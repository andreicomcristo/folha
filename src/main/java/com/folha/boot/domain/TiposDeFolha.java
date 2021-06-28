package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipos_de_folha")
public class TiposDeFolha extends AbstractEntity<Long> {

	@Basic(optional = false)
	@Column(name = "nome_tipo_folha")
	private String nomeTipoFolha;
	@Column(name = "descricao_tipo_folha")
	private String descricaoTipoFolha;
	@JoinColumn(name = "id_tipo_remuneracao_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeRemuneracao idTipoRemuneracaoFk;
	@OneToMany(mappedBy = "idTipoFolhaFk")
	private List<Escala> escalaList;
	@OneToMany(mappedBy = "idTipoFolhaFk")
    private List<EscalaPosTransparencia> escalaPosTransparenciaList;
	@OneToMany(mappedBy = "idTipoDeFolhaFk")
	private List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList;
	@OneToMany(mappedBy = "idFolhaFk")
    private List<RubricaVencimento> rubricaVencimentoList;
	@OneToMany(mappedBy = "idTipoDeFolhaFk")
    private List<TiposDeFolhaVinculo> tiposDeFolhaVinculoList;
	@OneToMany(mappedBy = "idTipoDeFolhaFk")
    private List<FaixasValoresParametrosCalculoFolhasExtrasIndividual> faixasValoresParametrosCalculoFolhasExtrasIndividualList;
	
	@JoinColumn(name = "id_folha_efetiva_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idFolhaEfetivaSimNaoFk;
	
	@JoinColumn(name = "id_admite_complemento_de_plantao_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idAdmiteComplementoDePlantaoSimNaoFk;
    @JoinColumn(name = "id_admite_incremento_de_risco_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idAdmiteIncrementoDeRiscoSimNaoFk;
    
	
    
    @OneToMany(mappedBy = "idTipoDeFolhaFk")
    private List<TipoDeFolhaTurno> tipoDeFolhaTurnoList;
    
    
	@OneToMany(mappedBy = "idTipoFolhaFk")
    private List<EscalaAlteracoes> escalaAlteracoesList;
	
	@OneToMany(mappedBy = "idTipoDeFolhaFk")
    private List<TiposDeFolhaNivelCargo> tiposDeFolhaNivelCargoList;
	
	public String getNomeTipoFolha() {
		return nomeTipoFolha;
	}
	public void setNomeTipoFolha(String nomeTipoFolha) {
		this.nomeTipoFolha = nomeTipoFolha;
	}
	public String getDescricaoTipoFolha() {
		return descricaoTipoFolha;
	}
	public void setDescricaoTipoFolha(String descricaoTipoFolha) {
		this.descricaoTipoFolha = descricaoTipoFolha;
	}
	public List<Escala> getEscalaList() {
		return escalaList;
	}
	public void setEscalaList(List<Escala> escalaList) {
		this.escalaList = escalaList;
	}
	public List<FaixasValoresParametrosCalculoFolhasExtras> getFaixasValoresParametrosCalculoFolhasExtrasList() {
		return faixasValoresParametrosCalculoFolhasExtrasList;
	}
	public void setFaixasValoresParametrosCalculoFolhasExtrasList(
			List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList) {
		this.faixasValoresParametrosCalculoFolhasExtrasList = faixasValoresParametrosCalculoFolhasExtrasList;
	}
	public List<EscalaPosTransparencia> getEscalaPosTransparenciaList() {
		return escalaPosTransparenciaList;
	}
	public void setEscalaPosTransparenciaList(List<EscalaPosTransparencia> escalaPosTransparenciaList) {
		this.escalaPosTransparenciaList = escalaPosTransparenciaList;
	}
	public List<EscalaAlteracoes> getEscalaAlteracoesList() {
		return escalaAlteracoesList;
	}
	public void setEscalaAlteracoesList(List<EscalaAlteracoes> escalaAlteracoesList) {
		this.escalaAlteracoesList = escalaAlteracoesList;
	}
	public TiposDeRemuneracao getIdTipoRemuneracaoFk() {
		return idTipoRemuneracaoFk;
	}
	public void setIdTipoRemuneracaoFk(TiposDeRemuneracao idTipoRemuneracaoFk) {
		this.idTipoRemuneracaoFk = idTipoRemuneracaoFk;
	}
	public SimNao getIdFolhaEfetivaSimNaoFk() {
		return idFolhaEfetivaSimNaoFk;
	}
	public void setIdFolhaEfetivaSimNaoFk(SimNao idFolhaEfetivaSimNaoFk) {
		this.idFolhaEfetivaSimNaoFk = idFolhaEfetivaSimNaoFk;
	}
	public List<TiposDeFolhaNivelCargo> getTiposDeFolhaNivelCargoList() {
		return tiposDeFolhaNivelCargoList;
	}
	public void setTiposDeFolhaNivelCargoList(List<TiposDeFolhaNivelCargo> tiposDeFolhaNivelCargoList) {
		this.tiposDeFolhaNivelCargoList = tiposDeFolhaNivelCargoList;
	}
	public List<RubricaVencimento> getRubricaVencimentoList() {
		return rubricaVencimentoList;
	}
	public void setRubricaVencimentoList(List<RubricaVencimento> rubricaVencimentoList) {
		this.rubricaVencimentoList = rubricaVencimentoList;
	}
	public List<TiposDeFolhaVinculo> getTiposDeFolhaVinculoList() {
		return tiposDeFolhaVinculoList;
	}
	public void setTiposDeFolhaVinculoList(List<TiposDeFolhaVinculo> tiposDeFolhaVinculoList) {
		this.tiposDeFolhaVinculoList = tiposDeFolhaVinculoList;
	}
	public SimNao getIdAdmiteComplementoDePlantaoSimNaoFk() {
		return idAdmiteComplementoDePlantaoSimNaoFk;
	}
	public void setIdAdmiteComplementoDePlantaoSimNaoFk(SimNao idAdmiteComplementoDePlantaoSimNaoFk) {
		this.idAdmiteComplementoDePlantaoSimNaoFk = idAdmiteComplementoDePlantaoSimNaoFk;
	}
	public SimNao getIdAdmiteIncrementoDeRiscoSimNaoFk() {
		return idAdmiteIncrementoDeRiscoSimNaoFk;
	}
	public void setIdAdmiteIncrementoDeRiscoSimNaoFk(SimNao idAdmiteIncrementoDeRiscoSimNaoFk) {
		this.idAdmiteIncrementoDeRiscoSimNaoFk = idAdmiteIncrementoDeRiscoSimNaoFk;
	}
	public List<FaixasValoresParametrosCalculoFolhasExtrasIndividual> getFaixasValoresParametrosCalculoFolhasExtrasIndividualList() {
		return faixasValoresParametrosCalculoFolhasExtrasIndividualList;
	}
	public void setFaixasValoresParametrosCalculoFolhasExtrasIndividualList(
			List<FaixasValoresParametrosCalculoFolhasExtrasIndividual> faixasValoresParametrosCalculoFolhasExtrasIndividualList) {
		this.faixasValoresParametrosCalculoFolhasExtrasIndividualList = faixasValoresParametrosCalculoFolhasExtrasIndividualList;
	}
	public List<TipoDeFolhaTurno> getTipoDeFolhaTurnoList() {
		return tipoDeFolhaTurnoList;
	}
	public void setTipoDeFolhaTurnoList(List<TipoDeFolhaTurno> tipoDeFolhaTurnoList) {
		this.tipoDeFolhaTurnoList = tipoDeFolhaTurnoList;
	}
	
	
	
}
