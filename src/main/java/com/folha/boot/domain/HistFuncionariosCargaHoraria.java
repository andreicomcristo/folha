package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "hist_funcionarios_carga_horaria")
public class HistFuncionariosCargaHoraria extends AbstractEntity<Long> {

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

	//bi-directional many-to-one association to CargaHorariaSemanal
	@ManyToOne
	@JoinColumn(name="id_carga_horaria_semanal_fk")
	private CargaHorariaSemanal cargaHorariaSemanal1;

	//bi-directional many-to-one association to CargaHorariaSemanal
	@ManyToOne
	@JoinColumn(name="id_carga_horaria_semanal_fk")
	private CargaHorariaSemanal cargaHorariaSemanal2;

	//bi-directional many-to-one association to PessoaFuncionario
	@ManyToOne
	@JoinColumn(name="id_funcionario_fk")
	private PessoaFuncionarios pessoaFuncionarios1;

	//bi-directional many-to-one association to PessoaFuncionario
	@ManyToOne
	@JoinColumn(name="id_funcionario_fk")
	private PessoaFuncionarios pessoaFuncionarios2;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk")
	private PessoaOperadores pessoaOperadores1;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk")
	private PessoaOperadores pessoaOperadores2;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk")
	private PessoaOperadores pessoaOperadores3;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk")
	private PessoaOperadores pessoaOperadores4;

	public HistFuncionariosCargaHoraria() {
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

	public CargaHorariaSemanal getCargaHorariaSemanal1() {
		return cargaHorariaSemanal1;
	}

	public void setCargaHorariaSemanal1(CargaHorariaSemanal cargaHorariaSemanal1) {
		this.cargaHorariaSemanal1 = cargaHorariaSemanal1;
	}

	public CargaHorariaSemanal getCargaHorariaSemanal2() {
		return cargaHorariaSemanal2;
	}

	public void setCargaHorariaSemanal2(CargaHorariaSemanal cargaHorariaSemanal2) {
		this.cargaHorariaSemanal2 = cargaHorariaSemanal2;
	}

	public PessoaFuncionarios getPessoaFuncionarios1() {
		return pessoaFuncionarios1;
	}

	public void setPessoaFuncionarios1(PessoaFuncionarios pessoaFuncionarios1) {
		this.pessoaFuncionarios1 = pessoaFuncionarios1;
	}

	public PessoaFuncionarios getPessoaFuncionarios2() {
		return pessoaFuncionarios2;
	}

	public void setPessoaFuncionarios2(PessoaFuncionarios pessoaFuncionarios2) {
		this.pessoaFuncionarios2 = pessoaFuncionarios2;
	}

	public PessoaOperadores getPessoaOperadores1() {
		return pessoaOperadores1;
	}

	public void setPessoaOperadores1(PessoaOperadores pessoaOperadores1) {
		this.pessoaOperadores1 = pessoaOperadores1;
	}

	public PessoaOperadores getPessoaOperadores2() {
		return pessoaOperadores2;
	}

	public void setPessoaOperadores2(PessoaOperadores pessoaOperadores2) {
		this.pessoaOperadores2 = pessoaOperadores2;
	}

	public PessoaOperadores getPessoaOperadores3() {
		return pessoaOperadores3;
	}

	public void setPessoaOperadores3(PessoaOperadores pessoaOperadores3) {
		this.pessoaOperadores3 = pessoaOperadores3;
	}

	public PessoaOperadores getPessoaOperadores4() {
		return pessoaOperadores4;
	}

	public void setPessoaOperadores4(PessoaOperadores pessoaOperadores4) {
		this.pessoaOperadores4 = pessoaOperadores4;
	}
	
}
