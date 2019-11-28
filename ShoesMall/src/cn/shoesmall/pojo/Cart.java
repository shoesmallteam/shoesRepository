package cn.shoesmall.pojo;

public class Cart {
	private String cartid;
	private String goods;
	private String accountid;
	
	
	public String getCartid() {
		return cartid;
	}


	public void setCartid(String cartid) {
		this.cartid = cartid;
	}


	public String getGoods() {
		return goods;
	}


	public void setGoods(String goods) {
		this.goods = goods;
	}


	public String getAccountid() {
		return accountid;
	}


	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}


	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", shoedetailsid=" + goods + ", accountid=" + accountid + "]";
	}
}
