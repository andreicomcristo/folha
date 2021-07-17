package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.folha.boot.service.util.UtilidadesDeTexto;

/**
 * The persistent class for the funcionarios_capacitacoes database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "funcionarios_capacitacoes")

public class FuncionariosCapacitacoes extends AbstractEntity<Long> {

	@Basic(optional = false)
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "instituicao")
	private String instituicao;
	
	@Column(name = "carga_horaria")
	private Integer cargaHoraria;
	
	@Column(name = "dt_inicial")
	@Temporal(TemporalType.DATE)
	private Date dtInicial;
	
	@Column(name = "dt_final")
	@Temporal(TemporalType.DATE)
	private Date dtFinal;
	
	@Column(name = "observacoes")
	private String observacoes;
	
	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dtCadastro;
	
	@Column(name = "dt_cancelamento")
	@Temporal(TemporalType.DATE)
	private Date dtCancelamento;
	
	@Column(name = "motivo_cancelamento")
	private String motivoCancelamento;
	
	@JoinColumn(name = "id_area_de_capacitacao_fk", referencedColumnName = "id")
	@ManyToOne
	private AreasDeCapacitacao idAreaDeCapacitacaoFk;
	
	@JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private PessoaFuncionarios idFuncionarioFk;
	
	@JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
	@ManyToOne
	private PessoaOperadores idOperadorCadastroFk;
	
	@JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
	@ManyToOne
	private PessoaOperadores idOperadorCancelamentoFk;
	
	@JoinColumn(name = "id_tipos_capacitacao_fk", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private TiposDeCapacitacao idTiposCapacitacaoFk;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricao);
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(instituicao);
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Date getDtInicial() {
		return dtInicial;
	}

	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}

	public Date getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(observacoes);
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
		this.motivoCancelamento = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(motivoCancelamento);
	}

	public AreasDeCapacitacao getIdAreaDeCapacitacaoFk() {
		return idAreaDeCapacitacaoFk;
	}

	public void setIdAreaDeCapacitacaoFk(AreasDeCapacitacao idAreaDeCapacitacaoFk) {
		this.idAreaDeCapacitacaoFk = idAreaDeCapacitacaoFk;
	}

	public PessoaFuncionarios getIdFuncionarioFk() {
		return idFuncionarioFk;
	}

	public void setIdFuncionarioFk(PessoaFuncionarios idFuncionarioFk) {
		this.idFuncionarioFk = idFuncionarioFk;
	}

	public PessoaOperadores getIdOperadorCadastroFk() {
		return idOperadorCadastroFk;
	}

	public void setIdOperadorCadastroFk(PessoaOperadores idOperadorCadastroFk) {
		this.idOperadorCadastroFk = idOperadorCadastroFk;
	}

	public PessoaOperadores getIdOperadorCancelamentoFk() {
		return idOperadorCancelamentoFk;
	}

	public void setIdOperadorCancelamentoFk(PessoaOperadores idOperadorCancelamentoFk) {
		this.idOperadorCancelamentoFk = idOperadorCancelamentoFk;
	}

	public TiposDeCapacitacao getIdTiposCapacitacaoFk() {
		return idTiposCapacitacaoFk;
	}

	public void setIdTiposCapacitacaoFk(TiposDeCapacitacao idTiposCapacitacaoFk) {
		this.idTiposCapacitacaoFk = idTiposCapacitacaoFk;
	}

}