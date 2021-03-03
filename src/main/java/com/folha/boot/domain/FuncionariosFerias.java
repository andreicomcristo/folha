package com.folha.boot.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name="funcionarios_ferias")
public class FuncionariosFerias extends AbstractEntity<Long> {
	
	@Column(name="ano_referencia")
	private String anoReferencia;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cancelamento")
	private Date dtCancelamento;

	@Column(name="motivo_cancelamento")
	private String motivoCancelamento;

	//bi-directional many-to-one association to PessoaFuncionario
	@ManyToOne
	@JoinColumn(name="id_funcionario_fk", insertable = false, updatable = false)
	private PessoaFuncionarios pessoaFuncionario;

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
	@JoinColumn(name="id_unidade_lancamento_fk", insertable = false, updatable = false)
	private Unidades unidade;

	//bi-directional many-to-one association to FuncionariosFeriasPeriodo
	@OneToMany(mappedBy="funcionariosFeria")
	private List<FuncionariosFeriasPeriodos> funcionariosFeriasPeriodos;

	public FuncionariosFerias() {
	}

	public String getAnoReferencia() {
		return this.anoReferencia;
	}

	public void setAnoReferencia(String anoReferencia) {
		this.anoReferencia = anoReferencia;
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

	public String getMotivoCancelamento() {
		return this.motivoCancelamento;
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

	public void setPessoaOperadore1(PessoaOperadores pessoaOperadores1) {
		this.pessoaOperadore1 = pessoaOperadores1;
	}

	public PessoaOperadores getPessoaOperadore2() {
		return pessoaOperadore2;
	}

	public void setPessoaOperadore2(PessoaOperadores pessoaOperadores2) {
		this.pessoaOperadore2 = pessoaOperadores2;
	}

	public Unidades getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidades unidade) {
		this.unidade = unidade;
	}

	public List<FuncionariosFeriasPeriodos> getFuncionariosFeriasPeriodos() {
		return funcionariosFeriasPeriodos;
	}

	public void setFuncionariosFeriasPeriodos(List<FuncionariosFeriasPeriodos> funcionariosFeriasPeriodos) {
		this.funcionariosFeriasPeriodos = funcionariosFeriasPeriodos;
	}

	public FuncionariosFeriasPeriodos addFuncionariosFeriasPeriodo(FuncionariosFeriasPeriodos funcionariosFeriasPeriodos) {
		getFuncionariosFeriasPeriodos().add(funcionariosFeriasPeriodos);
		funcionariosFeriasPeriodos.setFuncionariosFerias(this);

		return funcionariosFeriasPeriodos;
	}

	public FuncionariosFeriasPeriodos removeFuncionariosFeriasPeriodo(FuncionariosFeriasPeriodos funcionariosFeriasPeriodos) {
		getFuncionariosFeriasPeriodos().remove(funcionariosFeriasPeriodos);
		funcionariosFeriasPeriodos.setFuncionariosFerias(null);

		return funcionariosFeriasPeriodos;
	}

}