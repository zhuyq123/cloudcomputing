package com.plat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plat.user.*;
import com.plat.DAOInstance.*;
import com.plat.general.CookieUtil;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
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

			String name=request.getParameter("username");
			//System.out.println(name);
		    String password=request.getParameter("password");
		    String fullname = request.getParameter("forename")+request.getParameter("surname");
		    String email =  request.getParameter("email");
		    System.out.println(email);
		    User user=new User();  
	        user.setName(name);  
	        user.setPassword(password);
	        user.setFullname(fullname);
	        user.setEmail(email);;
	        
	        
	        //System.out.println("servlet");
	        try {  
	        	
		        UserDAOProxy userDAOProxy=new UserDAOProxy(); 		        		        	
		        if(userDAOProxy.addUser(user)){	
		        	response.sendRedirect("login2.jsp");
		        }
		        else{
		        	Cookie cookie = CookieUtil.create("error","Userhasexisted", false);
		        	//Cookie cookie1 = new Cookie("errornew", "abc");
		        	//cookie1.setPath("/");
		        	//cookie1.setMaxAge(60*60);
		        	//System.out.println(cookie.getValue());
		        	response.addCookie(cookie);
		        	//response.addCookie(cookie1);
		        	System.out.println("fail");
		        	response.sendRedirect("signup.jsp");
		        }
		        	//response.addCookie(CookieUtil.create("user", "!!!!",true ));
		        	//request.getRequestDispatcher("TokenVaild").forward(request,response);
		        
	        
			} catch (Exception e) {  
		        e.printStackTrace();  
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
