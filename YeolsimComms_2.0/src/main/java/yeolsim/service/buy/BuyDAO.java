package yeolsim.service.buy;

import java.util.List;
import java.util.Map;

import yeolsim.service.domain.Buy;
import yeolsim.service.domain.Product;

public interface BuyDAO {

	//insert
	public void insertBuy(Buy buy)throws Exception;
	
	//select
	public Buy getdBuy(int totalBuy)throws Exception;
	public Map<String, Object> getBuy2(int buyNo)throws Exception;
	public Map<String, Object> getBuyList(int memberNo)throws Exception;
	public List<Product> getProductList()throws Exception;

	//delete
	public void delBuy(int buyNo)throws Exception;
	
	
	
}
