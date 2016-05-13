package yeolsim.service.pay.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import yeolsim.service.domain.Pay;
import yeolsim.service.pay.PayDAO;
import yeolsim.service.pay.PayService;

@Service("PayServiceImpl")
public class PayServiceImpl implements PayService {
	
	@Autowired
	@Qualifier("PayDAOImpl")
	private PayDAO payDAO;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertPay(Pay pay) throws Exception {
		// TODO Auto-generated method stub
		payDAO.insertPay(pay);
	}

	@Override
	public Map<String, Object> getBuketList(int memberNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
