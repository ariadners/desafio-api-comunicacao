package com.desafio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.exception.ResourceNotFoundException;
import com.desafio.model.Comunicacao;
import com.desafio.model.enums.EStatusEnvio;
import com.desafio.repository.ComunicacaoRepository;

@RestController
@RequestMapping("/api/v1/comunicacoes")
public class ComunicacaoController {

	@Autowired
	private ComunicacaoRepository comunicacaoRepository;
	
	// 1. Agendamento de envio de comunicação
	@PostMapping("/agendar")
	public Comunicacao agendarEnvio(@RequestBody @Valid Comunicacao comunicacao) {
		return this.comunicacaoRepository.save(comunicacao);
	}

	// 2.1 Consulta do envio da comunicação (todos)
	@GetMapping("/consultar/todos")
	public List<Comunicacao> consultarEnvios() {
		return this.comunicacaoRepository.findAll();
	}

	// 2.2 Consulta do envio da comunicação (por id)
	@GetMapping("/consultar/{id}")
	public ResponseEntity<Comunicacao> consultarEnvioPorId(@PathVariable(value = "id") Long comunicacaoId) throws ResourceNotFoundException {
		Comunicacao comunicacao = comunicacaoRepository.findById(comunicacaoId).orElseThrow(() -> new ResourceNotFoundException("Não encontrada a comunicação com o Id: " + comunicacaoId));
		return ResponseEntity.ok().body(comunicacao);
	}

	// 3. Cancelamento do envio da comunicação
	@PutMapping("/cancelar/{id}")
	public String cancelarEnvio(@PathVariable(value = "id") Long comunicacaoId) throws ResourceNotFoundException {
		Comunicacao comunicacao = comunicacaoRepository.findById(comunicacaoId).orElseThrow(() -> new ResourceNotFoundException("Não encontrada a comunicação com o Id: " + comunicacaoId));
		comunicacao.setStatus(EStatusEnvio.CANCELADO);
		this.comunicacaoRepository.save(comunicacao);
		return ("Comunicação cancelada para o Id: " + comunicacaoId);
	}
}
