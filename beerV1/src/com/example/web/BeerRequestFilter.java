package com.example.web;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class BeerRequestFilter implements Filter{

	private FilterConfig fc;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String name = httpRequest.getRemoteUser();
		if (name != null) {
			fc.getServletContext().setAttribute("FilterInfo", "this is filter info" + name);
			fc.getServletContext().log("User " + name + " is updating");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		this.fc = config;
	}
	
	public void destroy() {
	}
	
}
