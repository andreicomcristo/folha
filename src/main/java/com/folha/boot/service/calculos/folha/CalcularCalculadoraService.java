package com.folha.boot.service.calculos.folha;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RubricaVencimento;
import com.folha.boot.domain.models.calculos.RubricasVencimento;
import com.folha.boot.service.NaoDescontaInssService;
import com.folha.boot.service.RubricaVencimentoService;
import com.folha.boot.service.util.UtilidadesMatematicas;

@Service
@Transactional(readOnly = false)
public class CalcularCalculadoraService {
	
	@Autowired
	private  RubricaVencimentoService rubricaVencimentoService;
	@Autowired
	private  CalcularInssService calcularInssService;
	@Autowired
	private  CalcularIrService calcularIrService;
	@Autowired
	private  CalcularBrutoService calcularBrutoService;
	
	
	public void calcularTudo(AnoMes anoMes) {
		List<PessoaFuncionarios> listaFuncionarios = listarFuncionariosComRubrica(anoMes);
		
		for(int i=0;i<listaFuncionarios.size();i++) {
			List<RubricaVencimento> listaVencimentos = buscarRubricasPorPessoa(anoMes, listaFuncionarios.get(i));
				boolean contemRemuneracaoLiquida = false;
				for(int j=0;j<listaVencimentos.size();j++) {
					if(listaVencimentos.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) {contemRemuneracaoLiquida = true;}
				}
				
				
				Double liquidoVantagens=0.0;
				Double liquidoDecontos=0.0;
				Double vantagens=0.0;
				Double descontos=0.0;
				Double pensao = 0.0;
				Double inss=0.0;
				Double ir=0.0;
				Double patronal=0.0;
				
				//Calculando quando só tem verbas brutas.
				if(contemRemuneracaoLiquida==false) {
					//Colocando valores nas variáveis
					for(int j=0;j<listaVencimentos.size();j++) {
						//Vantagens
						if(listaVencimentos.get(j).getIdNaturezaFk().getSigla().equalsIgnoreCase("V")) {
							vantagens = vantagens+listaVencimentos.get(j).getValorBruto();
							liquidoVantagens = liquidoVantagens+listaVencimentos.get(j).getValorLiquido();
						}
						//Descontos
						if(listaVencimentos.get(j).getIdNaturezaFk().getSigla().equalsIgnoreCase("D")) {
							descontos = descontos+listaVencimentos.get(j).getValorBruto();
							liquidoDecontos = liquidoDecontos+listaVencimentos.get(j).getValorLiquido();
						}
					}
				
					//Calculando Inss
					inss = calcularInssService.calcularValorInss(vantagens-descontos, anoMes, listaFuncionarios.get(i));
					//Faltando colocar a pensao alimenticia
					//Calculando Ir
					ir = calcularIrService.valorIr(vantagens-descontos-pensao-inss, anoMes);
					//Calculando patronal
					if(!listaFuncionarios.get(i).getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("EFETIVO")) {patronal = (vantagens-descontos)*0.22; }
				
					//Calculando as proporções dos impostos
					for(int j=0;j<listaVencimentos.size();j++) {
						if(listaVencimentos.get(j).getIdNaturezaFk().getSigla().equalsIgnoreCase("V")) {
							double proporcao = listaVencimentos.get(j).getValorLiquido()/liquidoVantagens;
							listaVencimentos.get(j).setValorPrevidencia(inss*proporcao);
							listaVencimentos.get(j).setValorIr(ir*proporcao);
							listaVencimentos.get(j).setValorPatronal(patronal*proporcao);
							listaVencimentos.get(j).setPercentagem(proporcao*100);
						}
					}
				
				}
		
				
				
				
				
				
				//Calculando quando tem alguma verba liquida.
				if(contemRemuneracaoLiquida==true) {
					//Colocando valores nas variáveis
					for(int j=0;j<listaVencimentos.size();j++) {
						//Vantagens
						if(listaVencimentos.get(j).getIdNaturezaFk().getSigla().equalsIgnoreCase("V")) {
							liquidoVantagens = liquidoVantagens+listaVencimentos.get(j).getValorLiquido();
						}
						//Descontos
						if(listaVencimentos.get(j).getIdNaturezaFk().getSigla().equalsIgnoreCase("D")) {
							descontos = descontos+listaVencimentos.get(j).getValorBruto();
							liquidoDecontos = liquidoDecontos+listaVencimentos.get(j).getValorLiquido();
						}
					}
				
					//Calcular bruto total
					vantagens = calcularBrutoService.calcularBruto(liquidoVantagens, listaFuncionarios.get(i), anoMes);
					
					//Calculando Inss
					inss = calcularInssService.calcularValorInss(vantagens-descontos, anoMes, listaFuncionarios.get(i));
					//Faltando colocar a pensao alimenticia
					//Calculando Ir
					ir = calcularIrService.valorIr(vantagens-descontos-pensao-inss, anoMes);
					//Calculando patronal
					if(!listaFuncionarios.get(i).getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("EFETIVO")) {patronal = (vantagens-descontos)*0.22; }
				
					//Calculando as proporções dos impostos
					for(int j=0;j<listaVencimentos.size();j++) {
						if(listaVencimentos.get(j).getIdNaturezaFk().getSigla().equalsIgnoreCase("V")) {
							double proporcao = listaVencimentos.get(j).getValorLiquido()/liquidoVantagens;
							listaVencimentos.get(j).setValorBruto(vantagens*proporcao); 
							listaVencimentos.get(j).setValorPrevidencia(inss*proporcao);
							listaVencimentos.get(j).setValorIr(ir*proporcao);
							listaVencimentos.get(j).setValorPatronal(patronal*proporcao);
							listaVencimentos.get(j).setPercentagem(proporcao*100);
						}
					}
				
				}
				
				
				
				
				
				
		}
	
		arredondarValoresVencimentos(anoMes);
	
	}
	
	
	
	
	
	
	public void arredondarValoresVencimentos(AnoMes anoMes) {
		List<RubricaVencimento> lista =  buscarRubricasPorAnoMes(anoMes);
		for(int i=0;i<lista.size();i++) {
			lista.get(i).setValorBruto(UtilidadesMatematicas.ajustaValorDecimal(lista.get(i).getValorBruto(), 2));
			lista.get(i).setValorIr(UtilidadesMatematicas.ajustaValorDecimal(lista.get(i).getValorIr(), 2));
			lista.get(i).setValorLiquido(UtilidadesMatematicas.ajustaValorDecimal(lista.get(i).getValorLiquido(), 2));
			lista.get(i).setValorPatronal(UtilidadesMatematicas.ajustaValorDecimal(lista.get(i).getValorPatronal(), 2));
			lista.get(i).setValorPrevidencia(UtilidadesMatematicas.ajustaValorDecimal(lista.get(i).getValorPrevidencia(), 2));
			lista.get(i).setPercentagem(UtilidadesMatematicas.ajustaValorDecimal(lista.get(i).getPercentagem(), 2));
		}
	}
	
	
	public List<PessoaFuncionarios> listarFuncionariosComRubrica(AnoMes anoMes){
		List<PessoaFuncionarios> lista = new ArrayList<>();
		
		List<RubricaVencimento> listaVencimentos = rubricaVencimentoService.buscarPorMes(anoMes);
		for(int i=0; i<listaVencimentos.size();i++) {
			if(!lista.contains(listaVencimentos.get(i).getIdFuncionarioFk())) {
				lista.add(listaVencimentos.get(i).getIdFuncionarioFk());
			}
		}
		return lista;
	}
	
	
	public List<RubricaVencimento> buscarRubricasPorPessoa(AnoMes anoMes, PessoaFuncionarios funcionario){
		return rubricaVencimentoService.buscarPorMesEFuncionario(anoMes, funcionario);
	}
	
	public List<RubricaVencimento> buscarRubricasPorAnoMes(AnoMes anoMes){
		return rubricaVencimentoService.buscarPorMes(anoMes);
	}
	
	
	
	
}
	