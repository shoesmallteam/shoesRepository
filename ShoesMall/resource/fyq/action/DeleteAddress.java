package fyq.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Address;
import fyq.form.DeleteAddressForm;
import fyq.form.InsertAddressForm;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class DeleteAddress extends XywAction{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp, XywForm arg2)
			throws ServletException, IOException {
		DeleteAddressForm form = (DeleteAddressForm)arg2;
		Address address = new Address();
		address.setAddressid(form.getAddressid());
		BaseDao dao = new BaseDaoImpl();
		Boolean flag;
		Connection conn = DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			flag = dao.delete("deleteAddress",address, conn);
			if(flag) {
				PrintWriter out = resp.getWriter();
				out.print(flag);
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
		}finally {
			DBHelper.disConnect(conn);
		}
		
		return "success";
	}

}
