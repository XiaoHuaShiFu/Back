package com.xhsf.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.xhsf.bean.Message;
import com.xhsf.service.ListService;


/**
 * List������
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����
		req.setCharacterEncoding("UTF-8");
		//��ȡҳ���ֵ
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		//��ҳ�洫ֵ
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		//��ѯ��Ϣ�б���ֵ��ҳ��
		ListService listService = new ListService();
		List<Message> messageList = null;
		messageList = listService.queryMessageList(command, description);
		if (messageList != null) {
			req.setAttribute("messageList", messageList);
		}
		//ҳ����ת
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
