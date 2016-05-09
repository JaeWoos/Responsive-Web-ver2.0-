package yeolsim.service.member.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import yeolsim.service.domain.Member;
import yeolsim.service.member.MemberDAO;

@Repository("MemberDAOImpl")
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSeesion;
	
	public void setSqlSeesion(SqlSession sqlSeesion) {
		this.sqlSeesion = sqlSeesion;
	}
	
	@Override
	public void insertMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("insetMember . DAO :"+member);
		sqlSeesion.insert("MemberMapper.insertMember", member);
	}

	@Override
	public void updateMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		sqlSeesion.update("MemberMapper.updateMember", member);
	}

	@Override
	public Member getMember(String memberId) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("getMember :"+memberId);
		return sqlSeesion.selectOne("MemberMapper.getMember", memberId);
	}

	@Override
	public Member getMember(int memberNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getUserList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSeesion.selectList("MemberMapper.getAllMember");
	}

}
