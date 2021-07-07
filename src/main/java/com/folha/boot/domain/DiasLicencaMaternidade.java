package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "dias_licenca_maternidade")
public class DiasLicencaMaternidade extends AbstractEntity<Long> {

	
	@Column(name = "dias")
    private Integer dias;

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

		
	
	    
    
}
