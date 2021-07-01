package com.folha.boot.service.calculos.folha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasImpostoDeRenda;
import com.folha.boot.domain.FaixasPrevidencia;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.service.FaixasImpostoDeRendaService;
import com.folha.boot.service.FaixasPrevidenciaNomeService;
import com.folha.boot.service.FaixasPrevidenciaSevice;
import com.folha.boot.service.NaoDescontaInssService;
import com.folha.boot.service.NaoDescontaIrService;
import com.folha.boot.service.PessoaFuncionariosService;

@Service
@Transactional(readOnly = false)
public class CalcularIrService {

	@Autowired
	private  FaixasImpostoDeRendaService faixasImpostoDeRendaService;
	@Autowired
	private  NaoDescontaIrService naoDescontaIrService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	
	
	public Double calcularValorIr(Double valor, AnoMes anoMes, Pessoa pessoa) {
		boolean temIr = true;
		Double resposta = 0.0;
		
		//Avaliando se Tem IR ou NÃO
		if(! naoDescontaIrService.buscarPorMesExatoEPessoa(anoMes, pessoa).isEmpty() ) {temIr=false;}
		if(temIr==true) {resposta = valorIr(valor, anoMes);}
		if(resposta<0) {resposta=0.0;}
				
		
		return resposta;
	}
	
	
	public Double valorIr(Double valor, AnoMes anoMes) {
		Double resposta = 0.0;
		List<FaixasImpostoDeRenda> listaFaixas = faixasImpostoDeRendaService.buscarPorAnoMesExato(anoMes);
			for(int i=0;i<listaFaixas.size();i++) {
				if(valor>=listaFaixas.get(i).getBaseCalculoValorInicial() && valor<=listaFaixas.get(i).getBaseCalculoValorFinal()) {
					resposta = (valor*(listaFaixas.get(i).getAliquota()/100) ) - (listaFaixas.get(i).getParcelaADevolver()) + (listaFaixas.get(i).getParcelaASubtrair()) ;
					if(resposta<0) {resposta=0.0;}
					break;
				}
			}
		if(resposta<0) {resposta=0.0;}	
		return resposta;
	}
	
}

