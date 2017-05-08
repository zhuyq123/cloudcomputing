package com.plat.dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  

import com.plat.app.*; 

public class AppDAOImpI implements IAppDAO {
	
	private Connection conn=null;   
    private PreparedStatement pstmt=null;  
    public AppDAOImpI(Connection conn){ 
    	this.conn=conn;  
    }

	@Override
	public boolean findApps(App app) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;  
        try {  
            String sql="select * from app where developer =? ";  
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,app.getDeveloper());               
            ResultSet rSet=pstmt.executeQuery();//取得结果   
            String name = "";
            String appPath = "";
            String content = "";
            String APPName = "";
            
            while(rSet.next()){
                name =  name + "!" + rSet.getString("name");
                appPath = appPath+ "!"+ rSet.getString("path") ;
                content = content + "!" + rSet.getString("content");
                APPName =  APPName +"!"+ rSet.getString("APPName");
            }
            System.out.println("name:"+name);
            System.out.println("Path:"+appPath);
            System.out.println("content: "+content);
            System.out.println("AppName:"+APPName);
            app.setName(name);
            app.setAppPath(appPath);
            app.setContent(content);
            app.setAPPName(APPName);           
            flag=true;             
            
        } catch (Exception e) {  
            throw e;  
        }finally{  
            
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
	public boolean addApp(App app) throws Exception {
		
		boolean flag=false;  
        try {  
            String sql="select * from app where appId > 16 ";  
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,app.getDeveloper());               
            ResultSet rSet=pstmt.executeQuery();//取得结果   
            String allname = "";
            String allappPath = "";
            String allcontent = "";
            String allAPPName = "";
            
            while(rSet.next()){
                allname =  allname + "!" + rSet.getString("name");
                allappPath = allappPath+ "!"+ rSet.getString("path") ;
                allcontent = allcontent + "!" + rSet.getString("content");
                allAPPName =  allAPPName +"!"+ rSet.getString("APPName");
            }
            System.out.println("name:"+allname);
            System.out.println("Path:"+allappPath);
            System.out.println("content: "+allcontent);
            System.out.println("AppName:"+allAPPName);
            app.setName(allname);
            app.setAppPath(allappPath);
            app.setContent(allcontent);
            app.setAPPName(allAPPName);           
            flag=true;             
            
        } catch (Exception e) {  
            throw e;  
        }finally{  
            
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
	public boolean getApp(App app) throws Exception {
		boolean flag =false;
		// TODO Auto-generated method stub
		 String sql="select * from app where developer =? ";  
         pstmt=conn.prepareStatement(sql);
         pstmt.setString(1,app.getDeveloper());               
         ResultSet rSet=pstmt.executeQuery();//取得结果   
         String name = "";
         String appPath = "";
         String content = "";
         String APPName = "";
         
         while(rSet.next()){
             name =  name + "!" + rSet.getString("name");
             appPath = appPath+ "!"+ rSet.getString("path") ;
             content = content + "!" + rSet.getString("content");
             APPName =  APPName +"!"+ rSet.getString("APPName");
         }
         System.out.println("name:"+name);
         System.out.println("Path:"+appPath);
         System.out.println("content: "+content);
         System.out.println("AppName:"+APPName);
         app.setName(name);
         app.setAppPath(appPath);
         app.setContent(content);
         app.setAPPName(APPName);           
         flag=true;   
		
		return flag;
	}
}
