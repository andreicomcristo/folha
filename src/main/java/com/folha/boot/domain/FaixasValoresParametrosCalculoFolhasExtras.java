package com.folha.boot.domain;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "faixas_valores_parametros_calculo_folhas_extras")
public class FaixasValoresParametrosCalculoFolhasExtras extends AbstractEntity<Long> {

	@Column(name = "valor_hora_dia")
    private Double valorHoraDia;
    @Column(name = "valor_hora_noite")
    private Double valorHoraNoite;
    
    @Column(name = "valor_hora_a")
    private Double valorHoraA;
    @Column(name = "valor_hora_b")
    private Double valorHoraB;
    @Column(name = "valor_hora_c")
    private Double valorHoraC;
    
    
    @Column(name = "valor_hora_semana")
    private Double valorHoraSemana;
    @Column(name = "valor_hora_fim_de_semana")
    private Double valorHoraFimDeSemana;
    @Column(name = "valor_liquido_por_hora")
    private Double valorLiquidoPorHora;
    @Column(name = "valor_bruto_por_hora")
    private Double valorBrutoPorHora;
    @Column(name = "valor_bruto_fixo_total")
    private Double valorBrutoFixoTotal;
    @JoinColumn(name = "id_ano_mes_fk", referencedColumnName = "id")
    @ManyToOne
    private AnoMes idAnoMesFk;
    @JoinColumn(name = "id_cod_diferenciado_fk", referencedColumnName = "id")
    @ManyToOne
    private CodigoDiferenciado idCodDiferenciadoFk;
    @JoinColumn(name = "id_nivel_fk", referencedColumnName = "id")
    @ManyToOne
    private NiveisCargo idNivelFk;
    @JoinColumn(name = "id_regime_de_trabalho_fk", referencedColumnName = "id")
    @ManyToOne
    private RegimesDeTrabalho idRegimeDeTrabalhoFk;
    @JoinColumn(name = "id_tipo_de_folha_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeFolha idTipoDeFolhaFk;
    @JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    
	public Double getValorHoraDia() {
		return valorHoraDia;
	}
	public void setValorHoraDia(Double valorHoraDia) {
		this.valorHoraDia = valorHoraDia;
	}
	public Double getValorHoraNoite() {
		return valorHoraNoite;
	}
	public void setValorHoraNoite(Double valorHoraNoite) {
		this.valorHoraNoite = valorHoraNoite;
	}
	public Double getValorHoraSemana() {
		return valorHoraSemana;
	}
	public void setValorHoraSemana(Double valorHoraSemana) {
		this.valorHoraSemana = valorHoraSemana;
	}
	public Double getValorHoraFimDeSemana() {
		return valorHoraFimDeSemana;
	}
	public void setValorHoraFimDeSemana(Double valorHoraFimDeSemana) {
		this.valorHoraFimDeSemana = valorHoraFimDeSemana;
	}
	public Double getValorLiquidoPorHora() {
		return valorLiquidoPorHora;
	}
	public void setValorLiquidoPorHora(Double valorLiquidoPorHora) {
		this.valorLiquidoPorHora = valorLiquidoPorHora;
	}
	public Double getValorBrutoPorHora() {
		return valorBrutoPorHora;
	}
	public void setValorBrutoPorHora(Double valorBrutoPorHora) {
		this.valorBrutoPorHora = valorBrutoPorHora;
	}
	public Double getValorBrutoFixoTotal() {
		return valorBrutoFixoTotal;
	}
	public void setValorBrutoFixoTotal(Double valorBrutoFixoTotal) {
		this.valorBrutoFixoTotal = valorBrutoFixoTotal;
	}
	public AnoMes getIdAnoMesFk() {
		return idAnoMesFk;
	}
	public void setIdAnoMesFk(AnoMes idAnoMesFk) {
		this.idAnoMesFk = idAnoMesFk;
	}
	public CodigoDiferenciado getIdCodDiferenciadoFk() {
		return idCodDiferenciadoFk;
	}
	public void setIdCodDiferenciadoFk(CodigoDiferenciado idCodDiferenciadoFk) {
		this.idCodDiferenciadoFk = idCodDiferenciadoFk;
	}
	public NiveisCargo getIdNivelFk() {
		return idNivelFk;
	}
	public void setIdNivelFk(NiveisCargo idNivelFk) {
		this.idNivelFk = idNivelFk;
	}
	public RegimesDeTrabalho getIdRegimeDeTrabalhoFk() {
		return idRegimeDeTrabalhoFk;
	}
	public void setIdRegimeDeTrabalhoFk(RegimesDeTrabalho idRegimeDeTrabalhoFk) {
		this.idRegimeDeTrabalhoFk = idRegimeDeTrabalhoFk;
	}
	public TiposDeFolha getIdTipoDeFolhaFk() {
		return idTipoDeFolhaFk;
	}
	public void setIdTipoDeFolhaFk(TiposDeFolha idTipoDeFolhaFk) {
		this.idTipoDeFolhaFk = idTipoDeFolhaFk;
	}
	public Double getValorHoraA() {
		return valorHoraA;
	}
	public void setValorHoraA(Double valorHoraA) {
		this.valorHoraA = valorHoraA;
	}
	public Double getValorHoraB() {
		return valorHoraB;
	}
	public void setValorHoraB(Double valorHoraB) {
		this.valorHoraB = valorHoraB;
	}
	public Double getValorHoraC() {
		return valorHoraC;
	}
	public void setValorHoraC(Double valorHoraC) {
		this.valorHoraC = valorHoraC;
	}
	
	
	
}
