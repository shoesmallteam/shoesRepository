package xyw.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Cart;
import cn.shoesmall.util.CookieUtil;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import xyw.dto.GoodsDto;
import xyw.form.AddToCartForm;
import xyw.utils.JsonUtils;
/**
 * 添加到购物车
 * @author xyw
 *
 */
public class AddToCartActon extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		System.out.println("add to cart");
		//获取form
		AddToCartForm form = (AddToCartForm)arg2;
		
		//获取登录的账户id
		Cookie auto_login = CookieUtil.findCookie(request.getCookies(), "auto_login");
		
		String value = auto_login.getValue();
		
		String accountid = value.split("#itheima#")[3];
		//通过账户id查询到用户的购物车		
		Cart cart = new Cart();
		cart.setAccountid(accountid);
		BaseDao dao = new BaseDaoImpl();
		Connection conn = null;
		List list = new ArrayList<Object>();
		try {
			conn = DBHelper.getConnection();
			list = dao.select("selectCartsByAcid", cart, conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.disConnect(conn);
		}
		List<GoodsDto> gds = new LinkedList<GoodsDto>();
		boolean flag = false;
		
		if(list.size() > 0)
		{
			cart = (Cart)list.get(0);
			gds = JsonUtils.toBeanList(JsonUtils.stringToArray(cart.getGoods()), GoodsDto.class);
			//查看是否有此商品，有：累加
			for(GoodsDto gd:gds)
			{
				if(gd != null)
				{
					if(gd.getShoesdetailid().equals(form.getShoesdetailid()))
					{
						System.out.println("+++++++++++++++++1");
						gd.setAmount((Integer.parseInt(gd.getAmount()) + (Integer.parseInt(form.getAmount())))+ "");
						flag = true;
					}
				}
			}
		}
		//无此商品，添加到购物车
		if(!flag)
		{
			GoodsDto gd = new GoodsDto();
			System.out.println("new ++++++++++++++++ 1");
			gd.setAmount(form.getAmount());
			gd.setShoesdetailid(form.getShoesdetailid());
			gds.add(0, gd);
			
		}
		cart.setGoods(JsonUtils.toJsonArrayString(gds));
		System.out.println(cart);
		PrintWriter out = new PrintWriter(response.getWriter(),true);
		boolean result = false;
		try {
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);
			result = dao.update("updateCartById", cart,conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		System.out.println("update result :" + result);
		out.print((result ? "true" : "false"));
		return null;
		//return "success";
	}

}
