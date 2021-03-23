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
	@OneToMany(mappedBy = "idTipoFolhaFk")
	private List<Escala> escalaList;
	@OneToMany(mappedBy = "idTipoDeFolhaFk")
	private List<FaixasValoresParametrosCalculoFolhasExtras> faixasValoresParametrosCalculoFolhasExtrasList;
	
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
	
}
