package com.folha.boot.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.EscalaReposytoty;
import com.folha.boot.Reposytory.PessoaDocumentosReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;
import com.folha.boot.service.util.UtilidadesMatematicas;

@Service
@Transactional(readOnly = false)
public class EscalaAtalhosService {

	
	@Autowired
	private	UtilidadesDeCalendarioEEscala utilidadesDeCalendarioEEscala;
	@Autowired
	private	TurnosService turnosService;
	@Autowired
	private	EscalaCalculosService escalaCalculosService;
	@Autowired
	private RegimesDeTrabalhoService regimesDeTrabalhoService;
	@Autowired
	private TurmasService turmasService;
	
	
	
	// Atalhos Limpar Escala
	public Escala atalhoLimaprEscala(Escala escala) {
		String mes = escala.getIdAnoMesFk().getNomeAnoMes();
		int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
		
		escala.setDia01Fk(turnosService.buscarPorNome(""));
		escala.setDia02Fk(turnosService.buscarPorNome(""));
		escala.setDia03Fk(turnosService.buscarPorNome(""));
		escala.setDia04Fk(turnosService.buscarPorNome(""));
		escala.setDia05Fk(turnosService.buscarPorNome(""));
		escala.setDia06Fk(turnosService.buscarPorNome(""));
		escala.setDia07Fk(turnosService.buscarPorNome(""));
		escala.setDia08Fk(turnosService.buscarPorNome(""));
		escala.setDia09Fk(turnosService.buscarPorNome(""));
		escala.setDia10Fk(turnosService.buscarPorNome(""));
		escala.setDia11Fk(turnosService.buscarPorNome(""));
		escala.setDia12Fk(turnosService.buscarPorNome(""));
		escala.setDia13Fk(turnosService.buscarPorNome(""));
		escala.setDia14Fk(turnosService.buscarPorNome(""));
		escala.setDia15Fk(turnosService.buscarPorNome(""));
		escala.setDia16Fk(turnosService.buscarPorNome(""));
		escala.setDia17Fk(turnosService.buscarPorNome(""));
		escala.setDia18Fk(turnosService.buscarPorNome(""));
		escala.setDia19Fk(turnosService.buscarPorNome(""));
		escala.setDia20Fk(turnosService.buscarPorNome(""));
		escala.setDia21Fk(turnosService.buscarPorNome(""));
		escala.setDia22Fk(turnosService.buscarPorNome(""));
		escala.setDia23Fk(turnosService.buscarPorNome(""));
		escala.setDia24Fk(turnosService.buscarPorNome(""));
		escala.setDia25Fk(turnosService.buscarPorNome(""));
		escala.setDia26Fk(turnosService.buscarPorNome(""));
		escala.setDia27Fk(turnosService.buscarPorNome(""));
		escala.setDia28Fk(turnosService.buscarPorNome(""));
		escala.setDia29Fk(turnosService.buscarPorNome(""));
		escala.setDia30Fk(turnosService.buscarPorNome(""));
		escala.setDia31Fk(turnosService.buscarPorNome(""));
		
	return escala;	
	}
	
	
	
