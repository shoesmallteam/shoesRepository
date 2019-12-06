package tan.dto;

import java.util.List;

import cn.shoesmall.pojo.Shoesdetail;
import tan.pojo.AddressDto;

public class ToConfirmDto {
	private List<Shoesdetail> list;
	private AddressDto address;
	private List<String> orderlist;
	private List<AddressDto> dtolist;
	
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
	public List<String> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List<String> orderlist) {
		this.orderlist = orderlist;
	}
	public List<AddressDto> getDtolist() {
		return dtolist;
	}
	public void setDtolist(List<AddressDto> dtolist) {
		this.dtolist = dtolist;
	}
	
}
