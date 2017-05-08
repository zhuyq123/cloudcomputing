package com.plat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plat.DAOInstance.UserDAOProxy;
import com.plat.dao.*;
import com.plat.user.*;



public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
		//System.out.println("c");
		Cookie cookie =null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		int count = 0;
		if (cookies!=null){						 
			 for (int i = 0; i < cookies.length; i++){				 			 
		         cookie = cookies[i];
		         //System.out.println(cookie.getName());
		         if(cookie.getName().equals("user")){
		        	 //request.getRequestDispatcher("/SignIn.jsp").forward(request,response);
		        	 response.sendRedirect("LoginSuccessful.jsp");
		        	 //System.out.println("a");
		        	 count++;
		        	 break;        	 
		         }		         
			 }
		}
		if (count == 0){
				 response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}			    
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
			String name=request.getParameter("name");  
		    String password=request.getParameter("password");   
		    User user=new User();  
		    user.setName(name);  
		    user.setPassword(password);  
		    UserDAOProxy userDAOProxy=new UserDAOProxy();  
	    	try {  	              
	         	if(userDAOProxy.findLogin(user)){  
	                Cookie loginCookie = new Cookie("user",name);//setting cookie to expiry in 30 mins
	    			loginCookie.setMaxAge(30*60);
	    			loginCookie.setPath("/");
	    			response.addCookie(loginCookie);
	    			//response.sendRedirect("LoginSuccess.jsp");
	    			//response.sendRedirect("LoginSuccessful.jsp");	    				    		
	    			Cookie peanut = new Cookie("peanut",String.valueOf(user.getPeanut()));	    	
	    			loginCookie.setMaxAge(30*60);
	    			loginCookie.setPath("/");
	    			response.addCookie(peanut);
	    			response.sendRedirect("LoginSuccessful.jsp");
	    			//response.sendRedirect("http://localhost:8080/HELLOWORLD/index.jsp");
	            }else {  
	                //info.add("Fail!"); 
	                /*
	                RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
	    			PrintWriter out= response.getWriter();
	    			out.println("<font color=red>Either user name or password is wrong.</font>");
	    			rd.include(request, response);
	    			*/
	                response.sendRedirect("login.jsp");
	            }                         
	        } catch (Exception e) { 
	        	System.out.println("error");
	            e.printStackTrace();  
	        }   
	}  
	   // request.setAttribute("info", info); 
	    //System.out.println(info);
	

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
