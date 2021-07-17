package com.folha.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name = "faixas_imposto_de_renda")
public class FaixasImpostoDeRenda extends AbstractEntity<Long>{
    
    @Column(name = "base_calculo_valor_inicial")
    private Double baseCalculoValorInicial;
    
    @Column(name = "base_calculo_valor_final")
    private Double baseCalculoValorFinal;
    
    @Column(name = "aliquota")
    private Double aliquota;
    
    @Column(name = "parcela_a_subtrair")
    private Double parcelaASubtrair;
    
    @Column(name = "parcela_a_devolver")
    private Double parcelaADevolver;
    
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    
    @JoinColumn(name = "id_faixas_imposto_de_renda_nome_fk", referencedColumnName = "id")
    @ManyToOne 
    private FaixasImpostoDeRendaNome idFaixasImpostoDeRendaNomeFk;
 
    public Double getBaseCalculoValorInicial() {
		return baseCalculoValorInicial;
	}
	public void setBaseCalculoValorInicial(Double baseCalculoValorInicial) {
		this.baseCalculoValorInicial = baseCalculoValorInicial;
	}
	public Double getBaseCalculoValorFinal() {
		return baseCalculoValorFinal;
	}
	public void setBaseCalculoValorFinal(Double baseCalculoValorFinal) {
		this.baseCalculoValorFinal = baseCalculoValorFinal;
	}
	public Double getAliquota() {
		return aliquota;
	}
	public void setAliquota(Double aliquota) {
		this.aliquota = aliquota;
	}
	public Double getParcelaASubtrair() {
		return parcelaASubtrair;
	}
	public void setParcelaASubtrair(Double parcelaASubtrair) {
		this.parcelaASubtrair = parcelaASubtrair;
	}
	public Double getParcelaADevolver() {
		return parcelaADevolver;
	}
	public void setParcelaADevolver(Double parcelaADevolver) {
		this.parcelaADevolver = parcelaADevolver;
	}
	
	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}
	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}
	public FaixasImpostoDeRendaNome getIdFaixasImpostoDeRendaNomeFk() {
		return idFaixasImpostoDeRendaNomeFk;
	}
	public void setIdFaixasImpostoDeRendaNomeFk(FaixasImpostoDeRendaNome idFaixasImpostoDeRendaNomeFk) {
		this.idFaixasImpostoDeRendaNomeFk = idFaixasImpostoDeRendaNomeFk;
	}
    
}
