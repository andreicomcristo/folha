package com.folha.boot.domain;

import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_bancos")
public class PessoaBancos extends AbstractEntity<Long> {
	
	//@JoinColumn(name = "id_banco_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bancos idBancoFk;

	public PessoaBancos() {
		super();
	}

	public PessoaBancos(Bancos idBancoFk) {
		super();
		this.idBancoFk = idBancoFk;
	}

	public Bancos getIdBancoFk() {
		return idBancoFk;
	}

	public void setIdBancoFk(Bancos idBancoFk) {
		this.idBancoFk = idBancoFk;
	}

}
