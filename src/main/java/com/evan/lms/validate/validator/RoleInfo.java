package com.evan.lms.validate.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

import com.evan.lms.entity.Role;
import com.evan.lms.validate.annotation.RoleCheck;

public class RoleInfo implements ConstraintValidator<RoleCheck,Role> {

	@Override
	public void initialize(RoleCheck constraintAnnotation) {
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean isValid(Role role, ConstraintValidatorContext constraintValidatorContext) {
		if(StringUtils.isBlank(role.getName())){
			constraintValidatorContext.disableDefaultConstraintViolation();
			constraintValidatorContext.buildConstraintViolationWithTemplate("角色名称不能为空").addNode("RoleName")
					.addConstraintViolation();
			return false;
		}
		System.out.println( "----------"+role.getName().length() );
		if(role.getName().length() < 6 ){
			constraintValidatorContext.disableDefaultConstraintViolation();
			constraintValidatorContext.buildConstraintViolationWithTemplate("名称长度为6-20").addNode("RoleName")
			.addConstraintViolation();
			return false;
		}
		return true;
	}
	

}
