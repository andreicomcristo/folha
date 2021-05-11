package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "carga_horaria_semanal")
public class CargaHorariaSemanal extends AbstractEntity<Long> {

	@Basic(optional = false)
    @Column(name = "carga_horaria")
    private int cargaHoraria;
    @Column(name = "descricao_carga_horaria")
    private String descricaoCargaHoraria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargaHorariaSemanalFk")
    private List<HistFuncionariosCargaHoraria> histFuncionariosCargaHorariaList;
    @OneToMany(mappedBy = "idCargaHorariaAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;
    @OneToMany(mappedBy = "idCargaHorariaSemanalFk")
    private List<FaixasValoresSubsidio> faixasValoresSubsidioList;
    
    @OneToMany(mappedBy = "idCargaHorariaSemanalFk")
    private List<FaixasValoresGpf> faixasValoresGpfList;
    
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

	public List<FaixasValoresSubsidio> getFaixasValoresSubsidioList() {
		return faixasValoresSubsidioList;
	}

	public void setFaixasValoresSubsidioList(List<FaixasValoresSubsidio> faixasValoresSubsidioList) {
		this.faixasValoresSubsidioList = faixasValoresSubsidioList;
	}

	public List<FaixasValoresGpf> getFaixasValoresGpfList() {
		return faixasValoresGpfList;
	}

	public void setFaixasValoresGpfList(List<FaixasValoresGpf> faixasValoresGpfList) {
		this.faixasValoresGpfList = faixasValoresGpfList;
	}
	
	
}
