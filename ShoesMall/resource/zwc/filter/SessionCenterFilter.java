package zwc.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.util.CookieUtil;
import sun.misc.BASE64Encoder;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import zwc.pojo.Account;
import zwc.pojo.User;

public class SessionCenterFilter  implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//强转成HTTP协议
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		//拿到设置好了的Cookie
		Cookie[] cs = request.getCookies();
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
		List list;
		try {
			list = dao.select("selectAccount3", ac, null);
			for (Object object : list) {
				ac = (Account)object;
				p = ac.getPhoto();
				name = ac.getSsname();//名字
				sex = ac.getSssex();//性别
				bir = ac.getSsbirthday();//生日
			}
			User u = new User();
			u.setAccountid(id);
			List list1 = dao.select("selectUserAccountid", u, null);
			for (Object object : list1) {
				u = (User)object;
				ni = u.getNikename();//昵称
			}
			//保存所有信息到session
			request.getSession().setAttribute("ac", ac);
			request.getSession().setAttribute("ni", ni);
			arg2.doFilter(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
