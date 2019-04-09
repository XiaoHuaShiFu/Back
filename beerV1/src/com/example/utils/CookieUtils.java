package com.example.utils;

import javax.servlet.http.*;

public class CookieUtils {
	
	public CookieUtils() {
	}
	
	public String getValue(Cookie[] cookies, String name) {
		if (cookies != null) {
    		for (int i = 0; i < cookies.length; i++) {
    			Cookie cookie = cookies[i];
    			if (cookie.getName().equals(name)) {
    				return cookie.getValue();
    			}
    		}
    	}
		return null;
	}
	
}
