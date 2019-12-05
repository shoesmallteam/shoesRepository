package fyq.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Address;
import fyq.form.InsertAddressForm;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class InsertAddressAction extends XywAction{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp, XywForm arg2)
			throws ServletException, IOException {
		/*InsertAddressForm form = (InsertAddressForm)arg2;
		
		Address a = new Address();
		
		System.out.println(form);
		*/
		InsertAddressForm form = (InsertAddressForm)arg2;
		
		//System.out.println(form.toString());
		
		Address address = new Address();
		address.setName(form.getName());
		address.setTel(form.getTel());
		address.setProvince(form.getProvinces());
		address.setCity(form.getCity());
		address.setArea(form.getArea());
		address.setUserid(form.getUid());
		address.setAddressid(form.getAddressid());
		address.setDetail(form.getDetail());
		
		//System.out.println(address.toString());
		
		BaseDao dao = new BaseDaoImpl(); 
		Connection conn = DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			dao.insert("insertAddress", address, conn);
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
