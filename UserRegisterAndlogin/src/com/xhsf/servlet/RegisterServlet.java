package com.xhsf.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*; 

import com.xhsf.service.UserService;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("UTF-8");
		//获取页面的值
		String username = req.getParameter("username");
		String sex = req.getParameter("sex");
		String password = req.getParameter("password");
		//向页面传值
		req.setAttribute("username", username);
		req.setAttribute("sex", sex);
		req.setAttribute("password", password);
		//查询信息列表并传值给页面
		UserService userService = new UserService();
		Integer account = userService.add(username, password, sex);
		if (account == -1) {
			req.setAttribute("prompt", "请补充完整表格信息");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
		req.setAttribute("account", account);
		//页面跳转
		req.getRequestDispatcher("/success.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
