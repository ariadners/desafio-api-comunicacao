package com.desafio.model.enums;

public enum EStatusEnvio {

	VALOR_INICIALIZACAO(0), //
	AGENDADO(1), //
	ENVIADO(2), //
	CANCELADO(3);

	private final int statusEnvio;

	EStatusEnvio(int status) {
		statusEnvio = status;
	}

	public int getValue() {
		return statusEnvio;
	}
}
