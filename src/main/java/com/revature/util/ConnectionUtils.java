package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getConnection() throws SQLException
	{
		try {
			
			Class.forName("org.postgresql.Driver"); //This will give our application the drivers we need to connect to our PostgreSQL database
			
		} catch (ClassNotFoundException e) { //SQLException is just class that gets SQL errors specifically
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String url = System.getenv("URL");
		String username = System.getenv("DB_Username");
		String password = System.getenv("DB_Password");
		
		return DriverManager.getConnection(url, username, password);
	}
	
//  We just used this main method to test if our connection was working
//	public static void main(String[] args)
//	{
//		try (Connection conn = ConnectionUtils.getConnection()){
//			
//			System.out.println("Connection was Successful!");
//			
//			
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
}
