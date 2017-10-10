package com.evan.lms.validate.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.evan.lms.validate.validator.RoleInfo;



@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {RoleInfo.class})
@Documented
public @interface RoleCheck {
	String message() default "值不符合规范";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}