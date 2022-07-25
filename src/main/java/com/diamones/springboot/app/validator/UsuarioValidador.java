package com.diamones.springboot.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.diamones.springboot.app.models.domain.Usuario;

@Component
public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Usuario usuario = (Usuario) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "NotEmpty.usuario.apellido");

		if (!usuario.getUsername().matches("[a-zA-Z]{9}")){
			errors.rejectValue("username", "Pattern.usuario.username");
		}
	}

}
