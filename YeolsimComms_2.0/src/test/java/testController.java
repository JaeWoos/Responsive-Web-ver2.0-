import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import yeolsim.service.buket.BuketService;
import yeolsim.service.buy.BuyService;
import yeolsim.service.buyMember.BuyMemberService;
import yeolsim.service.domain.Buket;
import yeolsim.service.domain.Buy;
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
	
	@Autowired
	@Qualifier("BuketServiceImpl")
	private BuketService buketService;
	
	@Autowired
	@Qualifier("BuyServiceImpl")
	private BuyService buyService;
	
	@Autowired
	@Qualifier("buyMemberServiceImpl")
	private BuyMemberService buyMemberService;

	@Test
	public void insertMember() throws Exception{
		Member member = new Member();
		member.setId("user05");
		member.setPassword("7777");
		member.setPhone("987654321");
		member.setAddr("서울시 테스트용 test!!");
		member.setEmail("test01@test.com");
		member.setName("테스트");
		member.setSex("남여");
		System.out.println("junit 시작");
		memberService.insertMember(member);
		
		assertEquals(member.getId(), memberService.getMember("user05").getId());
	}
	
	//@Test
	public void getListProduct() throws Exception{

		System.out.println("junit 시작");
		List<Product> list=productService.getProductList(1000040);
		System.out.println(list);
	}
	
	//@Test
	public void getProduct() throws Exception{

		System.out.println("junit 시작");
		Map<String, Object> map=productService.getAllProductList();
		
		System.out.println(map);
	}
	
	//@Test
	public void getListBuket()throws Exception{
		
		List<Buket> buketList=buketService.addBuketList(10000);
		System.out.println("test :"+buketList);
		System.out.println(buketList.get(0).getBuketProd());
		
		List<Product> prodList =new ArrayList<Product>();
		for(int i=0; i<buketList.size(); i++){
			prodList.add(i, buketList.get(i).getBuketProd());
		}
		System.out.println("test2: "+prodList);
	}
	
	//@Test
	public void buyProduct()throws Exception{

		Buy buy=new Buy();
		buy.setMemberNo(1000040);
		buy.setTranNo(1);
		buy.setProdNo(1000057);
		
		System.out.println("gg"+buyService.insertBuy(buy));
	}
}	








