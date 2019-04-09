package com.xhsf.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.xhsf.bean.Message;
import com.xhsf.service.ListService;


/**
 * List控制器
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("UTF-8");
		//获取页面的值
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		//向页面传值
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		//查询信息列表并传值给页面
		ListService listService = new ListService();
		List<Message> messageList = null;
		messageList = listService.queryMessageList(command, description);
		if (messageList != null) {
			req.setAttribute("messageList", messageList);
		}
		//页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
