package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "estados_civis")
public class EstadosCivis extends AbstractEntity<Long> {

	@Column(name="descricao_estado_civil")
	private String descricaoEstadoCivil;

	@Column(name="nome_estado_civil")
	private String nomeEstadoCivil;

	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="estadosCivi")
	private List<Pessoa> pessoas;

	public EstadosCivis() {
	}

	public String getDescricaoEstadoCivil() {
		return this.descricaoEstadoCivil;
	}

	public void setDescricaoEstadoCivil(String descricaoEstadoCivil) {
		this.descricaoEstadoCivil = descricaoEstadoCivil;
	}

	public String getNomeEstadoCivil() {
		return this.nomeEstadoCivil;
	}

	public void setNomeEstadoCivil(String nomeEstadoCivil) {
		this.nomeEstadoCivil = nomeEstadoCivil;
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa addPessoa(Pessoa pessoa) {
		getPessoas().add(pessoa);
		pessoa.setEstadosCivi(this);

		return pessoa;
	}

	public Pessoa removePessoa(Pessoa pessoa) {
		getPessoas().remove(pessoa);
		pessoa.setEstadosCivi(null);

		return pessoa;
	}
	
}
