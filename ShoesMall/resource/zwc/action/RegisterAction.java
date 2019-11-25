package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import cn.shoesmall.util.PrimaryKeyGeneric;
import net.sf.json.JSONObject;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.pojo.Account;

public class RegisterAction extends XywAction{

	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		//拿到ajax传过来的页面数据
		String username = arg0.getParameter("userName");
		String phonenumber = arg0.getParameter("phoneNumber");
		String pwd = arg0.getParameter("pwd");
		String email = arg0.getParameter("email");
		String verificationcode = arg0.getParameter("verificationCode");
//		//验证验证码
//		//拿到session里的验证码
		String serverCode = arg0.getSession().getAttribute("code").toString();
		//System.out.println(verificationcode);
		//System.out.println(serverCode);
		if (serverCode.equalsIgnoreCase(verificationcode)) {
			//成功将数据存到数据库
			BaseDao dao = new BaseDaoImpl();
			Account ac = new Account();
			ac.setAccountid(PrimaryKeyGeneric.getPrimaryKey());
			ac.setAccount(username);
			ac.setTel(phonenumber);
			ac.setPassword(pwd);
			ac.setEmail(email);
			ac.setIsassistant(0);
			ac.setIsvip(0);
			dao.insert("insertAccount", ac);
			//成功修改session中验证码,防重复登陆s
			arg0.getSession().setAttribute("code", "、、、");
			//JOptionPane.showMessageDialog(null, "注册成功！");
		}
		else{
			//失败后把提示信息存到session中然后展示到页面上
			//arg0.getSession().setAttribute("msg", "验证码错误");
			//JOptionPane.showMessageDialog(null, "注册失败，验证码错误！");
			PrintWriter out = arg1.getWriter();
			out.write(serverCode);
		}
		return null;
	}

}
