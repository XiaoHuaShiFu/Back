package com.example.action;

import java.sql.SQLException;

import com.example.dao.ContextDao;
import com.example.model.Context;

public class ContextAction {
	
	private ContextDao contextDao;
	
	public ContextAction() {
		ContextDao contextDao = new ContextDao();
		this.contextDao = contextDao;
	}
	
	public Context query(String param_value) throws SQLException {
		return this.contextDao.query(param_value);
	}
	
}
