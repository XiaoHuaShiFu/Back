package com.xhsf.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*; 

import com.xhsf.service.UserService;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����
		req.setCharacterEncoding("UTF-8");
		//��ȡҳ���ֵ
		String username = req.getParameter("username");
		String sex = req.getParameter("sex");
		String password = req.getParameter("password");
		//��ҳ�洫ֵ
		req.setAttribute("username", username);
		req.setAttribute("sex", sex);
		req.setAttribute("password", password);
		//��ѯ��Ϣ�б���ֵ��ҳ��
		UserService userService = new UserService();
		Integer account = userService.add(username, password, sex);
		if (account == -1) {
			req.setAttribute("prompt", "�벹�����������Ϣ");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
		req.setAttribute("account", account);
		//ҳ����ת
		req.getRequestDispatcher("/success.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
