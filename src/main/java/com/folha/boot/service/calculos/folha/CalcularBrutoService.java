package com.folha.boot.service.calculos.folha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.service.NaoDescontaInssService;
import com.folha.boot.service.PessoaFuncionariosService;

@Service
@Transactional(readOnly = false)
public class CalcularBrutoService {

	@Autowired
	private  CalcularLiquidoService calcularLiquidoService;
	@Autowired
	private  NaoDescontaInssService naoDescontaInssService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	
	
	
	
	public Double calcularBruto(Double valor, Pessoa pessoa, AnoMes anoMes) {
		boolean temInss = true;
		Double resposta = 0.0;
		//Avaliando se Tem INSS ou NÃO
		
		//Identificando o Vinculo
		boolean vinculoEfetivo = false;
		List<PessoaFuncionarios> listaFuncionariosVinculo = pessoaFuncionariosService.buscarPorPessoa(pessoa);
		for(PessoaFuncionarios f: listaFuncionariosVinculo) {
			if(f.getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("EFETIVO")) {
				vinculoEfetivo = true; break;
			}
		}
		
		if(vinculoEfetivo == true) {temInss=false;}
		if(! naoDescontaInssService.buscarPorMesExatoEPessoa(anoMes, pessoa).isEmpty() ) {temInss=false;}
		
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
