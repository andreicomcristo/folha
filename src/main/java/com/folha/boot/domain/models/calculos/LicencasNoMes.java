package com.folha.boot.domain.models.calculos;

import com.folha.boot.domain.FuncionariosLicencas;

public class LicencasNoMes {
	
	FuncionariosLicencas funcionariosLicencas;
	int diaInicial;
	int diaFinal;
	int qtdDias;
	
	public LicencasNoMes() {
		super();
	}

	

	public FuncionariosLicencas getFuncionariosLicencas() {
		return funcionariosLicencas;
	}



	public void setFuncionariosLicencas(FuncionariosLicencas funcionariosLicencas) {
		this.funcionariosLicencas = funcionariosLicencas;
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
