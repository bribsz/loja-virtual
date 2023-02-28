package com.dev.backend.dto;

import org.springframework.beans.BeanUtils;

import com.dev.backend.entity.Cidade;
import com.dev.backend.entity.Pessoa;

public class PessoaClienteRequestDTO {
	
	private String nome;
	private String cpf;
	private String email;
	private String endereco;
	private String cep;
	private Cidade cidade;
	
	public Pessoa converter(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
		Pessoa pessoa = new Pessoa();
		BeanUtils.copyProperties(pessoaClienteRequestDTO, pessoa);
		return pessoa;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	

}
