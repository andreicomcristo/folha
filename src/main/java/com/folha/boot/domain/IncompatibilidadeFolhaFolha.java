package com.folha.boot.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "incompatibilidade_folha_folha")
public class IncompatibilidadeFolhaFolha extends AbstractEntity<Long> {

	@JoinColumn(name = "id_folha_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeFolha idFolhaFk;
    @JoinColumn(name = "id_folha_incompativel_fk", referencedColumnName = "id")
    @ManyToOne
    private TiposDeFolha idFolhaIncompativelFk;

    public IncompatibilidadeFolhaFolha() {
    }

	public TiposDeFolha getIdFolhaFk() {
		return idFolhaFk;
	}

	public void setIdFolhaFk(TiposDeFolha idFolhaFk) {
		this.idFolhaFk = idFolhaFk;
	}

	public TiposDeFolha getIdFolhaIncompativelFk() {
		return idFolhaIncompativelFk;
	}

	public void setIdFolhaIncompativelFk(TiposDeFolha idFolhaIncompativelFk) {
		this.idFolhaIncompativelFk = idFolhaIncompativelFk;
	}
    
    
    
      
}
