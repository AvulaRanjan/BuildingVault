package miracle.com.arch.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import miracle.com.arch.bean.BottleBean;
import miracle.com.arch.util.Contants;

public class CreateBottleDAOImpl implements ICreateBottleDAO
{
	
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) {		
		 this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public BottleBean getInitialBottleData(){
		BottleBean bean= new BottleBean();		
        try{
        	getMeretialList(bean);        	
        	getTareTypeList(bean);        	
        	getDEARegistrationList(bean);
        	getDEAScheduleList(bean);
        	getOwnersList(bean);        
        	getDispositionList(bean);        	
        	getCheckoutRestrictionList(bean);        	
        	getContentUnitesList(bean);        	
        	getStorageLocationList(bean);        	
        }catch(DataAccessException e){
            e.printStackTrace();
        }
       // return list;
		return bean;
        
		
	}

	@SuppressWarnings("unchecked")
	public void getStorageLocationList(BottleBean bean) {
		List<BottleBean> storageLocationList = (List<BottleBean>) jdbcTemplate.query(Contants.STORE_LOCATION_QUERY,new RowMapper(){  
		    public BottleBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	BottleBean e=new BottleBean();  
		        e.setStorageLocationId(rs.getInt(1));  
		        e.setStorageLocationName(rs.getString(2));  
		        return e;  
		    }  
		    });        	 
		bean.setStorageLocationList(storageLocationList);
	}

	@SuppressWarnings("unchecked")
	public void getContentUnitesList(BottleBean bean) {
		List<BottleBean> contentUnitesList = (List<BottleBean>) jdbcTemplate.query(Contants.CONTENT_UNITES_QUERY,new RowMapper(){  
		    public BottleBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	BottleBean e=new BottleBean();  
		        e.setContentUnitesId(rs.getInt(1));  
		        e.setContentUnitesName(rs.getString(2));  
		        return e;  
		    }  
		    }); 
		   	bean.setContentUnitesList(contentUnitesList);
	}

	@SuppressWarnings("unchecked")
	public void getCheckoutRestrictionList(BottleBean bean) {
		List<BottleBean> checkoutRestrictionList = (List<BottleBean>) jdbcTemplate.query(Contants.CHECKOUT_REG_QUERY,new RowMapper(){  
		    public BottleBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	BottleBean e=new BottleBean();  
		        e.setCheckoutRestrictionId(rs.getInt(1));  
		        e.setCheckoutRestrictionName(rs.getString(2));  
		        return e;  
		    }  
		    });         	 
		bean.setCheckoutRestrictionList(checkoutRestrictionList);
	}

	@SuppressWarnings("unchecked")
	public void getDispositionList(BottleBean bean) {
		List<BottleBean> dispositionList = (List<BottleBean>) jdbcTemplate.query(Contants.TARE_QUERY,new RowMapper(){  
		    public BottleBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	BottleBean e=new BottleBean();  
		        e.setDispositionId(rs.getInt(1));  
		        e.setDispositionName(rs.getString(2));  
		        return e;  
		    }  
		    });         	 
		bean.setDispositionList(dispositionList);
	}
	@SuppressWarnings("unchecked")
	public void getOwnersList(BottleBean bean) {
		List<BottleBean> ownersList = (List<BottleBean>) jdbcTemplate.query(Contants.OWNER_QUERY,new RowMapper(){  
		    public BottleBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	BottleBean e=new BottleBean();  
		        e.setOwnerId(rs.getInt(1));  
		        e.setOwnerName(rs.getString(2));  
		        
		        return e;  
		    }  
		    }); 		 
		bean.setOwnersList(ownersList);
	}

	@SuppressWarnings("unchecked")
	public void getDEAScheduleList(BottleBean bean) {
		List<BottleBean> deaScheduleList = (List<BottleBean>) jdbcTemplate.query(Contants.DEA_SCHEDULE_QUERY,new RowMapper(){  
		    public BottleBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	BottleBean e=new BottleBean();  
		        e.setDeaScheduleId(rs.getInt(1));  
		        e.setDeaScheduleName(rs.getString(2));  
		        
		        return e;  
		    }  
		    }); 
		 
		bean.setDeaScheduleList(deaScheduleList);
	}
	@SuppressWarnings("unchecked")
	public void getDEARegistrationList(BottleBean bean) {
		List<BottleBean> deaRegistrationList = (List<BottleBean>) jdbcTemplate.query(Contants.REA_REGISTRATION_QUERY,new RowMapper(){  
		    public BottleBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	BottleBean e=new BottleBean();  
		        e.setDeaRegistrationId(rs.getInt(1));  
		        e.setDeaRegistrationName(rs.getString(2));  
		        return e;  
		    }  
		    }); 
		 
		bean.setDeaRegistrationList(deaRegistrationList);
	}

	@SuppressWarnings("unchecked")
	private void getTareTypeList(BottleBean bean) {
		List<BottleBean> tareTypeList = (List<BottleBean>) jdbcTemplate.query(Contants.TARE_QUERY,new RowMapper(){  
		    public BottleBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	BottleBean e=new BottleBean();  
		        e.setTareId(rs.getInt(1));  
		        e.setTareName(rs.getString(2));  
		        return e;  
		    }  
		    }); 
		 
		bean.setTareTypeList(tareTypeList);
	}

	@SuppressWarnings("unchecked")
	private void  getMeretialList(BottleBean bean) {
		String maretialQuery = Contants.MARETIAL_QUERY;
		System.out.println("try postiteam_tbl "+ maretialQuery);        	
		List<BottleBean> maretialTypeList = (List<BottleBean>) jdbcTemplate.query(Contants.MARETIAL_QUERY,new RowMapper(){  
		    public BottleBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	BottleBean e=new BottleBean();  
		        e.setMaretialId(rs.getInt(1));  
		        e.setMaretialName(rs.getString(2));  
		        return e;  
		    }  
		    });
		bean.setMaretialTypeList(maretialTypeList);
		
	}

	 
	public String saveBottleInfo(BottleBean bottleBean) {
		System.out.println("bottleBean....DAO----Save");
		String message = "";
		BottleBean alreadyExistedBean= checkButtleIsExits(bottleBean);
		int number= alreadyExistedBean.getBottleNumber();
		if(number !=0)
			message=Contants.BOTTLE_ALREADY_EXISTED_MSG;
		else{
			
			try{
				int i =jdbcTemplate.update(Contants.INSERT_BOTTLE_QUERY,new Object[]{
				bottleBean.getBottleNumber(),
				bottleBean.getDescription(),
				bottleBean.getSampleNotebookID(),
				bottleBean.getCode(),
				bottleBean.getMaretialId(),
				bottleBean.getTareId(),
				bottleBean.getDeaRegistrationId(),
				bottleBean.getDeaScheduleId(),
				bottleBean.getInventory(),
				bottleBean.getOwnerId(),
				bottleBean.getDispositionId(),
				bottleBean.getContentUnitesId(),
				bottleBean.getStorageLocationId(),
				bottleBean.getComment(),
				bottleBean.getTransactionDate(),
				bottleBean.getCustomerNbRef(),
				bottleBean.getCustomerEmpNo(),
				bottleBean.getCssEmpNo(),
				bottleBean.getGrossAmount(),
				bottleBean.getTransactionLogRef(),
				bottleBean.getCheckoutRestrictionId()				
					});
				if(i==1)
					message=Contants.SAVED_SUCCESSFULLY_MSG;
				else
					message=Contants.BOTTLE_FAIL_DB_ERROR;
				}			
	
				catch(Exception e){
					message=Contants.BOTTLE_CREATE_FAIL;
				}
		}
		return message;
		
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private BottleBean checkButtleIsExits(BottleBean bottleBean) {		
			BottleBean bottleBeanValues = (BottleBean)jdbcTemplate.queryForObject
					(Contants.CHCK_BOTLE_EXIST_QUERY,new Object[] { bottleBean.getBottleNumber() }, 
							new BeanPropertyRowMapper(BottleBean.class));		
		
		return bottleBeanValues;
		
	}


	 
	public BottleBean fetchInitalSampleLogOutData() {
	
		BottleBean bean= new BottleBean();
        try{
        	getBottleNumberList(bean);        	
        		
        }catch(DataAccessException e){
            e.printStackTrace();
        }
       // return list;
		return bean;
	}

	@SuppressWarnings("unchecked")
	public void getBottleNumberList(BottleBean bean) {
		List<BottleBean> simpleFormList = (List<BottleBean>) jdbcTemplate.query(Contants.SELECT_BOTLE_LIST_QUERY,new RowMapper(){  
		    public BottleBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	BottleBean bean=new BottleBean();  
		        bean.setBottleNumber(rs.getInt("bottle_number"));
		        bean.setGrossAmount(rs.getString("gross_amount"));
		        bean.setTransactionDate(rs.getString("transaction_date"));
		        bean.setCustomerEmpNo(rs.getString("customer_emp_no"));
		        bean.setCustomerNbRef(rs.getString("customer_nb_ref"));
		        bean.setTransactionLogRef(rs.getString("transaction_log_ref"));
		        bean.setCssEmpNo(rs.getString("css_emp_no"));
		        return bean;
		    }  
		    }); 
		 
		bean.setSimpleFormList(simpleFormList);
	}

	 
	public BottleBean fetchInitalLogInFormData() {
		// TODO Auto-generated method stub
		return null;
	}

	public BottleBean fetchInitalSampleLogInData() {
	
		BottleBean bean= new BottleBean();
        try{
        	getBottleNumberList(bean);        	
        		
        }catch(DataAccessException e){
            e.printStackTrace();
        }
       // return list;
		return bean;
	}

	public String saveSimpleLogOutForm(BottleBean bottleBean) {
		System.out.println("saveSimpleLogOutForm....DAO----Save");
		String message = "";
		BottleBean alreadyExistedBean= checkButtleIsExits(bottleBean);
		int number= alreadyExistedBean.getBottleNumber();
		if(number !=0)
			message=Contants.BOTTLE_ALREADY_EXISTED_MSG;
		else{			
			try{
				int i =jdbcTemplate.update(Contants.INSERT_BOTTLE_QUERY,new Object[]{
				bottleBean.getBottleNumber(),
				bottleBean.getComment(),
				bottleBean.getTransactionDate(),				
				bottleBean.getCustomerEmpNo(),
				bottleBean.getCssEmpNo(),
				bottleBean.getGrossAmount(),
				bottleBean.getTransactionLogRef()							
				});
				if(i==1)
					message=Contants.SAVED_SUCCESSFULLY_MSG;
				else
					message=Contants.BOTTLE_FAIL_DB_ERROR;
				}
				catch(Exception e){
					message=Contants.BOTTLE_CREATE_FAIL;
				}
		}
		return message;	
	}

	 
	public BottleBean fetchInitalSampleDestructionFormData() {
		BottleBean bean= new BottleBean();
        try{
        	getBottleNumberList(bean);     	
        		
        }catch(DataAccessException e){
            e.printStackTrace();
        }
       // return list;
		return bean;
	}

	 
	public BottleBean fetchInitalSampleConsumptionData() {
		BottleBean bean= new BottleBean();
        try{
        	getBottleNumberList(bean);        	
        		
        }catch(DataAccessException e){
            e.printStackTrace();
        }
       // return list;
		return bean;
	}

	 
	public BottleBean fetchInitalSampleTransferData() {
		BottleBean bean= new BottleBean();
        try{
        	getBottleNumberList(bean);        	
        		
        }catch(DataAccessException e){
            e.printStackTrace();
        }
       // return list;
		return bean;
	}

	 
	public BottleBean fetchInitalDEAFormData() {
		BottleBean bean= new BottleBean();
        try{
        	getBottleNumberList(bean);        	
        		
        }catch(DataAccessException e){
            e.printStackTrace();
        }
       // return list;
		return bean;
	}

	 
	public String saveDestructionData(BottleBean bottleBean) {
		System.out.println("saveDestructionData....DAO----Save");
		String message=Contants.SAVED_SUCCESSFULLY_MSG;
		return message;
	}

	 
	public String saveConsumptionData(BottleBean bottleBean) {
		System.out.println("saveConsumptionData....DAO----Save");
		String message=Contants.SAVED_SUCCESSFULLY_MSG;
		return message;
	}

	 
	public String saveTransferData(BottleBean bottleBean) {
		System.out.println("saveTransferData....DAO----Save");
		String message=Contants.SAVED_SUCCESSFULLY_MSG;
		return message;
	}
	
}
