package com.example.db;

import java.sql.*;

public class DBUtil {
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/beerv1";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static Connection connection;
	
	public DBUtil() {
		try {
			//1.������������
			Class.forName("com.mysql.jdbc.Driver");
			//2.������ݿ������
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

}
