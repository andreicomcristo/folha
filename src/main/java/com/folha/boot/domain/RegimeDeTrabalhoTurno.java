package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.domain.AbstractEntity;
import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "regime_de_trabalho_turno")
public class RegimeDeTrabalhoTurno extends AbstractEntity<Long> { 

    @JoinColumn(name = "id_regime_de_trabalho_fk", referencedColumnName = "id")
    @ManyToOne
    private RegimesDeTrabalho idRegimeDeTrabalhoFk;
    @JoinColumn(name = "id_turno_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos idTurnoFk;

    public RegimeDeTrabalhoTurno() {
    }

	public RegimesDeTrabalho getIdRegimeDeTrabalhoFk() {
		return idRegimeDeTrabalhoFk;
	}

	public void setIdRegimeDeTrabalhoFk(RegimesDeTrabalho idRegimeDeTrabalhoFk) {
		this.idRegimeDeTrabalhoFk = idRegimeDeTrabalhoFk;
	}

	public Turnos getIdTurnoFk() {
		return idTurnoFk;
	}

	public void setIdTurnoFk(Turnos idTurnoFk) {
		this.idTurnoFk = idTurnoFk;
	}
    
    
    
    
    
}
