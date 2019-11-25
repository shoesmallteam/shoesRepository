package cn.shoesmall.pojo;

public class User {
	private String userid;
	private String nikename;
	private String address;
	private String cartid;
	private String accountid;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNikename() {
		return nikename;
	}
	public void setNikename(String nikename) {
		this.nikename = nikename;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCartid() {
		return cartid;
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
		return "User [userid=" + userid + ", nikename=" + nikename + ", address=" + address + ", cartid=" + cartid
				+ ", accountid=" + accountid + "]";
	}
	
	
}
