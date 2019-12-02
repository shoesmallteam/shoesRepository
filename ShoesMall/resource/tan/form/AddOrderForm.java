package tan.form;

import xyw.core.web.form.XywForm;

public class AddOrderForm extends XywForm{
	private String order;
	
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public boolean invalidate() {
		return false;
	}

}
