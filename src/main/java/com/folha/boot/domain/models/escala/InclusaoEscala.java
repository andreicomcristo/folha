package com.folha.boot.domain.models.escala;

import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Turmas;

public class InclusaoEscala {

	Long id;
	PessoaFuncionarios pessoaFuncionarios;
	TiposDeFolha tiposDeFolha;
	RegimesDeTrabalho regiDeTrabalho;
	Turmas turma;
	
	
	
	public InclusaoEscala() {
		super();
	}



	public InclusaoEscala(Long id, PessoaFuncionarios pessoaFuncionarios, TiposDeFolha tiposDeFolha,
			RegimesDeTrabalho regiDeTrabalho, Turmas turma) {
		super();
		this.id = id;
		this.pessoaFuncionarios = pessoaFuncionarios;
		this.tiposDeFolha = tiposDeFolha;
		this.regiDeTrabalho = regiDeTrabalho;
		this.turma = turma;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public PessoaFuncionarios getPessoaFuncionarios() {
		return pessoaFuncionarios;
	}



	public void setPessoaFuncionarios(PessoaFuncionarios pessoaFuncionarios) {
		this.pessoaFuncionarios = pessoaFuncionarios;
	}



	public TiposDeFolha getTiposDeFolha() {
		return tiposDeFolha;
	}



	public void setTiposDeFolha(TiposDeFolha tiposDeFolha) {
		this.tiposDeFolha = tiposDeFolha;
	}



	public RegimesDeTrabalho getRegiDeTrabalho() {
		return regiDeTrabalho;
	}



	public void setRegiDeTrabalho(RegimesDeTrabalho regiDeTrabalho) {
		this.regiDeTrabalho = regiDeTrabalho;
	}



	public Turmas getTurma() {
		return turma;
	}



	public void setTurma(Turmas turma) {
		this.turma = turma;
	}



	
	
		
	
}
