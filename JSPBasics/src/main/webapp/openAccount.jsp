<%@ page import="java.sql.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!

Connection connection;
PreparedStatement statement;

public void jspInit(){
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "test");
	statement = connection.prepareStatement("insert into account value (?, ?, ?,?)");
	}
	
	catch(Exception e){
		e.printStackTrace();
	}
	
}
public void jspDestroy(){
	try{
	statement.close();
	connection.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
%>

<%
int accno = Integer.parseInt(request.getParameter("accno"));
String lastName = request.getParameter("lastname");
String firstName = request.getParameter("firstname");
int bal = Integer.parseInt(request.getParameter("bal"));

statement.setInt(1, accno);
statement.setString(2, lastName);
statement.setString(3, firstName);
statement.setInt(4, bal);

statement.executeUpdate();

%>

<%@ include file="openaccount.html"%>