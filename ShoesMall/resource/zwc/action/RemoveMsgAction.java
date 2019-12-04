package zwc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
/*
 * 单态被踢下线时清除msg和cookie信息的servlet
 */
public class RemoveMsgAction extends XywAction{

	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		//System.out.println(132);
		arg0.getSession().setAttribute("msg","");
		Cookie[] cookies=arg0.getCookies();
		for(Cookie cookie: cookies){
		    cookie.setMaxAge(0);
		    cookie.setPath("/ShoesMall");
		    arg1.addCookie(cookie);
		}
		return null;
	}

}
