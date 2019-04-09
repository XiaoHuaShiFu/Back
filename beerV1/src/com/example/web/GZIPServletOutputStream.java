package com.example.web;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;

public class GZIPServletOutputStream extends ServletOutputStream {

	GZIPOutputStream internalGzipOS;
	
	/**
	 * 装饰器构造函数
	 * @param sos
	 * @throws IOException
	 */
	public GZIPServletOutputStream(ServletOutputStream sos) throws IOException {
		this.internalGzipOS = new GZIPOutputStream(sos);
	}
	
	@Override
	public void write(int param) throws IOException {
		internalGzipOS.write(param);
	}

}
