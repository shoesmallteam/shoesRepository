package tan.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Shoesdetail;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tan.form.SelectCountForm;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class SelectCountAction extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		BaseDao dao = new BaseDaoImpl();
		SelectCountForm form = (SelectCountForm)arg2;
		JSONObject shoes = JSONObject.fromObject(form.getShoes());
		Shoesdetail detail = (Shoesdetail)JSONObject.toBean(shoes, Shoesdetail.class);
		PrintWriter out = response.getWriter();
		
		Connection conn = DBHelper.getConnection();
		List<Shoesdetail> detaillist = new ArrayList<Shoesdetail>();
		//拿数据
		List<Object> list;
		try {
			conn.setAutoCommit(false);
			list = dao.select("selectCount", detail, conn);
			for (Object object : list) {
				detail = (Shoesdetail)object;
				detaillist.add(detail);
			}
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
		
		if(detaillist != null) {
			JSONArray arr = JSONArray.fromObject(detaillist);
			System.out.println(arr.toString());
			out.print(arr.toString());
		}
		
		return null;
	}

}
