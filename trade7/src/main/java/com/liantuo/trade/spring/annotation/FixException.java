package com.liantuo.trade.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.aspectj.lang.annotation.AfterThrowing; 

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
//@AfterThrowing(value = "aspectjMethod()", throwing = "ex")
public @interface FixException {
	Class<?> value();
}
