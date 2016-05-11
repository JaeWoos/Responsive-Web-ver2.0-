package yeolsim.web.buy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import yeolsim.service.buket.BuketService;
import yeolsim.service.buy.BuyService;
import yeolsim.service.domain.Buket;
import yeolsim.service.domain.Buy;
import yeolsim.service.product.ProductService;

@Controller
@RequestMapping("/buy/*")
public class BuyController {

	@Autowired
	@Qualifier("BuyServiceImpl")
	private BuyService buyService;
	
	@Autowired
	@Qualifier("BuketServiceImpl")
	private BuketService buketService;
	
	@Autowired
	@Qualifier("ProductServiceImpl")
	private ProductService productService;
	
	public BuyController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@RequestMapping("/insertProduct")
	public String insertProduct(@RequestParam("check") List<Object> totalBuy, Model model )throws Exception{
		
		System.out.println("/getlistBuket Con : GET : " + totalBuy);
		
		Buy buy=new Buy();
		
		for(int i=0; i<totalBuy.size(); i++){
			System.out.println("11:"+Integer.parseInt((String)totalBuy.get(i)));
			Buket buket= buketService.findBuket1(Integer.parseInt((String)totalBuy.get(i)));
			System.out.println("g"+buket);
			buy.setProdNo(buket.getProdNo());
			buy.setMemberNo(buket.getMemberNo());
			buy.setTranNo(0);
			System.out.println("gg"+buy);
			buyService.insertBuy(buy);
			//buketService.deleteBuekt(buket.getTotalBuy());
		}
		
	return null;
	}

}
