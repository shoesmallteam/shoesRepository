package xyw.form;

import xyw.core.web.form.XywForm;

public class DeleteCartGoodForm extends XywForm{
	private String shoesdetailid;
	
	public void setShoesdetailid(String shoesdetailid) {
		this.shoesdetailid = shoesdetailid;
	}
	
	public String getShoesdetailid() {
		return shoesdetailid;
	}
	
	
	
	@Override
	public String toString() {
		return "DeleteCartGoodForm [shoesdetailid=" + shoesdetailid + "]";
	}

	@Override
	public boolean invalidate() {
		// TODO Auto-generated method stub
		return false;
	}

}
