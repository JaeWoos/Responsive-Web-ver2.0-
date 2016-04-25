<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.List"  %>
<%@ page import="yeolsim.service.domain.Member" %>
<%@ page import="yeolsim.service.domain.Product" %>

<% String path=request.getContextPath(); %>

<%
		Member member = (Member)session.getAttribute("member");
		List<Product> list= (List<Product>)request.getAttribute("product");
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>Yeolsim Commse</title>

    <!-- 부트스트랩 -->
    <link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="../resources/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    
/*  	function getFormData($form){
	    var unindexed_array = $form.serializeArray();
	    var indexed_array = {};

	    $.map(unindexed_array, function(n, i){
	        indexed_array[n["name"]] = n["value"];
	    });

	    return indexed_array;
	} */
	
		function loginCheck(){
			
				if($('#id').val()==""){
	           	 alert("아이디를 입력하세요");
	           	 focus();
	            }else if($('#password').val()==""){
	            	 alert("패스워드를 입력하세요");
	            	 focus();
	            }else if($.trim($('#name').val())==""){
	            	 alert("이름을 입력하세요");
	            	 focus();
	            }else if($.trim($('#email').val())==""){
	            	 alert("이메일을 입력하세요");
	            	 focus();
	            }else if($.trim($('#phoneNumber').val())==""){
	            	 alert("핸드폰번호를 입력하세요");
	            	 focus();
	            }else if($.trim($('#Addr').val())==""){
	            	 alert("주소를 입력하세요");
	            	 focus();
	            }
				var temp=$("#addMember")
				console.log(temp)
				document.getElementById("addMember").action="/member/insertMember"; 
				/* var temp=$('#addMember')
				var data = getFormData(temp)
				console.log("gg"+data);
				$.ajax({
					type:"POST",
					url:"/member/insertMember",
					data:JSON.stringify(data),
					dataType:"json",
					contentType:"application/json; charset=utf-8",
					success:function(data){
						console.log("ggg"+data)
					},
				});  */
		}
		
    window.onload = function(){ 
		 $('#id').focusout(function(event){
             var divId = $('#divId');
             var temp=$("#id").val();
             if($('#id').val()==""){
                  divId.removeClass("has-success");
                 divId.addClass("has-error");
             }else{
                 divId.removeClass("has-error");
                 divId.addClass("has-success");
             }
         });

		 $('#password').focusout(function(event){
             var divPassword = $('#divPassword');
             if($('#password').val()==""){
                 divPassword.removeClass("has-success");
                 divPassword.addClass("has-error");
             }else{
                 divPassword.removeClass("has-error");
                 divPassword.addClass("has-success");
             }
         });
         
         $('#passwordCheck').focusout(function(event){
             var passwordCheck = $('#passwordCheck').val();
             var password = $('#password').val();
             var divPasswordCheck = $('#divPasswordCheck');
              
             if((passwordCheck=="") || (password!=passwordCheck)){
                 divPasswordCheck.removeClass("has-success");
                 divPasswordCheck.addClass("has-error");
             }else{
                 divPasswordCheck.removeClass("has-error");
                 divPasswordCheck.addClass("has-success");
             }
         });
         
         $('#name').focusout(function(event){
             var divName = $('#divName');
              
             if($.trim($('#name').val())==""){
                 divName.removeClass("has-success");
                 divName.addClass("has-error");
             }else{
                 divName.removeClass("has-error");
                 divName.addClass("has-success");
             }
         });
         
         $('#email').keyup(function(event){
             var divEmail = $('#divEmail');
              
             if($.trim($('#email').val())==""){
                 divEmail.removeClass("has-success");
                 divEmail.addClass("has-error");
             }else{
                 divEmail.removeClass("has-error");
                 divEmail.addClass("has-success");
             }
         });
         
         $('#phoneNumber').keyup(function(event){
             var divPhoneNumber = $('#divPhoneNumber');
              
             if($.trim($('#phoneNumber').val())==""){
                 divPhoneNumber.removeClass("has-success");
                 divPhoneNumber.addClass("has-error");
             }else{
                 divPhoneNumber.removeClass("has-error");
                 divPhoneNumber.addClass("has-success");
             }
         });
         
         $('#Addr').keyup(function(event){
             var divPhoneNumber = $('#divAddr');
              
             if($.trim($('#Addr').val())==""){
                 divPhoneNumber.removeClass("has-success");
                 divPhoneNumber.addClass("has-error");
             }else{
                 divPhoneNumber.removeClass("has-error");
                 divPhoneNumber.addClass("has-success");
             }
         });
    }
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
             <a class="navbar-brand" href="/index.jsp">Yeolsim Shop </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" placeholder="ID" name="userId" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" name="password" class="form-control">
            </div>
		      <button id="login" type="submit" class="btn btn-success">Sign in</button>
		       <button id="member" type="submit" class="btn btn-success">Sign up</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
    
		<div class="container" style="margin-top: 7%;">
         <form class="form-horizontal" role="form" action="javascript:loginCheck()" method="POST" id="addMember">                  
            <div class="form-group" id="divId">
                <label for="inputId" class="col-lg-2 control-label">아이디</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control onlyAlphabetAndNumber" id="id"  name="id" data-rule-required="true" placeholder="영어 숫자 포함" maxlength="30">
                </div>
            </div>
            <div class="form-group" id="divPassword">
                <label for="inputPassword" class="col-lg-2 control-label">패스워드</label>
                <div class="col-lg-10">
                    <input type="password" class="form-control" id="password" name="password" data-rule-required="true" placeholder="패스워드" maxlength="30">
                </div>
            </div>
            <div class="form-group" id="divPasswordCheck">
                <label for="inputPasswordCheck" class="col-lg-2 control-label">패스워드 확인</label>
                <div class="col-lg-10">
                    <input type="password" class="form-control" id="passwordCheck" data-rule-required="true" placeholder="패스워드 확인" maxlength="30">
                </div>
            </div>
            <div class="form-group" id="divName">
                <label for="inputName" class="col-lg-2 control-label">이름</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control onlyHangul" id="name" name="name" data-rule-required="true" placeholder="홍길동" maxlength="15">
                </div>
            </div>
                                    
            <div class="form-group" id="divEmail">
                <label for="inputEmail" class="col-lg-2 control-label">이메일</label>
                <div class="col-lg-10">
                    <input type="email" class="form-control" id="email" name="email" data-rule-required="true" placeholder="이메일" maxlength="40">
                </div>
            </div>
            <div class="form-group" id="divPhoneNumber">
                <label for="inputPhoneNumber" class="col-lg-2 control-label">휴대폰 번호</label>
                <div class="col-lg-10">
                    <input type="tel" class="form-control onlyNumber" id="phoneNumber" name="phone" data-rule-required="true" placeholder="-를 제외하고 숫자만 입력하세요." maxlength="11">
                </div>
            </div>
            <div class="form-group" id="divAddr">
                <label for="inputAddr" class="col-lg-2 control-label">주소</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" id="Addr" name="addr" data-rule-required="true" placeholder="배송될 주소를 입력하세요" maxlength="50">
                </div>
            </div>
            
            <div class="form-group">
                <label for="inputPhoneNumber" class="col-lg-2 control-label">성별</label>
                <div class="col-lg-10">
                    <select class="form-control" id="gender" name="sex">
                        <option value="M">남</option>
                        <option value="F">여</option>
                    </select>
                </div>
            </div>
         
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <button type="submit" class="btn btn-default">Sign in</button>
                </div>
            </div>
        </form>
        </div>
</body>
</html>