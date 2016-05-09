package yeolsim.service.product.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import yeolsim.service.domain.Product;
import yeolsim.service.product.ProductDAO;

@Repository("ProductDAOImpl")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSeesion;

	
	public ProductDAOImpl() {
		System.out.println(this.getClass());
	}


	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSeesion = sqlSession;
	}

	
	@Override
	public void insertProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		sqlSeesion.insert("ProductMapper.insertProduct", product);
	}

	@Override
	public void updateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		sqlSeesion.update("ProductMapper.updateProduct", product);
	}

	@Override
	public void deleteProduct(Product product) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Product getProduct(int prodNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSeesion.selectOne("ProductMapper.getProduct", prodNo);
	}

	@Override
	public List<Product> getAllProductList() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("getAllproductList");
		return sqlSeesion.selectList("ProductMapper.getAllProductList");
	}

	@Override
	public List<Product> getProductList(int memberNo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("getProduct Dao"+memberNo);
		return sqlSeesion.selectList("ProductMapper.getProductList", memberNo);
	}


}
