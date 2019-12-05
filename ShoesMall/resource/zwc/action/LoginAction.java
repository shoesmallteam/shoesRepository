package zwc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
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
import xyw.core.db.DBHelper;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import zwc.info.PersonInfo;
import zwc.pojo.Account;
import zwc.pojo.User;
/*
 * 登陆的servlet
 */
public class LoginAction extends XywAction{

	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		//拿到ajax传过来的页面数据
		String un = arg0.getParameter("un");
		String pw = arg0.getParameter("pw");
		//调用数据库
		BaseDao dao = new BaseDaoImpl();
		//正则判断un是账号还是手机号还是邮箱
		String em = null;
		String ph = null;
		String uu = null;
		int isa = 0;
		Cookie cookie = null;
		Connection conn = DBHelper.getConnection();
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
			try {
				conn.setAutoCommit(false);
				list = dao.select("selectAccount1", ac, conn);
				conn.commit();
			} catch (Exception e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}else if(m2.find()){
			System.out.println("输入的登陆账号是手机号");
			ph = un;
			ac.setTel(ph);
			try {
				conn.setAutoCommit(false);
				list = dao.select("selectAccount", ac, conn);
				conn.commit();
			} catch (Exception e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}else{
			System.out.println("输入的登陆账号就是账号");
			uu = un;
			ac.setAccount(un);
			try {
				conn.setAutoCommit(false);
				list = dao.select("selectAccount2", ac, conn);
				conn.commit();
			} catch (Exception e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
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
				isa = ac.getIsassistant();
				user.setAccountid(id);
				List list1;
				try {
					conn.setAutoCommit(false);
					list1 = dao.select("selectUserAccountid", user, conn);
					for (Object object2 : list1) {
						user = (User)object2;
						nc = user.getNikename();//获得昵称
						System.out.println(nc);
					}
					conn.commit();
				} catch (Exception e) {
					try {
						conn.rollback();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}finally{
					DBHelper.disConnect(conn);
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
				p.setAccount(id);//账号
				p.setIp(arg0.getRemoteAddr());//IP
				p.setLoginDate(new Date());//时间
				//arg0.getServletContext().setAttribute("personInfo",p);
				arg0.getSession().setAttribute("personInfo",p);//把信息存入session中
				//如果要管理员就跳到管理员界面
				if(isa==1) {
					System.out.println("登录的帐号是管理员");
					PrintWriter out = arg1.getWriter();
					out.write(un+pw);
				}else {
					System.out.println("登录的帐号是普通用户");
					PrintWriter out = arg1.getWriter();
					out.write(nc);//输出昵称
				}
			}
		}
		return null;
	}

}
