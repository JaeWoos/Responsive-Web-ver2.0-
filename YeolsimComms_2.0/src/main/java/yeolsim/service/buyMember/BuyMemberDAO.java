package yeolsim.service.buyMember;

import java.util.List;

import yeolsim.service.domain.BuyMember;
import yeolsim.service.domain.Member;

public interface BuyMemberDAO {

	//insert
	public void insertBuyMember(BuyMember buyMember) throws Exception ;
	

	public BuyMember getBuyMember(int buyNo) throws Exception;
	public List<Member> getUserList() throws Exception;


}
