package cn.shoesmall.util;

import java.util.UUID;

public class PrimaryKeyGeneric {
	public static String getPrimaryKey() {
		
		return UUID.randomUUID().toString();
		
	}
}
