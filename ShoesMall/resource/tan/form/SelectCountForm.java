package tan.form;

import xyw.core.web.form.XywForm;

public class SelectCountForm extends XywForm{
	private String shoes;
	
	public String getShoes() {
		return shoes;
	}

	public void setShoes(String shoes) {
		this.shoes = shoes;
	}

	@Override
	public boolean invalidate() {
		// TODO Auto-generated method stub
		return false;
	}

}
