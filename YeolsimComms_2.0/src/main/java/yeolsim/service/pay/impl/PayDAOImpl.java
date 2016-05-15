package yeolsim.service.pay.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import yeolsim.service.domain.Pay;
import yeolsim.service.pay.PayDAO;

@Repository("PayDAOImpl")
public class PayDAOImpl implements PayDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertPay(Pay pay) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("PayMapper.insertPay", pay);
		}

	@Override
	public Pay getPay(int buyNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("PayMapper.selectPay", buyNo);
	}

	



}
