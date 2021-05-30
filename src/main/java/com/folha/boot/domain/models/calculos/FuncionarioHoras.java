package com.folha.boot.domain.models.calculos;



import com.folha.boot.domain.PessoaFuncionarios;

public class FuncionarioHoras {
	
	PessoaFuncionarios funcionario;
	int horas;
	
	
	
	public FuncionarioHoras() {
		super();
	}

	

	public FuncionarioHoras(PessoaFuncionarios funcionario, int horas) {
		super();
		this.funcionario = funcionario;
		this.horas = horas;
	}



	public PessoaFuncionarios getFuncionario() {
		return funcionario;
	}



	public void setFuncionario(PessoaFuncionarios funcionario) {
		this.funcionario = funcionario;
	}



	public int getHoras() {
		return horas;
	}



	public void setHoras(int horas) {
		this.horas = horas;
	}

		
	
}
