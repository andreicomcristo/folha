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
	private List<HistFuncionariosCarreira> histFuncionariosCarreiraCollection;

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

	public List<HistFuncionariosCarreira> getHistFuncionariosCarreiraCollection() {
		return histFuncionariosCarreiraCollection;
	}

	public void setHistFuncionariosCarreiraCollection(
			List<HistFuncionariosCarreira> histFuncionariosCarreiraCollection) {
		this.histFuncionariosCarreiraCollection = histFuncionariosCarreiraCollection;
	}

}
