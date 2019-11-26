package zwc.pojo;

import java.io.Serializable;

public class Cart  implements Serializable{
	private String cartid;
	private String shoedetailsid;
	private String accountid;
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public String getShoedetailsid() {
		return shoedetailsid;
	}
	public void setShoedetailsid(String shoedetailsid) {
		this.shoedetailsid = shoedetailsid;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", shoedetailsid=" + shoedetailsid + ", accountid=" + accountid + "]";
	}
	
	
}
