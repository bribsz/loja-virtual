package com.dev.backend.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.dto.PessoaClienteRequestDTO;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;

@Service
public class PessoaClienteService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PermissaoPessoaService permissaoPessoaService;
	
	@Autowired
	private EmailService emailService;
	
	public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
		Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
		pessoa.setDataCriacao(new Date());
		Pessoa pessoaNova = pessoaRepository.saveAndFlush(pessoa);
		permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNova);
		//emailService.enviarEmailTexto(pessoaNova.getEmail(), "Cadastro na Loja xxx", "O registro foi com suscesso");
		Map<String, Object> proprMap = new HashMap<>();
		proprMap.put("nome", pessoaNova.getNome());
		proprMap.put("mensagem", "O registro foi com suscesso");
		emailService.enviarEmailTemplate(pessoaNova.getEmail(), "Cadastro na Loja x", proprMap);
		return pessoaNova;
	}
	
}
