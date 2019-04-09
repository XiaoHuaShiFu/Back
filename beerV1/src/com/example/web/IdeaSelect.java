package com.example.web;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.example.model.*;
import com.example.utils.*;

public class IdeaSelect extends HttpServlet {
	
	private static final long serialVersionUID = 2392872503770983536L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Cookie[] cookies = request.getCookies();
    	
    	CookieUtils cookieUtils = new CookieUtils();
    	String username = cookieUtils.getValue(cookies, "username");
    	String password = cookieUtils.getValue(cookies, "password");
    	if (username != null && password != null) {
    		User user = new User(username, password);
    		Dog dog = new Dog();
    		dog.setName("wangwang");
    		user.setDog(dog);
    		
    		HashMap<String, String> dogMap = new HashMap<String, String>();
        	dogMap.put("Creative creativity", "wangwang");
        	
        	request.setAttribute("dogMap", dogMap);
    		request.setAttribute("user", user);
    	}
    	
    	String[] dogTypes = {"Creative creativity"};
    	request.setAttribute("dogTypes", dogTypes);
    	
    	String[] movieList1 = {"Amelie", "Return of the King", "Mean Girls"};
    	String[] movieList2 = {"Matrix Revolutions", "Kill Bill", "Boodock Saints"};
    	List<String[]> movieList = new ArrayList<String[]>();
    	movieList.add(movieList1);
    	movieList.add(movieList2);
    	request.setAttribute("movies", movieList1);
     	request.setAttribute("movieList", movieList);
    	
    	String ideaType = request.getParameter("ideaType");
    	request.setAttribute("ideaType", ideaType);
    	
    	RequestDispatcher view = request.getRequestDispatcher("ideaSelectResult.jsp");
    	view.forward(request, response);
    	
	}
	

	
}
