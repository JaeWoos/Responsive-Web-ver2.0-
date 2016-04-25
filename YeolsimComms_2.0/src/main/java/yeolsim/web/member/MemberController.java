package yeolsim.web.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
}
