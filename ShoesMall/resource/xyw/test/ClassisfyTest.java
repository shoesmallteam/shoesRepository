package xyw.test;

import java.net.URLDecoder;
import java.util.List;

import cn.shoesmall.pojo.Cart;
import cn.shoesmall.pojo.Shoes;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.db.DBHelper;

public class ClassisfyTest {
	public static void main(String[] args) {
//		BaseDao dao = new BaseDaoImpl();
//		Shoes shoes = new Shoes();
//		
//		shoes.setShoesname("男");
//		List list = dao.select("selectAll", new Cart());
//		
//		
//		for(int i = 0; i< list.size(); i++)
//		{
//			System.out.println(list.get(i));
//		}
//		
//		System.out.println(list.size());
		//System.out.println(DBHelper.getDoc(Shoes.class));
		
		System.out.println(URLDecoder.decode("%E5%A5%B3"));
		
	}
}
