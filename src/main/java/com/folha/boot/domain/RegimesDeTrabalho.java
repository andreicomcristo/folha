package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "regimes_de_trabalho")
public class RegimesDeTrabalho extends AbstractEntity<Long> {

	@Column(name = "nome_regime_de_trabalho")
	private String nomeRegimeDeTrabalho;
	
	@Column(name = "descricao_regime_de_trabalho")
	private String descricaoRegimeDeTrabalho;
	
	@OneToMany(mappedBy = "idRegimeDeTrabalhoFk")
	private List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList;

	public String getNomeRegimeDeTrabalho() {
		return nomeRegimeDeTrabalho;
	}

	public void setNomeRegimeDeTrabalho(String nomeRegimeDeTrabalho) {
		this.nomeRegimeDeTrabalho = nomeRegimeDeTrabalho;
	}

	public String getDescricaoRegimeDeTrabalho() {
		return descricaoRegimeDeTrabalho;
	}

	public void setDescricaoRegimeDeTrabalho(String descricaoRegimeDeTrabalho) {
		this.descricaoRegimeDeTrabalho = descricaoRegimeDeTrabalho;
	}

	public List<FaixasValoresParametrosCalculoFolhasExtras> getFaixasValoresParametrosCalculoFolhasExtrasList() {
		return faixasValoresParametrosCalculoFolhasExtrasList;
	}

	public void setFaixasValoresParametrosCalculoFolhasExtrasList(
			List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList) {
		this.faixasValoresParametrosCalculoFolhasExtrasList = faixasValoresParametrosCalculoFolhasExtrasList;
	}

}
