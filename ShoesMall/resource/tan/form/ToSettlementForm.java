package tan.form;

import xyw.core.web.form.XywForm;

public class ToSettlementForm extends XywForm{
	private String shoesdetailid;
	private String count;
	
	public String getShoesdetailid() {
		return shoesdetailid;
	}

	public void setShoesdetailid(String shoesdetailid) {
		this.shoesdetailid = shoesdetailid;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public boolean invalidate() {
		if (this.count == null) {
			this.count = "1";
			return true;
		}
		return false;
	}
	
}
