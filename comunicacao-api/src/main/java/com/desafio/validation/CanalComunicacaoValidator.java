package com.desafio.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.desafio.model.enums.ECanalComunicacao;
import com.desafio.validation.constraints.ValidCanalComunicacao;

public class CanalComunicacaoValidator implements ConstraintValidator<ValidCanalComunicacao, ECanalComunicacao> {

	@Override
	public void initialize(ValidCanalComunicacao constraintAnnotation) {
	}

	@Override
	public boolean isValid(ECanalComunicacao canal, ConstraintValidatorContext context) {
		if (canal == null) {
			return false;
		}

		if (canal.equals(ECanalComunicacao.VALOR_INICIALIZACAO)) {
			return false;
		}

		return true;
	}
}
