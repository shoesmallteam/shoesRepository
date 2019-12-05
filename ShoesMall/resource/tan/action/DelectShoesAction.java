package tan.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Shoes;
import cn.shoesmall.pojo.Shoesdetail;
import tan.form.DelectShoesForm;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class DelectShoesAction extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		DelectShoesForm form = (DelectShoesForm)arg2;
		BaseDao dao = new BaseDaoImpl();
		Connection conn = DBHelper.getConnection();
		Shoes shoes = new Shoes();
		shoes.setShoesid(form.getShoesid());
		Shoesdetail detail = new Shoesdetail();
		detail.setShoesid(form.getShoesid());
		
		boolean falg = false;
		boolean dfalg = false;
		try {
			conn.setAutoCommit(false);
			falg = dao.delete("DelectShoesById", shoes, conn);
			dfalg = dao.delete("deleteShoesDetailById", detail, conn);
			
			if (dfalg&&falg) {
				conn.commit();
			}
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
		
		return null;
	}

}
