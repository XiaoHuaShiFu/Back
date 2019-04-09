package com.example;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class BeerSessionCounter implements HttpSessionListener{
	
	private static int activeSessions = 0;
	
	public static int getActiveSessions() {
		return activeSessions;
	}
	
	public void sessionCreated(HttpSessionEvent event) {
		activeSessions++;
	}
	
	public void sessionDestroyed(HttpSessionEvent event) {
		activeSessions--;
	}
	
}
