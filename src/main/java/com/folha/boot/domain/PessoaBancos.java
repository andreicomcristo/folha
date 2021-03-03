package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_bancos")
public class PessoaBancos extends AbstractEntity<Long> {

	@Column(name="agencia_dv")
	private String agenciaDv;

	@Column(name="agencia_nome")
	private String agenciaNome;

	@Column(name="agencia_numero")
	private String agenciaNumero;

	@Column(name="conta_dv")
	private String contaDv;

	@Column(name="conta_numero")
	private String contaNumero;

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

	@Column(name="operacao_variacao")
	private String operacaoVariacao;

	private String prioritario;

	//bi-directional many-to-one association to Banco
	@ManyToOne
	@JoinColumn(name="id_banco_fk", insertable = false, updatable = false)
	private Bancos banco;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa_fk", insertable = false, updatable = false)
	private Pessoa pessoa;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk", insertable = false, updatable = false)
	private PessoaOperadores pessoaOperadore1;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk", insertable = false, updatable = false)
	private PessoaOperadores pessoaOperadore2;

	public PessoaBancos() {
	}

	public String getAgenciaDv() {
		return this.agenciaDv;
	}

	public void setAgenciaDv(String agenciaDv) {
		this.agenciaDv = agenciaDv;
	}

	public String getAgenciaNome() {
		return this.agenciaNome;
	}

	public void setAgenciaNome(String agenciaNome) {
		this.agenciaNome = agenciaNome;
	}

	public String getAgenciaNumero() {
		return this.agenciaNumero;
	}

	public void setAgenciaNumero(String agenciaNumero) {
		this.agenciaNumero = agenciaNumero;
	}

	public String getContaDv() {
		return this.contaDv;
	}

	public void setContaDv(String contaDv) {
		this.contaDv = contaDv;
	}

	public String getContaNumero() {
		return this.contaNumero;
	}

	public void setContaNumero(String contaNumero) {
		this.contaNumero = contaNumero;
	}

	public Date getDtCadastro() {
		return this.dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtCancelamento() {
		return this.dtCancelamento;
	}

	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}

	public String getMotivoCadastro() {
		return this.motivoCadastro;
	}

	public void setMotivoCadastro(String motivoCadastro) {
		this.motivoCadastro = motivoCadastro;
	}

	public String getMotivoCancelamento() {
		return this.motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public String getOperacaoVariacao() {
		return this.operacaoVariacao;
	}

	public void setOperacaoVariacao(String operacaoVariacao) {
		this.operacaoVariacao = operacaoVariacao;
	}

	public String getPrioritario() {
		return this.prioritario;
	}

	public void setPrioritario(String prioritario) {
		this.prioritario = prioritario;
	}

	public Bancos getBanco() {
		return this.banco;
	}

	public void setBanco(Bancos banco) {
		this.banco = banco;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaOperadores getPessoaOperadore1() {
		return this.pessoaOperadore1;
	}

	public void setPessoaOperadore1(PessoaOperadores pessoaOperadore1) {
		this.pessoaOperadore1 = pessoaOperadore1;
	}

	public PessoaOperadores getPessoaOperadore2() {
		return this.pessoaOperadore2;
	}

	public void setPessoaOperadore2(PessoaOperadores pessoaOperadore2) {
		this.pessoaOperadore2 = pessoaOperadore2;
	}

}
