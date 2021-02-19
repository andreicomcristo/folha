package com.folha.boot.domain;
import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "unidades_natureza_juridica")
public class UnidadesNaturezaJuridica extends AbstractEntity<Long> {

	@Column(name = "nome_natureza_juridica", nullable = false, length = 150)
    private String nomeNaturezaJuridica;
   
	@Column(name = "descricao_natureza_juridica", length = 300)
    private String descricaoNaturezaJuridica;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeDeSaudeFk")
    private List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection;

	public String getNomeNaturezaJuridica() {
		return nomeNaturezaJuridica;
	}

	public void setNomeNaturezaJuridica(String nomeNaturezaJuridica) {
		this.nomeNaturezaJuridica = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeNaturezaJuridica);
	}

	public String getDescricaoNaturezaJuridica() {
		return descricaoNaturezaJuridica;
	}

	public void setDescricaoNaturezaJuridica(String descricaoNaturezaJuridica) {
		this.descricaoNaturezaJuridica = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoNaturezaJuridica);
	}

	public List<HistUnidadesNaturezaJuridica> getHistUnidadesNaturezaJuridicaCollection() {
		return histUnidadesNaturezaJuridicaCollection;
	}

	public void setHistUnidadesNaturezaJuridicaCollection(
			List<HistUnidadesNaturezaJuridica> histUnidadesNaturezaJuridicaCollection) {
		this.histUnidadesNaturezaJuridicaCollection = histUnidadesNaturezaJuridicaCollection;
	}

}
