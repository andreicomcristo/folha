package com.folha.boot.service.calculos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.EscalaReposytoty;
import com.folha.boot.Reposytory.FuncionariosFeriasPeriodosReposytory;
import com.folha.boot.Reposytory.FuncionariosLicencasCidReposytory;
import com.folha.boot.Reposytory.FuncionariosLicencasReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.FuncionariosFerias;
import com.folha.boot.domain.FuncionariosFeriasPeriodos;
import com.folha.boot.domain.FuncionariosLicencas;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.models.calculos.EscalasNoMes;
import com.folha.boot.domain.models.calculos.FeriasNoMes;
import com.folha.boot.domain.models.calculos.LicencasNoMes;
import com.folha.boot.domain.models.calculos.ReferenciasDeEscala;
import com.folha.boot.service.EscalaPosTransparenciaService;
import com.folha.boot.service.EscalaService;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;

@Service
@Transactional(readOnly = false)
public class CalculosColetaDeDadosService {

	@Autowired
	EscalaService escalaService;
	@Autowired
	private  UtilidadesDeCalendarioEEscala utilidadesDeCalendarioEEscala;
	@Autowired
	private  FuncionariosFeriasPeriodosReposytory funcionariosFeriasPeriodosReposytory;
	@Autowired
	private  FuncionariosLicencasReposytory funcionariosLicencasReposytory;
	@Autowired
	private  EscalaReposytoty escalaReposytoty;

	
	@Transactional(readOnly = true)
	public List<EscalasNoMes> buscarEscalasPorMes(AnoMes anoMes){
		
		List<Escala> lista = escalaReposytoty.findByIdAnoMesFkAndDtCancelamentoIsNullOrderByIdCoordenacaoFkIdLocalidadeFkIdUnidadeFkAscIdTipoFolhaFkAscIdFuncionarioFkIdPessoaFkNomeAsc(anoMes); 
		List<EscalasNoMes> listaResposta = new ArrayList<>();
		for(int i=0;i<lista.size();i++) {
			EscalasNoMes f= new EscalasNoMes();
			ReferenciasDeEscala r = new ReferenciasDeEscala();
			
			r.setCodigoDiferenciado(lista.get(i).getIdCodigoDiferenciadoFk());
			r.setCpf(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getCpf());
			r.setNome(lista.get(i).getIdFuncionarioFk().getIdPessoaFk().getNome());
			r.setDiasFerias(0);
			r.setDiasLicenca(0);
			r.setHorasFeriasDescontadas(0);
			r.setHorasLicencaDescontadas(0);
			r.setMatricula(lista.get(i).getIdFuncionarioFk().getMatricula());
			r.setObsReferencias("");
			r.setRegimesDeTrabalho(lista.get(i).getIdRegimeFk());
			r.setTiposDeFolha(lista.get(i).getIdTipoFolhaFk());
			r.setUnidades(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk());
			r.setVinculos(lista.get(i).getIdFuncionarioFk().getIdVinculoAtualFk());
			r.setUnidadesRegime(lista.get(i).getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk().getIdUnidadesRegimeFk());
			
			f.setEscala( escalaService.converteDeEscalaParaEscalaComId(lista.get(i)) );
			f.setReferencias(r);
			listaResposta.add(f);
		}
		return listaResposta;
	}
	
	
	
	@Transactional(readOnly = true)
	public List<FeriasNoMes> buscarFeriasPorMes(AnoMes anoMes){
		
		@SuppressWarnings("deprecation")
		Date dataInicial = new Date( Integer.parseInt(anoMes.getNomeAnoMes().substring(0, 4))-1900 , Integer.parseInt(anoMes.getNomeAnoMes().substring(4, 6))-1   ,  1 );
		int diaFinala = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(anoMes.getNomeAnoMes());
		@SuppressWarnings("deprecation")
		Date dataFinal = new Date( Integer.parseInt(anoMes.getNomeAnoMes().substring(0, 4))-1900 , Integer.parseInt(anoMes.getNomeAnoMes().substring(4, 6))-1   ,  diaFinala );
		List<FuncionariosFeriasPeriodos> lista = funcionariosFeriasPeriodosReposytory.findByDtInicialLessThanEqualAndDtFinalGreaterThanEqualAndDtCancelamentoIsNullOrderByIdFeriasFkIdFuncionarioFkIdPessoaFkCpfAsc(dataFinal, dataInicial); 
		List<FeriasNoMes> listaResposta = new ArrayList<>();
		for(int i=0;i<lista.size();i++) {
			FeriasNoMes f= new FeriasNoMes();
			int diaInicial = dataInicial.getDate();
			if(dataInicial.before(lista.get(i).getDtInicial())) {diaInicial = lista.get(i).getDtInicial().getDate();}
			int diaFinal = dataFinal.getDate();
			if(lista.get(i).getDtFinal().before(dataFinal)) {diaFinal = lista.get(i).getDtFinal().getDate();}
			f.setFuncionariosFeriasPeriodos(lista.get(i));
			f.setDiaInicial(diaInicial);
			f.setDiaFinal(diaFinal);
			f.setQtdDias((diaFinal-diaInicial)+1);
			listaResposta.add(f);
		}
		return listaResposta;
	}
	

	
	@Transactional(readOnly = true)
	public List<LicencasNoMes> buscarLicencasPorMes(AnoMes anoMes){
		
		@SuppressWarnings("deprecation")
		Date dataInicial = new Date( Integer.parseInt(anoMes.getNomeAnoMes().substring(0, 4))-1900 , Integer.parseInt(anoMes.getNomeAnoMes().substring(4, 6))-1   ,  1 );
		int diaFinala = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(anoMes.getNomeAnoMes());
		@SuppressWarnings("deprecation")
		Date dataFinal = new Date( Integer.parseInt(anoMes.getNomeAnoMes().substring(0, 4))-1900 , Integer.parseInt(anoMes.getNomeAnoMes().substring(4, 6))-1   ,  diaFinala );
		List<FuncionariosLicencas> lista = funcionariosLicencasReposytory.findByDtInicialLessThanEqualAndDtFinalGreaterThanEqualAndDtCancelamentoIsNullOrderByIdFuncionarioFkIdPessoaFkCpfAsc(dataFinal, dataInicial); 
		List<LicencasNoMes> listaResposta = new ArrayList<>();
		for(int i=0;i<lista.size();i++) {
			LicencasNoMes f= new LicencasNoMes();
			int diaInicial = dataInicial.getDate();
			if(dataInicial.before(lista.get(i).getDtInicial())) {diaInicial = lista.get(i).getDtInicial().getDate();}
			int diaFinal = dataFinal.getDate();
			if(lista.get(i).getDtFinal().before(dataFinal)) {diaFinal = lista.get(i).getDtFinal().getDate();}
			f.setFuncionariosLicencas(lista.get(i));
			f.setDiaInicial(diaInicial);
			f.setDiaFinal(diaFinal);
			f.setQtdDias((diaFinal-diaInicial)+1);
			listaResposta.add(f);
		}
		return listaResposta;
	}

	
	
	
}
