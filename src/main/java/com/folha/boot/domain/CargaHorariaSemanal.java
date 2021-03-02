package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "carga_horaria_semanal")
public class CargaHorariaSemanal extends AbstractEntity<Long> {

	@Column(name="carga_horaria")
	private Integer cargaHoraria;

	@Column(name="descricao_carga_horaria")
	private String descricaoCargaHoraria;

	//bi-directional many-to-one association to HistFuncionariosCargaHoraria
	@OneToMany(mappedBy="cargaHorariaSemanal1")
	private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias1;

	//bi-directional many-to-one association to HistFuncionariosCargaHoraria
	@OneToMany(mappedBy="cargaHorariaSemanal2")
	private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias2;

	//bi-directional many-to-one association to PessoaFuncionario
	@OneToMany(mappedBy="cargaHorariaSemanal")
	private List<PessoaFuncionarios> pessoaFuncionarios;

	public CargaHorariaSemanal() {
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getDescricaoCargaHoraria() {
		return descricaoCargaHoraria;
	}

	public void setDescricaoCargaHoraria(String descricaoCargaHoraria) {
		this.descricaoCargaHoraria = descricaoCargaHoraria;
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorarias1() {
		return histFuncionariosCargaHorarias1;
	}

	public void setHistFuncionariosCargaHorarias1(List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias1) {
		this.histFuncionariosCargaHorarias1 = histFuncionariosCargaHorarias1;
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorarias2() {
		return histFuncionariosCargaHorarias2;
	}

	public void setHistFuncionariosCargaHorarias2(List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorarias2) {
		this.histFuncionariosCargaHorarias2 = histFuncionariosCargaHorarias2;
	}

	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return pessoaFuncionarios;
	}

	public void setPessoaFuncionarios(List<PessoaFuncionarios> pessoaFuncionarios) {
		this.pessoaFuncionarios = pessoaFuncionarios;
	}

}
