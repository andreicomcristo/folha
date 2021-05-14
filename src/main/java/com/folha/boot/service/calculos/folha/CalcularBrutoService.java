package com.folha.boot.service.calculos.folha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.service.NaoDescontaInssService;

@Service
@Transactional(readOnly = false)
public class CalcularBrutoService {

	@Autowired
	private  CalcularLiquidoService calcularLiquidoService;
	@Autowired
	private  NaoDescontaInssService naoDescontaInssService;
	
	
	
	
	public Double calcularBruto(Double valor, PessoaFuncionarios funcionario, AnoMes anoMes) {
		boolean temInss = true;
		Double resposta = 0.0;
		//Avaliando se Tem INSS ou NÃO
		if(funcionario.getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("EFETIVO")) {temInss=false;}
		if(! naoDescontaInssService.buscarPorMesExatoEFuncionario(anoMes, funcionario).isEmpty() ) {temInss=false;}
		
		if(temInss==true) {
			for(Double i = valor; ; i=i+0.01 ) {
				Double liquido = calcularLiquidoService.calcularLiquidoComInss(i, anoMes);
				if((liquido+0.1)< valor ) { i=i+ valor-liquido-0.09; }
				if(!(liquido<valor)) {resposta = i;break;}
			}
		}else {
			for(Double i = valor; ; i=i+0.01 ) {
				Double liquido = calcularLiquidoService.calcularLiquidoSemInss(i, anoMes);
				if((liquido+0.1)< valor ) { i=i+ valor-liquido-0.09; }
				if(!(liquido<valor)) {resposta = i;break;}
			}
		}
		return resposta;
	}
	
	
	
	public Double calcularBrutoComInss(Double valor, AnoMes anoMes) {
		Double resposta = 0.0;
		for(Double i = valor; ; i=i+0.01 ) {
			Double liquido = calcularLiquidoService.calcularLiquidoComInss(i, anoMes);
			if((liquido+0.1)< valor ) { i=i+ valor-liquido-0.09; }
			if(!(liquido<valor)) {resposta = i;break;}
		}
		return resposta;
	}
	
	public Double calcularBrutoSemInss(Double valor, AnoMes anoMes) {
		Double resposta = 0.0;
		for(Double i = valor; ; i=i+0.01 ) {
			Double liquido = calcularLiquidoService.calcularLiquidoSemInss(i, anoMes);
			if((liquido+0.1)< valor ) { i=i+ valor-liquido-0.09; }
			if(!(liquido<valor)) {resposta = i;break;}
		}
		return resposta;
	}
	
}
