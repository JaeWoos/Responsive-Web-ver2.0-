package yeolsim.service.buyMember.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import yeolsim.service.buyMember.BuyMemberDAO;
import yeolsim.service.buyMember.BuyMemberService;
import yeolsim.service.domain.BuyMember;
import yeolsim.service.domain.Member;

@Service("buyMemberServiceImpl")
public class buyMemberServiceImpl implements BuyMemberService {
	
	@Autowired
	@Qualifier("buyMemberDAOImpl")
	private BuyMemberDAO buyMemberDAO;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertMember(BuyMember buyMember) throws Exception {
		// TODO Auto-generated method stub
		buyMemberDAO.insertBuyMember(buyMember);
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
	public Map<String, Object> getMemberList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member updateMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
