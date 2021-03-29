package com.folha.boot.domain.models;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CoordenacaoEscala;

public class EscolhaAcessoEscala {

	AnoMes anoMes;
	CoordenacaoEscala coordenacaoEscala;
	
	public EscolhaAcessoEscala() {
		super();
	}
	
	public EscolhaAcessoEscala(AnoMes anoMes, CoordenacaoEscala coordenacaoEscala) {
		super();
		this.anoMes = anoMes;
		this.coordenacaoEscala = coordenacaoEscala;
	}

	public AnoMes getAnoMes() {
		return anoMes;
	}

	public void setAnoMes(AnoMes anoMes) {
		this.anoMes = anoMes;
	}

	public CoordenacaoEscala getCoordenacaoEscala() {
		return coordenacaoEscala;
	}

	public void setCoordenacaoEscala(CoordenacaoEscala coordenacaoEscala) {
		this.coordenacaoEscala = coordenacaoEscala;
	}
	
	
	
}
