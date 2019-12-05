package tan.form;

import xyw.core.web.form.XywForm;

public class UpdateAccountForm extends XywForm{
	private String account;
	private String isassistant;
	private String isvip;
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getIsassistant() {
		return isassistant;
	}

	public void setIsassistant(String isassistant) {
		this.isassistant = isassistant;
	}

	public String getIsvip() {
		return isvip;
	}

	public void setIsvip(String isvip) {
		this.isvip = isvip;
	}

	@Override
	public boolean invalidate() {
		return false;
	}

}