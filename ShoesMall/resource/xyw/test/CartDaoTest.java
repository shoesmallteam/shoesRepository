package xyw.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.shoesmall.pojo.Cart;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;

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
		List list = dao.select("selectAll", new Cart());
		
		for(Object o:list)
		{
			System.out.println(o);
		}
	}
}
