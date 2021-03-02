package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "niveis_carreira")
public class NiveisCarreira extends AbstractEntity<Long> {

	@Column(name="descricao_nivel_carreira")
	private String descricaoNivelCarreira;

	@Column(name="nome_nivel_carreira")
	private String nomeNivelCarreira;

	//bi-directional many-to-one association to HistFuncionariosNiveisCarreira
	@OneToMany(mappedBy="niveisCarreira")
	private List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiras;

	//bi-directional many-to-one association to PessoaFuncionario
	@OneToMany(mappedBy="niveisCarreira")
	private List<PessoaFuncionarios> pessoaFuncionarios;

	public NiveisCarreira() {
	}

	public String getDescricaoNivelCarreira() {
		return this.descricaoNivelCarreira;
	}

	public void setDescricaoNivelCarreira(String descricaoNivelCarreira) {
		this.descricaoNivelCarreira = descricaoNivelCarreira;
	}

	public String getNomeNivelCarreira() {
		return this.nomeNivelCarreira;
	}

	public void setNomeNivelCarreira(String nomeNivelCarreira) {
		this.nomeNivelCarreira = nomeNivelCarreira;
	}

	public List<HistFuncionariosNiveisCarreira> getHistFuncionariosNiveisCarreiras() {
		return this.histFuncionariosNiveisCarreiras;
	}

	public void setHistFuncionariosNiveisCarreiras(List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiras) {
		this.histFuncionariosNiveisCarreiras = histFuncionariosNiveisCarreiras;
	}

	public HistFuncionariosNiveisCarreira addHistFuncionariosNiveisCarreira(HistFuncionariosNiveisCarreira histFuncionariosNiveisCarreira) {
		getHistFuncionariosNiveisCarreiras().add(histFuncionariosNiveisCarreira);
		histFuncionariosNiveisCarreira.setNiveisCarreira(this);

		return histFuncionariosNiveisCarreira;
	}

	public HistFuncionariosNiveisCarreira removeHistFuncionariosNiveisCarreira(HistFuncionariosNiveisCarreira histFuncionariosNiveisCarreira) {
		getHistFuncionariosNiveisCarreiras().remove(histFuncionariosNiveisCarreira);
		histFuncionariosNiveisCarreira.setNiveisCarreira(null);

		return histFuncionariosNiveisCarreira;
	}

	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return this.pessoaFuncionarios;
	}

	public void setPessoaFuncionarios(List<PessoaFuncionarios> pessoaFuncionarios) {
		this.pessoaFuncionarios = pessoaFuncionarios;
	}

	public PessoaFuncionarios addPessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().add(pessoaFuncionario);
		pessoaFuncionario.setNiveisCarreira(this);

		return pessoaFuncionario;
	}

	public PessoaFuncionarios removePessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().remove(pessoaFuncionario);
		pessoaFuncionario.setNiveisCarreira(null);

		return pessoaFuncionario;
	}
}
