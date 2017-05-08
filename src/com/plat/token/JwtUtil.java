package com.plat.token;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import io.jsonwebtoken.*;
import java.util.Date; 
import net.sf.json.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;

import com.plat.user.*;

public class JwtUtil 
{
    private static String zhuyq;


    public static SecretKey generalKey(){
        String stringKey = zhuyq+Constant.JWT_SECRET;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

 
    public String createJWT(String id, String subject, long ttlMillis) throws Exception {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts.builder();
        builder.setId(id);
        builder.setIssuedAt(now);
        builder.setSubject(subject);
        builder.signWith(signatureAlgorithm, key);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 解密jwt
     * @param jwt
     * @return
     * @throws Exception
     */
    public Claims parseJWT(String jwt) throws Exception{
        SecretKey key = generalKey();
        Claims claims = Jwts.parser()         
           .setSigningKey(key)
           .parseClaimsJws(jwt).getBody();
        
        
        return claims;
    }

    /**
     * 生成subject信息
     * @param user
     * @return
     */
    
    public static String generalSubject(User user){
        JSONObject sub = new JSONObject();
        sub.put("id", user.getUserid());
        sub.put("name", user.getName());
        //jo.put("mobile", user.getMobile());
        return sub.toString();
       
    }
     

}