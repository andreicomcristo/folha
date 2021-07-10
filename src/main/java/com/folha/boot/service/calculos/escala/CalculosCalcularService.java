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
import com.folha.boot.domain.TempoCalculo;
import com.folha.boot.domain.models.calculos.EscalasNoMes;
import com.folha.boot.domain.models.calculos.FeriasNoMes;
import com.folha.boot.domain.models.calculos.LicencasMaternidadeNoMes;
import com.folha.boot.domain.models.calculos.LicencasNoMes;
import com.folha.boot.domain.models.calculos.RubricasVencimento;
import com.folha.boot.service.RubricaPensaoObsService;
import com.folha.boot.service.RubricaPensaoObsVencimentoService;
import com.folha.boot.service.RubricaVencimentoObsService;
import com.folha.boot.service.RubricaVencimentoService;
import com.folha.boot.service.TempoCalculoService;
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
	@Autowired
	private RubricaPensaoObsVencimentoService rubricaPensaoObsVencimentoService;
	@Autowired
	private TempoCalculoService tempoCalculoService;

	
	public void calcular(AnoMes anoMes){
		
		Date momentoInicio = new Date();
		
		//Coletando Escalas
		List<EscalasNoMes> listaEscalas = new ArrayList<>();
		listaEscalas = calculosColetaDeDadosService.buscarEscalasPorMes(anoMes);
		
		//Coletando Ferias
		List<FeriasNoMes> listaFerias = new ArrayList<>();
		listaFerias = calculosColetaDeDadosService.buscarFeriasPorMes(anoMes);
		
		//Coletando Licenças
		List<LicencasNoMes> listaLicencas = new ArrayList<>();  
		listaLicencas = calculosColetaDeDadosService.buscarLicencasPorMes(anoMes);
		
		//Coletando Licenças Maternidade Da Folha
		List<LicencasMaternidadeNoMes> listaLicencasMaternidade = new ArrayList<>();  
		listaLicencasMaternidade = calculosColetaDeDadosService.buscarFaixasValoresLicencaMaternidadePorMes(anoMes);
		
		//Aplicando férias
		listaEscalas = calculosAlternativosService.aplicarFeriasNaEscala(listaEscalas, listaFerias);
		
		//Aplicando licenças
		listaEscalas = calculosAlternativosService.aplicarLicencasNaEscala(listaEscalas, listaLicencas, anoMes);
		
		//Aplicando licenças Maternidade Da Folha
		listaEscalas = calculosAlternativosService.aplicarLicencasMaternidadeDaFolhaNaEscala(listaEscalas, listaLicencasMaternidade, anoMes);
		
		//Aplicando Faltas Semana Fim Semana
		listaEscalas = calculosAlternativosService.aplicarFaltasVariaveisNaEscalaSemanaFimSemana(listaEscalas );
		
		//Aplicando Faltas Dia Noite
		listaEscalas = calculosAlternativosService.aplicarFaltasVariaveisNaEscalaDiaNoite(listaEscalas );
		
		//Obtendo valores
		List<RubricasVencimento> listaVencimentos = calculosAlternativosService.obterVencimentosDiferenciadoPorEscala(listaEscalas,listaFerias, listaLicencasMaternidade , anoMes); 
		
		//Colocando valores líquidos onde nao tiver
		listaVencimentos = calculosAlternativosService.colocandoLiquidoNasRubricas(listaVencimentos);
		
		//Mudando as fontes quando a Folha Muda a Fonte (CONVERSAO FONTE POR FOLHA)
		listaVencimentos = calculosAlternativosService.conversaoFontePorFolha(listaVencimentos, anoMes);
		
		//Limpando o banco
		rubricaPensaoObsVencimentoService.excluirPorMes(anoMes);
		rubricaVencimentoService.excluirPorMes(anoMes);
		rubricaVencimentoObsService.excluirPorMes(anoMes);
		rubricaPensaoObsService.excluirPorMes(anoMes);
		
		//Persistindo
		rubricaVencimentoService.salvarLista(listaVencimentos);
		rubricaVencimentoObsService.salvarLista(listaEscalas);
		
		//Chamando Calculadora
		calcularCalculadoraService.calcularTudo(anoMes);
		
		//Anotando Observacoes nas Rubricas Vencimentos
		calculosColetaDeDadosService.anotarObservacoes(anoMes);
		
		//Arredondando valores Brutos
		calculosColetaDeDadosService.ajustarValoresBrutos(anoMes);
		
		//Anotando as Pensoes
		calculosAlternativosService.colocarProporcaoNasPensoes(anoMes);
		
		
		
		//Colocando a média de tempo de cálculo por escala
		Date momentoFim = new Date();
		if(listaEscalas.size()>300) {
			Double segundos = (((momentoFim.getTime() - momentoInicio.getTime())+0.0)/1000) / listaEscalas.size();
			TempoCalculo t = new TempoCalculo();
			t.setSegundos(segundos);
			tempoCalculoService.salvar(t);
		}
		
		
		
		
		
		
		
		
	}
}
