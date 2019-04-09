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
		//����
		req.setCharacterEncoding("UTF-8");
		//��ȡҳ���ֵ
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		//��ҳ�洫ֵ
		req.setAttribute("account", account);
		//��ѯ��Ϣ�б���ֵ��ҳ��
		UserService userService = new UserService();
		User user = userService.log(account, password);
		if (user == null) {
			req.setAttribute("prompt", "��������ȷ���˺�����");
			req.getRequestDispatcher("/log.jsp").forward(req, resp);
		}
		req.setAttribute("user", user);
		//ҳ����ת
		req.getRequestDispatcher("/logSuccess.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
