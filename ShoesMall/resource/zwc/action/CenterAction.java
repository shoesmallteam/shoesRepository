package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.util.CookieUtil;
import sun.misc.BASE64Decoder;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.pojo.Account;
import zwc.pojo.User;
/*
 * 个人中心修改基本信息的servlet
 */
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
		Connection conn = DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			dao.update("updateAccountid", ac, conn);
			conn.commit();
		} catch (Exception e1) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
		}finally {
			DBHelper.disConnect(conn);
		}
		//更改User表
		User u = new User();
		u.setAccountid(id);
		u.setNikename(nicheng);
		try {
			conn.setAutoCommit(false);
			dao.update("updateUser", u, conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBHelper.disConnect(conn);
		}
		//返回生日
		PrintWriter out = arg1.getWriter();
		out.write(bir);
		return null;
	}

}
