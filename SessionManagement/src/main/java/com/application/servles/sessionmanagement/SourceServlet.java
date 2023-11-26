package com.application.servles.sessionmanagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

/**
 * Servlet implementation class SourceServlet
 */
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			
			System.out.println(cookies[i].getName());
			System.out.println(cookies[i].getValue());
			
		}
		
		response.addCookie(new Cookie("securityToken", "12345"));
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		session.setAttribute("user", userName);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String url = "targetServlet?sessionId=123";
		out.print("<a href='"+url+"'>Click here to get the User Name</a>");
	
	}

}
