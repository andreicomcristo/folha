package com.folha.boot.domain.models.outros;



import java.util.Date;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RubricaCodigo;

public class FeriasPeriodosDias {

	private Long id;
	private String anoReferencia;
	private Date dtInicial;
	private Date dtFinal;
	private Date dtAssinatura;
    private Long dias;
	
	
	public FeriasPeriodosDias() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAnoReferencia() {
		return anoReferencia;
	}


	public void setAnoReferencia(String anoReferencia) {
		this.anoReferencia = anoReferencia;
	}


	public Date getDtInicial() {
		return dtInicial;
	}


	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}


	public Date getDtFinal() {
		return dtFinal;
	}


	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}


	public Date getDtAssinatura() {
		return dtAssinatura;
	}


	public void setDtAssinatura(Date dtAssinatura) {
		this.dtAssinatura = dtAssinatura;
	}


	public Long getDias() {
		return dias;
	}


	public void setDias(Long dias) {
		this.dias = dias;
	}
	
		
	
}
