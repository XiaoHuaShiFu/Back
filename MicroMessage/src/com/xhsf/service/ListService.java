package com.xhsf.service;

import java.util.List;

import com.xhsf.bean.Message;
import com.xhsf.dao.MessageDao;

/**
 * �б���ص�ҵ����
 */
public class ListService {
	
	private MessageDao messageDao;
	
	public ListService() {
		this.messageDao = new MessageDao();
	}
	
	public List<Message> queryMessageList(String command, String description) {
		return messageDao.queryMessageList(command, description);
	}
	
}
