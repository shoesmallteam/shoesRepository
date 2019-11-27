package xyw.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyw.core.web.action.XywAction;
import xyw.core.web.form.XywForm;
import xyw.form.ClassifyForm;

/**
 * 分类处理
 * @author xyw
 *
 */
public class ClassifyAction extends XywAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, XywForm arg2)
			throws ServletException, IOException {
		
		
		ClassifyForm form = (ClassifyForm)arg2;
		
		
		
		String typename = form.getTypename();
		
		System.out.println(typename);
		
		return null;
	}

}
