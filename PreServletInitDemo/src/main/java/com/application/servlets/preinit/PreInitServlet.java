package com.application.servlets.preinit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PreInitServlet
 */
//@WebServlet(urlPatterns = "/preInitServlet", loadOnStartup = 0)
public class PreInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public void init() {
	   
	   System.out.println("Inside the init method");
   }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().write("From the pre init servlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
