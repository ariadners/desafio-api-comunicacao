package com.desafio.model.enums;

public enum ECanalComunicacao {

	VALOR_INICIALIZACAO(0), //
	EMAIL(1), //
	SMS(2), //
	PUSH(3), //
	WHATSAPP(4);

	private final int canalComunicacao;

	ECanalComunicacao(int canal) {
		canalComunicacao = canal;
	}

	public int getValue() {
		return canalComunicacao;
	}
}
