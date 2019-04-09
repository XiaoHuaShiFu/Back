package com.example.utils;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		getJspContext().setAttribute("message", "Wear sunscreeen");
		//处理标记的体，并打印倒响应
		getJspBody().invoke(null);
	}
	
}
