package yeolsim.web.buy;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import yeolsim.service.buket.BuketService;
import yeolsim.service.buy.BuyService;
import yeolsim.service.buyMember.BuyMemberService;
import yeolsim.service.domain.Buket;
import yeolsim.service.domain.Buy;
import yeolsim.service.domain.BuyMember;
import yeolsim.service.domain.Member;
import yeolsim.service.domain.Pay;
import yeolsim.service.domain.Product;
import yeolsim.service.pay.PayService;
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
	
	@Autowired
	@Qualifier("buyMemberServiceImpl")
	private BuyMemberService buyMemberService;
	
	@Autowired
	@Qualifier("PayServiceImpl")
	private PayService payService;
	
	public BuyController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value="/viewProduct", method=RequestMethod.POST)
	public String viewProduct(@RequestParam("check") List<Object> totalBuy, Model model)throws Exception{

		System.out.println("/viewlistBuket Con : POST : " + totalBuy);

		Product prod=new Product();
		List<Product> prodList=new ArrayList<>();
		List<Buket> buketList=new ArrayList<>();
		
		for(int i=0; i<totalBuy.size(); i++){
			System.out.println("11:"+Integer.parseInt((String)totalBuy.get(i)));
			Buket buket= buketService.findBuket1(Integer.parseInt((String)totalBuy.get(i)));
			System.out.println("g"+buket);
			prod=productService.getProduct(buket.getProdNo());
			prodList.add(prod);
			buketList.add(buket);
			System.out.println(i+"::"+prodList);
		}
		model.addAttribute("prodList", prodList);
		model.addAttribute("buketList", buketList);
		model.addAttribute("totalBuy", totalBuy);
		
		return "forward:/buy/buyProduct.jsp";
	}
	
	@RequestMapping(value="/insertProduct", method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute BuyMember buyMember, @RequestParam("prodNo") List<Object> prodNo,
									@RequestParam("pay") String menu, @RequestParam("totalBuy") List<Object> totalBuy,
												HttpSession httpSession,	Model model )throws Exception{
		
		System.out.println("/getlistBuket Con : GET : " + buyMember);
		System.out.println("gg :"+prodNo);
		System.out.println("gg :"+menu);
		System.out.println("gg :"+totalBuy);
		
		Member member=(Member)(httpSession.getAttribute("member"));
		
		Buy buy=new Buy();
		Pay pay=new Pay();
		
		for(int i=0; i<prodNo.size(); i++){
			buy.setMemberNo(member.getMemberNo());
			buy.setProdNo(Integer.parseInt((String) prodNo.get(i)));
			buy.setTranNo(0);
			System.out.println("gggggg1");
			pay.setBuyNo(buyService.insertBuy(buy));
			pay.setPayMenu(menu);
			System.out.println("gggggg2");
			payService.insertPay(pay);
			System.out.println(buy);
			System.out.println("gggggg3");
		}
		for(int i=0; i<totalBuy.size(); i++){
			buketService.deleteBuekt(Integer.parseInt((String)totalBuy.get(i)));
		}
		
	return null;
	}


}













