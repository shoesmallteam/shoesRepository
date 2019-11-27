package xyw.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Cart;
import cn.shoesmall.pojo.Shoes;
import cn.shoesmall.pojo.Shoesdetail;
import net.sf.json.JSONArray;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import xyw.form.ClassifyForm;

/**
 * 分类处理
 * @author xyw
 *
 */
public class ClassifyAction extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		
		
		ClassifyForm form = (ClassifyForm)arg2;
		
		
		
		BaseDao dao = new BaseDaoImpl();

		Shoesdetail sd = new Shoesdetail();
		
		sd.setDescs(form.getTypename());
		
		
		List list = dao.select("selectByDesc",sd); 
		
		int number = Integer.parseInt(form.getNumber());
		int size = Integer.parseInt(form.getSize());
		
		System.out.println(form);
		
		list = list.subList((number - 1) * size, size);
		
		System.out.println(list.size());

		
		JSONArray jo = JSONArray.fromObject(list);
		
		
		PrintWriter out = response.getWriter();
		
		out.print(jo.toString());
		
		return null;
	}

}
