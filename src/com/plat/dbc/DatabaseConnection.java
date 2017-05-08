package com.plat.dbc;

import java.sql.Connection;  
import java.sql.DriverManager;

public class DatabaseConnection {

	 
    private static final String DBDRIVER="com.mysql.jdbc.Driver";  
   
    private static final String DBURL="jdbc:mysql://localhost/cloud?user=rootname&password=zhuyq";//example表示数据库  
    private static final String DBUSER="root";  
    private static final String DBPASS="mysql";  
    private Connection connection=null;  
    public DatabaseConnection() throws Exception{  
        try{  
            
            Class.forName(DBDRIVER);  
            connection=DriverManager.getConnection(DBURL,DBUSER,DBPASS);                
        	}catch(Exception exception ){  
        		throw exception;  
        	} finally {  
        }     
    }  
    public Connection getConnection(){  
        return connection;  
    }  
    public void close() throws Exception{  
        if(connection!=null){  
            try {  
                connection.close();           
            } catch (Exception e) {  
                throw e;  
            }  
        }  
          
    }  
  
}
