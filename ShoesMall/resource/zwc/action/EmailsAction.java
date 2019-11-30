package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.util.CookieUtil;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.pojo.Account;

public class EmailsAction extends XywAction{

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
		String n = arg0.getParameter("n");//原邮箱
		String m = arg0.getParameter("m");//新邮箱
		String e = null;
		//调用数据库
		BaseDao dao = new BaseDaoImpl();
		Account ac = new Account();
		ac.setAccountid(id);
		List list = dao.select("selectAccount3", ac);
		for (Object object : list) {
			ac = (Account)object;
			e = ac.getEmail();
		}
		if (!e.equals(n)) {
			//返回原邮箱
			PrintWriter out = arg1.getWriter();
			out.write(n);
		}else{
			//通过邮箱查
			Account ac1 = new Account();
			ac1.setEmail(m);
			List list1 = dao.select("selectAccount1", ac1);
			if (list1.size()==0) {
				ac1.setAccountid(id);
				ac1.setPassword(m);
				dao.update("updateAccountidemail", ac1);
			}else{
				PrintWriter out = arg1.getWriter();
				out.write(m);
			}
		}
		
		
		return null;
	}

}
