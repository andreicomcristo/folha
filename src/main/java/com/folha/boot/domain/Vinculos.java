package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "vinculos")
public class Vinculos extends AbstractEntity<Long> {

	@Column(name="descricao_vinculo")
	private String descricaoVinculo;

	@Column(name="nome_vinculo")
	private String nomeVinculo;

	//bi-directional many-to-one association to HistFuncionariosVinculo
	@OneToMany(mappedBy="vinculo")
	private List<HistFuncionariosVinculos> histFuncionariosVinculos;

	//bi-directional many-to-one association to PessoaFuncionario
	@OneToMany(mappedBy="vinculo")
	private List<PessoaFuncionarios> pessoaFuncionarios;

	//bi-directional many-to-one association to FuncionariosLicenca
	@OneToMany(mappedBy="vinculo")
	private List<FuncionariosLicencas> funcionariosLicencas;

	public Vinculos() {
	}

	public String getDescricaoVinculo() {
		return this.descricaoVinculo;
	}

	public void setDescricaoVinculo(String descricaoVinculo) {
		this.descricaoVinculo = descricaoVinculo;
	}

	public String getNomeVinculo() {
		return this.nomeVinculo;
	}

	public void setNomeVinculo(String nomeVinculo) {
		this.nomeVinculo = nomeVinculo;
	}

	public List<HistFuncionariosVinculos> getHistFuncionariosVinculos() {
		return this.histFuncionariosVinculos;
	}

	public void setHistFuncionariosVinculos(List<HistFuncionariosVinculos> histFuncionariosVinculos) {
		this.histFuncionariosVinculos = histFuncionariosVinculos;
	}

	public HistFuncionariosVinculos addHistFuncionariosVinculo(HistFuncionariosVinculos histFuncionariosVinculo) {
		getHistFuncionariosVinculos().add(histFuncionariosVinculo);
		histFuncionariosVinculo.setVinculo(this);

		return histFuncionariosVinculo;
	}

	public HistFuncionariosVinculos removeHistFuncionariosVinculo(HistFuncionariosVinculos histFuncionariosVinculo) {
		getHistFuncionariosVinculos().remove(histFuncionariosVinculo);
		histFuncionariosVinculo.setVinculo(null);

		return histFuncionariosVinculo;
	}

	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return this.pessoaFuncionarios;
	}

	public void setPessoaFuncionarios(List<PessoaFuncionarios> pessoaFuncionarios) {
		this.pessoaFuncionarios = pessoaFuncionarios;
	}

	public PessoaFuncionarios addPessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().add(pessoaFuncionario);
		pessoaFuncionario.setVinculo(this);

		return pessoaFuncionario;
	}

	public PessoaFuncionarios removePessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().remove(pessoaFuncionario);
		pessoaFuncionario.setVinculo(null);

		return pessoaFuncionario;
	}

	public List<FuncionariosLicencas> getFuncionariosLicencas() {
		return this.funcionariosLicencas;
	}

	public void setFuncionariosLicencas(List<FuncionariosLicencas> funcionariosLicencas) {
		this.funcionariosLicencas = funcionariosLicencas;
	}

	public FuncionariosLicencas addFuncionariosLicenca(FuncionariosLicencas funcionariosLicenca) {
		getFuncionariosLicencas().add(funcionariosLicenca);
		funcionariosLicenca.setVinculos(this);

		return funcionariosLicenca;
	}

	public FuncionariosLicencas removeFuncionariosLicenca(FuncionariosLicencas funcionariosLicenca) {
		getFuncionariosLicencas().remove(funcionariosLicenca);
		funcionariosLicenca.setVinculos(null);

		return funcionariosLicenca;
	}

}
