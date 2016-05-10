package yeolsim.service.buket;

import java.util.List;

import yeolsim.service.domain.Buket;

public interface BuketDAO {

	//insert
	public void insertBuket(Buket buket)throws Exception;
	
	//select
	public Buket findBuket(int totalBuy)throws Exception;
	public List<Buket> addBuketList(int memberNo)throws Exception;
	
	//update
	public void updateBuket(int totalBuy)throws Exception;
	
	
}
