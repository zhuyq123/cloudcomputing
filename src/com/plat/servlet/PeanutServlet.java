package com.plat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Pattern.Flag;

import com.plat.DAOInstance.AppDAOProxy;
import com.plat.DAOInstance.UserDAOProxy;
import com.plat.app.App;
import com.plat.general.CookieUtil;
import com.plat.user.User;

public class PeanutServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PeanutServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean flag = false;
		User user = new User();
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("user")){
					user.setName(cookie.getValue());
				}
				
			}
		}
		UserDAOProxy userDAOProxy=new UserDAOProxy();
		try {
			flag = userDAOProxy.peanut(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag == true){			
			response.addCookie(CookieUtil.create("peanut",String.valueOf(user.getPeanut()),false));
		}
		App app = new App();
		AppDAOProxy appDAOProxy = new AppDAOProxy();
		//AppDAOProxy.
		
		
		
		response.sendRedirect("login2.jsp");
			
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
