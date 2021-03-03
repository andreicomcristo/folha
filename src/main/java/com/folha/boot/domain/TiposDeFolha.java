package com.folha.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipos_de_folha")
public class TiposDeFolha extends AbstractEntity<Long> {

	@Column(name = "nome_tipo_folha")
    private String nomeTipoFolha;
    @Column(name = "descricao_tipo_folha")
    private String descricaoTipoFolha;
    @Basic(optional = false)
    @Column(name = "nome_tipo_filha")
    private String nomeTipoFilha;
	
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
	public String getNomeTipoFilha() {
		return nomeTipoFilha;
	}
	public void setNomeTipoFilha(String nomeTipoFilha) {
		this.nomeTipoFilha = nomeTipoFilha;
	}
    
}
