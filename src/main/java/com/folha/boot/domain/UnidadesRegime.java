package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "unidades_regime")
public class UnidadesRegime extends AbstractEntity<Long> {

	@Column(name = "sigla_regime_unid_lotacao", nullable = false, length = 10)
	private String siglaRegimeUnidLotacao;

	@Column(name = "nome_regime_unid_lotacao", nullable = false, length = 150)
	private String nomeRegimeUnidLotacao;

	@Column(name = "descricao_regime_unid_lotacao", length = 300)
	private String descricaoRegimeUnidLotacao;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeRegimeFk")
	private List<HistUnidadesRegime> histUnidadesRegimeCollection;

	public String getSiglaRegimeUnidLotacao() {
		return siglaRegimeUnidLotacao;
	}

	public void setSiglaRegimeUnidLotacao(String siglaRegimeUnidLotacao) {
		this.siglaRegimeUnidLotacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(siglaRegimeUnidLotacao);
	}

	public String getNomeRegimeUnidLotacao() {
		return nomeRegimeUnidLotacao;
	}

	public void setNomeRegimeUnidLotacao(String nomeRegimeUnidLotacao) {
		this.nomeRegimeUnidLotacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeRegimeUnidLotacao);
	}

	public String getDescricaoRegimeUnidLotacao() {
		return descricaoRegimeUnidLotacao;
	}

	public void setDescricaoRegimeUnidLotacao(String descricaoRegimeUnidLotacao) {
		this.descricaoRegimeUnidLotacao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoRegimeUnidLotacao);
	}

	public List<HistUnidadesRegime> getHistUnidadesRegimeCollection() {
		return histUnidadesRegimeCollection;
	}

	public void setHistUnidadesRegimeCollection(List<HistUnidadesRegime> histUnidadesRegimeCollection) {
		this.histUnidadesRegimeCollection = histUnidadesRegimeCollection;
	}

}
