package com.tutosoftware.productmarket.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tutosoftware.productmarket.entity.Usuario;



public class UsuarioValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Usuario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombreUsuario",
				"field.nombreUsuario.required","El nombre del administrador es requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"usuario",
				"field.usuario.required","El usuario es requerido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password",
				"field.password.required","El password es requerido");

	}

}
