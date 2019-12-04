package zwc.test;


import cn.shoesmall.util.GenerateAc;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.util.SendmailUtil;
import zwc.pojo.Account;

public class Test {
	public static void main(String[] args) {
		SendmailUtil.send("466268726@qq.com", "466268726@qq.com", GenerateAc.generateAc1());
	}
}
