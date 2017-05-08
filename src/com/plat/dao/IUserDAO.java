package com.plat.dao;

import com.plat.user.User; 

public interface IUserDAO {

	/** 
	 * 用户登录验证 
	 * @param user传入vo对象 
	 * @return 验证的操作结果  
	 * @throws Exception 
	 */  
	public boolean findLogin(User user) throws Exception; 
	public boolean addUser(User user) throws Exception;
	public boolean peanut(User user) throws Exception;
	//public boolean checkUser(User user) throws Exception;
}
