package tan.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Orders;
import cn.shoesmall.pojo.Shoesdetail;
import net.sf.json.JSONObject;
import tan.form.AddOrderForm;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class AddOrderAction extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		AddOrderForm form = (AddOrderForm)arg2;
		BaseDao dao = new BaseDaoImpl();
		
		String order = form.getOrder();
		JSONObject jobj = JSONObject.fromObject(order);
		Orders orders = (Orders)JSONObject.toBean(jobj, Orders.class);
		orders.setCount(Integer.valueOf(form.getCount()));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		orders.setGenerictime(sdf.format(date));
		System.out.println(orders);
		
		Connection conn = DBHelper.getConnection();
		
		//修改库存,先查看库存
		Shoesdetail detail = new Shoesdetail();
		detail.setShoesdetailid(orders.getShoesdetailid());
		List<Object> list;
		try {
			conn.setAutoCommit(false);
			list = dao.select("selectByShoesdetailid", detail, conn);
			for (Object object : list) {
				detail = (Shoesdetail)object;
				detail.setCount(detail.getCount() - Integer.valueOf(form.getCount()));
			}
			
			dao.update("updateCount", detail, conn);
			boolean result = dao.insert("insertOrders", orders, conn);
			PrintWriter out = response.getWriter();
			conn.commit();
			if (result) {
				out.print(result);
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
