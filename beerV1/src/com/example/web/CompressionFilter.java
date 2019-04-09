package com.example.web;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.*;
import javax.servlet.http.*;

public class CompressionFilter implements Filter{
	
	private ServletContext ctx;
	private FilterConfig cfg;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.cfg = filterConfig;
		ctx = cfg.getServletContext();
		ctx.log(cfg.getFilterName() + " initialized.");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String valid_encodings = request.getHeader("Accept-Encoding");
		if (valid_encodings.indexOf("gzip") > -1) {
			CompressionResponseWrapper wrappedResponse = new CompressionResponseWrapper(response);
			wrappedResponse.setHeader("Content-Encoding", "gzip");
			fc.doFilter(request, wrappedResponse);
			
			GZIPOutputStream gzos = wrappedResponse.getGzipOutputStream();
			gzos.finish();
			ctx.log(cfg.getFilterName() + ":finished the request.");
		} else {
			ctx.log(cfg.getFilterName() + ": no encoding performed.");
			fc.doFilter(request, response);
		}
	}

	public void destroy() {
		cfg = null;
		ctx = null;
	}
	
}
