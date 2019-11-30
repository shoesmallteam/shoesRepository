package zwc.pojo;

import java.io.Serializable;
import java.util.Arrays;

public class Account implements Serializable{
	private String accountid;
	private String account;
	private String password;
	private String tel;
	private String email;
	private int isassistant;
	private int isvip;
	private String photo;
	private String ssname;
	private String sssex;
	private String ssbirthday;
	private String ssidnumber;
	private String realname ;
	
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSsname() {
		return ssname;
	}
	public void setSsname(String ssname) {
		this.ssname = ssname;
	}
	public String getSssex() {
		return sssex;
	}
	public void setSssex(String sssex) {
		this.sssex = sssex;
	}
	public String getSsbirthday() {
		return ssbirthday;
	}
	public void setSsbirthday(String ssbirthday) {
		this.ssbirthday = ssbirthday;
	}
	public String getSsidnumber() {
		return ssidnumber;
	}
	public void setSsidnumber(String ssidnumber) {
		this.ssidnumber = ssidnumber;
	}
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
				+ ", email=" + email + ", isassistant=" + isassistant + ", isvip=" + isvip + ", photo=" + photo
				+ ", ssname=" + ssname + ", sssex=" + sssex + ", ssbirthday=" + ssbirthday + ", ssidnumber="
				+ ssidnumber + ", realname=" + realname + "]";
	}
	
	
	
	
}
