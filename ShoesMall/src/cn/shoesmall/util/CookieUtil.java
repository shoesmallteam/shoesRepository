package cn.shoesmall.util;

import javax.servlet.http.Cookie;

public class CookieUtil {
	public static Cookie findCookie(Cookie [] cookies , String name){
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if(name.equals(cookie.getName())){
					return cookie;
				}
			}
		}
		return null;
	}
	
	public static String getValueFromString(String src,String desc) {
		String result = null;
		
		src = src.substring(src.indexOf(desc +"#"));
		result = src.substring(0,src.indexOf("#"));
		
		return result;
	}
}
