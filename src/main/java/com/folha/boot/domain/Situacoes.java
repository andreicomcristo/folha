package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "situacoes")
public class Situacoes extends AbstractEntity<Long> {

	@Column(name="descricao_situacao")
	private String descricaoSituacao;

	@Column(name="nome_situacao")
	private String nomeSituacao;

	//bi-directional many-to-one association to HistFuncionariosSituacoe
	@OneToMany(mappedBy="situacoe")
	private List<HistFuncionariosSituacoes> histFuncionariosSituacoes;

	//bi-directional many-to-one association to PessoaFuncionario
	@OneToMany(mappedBy="situacoe")
	private List<PessoaFuncionarios> pessoaFuncionarios;

	public Situacoes() {
	}

	public String getDescricaoSituacao() {
		return this.descricaoSituacao;
	}

	public void setDescricaoSituacao(String descricaoSituacao) {
		this.descricaoSituacao = descricaoSituacao;
	}

	public String getNomeSituacao() {
		return this.nomeSituacao;
	}

	public void setNomeSituacao(String nomeSituacao) {
		this.nomeSituacao = nomeSituacao;
	}

	public List<HistFuncionariosSituacoes> getHistFuncionariosSituacoes() {
		return this.histFuncionariosSituacoes;
	}

	public void setHistFuncionariosSituacoes(List<HistFuncionariosSituacoes> histFuncionariosSituacoes) {
		this.histFuncionariosSituacoes = histFuncionariosSituacoes;
	}

	public HistFuncionariosSituacoes addHistFuncionariosSituacoe(HistFuncionariosSituacoes histFuncionariosSituacoe) {
		getHistFuncionariosSituacoes().add(histFuncionariosSituacoe);
		histFuncionariosSituacoe.setSituacoe(this);

		return histFuncionariosSituacoe;
	}

	public HistFuncionariosSituacoes removeHistFuncionariosSituacoe(HistFuncionariosSituacoes histFuncionariosSituacoe) {
		getHistFuncionariosSituacoes().remove(histFuncionariosSituacoe);
		histFuncionariosSituacoe.setSituacoe(null);

		return histFuncionariosSituacoe;
	}

	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return this.pessoaFuncionarios;
	}

	public void setPessoaFuncionarios(List<PessoaFuncionarios> pessoaFuncionarios) {
		this.pessoaFuncionarios = pessoaFuncionarios;
	}

	public PessoaFuncionarios addPessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().add(pessoaFuncionario);
		pessoaFuncionario.setSituacoe(this);

		return pessoaFuncionario;
	}

	public PessoaFuncionarios removePessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().remove(pessoaFuncionario);
		pessoaFuncionario.setSituacoe(null);

		return pessoaFuncionario;
	}


}
