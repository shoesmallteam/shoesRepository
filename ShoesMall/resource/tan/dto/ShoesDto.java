package tan.dto;

import java.util.HashMap;
import java.util.HashSet;

public class ShoesDto {
	private String shoesid;
	private String descs;
	private float price;
	private int frequence;
	private int allcount;
	private HashMap<String, String> color;
	private HashSet<String> size;
	public String getShoesid() {
		return shoesid;
	}
	public void setShoesid(String shoesid) {
		this.shoesid = shoesid;
	}
	public String getDescs() {
		return descs;
	}
	public void setDescs(String descs) {
		this.descs = descs;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getFrequence() {
		return frequence;
	}
	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}
	public int getAllcount() {
		return allcount;
	}
	public void setAllcount(int allcount) {
		this.allcount = allcount;
	}
	public HashMap<String, String> getColor() {
		return color;
	}
	public void setColor(HashMap<String, String> color) {
		this.color = color;
	}
	public HashSet<String> getSize() {
		return size;
	}
	public void setSize(HashSet<String> size) {
		this.size = size;
	}
}
