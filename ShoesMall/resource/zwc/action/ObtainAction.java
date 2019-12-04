package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.util.GenerateAc;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import xyw.util.SendmailUtil;
/*
 * 生成邮箱验证码的servlet
 */
public class ObtainAction extends XywAction{

	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		//拿到ajax传过来的页面数据
		String f = arg0.getParameter("f");
		//随机生成六位数验证码
		String s = GenerateAc.generateAc1();
		//发送到邮箱
		SendmailUtil.send(f, f, s);
		//同时把数据返回到界面
		PrintWriter out = arg1.getWriter();
		out.write(s);
		System.out.println(s);
		return null;
	}

}
