package com.xhsf.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.xhsf.service.QueryService;

@SuppressWarnings("serial")
public class AutoReplyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		QueryService queryService = new QueryService();
		String command = req.getParameter("content");
		if (command != null) {
			out.write(queryService.queryByCommand(command));
		}
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
