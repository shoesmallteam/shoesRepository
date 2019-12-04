package xyw.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.shoesmall.pojo.Cart;
import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.dto.GoodsDto;
import xyw.utils.JsonUtils;

public class CartDaoTest {
	
	@Before
	public void begin()
	{
		System.out.println("begin");
	}
	
	@Test
	public void selectAll() {
		BaseDao dao = new BaseDaoImpl();
		
//		System.out.println(dao.select("selectAll", new cn.shoesmall.pojo.Cart()));
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
		
//		List list = dao.select("selectCartsByAcid", cart);
		
//		if(list.size() > 0)
//		{
//			cart = (Cart)list.get(0);
//		}
//				
//		List<GoodsDto> lgs = new ArrayList<GoodsDto>();
//		
//		lgs.add(gd);
//		
//		
//		
//		cart.setGoods(JsonUtils.toJsonArrayString(lgs));
//		
//		String gds = cart.getGoods();
//		
//		System.out.println(gds);
//		
//		List<GoodsDto> ls = JsonUtils.toBeanList(JsonUtils.stringToArray(gds), GoodsDto.class);
//		
//		GoodsDto gd1 = new GoodsDto();
//		gd1.setShoesdetailid("hello world");
//		
//		gd1.setAmount("20");
//		ls.add(gd1);
//		
//		System.out.println(JsonUtils.toJsonArrayString(ls));
	}
}
