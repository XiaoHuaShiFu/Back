package com.example.dao;

import java.sql.*;

import com.example.db.DBUtil;
import com.example.model.User;

public class UserDao {
	
	private Connection connection;
	
	public UserDao() {
		DBUtil dbUtil = new DBUtil();
		connection = dbUtil.getConnection();
	}
	
	public void add(User user) throws SQLException {
		String sql = "" + 
				" insert into user(username, password)" + 
				" values(?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.execute();
	}
	
}
