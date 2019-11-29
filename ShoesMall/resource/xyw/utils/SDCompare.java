package xyw.utils;

import java.util.Comparator;

import cn.shoesmall.pojo.Shoesdetail;

public class SDCompare implements Comparator<Shoesdetail>{

	private boolean desc = false;
	public SDCompare() {}
	
	public void setDesc(boolean desc) {
		this.desc = desc;
	}
	
	public SDCompare(boolean desc)
	{
		this.desc = desc;
	}

	@Override
	public int compare(Shoesdetail o1, Shoesdetail o2) {
		int result = (int) (o1.getPrice() - o2.getPrice());
		if(this.desc)
		{
			return -result;
		}else {
			return result;
		}
	}


}
