package xyw.dto;

import java.io.Serializable;

public class GoodsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1373723908087106095L;
	
	private String shoesdetailid;
	private String amount;
	
	public String getShoesdetailid() {
		return shoesdetailid;
	}
	public void setShoesdetailid(String shoesdetailid) {
		this.shoesdetailid = shoesdetailid;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "GoodsDto [shoesdetailid=" + shoesdetailid + ", amount=" + amount + "]";
	}

}
