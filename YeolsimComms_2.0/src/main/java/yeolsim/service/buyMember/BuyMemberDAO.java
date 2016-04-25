package yeolsim.service.buyMember;

import java.util.List;

import yeolsim.service.domain.BuyMember;
import yeolsim.service.domain.Member;

public interface BuyMemberDAO {

	//insert
	public void insertBuyMember(BuyMember buyMember) throws Exception ;
	
	//select
	public Member getMember(String memberId) throws Exception;
	public Member getdMember(int memberNo) throws Exception;
	public List<Member> getUserList() throws Exception;

	//update
	public void updateMember(Member member) throws Exception; 
	

}
