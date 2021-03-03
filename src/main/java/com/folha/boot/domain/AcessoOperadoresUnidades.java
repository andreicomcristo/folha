package com.folha.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "acesso_operadores_unidades")

public class AcessoOperadoresUnidades extends AbstractEntity<Long> {

	@JoinColumn(name = "id_operador_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaOperadores idOperadorFk;
    
	@JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)   
    private Unidades idUnidadeFk;
	
	public PessoaOperadores getIdOperadorFk() {
		return idOperadorFk;
	}
	public void setIdOperadorFk(PessoaOperadores idOperadorFk) {
		this.idOperadorFk = idOperadorFk;
	}
	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}
	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}    	
}