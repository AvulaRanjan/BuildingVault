package miracle.com.arch.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import miracle.com.arch.bean.BottleBean;
import miracle.com.arch.bean.IteamBo;

public class IteamDAOImpl implements IIteamDAO
{
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		 this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
 /*
	public void insert(Employee employee){
 
		String sql = "INSERT INTO emp " +
				"(emp_id, emp_name, salary) VALUES (?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setInt(3, employee.getAge());
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			CommonDAO.ColseConnection(conn);
		}
	}
	*/
	
	@SuppressWarnings("unchecked")
	public List<IteamBo> getIteamList(){
		List<IteamBo> list = new ArrayList<IteamBo>();
		//List<BottleBean> bottleBeanlist = new ArrayList<BottleBean>();
        String sql = "select * from test.productiteam_tbl";
        try{
        	System.out.println("try postiteam_tbl "+ sql);
        	BottleBean bottleBeanlist = this.getInitialValue();
        	System.out.println("bottleBeanlist ::"+bottleBeanlist.getMaretialTypeList().size());
        	//System.out.println("bottleBeanlist ::"+bottleBeanlist.getTareTypeList().size());
        	
        	list = (List<IteamBo>) jdbcTemplate.query(sql,new RowMapper(){  
        	    public IteamBo mapRow(ResultSet rs, int rownumber) throws SQLException {  
        	    	IteamBo e=new IteamBo();  
        	        e.setIteamId(rs.getInt(1));  
        	        e.setIteamName(rs.getString(2));  
        	        System.out.println("Total postiteam_tbl "+ rs.getString(2));
        	        //e.setSalary(rs.getInt(3));  
        	        return e;  
        	    }  
        	    }); 
        	 
        System.out.println("Total postiteam_tbl "+ list.size());
        }catch(DataAccessException e){
            e.printStackTrace();
        }
       // return list;
		return list;
        
    }
	
	@SuppressWarnings("unchecked")
	public List<IteamBo> getSubProdList(int productId){
		List<IteamBo> list = new ArrayList<IteamBo>();
        String sql = "select * from test.subproductiteam_tbl where Iteam_id=?";
        List<IteamBo> subProducts = new ArrayList<IteamBo>();
        try{
        //	List<Map> rows = getJdbcTemplate().queryForList(sql);
        	
        	System.out.println("try postiteam_tbl "+ sql);        	
        /*	list = (List<IteamBo>) jdbcTemplate.queryForList(sql,new Object[] { productId }); */
        	 
        System.out.println("Total postiteam_tbl "+ list.size());
        }catch(DataAccessException e){
            e.printStackTrace();
        }
       // return list;
		return list;
        
    }
	
	/* jdbcTemplate.query(sql,new RowMapper(){})
	 * jdbcTemplate.queryForObject(sql,new Object[] { productId },new RowMapper(){}
	
	*/
	
	@SuppressWarnings("unchecked")
	public BottleBean getInitialValue(){
		
		List<BottleBean> list = new ArrayList<BottleBean>();
		BottleBean bean= new BottleBean();
        try{
        	String maretialQuery = "SELECT * FROM test.maretial_type_tbl;";
        	System.out.println("try postiteam_tbl "+ maretialQuery);        	
        	List<BottleBean> maretialTypeList = (List<BottleBean>) jdbcTemplate.query(maretialQuery,new RowMapper(){  
        	    public BottleBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
        	    	BottleBean e=new BottleBean();  
        	        e.setMaretialId(rs.getInt(1));  
        	        e.setMaretialName(rs.getString(2));  
        	        System.out.println("Total postiteam_tbl "+ rs.getString(2));
        	        //e.setSalary(rs.getInt(3));  
        	        return e;  
        	    }  
        	    });
        	bean.setMaretialTypeList(maretialTypeList);
        	String tareTypeQuery = "SELECT * FROM test.maretial_type_tbl;";
        	List<BottleBean> tareTypeList = (List<BottleBean>) jdbcTemplate.query(tareTypeQuery,new RowMapper(){  
        	    public BottleBean mapRow(ResultSet rs, int rownumber) throws SQLException {  
        	    	BottleBean e=new BottleBean();  
        	        e.setMaretialId(rs.getInt(1));  
        	        e.setMaretialName(rs.getString(2));  
        	        System.out.println("Total postiteam_tbl "+ rs.getString(2));
        	        //e.setSalary(rs.getInt(3));  
        	        return e;  
        	    }  
        	    }); 
        	 
        	bean.setMaretialTypeList(maretialTypeList);
        System.out.println("Total postiteam_tbl "+ list.size());
        }catch(DataAccessException e){
            e.printStackTrace();
        }
       // return list;
		return bean;
        
		
	}
	
}
