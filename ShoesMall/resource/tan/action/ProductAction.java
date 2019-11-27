package tan.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shoesmall.pojo.Shoesdetail;
import tan.dto.ShoesDto;
import tan.form.ProductForm;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class ProductAction extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		ProductForm from = (ProductForm)arg2;
		Shoesdetail shoesdetail = new Shoesdetail();
		ShoesDto dto = new ShoesDto();
		BaseDao dao = new BaseDaoImpl();
		
		HashMap<String, String> map = new HashMap<String, String>();
		HashSet<String> size = new HashSet<String>();
		String shoesid = null;
		String descs = null;
		float price = 0;
		int frequence = 0;
		int allcount = 0;
		
		//查询
		shoesdetail.setShoesid(from.getShoesid());
		List<Object> list = dao.select("selectShoesDetail", shoesdetail);
		if (!list.isEmpty()) {
			for (Object object : list) {
				shoesdetail = (Shoesdetail)object;
				shoesid = shoesdetail.getShoesid();
				descs = shoesdetail.getDescs();
				price = shoesdetail.getPrice();
				frequence = shoesdetail.getFrequence();
				allcount += shoesdetail.getCount();
				map.put(shoesdetail.getColor(), shoesdetail.getImage());
				size.add(shoesdetail.getSize());
			}
			dto.setShoesid(shoesid);
			dto.setDescs(descs);
			dto.setPrice(price);
			dto.setFrequence(frequence);
			dto.setAllcount(allcount);
			dto.setColor(map);
			dto.setSize(size);
			
			request.setAttribute("dto", dto);
			
			return "success";
		}
		
		return "error";
	}

}
