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
	
	@OneToMany(mappedBy = "idCoordenacaoFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList;
	
	@OneToMany(mappedBy = "idCoordenacaoFk")
    private List<AcessoOperadoresCoordenacao> acessoOperadoresCoordenacaoList;
	
	@OneToMany(mappedBy = "idCoordenacaoFk")
    private List<EscalaAlteracoes> escalaAlteracoesList;

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

	public List<AcessoOperadoresCoordenacao> getAcessoOperadoresCoordenacaoList() {
		return acessoOperadoresCoordenacaoList;
	}

	public void setAcessoOperadoresCoordenacaoList(List<AcessoOperadoresCoordenacao> acessoOperadoresCoordenacaoList) {
		this.acessoOperadoresCoordenacaoList = acessoOperadoresCoordenacaoList;
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
