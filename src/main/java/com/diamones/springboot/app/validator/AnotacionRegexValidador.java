package com.diamones.springboot.app.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AnotacionRegexValidador implements ConstraintValidator<AnotacionRegex, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.matches("[0-9]{2}[.][a-zA-Z]{5}"))
			
			return true;
		
		return false;
	}

}
