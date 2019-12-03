package tan.form;

import xyw.core.web.form.XywForm;

public class ConfirmForm extends XywForm{
	private String items;
	
	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	@Override
	public boolean invalidate() {
		return false;
	}
	
}
