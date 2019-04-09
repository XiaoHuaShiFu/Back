package com.xhsf.service;

import java.util.ArrayList;
import java.util.List;

import com.xhsf.dao.CommandDao;
import com.xhsf.dao.MessageDao;

/**
 *ά����ص�ҵ��
 *
 */

public class MainTainService {
	
	/**
	 * ����servlet��������ֵ����ֵ���д���
	 * @param id
	 */
	public void deleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
		}
	}
	
	public void deleteBatch(String[] ids) {
		MessageDao messageDao = new MessageDao();
		List<Integer> idList = new ArrayList<Integer>();
		for (String id : ids) {
			idList.add(Integer.valueOf(id));
		}
		messageDao.deleteBatch(idList);
	}
	
	public void insertContent(String name, String content) {
		CommandDao commandDao = new CommandDao();
		commandDao.insertContent(name, content);
	}
	
	
}
