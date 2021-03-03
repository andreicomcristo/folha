package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "vinculos")
public class Vinculos extends AbstractEntity<Long> {

	@Column(name = "nome_vinculo", nullable = false, length = 100)
	private String nomeVinculo;

	@Column(name = "descricao_vinculo", length = 300)
	private String descricaoVinculo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idVinculoFk")
	private List<HistFuncionariosVinculos> histFuncionariosVinculosList;

	public String getNomeVinculo() {
		return nomeVinculo;
	}

	public void setNomeVinculo(String nomeVinculo) {
		this.nomeVinculo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeVinculo);
	}

	public String getDescricaoVinculo() {
		return descricaoVinculo;
	}

	public void setDescricaoVinculo(String descricaoVinculo) {
		this.descricaoVinculo = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoVinculo);
	}

	public List<HistFuncionariosVinculos> getHistFuncionariosVinculosList() {
		return histFuncionariosVinculosList;
	}

	public void setHistFuncionariosVinculosList(List<HistFuncionariosVinculos> histFuncionariosVinculosList) {
		this.histFuncionariosVinculosList = histFuncionariosVinculosList;
	}


}
