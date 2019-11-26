package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.pojo.Account;

public class EmailAction extends XywAction{

	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		//拿到页面传过来的数据
		String email = arg0.getParameter("email");
		//拿到数据库里的数据
		BaseDao dao = new BaseDaoImpl();
		Account ac = new Account();
		//通过查出单个进行比较
		ac.setEmail(email);
		List list = dao.select("selectAccount1", ac);
		if (list.size()>0) {
			System.out.println("已存在");
			PrintWriter out = arg1.getWriter();
			out.write(email);
		}
		return null;
	}

}
