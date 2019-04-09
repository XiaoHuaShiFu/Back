<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Beer Selection Advice</title>
    
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
  		}
  </style>
  
  <body>
    <h1 class="center">Beer Recommendations JSP</h1>
    <% 
    	@SuppressWarnings("unchecked")
 		List<String> styles = (List<String>) request.getAttribute("styles"); 
 		@SuppressWarnings("unchecked")
 		List<String> varieties = (List<String>) request.getAttribute("varieties");
 		String color = (String) request.getAttribute("color");
 		String body = (String) request.getAttribute("body");
 		String price = (String) request.getAttribute("price");
 		String info = (String) request.getAttribute("info");
 		String username = (String) request.getAttribute("username");
 		String adminEmail = (String) request.getAttribute("adminEmail");
 		String zkbEmail = (String) request.getAttribute("zkbEmail");
 		String counts = (String) request.getAttribute("counts");
 		
 		if (username != null) {
 			out.print("<h2 class='center'>" + "Welcome " + username + "</h2>");
 		}
 		if (counts != null) {
 			out.print("<h3 class='center'>" + "The current number of sessions is " + counts + "</h3>");
 		}
 		if (info != null) {
 			out.print("<br><strong>" + info +"</strong><br>");
 		}
 		if (color != null) {
 			out.print("<br>color: " + color);
 		}
 		if (body != null) {
 			out.print("<br>body: " + body);
 		}
 		if (price != null) {
 			out.print("<br> price" + price);
 		}
 		if (styles != null) {
 			Iterator<String> iterator = styles.iterator();
 			while (iterator.hasNext()) {
				out.print("<br> try: " + iterator.next()); 		
 			}
 		}
 		if (varieties != null) {
 			Iterator<String> iterator = varieties.iterator();
 			while (iterator.hasNext()) {
				out.print("<br> try: " + iterator.next()); 		
 			}
 		}
 		
 		if (body == null || price == null) {
 			 out.print("<form method='post' action='SelectBeer.do'>" + 
 			"<p>Select beer characteristics</p>" + 
   		"Body:" + 
   		"<select name='body' size='1'>" + 
   			"<option value='light'>light</option>" + 
   			"<option value='amber'>medium</option>" + 
   			"<option value='brown'>heavy</option>" + 
   		"</select>" + 
   		"<br>" + 
   		"Prices:" + 
   		"<br>" + 
   		"<select name='price' size='1'>" + 
   			"<option value='100~500'>100~500</option>" + 
   			"<option value='500~1000'>500~1000</option>" + 
   			"<option value='More than 1000'>More than 1000</option>" + 
   		"</select>" + 
   		"<br>" + 
   		"<br>" + 
   		"<center>" + 
   			"<input type='submit'>" + 
   		"</center>" + 
   	"</form>");
 		}
 		
 		
 		if (adminEmail != null) {
 			out.println("<h3 align='center'>" + "adminEmail: " + adminEmail + "</h3>");
 		}
 		if (zkbEmail != null) {
 			out.println("<h3 align='center'>" + "zkbEmail: " + zkbEmail + "</h3>");
 		}
    %>
  </body>
</html>
