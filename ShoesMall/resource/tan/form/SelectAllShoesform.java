package tan.form;

import xyw.core.web.form.XywForm;

public class SelectAllShoesform extends XywForm{
	private String pagesize;
	
	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	@Override
	public boolean invalidate() {
		return false;
	}

}
