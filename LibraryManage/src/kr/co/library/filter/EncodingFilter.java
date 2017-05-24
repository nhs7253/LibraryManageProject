package kr.co.library.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

	private String encoding;
	
	@Override
	public void destroy() {
//		System.out.println("EncodingFilter.destroy() 실행");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("EncodingFilter.doFilter()-전처리작업");
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
//		System.out.println("EncodingFilter.doFilter()-후처리작업");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.encoding = config.getInitParameter("encoding");
//		System.out.println("EncodingFilter.init()실행"+encoding);
	}

}
