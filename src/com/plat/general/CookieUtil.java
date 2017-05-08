package com.plat.general;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static Cookie create( String name, String value, Boolean secure) {
        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(secure);
        //cookie.setHttpOnly(true);
        cookie.setMaxAge(60*60);
        //cookie.setDomain(domain);
        cookie.setPath("/");
        //httpServletResponse.addCookie(cookie);
        return cookie;
    }

    public static void clear(HttpServletResponse httpServletResponse, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
    }
/*
    public static String getValue(HttpServletRequest httpServletRequest, String name) {
        Cookie cookie = WebUtils.getCookie(httpServletRequest, name);
        return cookie != null ? cookie.getValue() : null;
    }
    */
}
