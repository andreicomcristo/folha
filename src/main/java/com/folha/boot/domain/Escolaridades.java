package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "escolaridades")
public class Escolaridades extends AbstractEntity<Long> {
	
	@Column(name="descricao_escolaridade")
	private String descricaoEscolaridade;

	@Column(name="nome_escolaridade")
	private String nomeEscolaridade;

	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="escolaridade")
	private List<Pessoa> pessoas;

	public Escolaridades() {
	}

	public String getDescricaoEscolaridade() {
		return this.descricaoEscolaridade;
	}

	public void setDescricaoEscolaridade(String descricaoEscolaridade) {
		this.descricaoEscolaridade = descricaoEscolaridade;
	}

	public String getNomeEscolaridade() {
		return this.nomeEscolaridade;
	}

	public void setNomeEscolaridade(String nomeEscolaridade) {
		this.nomeEscolaridade = nomeEscolaridade;
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa addPessoa(Pessoa pessoa) {
		getPessoas().add(pessoa);
		pessoa.setEscolaridade(this);

		return pessoa;
	}

	public Pessoa removePessoa(Pessoa pessoa) {
		getPessoas().remove(pessoa);
		pessoa.setEscolaridade(null);

		return pessoa;
	}

}
