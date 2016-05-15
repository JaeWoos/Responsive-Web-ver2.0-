package yeolsim.service.buy;

import java.util.List;
import java.util.Map;

import yeolsim.service.domain.Buy;

public interface BuyService {

	
	//insert
	public int insertBuy(Buy buy) throws Exception;
	
	//delete
	public void delBuy(int tranNo) throws Exception;
	
	//select
	public Buy getBuy(int buyNo) throws Exception;
	public List<Buy> getBuyList(int memberNo) throws Exception;
	Map<String, Object> getAllProductList() throws Exception;
	
	
	
}
