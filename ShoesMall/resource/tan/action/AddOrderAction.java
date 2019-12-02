package tan.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Orders;
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
		
		boolean result = dao.insert("insertOrders", orders);
		PrintWriter out = response.getWriter();
		if (result) {
			out.print(result);
		}
		
		return null;
	}

}
