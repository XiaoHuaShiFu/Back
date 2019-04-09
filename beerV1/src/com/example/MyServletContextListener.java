package com.example;

import java.sql.SQLException;

import javax.servlet.*;

import com.example.action.ContextAction;
import com.example.model.Context;

public class MyServletContextListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		String adminEmail = servletContext.getInitParameter("adminEmail");
		ContextAction contextAction = new ContextAction();
		Context context = null;
		try {
			context = contextAction.query(adminEmail);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (context != null) {
			servletContext.setAttribute("adminEmail", context.getAdminEmail());
		}
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		
	}
	
	
}
