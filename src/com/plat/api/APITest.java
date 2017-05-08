package com.plat.api;

import java.sql.Connection; 
import java.sql.PreparedStatement; 

public class APITest {
	private Connection conn=null;   
    private PreparedStatement pstmt=null;  
   
	
	public boolean createUser(String username, String password, String database) {
		
		boolean flag = false;				
		try {
			conn = (Connection) DBUtil.getConnection();
			String sql1="CREATE USER ?@'localhost' IDENTIFIED BY ?;";  
            pstmt=conn.prepareStatement(sql1);
            pstmt.setString(1,username);
            pstmt.setString(2,password);                          
            pstmt.executeUpdate();
            
            String sql2="create schema "+ database +";";
            pstmt=conn.prepareStatement(sql2);
            //pstmt.setString(1,"app1");                                     
            pstmt.executeUpdate();
            
            
            String sql3="GRANT ALL PRIVILEGES ON "+database+" . * TO ?@'localhost';";
            pstmt=conn.prepareStatement(sql3);
            //pstmt.setString(1,database);
            pstmt.setString(1,username);                          
            pstmt.executeUpdate();
            flag = true;

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				DBUtil.close(pstmt);
				DBUtil.close(conn);
		}	
		return flag;
	}
}
