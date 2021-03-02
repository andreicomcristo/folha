package com.folha.boot.domain;

import javax.persistence.*;


/**
 * The persistent class for the tipos_de_anexo database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="tipos_de_anexo")
public class TiposDeAnexo extends AbstractEntity<Long> {


	@Column(name="tipo_de_anexo")
	private String tipoDeAnexo;

	//bi-directional one-to-one association to FuncionariosAnexo
	@OneToOne(mappedBy="tiposDeAnexo")
	private FuncionariosAnexos funcionariosAnexo;

	public TiposDeAnexo() {
	}

	public String getTipoDeAnexo() {
		return this.tipoDeAnexo;
	}

	public void setTipoDeAnexo(String tipoDeAnexo) {
		this.tipoDeAnexo = tipoDeAnexo;
	}

	public FuncionariosAnexos getFuncionariosAnexo() {
		return this.funcionariosAnexo;
	}

	public void setFuncionariosAnexo(FuncionariosAnexos funcionariosAnexo) {
		this.funcionariosAnexo = funcionariosAnexo;
	}

}