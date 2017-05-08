package com.plat.dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  

import com.plat.user.*; 

public class UserDAOImpI implements IUserDAO{
	private Connection conn=null;   
    private PreparedStatement pstmt=null;  
    public UserDAOImpI(Connection conn){ 
    	this.conn=conn;  
    }
	@Override
	public boolean findLogin(User user) throws Exception {
		boolean flag=false;  
        try {  
            String sql="select userid,peanut,fullname from user where name=? and password=?";  
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());  
            pstmt.setString(2,user.getPassword());  
            ResultSet rSet=pstmt.executeQuery();  
            if(rSet.next()){ 
            	user.setUserid(rSet.getInt(1));                 
                user.setPeanut(rSet.getInt(2));
                user.setFullname(rSet.getString(3));
                flag=true;        
            }  
  
        } catch (Exception e) {  
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
	@Override
	public boolean addUser(User user) throws Exception{
		boolean flag=false;
		 try {  
			 	String exist = "select * from user where name = ?";
			 	pstmt=conn.prepareStatement(exist); 
		        pstmt.setString(1,user.getName()); 
		        ResultSet rSet=pstmt.executeQuery();
		        if(!rSet.next()){  
		        	System.out.println("charu");
		        	String sql="insert into user(name, password,peanut,email,fullname) values(?,?,?,?,?)";  
		            pstmt=conn.prepareStatement(sql);//实例化操作  
		            //pstmt.setString(1,"5");  
		            pstmt.setString(1,user.getName()); 
		            pstmt.setString(2,user.getPassword());
		            pstmt.setInt(3, 100);
		            pstmt.setString(4, user.getEmail());
		            pstmt.setString(5, user.getFullname());
		            pstmt.executeUpdate();
		            flag = true;	                        
	            } 
		       
	            //ResultSet rSet=pstmt.executeQuery();//取得结果   	              
	        } catch (Exception e) {  
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
	
	@Override
	public boolean peanut(User user) throws Exception {
		// TODO Auto-generated method stub
		String exist = "select peanut from user where name = ?";
	 	pstmt=conn.prepareStatement(exist); 
        pstmt.setString(1,user.getName()); 
        ResultSet rSet=pstmt.executeQuery();
        if(rSet.next()){
        	user.setPeanut(rSet.getInt(1));
        	return true;
        }				
		return false;
	}
}
