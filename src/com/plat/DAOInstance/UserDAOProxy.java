package com.plat.DAOInstance;

import com.plat.dao.IUserDAO;
import com.plat.dao.UserDAOImpI;
import com.plat.dbc.DatabaseConnection;
import com.plat.user.User;

public class UserDAOProxy implements IUserDAO{
	 private DatabaseConnection dbc=null;//定义数据库连接  
	    private IUserDAO dao=null;//定义DAO接口  
	    public UserDAOProxy(){  
	        try {  
	            dbc=new DatabaseConnection();//实例化数据库连接  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        dao=new UserDAOImpI(dbc.getConnection());  
	          
	    }  

	@Override
	public boolean findLogin(User user) throws Exception {
		 boolean flag=false;  
	        try {  
	            flag=dao.findLogin(user);//调用真实主题  
	        } catch (Exception e) {  
	            throw e;  
	        }finally{  
	            dbc.close();  
	        }  
	        return flag; 
	}
	@Override
	public boolean addUser(User user) throws Exception{
		boolean flag=false;
		try {  
			flag = dao.addUser(user);
        } catch (Exception e) {  
            throw e;  
        }finally{  
            dbc.close();  
        }
		return flag; 
	}

	@Override
	public boolean peanut(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {  
			flag = dao.peanut(user);
        } catch (Exception e) {  
            throw e;  
        }finally{  
            dbc.close();  
        }
		return flag; 
	}

}
