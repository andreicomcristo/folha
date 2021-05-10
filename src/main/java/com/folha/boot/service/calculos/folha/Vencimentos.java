package com.folha.boot.service.calculos.folha;

public class Vencimentos {

	private int id;
	private Funcionario funcionario;
	private AnoMes anoMes;
	private CodigoDaRubrica codigoDaRubrica;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public AnoMes getAnoMes() {
		return anoMes;
	}
	public void setAnoMes(AnoMes anoMes) {
		this.anoMes = anoMes;
	}
	public CodigoDaRubrica getCodigoDaRubrica() {
		return codigoDaRubrica;
	}
	public void setCodigoDaRubrica(CodigoDaRubrica codigoDaRubrica) {
		this.codigoDaRubrica = codigoDaRubrica;
	}
	
}
