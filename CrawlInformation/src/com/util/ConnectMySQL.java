package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQL {
	static final String USER = "root";
	static final String PASS = "";
	static final String DB = "jdbc:mysql://localhost:3306/google";
	static final String sql_class = "com.mysql.jdbc.Driver";
	
	public Connection ConnectSQL() throws SQLException{
		Connection conn = null;
		try{
			Class.forName(sql_class);
			conn = DriverManager.getConnection(DB, USER, PASS);
		}catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		}
		return conn;
	}
}
