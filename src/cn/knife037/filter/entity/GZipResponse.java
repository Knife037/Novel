package cn.knife037.filter.entity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GZipResponse extends HttpServletResponseWrapper {

	ByteArrayOutputStream baos = null;
	PrintWriter pw = null;
	
	public GZipResponse(HttpServletResponse response) {
		super(response);
		baos = new ByteArrayOutputStream();
	}

	public byte[] getBytes() {
		if(pw != null) {
			pw.flush();
		}
		return baos.toByteArray();
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		if(pw == null) {
			pw = new PrintWriter(baos);
		}
		return pw;
	}
	
}
