package com.folha.boot.domain;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "unidades_natureza_juridica")
public class UnidadesNaturezaJuridica extends AbstractEntity<Long> {

	@Column(name="descricao_natureza_juridica")
	private String descricaoNaturezaJuridica;

	@Column(name="nome_natureza_juridica")
	private String nomeNaturezaJuridica;

	//bi-directional many-to-one association to HistUnidadesNaturezaJuridica
	@OneToMany(mappedBy="unidadesNaturezaJuridica")
	private List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicas;

	public UnidadesNaturezaJuridica() {
	}

	public String getDescricaoNaturezaJuridica() {
		return this.descricaoNaturezaJuridica;
	}

	public void setDescricaoNaturezaJuridica(String descricaoNaturezaJuridica) {
		this.descricaoNaturezaJuridica = descricaoNaturezaJuridica;
	}

	public String getNomeNaturezaJuridica() {
		return this.nomeNaturezaJuridica;
	}

	public void setNomeNaturezaJuridica(String nomeNaturezaJuridica) {
		this.nomeNaturezaJuridica = nomeNaturezaJuridica;
	}

	public List<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridicas() {
		return this.histUnidadesNaturezaJuridicas;
	}

	public void setHistUnidadesNaturezaJuridicas(List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicas) {
		this.histUnidadesNaturezaJuridicas = histUnidadesNaturezaJuridicas;
	}

	public HistUnidadesNaturezaJuridica addHistUnidadesNaturezaJuridica(HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridica) {
		getHistUnidadesNaturezaJuridicas().add(histUnidadesNaturezaJuridica);
		histUnidadesNaturezaJuridica.setUnidadesNaturezaJuridica(this);

		return histUnidadesNaturezaJuridica;
	}

	public HistUnidadesNaturezaJuridica removeHistUnidadesNaturezaJuridica(HistUnidadesNaturezaJuridica histUnidadesNaturezaJuridica) {
		getHistUnidadesNaturezaJuridicas().remove(histUnidadesNaturezaJuridica);
		histUnidadesNaturezaJuridica.setUnidadesNaturezaJuridica(null);

		return histUnidadesNaturezaJuridica;
	}


}
