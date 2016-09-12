package com.platform.mvc.dept;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.platform.mvc.base.BaseValidator;

public class DepartmentValidator extends BaseValidator {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(DepartmentValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/dept/save")){
			
		} else if (actionKey.equals("/dept/update")){
			
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Department.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/dept/save")){
			
		} else if (actionKey.equals("/dept/update")){
			
		}
	}
}
