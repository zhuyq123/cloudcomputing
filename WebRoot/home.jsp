<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" /> 
<title>Home</title>

<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">
</script>
</head>

<body>
<%
            Cookie[] cookies = request.getCookies();
			String peanut = "????";
			String user = "????";
			String token = null;
			String fullname =null;
			String project = null;
			String appName =null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                	if(cookie.getName().equals("peanut")){
						peanut=cookie.getValue();
					}
                	if(cookie.getName().equals("user")){
						user=cookie.getValue();
					}
                	if(cookie.getName().equals("token")){
						token=cookie.getValue();
					}
                	if(cookie.getName().equals("fullname")){
						fullname=cookie.getValue();
					}
                	if(cookie.getName().equals("project")){
						project =cookie.getValue();
					} 
                	if(cookie.getName().equals("appName")){
						project =cookie.getValue();
					} 
                	 
                }
            }
		%>
		
<nav class="w3-topnav w3-light-grey">

	<a class="w3-button w3-light-grey" href="http://localhost:8080/Platform">Home</a >
	<a class="w3-button w3-light-grey" href="http://localhost:8080/Platform/Uploadnew.jsp">Upload</a >
	<div class="w3-dropdown-hover w3-right" style="padding-right:40px;">
	 <button class="w3-button w3-light-grey">Peanut:<%=peanut %></button>
	 <div class="w3-dropdown-content "> 
	  <a class="w3-button w3-light-grey" href="http://localhost:8080/Platform/PeanutServlet">Update</a >
	 </div>
	</div>
	<div class="w3-dropdown-hover w3-right" style="padding-right:40px;">
	    <button class="w3-button w3-light-grey">Welcome, <%=fullname %></button>
	    <div class="w3-dropdown-content ">
	     <a class="w3-button w3-white" href="http://localhost:8080/Platform/ManageAppServlet">Manage My Apps</a >     
	     <a class="w3-button w3-white"  href="http://localhost:8080/Platform/LogoutServlet">Logout</a >
	    </div>
	</div> 
</nav>
	
		 
<div class="w3-display-container w3-blue" style="width:100%;height:300px">
  	<img class="Slides" src="image/1.jpg" style="width:100%;height:300px" >
 	<img class="Slides" src="image/2.jpg" style="width:100%;height:300px">
  	<img class="Slides" src="image/3.jpg" style="width:100%;height:300px">
    <h1 class="w3-jumbo w3-text-white w3-wide w3-display-middle "><b>CloudBase</b></h1>
</div>


  <section class="w3-container"> 
    <div class="w3-padding w3-third">
      <div class="w3-card-4">
        <header class="w3-container w3-light-grey w3-center">
           <h2>Weather</h2></header>
         
        <div class="w3-image w3-padding w3-center w3-grey">
          <a href = "http://localhost:8080/Weather">
          <img src="./image/weather.png" style="height:100px"></a></div>
        <div class="w3-container">
          <p>Sheffield Weather in one day</p>
        </div>
      </div>
    </div>
    
    
    <div class="w3-padding w3-third">
      <div class="w3-card-4">
        <header class="w3-container w3-light-grey w3-center">
          <h2>Message Board</h2></header>
        <div class="w3-image w3-padding w3-center w3-grey">
        <a href = "http://localhost:8080/notepad/list.jsp">
          <img src="image/message.png" style="height:100px"></a></div>
        <div class="w3-container">
          <p>Ask questions here and comment others message</p>
        </div>
      </div>
    </div>
    
    
    <div class="w3-padding w3-third">
      <div class="w3-card-4">
        <header class="w3-container w3-light-grey w3-center">
          <h2>Restaurants</h2></header>
        <div class="w3-image w3-padding w3-center w3-grey">
        <a href = " http://localhost:8080/MobileSearch">
          <img src="image/food.png" style="height:100px"></a></div>
        <div class="w3-container">
          <p>Students  can find restaurant in this app.</p>
        </div>
      </div>
    </div> 
  </section>
 <section class="w3-container">
  <div class="w3-padding w3-third">
    <div class="w3-card-4">
      <header class="w3-container w3-light-grey w3-center">
        <h2>Resource Sharing</h2></header>
      <div class="w3-image w3-padding w3-center w3-grey">
      <a href = "http://localhost:8080/FileUpLoadAndDownLoad">
        <img src="image/resource.png" style="height:100px"></a></div>
      <div class="w3-container">
        <p>Students in Sheffield can share file in this app </p>
      </div>
    </div>
  </div>
  	
  
  
 </section>
 

 
 <footer class="w3-center w3-light-grey w3-padding-32">
  <p>Welcome to our cloudbase</p>
</footer>

<script>
var index = 0;
slide();

function slide() {
    var i;
    var j = document.getElementsByClassName("Slides");
    for (i = 0; i < j.length; i++) {
       j[i].style.display = "none";  
    }
    index++;
    if (index > j.length) {index = 1}    
    j[index-1].style.display = "block";  
    setTimeout(slide, 4000); 
}
</script>


</body>

</html>