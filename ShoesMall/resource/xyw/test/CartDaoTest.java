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
	
	}
	
	@After
	public void end() {
		System.out.println("end");
	}
	
	public static void main(String[] args) {
		
	}
}
