package com.application.servlets.jdbc.preparedstatment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateProductServlet")
public class updateProductServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	Connection connection ;
	PreparedStatement statement;
	
	
	public void init(GenericServlet config) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
			statement = connection.prepareStatement("update product set price=? where id=?");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		int price = Integer.parseInt(req.getParameter("price"));
		
		try {
			statement.setInt(1, price);
			statement.setInt(2, id);
			
			int result = statement.executeUpdate();
			
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.print("<h1>"+result + "Product Updated </h1>" );
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}
	
	public void destroy() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
