package tan.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Shoes;
import cn.shoesmall.pojo.Shoesdetail;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tan.dao.PageShoesDao;
import tan.form.SelectAllShoesform;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class SelectAllShoesAction extends XywAction{

	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		SelectAllShoesform form = (SelectAllShoesform)arg2;
		Connection conn = DBHelper.getConnection();
		Shoes shoes = new Shoes();
		Shoesdetail detail = new Shoesdetail();
		List<Shoesdetail> shoeslist = new ArrayList<Shoesdetail>();
		PageShoesDao dao = new PageShoesDao();//分页dao
		BaseDao basedao = new BaseDaoImpl();
		
		List<Shoes> list = null;
		
		try {
			conn.setAutoCommit(false);
			
			int pagesize = Integer.valueOf(form.getPagesize());
			list = dao.select(pagesize,conn);
			for (Shoes obj : list) {
				detail.setShoesid(obj.getShoesid());
				int count = 0;
				List<Object> detaillist = basedao.select("selectShoesDetail", detail, conn);
				for (Object object2 : detaillist) {
					detail = (Shoesdetail)object2;
					count += detail.getCount();
				}
				detail.setCount(count);
				System.out.println(detail.toString());
				shoeslist.add(detail);//加入返回集合
			}
			
			conn.commit();
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
		
		PrintWriter out = arg1.getWriter();
		if (!list.isEmpty()) {
			JSONArray arr = JSONArray.fromObject(shoeslist);
			out.print(arr.toString());
		}
		
		return null;
	}

}
