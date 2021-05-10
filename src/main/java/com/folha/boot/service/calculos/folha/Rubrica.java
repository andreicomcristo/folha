package com.folha.boot.service.calculos.folha;

public class Rubrica {

	private int id;
	private CodigoDaRubrica CodigoDaRubrica;	
	private AnoMes anoMes;
	private int valor;
	private double porcentagem;
	private double quantidade;
	
	
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
	public double getPorcentagem() {
		return porcentagem;
	}
	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
}
