package com.liantuo.deposit.advanceaccount.web.util;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CannotEmptyStringValidator implements ConstraintValidator<CannotEmptyString, String> {  
    String regex;
    @Override  
    public void initialize(CannotEmptyString arg0) {  
    	regex=arg0.regexp();
    }  
    @Override  
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {  
    	if(str==null){
    		return true;
    	}
    	if(str.equals("")){
    		return true;
    	}else{
    		return str.matches(regex);
    	} 
    }  

}  