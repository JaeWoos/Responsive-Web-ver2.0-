package yeolsim.web.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yeolsim.service.domain.Member;
import yeolsim.service.domain.Product;
import yeolsim.service.member.MemberService;
import yeolsim.service.product.ProductService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	@Qualifier("MemberServiceImpl")
	private MemberService memberService;
	
	@Autowired
	@Qualifier("ProductServiceImpl")
	private ProductService productService;
	
	public MemberController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}

	@RequestMapping(value="insertMember", method=RequestMethod.POST)	
	public String inserUser(@ModelAttribute("Member") Member member)throws Exception{
		
		System.out.println("/inserUser Con :POST" + member.getId());
		System.out.println(member);
		memberService.insertMember(member);
		
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value="insertMember", method=RequestMethod.GET)	
	public String inserUser()throws Exception{
		
		System.out.println("/inserUser Con :GET");
		
		return "redirect:/member/member.jsp";
	}
	
	
	@RequestMapping(value="login", method=RequestMethod.POST)	
	public String loginUser(@ModelAttribute("Member") Member member, Model model,
																HttpSession httpSession)throws Exception{
		
		System.out.println("/loginUser Con :POST" + member.getId());
		System.out.println(member);

		Member dbMember=memberService.loginMember(member.getId());
		Map<String, Object> prodList=productService.getAllProductList();
		System.out.println(prodList);
		if(dbMember!=null && member.getPassword().equals(dbMember.getPassword())){
			httpSession.setAttribute("member", dbMember);
			
			List<Product> randomList=new ArrayList<Product>();
			Random ran=new Random();
			int size=((List<Product>)prodList.get("product")).size();
			for(int i=0; i<3; i++){
				int temp=ran.nextInt(size);
				randomList.add(((List<Product>)prodList.get("product")).get(temp));
				
				model.addAttribute("product", prodList.get("product"));
				model.addAttribute("allMember", prodList.get("member"));
				model.addAttribute("random", randomList);
			}
			return "forward:/loginMain.jsp";
			
		}else{
			List<Product> randomList=new ArrayList<Product>();
			Random ran=new Random();
			int size=((List<Product>)prodList.get("product")).size();
			for(int i=0; i<3; i++){
				int temp=ran.nextInt(size);
				randomList.add(((List<Product>)prodList.get("product")).get(temp));
				
				model.addAttribute("product", prodList.get("product"));
				model.addAttribute("allMember", prodList.get("member"));
				model.addAttribute("random", randomList);
				model.addAttribute("user", false);
			}
			return "forward:/index2.jsp";
			
		}
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)	
	public String loginUser(HttpSession httpSession, Model model)throws Exception{
		
		System.out.println("/loginUser Con :GET" );
	
		Map<String, Object> prodList=productService.getAllProductList();
		System.out.println(prodList);
		
		List<Product> randomList=new ArrayList<Product>();
		Random ran=new Random();
		int size=((List<Product>)prodList.get("product")).size();
		for(int i=0; i<3; i++){
			int temp=ran.nextInt(size);
			randomList.add(((List<Product>)prodList.get("product")).get(temp));
		}
		
		httpSession.getAttribute("member");
		
		model.addAttribute("product", prodList.get("product"));
		model.addAttribute("allMember", prodList.get("member"));
		model.addAttribute("random", randomList);
		
		return "forward:/loginMain.jsp";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)	
	public String logoutUser(HttpSession httpSession)throws Exception{
		
		System.out.println("/logoutUser Con :GET" );
		httpSession.invalidate();
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value="updateMember", method=RequestMethod.GET)	
	public String updateUser(HttpSession httpSession)throws Exception{
		
		System.out.println("/updateUser Con :GET" );
		return "forward:/member/UpdateMember.jsp";
	}
	
	@RequestMapping(value="updateMember", method=RequestMethod.POST)	
	public String updateUser(Member member, HttpSession httpSession, Model model)throws Exception{
		
		System.out.println("/updateUser Con :POST" );
		Member mem=(Member)httpSession.getAttribute("member");
		member.setMemberNo(mem.getMemberNo());
		System.out.println(member);
		memberService.updateMember(member);

		return "forward:/member/login";
	}
	
	@RequestMapping(value="check", method=RequestMethod.POST)	
	public void checkDuplicate(@RequestBody String id, Model model)throws Exception{
		String memberId=id.split("=")[1];
		System.out.println("/check Con :POST" +memberId);
		Member dbMember=memberService.getMember(memberId);
		if(dbMember==null ){
			model.addAttribute("check", true);
		}else{
			model.addAttribute("check", false);
		}
	}
	
	@RequestMapping(value="passwordCheck", method=RequestMethod.POST)	
	public void checkDuplicate(@RequestBody String password, HttpSession httpSession,
								Model model)throws Exception{
		
		String temp[]=password.split("=");
		System.out.println("/passwordCheck Con :POST : " +temp[1]);
		Member member=(Member)httpSession.getAttribute("member");
		System.out.println(member);
		if(member.getPassword().equals(temp[1]) ){
			System.out.println("1");
			model.addAttribute("check", true);
		}else{
			System.out.println("2");
			model.addAttribute("check", false);
		}
	}
}





