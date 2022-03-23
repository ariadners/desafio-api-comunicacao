package com.desafio.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.desafio.model.Comunicacao;
import com.desafio.model.enums.ECanalComunicacao;
import com.desafio.model.enums.EStatusEnvio;
import com.desafio.repository.ComunicacaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ComunicacaoControllerTest {

	// Instância do MockMVC
	@Autowired
	private MockMvc mockMvc;
	
	// Instância do ObjectMapper para trabalhar com JSON
	@Autowired
	private ObjectMapper objectMapper;

	// Instância do mock repository
	@MockBean
	private ComunicacaoRepository comunicacaoRepositoryMocked;

    // URLs base
    private final String urlPost = "/api/v1/comunicacoes/agendar";
    
	@Test
	void validarPostEnvioComSucesso() throws Exception {
		LocalDateTime dataHoraEnvio = LocalDateTime.now().plusDays(1);
		String destinatario = "Destinatário da Mensagem";
		String mensagem = "Testando se a API está funcionando corretamente!";
		ECanalComunicacao canal = ECanalComunicacao.EMAIL;
		String email = "email@email.com";
		String telefone = "";
		String urlPush = "";
		EStatusEnvio status = EStatusEnvio.AGENDADO;

		Comunicacao comunicacao = new Comunicacao(dataHoraEnvio, destinatario, mensagem, canal, email, telefone,
				urlPush, status);

		mockMvc.perform(post(urlPost)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(comunicacao)))
				.andExpect(status().isOk());
	}

	@Test
	void validarPostDestinatarioEmBranco() throws Exception {
		LocalDateTime dataHoraEnvio = LocalDateTime.now().plusDays(1);
		String destinatario = "";
		String mensagem = "Testando se a API está funcionando corretamente!";
		ECanalComunicacao canal = ECanalComunicacao.EMAIL;
		String email = "email@email.com";
		String telefone = "";
		String urlPush = "";
		EStatusEnvio status = EStatusEnvio.AGENDADO;

		Comunicacao comunicacao = new Comunicacao(dataHoraEnvio, destinatario, mensagem, canal, email, telefone,
				urlPush, status);

		mockMvc.perform(post(urlPost)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(comunicacao)))
				.andExpect(status().is4xxClientError());
	}

	@Test
	void validarPostMensagemEmBranco() throws Exception {
		LocalDateTime dataHoraEnvio = LocalDateTime.now().plusDays(1);
		String destinatario = "Destinatário da Mensagem";
		String mensagem = "";
		ECanalComunicacao canal = ECanalComunicacao.EMAIL;
		String email = "email@email.com";
		String telefone = "";
		String urlPush = "";
		EStatusEnvio status = EStatusEnvio.AGENDADO;

		Comunicacao comunicacao = new Comunicacao(dataHoraEnvio, destinatario, mensagem, canal, email, telefone,
				urlPush, status);

		mockMvc.perform(post(urlPost)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(comunicacao)))
				.andExpect(status().is4xxClientError());
	}

	@Test
	void validarPostCanalNaoInformado() throws Exception {
		LocalDateTime dataHoraEnvio = LocalDateTime.now().plusDays(1);
		String destinatario = "Destinatário da Mensagem";
		String mensagem = "Testando se a API está funcionando corretamente!";
		ECanalComunicacao canal = ECanalComunicacao.VALOR_INICIALIZACAO;
		String email = "email@email.com";
		String telefone = "";
		String urlPush = "";
		EStatusEnvio status = EStatusEnvio.AGENDADO;

		Comunicacao comunicacao = new Comunicacao(dataHoraEnvio, destinatario, mensagem, canal, email, telefone,
				urlPush, status);

		mockMvc.perform(post(urlPost)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(comunicacao)))
				.andExpect(status().is4xxClientError());
	}

	@Test
	void validarPostCanalEmailNaoInformado() throws Exception {
		LocalDateTime dataHoraEnvio = LocalDateTime.now().plusDays(1);
		String destinatario = "Destinatário da Mensagem";
		String mensagem = "Testando se a API está funcionando corretamente!";
		ECanalComunicacao canal = ECanalComunicacao.EMAIL;
		String email = "";
		String telefone = "";
		String urlPush = "";
		EStatusEnvio status = EStatusEnvio.AGENDADO;

		Comunicacao comunicacao = new Comunicacao(dataHoraEnvio, destinatario, mensagem, canal, email, telefone,
				urlPush, status);

		mockMvc.perform(post(urlPost)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(comunicacao)))
				.andExpect(status().is4xxClientError());
	}

	@Test
	void validarPostCanalSmsNaoInformado() throws Exception {
		LocalDateTime dataHoraEnvio = LocalDateTime.now().plusDays(1);
		String destinatario = "Destinatário da Mensagem";
		String mensagem = "Testando se a API está funcionando corretamente!";
		ECanalComunicacao canal = ECanalComunicacao.SMS;
		String email = "";
		String telefone = "";
		String urlPush = "";
		EStatusEnvio status = EStatusEnvio.AGENDADO;

		Comunicacao comunicacao = new Comunicacao(dataHoraEnvio, destinatario, mensagem, canal, email, telefone,
				urlPush, status);

		mockMvc.perform(post(urlPost)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(comunicacao)))
				.andExpect(status().is4xxClientError());
	}
	
	@Test
	void validarPostCanalWhatsNaoInformado() throws Exception {
		LocalDateTime dataHoraEnvio = LocalDateTime.now().plusDays(1);
		String destinatario = "Destinatário da Mensagem";
		String mensagem = "Testando se a API está funcionando corretamente!";
		ECanalComunicacao canal = ECanalComunicacao.WHATSAPP;
		String email = "";
		String telefone = "";
		String urlPush = "";
		EStatusEnvio status = EStatusEnvio.AGENDADO;

		Comunicacao comunicacao = new Comunicacao(dataHoraEnvio, destinatario, mensagem, canal, email, telefone,
				urlPush, status);

		mockMvc.perform(post(urlPost)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(comunicacao)))
				.andExpect(status().is4xxClientError());
	}

	@Test
	void validarPostCanalUrlPushNaoInformada() throws Exception {
		LocalDateTime dataHoraEnvio = LocalDateTime.now().plusDays(1);
		String destinatario = "Destinatário da Mensagem";
		String mensagem = "Testando se a API está funcionando corretamente!";
		ECanalComunicacao canal = ECanalComunicacao.PUSH;
		String email = "";
		String telefone = "";
		String urlPush = "";
		EStatusEnvio status = EStatusEnvio.AGENDADO;

		Comunicacao comunicacao = new Comunicacao(dataHoraEnvio, destinatario, mensagem, canal, email, telefone,
				urlPush, status);

		mockMvc.perform(post(urlPost)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(comunicacao)))
				.andExpect(status().is4xxClientError());
	}
	
	@Test
	void validarPostStatusNaoInformado() throws Exception {
		LocalDateTime dataHoraEnvio = LocalDateTime.now().plusDays(1);
		String destinatario = "Destinatário da Mensagem";
		String mensagem = "Testando se a API está funcionando corretamente!";
		ECanalComunicacao canal = ECanalComunicacao.EMAIL;
		String email = "email@email.com";
		String telefone = "";
		String urlPush = "";
		EStatusEnvio status = EStatusEnvio.VALOR_INICIALIZACAO;

		Comunicacao comunicacao = new Comunicacao(dataHoraEnvio, destinatario, mensagem, canal, email, telefone,
				urlPush, status);

		mockMvc.perform(post(urlPost)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(comunicacao)))
				.andExpect(status().is4xxClientError());
	}
}
