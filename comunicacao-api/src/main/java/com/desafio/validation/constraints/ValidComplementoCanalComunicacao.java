package com.desafio.validation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.desafio.validation.ComplementoCanalComunicacaoValidator;

@Documented
@Constraint(validatedBy = { ComplementoCanalComunicacaoValidator.class })
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidComplementoCanalComunicacao {

	String message() default "Complemento do canal da comunicação não informado (e-mail, telefone ou url)";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
