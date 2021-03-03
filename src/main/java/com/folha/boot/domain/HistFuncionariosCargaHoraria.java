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
	@JoinColumn(name="id_carga_horaria_semanal_fk", insertable = false, updatable = false)
	private CargaHorariaSemanal cargaHorariaSemanal1;

	//bi-directional many-to-one association to CargaHorariaSemanal
	@ManyToOne
	@JoinColumn(name="id_carga_horaria_semanal_fk", insertable = false, updatable = false)
	private CargaHorariaSemanal cargaHorariaSemanal2;

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
	@JoinColumn(name="id_operador_cancelamento_fk", insertable = false, updatable = false)
	private PessoaOperadores pessoaOperadore1;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk", insertable = false, updatable = false)
	private PessoaOperadores pessoaOperadore2;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk", insertable = false, updatable = false)
	private PessoaOperadores pessoaOperadore3;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk", insertable = false, updatable = false)
	private PessoaOperadores pessoaOperadore4;

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

	public PessoaFuncionarios getPessoaFuncionario1() {
		return pessoaFuncionario1;
	}

	public void setPessoaFuncionario1(PessoaFuncionarios pessoaFuncionarios1) {
		this.pessoaFuncionario1 = pessoaFuncionarios1;
	}

	public PessoaFuncionarios getPessoaFuncionario2() {
		return pessoaFuncionario2;
	}

	public void setPessoaFuncionario2(PessoaFuncionarios pessoaFuncionarios2) {
		this.pessoaFuncionario2 = pessoaFuncionarios2;
	}

	public PessoaOperadores getPessoaOperadore1() {
		return pessoaOperadore1;
	}

	public void setPessoaOperadore1(PessoaOperadores pessoaOperadores1) {
		this.pessoaOperadore1 = pessoaOperadores1;
	}

	public PessoaOperadores getPessoaOperadore2() {
		return pessoaOperadore2;
	}

	public void setPessoaOperadore2(PessoaOperadores pessoaOperadores2) {
		this.pessoaOperadore2 = pessoaOperadores2;
	}

	public PessoaOperadores getPessoaOperadore3() {
		return pessoaOperadore3;
	}

	public void setPessoaOperadore3(PessoaOperadores pessoaOperadores3) {
		this.pessoaOperadore3 = pessoaOperadores3;
	}

	public PessoaOperadores getPessoaOperadore4() {
		return pessoaOperadore4;
	}

	public void setPessoaOperadore4(PessoaOperadores pessoaOperadores4) {
		this.pessoaOperadore4 = pessoaOperadores4;
	}	
}
