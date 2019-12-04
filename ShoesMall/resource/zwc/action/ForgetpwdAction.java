package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.util.Encoding;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.pojo.Account;
/*
 * 忘记密码的servlet
 */
public class ForgetpwdAction extends XywAction{

	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		//拿到ajax传过来的页面数据
		String f = arg0.getParameter("f");
		String forgetpwd = arg0.getParameter("forgetpwd");
		//加密
		String newforgetpwd = Encoding.encode(forgetpwd, "MD5");//加密
		//调用数据库
		BaseDao dao = new BaseDaoImpl();
		Account ac = new Account();
		ac.setEmail(f);
		String id= null;
		Connection conn = DBHelper.getConnection();
		//通过邮箱查到id
		List list;
		try {
			conn.setAutoCommit(false);
			list = dao.select("selectAccount1", ac, conn);
			for (Object object : list) {
				ac = (Account)object;
				id = ac.getAccountid();
			}
			if (list.size()>0) {
				//通过id修改密码
				Account ac1 = new Account();
				ac1.setAccountid(id);
				ac1.setPassword(newforgetpwd);
				dao.update("updateAccountidpass", ac1, conn);
			} else {
				PrintWriter out = arg1.getWriter();
				out.write(forgetpwd);
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DBHelper.disConnect(conn);
		}
		
		
		return null;
	}

}
