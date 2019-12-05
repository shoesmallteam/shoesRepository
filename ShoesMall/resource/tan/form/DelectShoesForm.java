package tan.form;

import xyw.core.web.form.XywForm;

public class DelectShoesForm extends XywForm{
	private String shoesid;
	
	public String getShoesid() {
		return shoesid;
	}

	public void setShoesid(String shoesid) {
		this.shoesid = shoesid;
	}

	@Override
	public boolean invalidate() {
		return false;
	}

}
