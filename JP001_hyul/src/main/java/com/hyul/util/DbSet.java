package com.hyul.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbSet {
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_ID = "hyul";
	private static final String DB_PW = "1234";
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
			return conn;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
