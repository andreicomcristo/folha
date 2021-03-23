package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "atividade_escala")
public class AtividadeEscala extends AbstractEntity<Long> {

	@Column(name = "nome_atividade")
	private String nomeAtividade;
	
	@Column(name = "descricao_atividade")
	private String descricaoAtividade;
	
	@OneToMany(mappedBy = "idAtividadeFk")
	private List<CoordenacaoEscala> coordenacaoEscalaList;

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}

	public String getDescricaoAtividade() {
		return descricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
	}

	public List<CoordenacaoEscala> getCoordenacaoEscalaList() {
		return coordenacaoEscalaList;
	}

	public void setCoordenacaoEscalaList(List<CoordenacaoEscala> coordenacaoEscalaList) {
		this.coordenacaoEscalaList = coordenacaoEscalaList;
	}

}
