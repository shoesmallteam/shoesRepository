package xyw.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import xyw.utils.SDCompare;

/**
 * 分类处理
 * @author xyw
 *
 */
public class ClassifyAction extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		
		Connection conn = null;
		ClassifyForm form = (ClassifyForm)arg2;
		
		
		System.out.println(form);
		
		BaseDao dao = new BaseDaoImpl();
		
		Shoesdetail sd = new Shoesdetail();
		sd.setPrice(111);
		sd.setDescs(decode(form.getTypename()));
		List list = new ArrayList<Object>();
		try {
			conn = DBHelper.getConnection();
			list = dao.select("selectByDesc",sd,conn); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		int number = Integer.parseInt(form.getNumber());
				
		int size = Integer.parseInt(form.getSize());
		System.out.println("共:" +list.size());
		//SDCompare sdc = new SDCompare();

		//Collections.sort(list,sdc);
		
		if(list.size() > (number - 1) * size) {
			System.out.println((number - 1) * size+":"+ number * size);
			if(list.size() > size * number) {
				list = list.subList((number - 1) * size, number * size);				
			}else {
				list = list.subList((number - 1) * size, list.size());
			}
		}
		
		System.out.println("需要:" + list.size());
				
		JSONArray jo = JSONArray.fromObject(list);
		
		
		PrintWriter out = response.getWriter();
		
		out.print(jo.toString());
		
		return null;
	}
	
	private String decode(String s)
	{
		String result = "";
		try {
			result = URLDecoder.decode(s, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
