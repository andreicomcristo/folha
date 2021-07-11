package com.folha.boot.domain.models.calculos;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Unidades;

public class UnidadeValor {
	
	Unidades unidade;
	Double valor;
	
	public UnidadeValor() {
	}

	public Unidades getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidades unidade) {
		this.unidade = unidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

		
	
}
