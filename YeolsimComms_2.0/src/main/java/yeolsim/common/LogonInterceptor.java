package yeolsim.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import yeolsim.service.domain.Member;


/*

 */
public class LogonInterceptor extends HandlerInterceptorAdapter {
	
	///Constructor
	public LogonInterceptor(){
		System.out.println("\nCommon :: "+this.getClass()+"\n");		
	}
	
	///Method
	public boolean preHandle(	HttpServletRequest request,
														HttpServletResponse response, 
														Object handler) throws Exception {
		
		System.out.println("\n[ LogonCheckInterceptor start........]");
		System.out.println("ggg :"+request.getSession().getId());
		HttpSession session = request.getSession(true);
		Member member = (Member)session.getAttribute("member");
			try{
				if(member==null){
					System.out.println("1");
					response.sendRedirect("/index.jsp");
					return false;
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		
		
		return true;
		}

}//end of class







