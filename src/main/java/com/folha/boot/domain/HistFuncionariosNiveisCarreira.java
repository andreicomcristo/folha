package com.folha.boot.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hist_funcionarios_niveis_carreira database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="hist_funcionarios_niveis_carreira")
public class HistFuncionariosNiveisCarreira extends AbstractEntity<Long> {

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

	//bi-directional many-to-one association to NiveisCarreira
	@ManyToOne
	@JoinColumn(name="id_nivel_carreira_fk", insertable = false, updatable = false)
	private NiveisCarreira niveisCarreira;

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

	public HistFuncionariosNiveisCarreira() {
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

	public NiveisCarreira getNiveisCarreira() {
		return niveisCarreira;
	}

	public void setNiveisCarreira(NiveisCarreira niveisCarreira) {
		this.niveisCarreira = niveisCarreira;
	}

	public PessoaFuncionarios getPessoaFuncionarios() {
		return pessoaFuncionario;
	}

	public void setPessoaFuncionarios(PessoaFuncionarios pessoaFuncionarios) {
		this.pessoaFuncionario = pessoaFuncionarios;
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

}