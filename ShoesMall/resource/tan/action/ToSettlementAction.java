package tan.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Shoesdetail;
import cn.shoesmall.pojo.User;
import cn.shoesmall.util.CookieUtil;
import cn.shoesmall.util.PrimaryKeyGeneric;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tan.dto.ToConfirmDto;
import tan.form.ConfirmForm;
import tan.form.ToSettlementForm;
import tan.pojo.AddressDto;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class ToSettlementAction extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		ConfirmForm form = (ConfirmForm)arg2;
		Connection conn = DBHelper.getConnection();
		
		Cookie cookie = CookieUtil.findCookie(request.getCookies(), "auto_login");
		String value = cookie.getValue();
		String accountid = value.split("#itheima#")[3];
		
		Shoesdetail detail = new Shoesdetail();
		BaseDao dao = new BaseDaoImpl();
		//list存查询的shoesdetail
		List<Shoesdetail> listshoes = new ArrayList<Shoesdetail>();
		//list存生成的订单id
		List<String> orderlist = new ArrayList<String>();
		
		//对象数组
		String items = form.getItems();
		System.out.println(items);
		JSONArray arr = JSONArray.fromObject(items);
		for (int i = 0; i < arr.size(); i++) {
			JSONObject jobj = arr.getJSONObject(i);
			ToSettlementForm shoes = (ToSettlementForm)JSONObject.toBean(jobj, ToSettlementForm.class);
			shoes.invalidate();
			//查询商品详情
			detail.setShoesdetailid(shoes.getShoesdetailid());
			List<Object> list;
			try {
				conn.setAutoCommit(false);
				list = dao.select("selectByShoesdetailid", detail, conn);
				for (Object obj : list) {
					detail = (Shoesdetail)obj;
					detail.setCount(Integer.parseInt(shoes.getCount()));
				}
				//生成订单id
				String orderid = PrimaryKeyGeneric.getPrimaryKey();
				
				listshoes.add(detail);
				orderlist.add(orderid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		AddressDto dto = new AddressDto();//查询数据库的pojo类
		AddressDto address = null;
		List<AddressDto> dtolist = new ArrayList<AddressDto>();
		dto.setAccountid(accountid);
		//查询地址
		List<Object> addresslist;
		try {
			addresslist = dao.select("SelectAddress", dto, conn);
			for (Object object : addresslist) {
				address = (AddressDto)object;
				dtolist.add(address);
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
		
		
		//用DTO像前端传数据
		ToConfirmDto confirmdto = new ToConfirmDto();
		confirmdto.setAddress(address);
		confirmdto.setList(listshoes);
		confirmdto.setOrderlist(orderlist);
		confirmdto.setDtolist(dtolist);
		System.out.println(confirmdto.toString());
		
		if (address != null && listshoes != null) {
			request.setAttribute("confirmdto", confirmdto);
			return "success";
		}

		return null;
	}
	
}
