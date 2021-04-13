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
	
	@JoinColumn(name = "id_folha_efetiva_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idFolhaEfetivaSimNaoFk;
	
	@OneToMany(mappedBy = "idTipoFolhaFk")
    private List<EscalaAlteracoes> escalaAlteracoesList;
	
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
	
	
	
}
