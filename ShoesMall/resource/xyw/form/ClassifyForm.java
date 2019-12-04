package xyw.form;

import java.io.Serializable;

import xyw.core.web.form.XywForm;
/**
 * 用户查询商品分类form参数列表
 * @author xyw
 *
 */
public class ClassifyForm extends XywForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 713742402630630741L;
	
	private String orderByPriceUp;
	
	private String orderByPriceDown;
	
	private String color;
	
	private String size;
	
	private String number;
	
	private String typename;
	
	private String price;
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getPrice() {
		return price;
	}
	

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@Override
	public String toString() {
		return "ClassifyForm [size=" + size + ", number=" + number + ", typename=" + typename + "]";
	}

	@Override
	public boolean invalidate() {
		// TODO Auto-generated method stub
		return false;
	}

}
