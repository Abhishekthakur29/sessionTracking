package com.abhiTech.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtility {
	private static Connection connection = null;

	private JdbcUtility() {

	}

	public static Connection getInstance() throws ClassNotFoundException, SQLException {
		if (connection == null) {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection("jdbc:mysql:///abhishekdb", "root", "root");
		}
		return connection;
	}
}
