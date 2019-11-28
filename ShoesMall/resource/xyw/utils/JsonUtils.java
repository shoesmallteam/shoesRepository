package xyw.utils;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

public class JsonUtils {
	public static String toJsonArrayString(List list)
	{
		String result = "";
		
		result = JSONArray.fromObject(list).toString();
		
		return result;
	}
	
	public static List toBeanList(JSONArray src,Class c)
	{
		List list = new ArrayList<Object>();
		
		list = JSONArray.toList(src, c);
		
		return list;
	}
	
	public static JSONArray stringToArray(String src)
	{
		return JSONArray.fromObject(src);
	}
}
