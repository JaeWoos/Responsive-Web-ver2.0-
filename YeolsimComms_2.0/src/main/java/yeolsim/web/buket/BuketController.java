package yeolsim.web.buket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yeolsim.service.buket.BuketService;
import yeolsim.service.domain.Buket;
import yeolsim.service.product.ProductService;

@Controller
@RequestMapping("/buket/*")
public class BuketController {

	@Autowired
	@Qualifier("BuketServiceImpl")
	private BuketService buketService;
	
	@Autowired
	@Qualifier("ProductServiceImpl")
	private ProductService productService;
	
	public BuketController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}

	@RequestMapping(value="insertBuket", method=RequestMethod.POST)	
	public void insertBuket(@RequestBody Buket buket, Model model)throws Exception{
		
		System.out.println("/inserBuket Con :POST" + buket);
		System.out.println(buket);
		
		buketService.insertBuket(buket);
		
		model.addAttribute("check", true);
		
	}
	
	@RequestMapping(value="getListBuket/{memberNo}", method=RequestMethod.GET)
	public String getListBuket(@PathVariable int memberNo , Model model)throws Exception{
		
		System.out.println("/getlistBuket Con : GET : " + memberNo);
		
		List<Buket> buketList=buketService.addBuketList(memberNo);
		System.out.println(buketList);
		
		model.addAttribute("buketList", buketList);
		
		return "forward:/buket/buketList.jsp"; 
	}

}





