package com.liantuo.trade.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {EmptyAnnotationValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmptyAnnotation {

//	String message() default "{constraint.default.words.message}";
	String message();

	Class<?>[] groups() default {};

	boolean isAllowBlank() default false;
	
	Class<? extends Payload>[] payload() default {};
	
//	String filed() default "";
}
