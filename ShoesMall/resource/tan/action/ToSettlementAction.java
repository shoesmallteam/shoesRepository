package tan.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Shoesdetail;
import cn.shoesmall.pojo.User;
import cn.shoesmall.util.CookieUtil;
import tan.dto.ToConfirmDto;
import tan.form.ToSettlementForm;
import tan.pojo.AddressDto;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class ToSettlementAction extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		ToSettlementForm form = (ToSettlementForm)arg2;
		form.invalidate();
		Cookie cookie = CookieUtil.findCookie(request.getCookies(), "auto_login");
		String value = cookie.getValue();
		String accountid = value.split("#itheima#")[3];
		
		Shoesdetail detail = new Shoesdetail();
		BaseDao dao = new BaseDaoImpl();
		
		//查询商品详情
		detail.setShoesdetailid(form.getShoesdetailid());
		List<Object> list = dao.select("selectByShoesdetailid", detail);
		for (Object obj : list) {
			detail = (Shoesdetail)obj;
			detail.setCount(Integer.parseInt(form.getCount()));
		}

		AddressDto dto = new AddressDto();//查询数据库的pojo类
		AddressDto address = null;
		dto.setAccountid(accountid);
		//查询地址
		List<Object> addresslist = dao.select("SelectAddress", dto);
		for (Object object : addresslist) {
			address = (AddressDto)object;
		}
		
		//用DTO像前端传数据
		ToConfirmDto confirmdto = new ToConfirmDto();
		confirmdto.setAddress(address);
		confirmdto.setDetail(detail);
		
		request.setAttribute("confirmdto", confirmdto);
		
		if (address != null && detail != null) {
			return "success";
		}
		return "error";
	}
	
}
