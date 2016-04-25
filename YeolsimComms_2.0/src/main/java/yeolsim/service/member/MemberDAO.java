package yeolsim.service.member;

import java.util.List;

import org.springframework.stereotype.Repository;

import yeolsim.service.domain.Member;


public interface MemberDAO {
	
	//insert
	public void insertMember(Member member)throws Exception;
	
	//update
	public void updateMember(Member Member)throws Exception;

	//select
	public Member getMember(String memberId)throws Exception;
	public Member getMember(int memberNo)throws Exception;
	
	public List<Member> getUserList() throws Exception;
	
}
