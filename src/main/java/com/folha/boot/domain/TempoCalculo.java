package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

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
