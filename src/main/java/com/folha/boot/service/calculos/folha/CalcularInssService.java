package com.folha.boot.service.calculos.folha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FaixasPrevidencia;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.service.FaixasPrevidenciaNomeService;
import com.folha.boot.service.FaixasPrevidenciaSevice;
import com.folha.boot.service.NaoDescontaInssService;
import com.folha.boot.service.PessoaFuncionariosService;

@Service
@Transactional(readOnly = false)
public class CalcularInssService {

	@Autowired
	private  FaixasPrevidenciaSevice faixasPrevidenciaSevice;
	@Autowired
	private  NaoDescontaInssService naoDescontaInssService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	
	
	
	public Double calcularValorInss(Double valor, AnoMes anoMes, Pessoa pessoa) {
		boolean temInss = true;
		Double resposta = 0.0;
		
		List<PessoaFuncionarios> listaFuncionarios = pessoaFuncionariosService.buscarPorPessoa(pessoa);
		boolean vinculoEfetivo = false;
		for(PessoaFuncionarios f: listaFuncionarios) {
			if(f.getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("EFETIVO")) {
				temInss = false;
			}
		}
		
		//Avaliando se Tem INSS ou NÃO
		if(! naoDescontaInssService.buscarPorMesExatoEPessoa(anoMes, pessoa).isEmpty() ) {temInss=false;}
		if(temInss==true) {resposta = valorInss(valor, anoMes);}
		if(resposta<0) {resposta=0.0;}
				
		
		return resposta;
	}
	
	
	
	
	public Double valorInss(Double valor, AnoMes anoMes) {
		Double resposta = 0.0;
		List<FaixasPrevidencia> listaFaixas = faixasPrevidenciaSevice.buscarPorAnoMesExato(anoMes);
			for(int i=0;i<listaFaixas.size();i++) {
				if(valor>=listaFaixas.get(i).getBaseCalculoValorInicial() && valor<=listaFaixas.get(i).getBaseCalculoValorFinal()) {
					Double acumulado = 0.0;
					if(i>0) {
						for(int j=0;j<i;j++) {
							if(j==i) {break;}
							acumulado = acumulado + listaFaixas.get(j).getParcelaASubtrair();
						}
					}
					resposta = ((valor-listaFaixas.get(i).getBaseCalculoValorInicial())*(listaFaixas.get(i).getAliquota()/100)) - (listaFaixas.get(i).getParcelaADevolver()) + (acumulado) ;
					if(resposta<0) {resposta=0.0;}
					break;
				}
			}
		if(resposta<0) {resposta=0.0;}
		return resposta;
	}
	
}
