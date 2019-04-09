package com.example.web;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CompressionResponseWrapper extends HttpServletResponseWrapper {
	
	//servlet响应的压缩输出流
	private GZIPServletOutputStream servletGzipOS = null;
	//压缩输出流的PrintWriter对象
	private PrintWriter pw = null;
	
	public CompressionResponseWrapper(HttpServletResponse response) {
		super(response);
	}
	
	public void setContentLength(int len) {
	}
	
	public GZIPOutputStream getGzipOutputStream() {
		return this.servletGzipOS.internalGzipOS;
	}
	
	private Object streamUsed = null;
	
	public ServletOutputStream getOutputStream() throws IOException {
		if ((streamUsed != null) && (streamUsed != pw)) {
			throw new IllegalStateException();
		}
		
		if (servletGzipOS == null) {
			servletGzipOS = new GZIPServletOutputStream(getResponse().getOutputStream());
			streamUsed = servletGzipOS;
		}
		return servletGzipOS;
	}
	
	public PrintWriter getWriter() throws IOException {
		if ((streamUsed != null) && (streamUsed != servletGzipOS)) {
			throw new IllegalStateException();
		}
		
		if (pw == null) {
			servletGzipOS = new GZIPServletOutputStream(getResponse().getOutputStream());
			OutputStreamWriter osw = new OutputStreamWriter(servletGzipOS, getResponse().getCharacterEncoding());
			pw = new PrintWriter(osw);
			streamUsed = pw;
		}
		
		return pw;
	}
	

}
