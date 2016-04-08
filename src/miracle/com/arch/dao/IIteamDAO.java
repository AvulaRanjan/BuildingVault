package miracle.com.arch.dao;

import java.util.List;

import miracle.com.arch.bean.IteamBo;


public interface IIteamDAO 
{
	public List<IteamBo> getIteamList();	
	public List<IteamBo> getSubProdList(int productId);
	
	
}
