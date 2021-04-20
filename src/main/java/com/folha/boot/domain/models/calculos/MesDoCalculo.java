package com.folha.boot.domain.models.calculos;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CoordenacaoEscala;

public class MesDoCalculo {

	AnoMes anoMes;
	
	public MesDoCalculo() {
		super();
	}
	
	public MesDoCalculo(AnoMes anoMes, CoordenacaoEscala coordenacaoEscala) {
		super();
		this.anoMes = anoMes;
	}

	public AnoMes getAnoMes() {
		return anoMes;
	}

	public void setAnoMes(AnoMes anoMes) {
		this.anoMes = anoMes;
	}
	
	
}
