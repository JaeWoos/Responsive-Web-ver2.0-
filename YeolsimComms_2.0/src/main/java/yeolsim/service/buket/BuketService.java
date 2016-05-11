package yeolsim.service.buket;

import java.util.List;

import yeolsim.service.domain.Buket;

public interface BuketService {

	//insert
	public void insertBuket(Buket buket) throws Exception;
	
	//select
	public Buket findBuket1(int totalBuy) throws Exception;
	public List<Buket> addBuketList(int memberNo) throws Exception;
	
	//update
	public void updateBuket(int totalBuy) throws Exception;
	
	//delete
	public void deleteBuekt(int totalBuy) throws Exception;
}
