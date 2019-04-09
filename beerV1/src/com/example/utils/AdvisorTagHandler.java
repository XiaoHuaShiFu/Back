package com.example.utils;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AdvisorTagHandler extends SimpleTagSupport {
	
	private String user;
	
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().write("Hello " + user + " <br>");
		getJspContext().getOut().write("Your advice is: " + getAdvice());
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	String getAdvice() {
		String[] advices = {"That color's not working for you", 
				"You should call in sick.", 
				"You might want to rethink that haircut."};
		int random = (int) (Math.random() * advices.length);
		return advices[random];
	}
	
	
}
