package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "autorizacoes")
public class Autorizacoes extends AbstractEntity<Long> {

	@Column(name = "dt_inicio")
	@Temporal(TemporalType.DATE)
	private Date dtInicio;

	@Column(name = "dt_fim")
	@Temporal(TemporalType.DATE)
	private Date dtFim;

	@Column(name = "id_carga_horaria_semanal_fk", nullable = false)
	private long idCargaHorariaSemanalFk;

	@Column(name = "dt_criacao", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtCriacao;
	
	@JoinColumn(name = "id_funcionario_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private PessoaFuncionarios idFuncionarioFk;

	@JoinColumn(name = "id_operador_criacao_fk", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private PessoaOperadores idOperadorCriacaoFk;

	@JoinColumn(name = "id_unidade_de_saude_fk", referencedColumnName = "id")
	@ManyToOne
	private Unidades idUnidadeDeSaudeFk;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutorizacaoFk")
	private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList;

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public long getIdCargaHorariaSemanalFk() {
		return idCargaHorariaSemanalFk;
	}

	public void setIdCargaHorariaSemanalFk(long idCargaHorariaSemanalFk) {
		this.idCargaHorariaSemanalFk = idCargaHorariaSemanalFk;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaoList() {
		return histFuncionariosAutorizacaoList;
	}

	public void setHistFuncionariosAutorizacaoList(List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaoList) {
		this.histFuncionariosAutorizacaoList = histFuncionariosAutorizacaoList;
	}

	public PessoaFuncionarios getIdFuncionarioFk() {
		return idFuncionarioFk;
	}

	public void setIdFuncionarioFk(PessoaFuncionarios idFuncionarioFk) {
		this.idFuncionarioFk = idFuncionarioFk;
	}

	public PessoaOperadores getIdOperadorCriacaoFk() {
		return idOperadorCriacaoFk;
	}

	public void setIdOperadorCriacaoFk(PessoaOperadores idOperadorCriacaoFk) {
		this.idOperadorCriacaoFk = idOperadorCriacaoFk;
	}

	public Unidades getIdUnidadeDeSaudeFk() {
		return idUnidadeDeSaudeFk;
	}

	public void setIdUnidadeDeSaudeFk(Unidades idUnidadeDeSaudeFk) {
		this.idUnidadeDeSaudeFk = idUnidadeDeSaudeFk;
	}

}
