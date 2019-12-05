package fyq.form;

import cn.shoesmall.util.PrimaryKeyGeneric;
import xyw.core.web.form.XywForm;

public class InsertAddressForm extends XywForm{

	private String name;
	private String tel;
	private String provinces;
	private String city;
	private String area;
	private String detail;
	private String userid;
	private String addressid;
	
	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getAddressid() {
		return PrimaryKeyGeneric.getPrimaryKey();
	}



	public void setAddressid() {
		this.addressid = PrimaryKeyGeneric.getPrimaryKey();
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getProvinces() {
		return provinces;
	}



	public void setProvinces(String provinces) {
		this.provinces = provinces;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}



	public String getDetail() {
		return detail;
	}



	public void setDetail(String detail) {
		this.detail = detail;
	}



	public String getUid() {
		return userid;
	}



	public void setUid(String userid) {
		this.userid = userid;
	}



	@Override
	public boolean invalidate() {
		
		return this.userid != null;
	}



	@Override
	public String toString() {
		return "InsertAddressForm [name=" + name + ", tel=" + tel + ", provinces=" + provinces + ", city=" + city
				+ ", area=" + area + ", detail=" + detail + ", userid=" + userid + "]";
	}
	
	

}
