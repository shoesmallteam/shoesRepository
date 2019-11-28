package xyw.test;

import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.shoesmall.pojo.Cart;
import net.sf.json.JSONArray;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.dto.GoodsDto;

public class CartDaoTest {
	
	@Before
	public void begin()
	{
		System.out.println("begin");
	}
	
	@Test
	public void selectAll() {
		BaseDao dao = new BaseDaoImpl();
		
		System.out.println(dao.select("selectAll", new cn.shoesmall.pojo.Cart()));
	}
	
	@After
	public void end() {
		System.out.println("end");
	}
	
	public static void main(String[] args) {
		BaseDao dao = new BaseDaoImpl();
		GoodsDto gd = new GoodsDto();
		
		gd.setShoesdetailid("0005802b-5b64-4956-9802-cb461e4883b0");
		gd.setAmount("10");
		String accountid = "2972e7a5-293d-4903-8286-8f377f568a9d";
		
		Cart cart = new Cart();
		cart.setAccountid(accountid);
		
		List list = dao.select("selectCartsByAcid", cart);
		
		if(list.size() > 0)
		{
			cart = (Cart)list.get(0);
		}
				
		List<GoodsDto> lgs = new ArrayList<GoodsDto>();
		
		lgs.add(gd);
		
		
		JSONArray ja = JSONArray.fromObject(lgs);
		
		cart.setGoods(ja.toString());
		System.out.println(cart);
		
		String gds = cart.getGoods();
		
		

	}
}
