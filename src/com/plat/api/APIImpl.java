package com.plat.api;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  


public class APIImpl  implements API{
	private Connection conn=null;   
    private PreparedStatement pstmt=null;  
    public APIImpl(Connection conn){ 
    	this.conn=conn;
    }


	@Override
	public boolean createUser(String username, String password, String database)
			throws Exception {
			boolean flag=false;  
	        try {  
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
	        }
	        catch (Exception e) {  
	            throw e;  
	        }finally{  
	            //关闭操作  
	            if(pstmt!=null){  
	                try {  
	                    pstmt.close();  
	                } catch (Exception e) {  
	                    throw e;                  
	                }                  
	            }  
	        }
	        return flag;
	    }
	
}
	

