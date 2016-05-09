package yeolsim.web.buy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yeolsim.service.buy.BuyService;
import yeolsim.service.buy.impl.BuyServiceImpl;

@Controller
@RequestMapping("/buy/*")
public class BuyController {

	@Autowired
	@Qualifier("BuyServiceImpl")
	private BuyService buyService=new BuyServiceImpl();
	
	public BuyController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}

}
