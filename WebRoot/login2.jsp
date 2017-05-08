<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" /> 
<title>Login</title>
<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">
</script>

<script type= "text/javascript">
	$(document).ready(function(){
		document.location.href = "TokenServlet";
	});
	
</script>
</head>
<body>
<div class="w3-display-container">
  <img src="background1.jpg " class="w3-opacity" style="width:100%;height:900px">
<div class="w3-container w3-display-middle w3-sepia"> 
<div id="login" class="w3-half " > 
    	<div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px"> 
     		<div class="w3-center">
      		<br /> 
      		<header class="w3-container w3-white"><h1>Login</h1></header> 
      	
      		<img src="account.png" alt="Avatar" style="width:20%" class="w3-circle w3-margin-top" /> 
     		</div>
     	<form class="w3-container w3-center" action="TokenServlet" method = "post"> 
      		<div class="w3-section "> 
       		<label><b>Username</b></label> 
       		<input class="w3-input w3-border-bottom w3-border-light-grey w3-margin-bottom w3-center" type="text"  name="name" required="" /> 
       		<label><b>Password</b></label> 
       		<input class="w3-input w3-border-bottom w3-border-light-grey w3-margin-bottom w3-center" type="password"  name="password" required="" /> 
        		<input  class="w3-button w3-blue w3-section w3-round-large w3-left " style="width:50%" type="submit" value = "Login">
        		<span class="w3-right w3-padding-24 ">No account? <a href="http://localhost:8080/Platform/signup.jsp">Sign up</a></span>
       			</div> 
      		</div> 
     	</form>
    	</div> 
 
	</div>
</div>
</div>
</body>
</html>