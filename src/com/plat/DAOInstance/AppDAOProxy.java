package com.plat.DAOInstance;

import com.plat.dao.IAppDAO;
import com.plat.dao.AppDAOImpI;
import com.plat.dbc.DatabaseConnection;
import com.plat.app.App;

public class AppDAOProxy implements IAppDAO{
	
	private DatabaseConnection dbc=null;
    private IAppDAO dao=null;
    public AppDAOProxy(){  
        try {  
            dbc=new DatabaseConnection();
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        dao=new AppDAOImpI(dbc.getConnection()); 
    }

	@Override
	public boolean findApps(App app) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;  
        try {  
            flag=dao.findApps(app);//调用真实主题  
        } catch (Exception e) {  
            throw e;  
        }finally{  
            dbc.close();  
        }  
		
		return flag;
	}

	@Override
	public boolean addApp(App app) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {  
			flag = dao.addApp(app);
        } catch (Exception e) {  
            throw e;  
        }finally{  
            dbc.close();  
        }
		return flag;
	}

	@Override
	public boolean getApp(App app) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	

}
