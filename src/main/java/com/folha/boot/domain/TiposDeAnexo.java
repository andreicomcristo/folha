package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the tipos_de_anexo database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tipos_de_anexo")
public class TiposDeAnexo extends AbstractEntity<Long> { 	

	@Basic(optional = false)
    @Column(name = "tipo_de_anexo")
    private String tipoDeAnexo;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDeAnexoFk")
    private List<FuncionariosAnexos> funcionariosAnexosList;
	
    public String getTipoDeAnexo() {
		return tipoDeAnexo;
	}
	public void setTipoDeAnexo(String tipoDeAnexo) {
		this.tipoDeAnexo = tipoDeAnexo;
	}
	public List<FuncionariosAnexos> getFuncionariosAnexosList() {
		return funcionariosAnexosList;
	}
	public void setFuncionariosAnexosList(List<FuncionariosAnexos> funcionariosAnexosList) {
		this.funcionariosAnexosList = funcionariosAnexosList;
	}

    
}