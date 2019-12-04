package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.pojo.Account;
/*
 * 查询电话是不是唯一的servlet
 */
public class TelAction extends XywAction{
	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		//拿到页面传过来的数据
		String tel = arg0.getParameter("tel");
		//System.out.println(tel);
		//拿到数据库里的数据
		BaseDao dao = new BaseDaoImpl();
		Account ac = new Account();
		//通过查出单个进行比较
		ac.setTel(tel);
		List list;
		Connection conn = DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			list = dao.select("selectAccount", ac, conn);
			if (list.size()>0) {
				System.out.println("已存在");
				PrintWriter out = arg1.getWriter();
				out.write(tel);
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
		//通过查出所有然后再循环对比数据
//		List list = dao.select("selectAll", new Account());
//		for (Object object : list) {
//			ac = (Account)object;
//			ac.getTel();
//			for (int i = 0; i < ac.getTel().length(); i++) {
//				if (ac.getTel().equals(tel)) {
//					System.out.println("已存在");
//				}
//			}
//		}
		
		return null;
	}
}
