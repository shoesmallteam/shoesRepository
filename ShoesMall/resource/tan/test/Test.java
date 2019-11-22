package tan.test;

import cn.shoesmall.util.PrimaryKeyGeneric;
import tan.pojo.User;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;

public class Test {
	public static void main(String[] args) {
		BaseDao dao = new BaseDaoImpl();
		
		User user = new User();
		
		user.setUserid(PrimaryKeyGeneric.getPrimaryKey());
		user.setAccountid(PrimaryKeyGeneric.getPrimaryKey());
		user.setCartid(PrimaryKeyGeneric.getPrimaryKey());
		user.setNikename("tan");
		user.setAddress("hello thank you");
		
		
		
		dao.insert("insertUser", user);
	}
}
