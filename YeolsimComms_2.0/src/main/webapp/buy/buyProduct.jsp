<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Yeolsim Commse</title>
    <!-- Bootstrap Core CSS -->
		<link href="../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="../../resources/bootstrap/css/shop-homepage.css" rel="stylesheet">
	
	<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
    <!-- Custom CSS -->
    <link href="../../resources/bootstrap/css/1-col-portfolio.css" rel="stylesheet">
    
    <script type="text/javascript">
    
    window.onload=function(){

    }
    </script>
</head>

<body>
    <!-- Navigation -->
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
            <div class="col-lg-12">
                <h1 class="page-header">구매 리스트</h1>
            </div>
        </div>
        <!-- Project One -->
        <c:set var="totalPrice" value="0" />
        <c:forEach items="${prodList }" var="product">
        <c:set var="totalPrice" value="${totalPrice+product.price }"/>
        <div class="row">
            <div class="col-md-7">
                <a href="#">
                    <img class="img-responsive" src="../../resources/img/${product.pic }" alt="" style="width: 320px; height: 200px;">
                </a>
            </div>
            <div class="col-md-5">
                <h3>${product.prodName } </h3>
                <h4>가격 : ${product.price }</h4>
                <p>${product.info }</p>
            </div>
        </div>
        <br><hr><br>
        </c:forEach>
        <!-- /.row -->
		<form class="form-horizontal" action="/buy/insertProduct" method="post" id="addBuy">                  
            <div class="form-group" id="divName">
                <label for="inputName" class="col-lg-2 control-label">받으실 분</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control onlyAlphabetAndNumber" id="name"  name="name" data-rule-required="true" placeholder="이름" maxlength="30">
                </div>
            </div>
            <div class="form-group" id="divPhone">
                <label for="inputPhone" class="col-lg-2 control-label">전화 번호</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" id="phone" name="phone" data-rule-required="true" placeholder="받으실 분 전화번호" maxlength="50">
                </div>
            </div>
            <div class="form-group" id="divAddr">
                <label for="inputPhone" class="col-lg-2 control-label">배송지 주소</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" id="Addr" name="Addr" data-rule-required="true" placeholder="받으실 분 주소" maxlength="50">
                </div>
            </div>
            <div class="form-group" id="divPrice">
                <label for="inputPrice" class="col-lg-2 control-label">총 결제금액</label>
                <div class="col-lg-10">
                    <div><h3 style="margin: 3px;" > <c:out value="${totalPrice }"/>원</h3></div>
                    <c:forEach items="${prodList}" var="prod">
					   <input type="hidden" name="prodNo" value="${prod.prodNo }">
					</c:forEach>                 
					   <input type="hidden" name="totalBuy" value="${totalBuy}">
                </div>
            </div>
            <div class="form-group" id="divPrice">
            <label for="inputPrice" class="col-lg-2 control-label">결제 수단</label>
             <div class="col-lg-10">
	            <div class="btn-group" data-toggle="buttons">
	                <label class="btn btn-default">
	                    <input type="radio" name="pay" value="신용카드" /> 신용카드
	                </label> 
	                <label class="btn btn-default">
	                    <input type="radio" name="pay" value="계좌이체" /> 계좌이체
	                </label> 
	                <label class="btn btn-default">
	                    <input type="radio" name="pay" value="기타" /> 기타
	                </label> 
	                <label class="btn btn-default">
	                    <input type="radio" name="pay" value="외상" /> 외상
	                </label> 
	            </div>
	            </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <button type="submit" class="btn btn-default" id="pay">결제 하기</button>
                </div>
            </div>
        </form>
        <hr>
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
