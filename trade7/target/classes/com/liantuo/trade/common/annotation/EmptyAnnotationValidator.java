package com.liantuo.trade.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmptyAnnotationValidator implements ConstraintValidator<EmptyAnnotation, String> {

	private boolean isAllowBlank;
	
	@Override
	public void initialize(EmptyAnnotation constraintAnnotation) {
		this.isAllowBlank = constraintAnnotation.isAllowBlank();
	}

	/**
	 * 验证逻辑：
	 * value为null、为""都返回true，为" "返回false，其他情况返回true
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(!isAllowBlank){
			if(null==value||"".equals(value)){
				return true;
			}else if(" ".equals(value)){
				return false;
			}
		}//else{} 对于允许为空的逻辑 暂不处理
		return true;
	}

}
