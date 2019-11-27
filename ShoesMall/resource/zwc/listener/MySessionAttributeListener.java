package zwc.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import zwc.info.PersonInfo;
/*
 * 实现单态登陆的监听器
 */
public class MySessionAttributeListener implements HttpSessionAttributeListener{
	Map<String, HttpSession> map = new HashMap<String, HttpSession>();
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		//获得session中存入的key（固定是personInfo）
		String name = arg0.getName();
		// 登录
		if (name.equals("personInfo")) {
			PersonInfo personInfo = (PersonInfo) arg0.getValue();
				if (map.get(personInfo.getAccount()) != null) {
					// map 中有记录，表明该帐号在其他机器上登录过，将以前的登录失效
					HttpSession session = map.get(personInfo.getAccount());//拿出原来的session
					PersonInfo oldPersonInfo = (PersonInfo) session.getAttribute("personInfo");//map已经存在的旧的信息
					System.out.println("帐号" + oldPersonInfo.getAccount() + "在" + oldPersonInfo.getIp() + "已经登录，该登录将被迫下线。");
						session.removeAttribute("personInfo");//清除原来的session
						session.setAttribute("msg", "您的帐号已经在其他机器上登录，您被迫下线。");
					}
					// 将session以用户名为索引，放入map中
					map.put(personInfo.getAccount(), arg0.getSession());
					System.out.println("帐号" + personInfo.getAccount() + "在" + personInfo.getIp() + "登录。");
				}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		String name = arg0.getName();
		// 注销
		if (name.equals("personInfo")) {
			// 将该session从map中移除
			PersonInfo personInfo = (PersonInfo) arg0.getValue();
			map.remove(personInfo.getAccount());
			System.out.println("帐号" + personInfo.getAccount() + "注销。");
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		String name = arg0.getName();
		// 没有注销的情况下，用另一个帐号登录
		if (name.equals("personInfo")) {
			// 移除旧的的登录信息
			PersonInfo oldPersonInfo = (PersonInfo) arg0.getValue();
			map.remove(oldPersonInfo.getAccount());
			// 新的登录信息
			PersonInfo personInfo = (PersonInfo) arg0.getSession().getAttribute("personInfo");
			// 也要检查新登录的帐号是否在别的机器上登录过
			if (map.get(personInfo.getAccount()) != null) {
				// map 中有记录，表明该帐号在其他机器上登录过，将以前的登录失效
				HttpSession session = map.get(personInfo.getAccount());
				session.removeAttribute("personInfo");
				session.setAttribute("msg", "您的帐号已经在其他机器上登录，您被迫下线。");
			}
			map.put(personInfo.getAccount(), arg0.getSession());
		}
	}

}
