import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import yeolsim.service.domain.Member;
import yeolsim.service.domain.Product;
import yeolsim.service.member.MemberService;
import yeolsim.service.product.ProductService;

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
	

	@Autowired
	@Qualifier("ProductServiceImpl")
	private ProductService productService;

	//@Test
	public void insertMember() throws Exception{
		Member member = new Member();
		member.setId("user04");
		member.setPassword("1234");
		member.setPhone("123123123");
		member.setAddr("서울시 강남구");
		member.setEmail("user01@nabve.com");
		member.setName("홍길동");
		member.setSex("남");
		System.out.println("junit 시작");
		memberService.insertMember(member);
	}
	
	//@Test
	public void getListProduct() throws Exception{

		System.out.println("junit 시작");
		List<Product> list=productService.getProductList(1000040);
		System.out.println(list);
	}
	
	@Test
	public void getProduct() throws Exception{

		System.out.println("junit 시작");
		Map<String, Object> map=productService.getAllProductList();
		
		System.out.println(map);
	}
	
	
}	








