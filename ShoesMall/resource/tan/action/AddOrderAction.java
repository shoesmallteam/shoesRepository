package tan.action;

import java.io.IOException;
import java.io.PrintWriter;
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
		System.out.println(orders);
		
		//修改库存,先查看库存
		Shoesdetail detail = new Shoesdetail();
		detail.setShoesdetailid(orders.getShoesdetailid());
		List<Object> list = dao.select("selectByShoesdetailid", detail);
		for (Object object : list) {
			detail = (Shoesdetail)object;
			detail.setCount(detail.getCount() - Integer.valueOf(form.getCount()));
		}
		
		dao.update("updateCount", detail);
		boolean result = dao.insert("insertOrders", orders);
		PrintWriter out = response.getWriter();
		if (result) {
			out.print(result);
		}
		
		return null;
	}

}
