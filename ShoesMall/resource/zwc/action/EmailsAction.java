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
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.pojo.Account;
/*
 * 个人中心修改邮箱的servlet
 */
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
		List list;
		Connection conn = DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			list = dao.select("selectAccount3", ac, conn);
			for (Object object : list) {
				ac = (Account)object;
				e = ac.getEmail();
			}
			conn.commit();
		} catch (Exception e1) {
			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			e1.printStackTrace();
		}
		if (!e.equals(n)) {
			//返回原邮箱
			PrintWriter out = arg1.getWriter();
			out.write(n);
		}else{
			//通过邮箱查
			Account ac1 = new Account();
			ac1.setEmail(m);
			List list1;
			try {
				conn.setAutoCommit(false);
				list1 = dao.select("selectAccount1", ac1, conn);
				if (list1.size()==0) {
					ac1.setAccountid(id);
					ac1.setPassword(m);
					dao.update("updateAccountidemail", ac1, conn);
				}else{
					PrintWriter out = arg1.getWriter();
					out.write(m);
				}
				conn.commit();
			} catch (Exception e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				e1.printStackTrace();
			}finally{
				DBHelper.disConnect(conn);
			}
		}
		
		
		return null;
	}

}
