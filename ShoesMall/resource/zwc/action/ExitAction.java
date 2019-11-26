package zwc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.util.CookieUtil;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class ExitAction extends XywAction{

	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
//		//拿到设置好了的Cookie
//		Cookie[] cs = arg0.getCookies();
//		//找到之前的
//		Cookie cookie = CookieUtil.findCookie(cs, "auto_login");
//		System.out.println(111);
//		//设置存活时间为零
//		cookie.setMaxAge(0);
//		arg1.sendRedirect("http://localhost:8080/ShoesMall/home.jsp");
		Cookie[] cookies=arg0.getCookies();
		for(Cookie cookie: cookies){
		    cookie.setMaxAge(0);
		    cookie.setPath("/ShoesMall");
		    arg1.addCookie(cookie);
		}
		return null;
	}

}
