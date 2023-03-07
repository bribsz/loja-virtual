package com.dev.backend.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String cpf;
	private String email;
	private String codigoRecuperacaoSenha;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEnvioCodigo;
	private String senha;
	private String endereco;
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "idCidade")
	private Cidade cidade;
	
	@OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@Setter(value = AccessLevel.NONE)
	private List<PermissaoPessoa> permissaoPessoas;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;
	
	public void setPermissaoPessoas(List<PermissaoPessoa> pp) {
		for(PermissaoPessoa p:pp) {
			p.setPessoa(this);
		}
		this.permissaoPessoas = pp;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getCodigoRecuperacaoSenha() {
		return codigoRecuperacaoSenha;
	}
	public void setCodigoRecuperacaoSenha(String codigoRecuperacaoSenha) {
		this.codigoRecuperacaoSenha = codigoRecuperacaoSenha;
	}
	public Date getDataEnvioCodigo() {
		return dataEnvioCodigo;
	}
	public void setDataEnvioCodigo(Date dataEnvioCodigo) {
		this.dataEnvioCodigo = dataEnvioCodigo;
	}
	public List<PermissaoPessoa> getPermissaoPessoas() {
		return permissaoPessoas;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
