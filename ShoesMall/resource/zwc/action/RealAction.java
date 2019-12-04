package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.util.CookieUtil;
import cn.shoesmall.util.Encoding;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.pojo.Account;
/*
 * 个人中心真实姓名和身份证号码的servlet
 */
public class RealAction extends XywAction{

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
		String n = arg0.getParameter("n");//真是姓名
		String m = arg0.getParameter("m");//身份证号
		String r = null;
		//调用数据库
		BaseDao dao = new BaseDaoImpl();
		Account ac = new Account();
		ac.setAccountid(id);
		List list;
		Connection conn = DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			list = dao.select("selectAccount3", ac, conn);
			for (Object object : list) {
				ac = (Account)object;
				r = ac.getSsidnumber();//通过id查到身份证
			}
			if (r==null) {
				ac.setAccountid(id);
				ac.setSsidnumber(m);
				ac.setRealname(n);
				dao.update("updateAccountidssidnumberandrealname", ac, null);
			} else {
				if (!r.equals(m)) {
					ac.setAccountid(id);
					ac.setSsidnumber(m);
					ac.setRealname(n);
					dao.update("updateAccountidssidnumberandrealname", ac, null);
				} else {
					PrintWriter out = arg1.getWriter();
					out.write(m);
				}
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DBHelper.disConnect(conn);
		}
		
		return null;
	}

}
