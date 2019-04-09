package com.example.web;

import java.util.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


import com.example.model.*;
import com.example.utils.CookieUtils;

public class BeerSelect extends HttpServlet {
	
	//此处不应该有实例参数
	private static final long serialVersionUID = 8449997020119126958L;

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	session.setMaxInactiveInterval(60);
    	Cookie[] cookies = request.getCookies();
    	
    	
    	CookieUtils cookieUtils = new CookieUtils();
    	String username = cookieUtils.getValue(cookies, "username");
    	String password = cookieUtils.getValue(cookies, "password");
    	if (username != null) {
    		request.setAttribute("username", username);
    	}
    	
    	
    	//使用监听者获取context-param
    	String adminEmail = (String) getServletContext().getAttribute("adminEmail");
    	String zkbEmail = getServletConfig().getInitParameter("zkbEmail");
    	request.setAttribute("adminEmail", adminEmail);
    	request.setAttribute("zkbEmail", zkbEmail);
    	
    	String counts = String.valueOf(com.example.BeerSessionCounter.getActiveSessions());
    	request.setAttribute("counts", counts);
    	
    	if (session.isNew()) {
    		String color = request.getParameter("color");
         	BeerExpert beerExpert = new BeerExpert();
        	List<String> styles = beerExpert.getBrands(color);
        	
        	request.setAttribute("styles", styles);
        	session.setAttribute("color", color);
    		User user = new User(username, password);
    	    session.setAttribute("user", user);
        	
//        	response.encodeRedirectURL("/SelectBeer.do");
        	RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        	view.forward(request, response);
    	} else {
    		String color = (String) session.getAttribute("color");
			List<String> styles = (List<String>) session.getAttribute("styles");
    		String body = request.getParameter("body");
    		String price = request.getParameter("price");
        	
        	BeerExpert beerExpert = new BeerExpert();
        	List<String> varieties = beerExpert.getVarieties(color, price);
        	

        	request.setAttribute("color", color);
        	request.setAttribute("styles", styles);
        	request.setAttribute("varieties", varieties);
        	request.setAttribute("body", body);
        	request.setAttribute("price", price);
        	
//        	response.encodeRedirectURL("/SelectBeer.do");
//        	session.invalidate();
        	RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        	view.forward(request, response);
    	}
    	
    }

}

/*
 * @Override protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * 
 * }
 * 
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * 
 * }
 */


/*response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("Beer Selection Advice<br>");

Iterator<String> iterator = result.iterator();
while (iterator.hasNext()) {
	out.println("<br>try:" + iterator.next());
}*/

//请求其他格式的内容
/*response.setContentType("application/java");
ServletContext context = getServletContext();
InputStream is = context.getResourceAsStream("/BeerExpert.java");

int read = 0;
byte[] bytes = new byte[1024];

OutputStream os = response.getOutputStream();
while ((read = is.read(bytes)) != -1) {
	os.write(bytes, 0, read);
}
os.flush();
os.close();*/

//获取context参数
//String adminEmail = getServletContext().getInitParameter("adminEmail");

/*	//得到所有initParam的名字
@SuppressWarnings("unchecked")
Enumeration<String> emails = (Enumeration<String>) getServletConfig().getInitParameterNames();
String servletName = getServletConfig().getServletName();*/

//重定向
//response.sendRedirect("https://www.baidu.com/");


//打印头部信息
/*StringBuilder info = new StringBuilder();
info.append("User-Agent:" + request.getHeader("User-Agent"));
info.append("<br>Method:" + request.getMethod());
info.append("<br>Content-Length:" + request.getIntHeader("Content-Length"));
info.append("<br>Max-Forwards:" + request.getIntHeader("Max-Forwards"));
info.append("<br>ServerPort:" + request.getServerPort());
info.append("<br>LocalPort:" + request.getLocalPort());
info.append("<br>RemotePort:" + request.getRemotePort());
request.setAttribute("info", info.toString());*/

