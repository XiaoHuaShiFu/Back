package com.example;

import javax.servlet.http.*;

public class BeerAttributeListener implements HttpSessionAttributeListener{

	public void attributeAdded(HttpSessionBindingEvent event) {
		String name = event.getName();
		System.out.println("BeerAttributeListener attributeAdded name:" + name);
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}

}
