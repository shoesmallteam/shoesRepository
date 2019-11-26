package xyw.form;

import xyw.core.web.form.XywForm;

/**
 *   用户访问购物车传过来的form
 * @author xyw
 *
 */


public class CartForm extends XywForm{

	/**
	 *用户id 
	 */
	private String accountid;
	
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	
	public String getAccountid() {
		return accountid;
	} 
	
	@Override
	public boolean invalidate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "CartForm [cartid=" + accountid + "]";
	}
	
	
}
