package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "niveis_carreira")
public class NiveisCarreira extends AbstractEntity<Long> {

	@Column(name = "nome_nivel_carreira", nullable = false, length = 300)
	private String nomeNivelCarreira;

	@Column(name = "descricao_nivel_carreira", length = 300)
	private String descricaoNivelCarreira;
	
	@OneToMany(mappedBy = "idNivelCarreiraFk")
	private List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiraList;
	
	@OneToMany(mappedBy = "idNivelCarreiraAtualFk")
	private List<PessoaFuncionarios> pessoaFuncionariosList;
	
	@OneToMany(mappedBy = "idNivelCarreiraFk")
    private List<FaixasValoresSubsidio> faixasValoresSubsidioList;

	
	public List<HistFuncionariosNiveisCarreira> getHistFuncionariosNiveisCarreiraList() {
		return histFuncionariosNiveisCarreiraList;
	}

	public void setHistFuncionariosNiveisCarreiraList(
			List<HistFuncionariosNiveisCarreira> histFuncionariosNiveisCarreiraList) {
		this.histFuncionariosNiveisCarreiraList = histFuncionariosNiveisCarreiraList;
	}

	public List<PessoaFuncionarios> getPessoaFuncionariosList() {
		return pessoaFuncionariosList;
	}

	public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
		this.pessoaFuncionariosList = pessoaFuncionariosList;
	}

	public String getNomeNivelCarreira() {
		return nomeNivelCarreira;
	}

	public void setNomeNivelCarreira(String nomeNivelCarreira) {
		this.nomeNivelCarreira = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeNivelCarreira);
	}

	public String getDescricaoNivelCarreira() {
		return descricaoNivelCarreira;
	}

	public void setDescricaoNivelCarreira(String descricaoNivelCarreira) {
		this.descricaoNivelCarreira = UtilidadesDeTexto
				.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoNivelCarreira);
	}

	public List<FaixasValoresSubsidio> getFaixasValoresSubsidioList() {
		return faixasValoresSubsidioList;
	}

	public void setFaixasValoresSubsidioList(List<FaixasValoresSubsidio> faixasValoresSubsidioList) {
		this.faixasValoresSubsidioList = faixasValoresSubsidioList;
	}

	
}
