package yeolsim.service.buy.impl;

import java.util.List;
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
	private BuyDAO buyDAO;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insertBuy(Buy buy) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("1");
		return buyDAO.insertBuy(buy);
	}

	@Override
	public void delBuy(int tranNo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Buy getBuy(int buyNo) throws Exception {
		// TODO Auto-generated method stub
		return buyDAO.getdBuy(buyNo);
	}

	@Override
	public List<Buy> getBuyList(int memberNo) throws Exception {
		// TODO Auto-generated method stub
		return buyDAO.getBuyList(memberNo);
	}

	@Override
	public Map<String, Object> getAllProductList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTranNo(int buyNo) throws Exception {
		// TODO Auto-generated method stub
		buyDAO.updateTranNo(buyNo);
	}


}
