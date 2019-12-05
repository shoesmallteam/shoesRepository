package tan.form;

import xyw.core.web.form.XywForm;

public class SelectAccountForm extends XywForm{
	private String pagesize;
	
	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	@Override
	public boolean invalidate() {
		if (this.pagesize == null) {
			this.pagesize = "1";
		}
		return false;
	}

}
