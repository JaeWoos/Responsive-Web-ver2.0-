package yeolsim.web.member;

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
import yeolsim.service.member.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	@Qualifier("MemberServiceImpl")
	private MemberService memberService;
	
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
	
	@RequestMapping(value="check", method=RequestMethod.POST)	
	public void checkDuplicate(@RequestBody String id, Model model)throws Exception{
		String memberId=id.split("=")[1];
		System.out.println("/check Con :POST" +memberId);
		Member dbMember=memberService.getMember(memberId);
		if(dbMember==null ){
			model.addAttribute("check", true);
			System.out.println("1");
		}else{
			System.out.println("2");
			model.addAttribute("check", false);
		}
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)	
	public String loginUser(@ModelAttribute("Member") Member member, HttpSession httpSession)throws Exception{
		
		System.out.println("/loginUser Con :POST" + member.getId());
		System.out.println(member);
		Member dbMember=memberService.loginMember(member.getId());
		
		if(member.getPassword().equals(dbMember.getPassword())){
			httpSession.setAttribute("member", dbMember);
		}
		
		return "redirect:/loginMain.jsp";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)	
	public String logoutUser(HttpSession httpSession)throws Exception{
		
		System.out.println("/logoutUser Con :GET" );
		httpSession.invalidate();
		return "redirect:/index.jsp";
	}
	
}





