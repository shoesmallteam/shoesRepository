package fyq.form;

import xyw.core.web.form.XywForm;

public class DeleteAddressForm extends XywForm{
    private String addressid;
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	@Override
	public boolean invalidate() {
		// TODO Auto-generated method stub
		return this.addressid != null;
	}
	
}
