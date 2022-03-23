package com.desafio.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.desafio.model.enums.ECanalComunicacao;
import com.desafio.model.enums.EStatusEnvio;
import com.desafio.validation.constraints.ValidCanalComunicacao;
import com.desafio.validation.constraints.ValidComplementoCanalComunicacao;
import com.desafio.validation.constraints.ValidStatusComunicacao;

@ValidComplementoCanalComunicacao
@Entity
@Table(name = "comunicacao")
public class Comunicacao {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id; // Cada comunicação terá um id unico gerado automaticamente ao ser incluído

	@DateTimeFormat
	@FutureOrPresent
	@Column(name = "data_hora_envio", nullable = false)
	private LocalDateTime dataHoraEnvio; // Data e horário em que a comunicação deverá ser realizada

	@NotBlank(message = "Campo destinatário não informado")
	@Column(name = "destinatario", nullable = false)
	private String destinatario; // Descrição do destinatário da mensagem

	@NotBlank(message = "Campo mensagem não informado")
	@Column(name = "mensagem", nullable = false)
	private String mensagem; // Mensagem que será repassada ao(s) destinatário(s)

	@ValidCanalComunicacao
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "canal", nullable = false)
	private ECanalComunicacao canal; // Canal em que a comunicação será realizada, ex. e-mail, whatsapp, push

	@Email(message = "Email inválido")
	@Column(name = "email", nullable = true)
	private String email; // Informar o endereço de email quando o canal da comunicação for email

	@NumberFormat
	@Column(name = "telefone", nullable = true)
	private String telefone; // Informar o número de telefone quando o canal da comunicação for whatsapp ou sms

	@URL(message = "URL inválida")
	@Column(name = "url_push", nullable = true)
	private String urlPush; // Informar a URL para realizar o push da mensagem quando o canal da comunicação for push

	@ValidStatusComunicacao
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status", nullable = false)
	private EStatusEnvio status; // Status em que se encontra a comunicação: ex. enviada, cancelada

	public Comunicacao() {
		super();
	}

	public Comunicacao(@FutureOrPresent LocalDateTime dataHoraEnvio,
			@NotBlank(message = "Campo destinatário não informado") String destinatario,
			@NotBlank(message = "Campo mensagem não informado") String mensagem, ECanalComunicacao canal,
			@Email(message = "Email inválido") String email, String telefone,
			@URL(message = "URL inválida") String urlPush, EStatusEnvio status) {
		super();
		this.dataHoraEnvio = dataHoraEnvio;
		this.destinatario = destinatario;
		this.mensagem = mensagem;
		this.canal = canal;
		this.email = email;
		this.telefone = telefone;
		this.urlPush = urlPush;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDataHoraEnvio() {
		return dataHoraEnvio;
	}

	public void setDataHoraEnvio(LocalDateTime dataHoraEnvio) {
		this.dataHoraEnvio = dataHoraEnvio;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public ECanalComunicacao getCanal() {
		return canal;
	}

	public void setCanal(ECanalComunicacao canal) {
		this.canal = canal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUrlPush() {
		return urlPush;
	}

	public void setUrlPush(String urlPush) {
		this.urlPush = urlPush;
	}

	public EStatusEnvio getStatus() {
		return status;
	}

	public void setStatus(EStatusEnvio status) {
		this.status = status;
	}
}
