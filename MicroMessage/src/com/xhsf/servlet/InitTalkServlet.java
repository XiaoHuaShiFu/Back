package com.xhsf.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;


/**
 * �Ի�ҳ�ĳ�ʼ��ҳ��
 *
 */

@SuppressWarnings("serial")
public class InitTalkServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����
		req.setCharacterEncoding("UTF-8");
		//ҳ����ת
		req.getRequestDispatcher("/WEB-INF/jsp/front/talk.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
