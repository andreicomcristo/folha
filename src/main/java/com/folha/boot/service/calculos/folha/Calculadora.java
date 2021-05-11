package com.folha.boot.service.calculos.folha;

import java.util.List;

public class Calculadora {

	private int id;
	private List<Funcionario> funcionarios;
	private List<MemoriaDeCalculo> memoriaDosCalculos;
	private List<Rubrica> vantegens;
	private List<Rubrica> descontos;
	
	public Calculadora() {
		super();
	}
	
	public Calculadora(List<Funcionario> funcionarios, List<MemoriaDeCalculo> memoriaDosCalculos) {
		super();
		this.funcionarios = funcionarios;
		this.memoriaDosCalculos = memoriaDosCalculos;
	}

	public int getId() {
		return id;
	}
	
	public void separarTiposDeVemcimento(){
				
		//Funcionario = 
	}
		
}
