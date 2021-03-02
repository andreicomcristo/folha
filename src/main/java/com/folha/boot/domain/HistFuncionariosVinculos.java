package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "hist_funcionarios_vinculos")
public class HistFuncionariosVinculos extends AbstractEntity<Long> {

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

	//bi-directional many-to-one association to Vinculo
	@ManyToOne
	@JoinColumn(name="id_vinculo_fk")
	private Vinculos vinculo;

	public HistFuncionariosVinculos() {
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

	public Vinculos getVinculo() {
		return vinculo;
	}

	public void setVinculo(Vinculos vinculo) {
		this.vinculo = vinculo;
	}	
	
}
