package com.application.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO{
	public static void main(String[] args) {
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root",
					"root");
			//System.out.println(connection);
			
			Statement createStatement = connection.createStatement();
			
			/*
			 * String createTable =
			 * "create table account (accno int, lastname varchar(25), firstname varchar(25), bal int)"
			 * ; createStatement.executeUpdate(createTable);
			 */
			
			int result = createStatement.executeUpdate("insert into account values(1, 'John', 'Miller', 1000)");
			System.out.println(result +  " rows got inserted");
			
			
			/*
			 * int result =
			 * createStatement.executeUpdate("update account set bal=5000 where accno=1");
			 * System.out.println(result + " rows got updated");
			 */
			
				/*
				 * int result =
				 * createStatement.executeUpdate("delete from account where accno=1");
				 * System.out.println(result + " rows got deleted");
				 */
			  
			  ResultSet resultSet = createStatement.executeQuery("select * from account");
			  while(resultSet.next()) {
				  System.out.println(resultSet.getString(2));
				  System.out.println(resultSet.getString(3));
				  System.out.println(resultSet.getString(4));
				  
			  }
			  
			  resultSet.close();
			  createStatement.close();
			  connection.close();
			  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
