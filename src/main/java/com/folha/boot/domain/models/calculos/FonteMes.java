package com.folha.boot.domain.models.calculos;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Fonte;
import com.folha.boot.domain.Unidades;

public class FonteMes {
	
	Fonte fonte;
	AnoMes anoMes;
	
	public FonteMes() {
	}

	public Fonte getFonte() {
		return fonte;
	}

	public void setFonte(Fonte fonte) {
		this.fonte = fonte;
	}

	public AnoMes getAnoMes() {
		return anoMes;
	}

	public void setAnoMes(AnoMes anoMes) {
		this.anoMes = anoMes;
	}

		
	
}
