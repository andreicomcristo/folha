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
	@JoinColumn(name="id_autorizacao_fk", referencedColumnName = "id", nullable = false)
	private Autorizacoes autorizacoes1;

	//bi-directional many-to-one association to Autorizacoe
	@ManyToOne
	@JoinColumn(name="id_autorizacao_fk", referencedColumnName = "id", nullable = false)
	private Autorizacoes autorizacoes2;

	//bi-directional many-to-one association to PessoaFuncionario
	@ManyToOne
	@JoinColumn(name="id_funcionario_fk", referencedColumnName = "id")
	private PessoaFuncionarios pessoaFuncionario;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk", referencedColumnName = "id")
	private PessoaOperadores pessoaOperadores1;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk", referencedColumnName = "id")
	private PessoaOperadores pessoaOperadores2;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk", referencedColumnName = "id")
	private PessoaOperadores pessoaOperadores3;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk", referencedColumnName = "id")
	private PessoaOperadores pessoaOperadores4;

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
		return autorizacoes1;
	}

	public void setAutorizacoe1(Autorizacoes autorizacoe1) {
		this.autorizacoes1 = autorizacoe1;
	}

	public Autorizacoes getAutorizacoe2() {
		return autorizacoes2;
	}

	public void setAutorizacoe2(Autorizacoes autorizacoe2) {
		this.autorizacoes2 = autorizacoe2;
	}

	public PessoaFuncionarios getPessoaFuncionario() {
		return pessoaFuncionario;
	}

	public void setPessoaFuncionario(PessoaFuncionarios pessoaFuncionario) {
		this.pessoaFuncionario = pessoaFuncionario;
	}

	public PessoaOperadores getPessoaOperadore1() {
		return pessoaOperadores1;
	}

	public void setPessoaOperadore1(PessoaOperadores pessoaOperadore1) {
		this.pessoaOperadores1 = pessoaOperadore1;
	}

	public PessoaOperadores getPessoaOperadore2() {
		return pessoaOperadores2;
	}

	public void setPessoaOperadore2(PessoaOperadores pessoaOperadore2) {
		this.pessoaOperadores2 = pessoaOperadore2;
	}

	public PessoaOperadores getPessoaOperadore3() {
		return pessoaOperadores3;
	}

	public void setPessoaOperadore3(PessoaOperadores pessoaOperadore3) {
		this.pessoaOperadores3 = pessoaOperadore3;
	}

	public PessoaOperadores getPessoaOperadore4() {
		return pessoaOperadores4;
	}

	public void setPessoaOperadore4(PessoaOperadores pessoaOperadore4) {
		this.pessoaOperadores4 = pessoaOperadore4;
	}
	
}
