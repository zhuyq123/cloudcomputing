package com.plat.servlet;

import java.io.File;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig; 
import javax.servlet.http.Part;

import com.plat.DAOInstance.AppDAOProxy;
import com.plat.app.App;
import com.plat.general.CookieUtil;


@WebServlet("/Uploaderservlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10, // 10MB
maxRequestSize=1024*1024*50) // 50MB
public class UploaderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
			return "";
	}
	public void Extractor(String jarpath, String destdir) throws IOException{
		JarFile jarfile = new JarFile(jarpath);
		for (Enumeration<JarEntry> iter = jarfile.entries();
		 iter.hasMoreElements();) {
		 JarEntry entry = iter.nextElement();
		 System.out.println("Processing: " + entry.getName());
		 File outfile = new File(destdir, entry.getName());
		 if (! outfile.exists())
		 outfile.getParentFile().mkdirs(); 
		 if (! entry.isDirectory()) {
			 InputStream instream = jarfile.getInputStream(entry);
			 FileOutputStream outstream = new FileOutputStream(outfile);
			 while (instream.available() > 0) {
			 outstream.write(instream.read());
			 }
			 outstream.close();
			 instream.close();
			 } // end if
			 } // end for
			 jarfile.close();
		
} // end main


	/**
	 * Constructor of the object.
	 */
	
	public UploaderServlet() {
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
		// TODO Auto-generated method stub
		String appPath = request.getServletContext().getRealPath(""); 
		// Create path to the directory to save uploaded file 
		String savePath = appPath;// + File.separator + SAVE_DIR; 
		// Create the save directory if it does not exist
		File fileSaveDir = new File(savePath); 
		if (!fileSaveDir.exists()) fileSaveDir.mkdir(); 
		String warPath = null;
		String file =null;
		//for (Part part : request.getParts()) {
			Part part = request.getPart("filename");
			String fileName = extractFileName(part);			
			warPath = savePath + File.separator + fileName;
			part.write(warPath);
			file = fileName;
			warPath = savePath.replace("\\\\", File.separator+File.separator) + File.separator + fileName;			
		//}
		
		String[] a = savePath.split("\\\\");
		String jarPath = "";
		for (int i=0; i<a.length-1;i++){
			//System.out.println(a[i]);
			jarPath = jarPath + a[i] + File.separator+File.separator;
			//System.out.println(jarPath);
		}
		appPath = jarPath + file.split("\\.")[0];
		jarPath = jarPath + a[a.length-1] + File.separator+File.separator + file;		
		System.out.println(appPath);
		System.out.println(jarPath);
		String content = "empty";
		String APPName ="app";
		content = request.getParameter("content");
		APPName = request.getParameter("APPName");
		
		// Add more code here to generate HTML response 
		// to say that upload was completed successfully
		//doGet(request, response);
		//response.getWriter().append("upload sucess").append(jarPath);
		Extractor(jarPath,appPath);
		 
		System.out.print("a");
		
		App app = new App();
		app.setName(file.split("\\.")[0]);
		Cookie[] cookies = request.getCookies(); 
		for(Cookie cookie:cookies){
			//System.out.println("a");
			if(cookie.getName().equals("user")){			
				app.setDeveloper(cookie.getValue().toString());
				app.setAppPath(appPath);
				//System.out.println(appPath);
				System.out.println(content);
				app.setContent(content);
				app.setAPPName(APPName);
				//System.out.println(app.getDeveloper());
				AppDAOProxy appDAOProxy = new AppDAOProxy();
					try {
						if(appDAOProxy.addApp(app)){
							//System.out.println("n");
							response.sendRedirect("home.jsp");
						}
						else{
							//System.out.println("m");							
							response.addCookie(CookieUtil.create("error", "UploadFail", false));
							response.sendRedirect("home.jsp");
							
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
