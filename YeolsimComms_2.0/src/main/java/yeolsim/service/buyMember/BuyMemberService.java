package yeolsim.service.buyMember;

import java.util.Map;

import yeolsim.service.domain.BuyMember;
import yeolsim.service.domain.Member;

public interface BuyMemberService {

	//insert
	public void insertMember(BuyMember buyMember) throws Exception;
	
	public Member loginMember(Member member) throws Exception;
	
	public Member getMember(String memberId) throws Exception;
	
	public Map<String, Object> getMemberList() throws Exception;
	
	public Member updateMember(Member member) throws Exception;
	
	
}
