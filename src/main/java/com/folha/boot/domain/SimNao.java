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
    @OneToMany(mappedBy = "idAvaliacaoAssiduidadeFk")
    private List<Escala> escalaList2;
    @OneToMany(mappedBy = "idAvaliacaoAtividadesBurocraticasFk")
    private List<Escala> escalaList3;
    @OneToMany(mappedBy = "idAvaliacaoFormalizacaoPontoFk")
    private List<Escala> escalaList4;
    @OneToMany(mappedBy = "idAvaliacaoPermanenciaFk")
    private List<Escala> escalaList5;
	
    
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


	public List<Escala> getEscalaList2() {
		return escalaList2;
	}


	public void setEscalaList2(List<Escala> escalaList2) {
		this.escalaList2 = escalaList2;
	}


	public List<Escala> getEscalaList3() {
		return escalaList3;
	}


	public void setEscalaList3(List<Escala> escalaList3) {
		this.escalaList3 = escalaList3;
	}


	public List<Escala> getEscalaList4() {
		return escalaList4;
	}


	public void setEscalaList4(List<Escala> escalaList4) {
		this.escalaList4 = escalaList4;
	}


	public List<Escala> getEscalaList5() {
		return escalaList5;
	}


	public void setEscalaList5(List<Escala> escalaList5) {
		this.escalaList5 = escalaList5;
	}

    
	
	
}
