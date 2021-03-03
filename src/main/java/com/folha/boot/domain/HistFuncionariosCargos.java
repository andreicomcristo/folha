package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "hist_funcionarios_cargos")
public class HistFuncionariosCargos extends AbstractEntity<Long> {

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cancelamento")
	private Date dtCancelamento;

	@Column(name="motivo_cadastro")
	private String motivoCadastro;

	@Column(name="motivo_cancelamento")
	private String motivoCancelamento;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="id_cargo_fk", insertable = false, updatable = false)
	private Cargos cargo1;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="id_cargo_fk", insertable = false, updatable = false)
	private Cargos cargo2;

	//bi-directional many-to-one association to PessoaFuncionario
	@ManyToOne
	@JoinColumn(name="id_funcionario_fk", insertable = false, updatable = false)
	private PessoaFuncionarios pessoaFuncionario1;

	//bi-directional many-to-one association to PessoaFuncionario
	@ManyToOne
	@JoinColumn(name="id_funcionario_fk", insertable = false, updatable = false)
	private PessoaFuncionarios pessoaFuncionario2;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk", insertable = false, updatable = false)
	private PessoaOperadores pessoaOperadore1;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk", insertable = false, updatable = false)
	private PessoaOperadores pessoaOperadore2;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk", insertable = false, updatable = false)
	private PessoaOperadores pessoaOperadore3;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk", insertable = false, updatable = false)
	private PessoaOperadores pessoaOperadore4;

	public HistFuncionariosCargos() {
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtCancelamento() {
		return dtCancelamento;
	}

	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}

	public String getMotivoCadastro() {
		return motivoCadastro;
	}

	public void setMotivoCadastro(String motivoCadastro) {
		this.motivoCadastro = motivoCadastro;
	}

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public Cargos getCargo1() {
		return cargo1;
	}

	public void setCargo1(Cargos cargo1) {
		this.cargo1 = cargo1;
	}

	public Cargos getCargo2() {
		return cargo2;
	}

	public void setCargo2(Cargos cargo2) {
		this.cargo2 = cargo2;
	}

	public PessoaFuncionarios getPessoaFuncionario1() {
		return pessoaFuncionario1;
	}

	public void setPessoaFuncionario1(PessoaFuncionarios pessoaFuncionario1) {
		this.pessoaFuncionario1 = pessoaFuncionario1;
	}

	public PessoaFuncionarios getPessoaFuncionario2() {
		return pessoaFuncionario2;
	}

	public void setPessoaFuncionario2(PessoaFuncionarios pessoaFuncionario2) {
		this.pessoaFuncionario2 = pessoaFuncionario2;
	}

	public PessoaOperadores getPessoaOperadore1() {
		return pessoaOperadore1;
	}

	public void setPessoaOperadore1(PessoaOperadores pessoaOperadore1) {
		this.pessoaOperadore1 = pessoaOperadore1;
	}

	public PessoaOperadores getPessoaOperadore2() {
		return pessoaOperadore2;
	}

	public void setPessoaOperadore2(PessoaOperadores pessoaOperadore2) {
		this.pessoaOperadore2 = pessoaOperadore2;
	}

	public PessoaOperadores getPessoaOperadore3() {
		return pessoaOperadore3;
	}

	public void setPessoaOperadore3(PessoaOperadores pessoaOperadore3) {
		this.pessoaOperadore3 = pessoaOperadore3;
	}

	public PessoaOperadores getPessoaOperadore4() {
		return pessoaOperadore4;
	}

	public void setPessoaOperadore4(PessoaOperadores pessoaOperadore4) {
		this.pessoaOperadore4 = pessoaOperadore4;
	}

}
