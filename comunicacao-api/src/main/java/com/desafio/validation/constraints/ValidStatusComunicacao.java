package com.desafio.validation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.desafio.validation.StatusComunicacaoValidator;

@Documented
@Constraint(validatedBy = { StatusComunicacaoValidator.class })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStatusComunicacao {

	String message() default "Status comunicação inválido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
