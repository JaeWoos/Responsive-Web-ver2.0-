package yeolsim.web.product;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import yeolsim.service.domain.Member;
import yeolsim.service.domain.Product;
import yeolsim.service.product.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	@Qualifier("ProductServiceImpl")
	private ProductService productService;
	
	public ProductController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value="start", method=RequestMethod.GET)
	public String start(Model model) throws Exception{
		
		System.out.println("/start Con : get : ");
		Map<String, Object> list = productService.getAllProductList();
		
		List<Product> randomList=new ArrayList<Product>();
		Random ran=new Random();
		int size=((List<Product>)list.get("product")).size();
		for(int i=0; i<3; i++){
			int temp=ran.nextInt(size);
			randomList.add(((List<Product>)list.get("product")).get(temp));
		}
		
		
		model.addAttribute("product", list.get("product"));
		model.addAttribute("allMember", list.get("member"));
		model.addAttribute("random", randomList);
		
		return "forward:/index2.jsp";
		
	}
	
	@RequestMapping(value="myMenu")
	public String myMenu(HttpSession session, Model model) throws Exception{
		
		System.out.println("/meMenu Con : Post : ");
		Member member =(Member)session.getAttribute("member");
		
		List<Product> list = productService.getProductList(member.getMemberNo());
		
		model.addAttribute("product", list);
		
		return "forward:/myMenu.jsp";
	}
	
	@RequestMapping(value="insertProduct", method=RequestMethod.GET)
	public String insertProduct(HttpSession session) throws Exception{
		
		System.out.println("/insertProduct Con : GET : ");
		
		return "forward:/product/insertProduct.jsp";
	}
	
	@RequestMapping(value="insertProduct", method=RequestMethod.POST)
	public String insertProduct(Product product, @RequestParam("file") MultipartFile file,
										HttpSession session, Model model) throws Exception{
		
		System.out.println("/insert Con : Post : "+file);
		Member member =(Member)session.getAttribute("member");
		String temp=file.getOriginalFilename();
		String type=temp.substring(temp.lastIndexOf("."));
		String name=UUID.randomUUID().toString().replaceAll("-", "")+type;

		String path=session.getServletContext().getRealPath("/")+"resources"+"\\"+"img"+"\\";
				
		System.out.println("gg"+path);
		
		File dir=new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		file.transferTo(new File(path + name));
		
		product.setMemberNo(member.getMemberNo());
		product.setPic(name);
		System.out.println(product);
		productService.addProduct(product);
		
		List<Product> list = productService.getProductList(member.getMemberNo());
		
		model.addAttribute("product", list);
		
		return "forward:/myMenu.jsp";
	}
	
	@RequestMapping(value="getProduct/{prodNo}", method=RequestMethod.GET)
	public String getProduct(@PathVariable int prodNo, HttpSession session, Model model) throws Exception{
		
		System.out.println("/getProduct Con : GET : "+prodNo);
		Product product = productService.getProduct(prodNo);
			
				model.addAttribute("product", product);
				return "forward:/product/getProduct.jsp";
	}
	
	@RequestMapping(value="updateProduct", method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute Product product, HttpSession session, Model model) throws Exception{
		
		System.out.println("/updateProduct Con : POST : "+product);
		productService.updateProduct(product);

		return "forward:/product/myMenu";
	}
	
	@RequestMapping(value="updateProduct/{prodNo}", method=RequestMethod.GET)
	public String updateProduct(@PathVariable int prodNo, HttpSession session, Model model) throws Exception{
		
		System.out.println("/updateProduct Con : GET : "+prodNo);
		Product product = productService.getProduct(prodNo);

		model.addAttribute("product", product);
		
		return "forward:/product/updateProduct.jsp";
	}
	
	
	@RequestMapping(value="starCheck", method=RequestMethod.POST)
	public void starCheck(@RequestBody String temp)throws Exception{
		System.out.println("/starCheck CON : POST : "+temp);
		
		String list[]=temp.split("=");
		String parseList[]=list[1].split("&");
		float star=Float.parseFloat(parseList[0]);
		int prodNo=Integer.parseInt(list[2]);
		
		System.out.println("gggg :"+star);
		System.out.println("gggg : "+prodNo);
	}
	
	
}









