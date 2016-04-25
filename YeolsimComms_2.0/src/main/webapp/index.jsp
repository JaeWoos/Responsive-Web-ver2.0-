<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@ page import="java.util.*"  %>
<%@ page import="yeolsim.service.domain.Member" %>
<%@ page import="yeolsim.service.domain.Product" %>
<%@ page import="yeolsim.service.product.ProductService" %>
<%@ page import="yeolsim.service.product.impl.ProductServiceImpl" %>
<% String path=request.getContextPath(); %>

<%
/* 	ProductService productService=new ProductServiceImpl();
	Map<String, Object> map =productService.getAllProductList();
	
	List<Product> list= (List<Product>)map.get("product");
	List<Member> memList= (List<Member>)map.get("member"); 
	*/
	
%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Yeolsim Commse</title>

	<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/bootstrap/css/shop-homepage.css" rel="stylesheet">
	
	<script src="resources/bootstrap/js/jquery.js" ></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
   		window.onload = function(){ 
		    $("#login").click(function(){
		    	var id=$("#navbar .form-group").find("input[name='userId']").val();
				var pw=$("#navbar .form-group").find("input[name='password']").val();
		
				if(id == null || id.length <1) {
					alert('ID 를 확인하세요.');
					$("#navbar .form-group").find("input[name='userId']").focus();
				}
				if(pw == null || pw.length <1) {
					alert('패스워드를 입력하지 않으셨습니다.');
					$("#navbar .form-group").find("input[name='userId']").focus();
				}
		    })
		    }
  		
   //	function loginProduct(){
   //		var temp=<%=session.getAttribute("member")%>
   // 	alert("로그인 후 이용하세요");
   //	}	
   		 
	</script>    
    
</head>

<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
  
   <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/index.jsp">Yeolsim Shop</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" id="loginform" action="/login.do" method="post">
            <div class="form-group">
              <input type="text" placeholder="ID" name="userId" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" name="password" class="form-control">
            </div>
		      <button id="login" type="submit" class="btn btn-success" >Sign in</button>
		       <a href="/member/insertMember"><button id="member" type="button" class="btn btn-success">Sign up</button></a>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>


    <!-- Page Content -->
    <div class="container">
		<div class="row" >
         <%--    <div class="col-md-9" style="margin-left: 10%;">
                <div class="row carousel-holder">
                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner" >
                                 <% if(list.size()==0) { %>
                                <div class="item active">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                            <% }else{ 
                            	List<Product> randomList=new ArrayList<Product>();
                            	  Random ra = new Random();
                            	  int mainSize= list.size();
                            	  for(int i=0; i<mainSize ;i++){
                            	   int rv = ra.nextInt(list.size());
                            	   randomList.add(list.get(rv));
                            	  }
                            	%>      	
                                <div class="item active">
                                    <img class="slide-image" src="/img/<%= randomList.get(0).getPic() %>" style="width: 800px; height: 300px;">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="/img/<%= randomList.get(1).getPic() %>" style="width: 800px; height: 300px;">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="/img/<%= randomList.get(2).getPic() %>" style="width: 800px; height: 300px;">
                                </div>
                                <%} %>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <%	if(list.size()==0 || memList==null){ %>
                    	 <div class="col-sm-4 col-lg-4 col-md-4">
                         <div class="thumbnail">
                             <img src="http://placehold.it/320x150" alt="">
                             <div class="caption">
                                 <h4 class="pull-right">$24.99</h4>
                                 <h4><a href="#">First Product</a>
                                 </h4>
                                 <p>See more snippets like this online store item at <a target="_blank" href="http://www.bootsnipp.com">Bootsnipp - http://bootsnipp.com</a>.</p>
                             </div>
                             <div class="ratings">
                                 <p class="pull-right">15 reviews</p>
                                 <p>
                                     <span class="glyphicon glyphicon-star"></span>
                                     <span class="glyphicon glyphicon-star"></span>
                                     <span class="glyphicon glyphicon-star"></span>
                                     <span class="glyphicon glyphicon-star"></span>
                                     <span class="glyphicon glyphicon-star"></span>
                                 </p>
                             </div>
                         </div>
                     </div>
                    	
                   <% }else{                     
							for(int i=0; i<list.size(); i++) {
								Product product = list.get(i);
									for(int j=0 ; j<memList.size(); j++){
										Member mem=memList.get(j);
										if(product.getMemberNo()==mem.getMemberNo()){
											%>
					 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                        <a href="/getProduct.do?prodNo=<%=product.getProdNo()%>">
                            <img src="/img/<%=product.getPic() %>" alt="" style="width: 320px; height: 200px;">
                              <div class="caption">
                                <h4 class="pull-right"><%=product.getPrice() %> 원</h4>
                                <h4 title="<%=product.getProdName() %>" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
                                			<%=product.getProdName() %>
                                </h4>
                                <p><%=product.getInfo() %></p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right"><%=mem.getId() %>(<%=mem.getName() %>)</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                            </a>
                        </div>
                    </div>
			<%								
										}
									}
								}
                    }
				
	 		 %>	 
                        </div>
                    </div>
   --%>
                </div>
        </div>
    <!-- /.container -->
    <div class="container">
        <hr>
        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Yeolsim Comms 2016</p>
                </div>
            </div>
        </footer>
    </div>
    <!-- /.container -->

</body>

</html>