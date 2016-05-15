package yeolsim.service.buyMember;

import java.util.Map;

import yeolsim.service.domain.BuyMember;
import yeolsim.service.domain.Member;

public interface BuyMemberService {

	//insert
	public void insertBuyMember(BuyMember buyMember) throws Exception;
	
	
	public BuyMember getBuyMember(int buyNo) throws Exception;
	
	
}
