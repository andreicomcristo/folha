package com.folha.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="funcionarios_licencas_cid")
public class FuncionariosLicencasCid extends AbstractEntity<Long> {
	
	@JoinColumn(name = "id_cid_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cids idCidFk;
    @JoinColumn(name = "id_funcionarios_licencas_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FuncionariosLicencas idFuncionariosLicencasFk;
	public Cids getIdCidFk() {
		return idCidFk;
	}
	public void setIdCidFk(Cids idCidFk) {
		this.idCidFk = idCidFk;
	}
	public FuncionariosLicencas getIdFuncionariosLicencasFk() {
		return idFuncionariosLicencasFk;
	}
	public void setIdFuncionariosLicencasFk(FuncionariosLicencas idFuncionariosLicencasFk) {
		this.idFuncionariosLicencasFk = idFuncionariosLicencasFk;
	}
    
    
    
}