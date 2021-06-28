package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.domain.AbstractEntity;
import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipo_de_folha_turno")
public class TipoDeFolhaTurno extends AbstractEntity<Long> { 

        
	@JoinColumn(name = "id_tipo_de_folha_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeFolha idTipoDeFolhaFk;
    @JoinColumn(name = "id_turno_fk", referencedColumnName = "id")
    @ManyToOne
    private Turnos idTurnoFk;

    public TipoDeFolhaTurno() {
    }

	public TiposDeFolha getIdTipoDeFolhaFk() {
		return idTipoDeFolhaFk;
	}

	public void setIdTipoDeFolhaFk(TiposDeFolha idTipoDeFolhaFk) {
		this.idTipoDeFolhaFk = idTipoDeFolhaFk;
	}

	public Turnos getIdTurnoFk() {
		return idTurnoFk;
	}

	public void setIdTurnoFk(Turnos idTurnoFk) {
		this.idTurnoFk = idTurnoFk;
	}
    
    
}
