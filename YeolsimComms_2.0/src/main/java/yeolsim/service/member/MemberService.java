package yeolsim.service.member;

import yeolsim.service.domain.Member;



public interface MemberService {
	
	public void insertMember(Member member) throws Exception;
	
	public Member loginMember(String memberId) throws Exception;
	
	public Member getMember(String memberId) throws Exception;
	
	public Member updateMember(Member member) throws Exception;
		
}