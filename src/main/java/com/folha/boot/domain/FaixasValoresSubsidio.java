package com.folha.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "faixas_valores_subsidio")
public class FaixasValoresSubsidio extends AbstractEntity<Long> {

	@Column(name = "valor")
    private Double valor;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_carga_horaria_semanal_fk", referencedColumnName = "id")
    @ManyToOne
    private CargaHorariaSemanal idCargaHorariaSemanalFk;
    @JoinColumn(name = "id_carreira_fk", referencedColumnName = "id")
    @ManyToOne
    private Carreiras idCarreiraFk;
    @JoinColumn(name = "id_classe_carreira_fk", referencedColumnName = "id")
    @ManyToOne
    private ClassesCarreira idClasseCarreiraFk;
    @JoinColumn(name = "id_nivel_carreira_fk", referencedColumnName = "id")
    @ManyToOne
    private NiveisCarreira idNivelCarreiraFk;
    @JoinColumn(name = "id_unidade_regime_fk", referencedColumnName = "id")
    @ManyToOne
    private UnidadesRegime idUnidadeRegimeFk;
    @JoinColumn(name = "id_fonte_fk", referencedColumnName = "id")
    @ManyToOne
    private Fonte idFonteFk;
    @JoinColumn(name = "id_tipo_bruto_liquido_fk", referencedColumnName = "id")
    @ManyToOne
    private TipoBrutoLiquido idTipoBrutoLiquidoFk;
    
    public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
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
	public Carreiras getIdCarreiraFk() {
		return idCarreiraFk;
	}
	public void setIdCarreiraFk(Carreiras idCarreiraFk) {
		this.idCarreiraFk = idCarreiraFk;
	}
	public ClassesCarreira getIdClasseCarreiraFk() {
		return idClasseCarreiraFk;
	}
	public void setIdClasseCarreiraFk(ClassesCarreira idClasseCarreiraFk) {
		this.idClasseCarreiraFk = idClasseCarreiraFk;
	}
	public NiveisCarreira getIdNivelCarreiraFk() {
		return idNivelCarreiraFk;
	}
	public void setIdNivelCarreiraFk(NiveisCarreira idNivelCarreiraFk) {
		this.idNivelCarreiraFk = idNivelCarreiraFk;
	}
	public UnidadesRegime getIdUnidadeRegimeFk() {
		return idUnidadeRegimeFk;
	}
	public void setIdUnidadeRegimeFk(UnidadesRegime idUnidadeRegimeFk) {
		this.idUnidadeRegimeFk = idUnidadeRegimeFk;
	}
	public Fonte getIdFonteFk() {
		return idFonteFk;
	}
	public void setIdFonteFk(Fonte idFonteFk) {
		this.idFonteFk = idFonteFk;
	}
	public TipoBrutoLiquido getIdTipoBrutoLiquidoFk() {
		return idTipoBrutoLiquidoFk;
	}
	public void setIdTipoBrutoLiquidoFk(TipoBrutoLiquido idTipoBrutoLiquidoFk) {
		this.idTipoBrutoLiquidoFk = idTipoBrutoLiquidoFk;
	}
    
    
    
	
}
