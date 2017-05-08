package com.plat.api;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
		public static Connection getConnection() throws Exception{
			String driver = "com.mysql.jdbc.Driver";
			String username = "root";
			String password = "mysql";
			String url = "jdbc:mysql://localhost:3306/example";
			Connection conn;
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, username, password);
				return conn;
			} catch (Exception e) {
				
				e.printStackTrace();
				throw e;
			}
			
			
	    }


	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void close(PreparedStatement pres){
		if(pres != null){
			try {
				pres.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void close(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
	}


}


