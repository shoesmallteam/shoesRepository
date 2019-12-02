package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.util.Encoding;
import sun.misc.BASE64Encoder;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.info.PersonInfo;
import zwc.pojo.Account;
import zwc.pojo.User;

public class LoginAction extends XywAction{

	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		//拿到ajax传过来的页面数据
		String un = arg0.getParameter("un");
		String pw = arg0.getParameter("pw");
		//正则判断un是账号还是手机号还是邮箱
		String em = null;
		String ph = null;
		String uu = null;
		Cookie cookie = null;
		//调用数据库
		BaseDao dao = new BaseDaoImpl();
		Account ac = new Account();
		Pattern email = Pattern.compile("^\\w+@\\w+\\.(net|com|cn|org)+$");
		Pattern photo = Pattern.compile("^1[3456789]\\d{9}$");
		List list = null;
		Matcher m1 = email.matcher(un);
		Matcher m2 = photo.matcher(un);
		if(m1.find()){
			System.out.println("输入的登陆账号是邮箱");
			em = un;
			ac.setEmail(em);
			list = dao.select("selectAccount1", ac);
		}else if(m2.find()){
			System.out.println("输入的登陆账号是手机号");
			ph = un;
			ac.setTel(ph);
			list = dao.select("selectAccount", ac);
		}else{
			System.out.println("输入的登陆账号就是账号");
			uu = un;
			ac.setAccount(un);
			list = dao.select("selectAccount2", ac);
		}
		
		//数据库里的拿到的数据
		String newpwd = null;//密码
		String nc = null;//昵称
		String id = null;//UUID主键id
		String name = null;//名字
		String sex = null;//性别
		String bir = null;//生日
		//加密
		String pw1 = Encoding.encode(pw, "MD5");
		User user = new User();
		if (list.size()==0){
			System.out.println("登陆账号不存在");
			PrintWriter out = arg1.getWriter();
			out.write(un);
		}else{
			System.out.println("账号正确");
			for (Object object : list) {
				ac = (Account)object;
				newpwd= ac.getPassword();
				id = ac.getAccountid();//获得主键
				name = ac.getSsname();
				sex = ac.getSssex();
				bir = ac.getSsbirthday();
				user.setAccountid(id);
				List list1 = dao.select("selectUserAccountid", user);
				for (Object object2 : list1) {
					user = (User)object2;
					nc = user.getNikename();//获得昵称
					System.out.println(nc);
				}
			}
			if(!pw1.equals(newpwd)){
				System.out.println("密码错误");
				PrintWriter out = arg1.getWriter();
				out.write(pw);
			}else{
				System.out.println("密码正确");
				//登录成功就往cookie里面存数据
				if(em!=null){
					cookie = new Cookie("auto_login",em+"#itheima#"+pw1+"#itheima#"+nc+"#itheima#"+id+"#itheima#"+name+"#itheima#"+sex+"#itheima#"+bir);
					//System.out.println(cookie);
				}else if(ph!=null){
					cookie = new Cookie("auto_login",ph+"#itheima#"+pw1+"#itheima#"+nc+"#itheima#"+id+"#itheima#"+name+"#itheima#"+sex+"#itheima#"+bir);
				}else{
					cookie = new Cookie("auto_login",uu+"#itheima#"+pw1+"#itheima#"+nc+"#itheima#"+id+"#itheima#"+name+"#itheima#"+sex+"#itheima#"+bir);	
				}
				//设置IP
				cookie.setDomain("localhost");
				//设置工程
				cookie.setPath("/ShoesMall");
				//设置时间
				cookie.setMaxAge(60*60*24*7);
				arg1.addCookie(cookie);
				//把信息存入info,用于单态
				PersonInfo p = new PersonInfo();
				p.setAccount(un);//账号
				p.setIp(arg0.getRemoteAddr());//IP
				p.setLoginDate(new Date());//时间
				//arg0.getServletContext().setAttribute("personInfo",p);
				arg0.getSession().setAttribute("personInfo",p);//把信息存入session中
				PrintWriter out = arg1.getWriter();
				out.write(nc);//输出昵称
			}
		}
		return null;
	}

}
