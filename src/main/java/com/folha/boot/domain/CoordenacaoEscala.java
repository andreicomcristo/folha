package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "coordenacao_escala")
public class CoordenacaoEscala extends AbstractEntity<Long>{

	@Column(name = "nome_coordenacao")
    private String nomeCoordenacao;
    
	@JoinColumn(name = "id_atividade_fk", referencedColumnName = "id")
    @ManyToOne
    private AtividadeEscala idAtividadeFk;
    
	@JoinColumn(name = "id_localidade_fk", referencedColumnName = "id")
    @ManyToOne
    private LocalidadeEscala idLocalidadeFk;
    
	@OneToMany(mappedBy = "idCoordenacaoFk")
    private List<Escala> escalaList;

	public String getNomeCoordenacao() {
		return nomeCoordenacao;
	}

	public void setNomeCoordenacao(String nomeCoordenacao) {
		this.nomeCoordenacao = nomeCoordenacao;
	}

	public AtividadeEscala getIdAtividadeFk() {
		return idAtividadeFk;
	}

	public void setIdAtividadeFk(AtividadeEscala idAtividadeFk) {
		this.idAtividadeFk = idAtividadeFk;
	}

	public LocalidadeEscala getIdLocalidadeFk() {
		return idLocalidadeFk;
	}

	public void setIdLocalidadeFk(LocalidadeEscala idLocalidadeFk) {
		this.idLocalidadeFk = idLocalidadeFk;
	}

	public List<Escala> getEscalaList() {
		return escalaList;
	}

	public void setEscalaList(List<Escala> escalaList) {
		this.escalaList = escalaList;
	}
    
	
}
