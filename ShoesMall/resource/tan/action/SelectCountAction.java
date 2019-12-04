package tan.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Shoesdetail;
import net.sf.json.JSONObject;
import tan.form.SelectCountForm;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
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
		
		//拿数据
		List<Object> list;
		try {
			list = dao.select("selectCount", detail, null);
			for (Object object : list) {
				detail = (Shoesdetail)object;
				JSONObject returnshoes = JSONObject.fromObject(detail);
				out.print(returnshoes.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
