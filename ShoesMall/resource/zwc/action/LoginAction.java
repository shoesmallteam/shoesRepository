package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.util.Encoding;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.pojo.Account;

public class LoginAction extends XywAction{

	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		//拿到ajax传过来的页面数据
		String un = arg0.getParameter("un");
		String pw = arg0.getParameter("pw");
		//数据库里的拿到的数据（密码）
		String newpwd = null;
		//昵称
		String nc = null;
		//加密
		String pw1 = Encoding.encode(pw, "MD5");
		//调用数据库
		BaseDao dao = new BaseDaoImpl();
		Account ac = new Account();//通过账号查询数据
		ac.setAccount(un);//账号
		List list = dao.select("selectAccount2", ac);
		
		if (list.size()==0){
			System.out.println("账号不存在");
			PrintWriter out = arg1.getWriter();
			out.write(un);
		}else{
			System.out.println("账号正确");
			for (Object object : list) {
				ac = (Account)object;
				newpwd= ac.getPassword();
			}
			if(!pw1.equals(newpwd)){
				System.out.println("密码错误");
				PrintWriter out = arg1.getWriter();
				out.write(pw);
			}else{
				System.out.println("密码正确");
				PrintWriter out = arg1.getWriter();
				out.write(newpwd);
			}
		}
		return null;
	}

}
