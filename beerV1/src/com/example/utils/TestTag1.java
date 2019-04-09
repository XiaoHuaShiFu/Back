package com.example.utils;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestTag1 extends SimpleTagSupport {
	
	private String[] movies;

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		for (String movie : movies) {
			getJspContext().setAttribute("movie", movie);
			getJspBody().invoke(null);
		}
	}
	
	public void setMovies(String[] movies) {
		this.movies = movies;
	}
	
	
	
}
