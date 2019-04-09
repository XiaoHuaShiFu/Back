package com.example.model;

import java.sql.SQLException;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.example.action.UserAction;

public class User extends Person implements HttpSessionBindingListener{

	private String username;
	private String password;
	private int id;
	private Dog dog;
	
	public User() {
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(String name, String username, String password) {
		super(name);
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("User valueBound receive ");
		UserAction userAction = new UserAction();
		User user = new User(username, password);
		try {
			userAction.add(user);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("User valueUnbound receive ");
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", id=" + id + "]";
	}
	
}
