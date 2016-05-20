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
    
    window.onload = function(){    
	    $("#tranNo").click(function(){
	    	var temp=$(":checked");
	    	var eachChk=[]
	    	temp.each(function() {
	    		eachChk.push($(this).val())
	    	});
	    	console.log(eachChk)
 			$.ajax({
				type:"POST",
				url:"/buy/updateTranNo",
				dataType:"JSON",
				data:{
					eachChk
				},
				success:function(data){
					console.log("gg"+data)
					location.reload();
				}
			}) 
	    })
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
		 <div class="col-md-3 ">
                <p class="lead">개인 관리</p>
                <div class="list-group">
                    <a href="/member/updateMember" class="list-group-item">개인정보 수정</a>
                    <a href="/product/insertProduct" class="list-group-item" >상품 등록</a>
                    <a href="/buket/getListBuket/${member.memberNo }" class="list-group-item"  >장바 구니</a>
                    <a href="/buy/getBuyList/${member.memberNo }" class="list-group-item"  >구매 목록</a>
                    <a href="/product/buyProduct/${member.memberNo }" class="list-group-item"  style="background-color: #DCDCDC">판매 관리</a>
                </div>
          </div>
		<form  action="/buy/listViewProduct" class="col-md-9" method="POST">
				<h4 class="page-header">판매 리스트</h4>
		<c:forEach items="${buyList}" var="product">
			<div class="row">
				<div class="col-md-7">
						<input type="checkbox" name="check" value="${product.buyProd.buyNo}">
						<img class="img-responsive" src="../../resources/img/${product.pic }" alt="" style="width: 320px; height: 200px;">
				</div>
				<div class="col-md-5">
				 	<div> <h3>${product.prodName }</h3></div>
					<div> <h4>가 격 : ${product.price } 원</h4></div>
					<div> <h4>설 명 : ${product.info } </h4></div>
					<div> <h4>판매일 : ${product.buyProd.data}</h4></div>
					<c:choose>
						<c:when test="${product.buyProd.tranNo==0 }">
							<div> <h4>배송상태 : 배 송 준 비 </h4></div>
						</c:when>
						<c:when test="${product.buyProd.tranNo==1 }">
							<div> <h4>배송상태 : 배 송 중 </h4></div>
						</c:when>
						<c:when test="${product.buyProd.tranNo==2 }">
							<div> <h4>배송상태 : 배 송 완 료 </h4></div>
						</c:when>
					</c:choose>
					
				</div>
			</div>
			<hr>
		</c:forEach>
		<hr>
	        <button class="btn btn-primary" type="button" id="tranNo">배송 처리</button>
		</form>
<!-- /.row -->
	 </div>
	</div>
        <hr>
    <div class="container">
        <hr>
    	<footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Yeolsim Comms 2016</p>
                </div>
            </div>
        </footer>
    </div>
</body>
</html>
