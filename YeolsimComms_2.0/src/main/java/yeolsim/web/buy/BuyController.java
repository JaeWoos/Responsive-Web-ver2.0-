package yeolsim.web.buy;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/listViewProduct", method=RequestMethod.POST)
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
		
		return "forward:/buy/listBuyProduct.jsp";
	}
	
	@RequestMapping(value="/viewProduct", method=RequestMethod.POST)
	public String viewProduct(@ModelAttribute Product product, @RequestParam("count") int count ,Model model)throws Exception{

		System.out.println("/viewProduct Con : POST : " + product);
		System.out.println(count);

		Product prod=productService.getProduct(product.getProdNo());
		
		model.addAttribute("product", prod);
		
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
			int buyNo=buyService.insertBuy(buy);
			System.out.println("gggggg1");
			
			pay.setBuyNo(buyNo);
			pay.setPayMenu(menu);
			System.out.println("gggggg2");
			payService.insertPay(pay);
			System.out.println(buy);
			System.out.println(pay);
			
			System.out.println("gggggg3");
			buyMember.setBuyNo(buyNo);
			buyMemberService.insertBuyMember(buyMember);
			
		}
		for(int i=0; i<totalBuy.size(); i++){
			System.out.println(totalBuy.get(i));
			buketService.deleteBuekt(Integer.parseInt((String)totalBuy.get(i)));
		}
		
		List<Buy> buyList=buyService.getBuyList(member.getMemberNo());
		
		model.addAttribute("buyList", buyList);
		
		return null;
	}
	
	@RequestMapping(value="/insertProduct2", method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute BuyMember buyMember, @RequestParam("prodNo") int prodNo,
										@RequestParam("pay") String menu, HttpSession httpSession, Model model)throws Exception{
		
		System.out.println("/getinsertProduct2 Con : Post" + buyMember);
		System.out.println("gg :"+prodNo);
		System.out.println("gg :"+menu);
		
		Member member=(Member)httpSession.getAttribute("member");
		
		Buy buy=new Buy();
		Pay pay=new Pay();
		
		buy.setMemberNo(member.getMemberNo());
		buy.setProdNo(prodNo);
		buy.setTranNo(0);
		
		int buyNo=buyService.insertBuy(buy);
		System.out.println("buy :"+buy);
		
		pay.setBuyNo(buyNo);
		pay.setPayMenu(menu);
		payService.insertPay(pay);
		
		buyMember.setBuyNo(buyNo);
		buyMemberService.insertBuyMember(buyMember);
		
		return null;
	}
	
	@RequestMapping(value="/getBuyList/{memberNo}", method=RequestMethod.GET)
	public String getBuyList(@PathVariable int memberNo, Model model)throws Exception{
		
		System.out.println("/getBuyList Con : GET : "+memberNo);
		
		List<Buy> buyList=buyService.getBuyList(memberNo);
		System.out.println("gg :"+buyList);
		
		model.addAttribute("buyList", buyList);
		
		return "forward:/buy/buyListProduct.jsp";
	}
	
	@RequestMapping(value="/getBuyProduct/{buyNo}", method=RequestMethod.GET)
	public String getBuyProduct(@PathVariable int buyNo, Model model)throws Exception{
		
		System.out.println("/getBuyList Con : GET : "+buyNo);
		
		Buy buy=(Buy)buyService.getBuy(buyNo);
		System.out.println("1 : "+buy);
		BuyMember buyMember=buyMemberService.getBuyMember(buyNo);
		System.out.println("2 :"+buyMember );
		Pay pay=payService.getPay(buyNo);
		System.out.println("3 :"+pay);
		
		model.addAttribute("buy", buy);
		model.addAttribute("buyMember", buyMember);
		model.addAttribute("pay", pay);
		
		
		return "forward:/buy/getBuy.jsp";
	}
	
	

}













