package com.folha.boot.service.calculos.folha;

public class Rubrica {

	private int id;
	private CodigoDaRubrica CodigoDaRubrica;	
	private AnoMes anoMes;
	private int valor;	
	private char tipoDeValor;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CodigoDaRubrica getCodigoDaRubrica() {
		return CodigoDaRubrica;
	}
	public void setCodigoDaRubrica(CodigoDaRubrica codigoDaRubrica) {
		CodigoDaRubrica = codigoDaRubrica;
	}
	public AnoMes getAnoMes() {
		return anoMes;
	}
	public void setAnoMes(AnoMes anoMes) {
		this.anoMes = anoMes;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public char getTipoDeValor() {
		return tipoDeValor;
	}
	public void setTipoDeValor(char tipoDeValor) {
		this.tipoDeValor = tipoDeValor;
	}
	
}
