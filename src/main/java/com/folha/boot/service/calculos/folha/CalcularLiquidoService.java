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
public class CalcularLiquidoService {

	@Autowired
	private  CalcularInssService calcularInssService;
	@Autowired
	private  CalcularIrService calcularIrService;
	@Autowired
	private  NaoDescontaInssService naoDescontaInssService;
	
	
	public Double calcularLiquido(Double valor, PessoaFuncionarios funcionario, AnoMes anoMes) {
		boolean temInss = true;
		Double resposta = 0.0;
		Double intermediario1 = 0.0;
		Double intermediario2 = 0.0;
		//Avaliando se Tem INSS ou NÃO
		if(funcionario.getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("EFETIVO")) {temInss=false;}
		if(! naoDescontaInssService.buscarPorMesExatoEFuncionario(anoMes, funcionario).isEmpty() ) {temInss=false;}
		
		if(temInss==true) {
			intermediario1 = valor - calcularInssService.valorInss(valor, anoMes);
			intermediario2 = intermediario1 - calcularIrService.valorIr(intermediario1, anoMes);
			resposta = intermediario2;
			if(resposta<0) {resposta=0.0;}
		}else {
			resposta = valor - calcularIrService.valorIr(valor, anoMes);
			if(resposta<0) {resposta=0.0;}
		}
		
		return resposta;
	}
	
	
	
	public Double calcularLiquidoComInss(Double valor, AnoMes anoMes) {
		Double resposta = 0.0;
		Double resposta1 = valor - calcularInssService.valorInss(valor, anoMes);
		resposta = resposta1 - calcularIrService.valorIr(resposta1, anoMes);
		if(resposta<0) {resposta=0.0;}
		return resposta;
	}
	
	public Double calcularLiquidoSemInss(Double valor, AnoMes anoMes) {
		Double resposta = 0.0;
		resposta = valor - calcularIrService.valorIr(valor, anoMes);
		if(resposta<0) {resposta=0.0;}
		return resposta;
	}
	
}
