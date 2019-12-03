package tan.form;

import xyw.core.web.form.XywForm;

public class AddOrderForm extends XywForm{
	private String order;
	private String count;
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public boolean invalidate() {
		return false;
	}

}
