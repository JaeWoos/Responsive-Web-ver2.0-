package yeolsim.service.buyMember.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import yeolsim.service.buyMember.BuyMemberDAO;
import yeolsim.service.domain.BuyMember;
import yeolsim.service.domain.Member;

@Repository("buyMemberDAOImpl")
public class buyMemberDAOImpl implements BuyMemberDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBuyMember(BuyMember buyMember) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("BuyMemberMapper.insertBuyMember", buyMember);
	}


	@Override
	public BuyMember getBuyMember(int buyNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("BuyMemberMapper.getBuyMember", buyNo);
	}

	@Override
	public List<Member> getUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
