package com.folha.boot.service.calculos.folha;

import java.util.List;

public class Funcionario {
	
	private int id;
	private List<Vencimentos> vencimentos;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Vencimentos> getVencimentos() {
		return vencimentos;
	}
	public void setVencimentos(List<Vencimentos> vencimentos) {
		this.vencimentos = vencimentos;
	}

}
