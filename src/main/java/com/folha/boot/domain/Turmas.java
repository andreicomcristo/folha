package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "turmas")
public class Turmas extends AbstractEntity<Long> { 

	@Column(name = "nome_turma")
	private String nomeTurma;
	@Column(name = "descricao_turma")
	private String descricaoTurma;
	@OneToMany(mappedBy = "idTurmaFk")
	private List<Escala> escalaList;
	@OneToMany(mappedBy = "idTurmaFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList;
	
	@OneToMany(mappedBy = "idTurmaFk")
    private List<EscalaAlteracoes> escalaAlteracoesList;
	
	public String getNomeTurma() {
		return nomeTurma;
	}
	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
	public String getDescricaoTurma() {
		return descricaoTurma;
	}
	public void setDescricaoTurma(String descricaoTurma) {
		this.descricaoTurma = descricaoTurma;
	}
	public List<Escala> getEscalaList() {
		return escalaList;
	}
	public void setEscalaList(List<Escala> escalaList) {
		this.escalaList = escalaList;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList() {
		return escalaPosTransparenciaList;
	}
	public void setEscalaPosTransparenciaList(List<EscalaPosTransparencia> escalaPosTransparenciaList) {
		this.escalaPosTransparenciaList = escalaPosTransparenciaList;
	}
	public List<EscalaAlteracoes> getEscalaAlteracoesList() {
		return escalaAlteracoesList;
	}
	public void setEscalaAlteracoesList(List<EscalaAlteracoes> escalaAlteracoesList) {
		this.escalaAlteracoesList = escalaAlteracoesList;
	}
	
	
	
}
