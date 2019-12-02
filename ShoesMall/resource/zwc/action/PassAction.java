package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.util.CookieUtil;
import cn.shoesmall.util.Encoding;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.pojo.Account;

public class PassAction extends XywAction{

	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		//拿到设置好了的Cookie
		Cookie[] cs = arg0.getCookies();
		//找到之前的
		Cookie cookie = CookieUtil.findCookie(cs, "auto_login");
		String value = cookie.getValue();
		//拿到id
		String id = value.split("#itheima#")[3];
		System.out.println(id);
		//拿到ajax传过来的页面数据
		String n = arg0.getParameter("n");//原密码
		System.out.println(n);
		n = Encoding.encode(n, "MD5");//加密
		System.out.println(n);
		String m = arg0.getParameter("m");//新密码
		System.out.println(m);
		m = Encoding.encode(m, "MD5");//加密
		System.out.println(m);
		String old = null;
		//定义id
		BaseDao dao = new BaseDaoImpl();
		Account ac = new Account();
		ac.setAccountid(id);
		List list = dao.select("selectAccount3", ac);
			for (Object object : list) {
				ac = (Account)object;
				old = ac.getPassword();
			}
			if (!old.equals(n)) {
				//返回原密码
				PrintWriter out = arg1.getWriter();
				out.write(n);
			}else{
				//通过id修改密码
				Account ac1 = new Account();
				ac1.setAccountid(id);
				ac1.setPassword(m);
				dao.update("updateAccountidpass", ac1);
				//清除原来得数据
				Cookie[] cookies=arg0.getCookies();
				for(Cookie c: cookies){
				    c.setMaxAge(0);
				    c.setPath("/ShoesMall");
				    arg1.addCookie(cookie);
				}
			}
			
		
		
		
		
		return null;
	}

}
