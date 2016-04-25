package yeolsim.service.pay;

import java.util.Map;

import yeolsim.service.domain.Pay;

public interface PayDAO {

	
	public void insertPay(Pay pay)throws Exception;
	
	public Map<String, Object> addBuketList(int memberNo)throws Exception;
	
	
}
