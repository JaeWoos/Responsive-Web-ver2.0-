package yeolsim.service.buy.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import yeolsim.service.buy.BuyDAO;
import yeolsim.service.domain.Buy;
import yeolsim.service.domain.Product;

@Repository("BuyDAOImpl")
public class BuyDAOImpl implements BuyDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBuy(Buy buy) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Buy getdBuy(int totalBuy) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getBuy2(int buyNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getBuyList(int memberNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delBuy(int buyNo) throws Exception {
		// TODO Auto-generated method stub

	}

}
