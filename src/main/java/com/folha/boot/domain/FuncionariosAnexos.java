package com.folha.boot.domain;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name="funcionarios_anexos")

public class FuncionariosAnexos extends AbstractEntity<Long> {

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cancelamento")
	private Date dtCancelamento;

	@Column(name="motivo_cancelamento")
	private String motivoCancelamento;

	@Column(name="pdf_anexo")
	private byte[] pdfAnexo;

	//bi-directional many-to-one association to PessoaFuncionario
	@ManyToOne
	@JoinColumn(name="id_pessoa_funcionario_fk")
	private PessoaFuncionarios pessoaFuncionarios;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cadastro_fk")
	private PessoaOperadores pessoaOperadores1;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_cancelamento_fk")
	private PessoaOperadores pessoaOperadores2;

	//bi-directional one-to-one association to TiposDeAnexo
	@OneToOne
	@JoinColumn(name="id_tipo_de_anexo_fk")
	private TiposDeAnexo tiposDeAnexo;

	public FuncionariosAnexos() {
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

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public byte[] getPdfAnexo() {
		return pdfAnexo;
	}

	public void setPdfAnexo(byte[] pdfAnexo) {
		this.pdfAnexo = pdfAnexo;
	}

	public PessoaFuncionarios getPessoaFuncionarios() {
		return pessoaFuncionarios;
	}

	public void setPessoaFuncionarios(PessoaFuncionarios pessoaFuncionarios) {
		this.pessoaFuncionarios = pessoaFuncionarios;
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

	public TiposDeAnexo getTiposDeAnexo() {
		return tiposDeAnexo;
	}

	public void setTiposDeAnexo(TiposDeAnexo tiposDeAnexo) {
		this.tiposDeAnexo = tiposDeAnexo;
	}
	
}