package com.folha.boot.domain.models.calculos;

import com.folha.boot.domain.FaixasValoresLicencaMaternidade;


public class LicencasMaternidadeNoMes {
	
	FaixasValoresLicencaMaternidade faixasValoresLicencaMaternidade;
	int diaInicial;
	int diaFinal;
	int qtdDias;
	
	public LicencasMaternidadeNoMes() {
		super();
	}


	public FaixasValoresLicencaMaternidade getFaixasValoresLicencaMaternidade() {
		return faixasValoresLicencaMaternidade;
	}


	public void setFaixasValoresLicencaMaternidade(FaixasValoresLicencaMaternidade faixasValoresLicencaMaternidade) {
		this.faixasValoresLicencaMaternidade = faixasValoresLicencaMaternidade;
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
