package tan.dto;

import java.util.List;

import cn.shoesmall.pojo.Shoesdetail;
import tan.pojo.AddressDto;

public class ToConfirmDto {
	private List<Shoesdetail> list;
	private AddressDto address;
	
	public List<Shoesdetail> getList() {
		return list;
	}
	public void setList(List<Shoesdetail> list) {
		this.list = list;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	
}
