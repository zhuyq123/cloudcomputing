package com.plat.user;

public class User {
	 private int userid; 
	    private String name; 
	    private String password;
	    private int peanut;
	    private String email;
	    public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFullname() {
			return fullname;
		}
		public void setFullname(String fullname) {
			this.fullname = fullname;
		}
		private String fullname;
	    public int getUserid() {  
	        return userid;  
	    }  
	    public void setUserid(int userid) {  
	        this.userid = userid;  
	    }  
	    public int getPeanut() {
			return peanut;
		}
		public void setPeanut(int peanut) {
			this.peanut = peanut;
		}
		public String getName() {  
	        return name;  
	    }  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	    public String getPassword() {  
	        return password;  
	    }  
	    public void setPassword(String password) {  
	        this.password = password;  
	    }  
}
