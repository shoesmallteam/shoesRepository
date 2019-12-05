package tan.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Account;
import net.sf.json.JSONArray;
import tan.dao.PageDao;
import tan.form.SelectAccountForm;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class SelectAccountAction extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		SelectAccountForm form = (SelectAccountForm)arg2;
		Connection conn = DBHelper.getConnection();
		PageDao dao = new PageDao();
		List<Account> acclist = null;
		try {
			conn.setAutoCommit(false);
			int pagesize = Integer.valueOf(form.getPagesize());
			acclist = dao.select(pagesize, conn);
			conn.commit();
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBHelper.disConnect(conn);
		}
		PrintWriter out = response.getWriter();
		if (!acclist.isEmpty()) {
			JSONArray jsonlist = JSONArray.fromObject(acclist);
			out.print(jsonlist.toString());
		}
		
		return null;
	}

}
