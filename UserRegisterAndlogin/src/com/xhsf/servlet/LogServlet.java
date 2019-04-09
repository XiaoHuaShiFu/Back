package com.xhsf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhsf.bean.User;
import com.xhsf.service.UserService;

@SuppressWarnings("serial")
public class LogServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("UTF-8");
		//获取页面的值
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		//向页面传值
		req.setAttribute("account", account);
		//查询信息列表并传值给页面
		UserService userService = new UserService();
		User user = userService.log(account, password);
		if (user == null) {
			req.setAttribute("prompt", "请输入正确的账号密码");
			req.getRequestDispatcher("/log.jsp").forward(req, resp);
		}
		req.setAttribute("user", user);
		//页面跳转
		req.getRequestDispatcher("/logSuccess.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
