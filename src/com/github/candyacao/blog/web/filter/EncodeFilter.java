package com.github.candyacao.blog.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class EncodeFilter
 */
@WebFilter(value={"/*"},initParams= {@WebInitParam(name="encode",value="UTF-8")})
public class EncodeFilter implements Filter {
	String encode;
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//编码
		request.setCharacterEncoding(encode);
		response.setCharacterEncoding(encode);
		// 设置浏览器读取时，内容以及编码类型
		//response.setContentType("text/html;charset=UTF-8");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		encode = fConfig.getInitParameter("encode");
	}

}
