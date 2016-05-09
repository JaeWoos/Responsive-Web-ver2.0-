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

        <!-- /.container -->

    <!-- Page Content -->
    <div class="container">
       <div class="row">
            <div class="col-md-3">
                <p class="lead">개인 관리</p>
               <div class="list-group">
                    <a href="/member/updateMember" class="list-group-item">개인정보 수정</a>
                    <a href="/product/insertProduct" class="list-group-item" >상품 등록</a>
                    <a href="/addBuketList.do" class="list-group-item"  >장바 구니</a>
                    <a href="/listBuy.do?userId=${member.id }" class="list-group-item"  >구매 목록</a>
                </div>
            </div>

            <div class="col-md-9">

				<div class="thumbnail" style="width: inherit;">
					<form class="form-horizontal"  action="/product/updateProduct" method="post">                  
                   	 <img class="img-responsive" src="/resources/img/${product.pic }" alt="" style="width: 300px;height: 220px;margin: 10px 0px 20px 150px;">
      					<div class="form-group" id="divId">
                			<label for="inputId" class="col-lg-2 control-label">상품명</label>
                				<div class="col-lg-10">
                    				<input type="text" class="form-control" id="prodName" name="prodName" data-rule-required="true" value="${product.prodName }">
                					<input type="hidden" class="form-control" id="" name="prodNo" data-rule-required="true" value="${product.prodNo }">	
                				</div>
            			</div>
            			<div class="form-group" id="divPassword">
                			<label for="inputPassword" class="col-lg-2 control-label">상품 가격</label>
               				 <div class="col-lg-10">
                  			  <input type="text" class="form-control" id="prodPrice" name="price" data-rule-required="true" value="${product.price }">
                			</div>
            			</div>
            			<div class="form-group" id="divName">
                			<label for="inputName" class="col-lg-2 control-label">상품 설명</label>
                				<div class="col-lg-10">
                    				<input type="text" class="form-control onlyHangul" id="prodInfo" name="info" data-rule-required="true" value="${product.info }">
                				</div>
            			</div>
            			<div class="form-group">
               			 <label for="inputPhoneNumber" class="col-lg-2 control-label">분류</label>
                		 <div class="col-lg-10">
                    		<select class="form-control" id="cate" name="cate">
                        		<option value="의류">의류</option>
                        		<option value="가전">가전</option>
                        		<option value="음식">음식</option>
                        		<option value="가구">가구</option>
                        		<option value="기타">기타</option>
	                    	</select>	
                </div>
            </div>
            			<div class="form-group">
                			<div class="col-lg-offset-2 col-lg-10">
                    		<button type="submit" class="btn btn-default">제품 등록</button>
                			</div>
            			</div>
			        </form>
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
