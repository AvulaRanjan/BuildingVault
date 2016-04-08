package miracle.com.arch.dao;

import miracle.com.arch.bean.BottleBean;


public interface ICreateBottleDAO 
{
	public BottleBean getInitialBottleData();	
	public String saveBottleInfo(BottleBean bottleBean);
	public BottleBean fetchInitalSampleLogOutData();
	public BottleBean fetchInitalLogInFormData();
	public BottleBean fetchInitalSampleLogInData();	
	public String saveSimpleLogOutForm(BottleBean bottleBean);
	public BottleBean fetchInitalSampleDestructionFormData();
	public BottleBean fetchInitalSampleConsumptionData();
	public BottleBean fetchInitalSampleTransferData();
	public BottleBean fetchInitalDEAFormData();
	public String saveDestructionData(BottleBean bottleBean);
	public String saveConsumptionData(BottleBean bottleBean);
	public String saveTransferData(BottleBean bottleBean);
	
	
}
