package tan.form;

import xyw.core.web.form.XywForm;

public class UpdateAccountForm extends XywForm{
	private String accountid;
	private int isassistant;
	
	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public int getIsassistant() {
		return isassistant;
	}

	public void setIsassistant(int isassistant) {
		this.isassistant = isassistant;
	}

	@Override
	public boolean invalidate() {
		return false;
	}

}
