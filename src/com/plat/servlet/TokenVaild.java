package com.plat.servlet;

import io.jsonwebtoken.Claims;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plat.DAOInstance.UserDAOProxy;
import com.plat.general.CookieUtil;
import com.plat.token.*;
import com.plat.user.User;

public class TokenVaild extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public TokenVaild() {
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
			Cookie[] cookies = null;
			cookies = request.getCookies();
			String userId = null;
			String NandP =null;
			boolean flag = false;
			System.out.println("a");
			for (int i = 0; i < cookies.length; i++){	
				if (cookies[i].getName().equals("token")){	
					System.out.println("c");
					try {
						System.out.println("b");
						User user=new User(); 
						ParseJWT claims = new ParseJWT(cookies[i].getValue());
						userId = claims.getId();
						System.out.println(userId);
						NandP = claims.getSubject();
						System.out.println(NandP);
						user.setName(NandP.split(",")[0]);
						user.setPassword(NandP.split(",")[1]);
						System.out.println(user.getPassword());
						UserDAOProxy userDAOProxy=new UserDAOProxy();						
						if(userDAOProxy.findLogin(user)){
							flag = true;
							response.sendRedirect("login2.jsp");
							break;			    		
						}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				
		}	//for	
			if(flag == false){
				//response.sendRedirect("login2.jsp");
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
				//response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
				//response.setHeader("Location", "http://localhost:8080/Platform/login2.jsp");
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
			user.setUserid(1);
			user.setPeanut(100);
		    UserDAOProxy userDAOProxy=new UserDAOProxy();
		    try {  	              
	         	if(userDAOProxy.findLogin(user)){
	         		String token = null;
	         		JwtUtil jwt = new JwtUtil();
	         		String subject =name+','+password;
					token = jwt.createJWT(String.valueOf(user.getUserid()) ,subject, 60*60*1000);
	         		
					Cookie tokenCookie = new Cookie("token",token);
					tokenCookie.setMaxAge(30*60);
					tokenCookie.setPath("/");
	    			response.addCookie(tokenCookie);
	         		         		
	                Cookie loginCookie = new Cookie("user",name);
	    			loginCookie.setMaxAge(30*60);
	    			loginCookie.setPath("/");
	    			response.addCookie(loginCookie);
	    				    		
	    			Cookie peanut = new Cookie("peanut",String.valueOf(user.getPeanut()));	    	
	    			peanut.setMaxAge(30*60);
	    			peanut.setPath("/");
	    			response.addCookie(peanut);
	    			
	    			response.addCookie(CookieUtil.create("fullname", user.getFullname(), false));
	    			
	    			response.sendRedirect("home.jsp");

	            }else {  
	                response.sendRedirect("login2.jsp");
	            }                         
	        } catch (Exception e) { 
	        	System.out.println("error");
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
