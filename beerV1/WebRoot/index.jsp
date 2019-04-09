<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<%!
  		int count = 1;
  	%>
  	<%! 
  		int doubleCount() {
  			count *= 2;
  			return count;
  		}
  	 %>
  	
  	<h1>User log up</h1>
  	
  	<%= doubleCount() %>
    <form method="post" action="form">
   		username: <input type="text" name='username'/>
   		<br>
   		password: <input type="password" name='password'/>
   		<center>
   			<input type="submit">
   		</center>
   	</form>
   	
<!--    	<form method="post" action="ideaSelectResult.jsp">
   		username: <input type="text" name='username'/>
   		<br>
   		password: <input type="password" name='password'/>
   		<br>
   		id: <input type="text" name='id'/>
   		<center>
   			<input type="submit">
   		</center>
   	</form> -->
  </body>
</html>
