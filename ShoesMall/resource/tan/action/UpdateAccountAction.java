package tan.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Account;
import tan.form.UpdateAccountForm;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class UpdateAccountAction extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		UpdateAccountForm form = (UpdateAccountForm)arg2;
		Connection conn = DBHelper.getConnection();
		
		BaseDao dao = new BaseDaoImpl();
		Account account = new Account();
		account.setAccount(form.getAccount());
		account.setIsassistant(Integer.valueOf(form.getIsassistant()));
		account.setIsvip(Integer.valueOf(form.getIsvip()));
		
		boolean flag = false;
		try {
			conn.setAutoCommit(false);
			flag = dao.update("updateIsassistant", account, conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBHelper.disConnect(conn);
		}
		
		if (flag) {
			return null;			
		}
		return null;
	}

}