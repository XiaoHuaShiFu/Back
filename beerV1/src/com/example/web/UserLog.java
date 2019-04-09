package com.example.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.example.model.User;

public class UserLog extends HttpServlet {
	
	private static final long serialVersionUID = 1682330241326069796L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	session.setMaxInactiveInterval(60);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Cookie cookieUsername = new Cookie("username", username);
		Cookie cookiePassword = new Cookie("password", password);
		cookieUsername.setMaxAge(120);
		cookiePassword.setMaxAge(120);
		response.addCookie(cookieUsername);
		response.addCookie(cookiePassword);
		
		User user = new User(username, password);
		user.setName("wjx");
    	session.setAttribute("user", user);
    	
		
		RequestDispatcher view = request.getRequestDispatcher("form.html");
		view.forward(request, response);
	}

}
