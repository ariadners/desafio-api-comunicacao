package com.desafio.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.desafio.model.enums.EStatusEnvio;
import com.desafio.validation.constraints.ValidStatusComunicacao;

public class StatusComunicacaoValidator implements ConstraintValidator<ValidStatusComunicacao, EStatusEnvio> {

	@Override
	public void initialize(ValidStatusComunicacao constraintAnnotation) {
	}

	@Override
	public boolean isValid(EStatusEnvio status, ConstraintValidatorContext context) {
		if (status == null) {
			return false;
		}

		if (status.equals(EStatusEnvio.VALOR_INICIALIZACAO)) {
			return false;
		}

		return true;
	}
}
