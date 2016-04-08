package miracle.com.arch.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class CommonServiceBeanFactory {
	
	public static Object getService(String beanName) {
		String loadContextFile ="empApplicationContext.xml";
		System.out.println("loadContextFile:::"+loadContextFile);
		ApplicationContext context = new ClassPathXmlApplicationContext(loadContextFile);
		Object objectbean = (Object) context.getBean(beanName);
		return objectbean;
		}
	}

	

