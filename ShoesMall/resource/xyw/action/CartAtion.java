package xyw.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import xyw.dto.GoodsDto;
import xyw.pojo.Goods;
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
		Connection conn = null;
		// 获取登录的账户id
		Cookie auto_login = CookieUtil.findCookie(request.getCookies(), "auto_login");

		String value = auto_login.getValue();

		String accountid = value.split("#itheima#")[3];

		// 通过账户id查询到用户的购物车
		Cart cart = new Cart();
		
		cart.setAccountid(accountid);
		List list = new ArrayList<Object>();
		BaseDao dao = new BaseDaoImpl();
		try {
			conn = DBHelper.getConnection();
			list = dao.select("selectCartsByAcid", cart,conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<GoodsDto> gds = new LinkedList<GoodsDto>();
		
		boolean flag = false;
		
		List<Goods> result = new ArrayList<Goods>();
		
		Shoesdetail sd = new Shoesdetail();
		
		PrintWriter out = new PrintWriter(response.getWriter(),true);
		
		if (list.size() > 0) {
			
			cart = (Cart) list.get(0);
			
			gds = JsonUtils.toBeanList(JsonUtils.stringToArray(cart.getGoods()), GoodsDto.class);
			
			for (GoodsDto gd : gds) {
				
				if (gd != null) {
					List rs = new ArrayList<Object>();
					sd.setShoesdetailid(gd.getShoesdetailid());
					try {
				
						rs = dao.select("selectByShoesdetailid", sd,conn);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					if(rs.size() > 0)
					{
						Goods goods = new Goods((Shoesdetail) rs.get(0));
						goods.setAmount(Integer.parseInt(gd.getAmount()));
						result.add(goods);
						
					}
				}
			}
		}
		
		out.print(JsonUtils.toJsonArrayString(result));
		
		return null;
	}

}
