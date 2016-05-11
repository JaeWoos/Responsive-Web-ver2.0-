package yeolsim.service.buket.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import yeolsim.service.buket.BuketDAO;
import yeolsim.service.domain.Buket;

@Repository("BuketDAOImpl")
public class BuketDAOImpl implements BuketDAO {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public void setSqlSeesion(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void insertBuket(Buket buket) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("insertBuket DAO : "+buket);
		sqlSession.insert("BuketMapper.insertBuket", buket);
	}

	@Override
	public Buket findBuket(int totalBuy) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("BuketMapper.getBuket", totalBuy);
	}

	@Override
	public List<Buket> addBuketList(int memberNo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("2");
		return sqlSession.selectList("BuketMapper.getBuketList", memberNo);
	}

	@Override
	public void updateBuket(int totalBuy) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBuket(int totalBuy) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("BuketMapper.deleteBuket", totalBuy);
	}
}
