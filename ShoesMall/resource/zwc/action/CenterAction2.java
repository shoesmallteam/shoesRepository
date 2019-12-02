package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import cn.shoesmall.util.CookieUtil;
import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.pojo.Account;
import zwc.pojo.User;

public class CenterAction2 extends XywAction{

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
				//调用数据库
				BaseDao dao = new BaseDaoImpl();
				//查表
				Account ac = new Account();
				//全局定义
				String ph = null;
				String name = null;
				String sex = null;
				String bir = null;
				String ni = null;
				String p = null;
				ac.setAccountid(id);
				List list = dao.select("selectAccount3", ac);
				for (Object object : list) {
					ac = (Account)object;
					p = ac.getPhoto();
					name = ac.getSsname();//名字
					sex = ac.getSssex();//性别
					bir = ac.getSsbirthday();//生日
				}
				User u = new User();
				u.setAccountid(id);
				List list1 = dao.select("selectUserAccountid", u);
				for (Object object : list1) {
					u = (User)object;
					ni = u.getNikename();//昵称
				}
				String s = p.replaceAll(" ","");
				System.out.println(s);
				//保存所有信息到session
				arg0.getSession().setAttribute("ac", ac);
				arg0.getSession().setAttribute("ni", ni);
				PrintWriter out = arg1.getWriter();
				out.print(s);
		
		return null;
	}

}
