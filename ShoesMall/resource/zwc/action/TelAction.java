package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.pojo.Account;

public class TelAction extends XywAction{
	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		//拿到页面传过来的数据
		String tel = arg0.getParameter("tel");
		//System.out.println(tel);
		//拿到数据库里的数据
		BaseDao dao = new BaseDaoImpl();
		Account ac = new Account();
		//通过查出单个进行比较
		ac.setTel(tel);
		List list;
		try {
			list = dao.select("selectAccount", ac, null);
			if (list.size()>0) {
				System.out.println("已存在");
				PrintWriter out = arg1.getWriter();
				out.write(tel);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//通过查出所有然后再循环对比数据
//		List list = dao.select("selectAll", new Account());
//		for (Object object : list) {
//			ac = (Account)object;
//			ac.getTel();
//			for (int i = 0; i < ac.getTel().length(); i++) {
//				if (ac.getTel().equals(tel)) {
//					System.out.println("已存在");
//				}
//			}
//		}
		
		return null;
	}
}
