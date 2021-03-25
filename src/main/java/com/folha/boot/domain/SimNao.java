package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "sim_nao")
public class SimNao extends AbstractEntity<Long> {

	@Column(name = "sigla")
    private String sigla;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idChDifSimNaoFk")
    private List<Escala> escalaList;
    @OneToMany(mappedBy = "idIncrementoDeRiscoSimNaoFk")
    private List<Escala> escalaList1;
	
    
    public SimNao() {
    }


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<Escala> getEscalaList() {
		return escalaList;
	}


	public void setEscalaList(List<Escala> escalaList) {
		this.escalaList = escalaList;
	}


	public List<Escala> getEscalaList1() {
		return escalaList1;
	}


	public void setEscalaList1(List<Escala> escalaList1) {
		this.escalaList1 = escalaList1;
	}

    
	
	
}
