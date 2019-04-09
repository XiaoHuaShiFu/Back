package com.xhsf.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.xhsf.service.MainTainService;

/**
 *����ɾ��
 */
@SuppressWarnings("serial")
public class DeleteOneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����
		req.setCharacterEncoding("UTF-8");
		//��ȡҳ���ֵ
		String id = req.getParameter("id");
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		MainTainService mainTainService = new MainTainService();
		mainTainService.deleteOne(id);
		//��servlet��ֵ
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		//ҳ����ת
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
