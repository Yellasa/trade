package com.liantuo.deposit.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Architecture {
	String value() default "";

	/**
	 * 系统
	 * @return
	 */
	String gateway() default "3.0";

	/**
	 * 体系
	 * @return
	 */
	String version() default "3.0";

	/**
	 * 系统
	 * @return
	 */
	String system() default "";

	/**
	 * 产品版本
	 * 0:created 1~n:modified
	 * @return
	 */
	String[] product_version() default "";
}
