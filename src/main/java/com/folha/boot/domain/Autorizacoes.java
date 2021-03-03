package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "autorizacoes")
public class Autorizacoes extends AbstractEntity<Long> {
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_criacao")
	private Date dtCriacao;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim")
	private Date dtFim;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_inicio")
	private Date dtInicio;

	@Column(name="id_carga_horaria_semanal_fk")
	private Long idCargaHorariaSemanalFk;

	//bi-directional many-to-one association to PessoaFuncionario
	@ManyToOne
	@JoinColumn(name="id_funcionario_fk")
	private PessoaFuncionarios pessoaFuncionarios;

	//bi-directional many-to-one association to PessoaOperadore
	@ManyToOne
	@JoinColumn(name="id_operador_criacao_fk")
	private PessoaOperadores pessoaOperadores;

	//bi-directional many-to-one association to Unidade
	@ManyToOne
	@JoinColumn(name="id_unidade_de_saude_fk")
	private Unidades unidades;

	//bi-directional many-to-one association to HistFuncionariosAutorizacao
	@OneToMany(mappedBy="autorizacoes1")
	private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacoes1;

	//bi-directional many-to-one association to HistFuncionariosAutorizacao
	@OneToMany(mappedBy="autorizacoes2")
	private List<HistFuncionariosAutorizacao> histFuncionariosAutorizacoes2;

	public Autorizacoes() {
	}
	
	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Long getIdCargaHorariaSemanalFk() {
		return idCargaHorariaSemanalFk;
	}

	public void setIdCargaHorariaSemanalFk(Long idCargaHorariaSemanalFk) {
		this.idCargaHorariaSemanalFk = idCargaHorariaSemanalFk;
	}

	public PessoaFuncionarios getPessoaFuncionarios() {
		return pessoaFuncionarios;
	}

	public void setPessoaFuncionarios(PessoaFuncionarios pessoaFuncionarios) {
		this.pessoaFuncionarios = pessoaFuncionarios;
	}

	public PessoaOperadores getPessoaOperadores() {
		return pessoaOperadores;
	}

	public void setPessoaOperadores(PessoaOperadores pessoaOperadores) {
		this.pessoaOperadores = pessoaOperadores;
	}

	public Unidades getUnidades() {
		return unidades;
	}

	public void setUnidades(Unidades unidades) {
		this.unidades = unidades;
	}

	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacoes1() {
		return histFuncionariosAutorizacoes1;
	}

	public void setHistFuncionariosAutorizacoes1(List<HistFuncionariosAutorizacao> histFuncionariosAutorizacoes1) {
		this.histFuncionariosAutorizacoes1 = histFuncionariosAutorizacoes1;
	}

	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacoes2() {
		return histFuncionariosAutorizacoes2;
	}

	public void setHistFuncionariosAutorizacoes2(List<HistFuncionariosAutorizacao> histFuncionariosAutorizacoes2) {
		this.histFuncionariosAutorizacoes2 = histFuncionariosAutorizacoes2;
	}

	public HistFuncionariosAutorizacao addHistFuncionariosAutorizacaos1(HistFuncionariosAutorizacao histFuncionariosAutorizacaos1) {
		getHistFuncionariosAutorizacoes1().add(histFuncionariosAutorizacaos1);
		histFuncionariosAutorizacaos1.setAutorizacoe1(this);

		return histFuncionariosAutorizacaos1;
	}

	public HistFuncionariosAutorizacao removeHistFuncionariosAutorizacaos1(HistFuncionariosAutorizacao histFuncionariosAutorizacaos1) {
		getHistFuncionariosAutorizacoes1().remove(histFuncionariosAutorizacaos1);
		histFuncionariosAutorizacaos1.setAutorizacoe1(null);

		return histFuncionariosAutorizacaos1;
	}

	public List<HistFuncionariosAutorizacao> getHistFuncionariosAutorizacaos2() {
		return this.histFuncionariosAutorizacoes2;
	}

	public void setHistFuncionariosAutorizacaos2(List<HistFuncionariosAutorizacao> histFuncionariosAutorizacaos2) {
		this.histFuncionariosAutorizacoes2 = histFuncionariosAutorizacaos2;
	}

	public HistFuncionariosAutorizacao addHistFuncionariosAutorizacaos2(HistFuncionariosAutorizacao histFuncionariosAutorizacaos2) {
		getHistFuncionariosAutorizacaos2().add(histFuncionariosAutorizacaos2);
		histFuncionariosAutorizacaos2.setAutorizacoe2(this);

		return histFuncionariosAutorizacaos2;
	}

	public HistFuncionariosAutorizacao removeHistFuncionariosAutorizacaos2(HistFuncionariosAutorizacao histFuncionariosAutorizacaos2) {
		getHistFuncionariosAutorizacaos2().remove(histFuncionariosAutorizacaos2);
		histFuncionariosAutorizacaos2.setAutorizacoe2(null);

		return histFuncionariosAutorizacaos2;
	}

}
