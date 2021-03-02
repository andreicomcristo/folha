package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "hist_funcionarios_autorizacao")
public class HistFuncionariosAutorizacao extends AbstractEntity<Long> {

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

	//bi-directional many-to-one association to Autorizacoe
	@ManyToOne
	@JoinColumn(name="id_autorizacao_fk")
	private Autorizacoes autorizacoe1;

	//bi-directional many-to-one association to Autorizacoe
	@ManyToOne
	@JoinColumn(name="id_autorizacao_fk")
	private Autorizacoes autorizacoe2;

	//bi-directional many-to-one association to PessoaFuncionario
	@ManyToOne
	@JoinColumn(name="id_funcionario_fk")
	private PessoaFuncionarios pessoaFuncionario;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk")
	private PessoaOperadores pessoaOperadore1;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk")
	private PessoaOperadores pessoaOperadore2;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk")
	private PessoaOperadores pessoaOperadore3;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk")
	private PessoaOperadores pessoaOperadore4;

	public HistFuncionariosAutorizacao() {
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

	public Autorizacoes getAutorizacoe1() {
		return autorizacoe1;
	}

	public void setAutorizacoe1(Autorizacoes autorizacoe1) {
		this.autorizacoe1 = autorizacoe1;
	}

	public Autorizacoes getAutorizacoe2() {
		return autorizacoe2;
	}

	public void setAutorizacoe2(Autorizacoes autorizacoe2) {
		this.autorizacoe2 = autorizacoe2;
	}

	public PessoaFuncionarios getPessoaFuncionario() {
		return pessoaFuncionario;
	}

	public void setPessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		this.pessoaFuncionario = pessoaFuncionario;
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
