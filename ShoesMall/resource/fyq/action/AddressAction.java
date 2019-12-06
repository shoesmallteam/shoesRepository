package fyq.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Account;
import cn.shoesmall.pojo.Address;
import cn.shoesmall.pojo.User;
import cn.shoesmall.util.CookieUtil;
import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class AddressAction extends XywAction{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp, XywForm arg2)
			throws ServletException, IOException {
		//拿到设置好了的Cookie
		Cookie[] cs = req.getCookies();
		//找到之前的
		Cookie cookie = CookieUtil.findCookie(cs, "auto_login");
		String value = cookie.getValue();
		//拿到主键id
		String accountid = value.split("#itheima#")[3];
		BaseDao dao = new BaseDaoImpl();
		User user = new User();
		user.setAccountid(accountid);
		
		Address address = new Address();
		DBHelper.getDoc(address.getClass());
		List list;
		Connection conn = DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			list = dao.select("selectUserById", user, conn);
			for (Object object : list) {
				user = (User)object;
			}
			address.setUserid(user.getUserid());
			
			list = dao.select("selectAddress", address, conn);
			req.setAttribute("addressList", list);
			req.setAttribute("userid", user.getUserid());
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
		return "success";
	}

}
