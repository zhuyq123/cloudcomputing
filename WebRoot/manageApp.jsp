<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Manage My App</title>
</head>
<body>
<%
            Cookie[] cookies = request.getCookies();
			String peanut = "????";
			String user = "????";
			String appName = "????";
			String fullname =null;
			
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                	if(cookie.getName().equals("peanut")){
						peanut=cookie.getValue();
					}
                	if(cookie.getName().equals("user")){
						user=cookie.getValue();
					}
                	if(cookie.getName().equals("APPName")){
						appName=cookie.getValue();
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

<h1 align = "center"> ManageMy APPs</h1>

<table class="w3-table w3-striped">
	<tr align ="center">
		<th>My App</th>
		<th>Uploaded by</th>
	</tr>

<%
	String[] apps = appName.split("!");
	if(apps.length > 0){
		for (int i=0;i<apps.length-1;i++){
%>
<tr>
	<td><%=apps[i+1] %></td>
	<td><%=user %></td>
	<td></td>
</tr>

<% 			
		}		
	}		
%>
</table>

</body>
</html>