<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" /> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<%
            Cookie[] cookies = request.getCookies();
			String peanut = "????";
			String user = "????";
			String token = null;
			String fullname =null;
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

<div class="w3-container w3-display-middle w3-sepia">
  <div id="login" class="w3-half ">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
      <div class="w3-center">
        <br />
        <header class="w3-container w3-white">
          <h1>Upload</h1></header>
        <i class="glyphicon glyphicon-file w3-xxxlarge"></i>
      </div>
      <form class="w3-container  " method="post" action="UploaderServlet" enctype="multipart/form-data">
        <div class="w3-section w3-center">
          <div class="w3-container">
            <label class="w3-center w3-half">Select file to upload:</label>
            <input type="file" name="filename" class="w3-half" />
          </div>
          <br />
          <label style="padding-right:300px;">APPName: </label>
          <br/>
          
          <input type="text" name="APPName" size ="20">
          <br />
          <label style="padding-right:300px;">Description:</label>
          <br/>
          <textarea rows="10" cols="60" name="content"></textarea>
          <input class="w3-button w3-blue w3-section w3-round-large  " style="width:50%" type="submit" value="upload"></div>
    	</div>   	
    </form>
  </div>
</div>

</body>
</html>