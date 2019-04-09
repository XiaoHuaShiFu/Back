package com.xhsf.dao;

import java.util.List;

import com.xhsf.bean.Message;

public interface IMessage {
	public List<Message> queryMessageList(Message message);
}
