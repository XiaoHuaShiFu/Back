package com.example.utils;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestTag2 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		getJspContext().getOut().print("Message from within TestTag2");
		/*getJspContext().getOut().print("Message from within TestTag2" + getJspBody().getJspContext().getAttribute("adminEmail"));*/
		throw new SkipPageException();
	}

}
