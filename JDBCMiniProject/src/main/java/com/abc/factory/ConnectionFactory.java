package com.abc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection con=null;
	static {
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
}
