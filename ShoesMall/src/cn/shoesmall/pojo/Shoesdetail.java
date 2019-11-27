package cn.shoesmall.pojo;

public class Shoesdetail {
	private String shoesid;
	private String shoesdetailid;
	private String color;
	private String size;
	private String descs;
	private float price;
	private int count;
	private int frequence;
	private String image;
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
	@Override
	public String toString() {
		return "Shoesdetail [shoesid=" + shoesid + ", shoesdetailid=" + shoesdetailid + ", color=" + color + ", size="
				+ size + ", descs=" + descs + ", price=" + price + ", count=" + count + ", frequence=" + frequence
				+ ", image=" + image + "]";
	}
	
	
	
}
