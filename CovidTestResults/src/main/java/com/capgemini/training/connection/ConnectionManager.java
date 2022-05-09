package com.capgemini.training.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String url = "jdbc:mysql://localhost:3306/prelim_task_test_results_web_app";
	private static final String username = "root";
	private static final String password = "B1ackSm1th3ry";
	
	private static Connection connection;
	
	private static void makeConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		connection = DriverManager.getConnection(url, username, password);
	}
	
	public static Connection getConnection() {
		try {
			if (connection == null) {
				makeConnection();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
