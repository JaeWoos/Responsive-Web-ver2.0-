package yeolsim.service.buy;

import java.util.Map;

import yeolsim.service.domain.Buy;

public interface BuyService {

	
	//insert
	public void insertBuy(Buy buy) throws Exception;
	
	//delete
	public void delBuy(int tranNo) throws Exception;
	
	//select
	public Buy getBuy(int totalBuy) throws Exception;
	public Map<String,Object> getBuy2(int buyNo) throws Exception;
	public Map<String,Object> getBuyList(int memberNo) throws Exception;
	Map<String, Object> getAllProductList() throws Exception;
	
	
	
}
