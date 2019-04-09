<%@ page language="java" import="java.util.*,com.example.model.*" pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Subject Select Result Page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <style type="text/css"> 
  		.center {
  			text-align:center;
  			margin:20px auto;
  		}
  </style>
  
  <body>
  	<%!
  		public void jspInit() {
  			ServletConfig servletConfig = getServletConfig();
  			ServletContext servletContext = getServletContext();
  			String zkbEmail = servletConfig.getInitParameter("zkbEmail");
  			servletContext.setAttribute("adminEmail", zkbEmail);
  		}
  	 %>
  	 
  	<%
  		User user = (User) session.getAttribute("user");
  		application.setAttribute("adminEmail", "XHSF@qq.com"); 
  	 %>
  	 
  	<br>
    <%= "subject: " + request.getParameter("subject") %>
    <br>
    <%= "adminEmail: " + application.getAttribute("adminEmail") %>
    <br>
    <%= "username: " + user.getUsername() %>
    <br>
    <%= "password: " + user.getPassword() %>
    
  </body>
</html>
