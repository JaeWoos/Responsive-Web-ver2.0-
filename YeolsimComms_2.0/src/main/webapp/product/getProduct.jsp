<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.List"  %>
<%@ page import="yeolsim.service.domain.Member" %>
<%@ page import="yeolsim.service.domain.Product" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Yeolsim Commse</title>

	<link href="../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="../../resources/bootstrap/css/shop-homepage.css" rel="stylesheet">
	
	<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
    
	<script type="text/javascript">
		window.onload = function(){
			$("#buket").click(function(){
				alert("장바구니에 추가 되었습니다.")
				$.ajax({
					type:"POST",
					url:"/buket/insertBuket",
					dataType:"JSON",
					contentType: "application/json",
					data:JSON.stringify({
						memberNo:$("#memberNo").val(),
						prodNo:$("#prodNo").val(),
						count:$("#count").val()
					}),
					success:function(data){
							console.log(data.check)
					}
				})
			})
			
			$("#buy").click(function(){
			alert("구매")
			document.getElementById("info").action="/addBuy.do?prodNo";
			})
		}
			
		$(document).ready(function(){ 
	        	var count=$("#count").val();
	        $("#add").click(function(){
				if(count>=10 ){
					alert("최대 구매 수량을 초과 하였습니다.")
				}else{
				count++;
				$("#count").val(parseInt(count));
	        	}
	        })
	        $("#sub").click(function(){
				if(count<=1){
					alert("최소 구매 수량입니다.")
				}else{
					count--;
				$("#count").val(parseInt(count));
				}
	        })
	    })
	        
	 
	</script> 
</head>
<body>
<%
		request.setCharacterEncoding("UTF-8");
%>
   <nav class="navbar navbar-inverse navbar-fixed-top">
       <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/member/login">Yeolsim Shop</a>
        </div>
        <c:choose>
	        <c:when test="${member!=null }">
	        <div id="navbar" class="navbar-collapse collapse">
	          <form class="navbar-form navbar-right" action="/member/logout" method="GET">
	            <div class="form-group">
	              <span  style="color: wheat;">${member.id }(${member.name})님 환영 합니다.</span>
	            </div>
	              <button id="login" type="submit" class="btn btn-success" >Sign out</button>
	              <a href="/product/myMenu"><button id="addProduct" type="button" class="btn btn-success" >상품관리</button></a>
	          </form>
	        </div><!--/.navbar-collapse -->
	      </div>
	      </c:when>
	      <c:otherwise>
	       <div id="navbar" class="navbar-collapse collapse">
		          <form class="navbar-form navbar-right" id="loginform" action="/member/login" method="post">
		            <div class="form-group">
		              <input type="text" placeholder="ID" name="Id" class="form-control">
		            </div>
		            <div class="form-group">
		              <input type="password" placeholder="Password" name="password" class="form-control">
		            </div>
				      <button id="login" type="submit" class="btn btn-success" >Sign in</button>
				       <a href="/member/insertMember"><button id="member" type="button" class="btn btn-success">Sign up</button></a>
		          </form>
        	</div><!--/.navbar-collapse -->
	      </c:otherwise>
      </c:choose>
    </nav>

    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-9" style="margin: 0% 20% 0% 20%;">
                <div class="thumbnail" style="width: inherit;height: 390px;">
                    <img class="img-responsive" src="/resources/img/${product.pic }" alt=""  style="width: 300px;height: 220px;margin-top: 20px;">
                    <hr style="margin-bottom: auto; border-style: groove;">
                    <div class="caption-full" >
                        <h4 class="pull-right">${product.price } 원</h4>
                        <h4>${product.prodName }
                        </h4>
                        <p>${product.info }</p>
                    </div>
                    <div class="ratings" style="margin-bottom: 25px;">
                    <c:choose>
                    <c:when test="${member==null }">
                    	<button id="buket" type="submit" class="btn btn-success" >장바구니</button>
					
					</c:when>
                    <c:when test="${product.memberNo!=member.memberNo }">
                        <form class="counter" id="info">
                        	<p class="pull-right" style="width:250px;">
								<span class="glyphicon glyphicon-chevron-left" id="sub" style="border: solid 2px;padding:2%;margin:3px;"></span>
								<input type="text" value="1" readonly="" name="count" id="count" style="width: 10%;">
								<input type="hidden" value="${product.prodNo }" name="prodNo" id="prodNo" style="width: 10%;">
								<input type="hidden" value="${member.memberNo }" name="memberNo" id="memberNo" style="width: 10%;">
								<span class="glyphicon glyphicon-chevron-right" id="add" style="border:solid 2px;padding:2%;margin:3px;"></span>
                        	<button id="buket" type="button" class="btn btn-success" >장바구니</button>
                        	<button id="buy" type="submit" class="btn btn-success" >구 매 </button>
                        	</p>
						</form>
					</c:when>
					<c:otherwise>
                        <a href="/product/updateProduct/${product.prodNo}">
                        	<button id="login" type="submit" class="btn btn-success" >수  정</button></a>
                        <button id="login" type="submit" class="btn btn-success" >삭  제</button>
					</c:otherwise>
					</c:choose>
                    </div>
                </div>
            </div>
        </div>
            </div>
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
