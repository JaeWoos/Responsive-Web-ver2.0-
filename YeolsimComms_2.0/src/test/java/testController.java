import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import yeolsim.service.domain.Member;
import yeolsim.service.member.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
								"classpath:config/context-common.xml",
								"classpath:config/context-transaction.xml",
								"classpath:config/context-mybatis.xml"
								 })
public class testController {

	@Autowired
	@Qualifier("MemberServiceImpl")
	private MemberService memberService;

	@Test
	public void insertMember() throws Exception{
		Member member = new Member();
		member.setId("user01");
		member.setPassword("1234");
		member.setPhone("123123123");
		member.setAddr("서울시 강남구");
		member.setEmail("user01@nabve.com");
		member.setName("홍길동");
		member.setSex("남");
		System.out.println("junit 시작");
		memberService.insertMember(member);
		
	}
	
}
