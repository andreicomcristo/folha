package com.folha.boot.domain;

import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "faixas_valores_gpf_medica")
public class FaixasValoresGpfMedica extends AbstractEntity<Long> {

	@Column(name = "valor_semana")
    private Double valorSemana;
    @Column(name = "valor_fim_semana")
    private Double valorFimSemana;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_carga_horaria_semanal_fk", referencedColumnName = "id")
    @ManyToOne
    private CargaHorariaSemanal idCargaHorariaSemanalFk;
    @JoinColumn(name = "id_classe_carreira_fk", referencedColumnName = "id")
    @ManyToOne
    private ClassesCarreira idClasseCarreiraFk;
    @JoinColumn(name = "id_fonte_fk", referencedColumnName = "id")
    @ManyToOne
    private Fonte idFonteFk;
    @JoinColumn(name = "id_nivel_cargo_fk", referencedColumnName = "id")
    @ManyToOne
    private NiveisCargo idNivelCargoFk;
    @JoinColumn(name = "id_tipo_bruto_liquido_fk", referencedColumnName = "id")
    @ManyToOne
    private TipoBrutoLiquido idTipoBrutoLiquidoFk;
    @JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;

    public FaixasValoresGpfMedica() {
    }

	public Double getValorSemana() {
		return valorSemana;
	}

	public void setValorSemana(Double valorSemana) {
		this.valorSemana = valorSemana;
	}

	public Double getValorFimSemana() {
		return valorFimSemana;
	}

	public void setValorFimSemana(Double valorFimSemana) {
		this.valorFimSemana = valorFimSemana;
	}

	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}

	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}

	public CargaHorariaSemanal getIdCargaHorariaSemanalFk() {
		return idCargaHorariaSemanalFk;
	}

	public void setIdCargaHorariaSemanalFk(CargaHorariaSemanal idCargaHorariaSemanalFk) {
		this.idCargaHorariaSemanalFk = idCargaHorariaSemanalFk;
	}

	public ClassesCarreira getIdClasseCarreiraFk() {
		return idClasseCarreiraFk;
	}

	public void setIdClasseCarreiraFk(ClassesCarreira idClasseCarreiraFk) {
		this.idClasseCarreiraFk = idClasseCarreiraFk;
	}

	public Fonte getIdFonteFk() {
		return idFonteFk;
	}

	public void setIdFonteFk(Fonte idFonteFk) {
		this.idFonteFk = idFonteFk;
	}

	public NiveisCargo getIdNivelCargoFk() {
		return idNivelCargoFk;
	}

	public void setIdNivelCargoFk(NiveisCargo idNivelCargoFk) {
		this.idNivelCargoFk = idNivelCargoFk;
	}

	public TipoBrutoLiquido getIdTipoBrutoLiquidoFk() {
		return idTipoBrutoLiquidoFk;
	}

	public void setIdTipoBrutoLiquidoFk(TipoBrutoLiquido idTipoBrutoLiquidoFk) {
		this.idTipoBrutoLiquidoFk = idTipoBrutoLiquidoFk;
	}

	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}

	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}

    
    
    
    
	
}
