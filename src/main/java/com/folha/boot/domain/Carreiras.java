package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "carreiras")
public class Carreiras extends AbstractEntity<Long> {

	@Column(name="descricao_carreira")
	private String descricaoCarreira;

	@Column(name="nome_carreira")
	private String nomeCarreira;

	@Column(name="sigla_carreira")
	private String siglaCarreira;

	//bi-directional many-to-one association to HistFuncionariosCarreira
	@OneToMany(mappedBy="carreira")
	private List<HistFuncionariosCarreira> histFuncionariosCarreiras;

	//bi-directional many-to-one association to PessoaFuncionario
	@OneToMany(mappedBy="carreira")
	private List<PessoaFuncionarios> pessoaFuncionarios;

	public Carreiras() {
	}

	public String getDescricaoCarreira() {
		return this.descricaoCarreira;
	}

	public void setDescricaoCarreira(String descricaoCarreira) {
		this.descricaoCarreira = descricaoCarreira;
	}

	public String getNomeCarreira() {
		return this.nomeCarreira;
	}

	public void setNomeCarreira(String nomeCarreira) {
		this.nomeCarreira = nomeCarreira;
	}

	public String getSiglaCarreira() {
		return this.siglaCarreira;
	}

	public void setSiglaCarreira(String siglaCarreira) {
		this.siglaCarreira = siglaCarreira;
	}

	public List<HistFuncionariosCarreira> getHistFuncionariosCarreiras() {
		return this.histFuncionariosCarreiras;
	}

	public void setHistFuncionariosCarreiras(List<HistFuncionariosCarreira> histFuncionariosCarreiras) {
		this.histFuncionariosCarreiras = histFuncionariosCarreiras;
	}

	public HistFuncionariosCarreira addHistFuncionariosCarreira(HistFuncionariosCarreira histFuncionariosCarreira) {
		getHistFuncionariosCarreiras().add(histFuncionariosCarreira);
		histFuncionariosCarreira.setCarreira(this);

		return histFuncionariosCarreira;
	}

	public HistFuncionariosCarreira removeHistFuncionariosCarreira(HistFuncionariosCarreira histFuncionariosCarreira) {
		getHistFuncionariosCarreiras().remove(histFuncionariosCarreira);
		histFuncionariosCarreira.setCarreira(null);

		return histFuncionariosCarreira;
	}

	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return this.pessoaFuncionarios;
	}

	public void setPessoaFuncionarios(List<PessoaFuncionarios> pessoaFuncionarios) {
		this.pessoaFuncionarios = pessoaFuncionarios;
	}

	public PessoaFuncionarios addPessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().add(pessoaFuncionario);
		pessoaFuncionario.setCarreira(this);

		return pessoaFuncionario;
	}

	public PessoaFuncionarios removePessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().remove(pessoaFuncionario);
		pessoaFuncionario.setCarreira(null);

		return pessoaFuncionario;
	}
}
