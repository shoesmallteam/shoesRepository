package tan.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import cn.shoesmall.pojo.Shoesdetail;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;

public class Test {
	public static void main(String[] args) {
		Shoesdetail shoesdetail = new Shoesdetail();
		BaseDao dao = new BaseDaoImpl();
		HashMap<String, String> map = new HashMap<String, String>();;
		
		shoesdetail.setShoesid("585106793423");
		List<Object> list = dao.select("selectShoesDetail", shoesdetail);
		for (Object object : list) {
			shoesdetail = (Shoesdetail)object;
			System.out.println(shoesdetail.getColor()+"=="+shoesdetail.getImage());
			map.put(shoesdetail.getColor(), shoesdetail.getImage());
		}
		System.out.println(map.size());
	}
}

