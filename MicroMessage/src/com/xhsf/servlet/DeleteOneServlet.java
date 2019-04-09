package com.xhsf.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.xhsf.service.MainTainService;

/**
 *单个删除
 */
@SuppressWarnings("serial")
public class DeleteOneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("UTF-8");
		//获取页面的值
		String id = req.getParameter("id");
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		MainTainService mainTainService = new MainTainService();
		mainTainService.deleteOne(id);
		//给servlet传值
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		//页面跳转
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
