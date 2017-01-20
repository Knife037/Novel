package cn.knife037.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.knife037.filter.entity.GZipResponse;

/**
 * Servlet Filter implementation class GZipFilter
 */
@WebFilter("/*")
public class GZipFilter implements Filter {

    /**
     * Default constructor. 
     */
    public GZipFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		GZipResponse gzipResponse = new GZipResponse(response);
		
		chain.doFilter(request, gzipResponse);
		
		byte[] bytes = gzipResponse.getBytes();
		
		gzipResponse.getWriter().close();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		GZIPOutputStream gos = new GZIPOutputStream(baos);
		gos.write(bytes);
		gos.finish();
		gos.flush();
		gos.close();
		bytes = baos.toByteArray();
		
		response.setHeader("Content-Encoding", "gzip");
		response.setContentLength(bytes.length);
	    
		ServletOutputStream sos = response.getOutputStream();
		sos.write(bytes);
		sos.flush();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
