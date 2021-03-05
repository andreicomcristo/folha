package com.folha.boot.domain;

import javax.persistence.*;

/**
 * The persistent class for the tipos_de_anexo database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tipos_de_anexo")
public class TiposDeAnexo extends AbstractEntity<Long> {	

    @Column(name = "tipo_de_anexo")
    private String tipoDeAnexo;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tiposDeAnexo")
    private FuncionariosAnexos funcionariosAnexos;
      
	public String getTipoDeAnexo() {
		return tipoDeAnexo;
	}
	public void setTipoDeAnexo(String tipoDeAnexo) {
		this.tipoDeAnexo = tipoDeAnexo;
	}
	public FuncionariosAnexos getFuncionariosAnexos() {
		return funcionariosAnexos;
	}
	public void setFuncionariosAnexos(FuncionariosAnexos funcionariosAnexos) {
		this.funcionariosAnexos = funcionariosAnexos;
	}
    
    
}