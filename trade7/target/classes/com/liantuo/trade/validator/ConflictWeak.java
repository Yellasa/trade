package com.liantuo.trade.validator;

import com.liantuo.trade.validator.date.DateTime;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@ReportAsSingleViolation
@NotNull
public @interface ConflictWeak {
    Class<?>[] groups() default {};
    
    /**
	 * 
	 * @Description: 被注解的字段，通过反射获取值之后，与exclusion_prop_value进行正则匹配，匹配通过，
	 *              则通过配置exclusion_prop_name的获取关联的字段，依次获取被关联字段的值，如果都无值或有2 个及以上字段有值的，则返回 exclusionMessage 配置的错误信息。
	 *              
	 */
    String exclusion_prop_value() default ""; //正则
    //互斥字段
    String exclusion_prop_name() default "";
    //带前提条件的互斥字段
    String mutual_exclusion_prop_name() default "";
    String message() default "";
    
    
    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        DateTime[] value();
    }
}