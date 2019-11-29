package xyw.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.json.Json;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Cart;
import cn.shoesmall.pojo.Shoesdetail;
import cn.shoesmall.util.CookieUtil;
import net.sf.json.JSONArray;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import xyw.dto.GoodsDto;
import xyw.utils.JsonUtils;

/**
 * 用户访问购物车的处理业务方式
 * 
 * @author xyw
 *
 */
public class CartAtion extends XywAction {

	/**
	 * 处理,根据用户传过来的用户id查询用户的购物车里的所有商品
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		// 获取登录的账户id
		Cookie auto_login = CookieUtil.findCookie(request.getCookies(), "auto_login");

		String value = auto_login.getValue();

		String accountid = value.split("#itheima#")[3];

		// 通过账户id查询到用户的购物车
		Cart cart = new Cart();
		
		cart.setAccountid(accountid);
		
		BaseDao dao = new BaseDaoImpl();
		
		List list = dao.select("selectCartsByAcid", cart);
		
		List<GoodsDto> gds = new LinkedList<GoodsDto>();
		
		boolean flag = false;
		
		List<Shoesdetail> result = new ArrayList<Shoesdetail>();
		
		Shoesdetail sd = new Shoesdetail();
		
		PrintWriter out = new PrintWriter(response.getWriter(),true);
		
		if (list.size() > 0) {
			
			cart = (Cart) list.get(0);
			
			gds = JsonUtils.toBeanList(JsonUtils.stringToArray(cart.getGoods()), GoodsDto.class);
			
			for (GoodsDto gd : gds) {
				
				if (gd != null) {
					
					sd.setShoesdetailid(gd.getShoesdetailid());
					
					List rs = dao.select("selectByShoesdetailid", sd);
					
					if(rs.size() > 0)
					{
						
						result.add((Shoesdetail) rs.get(0));
						
					}
				}
			}
		}
		
		out.print(JsonUtils.toJsonArrayString(result));
		
		return null;
	}

}
