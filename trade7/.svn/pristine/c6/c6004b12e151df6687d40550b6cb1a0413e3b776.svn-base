package com.liantuo.deposit.advanceaccount.web.util;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CannotEmptyStringValidator.class) //具体的实现  
@Target( { java.lang.annotation.ElementType.METHOD,java.lang.annotation.ElementType.FIELD })  
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)   
public @interface CannotEmptyString {  
    String message() default "formatter error";
    String regexp();
    //下面这两个属性必须添加  
    Class<?>[] groups() default {};  
    Class<? extends Payload>[] payload() default {};  
      
}  