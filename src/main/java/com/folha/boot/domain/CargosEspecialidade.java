package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "cargos_especialidade")
public class CargosEspecialidade extends AbstractEntity<Long> {

	@Column(name="descricao_especialidade_cargo")
	private String descricaoEspecialidadeCargo;

	@Column(name="nome_especialidade_cargo")
	private String nomeEspecialidadeCargo;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="id_cargo_fk", insertable = false, updatable = false)
	private Cargos cargo;

	//bi-directional many-to-one association to PessoaFuncionario
	@OneToMany(mappedBy="cargosEspecialidade")
	private List<PessoaFuncionarios> pessoaFuncionarios;

	//bi-directional many-to-one association to FuncionariosLicenca
	@OneToMany(mappedBy="cargosEspecialidade")
	private List<FuncionariosLicencas> funcionariosLicencas;

	public CargosEspecialidade() {
	}

	public String getDescricaoEspecialidadeCargo() {
		return descricaoEspecialidadeCargo;
	}

	public void setDescricaoEspecialidadeCargo(String descricaoEspecialidadeCargo) {
		this.descricaoEspecialidadeCargo = descricaoEspecialidadeCargo;
	}

	public String getNomeEspecialidadeCargo() {
		return nomeEspecialidadeCargo;
	}

	public void setNomeEspecialidadeCargo(String nomeEspecialidadeCargo) {
		this.nomeEspecialidadeCargo = nomeEspecialidadeCargo;
	}

	public Cargos getCargo() {
		return cargo;
	}

	public void setCargo(Cargos cargo) {
		this.cargo = cargo;
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

	public PessoaFuncionarios addPessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().add(pessoaFuncionario);
		pessoaFuncionario.setCargosEspecialidade(this);

		return pessoaFuncionario;
	}

	public PessoaFuncionarios removePessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		getPessoaFuncionarios().remove(pessoaFuncionario);
		pessoaFuncionario.setCargosEspecialidade(null);

		return pessoaFuncionario;
	}

	public FuncionariosLicencas addFuncionariosLicenca(FuncionariosLicencas funcionariosLicenca) {
		getFuncionariosLicencas().add(funcionariosLicenca);
		funcionariosLicenca.setCargosEspecialidade(this);

		return funcionariosLicenca;
	}

	public FuncionariosLicencas removeFuncionariosLicenca(FuncionariosLicencas funcionariosLicenca) {
		getFuncionariosLicencas().remove(funcionariosLicenca);
		funcionariosLicenca.setCargosEspecialidade(null);

		return funcionariosLicenca;
	}

}
