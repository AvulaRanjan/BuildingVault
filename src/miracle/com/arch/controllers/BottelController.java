package miracle.com.arch.controllers;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import miracle.com.arch.bean.BottleBean;
import miracle.com.arch.dao.ICreateBottleDAO;
import miracle.com.arch.service.CommonServiceBeanFactory;
import miracle.com.arch.util.Contants;

 
@Controller
public class BottelController {
	
	@RequestMapping(value="/fetchInitalData",method = RequestMethod.GET,headers="Accept=application/json")
	//public @ResponseBody String fetchInitalData() {
	public @ResponseBody String fetchInitalData(@ModelAttribute("bottleBean")
	BottleBean bottleBean,BindingResult result,HttpServletRequest request) {
		
		String s=request.getQueryString();
		Map<String, String> inputValues = prepareMapFromReqQueryString(s);
		String  action=getStringValueFromMap(inputValues,"selectedOption");		
		
		ICreateBottleDAO createBottleDAO = (ICreateBottleDAO) CommonServiceBeanFactory.getService(Contants.CREATE_BOTTLE_DAO);
		
		//selectedOption=newBottle
		if(action.equals("newbottleform")){
		bottleBean = createBottleDAO.getInitialBottleData();
		}
		else if(action.equals("samplelogoutform")){
			bottleBean = createBottleDAO.fetchInitalSampleLogOutData();
		}
		else if(action.equals("sampleloginform")){
			System.out.println("sampleloginform");
			bottleBean = createBottleDAO.fetchInitalSampleLogInData();
		}
		else if(action.equals("loginform")){
			System.out.println("loginform");
			bottleBean = createBottleDAO.fetchInitalLogInFormData();
		}
		
		else if(action.equals("sampleDestructionForm")){
			System.out.println("sampleDestructionForm");
			bottleBean = createBottleDAO.fetchInitalSampleDestructionFormData();
		}
		else if(action.equals("sampleConsumptionForm")){
			System.out.println("sampleConsumptionForm");
			bottleBean = createBottleDAO.fetchInitalSampleConsumptionData();
		}
		else if(action.equals("sampleTransferForm")){
			System.out.println("sampleTransferForm");
			bottleBean = createBottleDAO.fetchInitalSampleTransferData();
		}
		else if(action.equals("deaForm")){
			System.out.println("deaForm");
			bottleBean = createBottleDAO.fetchInitalDEAFormData();
		}
		bottleBean.setActionName(action);
		String bottleBeanResp = new Gson().toJson(bottleBean);		
		return bottleBeanResp;
		
	}
	