	// Atalhos Diaristas Manha
			public Escala atalhoDiaristasManha(Escala escala) {
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				//Mudando Regime
				escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("D"));
				//Mudando Turma
				escala.setIdTurmaFk( turmasService.buscarPorNomeTurmaUnico("DM"));
				
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  1)==false) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  2)==false) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  3)==false) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  4)==false) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  5)==false) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  6)==false) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  7)==false) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  8)==false) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  9)==false) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 10)==false) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 11)==false) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 12)==false) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 13)==false) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 14)==false) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 15)==false) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 16)==false) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 17)==false) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 18)==false) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 19)==false) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 20)==false) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 21)==false) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 22)==false) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 23)==false) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 24)==false) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 25)==false) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 26)==false) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 27)==false) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 28)==false) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 29)==false) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
				if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 30)==false) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
				if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 31)==false) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
				
			return escala;	
			}
	
			// Atalhos Diaristas Tarde
			public Escala atalhoDiaristasTarde(Escala escala) {
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				//Mudando Regime
				escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("D"));
				//Mudando Turma
				escala.setIdTurmaFk( turmasService.buscarPorNomeTurmaUnico("DT"));
				
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  1)==false) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  2)==false) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  3)==false) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  4)==false) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  5)==false) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  6)==false) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  7)==false) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  8)==false) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  9)==false) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 10)==false) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 11)==false) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 12)==false) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 13)==false) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 14)==false) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 15)==false) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 16)==false) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 17)==false) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 18)==false) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 19)==false) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 20)==false) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 21)==false) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 22)==false) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 23)==false) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 24)==false) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 25)==false) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 26)==false) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 27)==false) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 28)==false) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 29)==false) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
				if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 30)==false) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
				if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 31)==false) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
				
			return escala;	
			}
			
			
			// Atalhos Diaristas Dia
			public Escala atalhoDiaristasDia(Escala escala) {
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				//Mudando Regime
				escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("D"));
				//Mudando Turma
				escala.setIdTurmaFk( turmasService.buscarPorNomeTurmaUnico("DD"));
				
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  1)==false) {escala.setDia01Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  2)==false) {escala.setDia02Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  3)==false) {escala.setDia03Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  4)==false) {escala.setDia04Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  5)==false) {escala.setDia05Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  6)==false) {escala.setDia06Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  7)==false) {escala.setDia07Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  8)==false) {escala.setDia08Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  9)==false) {escala.setDia09Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 10)==false) {escala.setDia10Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 11)==false) {escala.setDia11Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 12)==false) {escala.setDia12Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 13)==false) {escala.setDia13Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 14)==false) {escala.setDia14Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 15)==false) {escala.setDia15Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 16)==false) {escala.setDia16Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 17)==false) {escala.setDia17Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 18)==false) {escala.setDia18Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 19)==false) {escala.setDia19Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 20)==false) {escala.setDia20Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 21)==false) {escala.setDia21Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 22)==false) {escala.setDia22Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 23)==false) {escala.setDia23Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 24)==false) {escala.setDia24Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 25)==false) {escala.setDia25Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 26)==false) {escala.setDia26Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 27)==false) {escala.setDia27Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 28)==false) {escala.setDia28Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 29)==false) {escala.setDia29Fk(turnosService.buscarPorNome("D"));/*D*/}}
				if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 30)==false) {escala.setDia30Fk(turnosService.buscarPorNome("D"));/*D*/}}
				if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 31)==false) {escala.setDia31Fk(turnosService.buscarPorNome("D"));/*D*/}}
				
			return escala;	
			}
			
			
			// Atalhos MT DIAS IMPARES
			public Escala atalhoMTDiasImpares(Escala escala) {
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				
				escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
				
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  1)==false) {escala.setDia01Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  3)==false) {escala.setDia03Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  5)==false) {escala.setDia05Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  7)==false) {escala.setDia07Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  9)==false) {escala.setDia09Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 11)==false) {escala.setDia11Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 13)==false) {escala.setDia13Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 15)==false) {escala.setDia15Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 17)==false) {escala.setDia17Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 19)==false) {escala.setDia19Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 21)==false) {escala.setDia21Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 23)==false) {escala.setDia23Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 25)==false) {escala.setDia25Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 27)==false) {escala.setDia27Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 29)==false) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));/*MT*/}}
				if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 31)==false) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));/*MT*/}}
				
			return escala;	
			}

			// Atalhos MT DIAS PARES
			public Escala atalhoMTDiasPares(Escala escala) {
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				
				escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
				
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  2)==false) {escala.setDia02Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  4)==false) {escala.setDia04Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  6)==false) {escala.setDia06Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  8)==false) {escala.setDia08Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 10)==false) {escala.setDia10Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 12)==false) {escala.setDia12Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 14)==false) {escala.setDia14Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 16)==false) {escala.setDia16Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 18)==false) {escala.setDia18Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 20)==false) {escala.setDia20Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 22)==false) {escala.setDia22Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 24)==false) {escala.setDia24Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 26)==false) {escala.setDia26Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 28)==false) {escala.setDia28Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 30)==false) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));/*MT*/}}
				
			return escala;	
			}

			
			
		
		// Atalhos Ciclo1
		public Escala atalhoCiclo1A(Escala escala) {
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
			
			escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
			
			escala.setDia01Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia02Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia07Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia08Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia13Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia14Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia19Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia20Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia25Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia26Fk(turnosService.buscarPorNome("N"));//N
			
			if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));}//MT
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1B(Escala escala) {
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
			
			escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
			
			escala.setDia02Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia03Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia08Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia09Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia14Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia15Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia20Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia21Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia26Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia27Fk(turnosService.buscarPorNome("N"));//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1C(Escala escala) {
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
			
			escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
			
			escala.setDia03Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia04Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia09Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia10Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia15Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia16Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia21Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia22Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia27Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia28Fk(turnosService.buscarPorNome("N"));//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1D(Escala escala) {
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
			
			escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
			
			escala.setDia04Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia05Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia10Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia11Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia16Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia17Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia22Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia23Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia28Fk(turnosService.buscarPorNome("MT"));//MT
			if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("N"));}//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1E(Escala escala) {
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
			
			escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
			
			escala.setDia05Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia06Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia11Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia12Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia17Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia18Fk(turnosService.buscarPorNome("N"));//N
			
			escala.setDia23Fk(turnosService.buscarPorNome("MT"));//MT
			escala.setDia24Fk(turnosService.buscarPorNome("N"));//N
			
			if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));}//MT
			if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("N"));}//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1F(Escala escala) {
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
			
			escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
			
			escala.setDia01Fk(turnosService.buscarPorNome("N"));//N
			escala.setDia06Fk(turnosService.buscarPorNome("MT"));//MT
			
			escala.setDia07Fk(turnosService.buscarPorNome("N"));//N
			escala.setDia12Fk(turnosService.buscarPorNome("MT"));//MT
			
			escala.setDia13Fk(turnosService.buscarPorNome("N"));//N
			escala.setDia18Fk(turnosService.buscarPorNome("MT"));//MT
			
			escala.setDia19Fk(turnosService.buscarPorNome("N"));//N
			escala.setDia24Fk(turnosService.buscarPorNome("MT"));//MT
			
			escala.setDia25Fk(turnosService.buscarPorNome("N"));//N
			if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));}//MT
			
			if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("N"));}//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
	
		
		
		// Atalhos Ciclo2
				public Escala atalhoCiclo2A(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia01Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia07Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia13Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia19Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia25Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2B(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia02Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia08Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia14Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia20Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia26Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2C(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia03Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia09Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia15Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia21Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia27Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2D(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia04Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia10Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia16Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia22Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia28Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2E(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia05Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia11Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia17Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia23Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2F(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia06Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia12Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia18Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					escala.setDia24Fk(turnosService.buscarPorNome("MTN"));//MTN
					
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
		
				
				
				
				

				// Atalhos Ciclo4
				public Escala atalhoCiclo4A(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia01Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia02Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia03Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia07Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia08Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia09Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia13Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia14Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia15Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia19Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia20Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia21Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia25Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia26Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia27Fk(turnosService.buscarPorNome("N"));//N
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("M"));}//M
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4B(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia02Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia03Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia04Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia08Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia09Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia10Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia14Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia15Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia16Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia20Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia21Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia22Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia26Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia27Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia28Fk(turnosService.buscarPorNome("N"));//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4C(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia03Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia04Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia05Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia09Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia10Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia11Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia15Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia16Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia17Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia21Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia22Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia23Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia27Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia28Fk(turnosService.buscarPorNome("M"));//M
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("N"));}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4D(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia04Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia05Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia06Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia10Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia11Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia12Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia16Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia17Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia18Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia22Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia23Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia24Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia28Fk(turnosService.buscarPorNome("M"));//M
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("M"));}//M
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("N"));}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4E(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia01Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia05Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia06Fk(turnosService.buscarPorNome("M"));//M
					
					escala.setDia07Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia11Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia12Fk(turnosService.buscarPorNome("M"));//M
					
					escala.setDia13Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia17Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia18Fk(turnosService.buscarPorNome("M"));//M
					
					escala.setDia19Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia23Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia24Fk(turnosService.buscarPorNome("M"));//M
					
					escala.setDia25Fk(turnosService.buscarPorNome("N"));//N
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("M"));}//M
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("M"));}//M
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("N"));}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4F(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia01Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia02Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia06Fk(turnosService.buscarPorNome("M"));//M
					
					escala.setDia07Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia08Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia12Fk(turnosService.buscarPorNome("M"));//M
					
					escala.setDia13Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia14Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia18Fk(turnosService.buscarPorNome("M"));//M
					
					escala.setDia19Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia20Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia24Fk(turnosService.buscarPorNome("M"));//M
					
					escala.setDia25Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia26Fk(turnosService.buscarPorNome("N"));//N
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("M"));}//M
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("M"));}//M
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
			
				
				
				
				// Atalhos Ciclo5
				public Escala atalhoCiclo5A(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia01Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia02Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia03Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia07Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia08Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia09Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia13Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia14Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia15Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia19Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia20Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia21Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia25Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia26Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia27Fk(turnosService.buscarPorNome("N"));//N
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("T"));}//T
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5B(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia02Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia03Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia04Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia08Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia09Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia10Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia14Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia15Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia16Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia20Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia21Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia22Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia26Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia27Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia28Fk(turnosService.buscarPorNome("N"));//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5C(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia03Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia04Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia05Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia09Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia10Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia11Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia15Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia16Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia17Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia21Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia22Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia23Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia27Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia28Fk(turnosService.buscarPorNome("T"));//T
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("N"));}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5D(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia04Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia05Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia06Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia10Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia11Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia12Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia16Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia17Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia18Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia22Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia23Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia24Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia28Fk(turnosService.buscarPorNome("T"));//T
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("T"));}//T
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("N"));}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5E(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia01Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia05Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia06Fk(turnosService.buscarPorNome("T"));//T
					
					escala.setDia07Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia11Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia12Fk(turnosService.buscarPorNome("T"));//T
					
					escala.setDia13Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia17Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia18Fk(turnosService.buscarPorNome("T"));//T
					
					escala.setDia19Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia23Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia24Fk(turnosService.buscarPorNome("T"));//T
					
					escala.setDia25Fk(turnosService.buscarPorNome("N"));//N
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("T"));}//T
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("T"));}//T
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("N"));}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5F(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia01Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia02Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia06Fk(turnosService.buscarPorNome("T"));//T
					
					escala.setDia07Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia08Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia12Fk(turnosService.buscarPorNome("T"));//T
					
					escala.setDia13Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia14Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia18Fk(turnosService.buscarPorNome("T"));//T
					
					escala.setDia19Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia20Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia24Fk(turnosService.buscarPorNome("T"));//T
					
					escala.setDia25Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia26Fk(turnosService.buscarPorNome("N"));//N
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("T"));}//T
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("T"));}//T
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				
				
				// Atalhos Ciclo6
				public Escala atalhoCiclo6A(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia01Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia02Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia07Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia08Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia13Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia14Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia19Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia20Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia25Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia26Fk(turnosService.buscarPorNome("MT"));//MT
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));}//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6B(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia02Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia03Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia08Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia09Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia14Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia15Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia20Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia21Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia26Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia27Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6C(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia03Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia04Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia09Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia10Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia15Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia16Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia21Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia22Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia27Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia28Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6D(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia04Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia05Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia10Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia11Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia16Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia17Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia22Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia23Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia28Fk(turnosService.buscarPorNome("MT"));//MT
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));}//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6E(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia05Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia06Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia11Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia12Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia17Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia18Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia23Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia24Fk(turnosService.buscarPorNome("MT"));//MT
					
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));}//MT
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));}//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6F(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia01Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia06Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia07Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia12Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia13Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia18Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia19Fk(turnosService.buscarPorNome("MT"));//MT
					escala.setDia24Fk(turnosService.buscarPorNome("MT"));//MT
					
					escala.setDia25Fk(turnosService.buscarPorNome("MT"));//MT
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));}//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
	
				
				
				
				// Atalhos Ciclo7
				public Escala atalhoCiclo7A(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia01Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia02Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia03Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia07Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia08Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia09Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia13Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia14Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia15Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia19Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia20Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia21Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia25Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia26Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia27Fk(turnosService.buscarPorNome("N"));//N
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("M"));}//M
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7B(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia02Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia03Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia04Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia08Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia09Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia10Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia14Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia15Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia16Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia20Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia21Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia22Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia26Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia27Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia28Fk(turnosService.buscarPorNome("N"));//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7C(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia03Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia04Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia05Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia09Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia10Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia11Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia15Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia16Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia17Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia21Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia22Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia23Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia27Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia28Fk(turnosService.buscarPorNome("T"));//T
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("M"));}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7D(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia04Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia05Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia06Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia10Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia11Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia12Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia16Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia17Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia18Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia22Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia23Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia24Fk(turnosService.buscarPorNome("N"));//N
					
					escala.setDia28Fk(turnosService.buscarPorNome("M"));//M
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("T"));}//T
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("N"));}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7E(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia01Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia05Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia06Fk(turnosService.buscarPorNome("T"));//T
					
					escala.setDia07Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia11Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia12Fk(turnosService.buscarPorNome("T"));//T
					
					escala.setDia13Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia17Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia18Fk(turnosService.buscarPorNome("T"));//T
					
					escala.setDia19Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia23Fk(turnosService.buscarPorNome("M"));//M
					escala.setDia24Fk(turnosService.buscarPorNome("T"));//T
					
					escala.setDia25Fk(turnosService.buscarPorNome("N"));//N
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("M"));}//M
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("T"));}//T
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("N"));}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7F(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					
					escala.setDia01Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia02Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia06Fk(turnosService.buscarPorNome("M"));//M
					
					escala.setDia07Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia08Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia12Fk(turnosService.buscarPorNome("M"));//M
					
					escala.setDia13Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia14Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia18Fk(turnosService.buscarPorNome("M"));//M
					
					escala.setDia19Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia20Fk(turnosService.buscarPorNome("N"));//N
					escala.setDia24Fk(turnosService.buscarPorNome("M"));//M
					
					escala.setDia25Fk(turnosService.buscarPorNome("T"));//T
					escala.setDia26Fk(turnosService.buscarPorNome("N"));//N
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("M"));}//M
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("T"));}//T
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				// Ciclo 8
				public Escala atalhoCiclo8A(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					// Alterando de diarista para plantonista
					if(escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DD") || escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DM")  ||  escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DT")   ) {
						escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					}
					
					String nomeDia = "SEGUNDA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo8B(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					// Alterando de diarista para plantonista
					if(escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DD") || escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DM")  ||  escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DT")   ) {
						escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					}
					
					String nomeDia = "TERCA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo8C(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					// Alterando de diarista para plantonista
					if(escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DD") || escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DM")  ||  escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DT")   ) {
						escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					}
					
					String nomeDia = "QUARTA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo8D(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					// Alterando de diarista para plantonista
					if(escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DD") || escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DM")  ||  escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DT")   ) {
						escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					}
					
					String nomeDia = "QUINTA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo8E(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					// Alterando de diarista para plantonista
					if(escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DD") || escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DM")  ||  escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DT")   ) {
						escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					}
					
					String nomeDia = "SEXTA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo8F(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					// Alterando de diarista para plantonista
					if(escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DD") || escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DM")  ||  escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DT")   ) {
						escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					}
					
					String nomeDia = "SABADO";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo8G(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					// Alterando de diarista para plantonista
					if(escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DD") || escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DM")  ||  escala.getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("DT")   ) {
						escala.setIdRegimeFk(regimesDeTrabalhoService.buscarPorNomeUnico("PL"));
					}
					
					String nomeDia = "DOMINGO";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}




				// Ciclo 9
				public Escala atalhoCiclo9A(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					
					String nomeDia = "SEGUNDA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo9B(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					
					String nomeDia = "TERCA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo9C(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					String nomeDia = "QUARTA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo9D(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					String nomeDia = "QUINTA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo9E(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					String nomeDia = "SEXTA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo9F(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					String nomeDia = "SABADO";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo9G(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					String nomeDia = "DOMINGO";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				
				// Ciclo 10
				public Escala atalhoCiclo10A(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					
					String nomeDia = "SEGUNDA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo10B(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					
					String nomeDia = "TERCA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo10C(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					String nomeDia = "QUARTA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo10D(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					String nomeDia = "QUINTA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo10E(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					String nomeDia = "SEXTA";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/**/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo10F(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					String nomeDia = "SABADO";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo10G(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					String nomeDia = "DOMINGO";
					
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				
				
				
}
