package com.folha.boot.service.calculos.escala;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.FuncionariosFeriasPeriodosReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.FuncionariosFerias;
import com.folha.boot.domain.FuncionariosFeriasPeriodos;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RubricaVencimento;
import com.folha.boot.domain.models.calculos.EscalasNoMes;
import com.folha.boot.domain.models.calculos.FeriasNoMes;
import com.folha.boot.domain.models.calculos.LicencasNoMes;
import com.folha.boot.domain.models.calculos.RubricasVencimento;
import com.folha.boot.service.RubricaPensaoObsService;
import com.folha.boot.service.RubricaVencimentoObsService;
import com.folha.boot.service.RubricaVencimentoService;
import com.folha.boot.service.calculos.folha.CalcularBrutoService;
import com.folha.boot.service.calculos.folha.CalcularCalculadoraService;
import com.folha.boot.service.calculos.folha.CalcularInssService;
import com.folha.boot.service.calculos.folha.CalcularIrService;
import com.folha.boot.service.calculos.folha.CalcularLiquidoService;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;

@Service
@Transactional(readOnly = false)
public class CalculosCalcularService {

	@Autowired
	private  CalculosColetaDeDadosService calculosColetaDeDadosService;
	@Autowired
	private  CalculosAlternativosService calculosAlternativosService;
	@Autowired
	private RubricaVencimentoService rubricaVencimentoService;
	
	@Autowired
	private CalcularCalculadoraService calcularCalculadoraService;
	@Autowired
	private RubricaVencimentoObsService rubricaVencimentoObsService;
	@Autowired
	private RubricaPensaoObsService rubricaPensaoObsService;
	

	
	public void calcular(AnoMes anoMes){
		
		//Coletando Escalas
		List<EscalasNoMes> listaEscalas = new ArrayList<>();
		listaEscalas = calculosColetaDeDadosService.buscarEscalasPorMes(anoMes);
		//Coletando Ferias
		List<FeriasNoMes> listaFerias = new ArrayList<>();
		listaFerias = calculosColetaDeDadosService.buscarFeriasPorMes(anoMes);
		//Coletando Licenças
		List<LicencasNoMes> listaLicencas = new ArrayList<>();  
		listaLicencas = calculosColetaDeDadosService.buscarLicencasPorMes(anoMes);
		//Aplicando férias
		listaEscalas = calculosAlternativosService.aplicarFeriasNaEscala(listaEscalas, listaFerias);
		//Aplicando licenças
		listaEscalas = calculosAlternativosService.aplicarLicencasNaEscala(listaEscalas, listaLicencas, anoMes);
		
		//Aplicando Faltas Semana Fim Semana
		listaEscalas = calculosAlternativosService.aplicarFaltasVariaveisNaEscalaSemanaFimSemana(listaEscalas );
		//Aplicando Faltas Semana Fim Semana
		listaEscalas = calculosAlternativosService.aplicarFaltasVariaveisNaEscalaDiaNoite(listaEscalas );
		
		
		//Obtendo valores
		List<RubricasVencimento> listaVencimentos = calculosAlternativosService.obterVencimentosDiferenciadoPorEscala(listaEscalas,listaFerias , anoMes); 
		
		
		
		//Colocando valores líquidos onde nao tiver
		listaVencimentos = calculosAlternativosService.colocandoLiquidoNasRubricas(listaVencimentos);
		
		//Limpando o banco
		rubricaVencimentoService.excluirPorMes(anoMes);
		rubricaVencimentoObsService.excluirPorMes(anoMes);
		rubricaPensaoObsService.excluirPorMes(anoMes);
		//Persistindo
		rubricaVencimentoService.salvarLista(listaVencimentos);
		rubricaVencimentoObsService.salvarLista(listaEscalas);
		
		
		
		//Chamando Calculadora
		calcularCalculadoraService.calcularTudo(anoMes);
		
		
		
		/*
		for(int i=0;i<listaEscalas.size();i++) {
			
			
			System.out.println("Nome:"+listaEscalas.get(i).getReferencias().getNome());
			System.out.println("Cpf:"+listaEscalas.get(i).getReferencias().getCpf());
			System.out.println("Matricula:"+listaEscalas.get(i).getReferencias().getMatricula());
			System.out.println("Vinculo:"+listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo());
			System.out.println("Folha:"+listaEscalas.get(i).getReferencias().getTiposDeFolha().getNomeTipoFolha());
			System.out.println("Regime:"+listaEscalas.get(i).getReferencias().getRegimesDeTrabalho().getNomeRegimeDeTrabalho());
			System.out.println("Dias Ferias:"+listaEscalas.get(i).getReferencias().getDiasFerias());
			System.out.println("Horas Ferias:"+listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas());
			System.out.println("Dias Licenca:"+listaEscalas.get(i).getReferencias().getDiasLicenca());
			System.out.println("Horas Licenca:"+listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas());
			
			System.out.println("Horas Totais Finais:"+listaEscalas.get(i).getEscala().getHorasTotais());
			System.out.println("Anotacoes:"+listaEscalas.get(i).getReferencias().getObsReferencias());
			
			System.out.println();
			
			
		}
		*/
		
		
		
		
		
	}
}
