package tan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.shoesmall.pojo.Account;

public class PageDao {
	public List<Account> select(int pagesize,Connection conn) throws Exception{
		List<Account> list = new ArrayList<Account>();
		Account account = null;
		String sql = "select accountid,account,password,tel,email,isassistant,isvip from account limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pagesize-1)*10);
		ps.setInt(2, 10);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			account = new Account();
			account.setAccountid(rs.getString("accountid"));
			account.setAccount(rs.getString("account"));
			account.setPassword(rs.getString("password"));
			account.setEmail(rs.getString("email"));
			account.setTel(rs.getString("tel"));
			account.setIsassistant(rs.getInt("isassistant"));
			account.setIsvip(rs.getInt("isvip"));
			
			list.add(account);
		}
		
		return list;
	}
}
