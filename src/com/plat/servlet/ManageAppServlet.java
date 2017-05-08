package com.plat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plat.DAOInstance.AppDAOProxy;
import com.plat.app.App;
import com.plat.general.CookieUtil;

public class ManageAppServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ManageAppServlet() {
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
			App app = new App();
			AppDAOProxy appDAOProxy = new AppDAOProxy();
			Cookie[] cookies = request.getCookies();
			String developer = null;
			Boolean flag = false;
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("user")){
					developer =  cookie.getValue();
					//System.out.println("b"+ developer);
					flag = true;
					break;					
				}
			}
			if (flag == false){
				response.sendRedirect("login2.jsp");
			}
			else{
				app.setDeveloper(developer);
				System.out.println("dev:" +app.getDeveloper());
				try {
					if(appDAOProxy.findApps(app)){
						//response.addCookie(CookieUtil.create("appPath", app.getAppPath(), false));
						//response.addCookie(CookieUtil.create("content", app.getContent(), false));
						System.out.println("content: "+app.getContent());
						System.out.println("appname: "+app.getAPPName());
						System.out.println("name: "+app.getName());
						response.addCookie(CookieUtil.create("APPName", app.getAPPName(), false));
						response.addCookie(CookieUtil.create("project", app.getName(), false));
						response.sendRedirect("manageApp.jsp");					
					}
					else{
						response.sendRedirect("home.jsp");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
