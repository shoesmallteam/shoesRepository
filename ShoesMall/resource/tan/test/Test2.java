package tan.test;

import java.lang.reflect.Field;

import cn.shoesmall.pojo.Shoesdetail;
import xyw.core.dao.BaseDao;
import xyw.core.dao.impl.BaseDaoImpl;
import xyw.core.util.GenericMappingFile;

public class Test2 {
	public static void main(String[] args) throws Exception {
		Shoesdetail sd = new Shoesdetail();
		
		sd.setColor("color");
		sd.setCount(20);
		sd.setDescs("desc");
		sd.setFrequence(20);
		sd.setImage("image");
		sd.setPrice(152f);
		sd.setShoesdetailid("detailid");
		sd.setShoesid("shoesid");
		sd.setSize("size");
		
		
		BaseDao dao = new BaseDaoImpl();
		
		dao.insert("insertsd", sd);
		
		//getInsertSql(sd.getClass());
		//GenericMappingFile.generic(sd.getClass(), "C:\\Users\\admin\\git\\Test\\ShoesMall\\src");
	}
	
	
	public static void getInsertSql(Class c) throws Exception {
		System.out.println(c.getName());
		
		String className = c.getName();
		
		className = className.substring(className.lastIndexOf(".") + 1);
		
		className = className.substring(0,1).toLowerCase() + className.substring(1);
		System.out.println(className);
		
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("insert into ");
		
		
		sb.append(className + "(");
		
		
		Field[] fs = c.getDeclaredFields();
		
		for(int i = 0; i < fs.length; i++)
		{
			
			sb.append(fs[i].getName());
			if(i + 1 == fs.length) {
				sb.append(")");
			}else {
				sb.append(",");
			}
			
		}
		
		sb.append("\n values(");
		
		for(int i = 0; i < fs.length; i++)
		{
			
			sb.append("#{"+fs[i].getName()+"}");
			if(i + 1 == fs.length) {
				sb.append(")");
			}else {
				sb.append(",");
			}
			
		}
		
		
		System.out.println(sb.toString());
		
		
	}
}
