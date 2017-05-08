package com.plat.token;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;


public class ParseJWT {
		public String id;
		public String subject;
		public Date Expiration;
		public ParseJWT(String jwt) throws Exception{
	        SecretKey key = JwtUtil.generalKey();
	        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();		        
	        this.id =  claims.getId();
	        this.subject = claims.getSubject();
	        this.Expiration = claims.getExpiration();
	        
		}
		public String getId() {
			return id;
		}
		public String getSubject() {
			return subject;
		}
		public Date getExpiration() {
			return Expiration;
		}
	
}
