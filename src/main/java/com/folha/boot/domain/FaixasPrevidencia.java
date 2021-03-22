package com.folha.boot.domain;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "faixas_previdencia")
public class FaixasPrevidencia extends AbstractEntity<Long>{

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
    
    @Column(name = "ano_mes")
    private String anoMes;
    
    @JoinColumn(name = "id_faixas_previdencia_nome_fk", referencedColumnName = "id")
    @ManyToOne
    private FaixasPrevidenciaNome idFaixasPrevidenciaNomeFk;

	public FaixasPrevidenciaNome getIdFaixasPrevidenciaNomeFk() {
		return idFaixasPrevidenciaNomeFk;
	}

	public void setIdFaixasPrevidenciaNomeFk(FaixasPrevidenciaNome idFaixasPrevidenciaNomeFk) {
		this.idFaixasPrevidenciaNomeFk = idFaixasPrevidenciaNomeFk;
	}

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

	public String getAnoMes() {
		return anoMes;
	}

	public void setAnoMes(String anoMes) {
		this.anoMes = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(anoMes);
	}
    
    
}
