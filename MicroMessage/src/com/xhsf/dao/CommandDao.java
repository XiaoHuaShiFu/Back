package com.xhsf.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xhsf.bean.Command;
import com.xhsf.bean.Content;
import com.xhsf.db.DBAccess;

/**
 * 与Command相关的数据库操作
 */
public class CommandDao {
	
	/**
	 * 
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Command> queryCommandList(String name, String description) {
		DBAccess dbAccess = new DBAccess();
		List<Command> commandList = new ArrayList<Command>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Command command = new Command();
			command.setName(name);
			command.setDescription(description);
			commandList = sqlSession.selectList("Command.queryCommandList", command);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return commandList;
	}
	
	public int queryCommandId(String name) {
		DBAccess dbAccess = new DBAccess();
		int id = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			id = sqlSession.selectOne("Command.queryCommandId", name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return id;
	}
	
	public void insertContent(String name, String content) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Content cont = new Content();
			cont.setContent(content);
			cont.setCommandId(queryCommandId(name));
			sqlSession.insert("Command.insertContent", cont);
			sqlSession.commit();
			System.out.println(cont.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
	}
	
	/*public static void main(String[] args) {
		CommandDao commandDao = new CommandDao();
		commandDao.insertContent("段子", "段子内容4");
		System.out.println(commandDao.queryCommandId("新闻"));
	}*/
	
}
