package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.domain.AbstractEntity;
import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "incompatibilidade_codigo_diferenciado_codigo_diferenciado")
public class IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado extends AbstractEntity<Long> { 

    @JoinColumn(name = "id_codigo_diferenciado_incompativel_fk", referencedColumnName = "id")
    @ManyToOne
    private CodigoDiferenciado idCodigoDiferenciadoIncompativelFk;
    @JoinColumn(name = "id_codigo_diferenciado_fk", referencedColumnName = "id")
    @ManyToOne
    private CodigoDiferenciado idCodigoDiferenciadoFk;

    public IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado() {
    }

	

	public CodigoDiferenciado getIdCodigoDiferenciadoIncompativelFk() {
		return idCodigoDiferenciadoIncompativelFk;
	}



	public void setIdCodigoDiferenciadoIncompativelFk(CodigoDiferenciado idCodigoDiferenciadoIncompativelFk) {
		this.idCodigoDiferenciadoIncompativelFk = idCodigoDiferenciadoIncompativelFk;
	}



	public CodigoDiferenciado getIdCodigoDiferenciadoFk() {
		return idCodigoDiferenciadoFk;
	}

	public void setIdCodigoDiferenciadoFk(CodigoDiferenciado idCodigoDiferenciadoFk) {
		this.idCodigoDiferenciadoFk = idCodigoDiferenciadoFk;
	}

	
    
    
    
    
}
