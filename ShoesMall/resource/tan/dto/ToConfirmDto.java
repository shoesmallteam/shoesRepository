package tan.dto;

import cn.shoesmall.pojo.Shoesdetail;
import tan.pojo.AddressDto;

public class ToConfirmDto {
	private Shoesdetail detail;
	private AddressDto address;
	public Shoesdetail getDetail() {
		return detail;
	}
	public void setDetail(Shoesdetail detail) {
		this.detail = detail;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	
}