	@RequestMapping(value="/saveBottle",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody String save(@ModelAttribute("bottleBean")
	BottleBean bottleBean, BindingResult result,HttpServletRequest request,
    HttpSession session) {
		BottleBean resultBean = new BottleBean();
		//return getInputValueFromQueryString(request);
		String responseData ="";
		String bottleBeanValues="";
		String actionName = bottleBean.getActionName();
		ICreateBottleDAO createBottleDAO = (ICreateBottleDAO) CommonServiceBeanFactory.getService(Contants.CREATE_BOTTLE_DAO);
		if(actionName.equals("newbottleform")){		
			bottleBeanValues = createBottleDAO.saveBottleInfo(bottleBean);
			resultBean.setMessage(bottleBeanValues);
		}
		else if(actionName.equals("simpleformlogout")){
			bottleBeanValues = createBottleDAO.saveSimpleLogOutForm(bottleBean);
			resultBean.setMessage(bottleBeanValues);
			}
		else if(actionName.equals("sampleDestructionForm")){
			 bottleBeanValues = createBottleDAO.saveDestructionData(bottleBean);
			resultBean.setMessage(bottleBeanValues);
			
			}
		else if(actionName.equals("sampleConsumptionForm")){
			bottleBeanValues = createBottleDAO.saveConsumptionData(bottleBean);
			resultBean.setMessage(bottleBeanValues);
			
			}
		else if(actionName.equals("sampleTransferForm")){
			bottleBeanValues = createBottleDAO.saveTransferData(bottleBean);
			resultBean.setMessage(bottleBeanValues);
			
			}
		responseData = new Gson().toJson(resultBean);
	return responseData;
		
		
	}


		public BottleBean convertInputTOBean(Map<String, String> inputValues){
			BottleBean bean = new BottleBean();
			for(int i=0;i<inputValues.size();i++){			
				//String actionName=(String)inputValues.get("buttonActionName");	
				bean.setBottleNumber(getIntergerValueFromMap(inputValues,"battleName"));
				bean.setDescription(getStringValueFromMap(inputValues,"description"));
				bean.setSampleNotebookID(getStringValueFromMap(inputValues,"sampleID"));
				bean.setCode(getStringValueFromMap(inputValues,"code"));
				bean.setContent((String)(inputValues.get("content")));
				bean.setTare(getStringValueFromMap(inputValues,"tare"));
				bean.setComment(getStringValueFromMap(inputValues,"comment"));				
				bean.setMaretialId(getIntergerValueFromMap(inputValues,"maretialId"));
				bean.setTareId(getIntergerValueFromMap(inputValues,"tareId"));
				bean.setDeaRegistrationId(getIntergerValueFromMap(inputValues,"deaRegistrationId"));
				bean.setDeaScheduleId(getIntergerValueFromMap(inputValues,"deaScheduleId"));				
				bean.setOwnerId(getIntergerValueFromMap(inputValues,"ownerId"));
				bean.setDispositionId(getIntergerValueFromMap(inputValues,"dispositionId"));
				bean.setCheckoutRestrictionId(getIntergerValueFromMap(inputValues,"checkoutRestrictionId"));
				bean.setContentUnitesId(getIntergerValueFromMap(inputValues,"contentUnitesId"));
				bean.setStorageLocationId(getIntergerValueFromMap(inputValues,"storageLocationId"));
				bean.setCheckoutRestrictionId(getIntergerValueFromMap(inputValues,"checkoutRestrictionId"));
				
				bean.setCheckoutRestrictionId(getIntergerValueFromMap(inputValues,"checkoutRestrictionId"));
				bean.setCheckoutRestrictionId(getIntergerValueFromMap(inputValues,"checkoutRestrictionId"));
				bean.setCheckoutRestrictionId(getIntergerValueFromMap(inputValues,"checkoutRestrictionId"));
				bean.setCheckoutRestrictionId(getIntergerValueFromMap(inputValues,"checkoutRestrictionId"));
				bean.setCheckoutRestrictionId(getIntergerValueFromMap(inputValues,"checkoutRestrictionId"));
				bean.setCheckoutRestrictionId(getIntergerValueFromMap(inputValues,"checkoutRestrictionId"));
				
				String  inventory=getStringValueFromMap(inputValues,"inventory");
				if(inventory.equals("true"))
					bean.setInventory(1);
				else
					bean.setInventory(0);
			} 
			return bean;
		
		
		}
// This method 
 private Map<String, String> prepareMapFromReqQueryString(String s) {
	 Map<String, String> inputValues = new HashMap<String, String>();		
	 if(s !=null){
				String parm[]=s.split("&");
				for(int i=0;i<parm.length;i++){
					String paramValue=parm[i];
					String[] values= paramValue.split("=");				
					inputValues.put(values[0], values[1]);
				}			
			}
	return inputValues;
		}
private int getIntergerValueFromMap(Map<String, String> inputValues,String input){
	//int value;
	String value=(String)(inputValues.get(input));	
	if(null==value)
		 return 0;
	else
	return Integer.parseInt((String)(inputValues.get(input)));
	
}
private String getStringValueFromMap(Map<String, String> inputValues,String input){
	String value=(String)(inputValues.get(input));
	return (null==value ? "": value);
	
	
}


public String getInputValueFromQueryString(HttpServletRequest request) {/*
	@ModelAttribute("bottleBean")
	BottleBean bottleBean;
	System.out.println("saveBottle---> :: ");
	String responseData = null;
	String s=request.getQueryString();
	Map<String, String> inputValues = prepareMapFromReqQueryString(s);
	String  action=getStringValueFromMap(inputValues,"selectedOption");
	bottleBean= this.convertInputTOBean(inputValues);
	System.out.println("Save");

	ICreateBottleDAO createBottleDAO = (ICreateBottleDAO) CommonServiceBeanFactory.getService(Contants.CREATE_BOTTLE_DAO);
	String bottleBeanValues = createBottleDAO.saveBottleInfo(bottleBean);
	bottleBean.setMessage(bottleBeanValues);
	responseData = new Gson().toJson(bottleBean);

return responseData;
*/
return "";	
}

}