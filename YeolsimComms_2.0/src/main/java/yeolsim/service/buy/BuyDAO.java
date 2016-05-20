package yeolsim.service.buy;

import java.util.List;
import java.util.Map;

import yeolsim.service.domain.Buy;
import yeolsim.service.domain.Product;

public interface BuyDAO {

	//insert
	public int insertBuy(Buy buy)throws Exception;
	
	//select
	public Buy getdBuy(int buyNo)throws Exception;
	public List<Buy> getBuyList(int memberNo)throws Exception;
	public List<Product> getProductList()throws Exception;

	//delete
	public void delBuy(int buyNo)throws Exception;
	
	public void updateTranNo(int buyNo)throws Exception;
	
	
}
