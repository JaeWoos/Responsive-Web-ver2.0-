package yeolsim.service.buket;

import java.util.Map;

import yeolsim.service.domain.Buket;

public interface BuketDAO {

	//insert
	public void insertBuket(Buket buket)throws Exception;
	
	//select
	public Buket getBuket1(int memberNo)throws Exception;
	public Map<String, Object> findBuket2(int totalBuy)throws Exception;
	public Map<String, Object> addBuketList(int memberNo)throws Exception;
	
	//update
	public void updateBuket(int totalBuy)throws Exception;
	
	
}
