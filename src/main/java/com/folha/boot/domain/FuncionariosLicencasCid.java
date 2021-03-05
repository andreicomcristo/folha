package com.folha.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="funcionarios_licencas_cid")
public class FuncionariosLicencasCid extends AbstractEntity<Long> {
	
    @Column(name = "id_cid_fk")
    private long idCidFk;
    
	public long getIdCidFk() {
		return idCidFk;
	}
	public void setIdCidFk(long idCidFk) {
		this.idCidFk = idCidFk;
	}   
    
}