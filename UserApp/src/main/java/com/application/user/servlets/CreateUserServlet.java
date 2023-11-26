package com.application.user.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;



/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet(urlPatterns = "/addServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	
	
	public void init(ServletConfig config) {
		
		try {
			
			ServletContext context = config.getServletContext();
			
			Enumeration<String> initParameterNames = context.getInitParameterNames();
			
			while (initParameterNames.hasMoreElements()) {
				
				String element = initParameterNames.nextElement();
				System.out.println("Context Param Name: " + element);
				System.out.println("context Param Value: " + context.getInitParameter(element));
			}
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"),
					context.getInitParameter("dbUser"),
					context.getInitParameter("dbPassword"));
			connection.setAutoCommit(true);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
         String firstName = request.getParameter("firstName");
         String lastName = request.getParameter("lastName");
         String email = request.getParameter("email");
         String password = request.getParameter("password");
         
         try {
        	Statement createStatement = connection.createStatement();
        	 int result = createStatement.executeUpdate("insert into user values('" + firstName+"','"+lastName+"','"+email+"','"+password+"')" );
        	
        	 
        	 PrintWriter out = response.getWriter();
        	 if (result >0) {
        		 out.print("<h1>User created<h1>");
        	 }
        	 
        	 else {
        		 out.println("<h1>Error Creating the user</h1>");
        	 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
