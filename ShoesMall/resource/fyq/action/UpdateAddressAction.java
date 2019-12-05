package fyq.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Address;
import fyq.form.UpdateAddressForm;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class UpdateAddressAction extends XywAction{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp, XywForm arg2)
			throws ServletException, IOException {
		UpdateAddressForm form = (UpdateAddressForm)arg2;
		Address address = new Address();
		address.setName(form.getName());
		address.setTel(form.getTel());
		address.setProvince(form.getProvince());
		address.setCity(form.getCity());
		address.setArea(form.getArea());
		address.setAddressid(form.getAddressid());
		address.setDetail(form.getDetail());
		
		BaseDao dao = new BaseDaoImpl();
		Connection conn = DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			dao.update("updateAddress", address, null);
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
