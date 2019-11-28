package xyw.action;

import java.io.IOException;
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
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import xyw.dto.GoodsDto;
import xyw.form.AddToCartForm;
import xyw.utils.JsonUtils;

public class AddToCartActon extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		
		AddToCartForm form = (AddToCartForm)arg2;
		Cookie auto_login = CookieUtil.findCookie(request.getCookies(), "auto_login");
		
		String value = auto_login.getValue();
		
		String accountid = value.split("#itheima#")[3];
				
		Cart cart = new Cart();
		cart.setAccountid(accountid);
		
		BaseDao dao = new BaseDaoImpl();
		List list = dao.select("selectCartsByAcid", cart);
		List<GoodsDto> gds = new LinkedList<GoodsDto>();
		boolean flag = false;

		if(list.size() > 0)
		{
			cart = (Cart)list.get(0);
			gds = JsonUtils.toBeanList(JsonUtils.stringToArray(cart.getGoods()), GoodsDto.class);
			
			for(GoodsDto gd:gds)
			{
				if(gd != null)
				{
					if(gd.getShoesdetailid().equals(form.getShoesdetailid()))
					{
						gd.setAmount((Integer.parseInt(gd.getAmount()) + (Integer.parseInt(form.getAmount())) + ""));
						flag = true;
					}
				}
			}
		}
		
		if(!flag)
		{
			GoodsDto gd = new GoodsDto();
			
			gd.setAmount(form.getAmount());
			gd.setShoesdetailid(form.getShoesdetailid());
			gds.add(0, gd);
		}
		
		
		cart.setGoods(JsonUtils.toJsonArrayString(gds));
		
		dao.update("updateCartById", cart);
		return null;
	}

}
