package zwc.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;

public class ImgAction extends XywAction{
	//图片的宽和高
	private static int WIDTH = 150;
	private static int HEIGHT = 35;
	//随机验证码个数
	private static int CODE = 4;
	//干扰点个数
	private static int POINT = 200;
	private String[] str = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
					"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
					"X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
	private Random r = new Random();
	@Override
	public String execute(HttpServletRequest arg0, HttpServletResponse arg1, XywForm arg2)
			throws ServletException, IOException {
		//获得一个输出流
		ServletOutputStream sos = arg1.getOutputStream();
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		//总共产生的随机验证码
		for (int i = 0; i < CODE; i++) {
			int index = r.nextInt(str.length);//随机生成
			sb1.append(str[index]);
			sb2.append(str[index]+" ");
		}
		//验证码
		String content = sb1.toString();
		//请求得到一个session,并把验证码存到session中
		System.out.println(content);
		arg0.getSession().setAttribute("code", content);
		//内存中一个缓存的图片对象
		BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		//获得图片画笔
		Graphics g = bi.getGraphics();
		//上色
		g.setColor(randomColor());
		//画外框
		g.drawRect(0, 0, WIDTH, HEIGHT);
		//填充背景
		g.setColor(randomColor());
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//写内容
		g.setColor(randomColor());
		g.setFont(new Font("宋体", Font.BOLD, 20));
		g.drawString(sb2.toString(), r.nextInt(45)+1, 22);
		//画干扰点
		for (int i = 0; i < POINT; i++) {
			int x = r.nextInt(WIDTH);
			int y = r.nextInt(HEIGHT);
			g.drawLine(x, y, x, y);
		}
		//画干扰线
		int x1 = r.nextInt(30);
		int x2 = r.nextInt(130);
		int y1 = r.nextInt(30);
		int y2 = r.nextInt(30);
		int x11 = r.nextInt(20);
		int x22 = r.nextInt(120);
		int y11 = r.nextInt(20);
		int y22 = r.nextInt(20);
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x11, y11, x22, y22);
		//将内存中生产的图片写入输出流中
		ImageIO.write(bi, "jpg", sos);
		sos.flush();
		sos.close();
		return null;
	}
	//获得随机颜色的方法
	public static Color randomColor() {
	      	Random random = new Random();
	        int r = random.nextInt(256);
	        int g = random.nextInt(256);
	        int b = random.nextInt(256);
	        return new Color(r, g, b);
	    }

}
