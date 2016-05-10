<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="org.springframework.ui.Model"%>
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

	<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resources/bootstrap/css/shop-homepage.css" rel="stylesheet">
	
	<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="../resources/bootstrap/js/bootstrap.min.js"></script>
    
    <script>
     $(".list-group").click(function(){
    	 $(this).css('background', darkgray)
    	 
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
       <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" action="/member/logout" method="get">
            <div class="form-group">
              <span  style="color: wheat;">${member.id}(${member.name})님 환영 합니다.</span>
            </div>
              <button id="login" type="submit" class="btn btn-success" >Sign out</button>
              <a href="/product/myMenu"><button id="addProduct" type="button" class="btn btn-success" >상품관리</button></a>
		    
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-3 ">
                <p class="lead">개인 관리</p>
                <div class="list-group">
                    <a href="/member/updateMember" class="list-group-item">개인정보 수정</a>
                    <a href="/product/insertProduct" class="list-group-item" >상품 등록</a>
                    <a href="/buket/getListBuket/${member.memberNo }" class="list-group-item"  >장바 구니</a>
                    <a href="/listBuy.do?userId=" class="list-group-item"  >구매 목록</a>
                </div>
            </div>
            <div class="col-md-9">
                <div class="row">
				<c:forEach var="product" items="${product}">
					 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">	
                           <a href="/product/getProduct/${product.prodNo }">
                            <img src="/resources/img/${product.pic}" alt="" style="width: 320px; height: 200px;">
                              <div class="caption">
                                <h4 class="pull-right">${product.price } 원</h4>
                                <h4 style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
                                			<a href="/product/getProduct/${product.prodNo }">${product.prodName }</a>
                                </h4>
                                <p>${product.info }</p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">${member.id }(${member.name })</p>
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
 				</c:forEach>
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
