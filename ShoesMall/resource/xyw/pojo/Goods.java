package xyw.pojo;

import cn.shoesmall.pojo.Shoesdetail;

public class Goods {
	private String shoesid;
	private String shoesdetailid;
	private String color;
	private String size;
	private String descs;
	private float price;
	private int count;
	private int frequence;
	private String image;
	private int amount;
	
	public Goods(Shoesdetail sd)
	{
		this.color = sd.getColor();
		this.count = sd.getCount();
		this.descs = sd.getDescs();
		this.frequence = sd.getFrequence();
		this.image = sd.getImage();
		this.price = sd.getPrice();
		this.shoesdetailid = sd.getShoesdetailid();
		this.shoesid = sd.getShoesid();
		this.size = sd.getSize();
	}
	public String getShoesdetailid() {
		return shoesdetailid;
	}
	public void setShoesdetailid(String shoesdetailid) {
		this.shoesdetailid = shoesdetailid;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDescs() {
		return descs;
	}
	public void setDescs(String desc) {
		this.descs = desc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getFrequence() {
		return frequence;
	}
	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getShoesid() {
		return shoesid;
	}
	public void setShoesid(String shoesid) {
		this.shoesid = shoesid;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Goods [shoesid=" + shoesid + ", shoesdetailid=" + shoesdetailid + ", color=" + color + ", size=" + size
				+ ", descs=" + descs + ", price=" + price + ", count=" + count + ", frequence=" + frequence + ", image="
				+ image + ", amount=" + amount + "]";
	}
	
}
