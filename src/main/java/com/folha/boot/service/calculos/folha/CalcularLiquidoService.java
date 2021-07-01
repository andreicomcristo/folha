package com.folha.boot.service.calculos.folha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.service.NaoDescontaInssService;
import com.folha.boot.service.NaoDescontaIrService;

@Service
@Transactional(readOnly = false)
public class CalcularLiquidoService {

	@Autowired
	private  CalcularInssService calcularInssService;
	@Autowired
	private  CalcularIrService calcularIrService;
	@Autowired
	private  NaoDescontaInssService naoDescontaInssService;
	@Autowired
	private  NaoDescontaIrService naoDescontaIrService;
	
	
	public Double calcularLiquido(Double valor, PessoaFuncionarios funcionario, AnoMes anoMes) {
		boolean temInss = true;
		boolean temIr = true;
		Double resposta = 0.0;
		Double intermediario1 = 0.0;
		Double intermediario2 = 0.0;
		//Avaliando se Tem INSS ou NÃO
		if(funcionario.getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("EFETIVO")  ||  funcionario.getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("CEDIDO")) {temInss=false;}
		if(! naoDescontaInssService.buscarPorMesExatoEPessoa(anoMes, funcionario.getIdPessoaFk()).isEmpty() ) {temInss=false;}
		if(! naoDescontaIrService.buscarPorMesExatoEPessoa(anoMes, funcionario.getIdPessoaFk()).isEmpty() ) {temIr=false;}
		
		if(temInss==true) {
			intermediario1 = valor - calcularInssService.valorInss(valor, anoMes);
			
			double valorIr = calcularIrService.valorIr(intermediario1, anoMes);
			if(temIr==false) {valorIr = 0.0;}
			
			intermediario2 = intermediario1 - valorIr;
			resposta = intermediario2;
			if(resposta<0) {resposta=0.0;}
		}else {
			
			double valorIr = calcularIrService.valorIr(valor, anoMes);
			if(temIr==false) {valorIr = 0.0;}
			
			resposta = valor - valorIr;
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
	
	
	
	public Double calcularLiquidoComInss(Double valor, AnoMes anoMes, Pessoa pessoa) {
		
		Double resposta = 0.0;
		Double resposta1 = valor - calcularInssService.valorInss(valor, anoMes);
		
		boolean temIr = true;
		if(! naoDescontaIrService.buscarPorMesExatoEPessoa(anoMes, pessoa).isEmpty() ) {temIr=false;}
		double valorIr = calcularIrService.valorIr(resposta1, anoMes);
		if(temIr==false) {valorIr = 0.0;}
		
		resposta = resposta1 - valorIr;
		if(resposta<0) {resposta=0.0;}
		return resposta;
	}
	
	public Double calcularLiquidoSemInss(Double valor, AnoMes anoMes, Pessoa pessoa) {
		Double resposta = 0.0;
		
		boolean temIr = true;
		if(! naoDescontaIrService.buscarPorMesExatoEPessoa(anoMes, pessoa).isEmpty() ) {temIr=false;}
		double valorIr = calcularIrService.valorIr(valor, anoMes);
		if(temIr==false) {valorIr = 0.0;}
		
		resposta = valor - valorIr;
		if(resposta<0) {resposta=0.0;}
		return resposta;
	}
	
	
}
