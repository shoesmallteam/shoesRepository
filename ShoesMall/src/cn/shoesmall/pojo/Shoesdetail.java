package cn.shoesmall.pojo;

public class Shoesdetail {
	private String shoesdetailid;
	private String color;
	private int size;
	private String desc;
	private double price;
	private int count;
	private int frequence;
	private String image;
	private int inventory;
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
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
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	@Override
	public String toString() {
		return "shoesdetail [shoesdetailid=" + shoesdetailid + ", color=" + color + ", size=" + size + ", desc=" + desc
				+ ", price=" + price + ", count=" + count + ", frequence=" + frequence + ", image=" + image
				+ ", inventory=" + inventory + "]";
	}
	
	
	
}
