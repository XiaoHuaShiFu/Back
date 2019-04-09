package com.example.action;

import java.sql.SQLException;

import com.example.dao.UserDao;
import com.example.model.User;

public class UserAction {
	
	private UserDao userDao;
	
	public UserAction() {
		UserDao userDao = new UserDao();
		this.userDao = userDao;
	}
	
	public void add(User user) throws SQLException {
		this.userDao.add(user);
	}
	
}
