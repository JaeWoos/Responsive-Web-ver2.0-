package yeolsim.service.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import yeolsim.service.domain.Member;
import yeolsim.service.member.MemberDAO;
import yeolsim.service.member.MemberService;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	@Qualifier("MemberDAOImpl")
	private MemberDAO memberDao;
	
	public void setMemberDao(MemberDAO memberDAO){
		this.memberDao=memberDAO;
	}
	
	public MemberServiceImpl() {
		System.out.println(this.getClass());
	}
	
	@Override
	public void insertMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		memberDao.insertMember(member);
	}

	@Override
	public Member loginMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member getMember(String memberId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member updateMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
