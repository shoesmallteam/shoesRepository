package cn.shoesmall.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoding {
    public static String encode(String src,String type)
    {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(type);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] dest;
        try {
            md.update(src.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dest = md.digest();
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : dest) {
            stringBuilder.append(Integer.toHexString(b));
        }
        return stringBuilder.toString();
    }
}
