<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>Yeolsim Commse</title>

    <!-- 부트스트랩 -->
   <link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resources/bootstrap/css/shop-homepage.css" rel="stylesheet">
	
	<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="../resources/bootstrap/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">

	    window.onload = function(){ 

	    	}
	</script>    
  </head>
  <body>

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
    <div class="container" >

		<div class="row" >
            <div class="col-md-9" style="margin-left: 10%;">
            
                <div class="row carousel-holder">
                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1" class=""></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2" class=""></li>
                            </ol>
                            <div class="carousel-inner">
                               
                                <div class="item active">
                                    <img class="slide-image" src="/resources/img/${random[0].pic}" style="width: 800px; height: 300px;">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="/resources/img/${random[1].pic}" style="width: 800px; height: 300px;">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="/resources/img/${random[2].pic}" style="width: 800px; height: 300px;">
                                </div>
                              
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
					<c:forEach var="product" items="${product }">
					 <c:forEach var="men" items="${allMember }">
					 <c:if test="${product.memberNo==men.memberNo}">
					 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                        <a href="/product/getProduct/${product.prodNo }">
                            <img src="/resources/img/${product.pic }" alt="" style="width: 320px; height: 200px;">
                              <div class="caption">
                                <h4 class="pull-right">${product.price } 원</h4>
                                <h4 title="${product.prodName }" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
                                			${product.prodName }
                                </h4>
                                <p>${product.info }</p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">${men.id }(${men.name })</p>
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
                    </c:if>
                    </c:forEach>
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