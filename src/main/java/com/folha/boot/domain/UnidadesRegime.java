package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "unidades_regime")
public class UnidadesRegime extends AbstractEntity<Long> {

	@Column(name="descricao_regime_unid_lotacao")
	private String descricaoRegimeUnidLotacao;

	@Column(name="nome_regime_unid_lotacao")
	private String nomeRegimeUnidLotacao;

	@Column(name="sigla_regime_unid_lotacao")
	private String siglaRegimeUnidLotacao;

	//bi-directional many-to-one association to HistUnidadesRegime
	@OneToMany(mappedBy="unidadesRegime")
	private List<HistUnidadesRegime> histUnidadesRegimes;

	public UnidadesRegime() {
	}

	public String getDescricaoRegimeUnidLotacao() {
		return this.descricaoRegimeUnidLotacao;
	}

	public void setDescricaoRegimeUnidLotacao(String descricaoRegimeUnidLotacao) {
		this.descricaoRegimeUnidLotacao = descricaoRegimeUnidLotacao;
	}

	public String getNomeRegimeUnidLotacao() {
		return this.nomeRegimeUnidLotacao;
	}

	public void setNomeRegimeUnidLotacao(String nomeRegimeUnidLotacao) {
		this.nomeRegimeUnidLotacao = nomeRegimeUnidLotacao;
	}

	public String getSiglaRegimeUnidLotacao() {
		return this.siglaRegimeUnidLotacao;
	}

	public void setSiglaRegimeUnidLotacao(String siglaRegimeUnidLotacao) {
		this.siglaRegimeUnidLotacao = siglaRegimeUnidLotacao;
	}

	public List<HistUnidadesRegime> getHistUnidadesRegimes() {
		return this.histUnidadesRegimes;
	}

	public void setHistUnidadesRegimes(List<HistUnidadesRegime> histUnidadesRegimes) {
		this.histUnidadesRegimes = histUnidadesRegimes;
	}

	public HistUnidadesRegime addHistUnidadesRegime(HistUnidadesRegime histUnidadesRegime) {
		getHistUnidadesRegimes().add(histUnidadesRegime);
		histUnidadesRegime.setUnidadesRegime(this);

		return histUnidadesRegime;
	}

	public HistUnidadesRegime removeHistUnidadesRegime(HistUnidadesRegime histUnidadesRegime) {
		getHistUnidadesRegimes().remove(histUnidadesRegime);
		histUnidadesRegime.setUnidadesRegime(null);

		return histUnidadesRegime;
	}
}
