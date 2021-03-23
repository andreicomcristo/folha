package com.folha.boot.domain;

import java.math.BigInteger;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "acesso_operadores_unidades")
public class AcessoOperadoresUnidades extends AbstractEntity<Long> {

	@Column(name = "id_perfil_fk")
    private BigInteger idPerfilFk;
    @JoinColumn(name = "id_operador_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaOperadores idOperadorFk;
    @JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unidades idUnidadeFk;
	
    public BigInteger getIdPerfilFk() {
		return idPerfilFk;
	}
	public void setIdPerfilFk(BigInteger idPerfilFk) {
		this.idPerfilFk = idPerfilFk;
	}
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