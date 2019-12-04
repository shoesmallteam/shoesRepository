package tan.action;

import java.io.IOException;
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
		
		//访问频率
		Acfrenquence frenquence = new Acfrenquence();
		frenquence.setAccountid(getAccountid(request, response));
		frenquence.setShoesid(from.getShoesid());
		
		shoesdetail.setShoesid(from.getShoesid());
		
		//查询商品访问频率,有就修改shoesdetail、Acfrenquence的访问频率,没有就新增数据
		List<Object> aflist;
		try {
			aflist = dao.select("selectFrenquence", frenquence, null);
			if (!aflist.isEmpty()) {
				for (Object object : aflist) {
					frenquence = (Acfrenquence)object;
				}
				//修改访问频率
				frenquence.setFrequence(frenquence.getFrequence()+1);
				shoesdetail.setFrequence(frenquence.getFrequence());
				
				boolean flag = dao.update("updateFrequence", frenquence, null);
				boolean sflag = dao.update("updateshoesFrequence", shoesdetail, null);
				if(flag && sflag) {
					frenquence = null;
				}
			}else {
				//增加商品访问频率
				frenquence.setAcfrenquenceid(PrimaryKeyGeneric.getPrimaryKey());
				frenquence.setFrequence(1);
				dao.insert("insertAcfrenquence", frenquence, null);
			}
			
			HashMap<String, String> map = new HashMap<String, String>();
			HashSet<String> size = new HashSet<String>();
			String shoesid = null;
			String descs = null;
			float price = 0;
			int frequence = 0;
			int allcount = 0;
			
			//查询
			shoesdetail.setShoesid(from.getShoesid());
			List<Object> list = dao.select("selectShoesDetail", shoesdetail, null);
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
				
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
	}
	
	public String getAccountid(HttpServletRequest request, HttpServletResponse response) {
		String accountid = null;
		Cookie cookie = CookieUtil.findCookie(request.getCookies(), "auto_login");
		String value = cookie.getValue();
		accountid = value.split("#itheima#")[3];
		
		return accountid;
	}
}
