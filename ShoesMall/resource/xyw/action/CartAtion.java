package xyw.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Cart;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import xyw.form.CartForm;

/**
 * 用户访问购物车的处理业务方式
 * @author xyw
 *
 */
public class CartAtion extends XywAction{

	/**
	 * 处理
	 */
	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		CartForm form = (CartForm)arg2;
		
		
		BaseDao dao = new BaseDaoImpl();
		
		
		Cart cart = new Cart();
		
		cart.setAccountid(form.getAccountid());
		List list = dao.select("selectCartsByAcid", cart);
		
		System.out.println(list.size());
		
		return null;
	}

}
