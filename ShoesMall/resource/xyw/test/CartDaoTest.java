package xyw.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;
import zwc.pojo.Account;

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
		
		System.out.println(dao.select("selectCartsByAcid", new cn.shoesmall.pojo.Cart()).size());
	}
}
