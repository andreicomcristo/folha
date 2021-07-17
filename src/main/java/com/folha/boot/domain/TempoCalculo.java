package com.folha.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "tempo_calculo")
public class TempoCalculo extends AbstractEntity<Long> {

	
	@Column(name = "segundos")
    private Double segundos;

	public Double getSegundos() {
		return segundos;
	}

	public void setSegundos(Double segundos) {
		this.segundos = segundos;
	}
	
	
	    
    
}
