package com.folha.boot.domain.calculos;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.folha.boot.domain.PlanilhaImportacaoGenteDesktop;

@Component
public class planilhaImportacaoCalculada {

	Long id;
		
    private PlanilhaImportacaoGenteDesktop planilhaImportacaoGenteDesktop;
    
    private Double valorBrutoHorasTotais;
    
    private Double valorBrutoHorasDia;
    
    private Double valorBrutoHorasNoite;
    
    private Double valorBrutoHorasSemana;
    
    private Double valorBrutoHorasFinalDeSemana;
    
    private Double valorPrevidencia;
    
    private Double valorPensao;
    
    private Double valorIR;
    
    private Double valorLiquido;
    
    private Double valorPatronal;
    

    
    
    
    
	public planilhaImportacaoCalculada(PlanilhaImportacaoGenteDesktop planilhaImportacaoGenteDesktop) {
		super();
		this.planilhaImportacaoGenteDesktop = planilhaImportacaoGenteDesktop;
	}






	public planilhaImportacaoCalculada() {
		super();
		// TODO Auto-generated constructor stub
	}



	


	    
}
