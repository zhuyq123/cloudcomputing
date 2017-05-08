package com.plat.dao;

import com.plat.app.App;

public interface IAppDAO {

	public boolean findApps(App app) throws Exception; 
	public boolean addApp(App app) throws Exception;
	public boolean getApp(App app) throws Exception;
}
