package cn.shoesmall.util;

import java.io.File;
import java.io.FileInputStream;

public class PhotoToByte {
	public static byte[] photoToByte(String path) throws Exception{
		FileInputStream fis = new FileInputStream(new File(path));
		byte[] b = new byte[fis.available()];
		fis.read(b, 0, fis.available());
		fis.close();
		return b;
	}
}
