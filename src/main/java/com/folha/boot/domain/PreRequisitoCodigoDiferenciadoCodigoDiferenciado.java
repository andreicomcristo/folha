package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.domain.AbstractEntity;
import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "pre_requisito_codigo_diferenciado_codigo_diferenciado")
public class PreRequisitoCodigoDiferenciadoCodigoDiferenciado extends AbstractEntity<Long> { 

    @JoinColumn(name = "id_codigo_diferenciado_compativel_fk", referencedColumnName = "id")
    @ManyToOne
    private CodigoDiferenciado idCodigoDiferenciadoCompativelFk;
    @JoinColumn(name = "id_codigo_diferenciado_fk", referencedColumnName = "id")
    @ManyToOne
    private CodigoDiferenciado idCodigoDiferenciadoFk;

    public PreRequisitoCodigoDiferenciadoCodigoDiferenciado() {
    }

	public CodigoDiferenciado getIdCodigoDiferenciadoCompativelFk() {
		return idCodigoDiferenciadoCompativelFk;
	}

	public void setIdCodigoDiferenciadoCompativelFk(CodigoDiferenciado idCodigoDiferenciadoCompativelFk) {
		this.idCodigoDiferenciadoCompativelFk = idCodigoDiferenciadoCompativelFk;
	}

	public CodigoDiferenciado getIdCodigoDiferenciadoFk() {
		return idCodigoDiferenciadoFk;
	}

	public void setIdCodigoDiferenciadoFk(CodigoDiferenciado idCodigoDiferenciadoFk) {
		this.idCodigoDiferenciadoFk = idCodigoDiferenciadoFk;
	}

	
    
    
    
    
}
