package tan.form;

import xyw.core.web.form.XywForm;

public class ProductForm extends XywForm{
	private String color;
	
	private String shoesid;
	
	public String getShoesid() {
		return shoesid;
	}

	public void setShoesid(String shoesid) {
		this.shoesid = shoesid;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	@Override
	public boolean invalidate() {
		// TODO Auto-generated method stub
		return false;
	}

}
