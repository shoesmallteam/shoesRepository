package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import cn.shoesmall.util.Encoding;
import cn.shoesmall.util.GenerateAc;
import cn.shoesmall.util.PrimaryKeyGeneric;
import net.sf.json.JSONObject;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.pojo.Account;
import zwc.pojo.Cart;
import zwc.pojo.User;

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
		BaseDao dao = new BaseDaoImpl();
		Account ac = new Account();
		ac.setTel(phonenumber);//电话
		List list = dao.select("selectAccount", ac);
		Account ac1 = new Account();
		ac1.setEmail(email);//邮箱
		List list1 = dao.select("selectAccount1", ac1);
			if (list.size()>0) {
				System.out.println("手机号码已存在");
				PrintWriter out = arg1.getWriter();
				out.write(phonenumber);
			}else if(list1.size()>0){
				System.out.println("邮箱已存在");
				PrintWriter out = arg1.getWriter();
				out.write(email);
			}else if(serverCode.equalsIgnoreCase(verificationcode)){
				//成功将数据存到数据库
				//插入Account表
				ac.setAccountid(PrimaryKeyGeneric.getPrimaryKey());//主键id用UUID
				ac.setAccount(GenerateAc.generateAc());//用户名随机
				ac.setTel(phonenumber);//电话
				ac.setPassword(Encoding.encode(pwd, "MD5"));//密码加密
				ac.setEmail(email);//邮箱
				ac.setIsassistant(0);
				ac.setIsvip(0);
				dao.insert("insertAccount", ac);
				//插入User表
				User user = new User();
				user.setUserid(PrimaryKeyGeneric.getPrimaryKey());//主键id用UUID
				user.setNikename(username);//昵称
				user.setCartid(PrimaryKeyGeneric.getPrimaryKey());//购物车id
				user.setAccountid(ac.getAccountid());//Account表id
				dao.insert("insertUser", user);
				//插入Cart表
				Cart cart = new Cart();
				cart.setAccountid(ac.getAccountid());//Account表id
				cart.setCartid(user.getCartid());//User表购物车id
				dao.insert("insertCart", cart);
				//修改session中验证码,防重复登陆s
				arg0.getSession().setAttribute("code", "、、、");
				//把账号传过去
				PrintWriter out = arg1.getWriter();
				out.write(ac.getAccount());
			}else{
				PrintWriter out = arg1.getWriter();
				out.write(verificationcode);
			}
		
		return null;
	}

}
