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
	
	/**
	 * 分类名
	 */
	
	private String typename;
	
	public String getTypename() {
		return typename;
	}
	
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	

	@Override
	public boolean invalidate() {
		// TODO Auto-generated method stub
		return false;
	}

}
