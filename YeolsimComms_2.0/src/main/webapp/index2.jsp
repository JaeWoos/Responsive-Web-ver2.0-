<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Yeolsim Commse</title>

	<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resources/bootstrap/css/shop-homepage.css" rel="stylesheet">
	<link href="../../resources/bootstrap/css/star-rating.min.css" media="all" rel="stylesheet">
	<link href="../../resources/bootstrap/css/theme-krajee-svg.min.css" medCopyright © Yeolsim Comms 2016ia="all" rel="stylesheet">
	<link href="../../resources/css/test.css" media="all" rel="stylesheet">
	
	<script src="../resources/bootstrap/js/jquery.js" ></script>
    <script src="../resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="../../resources/bootstrap/js/star-rating.min.js"></script>
    <script src="https://cdn.socket.io/socket.io-1.4.5.js"></script>
    
    <script type="text/javascript">
    
    
     window.onload=function(){
	    
    	 var temp=$("#check").val();
    	 console.log("gg"+temp);
    	 if(temp=="false"){
    		 alert("아이디와 비밀번호를 확인하세요.")
    	 }
 
	    $("#login").click(function(event){
	    	var id=$("#navbar .form-group").find("input[name='Id']").val();
			var pw=$("#navbar .form-group").find("input[name='password']").val();

			if(id == null || id.length <1) {
				alert('ID 를 확인하세요.');
				$("#navbar .form-group").find("input[name='Id']").focus();
			}else if(pw == null || pw.length <1) {
				alert('패스워드를 입력하지 않으셨습니다.');
				$("#navbar .form-group").find("input[name='password']").focus();
			}else {
			document.loginform.submit();
			}
	 	  })
	 	  
	 	$("#addClass").click(function(){
			$('#qnimate').addClass('popup-box-on');
			 var socket = io.connect('http://localhost:9000');
			console.log("ggg")
			
	     	$("#removeClass").click(function () {
	         	socket.emit("disconnect")	         
	         $('#qnimate').removeClass('popup-box-on');
	           });
		    
		    $("#status_message").keyup(function(){
		    	if(event.keyCode==13){
					var message= $("#status_message").val()
	
					$("#status_message").val('');
					socket.emit("sendchat", message)
				}
		    })
		    
	     socket.on('updatechat', function (data) {
	    	 console.log(data)
	    	    $('.direct-chat-messages').append(
	    	    	'<div class="direct-chat-info clearfix">'+
	                  '<span class="direct-chat-name pull-left">user02</span></div>'+
	                  '<div class="direct-chat-text">'+
	                    data+
	                  '</div>'
	    	    		);
	    	  });
		    
		 socket.on('updateusers', function (data) {
		    	 console.log(data)
		    	    $('.direct-chat-messages').append(
		    	    	'<div class="direct-chat-info clearfix">'+
		                  '<span class="direct-chat-name pull-left">user02</span></div>'+
		                  '<div class="direct-chat-text">'+
		                  		'상대방이 나갔습니다.'+
		                  '</div>'
		    	    		);
		    	  });
 		})
	    
	    
	    
	    
     }
     
     function keyDown(){
    	 if(event.keyCode==13){
    		 document.loginform.submit();
    	 }
     }
	    $(document).on('ready', function(){
	        $('.star').rating({displayOnly: true, step: 0.5});
	    });
	    
	    
	</script>    
	<style>
     .rating-xs {font-size:1em; }
     
    </style> 
    
</head>
<body>
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
        <c:if test="${user==false }">
        	<input type="hidden" id="check" value="${user}" >
        </c:if>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" id="loginform" name="loginform" action="/member/login" method="POST" >
            <div class="form-group">
              <input type="text" placeholder="ID" name="Id" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" name="password" class="form-control" onKeyDown="keyDown()">
            </div>
		      <button id="login" type="button" class="btn btn-success" >Sign in</button>
		       <a href="/member/insertMember"><button id="member" type="button" class="btn btn-success">Sign up</button></a>
		       <button id="addClass" type="button" class="btn btn-success" >test</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">
		<div class="row" >
             <div class="col-md-9" style="margin-left: 10%;">
                <div class="row carousel-holder">
                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner" >
                               <c:choose>
                               <c:when test="${product.size()==null}">
                                <div class="item active">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                            	</c:when> 
                            	<c:otherwise>
                                <div class="item active">
                                 <a href="/product/getProduct/${random[0].prodNo }">
                                    <img class="slide-image" src="/resources/img/${random[0].pic }" style="width: 800px; height: 300px;">
                                 </a>
                                </div>
                                <div class="item">
                                 <a href="/product/getProduct/${random[1].prodNo }">
                                    <img class="slide-image" src="/resources/img/${random[1].pic }" style="width: 800px; height: 300px;">
                                 </a>   
                                </div>
                                <div class="item">
                                 <a href="/product/getProduct/${random[2].prodNo }">
                                    <img class="slide-image" src="/resources/img/${random[2].pic }" style="width: 800px; height: 300px;">
                                 </a>   
                                </div>
                           		</c:otherwise>
                                </c:choose>
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
                    <c:choose>
                        <c:when test="${product.size()==0 }">
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
                    </c:when>
					<c:otherwise>
						<c:forEach var="product" items="${product }">
					 <c:forEach var="men" items="${allMember }">
					 <c:if test="${product.memberNo==men.memberNo}">
					 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                        <a href="/product/getProduct/${product.prodNo }">
                            <img src="/resources/img/${product.pic }" alt="" style="width: 320px; height: 200px;"></a>
                              <div class="caption">
                                <h4 class="pull-right">${product.price } 원</h4>
                                <h4 title="${product.prodName }" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
                                			${product.prodName }
                                </h4>
                                <p>${product.info }</p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right" id="addClass">${men.id }(${men.name })</p>
                                <div class="temp">
                                    <input class="star" value="${product.stat }" class="rating-loading" data-size="xs">
                                </div>
                            </div>
                            
                        </div>
                    </div>
                    </c:if>
                    </c:forEach>
					</c:forEach>
                    </c:otherwise>
			</c:choose>
                        </div>
                    </div>
                </div>
        </div>
        
        <div class="popup-box chat-popup" id="qnimate">
    		  <div class="popup-head">
				<h4>판매자와 1:1 채팅
				<button data-widget="remove" id="removeClass" class="chat-header-button pull-right" type="button"><i class="glyphicon glyphicon-off"></i></button></h4>
			  </div>
			<div class="popup-messages">
				<div class="direct-chat-messages">
					<!-- Message. Default to the left -->
                    <div class="direct-chat-msg doted-border">
                      <div class="direct-chat-text">
                       판매자에게 대화를 요청해 주세요
                      </div>
                      
                    </div>
                    <!-- /.direct-chat-msg -->
                  </div>
			</div>
			<div class="popup-messages-footer">
			<textarea id="status_message" placeholder="판매자와 1:1 상담" rows="10" cols="40" name="message"></textarea>
			<div class="btn-footer">
			<button class="bg_none"><i class="glyphicon glyphicon-film"></i> </button>
			<button class="bg_none"><i class="glyphicon glyphicon-camera"></i> </button>
            <button class="bg_none"><i class="glyphicon glyphicon-paperclip"></i> </button>
			<button class="bg_none pull-right"><i class="glyphicon glyphicon-thumbs-up"></i> </button>
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