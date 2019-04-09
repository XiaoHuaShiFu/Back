package com.xhsf.service;

import com.xhsf.bean.User;
import com.xhsf.dao.UserDao;

public class UserService {
	
	/**
	 * ����û�
	 */
	public Integer add(String username, String password, String sex) {
		if ("".equals(username.trim()) || "".equals(password.trim()) || "".equals(sex.trim())) {
			return -1;
		}
		UserDao userDao = new UserDao();
		Integer account;
		User user;
		do {
			account = (int)(Math.random() * 10000);
			user = userDao.query(account);
		} while(user != null);
		user = new User(account, username, password, sex);
		userDao.add(user);
		return account;
	}
	
	/**
	 * ͨ���û��˺�ɾ���û�
	 */
	public void delete(Integer account) {
		UserDao userDao = new UserDao();
		userDao.delete(account);
	}
	
	/**
	 * ͨ���˺Ų�ѯ�û�
	 * ����û������ڷ���null
	 */
	public User query(Integer account) {
		UserDao userDao = new UserDao();
		return userDao.query(account);
	}
	
	/**
	 * �û���¼������˺�������󷵻�null
	 * @param account
	 * @param password
	 * @return User
	 */
	public User log(String account, String password) {
		User user = this.query(Integer.valueOf(account));
		if (user == null) {
			return null;
		}
		if (user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}
	}
	
}
