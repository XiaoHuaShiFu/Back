package com.xhsf.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xhsf.bean.User;
import com.xhsf.db.DBAccess;
import com.xhsf.ds.TreeMap;

public class UserDao {
	
	public TreeMap<Integer, User> queryUserMap() {
		DBAccess dbAccess = new DBAccess();
		List<User> userList = new ArrayList<User>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			userList = sqlSession.selectList("User.queryUserList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		TreeMap<Integer, User> userMap = new TreeMap<Integer, User>();
		for (User user : userList) {
			userMap.add(user.getAccount(), user);
		}
		return userMap;
	}
	
	/**
	 * 添加用户到数据库
	 */
	public void add(User user) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.insert("User.insertUser", user);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 通过用户账号删除用户
	 */
	public void delete(Integer account) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("User.deleteUser", account);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 通过账号查询用户
	 * 如果用户不存在返回null
	 */
	public User query(int account) {
		UserDao userDao = new UserDao();
		TreeMap<Integer, User> userMap = userDao.queryUserMap();
		return userMap.query(account);
	}

}
