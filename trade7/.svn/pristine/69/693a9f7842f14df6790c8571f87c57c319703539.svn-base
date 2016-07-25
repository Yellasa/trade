package com.liantuo.trade.common.annotation;

import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TradePatternVakudator implements ConstraintValidator<TradePattern, CharSequence>{

	private java.util.regex.Pattern pattern;

	
	@Override
	public void initialize(TradePattern parameters) {
//		TradePattern.Flag[] flags = parameters.flags();
		int intFlag = 0;
//		for ( TradePattern.Flag flag : flags ) {
//			intFlag = intFlag | flag.getValue();
//		}

		try {
			pattern = java.util.regex.Pattern.compile( parameters.regexp(), intFlag );
		}
		catch ( PatternSyntaxException e ) {
			 e.printStackTrace();
		}
	}

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		if ( value == null||"".equals(value) ) {
			return true;
		}
		Matcher m = pattern.matcher( value );
		return m.matches();
	}

}
