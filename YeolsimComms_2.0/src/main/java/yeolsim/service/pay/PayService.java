package yeolsim.service.pay;

import java.util.Map;

import yeolsim.service.domain.Pay;

public interface PayService {

	public void insertPay(Pay pay) throws Exception;
	
	public Map<String,Object> getBuketList(int memberNo) throws Exception;
	
	
}
