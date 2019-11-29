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
		//拿到主键id
		String id = value.split("#itheima#")[3];
		//调用数据库
		BaseDao dao = new BaseDaoImpl();
		//查表
		Account ac = new Account();
		//全局定义
		String ph = null;
		ac.setAccountid(id);
		List list = dao.select("selectAccount3", ac);
		for (Object object : list) {
			ac = (Account)object;
//			byte[] b = ac.getPhoto();
//			BASE64Encoder en = new BASE64Encoder();
//			ph = en.encode(b);//图片
		}
		//返回对象
//		arg1.setCharacterEncoding("UTF-8");
//		arg1.setHeader("Content-Type", "application/json;charset=utf-8");
//		JSONObject jo = JSONObject.fromObject(ac);
//		PrintWriter out = arg1.getWriter();
//		out.print(URLDecoder.decode(jo.toString()));
		PrintWriter out = arg1.getWriter();
		out.print(ph);
		
		return null;
	}

}
