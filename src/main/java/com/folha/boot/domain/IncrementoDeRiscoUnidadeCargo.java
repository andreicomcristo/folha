package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "incremento_de_risco_unidade_cargo")
public class IncrementoDeRiscoUnidadeCargo extends AbstractEntity<Long> {

	@JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_cargo_fk", referencedColumnName = "id")
    @ManyToOne
    private Cargos idCargoFk;
    @JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;

    public IncrementoDeRiscoUnidadeCargo() {
    }

	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}

	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}

	public Cargos getIdCargoFk() {
		return idCargoFk;
	}

	public void setIdCargoFk(Cargos idCargoFk) {
		this.idCargoFk = idCargoFk;
	}

	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}

	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}
    
	
}
