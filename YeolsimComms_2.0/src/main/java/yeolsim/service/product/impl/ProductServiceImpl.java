package yeolsim.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import yeolsim.service.domain.Product;
import yeolsim.service.member.MemberDAO;
import yeolsim.service.product.ProductDAO;
import yeolsim.service.product.ProductService;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {

	@Autowired
	@Qualifier("ProductDAOImpl")
	private ProductDAO productDAO;
	
	@Autowired
	@Qualifier("MemberDAOImpl")
	private MemberDAO memberDAO;

	
	public ProductServiceImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public void addProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		productDAO.insertProduct(product);
	}

	@Override
	public void updateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		productDAO.updateProduct(product);
	}

	@Override
	public void deleteProduct(Product product) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Product getProduct(int prodNo) throws Exception {
		// TODO Auto-generated method stub
		return productDAO.getProduct(prodNo);
	}

	@Override
	public Map<String, Object> getAllProductList() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Servie Impl : getAllproductList()");
		Map<String, Object> map=new HashMap<>();
		map.put("product", productDAO.getAllProductList());
		System.out.println("1");
		map.put("member", memberDAO.getUserList());
		System.out.println("2");
		System.out.println("gg :"+map);
		return map;
	}

	@Override
	public List<Product> getProductList(int memberNo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("2");
		return productDAO.getProductList(memberNo);
	}

	@Override
	public int starRating(Product product) throws Exception {
		// TODO Auto-generated method stub
		return productDAO.starRating(product);
	}

	@Override
	public List<Product> getBuyProductList(int memberNo) throws Exception {
		// TODO Auto-generated method stub
		return productDAO.getBuyProductList(memberNo);
	}


}
