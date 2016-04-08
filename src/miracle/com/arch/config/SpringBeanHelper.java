package miracle.com.arch.config;

import java.util.LinkedList;
import java.util.List;



import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;



/**
 * Helper class for accessing the Spring context object. This class loads up a
 * default application context configuration file and delegates requests for any
 * spring registered services to the context. By always using this class, the
 * context will always be initialized only once and from only one spot.
 * 
 * @author Ranjan
 */

public class SpringBeanHelper implements ApplicationContextAware {
	/**
	 * Logger instance.
	 */
	private static Logger logger = Logger.getLogger(SpringBeanHelper.class);

	/**
	 * Spring Application Contexts.
	 */
	private static List applicationContexts = new LinkedList();

	/**
	 * Root Spring Application Context.
	 */
	private static ApplicationContext rootContext;

	/**
	 * Flag indicating whether the current instance of the SpringUtils class is
	 * the current root context.
	 */
	private boolean isRootContext;

	/**
	 * Accessor method for the root application context.
	 * 
	 * @return current root application context
	 */
	public static ApplicationContext getRootContext() {
		return rootContext;
	}

	/**
	 * Accessor method for the list of application contexts.
	 * 
	 * @return list of currently applied application contexts
	 */
	public static List getApplicationContexts() {
		return applicationContexts;
	}

	/**
	 * Sets the application context.
	 * 
	 * @param applicationContext
	 *            applicationContext.
	 * @see org.springframework.context.ApplicationContextAware#
	 *      setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		if (isRootContext) {
			// manage the root application context
			if (rootContext == null) {
				rootContext = applicationContext;
			} else {
				String message = "Attempt to set root context more than once, "
						+ "only one root context allowed per application"
						+ "\nIf you are receiving this message when developing in Workshop, this is normal. "
						+ "Weblogic has tried hot deploy and while restarting"
						+ " set the root context more then once, this will cause this problem, "
						+ "please restart the weblogic container (you may have to restart more then once): "
						+ applicationContext.getDisplayName();

				logger.fatal(message);
				throw new RuntimeException(message);
			}
		} else {
			// manage child application context instances
			applicationContexts.add(applicationContext);

			if (rootContext != null) {
				if (applicationContext instanceof ConfigurableApplicationContext) {
					((ConfigurableApplicationContext) applicationContext)
							.setParent(rootContext);
					((ConfigurableApplicationContext) applicationContext)
							.refresh();
					logger.info("Set root context as parent of new context");
				} else {
					logger
							.warn("Received context but unable to cast to ConfigurableApplicationContext");
				}
			}
		}
	}

	/**
	 * Mutator method for the isRootContext flag.
	 * 
	 * @param isRoot
	 *            new value for the isRoot property
	 */
	public void setIsRootContext(boolean isRoot) {
		this.isRootContext = isRoot;
	}

	/**
	 * Utility method used to obtain a reference to the specified bean class.
	 * 
	 * @param beanName
	 *            name of bean to lookup in application context
	 * @return Object instance of the specified bean
	 */
	public static Object getBean(String beanName) {
		Object beanInstance = null;

		beanInstance = rootContext.getBean(beanName);

		if (beanInstance != null) {
			return beanInstance;
		}

		if (logger.isDebugEnabled() && (applicationContexts != null)) {
			logger.debug("Application Context size is: "
					+ applicationContexts.size());
		}

		for (int i = 0, n = applicationContexts.size(); i < n; i++) {
			ApplicationContext context = (ApplicationContext) applicationContexts
					.get(i);

			if (context instanceof ConfigurableApplicationContext) {
				if (((ConfigurableApplicationContext) context).getParent() == null) {
					((ConfigurableApplicationContext) context)
							.setParent(rootContext);
					((ConfigurableApplicationContext) context).refresh();
					logger.info("Set root context as parent of new context");
				}
			} else {
				logger
						.warn("Received context but unable to cast to ConfigurableApplicationContext");
			}

			beanInstance = context.getBean(beanName);

			if (beanInstance != null) {
				return beanInstance;
			}

		}

		// unable to locate bean
		String message = "Unable to load bean with name: " + beanName;
		logger.error(message);
		throw new RuntimeException(message);
	}

}
