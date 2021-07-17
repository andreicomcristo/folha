package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.domain.Escala;
import com.folha.boot.domain.Turnos;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;

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
	@Autowired
	private RegimeDeTrabalhoTurnoService regimeDeTrabalhoTurnoService;
	
	
	
	// Atalhos Limpar Escala
	public Escala atalhoLimparEscala(Escala escala) {
		
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
				
				// Pegando os turnos compatíveis
				List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
				
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  1)==false) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  2)==false) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  3)==false) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  4)==false) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  5)==false) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  6)==false) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  7)==false) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  8)==false) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  9)==false) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 10)==false) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 11)==false) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) &&  listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 12)==false) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 13)==false) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 14)==false) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 15)==false) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 16)==false) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 17)==false) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 18)==false) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 19)==false) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 20)==false) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 21)==false) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 22)==false) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 23)==false) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 24)==false) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 25)==false) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 26)==false) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 27)==false) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 28)==false) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
				if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 29)==false) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
				if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 30)==false) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
				if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 31)==false) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
				
			return escala;	
			}
	
			// Atalhos Diaristas Tarde
			public Escala atalhoDiaristasTarde(Escala escala) {
				
				// Pegando os turnos compatíveis
				List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
				
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  1)==false) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  2)==false) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  3)==false) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  4)==false) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  5)==false) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  6)==false) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  7)==false) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  8)==false) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  9)==false) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 10)==false) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 11)==false) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 12)==false) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 13)==false) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 14)==false) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 15)==false) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 16)==false) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 17)==false) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 18)==false) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 19)==false) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 20)==false) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 21)==false) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 22)==false) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 23)==false) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 24)==false) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 25)==false) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 26)==false) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 27)==false) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 28)==false) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
				if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 29)==false) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
				if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 30)==false) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
				if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 31)==false) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
				
			return escala;	
			}
			
			
			// Atalhos Diaristas Dia
			public Escala atalhoDiaristasDia(Escala escala) {
				
				// Pegando os turnos compatíveis
				List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
				
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  1)==false) {escala.setDia01Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  2)==false) {escala.setDia02Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  3)==false) {escala.setDia03Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  4)==false) {escala.setDia04Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  5)==false) {escala.setDia05Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  6)==false) {escala.setDia06Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  7)==false) {escala.setDia07Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  8)==false) {escala.setDia08Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  9)==false) {escala.setDia09Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 10)==false) {escala.setDia10Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 11)==false) {escala.setDia11Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 12)==false) {escala.setDia12Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 13)==false) {escala.setDia13Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 14)==false) {escala.setDia14Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 15)==false) {escala.setDia15Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 16)==false) {escala.setDia16Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 17)==false) {escala.setDia17Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 18)==false) {escala.setDia18Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 19)==false) {escala.setDia19Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 20)==false) {escala.setDia20Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 21)==false) {escala.setDia21Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 22)==false) {escala.setDia22Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 23)==false) {escala.setDia23Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 24)==false) {escala.setDia24Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 25)==false) {escala.setDia25Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 26)==false) {escala.setDia26Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 27)==false) {escala.setDia27Fk(turnosService.buscarPorNome("D"));/*D*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 28)==false) {escala.setDia28Fk(turnosService.buscarPorNome("D"));/*D*/}
				if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 29)==false) {escala.setDia29Fk(turnosService.buscarPorNome("D"));/*D*/}}
				if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 30)==false) {escala.setDia30Fk(turnosService.buscarPorNome("D"));/*D*/}}
				if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("D")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 31)==false) {escala.setDia31Fk(turnosService.buscarPorNome("D"));/*D*/}}
				
			return escala;	
			}
			
			
			// Atalhos MT DIAS IMPARES
			public Escala atalhoMTDiasImpares(Escala escala) {
				
				// Pegando os turnos compatíveis
				List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
				
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  1)==false) {escala.setDia01Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  3)==false) {escala.setDia03Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  5)==false) {escala.setDia05Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  7)==false) {escala.setDia07Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  9)==false) {escala.setDia09Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 11)==false) {escala.setDia11Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 13)==false) {escala.setDia13Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 15)==false) {escala.setDia15Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 17)==false) {escala.setDia17Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 19)==false) {escala.setDia19Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 21)==false) {escala.setDia21Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 23)==false) {escala.setDia23Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 25)==false) {escala.setDia25Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 27)==false) {escala.setDia27Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 29)==false) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));/*MT*/}}
				if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 31)==false) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));/*MT*/}}
				
			return escala;	
			}

			// Atalhos MT DIAS PARES
			public Escala atalhoMTDiasPares(Escala escala) {
				
				// Pegando os turnos compatíveis
				List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
				
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  2)==false) {escala.setDia02Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  4)==false) {escala.setDia04Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  6)==false) {escala.setDia06Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes,  8)==false) {escala.setDia08Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 10)==false) {escala.setDia10Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 12)==false) {escala.setDia12Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 14)==false) {escala.setDia14Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 16)==false) {escala.setDia16Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 18)==false) {escala.setDia18Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 20)==false) {escala.setDia20Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 22)==false) {escala.setDia22Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 24)==false) {escala.setDia24Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 26)==false) {escala.setDia26Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 28)==false) {escala.setDia28Fk(turnosService.buscarPorNome("MT"));/*MT*/}
				if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.fimDeSemana(mes, 30)==false) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));/*MT*/}}
				
			return escala;	
			}

			
			
		
		// Atalhos Ciclo1
		public Escala atalhoCiclo1A(Escala escala) {
			
			// Pegando os turnos compatíveis
			List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
			
			String mes = escala.getIdAnoMesFk().getNomeAnoMes();
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia01Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia02Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia07Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia08Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia13Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia14Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia19Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia20Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia25Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia26Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));}}//MT
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1B(Escala escala) {
			
			// Pegando os turnos compatíveis
			List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
			
			String mes = escala.getIdAnoMesFk().getNomeAnoMes();
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia02Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia03Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia08Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia09Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia14Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia15Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia20Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia21Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia26Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia27Fk(turnosService.buscarPorNome("N"));}//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1C(Escala escala) {
			
			// Pegando os turnos compatíveis
			List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
			
			String mes = escala.getIdAnoMesFk().getNomeAnoMes();
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia03Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia04Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia09Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia10Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia15Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia16Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia21Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia22Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia27Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia28Fk(turnosService.buscarPorNome("N"));}//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1D(Escala escala) {
			
			// Pegando os turnos compatíveis
			List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
			
			String mes = escala.getIdAnoMesFk().getNomeAnoMes();
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia04Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia05Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia10Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia11Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia16Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia17Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia22Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia23Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia28Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("N"));}}//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1E(Escala escala) {
			
			// Pegando os turnos compatíveis
			List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
			
			String mes = escala.getIdAnoMesFk().getNomeAnoMes();
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia05Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia06Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia11Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia12Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia17Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia18Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia23Fk(turnosService.buscarPorNome("MT"));}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia24Fk(turnosService.buscarPorNome("N"));}//N
			
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));}}//MT
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("N"));}}//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1F(Escala escala) {
			
			// Pegando os turnos compatíveis
			List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
			
			String mes = escala.getIdAnoMesFk().getNomeAnoMes();
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
			
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia01Fk(turnosService.buscarPorNome("N"));}//N
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia06Fk(turnosService.buscarPorNome("MT"));}//MT
			
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia07Fk(turnosService.buscarPorNome("N"));}//N
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia12Fk(turnosService.buscarPorNome("MT"));}//MT
			
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia13Fk(turnosService.buscarPorNome("N"));}//N
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia18Fk(turnosService.buscarPorNome("MT"));}//MT
			
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia19Fk(turnosService.buscarPorNome("N"));}//N
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia24Fk(turnosService.buscarPorNome("MT"));}//MT
			
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia25Fk(turnosService.buscarPorNome("N"));}//N
			if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));}}//MT
			
			if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("N"));}}//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
	
		
		
		// Atalhos Ciclo2
				public Escala atalhoCiclo2A(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));}}//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2B(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2C(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2D(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2E(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));}}//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2F(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));}//MTN
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN"))) {if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));}}//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
		
				
				
				
				

				// Atalhos Ciclo4
				public Escala atalhoCiclo4A(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia01Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia02Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia03Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia07Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia08Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia09Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia13Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia14Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia15Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia19Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia20Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia21Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia25Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia26Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia27Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("M"));}}//M
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4B(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia02Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia03Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia04Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia08Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia09Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia10Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia14Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia15Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia16Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia20Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia21Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia22Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia26Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia27Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia28Fk(turnosService.buscarPorNome("N"));}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4C(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia03Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia04Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia05Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia09Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia10Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia11Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia15Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia16Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia17Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia21Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia22Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia23Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia27Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia28Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("N"));}}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4D(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia04Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia05Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia06Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia10Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia11Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia12Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia16Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia17Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia18Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia22Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia23Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia24Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia28Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("M"));}}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("N"));}}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4E(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia01Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia05Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia06Fk(turnosService.buscarPorNome("M"));}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia07Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia11Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia12Fk(turnosService.buscarPorNome("M"));}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia13Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia17Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia18Fk(turnosService.buscarPorNome("M"));}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia19Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia23Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia24Fk(turnosService.buscarPorNome("M"));}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia25Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("M"));}}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("M"));}}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("N"));}}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4F(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia01Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia02Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia06Fk(turnosService.buscarPorNome("M"));}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia07Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia08Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia12Fk(turnosService.buscarPorNome("M"));}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia13Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia14Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia18Fk(turnosService.buscarPorNome("M"));}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia19Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia20Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia24Fk(turnosService.buscarPorNome("M"));}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia25Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia26Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("M"));}}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("M"));}}//M
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
			
				
				
				
				// Atalhos Ciclo5
				public Escala atalhoCiclo5A(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia01Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia02Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia03Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia07Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia08Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia09Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia13Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia14Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia15Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia19Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia20Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia21Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia25Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia26Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia27Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("T"));}}//T
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5B(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia02Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia03Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia04Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia08Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia09Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia10Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia14Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia15Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia16Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia20Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia21Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia22Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia26Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia27Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia28Fk(turnosService.buscarPorNome("N"));}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5C(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia03Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia04Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia05Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia09Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia10Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia11Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia15Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia16Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia17Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia21Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia22Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia23Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia27Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia28Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("N"));}}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5D(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia04Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia05Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia06Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia10Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia11Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia12Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia16Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia17Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia18Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia22Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia23Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia24Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia28Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("T"));}}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("N"));}}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5E(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia01Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia05Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia06Fk(turnosService.buscarPorNome("T"));}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia07Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia11Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia12Fk(turnosService.buscarPorNome("T"));}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia13Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia17Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia18Fk(turnosService.buscarPorNome("T"));}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia19Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia23Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia24Fk(turnosService.buscarPorNome("T"));}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia25Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("T"));}}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("T"));}}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("N"));}}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5F(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia01Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia02Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia06Fk(turnosService.buscarPorNome("T"));}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia07Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia08Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia12Fk(turnosService.buscarPorNome("T"));}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia13Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia14Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia18Fk(turnosService.buscarPorNome("T"));}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia19Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia20Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia24Fk(turnosService.buscarPorNome("T"));}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia25Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia26Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("T"));}}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("T"));}}//T
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				
				
				// Atalhos Ciclo6
				public Escala atalhoCiclo6A(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia01Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia02Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia07Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia08Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia13Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia14Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia19Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia20Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia25Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia26Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));}}//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6B(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia02Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia03Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia08Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia09Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia14Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia15Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia20Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia21Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia26Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia27Fk(turnosService.buscarPorNome("MT"));}//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6C(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia03Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia04Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia09Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia10Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia15Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia16Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia21Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia22Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia27Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia28Fk(turnosService.buscarPorNome("MT"));}//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6D(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia04Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia05Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia10Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia11Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia16Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia17Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia22Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia23Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia28Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));}}//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6E(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia05Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia06Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia11Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia12Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia17Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia18Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia23Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia24Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));}}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));}}//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6F(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia01Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia06Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia07Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia12Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia13Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia18Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia19Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia24Fk(turnosService.buscarPorNome("MT"));}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {escala.setDia25Fk(turnosService.buscarPorNome("MT"));}//MT
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));}}//MT
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT"))) {if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));}}//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
	
				
				
				
				// Atalhos Ciclo7
				public Escala atalhoCiclo7A(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia01Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia02Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia03Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia07Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia08Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia09Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia13Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia14Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia15Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia19Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia20Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia21Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia25Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia26Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia27Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("M"));}}//M
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7B(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia02Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia03Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia04Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia08Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia09Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia10Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia14Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia15Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia16Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia20Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia21Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia22Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia26Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia27Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia28Fk(turnosService.buscarPorNome("N"));}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7C(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia03Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia04Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia05Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia09Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia10Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia11Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia15Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia16Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia17Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia21Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia22Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia23Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia27Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia28Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("N"));}}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7D(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia04Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia05Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia06Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia10Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia11Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia12Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia16Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia17Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia18Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia22Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia23Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia24Fk(turnosService.buscarPorNome("N"));}//N
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia28Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("T"));}}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("N"));}}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7E(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia01Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia05Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia06Fk(turnosService.buscarPorNome("T"));}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia07Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia11Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia12Fk(turnosService.buscarPorNome("T"));}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia13Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia17Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia18Fk(turnosService.buscarPorNome("T"));}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia19Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia23Fk(turnosService.buscarPorNome("M"));}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia24Fk(turnosService.buscarPorNome("T"));}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia25Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {if(qtdDiasNoMes>=29) {escala.setDia29Fk(turnosService.buscarPorNome("M"));}}//M
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("T"));}}//T
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("N"));}}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7F(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia01Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia02Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia06Fk(turnosService.buscarPorNome("M"));}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia07Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia08Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia12Fk(turnosService.buscarPorNome("M"));}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia13Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia14Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia18Fk(turnosService.buscarPorNome("M"));}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia19Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia20Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {escala.setDia24Fk(turnosService.buscarPorNome("M"));}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {escala.setDia25Fk(turnosService.buscarPorNome("T"));}//T
					if( listaTurnos.contains(turnosService.buscarPorNome("N"))) {escala.setDia26Fk(turnosService.buscarPorNome("N"));}//N
					if( listaTurnos.contains(turnosService.buscarPorNome("M"))) {if(qtdDiasNoMes>=30) {escala.setDia30Fk(turnosService.buscarPorNome("M"));}}//M
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T"))) {if(qtdDiasNoMes==31) {escala.setDia31Fk(turnosService.buscarPorNome("T"));}}//T
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				// Ciclo 8
				public Escala atalhoCiclo8A(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "SEGUNDA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo8B(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "TERCA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo8C(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "QUARTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo8D(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "QUINTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo8E(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "SEXTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo8F(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "SABADO";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo8G(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "DOMINGO";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MTN")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MTN"));/*MTN*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}




				// Ciclo 9
				public Escala atalhoCiclo9A(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					
					String nomeDia = "SEGUNDA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo9B(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					
					String nomeDia = "TERCA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo9C(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "QUARTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo9D(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "QUINTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo9E(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "SEXTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo9F(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "SABADO";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo9G(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "DOMINGO";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("M"));/*M*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("M"));/*M*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("M"));/*M*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("M")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("M"));/*M*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				
				// Ciclo 10
				public Escala atalhoCiclo10A(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					
					String nomeDia = "SEGUNDA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo10B(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					
					String nomeDia = "TERCA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo10C(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "QUARTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo10D(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "QUINTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo10E(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "SEXTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/**/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo10F(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "SABADO";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo10G(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "DOMINGO";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("T"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("T"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("T"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("T")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("T"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				// Ciclo 11
				public Escala atalhoCiclo11A(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					
					String nomeDia = "SEGUNDA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MT"));/*MT*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));/*MT*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));/*MT*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));/*MT*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo11B(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					
					String nomeDia = "TERCA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo11C(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "QUARTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo11D(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "QUINTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo11E(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "SEXTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MT"));/**/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo11F(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "SABADO";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo11G(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "DOMINGO";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("MT"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("MT")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("MT"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				
				// Ciclo 12
				public Escala atalhoCiclo12A(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					
					String nomeDia = "SEGUNDA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("N"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("N"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("N"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("N"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo12B(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					
					String nomeDia = "TERCA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("N"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("N"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("N"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("N"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo12C(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "QUARTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("N"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("N"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("N"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("N"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo12D(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "QUINTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("N"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("N"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("N"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("N"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo12E(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "SEXTA";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("N"));/**/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("N"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("N"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("N"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("N"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo12F(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "SABADO";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("N"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("N"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("N"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("N"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				public Escala atalhoCiclo12G(Escala escala) {
					
					// Pegando os turnos compatíveis
					List<Turnos> listaTurnos = regimeDeTrabalhoTurnoService.buscarPorRegimesEUnidadeEFolha(escala);
					
					String mes = escala.getIdAnoMesFk().getNomeAnoMes();
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
					
					String nomeDia = "DOMINGO";
					
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  1).equalsIgnoreCase(nomeDia)) {escala.setDia01Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  2).equalsIgnoreCase(nomeDia)) {escala.setDia02Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  3).equalsIgnoreCase(nomeDia)) {escala.setDia03Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  4).equalsIgnoreCase(nomeDia)) {escala.setDia04Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  5).equalsIgnoreCase(nomeDia)) {escala.setDia05Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  6).equalsIgnoreCase(nomeDia)) {escala.setDia06Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  7).equalsIgnoreCase(nomeDia)) {escala.setDia07Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  8).equalsIgnoreCase(nomeDia)) {escala.setDia08Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(),  9).equalsIgnoreCase(nomeDia)) {escala.setDia09Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 10).equalsIgnoreCase(nomeDia)) {escala.setDia10Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 11).equalsIgnoreCase(nomeDia)) {escala.setDia11Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 12).equalsIgnoreCase(nomeDia)) {escala.setDia12Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 13).equalsIgnoreCase(nomeDia)) {escala.setDia13Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 14).equalsIgnoreCase(nomeDia)) {escala.setDia14Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 15).equalsIgnoreCase(nomeDia)) {escala.setDia15Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 16).equalsIgnoreCase(nomeDia)) {escala.setDia16Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 17).equalsIgnoreCase(nomeDia)) {escala.setDia17Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 18).equalsIgnoreCase(nomeDia)) {escala.setDia18Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 19).equalsIgnoreCase(nomeDia)) {escala.setDia19Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 20).equalsIgnoreCase(nomeDia)) {escala.setDia20Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 21).equalsIgnoreCase(nomeDia)) {escala.setDia21Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 22).equalsIgnoreCase(nomeDia)) {escala.setDia22Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 23).equalsIgnoreCase(nomeDia)) {escala.setDia23Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 24).equalsIgnoreCase(nomeDia)) {escala.setDia24Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 25).equalsIgnoreCase(nomeDia)) {escala.setDia25Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 26).equalsIgnoreCase(nomeDia)) {escala.setDia26Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 27).equalsIgnoreCase(nomeDia)) {escala.setDia27Fk(turnosService.buscarPorNome("N"));/*T*/}
					if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 28).equalsIgnoreCase(nomeDia)) {escala.setDia28Fk(turnosService.buscarPorNome("N"));/*T*/}
					if(qtdDiasNoMes>=29) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 29).equalsIgnoreCase(nomeDia)) {escala.setDia29Fk(turnosService.buscarPorNome("N"));/*T*/}}
					if(qtdDiasNoMes>=30) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 30).equalsIgnoreCase(nomeDia)) {escala.setDia30Fk(turnosService.buscarPorNome("N"));/*T*/}}
					if(qtdDiasNoMes==31) {if( listaTurnos.contains(turnosService.buscarPorNome("N")) && utilidadesDeCalendarioEEscala.getDiaSemanaPorAnoMesEDia(escala.getIdAnoMesFk().getNomeAnoMes(), 31).equalsIgnoreCase(nomeDia)) {escala.setDia31Fk(turnosService.buscarPorNome("N"));/*T*/}}
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}

				
				
}
