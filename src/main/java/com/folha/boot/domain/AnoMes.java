package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ano_mes")
public class AnoMes extends AbstractEntity<Long> {

	@Column(name = "nome_ano_mes")
	private String nomeAnoMes;
	
	@OneToMany(mappedBy = "idAnoMesFk")
	private List<Escala> escalaList;
	
	public String getNomeAnoMes() {
		return nomeAnoMes;
	}
	public void setNomeAnoMes(String nomeAnoMes) {
		this.nomeAnoMes = nomeAnoMes;
	}
	public List<Escala> getEscalaList() {
		return escalaList;
	}
	public void setEscalaList(List<Escala> escalaList) {
		this.escalaList = escalaList;
	}
	
	
}
