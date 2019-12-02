package xyw.form;

import xyw.core.web.form.XywForm;
/**
 * 添加购物车所需参数表
 * @author xyw
 *
 */
public class AddToCartForm extends XywForm{

	@Override
	public boolean invalidate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	//商品详情id
	private String shoesdetailid;
	//数量
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
		return "AddToCartForm [shoesdetailid=" + shoesdetailid + ", amount=" + amount + "]";
	}
	
}
