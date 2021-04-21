package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipos_de_folha_nivel_cargo")
public class TiposDeFolhaNivelCargo extends AbstractEntity<Long> {
	
	@JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_nivel_cargo_fk", referencedColumnName = "id")
    @ManyToOne
    private NiveisCargo idNivelCargoFk;
    @JoinColumn(name = "id_tipo_de_folha_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeFolha idTipoDeFolhaFk;

    public TiposDeFolhaNivelCargo() {
    }

	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}

	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}

	public NiveisCargo getIdNivelCargoFk() {
		return idNivelCargoFk;
	}

	public void setIdNivelCargoFk(NiveisCargo idNivelCargoFk) {
		this.idNivelCargoFk = idNivelCargoFk;
	}

	public TiposDeFolha getIdTipoDeFolhaFk() {
		return idTipoDeFolhaFk;
	}

	public void setIdTipoDeFolhaFk(TiposDeFolha idTipoDeFolhaFk) {
		this.idTipoDeFolhaFk = idTipoDeFolhaFk;
	}

    
    
}
