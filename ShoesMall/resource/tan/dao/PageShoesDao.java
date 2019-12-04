package tan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.shoesmall.pojo.Shoes;

public class PageShoesDao {
	public List<Shoes> select(int pagesize,Connection conn) throws Exception{
		List<Shoes> list = new ArrayList<Shoes>();
		Shoes shoes = null;
		String sql = "select * from shoes limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pagesize-1)*5);
		ps.setInt(2, 5);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			shoes = new Shoes();
			shoes.setShoesid(rs.getString("shoesid"));
			shoes.setShoesname(rs.getString("Shoesname"));
			shoes.setShoesclassifyid(rs.getString("shoesclassifyid"));
			
			list.add(shoes);
		}
		
		return list;
	}
}
