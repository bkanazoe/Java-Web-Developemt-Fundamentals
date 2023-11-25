package com.application.interservletcommunication;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class LoginServlwet
 */
@WebServlet("/loginServlet")
public class LoginServlwet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
			
			Statement createStatement = con.createStatement();
			
			ResultSet resultSet = createStatement.executeQuery("select * from user where email='"+userName+"' and password='"+password+"'");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeServlet");
			
			if(resultSet.next()) {
				request.setAttribute("message", "Welcome to Intercommunication " + userName);
				requestDispatcher.forward(request, response);
			}
			
			else {
				 requestDispatcher = request.getRequestDispatcher("login.html");
				 requestDispatcher.include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
