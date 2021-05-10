package com.folha.boot.domain;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "faixas_valores_incentivo_de_risco")
public class FaixasValoresIncentivoDeRisco extends AbstractEntity<Long>{
    
	@Column(name = "valor")
    private Double valor;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;
    @JoinColumn(name = "id_fonte_fk", referencedColumnName = "id")
    @ManyToOne
    private Fonte idFonteFk;
    @JoinColumn(name = "id_tipo_bruto_liquido_fk", referencedColumnName = "id")
    @ManyToOne
    private TipoBrutoLiquido idTipoBrutoLiquidoFk;

    public FaixasValoresIncentivoDeRisco() {
    }

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

	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}

	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
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
