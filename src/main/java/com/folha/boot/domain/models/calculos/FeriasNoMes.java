package com.folha.boot.domain.models.calculos;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.FuncionariosFeriasPeriodos;

public class FeriasNoMes {
	
	FuncionariosFeriasPeriodos funcionariosFeriasPeriodos;
	int diaInicial;
	int diaFinal;
	int qtdDias;
	
	public FeriasNoMes() {
		super();
	}

	public FuncionariosFeriasPeriodos getFuncionariosFeriasPeriodos() {
		return funcionariosFeriasPeriodos;
	}

	public void setFuncionariosFeriasPeriodos(FuncionariosFeriasPeriodos funcionariosFeriasPeriodos) {
		this.funcionariosFeriasPeriodos = funcionariosFeriasPeriodos;
	}

	public int getDiaInicial() {
		return diaInicial;
	}

	public void setDiaInicial(int diaInicial) {
		this.diaInicial = diaInicial;
	}

	public int getDiaFinal() {
		return diaFinal;
	}

	public void setDiaFinal(int diaFinal) {
		this.diaFinal = diaFinal;
	}

	public int getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}
	
	
	
}
