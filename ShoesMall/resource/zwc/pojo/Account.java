package zwc.pojo;

import java.io.Serializable;

public class Account implements Serializable{
	private String accountid;
	private String account;
	private String password;
	private String tel;
	private String email;
	private int isassistant;
	private int isvip;
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsassistant() {
		return isassistant;
	}
	public void setIsassistant(int isassistant) {
		this.isassistant = isassistant;
	}
	public int getIsvip() {
		return isvip;
	}
	public void setIsvip(int isvip) {
		this.isvip = isvip;
	}
	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", account=" + account + ", password=" + password + ", tel=" + tel
				+ ", email=" + email + ", isassistant=" + isassistant + ", isvip=" + isvip + "]";
	}
	
}
