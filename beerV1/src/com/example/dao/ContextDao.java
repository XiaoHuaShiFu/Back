package com.example.dao;

import java.sql.*;

import com.example.db.DBUtil;
import com.example.model.Context;

public class ContextDao {

	private Connection connection;
	
	public ContextDao() {
		DBUtil dbUtil = new DBUtil();
		connection = dbUtil.getConnection();
	}
	
	public Context query(String paramName) throws SQLException {
		String sql = "" + 
				" select * from context_param" + 
				" where param_name = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, paramName);
		ResultSet resultSet =  preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			Context context = new Context();
			context.setAdminEmail(resultSet.getString("param_value"));
			return context;
		}
		return null;
	}
	
}
