package yeolsim.service.buy.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import yeolsim.service.buy.BuyDAO;
import yeolsim.service.buy.BuyService;
import yeolsim.service.domain.Buy;

@Service("BuyServiceImpl")
public class BuyServiceImpl implements BuyService {
	
	@Autowired
	@Qualifier("BuyDAOImpl")
	private BuyDAO buyDAO=new BuyDAOImpl();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBuy(Buy buy) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delBuy(int tranNo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Buy getBuy(int totalBuy) throws Exception {
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
	public Map<String, Object> getAllProductList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
