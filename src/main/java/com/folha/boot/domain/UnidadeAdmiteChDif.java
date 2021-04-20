package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "unidade_admite_ch_dif")
public class UnidadeAdmiteChDif extends AbstractEntity<Long> {

	
    @JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;
	
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    
	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}
	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}
	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}
	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}
    
    
    
    
	
	
}
