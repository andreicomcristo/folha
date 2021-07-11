package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.domain.AbstractEntity;
import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "unidade_turno")
public class UnidadeTurno extends AbstractEntity<Long> { 

	@JoinColumn(name = "id_turno_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos idTurnoFk;
    @JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;

    public UnidadeTurno() {
    }

	public Turnos getIdTurnoFk() {
		return idTurnoFk;
	}

	public void setIdTurnoFk(Turnos idTurnoFk) {
		this.idTurnoFk = idTurnoFk;
	}

	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}

	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}
    
    
    
}
