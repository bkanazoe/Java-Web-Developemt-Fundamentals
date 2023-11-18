package com.application.servlets;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = "/AdditionServlet")
public class AdditionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		if (request.getParameter("number1") !=null && request.getParameter("number2") != null) {
		Long num1 =  Long.parseLong(request.getParameter("number1"));
		Long num2 =  Long.parseLong(request.getParameter("number2"));
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("The result is " + (num1 + num2));
		writer.println("<html>");
		writer.println("<body>");
		
		}
		

		
	}

}
