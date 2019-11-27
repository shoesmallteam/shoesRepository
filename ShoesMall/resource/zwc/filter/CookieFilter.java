package zwc.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import zwc.pojo.Account;
/*
 * 实现自动登陆的过滤器
 */
public class CookieFilter implements Filter{

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
		//第一次来
		if (cookie==null) {
			//放行
			request.getSession().setAttribute("uuname", "");
			request.getSession().setAttribute("uupass", "");
			arg2.doFilter(request, response);
		} else {
			String value = cookie.getValue();
			String username = value.split("#itheima#")[0];
			String password = value.split("#itheima#")[1];
			String nikename = value.split("#itheima#")[2];
			System.out.println(username);
			System.out.println(password);
			System.out.println(nikename);
			//调用数据库
			BaseDao dao = new BaseDaoImpl();
			Account ac = new Account();
			Pattern email = Pattern.compile("^\\w+@\\w+\\.(net|com|cn|org)+$");
			Pattern photo = Pattern.compile("^1[3456789]\\d{9}$");
			List list = null;
			Matcher m1 = email.matcher(username);
			Matcher m2 = photo.matcher(username);
			if(m1.find()){
				System.out.println("输入的登陆账号是邮箱");
				ac.setEmail(username);
				list = dao.select("selectAccount1", ac);
			}else if(m2.find()){
				System.out.println("输入的登陆账号是手机号");
				ac.setTel(username);
				list = dao.select("selectAccount", ac);
			}else{
				System.out.println("输入的登陆账号就是账号");
				ac.setAccount(username);
				list = dao.select("selectAccount2", ac);
			}
			if (list.size()>0){
				request.getSession().setAttribute("uuname", username);
				request.getSession().setAttribute("uupass", password);
				request.getSession().setAttribute("nikename", nikename);
				arg2.doFilter(request, response);
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
