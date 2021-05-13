package com.folha.boot.domain.models.calculos;


import com.folha.boot.domain.Escala;

public class EscalasNoMes {
	
	Escala escala;
	ReferenciasDeEscala referencias;
	
	
	
	public EscalasNoMes() {
		super();
	}

	public Escala getEscala() {
		return escala;
	}



	public void setEscala(Escala escala) {
		this.escala = escala;
	}



	public ReferenciasDeEscala getReferencias() {
		return referencias;
	}



	public void setReferencias(ReferenciasDeEscala referencias) {
		this.referencias = referencias;
	}

	
	
}
