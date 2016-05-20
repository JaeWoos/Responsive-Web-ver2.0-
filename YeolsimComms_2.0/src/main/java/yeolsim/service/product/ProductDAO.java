/**
 * 
 */
package yeolsim.service.product;

import java.util.List;
import java.util.Map;

import yeolsim.service.domain.Product;


public interface ProductDAO {

	//insert
	public void insertProduct(Product product)throws Exception;
	
	//update
	public void updateProduct(Product product)throws Exception;
	
	//delete
	public void deleteProduct(Product product)throws Exception;
	
	//select
	public Product getProduct(int probNo)throws Exception;
	public List<Product> getProductList(int memberNo)throws Exception;		
	public List<Product> getAllProductList()throws Exception;
	
	public int starRating(Product product) throws Exception;
	public List<Product> getBuyProductList(int memberNo) throws Exception;
}




