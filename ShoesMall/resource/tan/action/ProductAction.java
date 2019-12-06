package tan.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Acfrenquence;
import cn.shoesmall.pojo.Shoesdetail;
import cn.shoesmall.util.CookieUtil;
import cn.shoesmall.util.PrimaryKeyGeneric;
import tan.dto.ShoesDto;
import tan.form.ProductForm;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class ProductAction extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		ProductForm from = (ProductForm)arg2;
		Shoesdetail shoesdetail = new Shoesdetail();
		ShoesDto dto = new ShoesDto();
		BaseDao dao = new BaseDaoImpl();
		Connection conn = DBHelper.getConnection();
		
		//访问频率
		Acfrenquence frenquence = new Acfrenquence();
		frenquence.setAccountid(getAccountid(request, response));
		frenquence.setShoesid(from.getShoesid());
		
		shoesdetail.setShoesid(from.getShoesid());
		//判断是否登录，没有就不修改访问频率
		//查询商品访问频率,有就修改shoesdetail、Acfrenquence的访问频率,没有就新增数据
		List<Object> aflist;
		if(getAccountid(request, response) != null) {
			try {
				conn.setAutoCommit(false);
				aflist = dao.select("selectFrenquence", frenquence, conn);
				if (!aflist.isEmpty()) {
					for (Object object : aflist) {
						frenquence = (Acfrenquence)object;
					}
					//修改访问频率
					frenquence.setFrequence(frenquence.getFrequence()+1);
					shoesdetail.setFrequence(frenquence.getFrequence());
					
					boolean flag = dao.update("updateFrequence", frenquence, conn);
					boolean sflag = dao.update("updateshoesFrequence", shoesdetail, conn);
					if(flag && sflag) {
						frenquence = null;
					}
				}else {
					//增加商品访问频率
					frenquence.setAcfrenquenceid(PrimaryKeyGeneric.getPrimaryKey());
					frenquence.setFrequence(1);
					dao.insert("insertAcfrenquence", frenquence, conn);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			conn.setAutoCommit(false);
			HashMap<String, String> map = new HashMap<String, String>();
			HashSet<String> size = new HashSet<String>();
			String shoesid = null;
			String descs = null;
			float price = 0;
			int frequence = 0;
			int allcount = 0;
			
			//查询
			shoesdetail.setShoesid(from.getShoesid());
			List<Object> list = dao.select("selectShoesDetail", shoesdetail, conn);
			if (!list.isEmpty()) {
				for (Object object : list) {
					shoesdetail = (Shoesdetail)object;
					shoesid = shoesdetail.getShoesid();
					descs = shoesdetail.getDescs();
					price = shoesdetail.getPrice();
					frequence = shoesdetail.getFrequence();
					allcount += shoesdetail.getCount();
					map.put(shoesdetail.getColor(), shoesdetail.getImage());
					size.add(shoesdetail.getSize());
				}
				dto.setShoesid(shoesid);
				dto.setDescs(descs);
				dto.setPrice(price);
				dto.setFrequence(frequence);
				dto.setAllcount(allcount);
				dto.setColor(map);
				dto.setSize(size);
				
				request.setAttribute("dto", dto);
				
				conn.commit();
				return "success";
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
		
		return "error";
	}
	
	public String getAccountid(HttpServletRequest request, HttpServletResponse response) {
		String accountid = null;
		Cookie cookie = CookieUtil.findCookie(request.getCookies(), "auto_login");
		if(cookie != null) {
			String value = cookie.getValue();
			accountid = value.split("#itheima#")[3];
			return accountid;
		}
		
		return null;
	}
}
