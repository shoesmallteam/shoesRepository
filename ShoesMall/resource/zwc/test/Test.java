package zwc.test;


import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import zwc.pojo.Account;

public class Test {
	public static void main(String[] args) {
		BaseDao dao = new BaseDaoImpl();
		
		System.out.println(dao.select("selectAll", new Account()));
	}
}
