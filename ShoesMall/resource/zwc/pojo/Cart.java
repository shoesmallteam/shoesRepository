package zwc.pojo;

import java.io.Serializable;

public class Cart  implements Serializable{
	private String cartid;
	private String goods;
	private String accountid;
	public String getCartid() {
		return cartid;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", goods=" + goods + ", accountid=" + accountid + "]";
	}
	
	
}
