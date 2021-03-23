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
@Table(name = "localidade_escala")
public class LocalidadeEscala extends AbstractEntity<Long>{

	@Column(name = "nome_localidade")
    private String nomeLocalidade;
    
	@OneToMany(mappedBy = "idLocalidadeFk")
    private List<CoordenacaoEscala> coordenacaoEscalaList;
    
	@JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;

	public String getNomeLocalidade() {
		return nomeLocalidade;
	}

	public void setNomeLocalidade(String nomeLocalidade) {
		this.nomeLocalidade = nomeLocalidade;
	}

	public List<CoordenacaoEscala> getCoordenacaoEscalaList() {
		return coordenacaoEscalaList;
	}

	public void setCoordenacaoEscalaList(List<CoordenacaoEscala> coordenacaoEscalaList) {
		this.coordenacaoEscalaList = coordenacaoEscalaList;
	}

	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}

	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}
	
	
}
