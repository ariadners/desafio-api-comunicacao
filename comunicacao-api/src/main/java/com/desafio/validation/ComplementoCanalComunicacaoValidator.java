package com.desafio.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.desafio.model.Comunicacao;
import com.desafio.model.enums.ECanalComunicacao;
import com.desafio.validation.constraints.ValidComplementoCanalComunicacao;

public class ComplementoCanalComunicacaoValidator implements ConstraintValidator<ValidComplementoCanalComunicacao, Comunicacao> {

	@Override
	public void initialize(ValidComplementoCanalComunicacao constraintAnnotation) {
	}

	@Override
	public boolean isValid(Comunicacao comunicacao, ConstraintValidatorContext context) {
		if (comunicacao == null) {
			return false;
		}

		if (comunicacao.getCanal().equals(ECanalComunicacao.EMAIL)) {
			if (comunicacao.getEmail() == null || comunicacao.getEmail().isEmpty()) {
				return false;
			}
		} else if (comunicacao.getCanal().equals(ECanalComunicacao.SMS)
				|| comunicacao.getCanal().equals(ECanalComunicacao.WHATSAPP)) {
			if (comunicacao.getTelefone() == null || comunicacao.getTelefone().isEmpty()) {
				return false;
			}
		} else if (comunicacao.getCanal().equals(ECanalComunicacao.PUSH)) {
			if (comunicacao.getUrlPush() == null || comunicacao.getUrlPush().isEmpty()) {
				return false;
			}
		}

		return true;
	}
}
