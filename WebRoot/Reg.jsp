<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
	function beforeSubmit(form){
		if(form.name.value.length == 0){
			alert('name cant be empty');
			form.name.focus();
			return false;
		}
		if(form.password.value.length == 0){
			alert('password cant be empty!');
			form.password.focus();
			return false;
		}
		if(form.password.value.length<4){
			alert('password cant less than 4 number!');
			form.password.focus();
			return false;
		}
		if(form.password.value!=form.password2.value) {
			alert('password must be same!');
			form.password2.focus();
			return false;
		}
		return true;
	}
	</script>
  </head>
  
  <body>
  <center>
    <div>
    <h1>register</h1>
    <form action="RegisterServlet" method="post">
	username:<input type="text" name="username"><br/>
    password:<input type="password" name="password"><br/>
    <!--  
    password:<input type="password" name="rpsw"><br/>
    -->
    <input type="submit" value="submit">
    </form>
   <font color="red" size="2"> ${msg }</font>
    </div>
    </center>
  </body>
</html>
