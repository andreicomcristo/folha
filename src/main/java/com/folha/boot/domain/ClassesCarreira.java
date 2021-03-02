package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "classes_carreira")
public class ClassesCarreira extends AbstractEntity<Long> {
	@Column(name="descricao_classe")
	private String descricaoClasse;

	@Column(name="nome_classe")
	private String nomeClasse;

	@Column(name="sigla_classe")
	private String siglaClasse;

	//bi-directional many-to-one association to HistFuncionariosClasse
	@OneToMany(mappedBy="classesCarreira")
	private List<HistFuncionariosClasse> histFuncionariosClasses;

	//bi-directional many-to-one association to PessoaFuncionario
	@OneToMany(mappedBy="classesCarreira")
	private List<PessoaFuncionarios> pessoaFuncionarios;

	public ClassesCarreira() {
	}

	public String getDescricaoClasse() {
		return this.descricaoClasse;
	}

	public void setDescricaoClasse(String descricaoClasse) {
		this.descricaoClasse = descricaoClasse;
	}

	public String getNomeClasse() {
		return this.nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}

	public String getSiglaClasse() {
		return this.siglaClasse;
	}

	public void setSiglaClasse(String siglaClasse) {
		this.siglaClasse = siglaClasse;
	}

	public List<HistFuncionariosClasse> getHistFuncionariosClasses() {
		return this.histFuncionariosClasses;
	}

	public void setHistFuncionariosClasses(List<HistFuncionariosClasse> histFuncionariosClasses) {
		this.histFuncionariosClasses = histFuncionariosClasses;
	}

	public HistFuncionariosClasse addHistFuncionariosClass(HistFuncionariosClasse histFuncionariosClass) {
		getHistFuncionariosClasses().add(histFuncionariosClass);
		histFuncionariosClass.setClassesCarreira(this);

		return histFuncionariosClass;
	}

	public HistFuncionariosClasse removeHistFuncionariosClass(HistFuncionariosClasse histFuncionariosClass) {
		getHistFuncionariosClasses().remove(histFuncionariosClass);
		histFuncionariosClass.setClassesCarreira(null);

		return histFuncionariosClass;
	}

	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return this.pessoaFuncionarios;
	}

	public void setPessoaFuncionarios(List<PessoaFuncionarios> pessoaFuncionarios) {
		this.pessoaFuncionarios = pessoaFuncionarios;
	}

	public PessoaFuncionarios addPessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().add(pessoaFuncionario);
		pessoaFuncionario.setClassesCarreira(this);

		return pessoaFuncionario;
	}

	public PessoaFuncionarios removePessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().remove(pessoaFuncionario);
		pessoaFuncionario.setClassesCarreira(null);

		return pessoaFuncionario;
	}
}
