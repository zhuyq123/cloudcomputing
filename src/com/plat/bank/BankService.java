package com.plat.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.plat.api.DBUtil;

public class BankService {
	private Connection conn=null;   
    private PreparedStatement pstmt=null;  
   
	
	public boolean pay(String customer, String developer) {
		
		boolean flag = false;				
		try {
			
			int depositC = 0 ;
			int depositD = 0 ;
			conn = (Connection) DBUtil.getConnection();
			
			
			String sql0="select peanut from user where name = ? ";  
            pstmt=conn.prepareStatement(sql0);
            pstmt.setString(1,customer);                                     
            ResultSet rSetC=pstmt.executeQuery();
            if(rSetC.next()){ 
            	depositC = rSetC.getInt(1) - 5;            	
            } 
			
			String sql1="update user set peanut = ? where name = ?";  
            pstmt=conn.prepareStatement(sql1);
            pstmt.setInt(1,depositC);
            pstmt.setString(2,customer);                                     
            pstmt.executeUpdate();
            //ResultSet rSet=pstmt.executeQuery();//取得结果
            
            
            String sql2="select peanut from user where name = ? ";  
            pstmt=conn.prepareStatement(sql2);
            pstmt.setString(1,developer);                                     
            ResultSet rSetD=pstmt.executeQuery();
            if(rSetD.next()){ 
            	depositD = rSetD.getInt(1) + 2;            	
            } 
			
			String sql3="update user set peanut = ? where name = ?";  
            pstmt=conn.prepareStatement(sql3);
            pstmt.setInt(1,depositD);
            pstmt.setString(2,developer);                                     
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
