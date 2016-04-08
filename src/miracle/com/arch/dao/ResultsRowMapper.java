package miracle.com.arch.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ResultsRowMapper implements RowMapper {

	
	public Object mapRow(ResultSet rs,int line) throws SQLException
	{
		Blob blob = rs.getBlob(1);
		int length = (int)blob.length();

		byte[] bytes = blob.getBytes(1,length);

		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois;

		//ois = new ObjectInputStream(bais);
		
		//return ois.readObject();
		return null;
		//return null;
	
		
	}
	
	
	

}
