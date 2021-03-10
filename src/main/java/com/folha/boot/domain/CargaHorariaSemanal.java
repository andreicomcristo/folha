package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "carga_horaria_semanal")
public class CargaHorariaSemanal extends AbstractEntity<Long> {

	@Column(name = "carga_horaria", nullable = false)
	private int cargaHoraria;

	@Column(name = "descricao_carga_horaria", length = 300)
	private String descricaoCargaHoraria;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargaHorariaSemanalFk")
	private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargaHorariaSemanalFk")
    private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargaHorariaAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;
	
	
	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaList() {
		return histFuncionariosCargaHorariaList;
	}

	public void setHistFuncionariosCargaHorariaList(List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList) {
		this.histFuncionariosCargaHorariaList = histFuncionariosCargaHorariaList;
	}

	public List<PessoaFuncionarios> getPessoaFuncionariosList() {
		return pessoaFuncionariosList;
	}

	public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
		this.pessoaFuncionariosList = pessoaFuncionariosList;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getDescricaoCargaHoraria() {
		return descricaoCargaHoraria;
	}

	public void setDescricaoCargaHoraria(String descricaoCargaHoraria) {
		this.descricaoCargaHoraria = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoCargaHoraria);
	}

	public List<HistFuncionariosCargaHoraria> getHistFuncionariosCargaHorariaCollection() {
		return histFuncionariosCargaHorariaCollection;
	}

	public void setHistFuncionariosCargaHorariaCollection(
			List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaCollection) {
		this.histFuncionariosCargaHorariaCollection = histFuncionariosCargaHorariaCollection;
	}
	
}
