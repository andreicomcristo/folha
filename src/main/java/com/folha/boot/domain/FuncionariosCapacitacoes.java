package com.folha.boot.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the funcionarios_capacitacoes database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="funcionarios_capacitacoes")

public class FuncionariosCapacitacoes extends AbstractEntity<Long>  {
	
	@Column(name="carga_horaria")
	private Integer cargaHoraria;

	private String descricao;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cancelamento")
	private Date dtCancelamento;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_final")
	private Date dtFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_inicial")
	private Date dtInicial;

	private String instituicao;

	@Column(name="motivo_cancelamento")
	private String motivoCancelamento;

	private String observacoes;

	@Column(name="pdf_anexo")
	private byte[] pdfAnexo;

	//bi-directional many-to-one association to AreasDeCapacitacao
	@ManyToOne
	@JoinColumn(name="id_area_de_capacitacao_fk", insertable = false, updatable = false)
	private AreasDeCapacitacao areasDeCapacitacao;

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

	//bi-directional many-to-one association to TiposDeCapacitacao
	@ManyToOne
	@JoinColumn(name="id_tipos_capacitacao_fk", insertable = false, updatable = false)
	private TiposDeCapacitacao tiposDeCapacitacao;

	public FuncionariosCapacitacoes() {
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Date getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}

	public Date getDtInicial() {
		return dtInicial;
	}

	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public byte[] getPdfAnexo() {
		return pdfAnexo;
	}

	public void setPdfAnexo(byte[] pdfAnexo) {
		this.pdfAnexo = pdfAnexo;
	}

	public AreasDeCapacitacao getAreasDeCapacitacao() {
		return areasDeCapacitacao;
	}

	public void setAreasDeCapacitacao(AreasDeCapacitacao areasDeCapacitacao) {
		this.areasDeCapacitacao = areasDeCapacitacao;
	}

	public PessoaFuncionarios getPessoaFuncionario() {
		return pessoaFuncionario;
	}

	public void setPessoaFuncionario(PessoaFuncionarios pessoaFuncionarios) {
		this.pessoaFuncionario = pessoaFuncionarios;
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

	public TiposDeCapacitacao getTiposDeCapacitacao() {
		return tiposDeCapacitacao;
	}

	public void setTiposDeCapacitacao(TiposDeCapacitacao tiposDeCapacitacao) {
		this.tiposDeCapacitacao = tiposDeCapacitacao;
	}
	
}