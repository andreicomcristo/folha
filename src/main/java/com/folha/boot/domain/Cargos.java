package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "cargos")
public class Cargos extends AbstractEntity<Long> {

	@Column(name="descricao_cargo")
	private String descricaoCargo;

	@Column(name="nome_cargo")
	private String nomeCargo;

	//bi-directional many-to-one association to NiveisCargo
	@ManyToOne
	@JoinColumn(name="id_nivel_cargo_fk", insertable = false, updatable = false)
	private NiveisCargo niveisCargo;

	//bi-directional many-to-one association to CargosEspecialidade
	@OneToMany(mappedBy="cargo")
	private List<CargosEspecialidade> cargosEspecialidades;

	//bi-directional many-to-one association to HistFuncionariosCargo
	@OneToMany(mappedBy="cargo1")
	private List<HistFuncionariosCargos> histFuncionariosCargos1;

	//bi-directional many-to-one association to HistFuncionariosCargo
	@OneToMany(mappedBy="cargo2")
	private List<HistFuncionariosCargos> histFuncionariosCargos2;

	//bi-directional many-to-one association to PessoaFuncionario
	@OneToMany(mappedBy="cargo")
	private List<PessoaFuncionarios> pessoaFuncionarios;

	//bi-directional many-to-one association to FuncionariosLicenca
	@OneToMany(mappedBy="cargo")
	private List<FuncionariosLicencas> funcionariosLicencas;

	public Cargos() {
	}
	
	public String getDescricaoCargo() {
		return descricaoCargo;
	}

	public void setDescricaoCargo(String descricaoCargo) {
		this.descricaoCargo = descricaoCargo;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public NiveisCargo getNiveisCargo() {
		return niveisCargo;
	}

	public void setNiveisCargo(NiveisCargo niveisCargo) {
		this.niveisCargo = niveisCargo;
	}

	public List<CargosEspecialidade> getCargosEspecialidades() {
		return cargosEspecialidades;
	}

	public void setCargosEspecialidades(List<CargosEspecialidade> cargosEspecialidades) {
		this.cargosEspecialidades = cargosEspecialidades;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargos1() {
		return histFuncionariosCargos1;
	}

	public void setHistFuncionariosCargos1(List<HistFuncionariosCargos> histFuncionariosCargos1) {
		this.histFuncionariosCargos1 = histFuncionariosCargos1;
	}

	public List<HistFuncionariosCargos> getHistFuncionariosCargos2() {
		return histFuncionariosCargos2;
	}

	public void setHistFuncionariosCargos2(List<HistFuncionariosCargos> histFuncionariosCargos2) {
		this.histFuncionariosCargos2 = histFuncionariosCargos2;
	}

	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return pessoaFuncionarios;
	}

	public void setPessoaFuncionarios(List<PessoaFuncionarios> pessoaFuncionarios) {
		this.pessoaFuncionarios = pessoaFuncionarios;
	}

	public List<FuncionariosLicencas> getFuncionariosLicencas() {
		return funcionariosLicencas;
	}

	public void setFuncionariosLicencas(List<FuncionariosLicencas> funcionariosLicencas) {
		this.funcionariosLicencas = funcionariosLicencas;
	}

	public CargosEspecialidade addCargosEspecialidade(CargosEspecialidade cargosEspecialidade) {
		getCargosEspecialidades().add(cargosEspecialidade);
		cargosEspecialidade.setCargo(this);

		return cargosEspecialidade;
	}

	public CargosEspecialidade removeCargosEspecialidade(CargosEspecialidade cargosEspecialidade) {
		getCargosEspecialidades().remove(cargosEspecialidade);
		cargosEspecialidade.setCargo(null);

		return cargosEspecialidade;
	}


	public HistFuncionariosCargos addHistFuncionariosCargos1(HistFuncionariosCargos histFuncionariosCargos1) {
		getHistFuncionariosCargos1().add(histFuncionariosCargos1);
		histFuncionariosCargos1.setCargo1(this);

		return histFuncionariosCargos1;
	}

	public HistFuncionariosCargos removeHistFuncionariosCargos1(HistFuncionariosCargos histFuncionariosCargos1) {
		getHistFuncionariosCargos1().remove(histFuncionariosCargos1);
		histFuncionariosCargos1.setCargo1(null);

		return histFuncionariosCargos1;
	}

	public HistFuncionariosCargos addHistFuncionariosCargos2(HistFuncionariosCargos histFuncionariosCargos2) {
		getHistFuncionariosCargos2().add(histFuncionariosCargos2);
		histFuncionariosCargos2.setCargo2(this);

		return histFuncionariosCargos2;
	}

	public HistFuncionariosCargos removeHistFuncionariosCargos2(HistFuncionariosCargos histFuncionariosCargos2) {
		getHistFuncionariosCargos2().remove(histFuncionariosCargos2);
		histFuncionariosCargos2.setCargo2(null);

		return histFuncionariosCargos2;
	}

	public PessoaFuncionarios addPessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().add(pessoaFuncionario);
		pessoaFuncionario.setCargo(this);

		return pessoaFuncionario;
	}

	public PessoaFuncionarios removePessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().remove(pessoaFuncionario);
		pessoaFuncionario.setCargo(null);

		return pessoaFuncionario;
	}

	public FuncionariosLicencas addFuncionariosLicenca(FuncionariosLicencas funcionariosLicenca) {
		getFuncionariosLicencas().add(funcionariosLicenca);
		funcionariosLicenca.setCargos(this);

		return funcionariosLicenca;
	}

	public FuncionariosLicencas removeFuncionariosLicenca(FuncionariosLicencas funcionariosLicenca) {
		getFuncionariosLicencas().remove(funcionariosLicenca);
		funcionariosLicenca.setCargos(null);

		return funcionariosLicenca;
	}

}
