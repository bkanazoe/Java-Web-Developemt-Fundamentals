package com.application.servlets.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter("/FilterDemoServlet")
public class DemoFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest rquest, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		out.println("Pre Servlet");
		chain.doFilter(rquest, response);
		out.println("Post Servlet");
			
		
	}

}
