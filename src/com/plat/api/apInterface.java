package com.plat.api;


import com.plat.dbc.DatabaseConnection;

public class apInterface implements API{		
		private DatabaseConnection dbc=null;
	    private API dao=null;
	    public apInterface(){  
	        try {  
	            dbc=new DatabaseConnection();
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        dao=new APIImpl(dbc.getConnection()); 
	    }
		@Override
		public boolean createUser(String username, String password, String database)
				throws Exception {
			boolean flag=false;  
	        try {  
	            flag=dao.createUser(username,password,database);
	        } catch (Exception e) {  
	            throw e;  
	        }finally{  
	            dbc.close();  
	        }  			
			return flag;
			// TODO Auto-generated method stub
			
		}
}    

