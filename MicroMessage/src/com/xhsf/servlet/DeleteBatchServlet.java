package com.xhsf.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.xhsf.service.MainTainService;

/**
 * ����ɾ��
 */
@SuppressWarnings("serial")
public class DeleteBatchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����
		req.setCharacterEncoding("UTF-8");
		//��ȡҳ���ֵ
		String[] ids = req.getParameterValues("ids");
		MainTainService mainTainService = new MainTainService();
		mainTainService.deleteBatch(ids);
		//ҳ����ת
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
