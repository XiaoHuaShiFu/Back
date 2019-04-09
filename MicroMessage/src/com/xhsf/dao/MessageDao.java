package com.xhsf.dao;

import java.util.*;

import org.apache.ibatis.session.SqlSession;

import com.xhsf.bean.Message;
import com.xhsf.db.DBAccess;

/**
 * ��Message��ص����ݿ����
 */

public class MessageDao {
	
	/**
	 * ͨ���ֶβ�ѯ����
	 */
	public List<Message> queryMessageList(String command, String description) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			/**
			 * �ӿ�ʽ����mybatis
			 */
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			messageList = iMessage.queryMessageList(message);
			/*messageList = sqlSession.selectList("com.xhsf.dao.IMessage.queryMessageList",message);*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/**
	 *  ͨ��idɾ��һ������
	 */
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteOne", id);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	public void deleteBatch(List<Integer> idList) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteBatch", idList);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	

}
/**
 * ���ݲ�ѯ������ѯ�б�
 * @throws ClassNotFoundException 
 * @throws SQLException 
 */
/*public List<Message> queryMessageList(String command, String description) {
	StringBuilder sql = new StringBuilder("" + 
			" SELECT id, command, description, content FROM message " + 
			" WHERE 1 = 1 ");
	List<String> paramList = new ArrayList<String>(); 
	if ( null != command && !"".equals(command.trim())) {
		sql.append(" and command = ? ");
		paramList.add(command);
	}
	if ( null != description && !"".equals(description.trim())) {
		sql.append(" and description like ? ");
		paramList.add("%" + description + "%");
	}
	List<Message> messageList = new ArrayList<Message>();
	try {
		PreparedStatement statement = conn.prepareStatement(sql.toString());
		for (int i = 0; i < paramList.size(); i++) {
			statement.setString(i + 1, paramList.get(i));
		}
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			Message message = new Message();
			message.setId(rs.getInt("id"));
			message.setCommand(rs.getString("command"));
			message.setDescription(rs.getString("description"));
			message.setContent(rs.getString("content"));
			messageList.add(message);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return messageList;
}*/
