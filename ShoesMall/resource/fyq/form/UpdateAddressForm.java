package fyq.form;

import xyw.core.web.form.XywForm;

public class UpdateAddressForm extends XywForm{
	private String addressid;
	private String name;
	private String tel;
	private String province;
	private String city;
	private String area;
	private String detail;
	
	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}
	
	
	public String getAddressid() {
		return addressid;
	}


	public void setAddressid(String addressid) {
		this.addressid = addressid;
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


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	@Override
	public boolean invalidate() {
		// TODO Auto-generated method stub
		return this.addressid!=null;
	}

}
