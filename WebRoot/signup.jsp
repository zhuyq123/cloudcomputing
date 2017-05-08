<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" /> 
<title>Sign Up</title>
<script type="text/javascript">
	function beforeSubmit(form){
		
		if(form.password.value.length<4){
			alert('password cant less than 4 number!');
			form.password.focus();
			return false;
		}
		if(form.password.value!=form.ConfirmPassword.value) {
			alert("password must be same!");
			form.password2.focus();
			return false;
		}
		var emailStr=document.all.form.email.value;
		//alert(emailStr);
		var emailPat=/^(.+)@(.+)$/;
		var matchArray=emailStr.match(emailPat);
		if (matchArray==null) {
			alert("email must consist of @ and .");
		return false;
		}
		return true;
	}
	</script>
  </head>
</head>
<body>
<div class="w3-display-container">
  <img src="background1.jpg " class="w3-opacity" style="width:100%;height:900px">
<div class="w3-container w3-display-middle w3-sepia"> 
<div id="login" class="w3-half " > 
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px"> 
     	<div class="w3-center">
      		<br />
      		<header class="w3-container w3-white"><h2>Sign up</h2></header>       	
      		<img src="account.png" alt="Avatar" style="width:10%" class="w3-circle w3-margin-top" /> 
     	</div>
     	<% Cookie[] cookies = request.getCookies();
     		
     		for(int i=0;i<cookies.length;i++){
     			if(cookies[i].getName().equals("error")){%>
     				
     	<p align= "center"><font color ="red"><%=cookies[i].getValue()%></font></p>
     	<% 
     				break;
     			}
     		}
     		%>
     	<form class="w3-container w3-center" action="RegisterServlet" method= "post" name = "form" onsubmit ="return beforeSubmit(this);"> 
      		<div class="w3-section "> 
	       		<label><b>forename</b></label> 
	       		<input class="w3-input w3-border-bottom w3-border-light-grey w3-margin-bottom w3-center" type="text" placeholder="forename" name="forename" required="" /> 
	       		<label><b>Surname</b></label> 
	       		<input class="w3-input w3-border-bottom w3-border-light-grey w3-margin-bottom w3-center" type="text" placeholder="surname" name="surname" required="" /> 
	       		<label><b>Username</b></label> 
	       		<input class="w3-input w3-border-bottom w3-border-light-grey w3-margin-bottom w3-center" type="text" placeholder="username" name="username" required="" /> 
	       		<label><b>Email</b></label> 
	       		<input class="w3-input w3-border-bottom w3-border-light-grey w3-margin-bottom w3-center" type="text" placeholder="email" name="email" required="" /> 
	       		<label><b>Password</b></label> 
	       		<input class="w3-input w3-border-bottom w3-border-light-grey w3-margin-bottom w3-center" type="password" placeholder="password" name="password" required="" /> 
	       		<label><b>Confirm Password</b></label> 
	       		<input class="w3-input w3-border-bottom w3-border-light-grey w3-margin-bottom w3-center" type="password" placeholder="ConfirmPassword" name="confirmpassword" required="" /> 
        		<input class="w3-button w3-blue w3-section w3-round-large w3-center " style="width:50%" type="submit" value = "Sign up" >
			</div>
       	</form> 
      </div>    	
</div> 
</div>
</div>
</body>
</html>