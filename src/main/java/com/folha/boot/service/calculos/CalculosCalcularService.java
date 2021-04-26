package com.folha.boot.service.calculos;

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
import com.folha.boot.domain.models.calculos.EscalasNoMes;
import com.folha.boot.domain.models.calculos.FeriasNoMes;
import com.folha.boot.domain.models.calculos.LicencasNoMes;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;

@Service
@Transactional(readOnly = false)
public class CalculosCalcularService {

	@Autowired
	private  CalculosColetaDeDadosService calculosColetaDeDadosService;
	@Autowired
	private  CalculosAlternativosService calculosAlternativosService;

	
	public void calcular(AnoMes anoMes){
		
		List<EscalasNoMes> listaEscalas = calculosColetaDeDadosService.buscarEscalasPorMes(anoMes);
		List<FeriasNoMes> listaFerias = calculosColetaDeDadosService.buscarFeriasPorMes(anoMes);
		List<LicencasNoMes> listaLicencas = calculosColetaDeDadosService.buscarLicencasPorMes(anoMes);
		
		listaEscalas = calculosAlternativosService.aplicarFeriasNaEscala(listaEscalas, listaFerias);
		
		for(int i=0;i<listaEscalas.size();i++) {
			
			
			System.out.println("Nome:"+listaEscalas.get(i).getReferencias().getNome());
			System.out.println("Cpf:"+listaEscalas.get(i).getReferencias().getCpf());
			System.out.println("Matricula:"+listaEscalas.get(i).getReferencias().getMatricula());
			System.out.println("Vinculo:"+listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo());
			System.out.println("Folha:"+listaEscalas.get(i).getReferencias().getTiposDeFolha().getNomeTipoFolha());
			System.out.println("Regime:"+listaEscalas.get(i).getReferencias().getRegimesDeTrabalho().getNomeRegimeDeTrabalho());
			System.out.println("Diferenciado:"+listaEscalas.get(i).getReferencias().getCodigoDiferenciado().getNomeCodigoDiferenciado());
			System.out.println("Dias Ferias:"+listaEscalas.get(i).getReferencias().getDiasFerias());
			System.out.println("Horas Ferias:"+listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas());
			System.out.println("Dias Licenca:"+listaEscalas.get(i).getReferencias().getDiasLicenca());
			System.out.println("Horas Licenca:"+listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas());
			
			System.out.println("Horas Totais Finais:"+listaEscalas.get(i).getEscala().getHorasTotais());
			System.out.println("Anotacoes:"+listaEscalas.get(i).getReferencias().getObsReferencias());
			
			System.out.println();
			
			
		}
		
		
		
		/*
		//Aplicando descontos Escala por Férias
		listaEscalas = calculosAlternativosService.aplicarFeriasNaEscala(listaEscalas, listaFerias);
		
		for(int i=0;i<listaEscalas.size();i++) {
			
			System.out.println("Nome:"+listaEscalas.get(i).getReferencias().getNome());
			System.out.println("Cpf:"+listaEscalas.get(i).getReferencias().getCpf());
			System.out.println("Matricula:"+listaEscalas.get(i).getReferencias().getMatricula());
			System.out.println("Folha:"+listaEscalas.get(i).getReferencias().getTiposDeFolha().getNomeTipoFolha());
			System.out.println("Regime:"+listaEscalas.get(i).getReferencias().getRegimesDeTrabalho().getNomeRegimeDeTrabalho());
			System.out.println("Diferenciado:"+listaEscalas.get(i).getReferencias().getCodigoDiferenciado().getNomeCodigoDiferenciado());
			System.out.println("Dias Ferias:"+listaEscalas.get(i).getReferencias().getDiasFerias());
			System.out.println("Horas Ferias:"+listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas());
			System.out.println("Dias Licenca:"+listaEscalas.get(i).getReferencias().getDiasLicenca());
			System.out.println("Horas Licenca:"+listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas());
			System.out.println("Anotacoes:"+listaEscalas.get(i).getReferencias().getObsReferencias());
			
			System.out.println();
			
			
		}
		*/
		
		
	}
}
