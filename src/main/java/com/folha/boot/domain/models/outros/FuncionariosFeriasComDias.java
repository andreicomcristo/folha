package com.folha.boot.domain.models.outros;

import com.folha.boot.domain.PessoaFuncionarios;

public class FuncionariosFeriasComDias {

	private Long id;
	private String anoReferencia;
	private Long dias;
	private PessoaFuncionarios idFuncionarioFk;
	
	
	public FuncionariosFeriasComDias() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAnoReferencia() {
		return anoReferencia;
	}


	public void setAnoReferencia(String anoReferencia) {
		this.anoReferencia = anoReferencia;
	}


	public Long getDias() {
		return dias;
	}


	public void setDias(Long dias) {
		this.dias = dias;
	}


	public PessoaFuncionarios getIdFuncionarioFk() {
		return idFuncionarioFk;
	}


	public void setIdFuncionarioFk(PessoaFuncionarios idFuncionarioFk) {
		this.idFuncionarioFk = idFuncionarioFk;
	}
	
		
	
}
