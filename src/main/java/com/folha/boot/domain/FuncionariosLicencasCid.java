package com.folha.boot.domain;

import javax.persistence.*;


/**
 * The persistent class for the funcionarios_licencas_cid database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="funcionarios_licencas_cid")
public class FuncionariosLicencasCid extends AbstractEntity<Long> {

	@Column(name="id_cid_fk")
	private Long idCidFk;

	public FuncionariosLicencasCid() {
	}

	public Long getIdCidFk() {
		return this.idCidFk;
	}

	public void setIdCidFk(Long idCidFk) {
		this.idCidFk = idCidFk;
	}

}