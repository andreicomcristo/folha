package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "carreiras")
public class Carreiras extends AbstractEntity<Long> {

	@Column(name = "sigla_carreira", nullable = false, length = 10)
	private String siglaCarreira;

	@Column(name = "nome_carreira", nullable = false, length = 150)
	private String nomeCarreira;

	@Column(name = "descricao_carreira", length = 300)
	private String descricaoCarreira;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarreiraFk")
	private List<HistFuncionariosCarreira> histFuncionariosCarreiraList;
	
	@OneToMany(mappedBy = "idCarreiraAtualFk")
	private List<PessoaFuncionarios> pessoaFuncionariosList;
	
	@OneToMany(mappedBy = "idCarreiraFk")
    private List<FaixasValoresSubsidio> faixasValoresSubsidioList;

	public List<PessoaFuncionarios> getPessoaFuncionariosList() {
		return pessoaFuncionariosList;
	}

	public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
		this.pessoaFuncionariosList = pessoaFuncionariosList;
	}

	public String getSiglaCarreira() {
		return siglaCarreira;
	}

	public void setSiglaCarreira(String siglaCarreira) {
		this.siglaCarreira = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaCarreira);
	}

	public String getNomeCarreira() {
		return nomeCarreira;
	}

	public void setNomeCarreira(String nomeCarreira) {
		this.nomeCarreira = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeCarreira);
	}

	public String getDescricaoCarreira() {
		return descricaoCarreira;
	}

	public void setDescricaoCarreira(String descricaoCarreira) {
		this.descricaoCarreira = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoCarreira);
	}

	public List<HistFuncionariosCarreira> getHistFuncionariosCarreiraList() {
		return histFuncionariosCarreiraList;
	}

	public void setHistFuncionariosCarreiraList(List<HistFuncionariosCarreira> histFuncionariosCarreiraList) {
		this.histFuncionariosCarreiraList = histFuncionariosCarreiraList;
	}

	public List<FaixasValoresSubsidio> getFaixasValoresSubsidioList() {
		return faixasValoresSubsidioList;
	}

	public void setFaixasValoresSubsidioList(List<FaixasValoresSubsidio> faixasValoresSubsidioList) {
		this.faixasValoresSubsidioList = faixasValoresSubsidioList;
	}

	
}
