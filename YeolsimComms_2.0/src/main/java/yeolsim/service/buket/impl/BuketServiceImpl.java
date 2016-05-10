package yeolsim.service.buket.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import yeolsim.service.buket.BuketDAO;
import yeolsim.service.buket.BuketService;
import yeolsim.service.domain.Buket;

@Service("BuketServiceImpl")
public class BuketServiceImpl implements BuketService {

	@Autowired
	@Qualifier("BuketDAOImpl")
	private BuketDAO buketDAO;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertBuket(Buket buket) throws Exception {
		// TODO Auto-generated method stub
		buketDAO.insertBuket(buket);
	}

	@Override
	public Buket findBuket1(int totalBuy) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Buket> addBuketList(int memberNo) throws Exception {
		// TODO Auto-generated method stub
		return buketDAO.addBuketList(memberNo);
	}

	@Override
	public void updateBuket(int totalBuy) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
