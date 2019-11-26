package xyw.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.shoesmall.pojo.Cart;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;

public class CartDaoTest {
	
	@Before
	public void begin()
	{
		System.out.println("begin");
	}
	
	@Test
	public void selectAll() {
		System.out.println(DBHelper.getDoc(Cart.class));
	}
	
	@After
	public void end() {
		System.out.println("end");
	}
	
	public static void main(String[] args) {
		System.out.println(DBHelper.getDoc(tan.pojo.ShoesDetail.class));
	}
}
