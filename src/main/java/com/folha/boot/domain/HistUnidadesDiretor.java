package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "hist_unidades_diretor")
public class HistUnidadesDiretor extends AbstractEntity<Long> {

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cancelamento")
	private Date dtCancelamento;

	@Column(name="motivo_cadastro")
	private String motivoCadastro;

	@Column(name="motivo_cancelamento")
	private String motivoCancelamento;

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

	//bi-directional many-to-one association to Unidade
	@ManyToOne
	@JoinColumn(name="id_unidade_de_saude_fk", insertable = false, updatable = false)
	private Unidades unidade;

	public HistUnidadesDiretor() {
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaOperadores getPessoaOperadores1() {
		return pessoaOperadore1;
	}

	public void setPessoaOperadores1(PessoaOperadores pessoaOperadores1) {
		this.pessoaOperadore1 = pessoaOperadores1;
	}

	public PessoaOperadores getPessoaOperadores2() {
		return pessoaOperadore2;
	}

	public void setPessoaOperadores2(PessoaOperadores pessoaOperadores2) {
		this.pessoaOperadore2 = pessoaOperadores2;
	}

	public Unidades getUnidades() {
		return unidade;
	}

	public void setUnidades(Unidades unidades) {
		this.unidade = unidades;
	}

}
