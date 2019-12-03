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

public class PhotosAction extends XywAction{

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
		String n = arg0.getParameter("n");//原手机号码
		String m = arg0.getParameter("m");//新手机号码
		String t = null;
		//调用数据库
		BaseDao dao = new BaseDaoImpl();
		Account ac = new Account();
		ac.setAccountid(id);
		List list;
		try {
			list = dao.select("selectAccount3", ac, null);
			for (Object object : list) {
				ac = (Account)object;
				t = ac.getTel();
			}
			if (!t.equals(n)) {
				//返回原手机号码
				PrintWriter out = arg1.getWriter();
				out.write(n);
			}else{
				//通过电话查
				Account ac1 = new Account();
				ac1.setTel(m);
				List list1 = dao.select("selectAccount", ac1, null);
				if (list1.size()==0) {
					ac1.setAccountid(id);
					ac1.setPassword(m);
					dao.update("updateAccountidtel", ac1, null);
				}else{
					PrintWriter out = arg1.getWriter();
					out.write(m);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
