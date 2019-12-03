package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.util.CookieUtil;
import sun.misc.BASE64Decoder;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.pojo.Account;
import zwc.pojo.User;

public class CenterAction extends XywAction{

	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		//拿到ajax传过来的页面数据
		String content = arg0.getParameter("content");
		String nicheng = arg0.getParameter("nicheng");
		String xingming = arg0.getParameter("xingming");
		String xingbie = arg0.getParameter("xingbie");
		String nian = arg0.getParameter("nian");
		String yue = arg0.getParameter("yue");
		String ri = arg0.getParameter("ri");
		//图片解码
//		int index = content.indexOf(",");
//		content = content.substring(index+1);
//		BASE64Decoder decoder = new BASE64Decoder();
//		byte[] b = decoder.decodeBuffer(content);
		//拼接年月日
		String bir = nian+"-"+yue+"-"+ri;
		//拿到设置好了的Cookie
		Cookie[] cs = arg0.getCookies();
		//找到之前的
		Cookie cookie = CookieUtil.findCookie(cs, "auto_login");
		String value = cookie.getValue();
		//拿到主键id
		String id = value.split("#itheima#")[3];
		//调用数据库
		BaseDao dao = new BaseDaoImpl();
		//更改Account表
		Account ac = new Account();
		ac.setAccountid(id);
		ac.setPhoto(content);
		ac.setSsname(xingming);
		ac.setSssex(xingbie);
		ac.setSsbirthday(bir);
		try {
			dao.update("updateAccountid", ac, null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//更改User表
		User u = new User();
		u.setAccountid(id);
		u.setNikename(nicheng);
		try {
			dao.update("updateUser", u, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回生日
		PrintWriter out = arg1.getWriter();
		out.write(bir);
		return null;
	}

}
