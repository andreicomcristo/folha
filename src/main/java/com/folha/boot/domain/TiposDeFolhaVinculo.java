package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipos_de_folha_Vinculo")
public class TiposDeFolhaVinculo extends AbstractEntity<Long> {
	
	@JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_tipo_de_folha_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeFolha idTipoDeFolhaFk;
    @JoinColumn(name = "id_vinculo_fk", referencedColumnName = "id")
    @ManyToOne
    private Vinculos idVinculoFk;

    public TiposDeFolhaVinculo() {
    }

	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}

	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}

	public TiposDeFolha getIdTipoDeFolhaFk() {
		return idTipoDeFolhaFk;
	}

	public void setIdTipoDeFolhaFk(TiposDeFolha idTipoDeFolhaFk) {
		this.idTipoDeFolhaFk = idTipoDeFolhaFk;
	}

	public Vinculos getIdVinculoFk() {
		return idVinculoFk;
	}

	public void setIdVinculoFk(Vinculos idVinculoFk) {
		this.idVinculoFk = idVinculoFk;
	}
    
    
    
    
}
