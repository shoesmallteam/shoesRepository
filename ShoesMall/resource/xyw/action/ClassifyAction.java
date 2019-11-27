package xyw.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.Decoder;
import org.apache.tomcat.util.codec.DecoderException;

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
		
		sd.setDescs(decode(form.getTypename()));
				
		List list = dao.select("selectByDesc",sd); 
		System.out.println(form);

		
		int number = Integer.parseInt(form.getNumber());
				
		int size = Integer.parseInt(form.getSize());
		System.out.println("共:" +list.size());
		
		
		
		if(list.size() > 0) {
			System.out.println((number - 1) * size+":"+ number * size);
			list = list.subList((number - 1) * size, number * size);
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