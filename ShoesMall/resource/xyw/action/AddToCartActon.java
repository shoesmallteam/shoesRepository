package xyw.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.util.CookieUtil;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class AddToCartActon extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		
		
		Cookie auto_login = CookieUtil.findCookie(request.getCookies(), "auto_login");
		
		String value = auto_login.getValue();
		
		String id = value.split("#itheima#")[3];
		
		return null;
	}

}
