package com.folha.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "faixas_valores_parametros_calculo_folhas_extras")
public class FaixasValoresParametrosCalculoFolhasExtras extends AbstractEntity<Long> {

	@Column(name = "nomeTipoFolha")
	private String nomeTipoFolha;
	@Column(name = "cnes_unidade")
	private String cnesUnidade;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "valor_hora_dia")
	private Double valorHoraDia;
	@Column(name = "valor_hora_noite")
	private Double valorHoraNoite;
	@Column(name = "valor_hora_semana")
	private Double valorHoraSemana;
	@Column(name = "valor_hora_fim_de_semana")
	private Double valorHoraFimDeSemana;
	@Column(name = "nome_regime")
	private String nomeRegime;
	@Column(name = "nome_cod_diferenciado")
	private String nomeCodDiferenciado;
	@Column(name = "valor_liquido_por_hora")
	private Double valorLiquidoPorHora;
	@Column(name = "valor_bruto_por_hora")
	private Double valorBrutoPorHora;
	@Column(name = "nome_nivel")
	private String nomeNivel;
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
	@ManyToOne
	private Unidades idUnidadeFk;
	public String getNomeTipoFolha() {
		return nomeTipoFolha;
	}
	public void setNomeTipoFolha(String nomeTipoFolha) {
		this.nomeTipoFolha = nomeTipoFolha;
	}
	public String getCnesUnidade() {
		return cnesUnidade;
	}
	public void setCnesUnidade(String cnesUnidade) {
		this.cnesUnidade = cnesUnidade;
	}
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
	public String getNomeRegime() {
		return nomeRegime;
	}
	public void setNomeRegime(String nomeRegime) {
		this.nomeRegime = nomeRegime;
	}
	public String getNomeCodDiferenciado() {
		return nomeCodDiferenciado;
	}
	public void setNomeCodDiferenciado(String nomeCodDiferenciado) {
		this.nomeCodDiferenciado = nomeCodDiferenciado;
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
	public String getNomeNivel() {
		return nomeNivel;
	}
	public void setNomeNivel(String nomeNivel) {
		this.nomeNivel = nomeNivel;
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
	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}
	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}
	
}
