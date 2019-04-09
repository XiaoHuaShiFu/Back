package com.xhsf.service;

import java.util.List;

import com.xhsf.bean.Message;
import com.xhsf.dao.MessageDao;

/**
 * 列表相关的业务功能
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
