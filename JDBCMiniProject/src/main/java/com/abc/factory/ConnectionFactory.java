package com.abc.factory;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class ConnectionFactory {
	private static Connection con=null;
	static {
		try {
			OracleDataSource ds = new OracleDataSource();
			ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ds.setUser("system");
			ds.setPassword("tiger");
			con = ds.getConnection();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
}
