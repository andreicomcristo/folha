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
	private EscalaReposytoty reposytory;
	@Autowired
	private	UtilidadesDeCalendarioEEscala utilidadesDeCalendarioEEscala;
	@Autowired
	private	UtilidadesMatematicas utilidadesMatematicas;
	@Autowired
	private	EscalaCalculosService escalaCalculosService;
	
	
	
	
	
	// Atalhos Diaristas Manha
			public Escala atalhoDiaristasManha(Escala escala) {
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  1)==false) {escala.setDia01Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  2)==false) {escala.setDia02Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  3)==false) {escala.setDia03Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  4)==false) {escala.setDia04Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  5)==false) {escala.setDia05Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  6)==false) {escala.setDia06Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  7)==false) {escala.setDia07Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  8)==false) {escala.setDia08Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  9)==false) {escala.setDia09Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 10)==false) {escala.setDia10Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 11)==false) {escala.setDia11Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 12)==false) {escala.setDia12Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 13)==false) {escala.setDia13Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 14)==false) {escala.setDia14Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 15)==false) {escala.setDia15Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 16)==false) {escala.setDia16Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 17)==false) {escala.setDia17Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 18)==false) {escala.setDia18Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 19)==false) {escala.setDia19Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 20)==false) {escala.setDia20Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 21)==false) {escala.setDia21Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 22)==false) {escala.setDia22Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 23)==false) {escala.setDia23Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 24)==false) {escala.setDia24Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 25)==false) {escala.setDia25Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 26)==false) {escala.setDia26Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 27)==false) {escala.setDia27Fk(null);/*M*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 28)==false) {escala.setDia28Fk(null);/*M*/}
				if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 29)==false) {escala.setDia29Fk(null);/*M*/}}
				if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 30)==false) {escala.setDia30Fk(null);/*M*/}}
				if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 31)==false) {escala.setDia31Fk(null);/*M*/}}
				
			return escala;	
			}
	
			// Atalhos Diaristas Tarde
			public Escala atalhoDiaristasTarde(Escala escala) {
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  1)==false) {escala.setDia01Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  2)==false) {escala.setDia02Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  3)==false) {escala.setDia03Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  4)==false) {escala.setDia04Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  5)==false) {escala.setDia05Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  6)==false) {escala.setDia06Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  7)==false) {escala.setDia07Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  8)==false) {escala.setDia08Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  9)==false) {escala.setDia09Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 10)==false) {escala.setDia10Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 11)==false) {escala.setDia11Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 12)==false) {escala.setDia12Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 13)==false) {escala.setDia13Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 14)==false) {escala.setDia14Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 15)==false) {escala.setDia15Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 16)==false) {escala.setDia16Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 17)==false) {escala.setDia17Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 18)==false) {escala.setDia18Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 19)==false) {escala.setDia19Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 20)==false) {escala.setDia20Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 21)==false) {escala.setDia21Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 22)==false) {escala.setDia22Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 23)==false) {escala.setDia23Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 24)==false) {escala.setDia24Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 25)==false) {escala.setDia25Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 26)==false) {escala.setDia26Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 27)==false) {escala.setDia27Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 28)==false) {escala.setDia28Fk(null);/*T*/}
				if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 29)==false) {escala.setDia29Fk(null);/*T*/}}
				if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 30)==false) {escala.setDia30Fk(null);/*T*/}}
				if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 31)==false) {escala.setDia31Fk(null);/*T*/}}
				
			return escala;	
			}
			
			
			// Atalhos Diaristas Dia
			public Escala atalhoDiaristasDia(Escala escala) {
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  1)==false) {escala.setDia01Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  2)==false) {escala.setDia02Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  3)==false) {escala.setDia03Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  4)==false) {escala.setDia04Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  5)==false) {escala.setDia05Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  6)==false) {escala.setDia06Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  7)==false) {escala.setDia07Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  8)==false) {escala.setDia08Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  9)==false) {escala.setDia09Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 10)==false) {escala.setDia10Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 11)==false) {escala.setDia11Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 12)==false) {escala.setDia12Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 13)==false) {escala.setDia13Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 14)==false) {escala.setDia14Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 15)==false) {escala.setDia15Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 16)==false) {escala.setDia16Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 17)==false) {escala.setDia17Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 18)==false) {escala.setDia18Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 19)==false) {escala.setDia19Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 20)==false) {escala.setDia20Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 21)==false) {escala.setDia21Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 22)==false) {escala.setDia22Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 23)==false) {escala.setDia23Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 24)==false) {escala.setDia24Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 25)==false) {escala.setDia25Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 26)==false) {escala.setDia26Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 27)==false) {escala.setDia27Fk(null);/*D*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 28)==false) {escala.setDia28Fk(null);/*D*/}
				if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 29)==false) {escala.setDia29Fk(null);/*D*/}}
				if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 30)==false) {escala.setDia30Fk(null);/*D*/}}
				if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 31)==false) {escala.setDia31Fk(null);/*D*/}}
				
			return escala;	
			}
			
			
			// Atalhos MT DIAS IMPARES
			public Escala atalhoMTDiasImpares(Escala escala) {
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  1)==false) {escala.setDia01Fk(null);/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  3)==false) {escala.setDia03Fk(null);/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  5)==false) {escala.setDia05Fk(null);/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  7)==false) {escala.setDia07Fk(null);/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  9)==false) {escala.setDia09Fk(null);/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 11)==false) {escala.setDia11Fk(null);/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 13)==false) {escala.setDia13Fk(null);/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 15)==false) {escala.setDia15Fk(null);/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 17)==false) {escala.setDia17Fk(null);/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 19)==false) {escala.setDia19Fk(null);/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 21)==false) {escala.setDia21Fk(null);/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 23)==false) {escala.setDia23Fk(null);/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 25)==false) {escala.setDia25Fk(null);/*MT*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 27)==false) {escala.setDia27Fk(null);/*MT*/}
				if(qtdDiasNoMes>=29) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 29)==false) {escala.setDia29Fk(null);/*MT*/}}
				if(qtdDiasNoMes==31) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 31)==false) {escala.setDia31Fk(null);/*MT*/}}
				
			return escala;	
			}

			// Atalhos MT DIAS PARES
			public Escala atalhoMTDiasPares(Escala escala) {
				String mes = escala.getIdAnoMesFk().getNomeAnoMes();
				int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(mes);
				
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  2)==false) {escala.setDia02Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  4)==false) {escala.setDia04Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  6)==false) {escala.setDia06Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes,  8)==false) {escala.setDia08Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 10)==false) {escala.setDia10Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 12)==false) {escala.setDia12Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 14)==false) {escala.setDia14Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 16)==false) {escala.setDia16Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 18)==false) {escala.setDia18Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 20)==false) {escala.setDia20Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 22)==false) {escala.setDia22Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 24)==false) {escala.setDia24Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 26)==false) {escala.setDia26Fk(null);/*T*/}
				if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 28)==false) {escala.setDia28Fk(null);/*T*/}
				if(qtdDiasNoMes>=30) {if(utilidadesDeCalendarioEEscala.fimDeSemana(mes, 30)==false) {escala.setDia30Fk(null);/*T*/}}
				
			return escala;	
			}

			
			
		
		// Atalhos Ciclo1
		public Escala atalhoCiclo1A(Escala escala) {
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
			
			escala.setDia01Fk(null);//MT
			escala.setDia02Fk(null);//N
			
			escala.setDia07Fk(null);//MT
			escala.setDia08Fk(null);//N
			
			escala.setDia13Fk(null);//MT
			escala.setDia14Fk(null);//N
			
			escala.setDia19Fk(null);//MT
			escala.setDia20Fk(null);//N
			
			escala.setDia25Fk(null);//MT
			escala.setDia26Fk(null);//N
			
			if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//MT
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1B(Escala escala) {
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
			
			escala.setDia02Fk(null);//MT
			escala.setDia03Fk(null);//N
			
			escala.setDia08Fk(null);//MT
			escala.setDia09Fk(null);//N
			
			escala.setDia14Fk(null);//MT
			escala.setDia15Fk(null);//N
			
			escala.setDia20Fk(null);//MT
			escala.setDia21Fk(null);//N
			
			escala.setDia26Fk(null);//MT
			escala.setDia27Fk(null);//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1C(Escala escala) {
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
			
			escala.setDia03Fk(null);//MT
			escala.setDia04Fk(null);//N
			
			escala.setDia09Fk(null);//MT
			escala.setDia10Fk(null);//N
			
			escala.setDia15Fk(null);//MT
			escala.setDia16Fk(null);//N
			
			escala.setDia21Fk(null);//MT
			escala.setDia22Fk(null);//N
			
			escala.setDia27Fk(null);//MT
			escala.setDia28Fk(null);//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1D(Escala escala) {
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
			
			escala.setDia04Fk(null);//MT
			escala.setDia05Fk(null);//N
			
			escala.setDia10Fk(null);//MT
			escala.setDia11Fk(null);//N
			
			escala.setDia16Fk(null);//MT
			escala.setDia17Fk(null);//N
			
			escala.setDia22Fk(null);//MT
			escala.setDia23Fk(null);//N
			
			escala.setDia28Fk(null);//MT
			if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1E(Escala escala) {
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
			
			escala.setDia05Fk(null);//MT
			escala.setDia06Fk(null);//N
			
			escala.setDia11Fk(null);//MT
			escala.setDia12Fk(null);//N
			
			escala.setDia17Fk(null);//MT
			escala.setDia18Fk(null);//N
			
			escala.setDia23Fk(null);//MT
			escala.setDia24Fk(null);//N
			
			if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//MT
			if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
		
		public Escala atalhoCiclo1F(Escala escala) {
			int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
			
			escala.setDia01Fk(null);//N
			escala.setDia06Fk(null);//MT
			
			escala.setDia07Fk(null);//N
			escala.setDia12Fk(null);//MT
			
			escala.setDia13Fk(null);//N
			escala.setDia18Fk(null);//MT
			
			escala.setDia19Fk(null);//N
			escala.setDia24Fk(null);//MT
			
			escala.setDia25Fk(null);//N
			if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//MT
			
			if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//N
			
			escala = escalaCalculosService.calcularDadosEscala(escala);
			
		return escala;	
		}
	
		
		
		// Atalhos Ciclo2
				public Escala atalhoCiclo2A(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia01Fk(null);//MTN
					
					escala.setDia07Fk(null);//MTN
					
					escala.setDia13Fk(null);//MTN
					
					escala.setDia19Fk(null);//MTN
					
					escala.setDia25Fk(null);//MTN
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2B(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia02Fk(null);//MTN
					
					escala.setDia08Fk(null);//MTN
					
					escala.setDia14Fk(null);//MTN
					
					escala.setDia20Fk(null);//MTN
					
					escala.setDia26Fk(null);//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2C(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia03Fk(null);//MTN
					
					escala.setDia09Fk(null);//MTN
					
					escala.setDia15Fk(null);//MTN
					
					escala.setDia21Fk(null);//MTN
					
					escala.setDia27Fk(null);//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2D(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia04Fk(null);//MTN
					
					escala.setDia10Fk(null);//MTN
					
					escala.setDia16Fk(null);//MTN
					
					escala.setDia22Fk(null);//MTN
					
					escala.setDia28Fk(null);//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2E(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia05Fk(null);//MTN
					
					escala.setDia11Fk(null);//MTN
					
					escala.setDia17Fk(null);//MTN
					
					escala.setDia23Fk(null);//MTN
					
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo2F(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia06Fk(null);//MTN
					
					escala.setDia12Fk(null);//MTN
					
					escala.setDia18Fk(null);//MTN
					
					escala.setDia24Fk(null);//MTN
					
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//MTN
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
		
				
				
				
				

				// Atalhos Ciclo4
				public Escala atalhoCiclo4A(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia01Fk(null);//M
					escala.setDia02Fk(null);//M
					escala.setDia03Fk(null);//N
					
					escala.setDia07Fk(null);//M
					escala.setDia08Fk(null);//M
					escala.setDia09Fk(null);//N
					
					escala.setDia13Fk(null);//M
					escala.setDia14Fk(null);//M
					escala.setDia15Fk(null);//N
					
					escala.setDia19Fk(null);//M
					escala.setDia20Fk(null);//M
					escala.setDia21Fk(null);//N
					
					escala.setDia25Fk(null);//M
					escala.setDia26Fk(null);//M
					escala.setDia27Fk(null);//N
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//M
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4B(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia02Fk(null);//M
					escala.setDia03Fk(null);//M
					escala.setDia04Fk(null);//N
					
					escala.setDia08Fk(null);//M
					escala.setDia09Fk(null);//M
					escala.setDia10Fk(null);//N
					
					escala.setDia14Fk(null);//M
					escala.setDia15Fk(null);//M
					escala.setDia16Fk(null);//N
					
					escala.setDia20Fk(null);//M
					escala.setDia21Fk(null);//M
					escala.setDia22Fk(null);//N
					
					escala.setDia26Fk(null);//M
					escala.setDia27Fk(null);//M
					escala.setDia28Fk(null);//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4C(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia03Fk(null);//M
					escala.setDia04Fk(null);//M
					escala.setDia05Fk(null);//N
					
					escala.setDia09Fk(null);//M
					escala.setDia10Fk(null);//M
					escala.setDia11Fk(null);//N
					
					escala.setDia15Fk(null);//M
					escala.setDia16Fk(null);//M
					escala.setDia17Fk(null);//N
					
					escala.setDia21Fk(null);//M
					escala.setDia22Fk(null);//M
					escala.setDia23Fk(null);//N
					
					escala.setDia27Fk(null);//M
					escala.setDia28Fk(null);//M
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4D(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia04Fk(null);//M
					escala.setDia05Fk(null);//M
					escala.setDia06Fk(null);//N
					
					escala.setDia10Fk(null);//M
					escala.setDia11Fk(null);//M
					escala.setDia12Fk(null);//N
					
					escala.setDia16Fk(null);//M
					escala.setDia17Fk(null);//M
					escala.setDia18Fk(null);//N
					
					escala.setDia22Fk(null);//M
					escala.setDia23Fk(null);//M
					escala.setDia24Fk(null);//N
					
					escala.setDia28Fk(null);//M
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//M
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4E(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia01Fk(null);//N
					escala.setDia05Fk(null);//M
					escala.setDia06Fk(null);//M
					
					escala.setDia07Fk(null);//N
					escala.setDia11Fk(null);//M
					escala.setDia12Fk(null);//M
					
					escala.setDia13Fk(null);//N
					escala.setDia17Fk(null);//M
					escala.setDia18Fk(null);//M
					
					escala.setDia19Fk(null);//N
					escala.setDia23Fk(null);//M
					escala.setDia24Fk(null);//M
					
					escala.setDia25Fk(null);//N
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//M
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//M
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo4F(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia01Fk(null);//M
					escala.setDia02Fk(null);//N
					escala.setDia06Fk(null);//M
					
					escala.setDia07Fk(null);//M
					escala.setDia08Fk(null);//N
					escala.setDia12Fk(null);//M
					
					escala.setDia13Fk(null);//M
					escala.setDia14Fk(null);//N
					escala.setDia18Fk(null);//M
					
					escala.setDia19Fk(null);//M
					escala.setDia20Fk(null);//N
					escala.setDia24Fk(null);//M
					
					escala.setDia25Fk(null);//M
					escala.setDia26Fk(null);//N
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//M
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//M
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
			
				
				
				
				// Atalhos Ciclo5
				public Escala atalhoCiclo5A(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia01Fk(null);//T
					escala.setDia02Fk(null);//T
					escala.setDia03Fk(null);//N
					
					escala.setDia07Fk(null);//T
					escala.setDia08Fk(null);//T
					escala.setDia09Fk(null);//N
					
					escala.setDia13Fk(null);//T
					escala.setDia14Fk(null);//T
					escala.setDia15Fk(null);//N
					
					escala.setDia19Fk(null);//T
					escala.setDia20Fk(null);//T
					escala.setDia21Fk(null);//N
					
					escala.setDia25Fk(null);//T
					escala.setDia26Fk(null);//T
					escala.setDia27Fk(null);//N
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//M
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5B(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia02Fk(null);//T
					escala.setDia03Fk(null);//T
					escala.setDia04Fk(null);//N
					
					escala.setDia08Fk(null);//T
					escala.setDia09Fk(null);//T
					escala.setDia10Fk(null);//N
					
					escala.setDia14Fk(null);//T
					escala.setDia15Fk(null);//T
					escala.setDia16Fk(null);//N
					
					escala.setDia20Fk(null);//T
					escala.setDia21Fk(null);//T
					escala.setDia22Fk(null);//N
					
					escala.setDia26Fk(null);//T
					escala.setDia27Fk(null);//T
					escala.setDia28Fk(null);//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5C(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia03Fk(null);//T
					escala.setDia04Fk(null);//T
					escala.setDia05Fk(null);//N
					
					escala.setDia09Fk(null);//T
					escala.setDia10Fk(null);//T
					escala.setDia11Fk(null);//N
					
					escala.setDia15Fk(null);//T
					escala.setDia16Fk(null);//T
					escala.setDia17Fk(null);//N
					
					escala.setDia21Fk(null);//T
					escala.setDia22Fk(null);//T
					escala.setDia23Fk(null);//N
					
					escala.setDia27Fk(null);//T
					escala.setDia28Fk(null);//T
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5D(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia04Fk(null);//T
					escala.setDia05Fk(null);//T
					escala.setDia06Fk(null);//N
					
					escala.setDia10Fk(null);//T
					escala.setDia11Fk(null);//T
					escala.setDia12Fk(null);//N
					
					escala.setDia16Fk(null);//T
					escala.setDia17Fk(null);//T
					escala.setDia18Fk(null);//N
					
					escala.setDia22Fk(null);//T
					escala.setDia23Fk(null);//T
					escala.setDia24Fk(null);//N
					
					escala.setDia28Fk(null);//T
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//T
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5E(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia01Fk(null);//N
					escala.setDia05Fk(null);//T
					escala.setDia06Fk(null);//T
					
					escala.setDia07Fk(null);//N
					escala.setDia11Fk(null);//T
					escala.setDia12Fk(null);//T
					
					escala.setDia13Fk(null);//N
					escala.setDia17Fk(null);//T
					escala.setDia18Fk(null);//T
					
					escala.setDia19Fk(null);//N
					escala.setDia23Fk(null);//T
					escala.setDia24Fk(null);//T
					
					escala.setDia25Fk(null);//N
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//T
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//T
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo5F(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia01Fk(null);//T
					escala.setDia02Fk(null);//N
					escala.setDia06Fk(null);//T
					
					escala.setDia07Fk(null);//T
					escala.setDia08Fk(null);//N
					escala.setDia12Fk(null);//T
					
					escala.setDia13Fk(null);//T
					escala.setDia14Fk(null);//N
					escala.setDia18Fk(null);//T
					
					escala.setDia19Fk(null);//T
					escala.setDia20Fk(null);//N
					escala.setDia24Fk(null);//T
					
					escala.setDia25Fk(null);//T
					escala.setDia26Fk(null);//N
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//T
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//T
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				
				
				// Atalhos Ciclo6
				public Escala atalhoCiclo6A(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia01Fk(null);//MT
					escala.setDia02Fk(null);//MT
					
					escala.setDia07Fk(null);//MT
					escala.setDia08Fk(null);//MT
					
					escala.setDia13Fk(null);//MT
					escala.setDia14Fk(null);//MT
					
					escala.setDia19Fk(null);//MT
					escala.setDia20Fk(null);//MT
					
					escala.setDia25Fk(null);//MT
					escala.setDia26Fk(null);//MT
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6B(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia02Fk(null);//MT
					escala.setDia03Fk(null);//MT
					
					escala.setDia08Fk(null);//MT
					escala.setDia09Fk(null);//MT
					
					escala.setDia14Fk(null);//MT
					escala.setDia15Fk(null);//MT
					
					escala.setDia20Fk(null);//MT
					escala.setDia21Fk(null);//MT
					
					escala.setDia26Fk(null);//MT
					escala.setDia27Fk(null);//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6C(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia03Fk(null);//MT
					escala.setDia04Fk(null);//MT
					
					escala.setDia09Fk(null);//MT
					escala.setDia10Fk(null);//MT
					
					escala.setDia15Fk(null);//MT
					escala.setDia16Fk(null);//MT
					
					escala.setDia21Fk(null);//MT
					escala.setDia22Fk(null);//MT
					
					escala.setDia27Fk(null);//MT
					escala.setDia28Fk(null);//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6D(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia04Fk(null);//MT
					escala.setDia05Fk(null);//MT
					
					escala.setDia10Fk(null);//MT
					escala.setDia11Fk(null);//MT
					
					escala.setDia16Fk(null);//MT
					escala.setDia17Fk(null);//MT
					
					escala.setDia22Fk(null);//MT
					escala.setDia23Fk(null);//MT
					
					escala.setDia28Fk(null);//MT
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6E(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia05Fk(null);//MT
					escala.setDia06Fk(null);//MT
					
					escala.setDia11Fk(null);//MT
					escala.setDia12Fk(null);//MT
					
					escala.setDia17Fk(null);//MT
					escala.setDia18Fk(null);//MT
					
					escala.setDia23Fk(null);//MT
					escala.setDia24Fk(null);//MT
					
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//MT
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo6F(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia01Fk(null);//MT
					escala.setDia06Fk(null);//MT
					
					escala.setDia07Fk(null);//MT
					escala.setDia12Fk(null);//MT
					
					escala.setDia13Fk(null);//MT
					escala.setDia18Fk(null);//MT
					
					escala.setDia19Fk(null);//MT
					escala.setDia24Fk(null);//MT
					
					escala.setDia25Fk(null);//MT
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//MT
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//MT
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
	
				
				
				
				// Atalhos Ciclo7
				public Escala atalhoCiclo7A(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia01Fk(null);//M
					escala.setDia02Fk(null);//T
					escala.setDia03Fk(null);//N
					
					escala.setDia07Fk(null);//M
					escala.setDia08Fk(null);//T
					escala.setDia09Fk(null);//N
					
					escala.setDia13Fk(null);//M
					escala.setDia14Fk(null);//T
					escala.setDia15Fk(null);//N
					
					escala.setDia19Fk(null);//M
					escala.setDia20Fk(null);//T
					escala.setDia21Fk(null);//N
					
					escala.setDia25Fk(null);//M
					escala.setDia26Fk(null);//T
					escala.setDia27Fk(null);//N
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//M
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7B(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia02Fk(null);//M
					escala.setDia03Fk(null);//T
					escala.setDia04Fk(null);//N
					
					escala.setDia08Fk(null);//M
					escala.setDia09Fk(null);//T
					escala.setDia10Fk(null);//N
					
					escala.setDia14Fk(null);//M
					escala.setDia15Fk(null);//T
					escala.setDia16Fk(null);//N
					
					escala.setDia20Fk(null);//M
					escala.setDia21Fk(null);//T
					escala.setDia22Fk(null);//N
					
					escala.setDia26Fk(null);//M
					escala.setDia27Fk(null);//T
					escala.setDia28Fk(null);//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7C(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia03Fk(null);//M
					escala.setDia04Fk(null);//T
					escala.setDia05Fk(null);//N
					
					escala.setDia09Fk(null);//M
					escala.setDia10Fk(null);//T
					escala.setDia11Fk(null);//N
					
					escala.setDia15Fk(null);//M
					escala.setDia16Fk(null);//T
					escala.setDia17Fk(null);//N
					
					escala.setDia21Fk(null);//M
					escala.setDia22Fk(null);//T
					escala.setDia23Fk(null);//N
					
					escala.setDia27Fk(null);//M
					escala.setDia28Fk(null);//T
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7D(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia04Fk(null);//M
					escala.setDia05Fk(null);//T
					escala.setDia06Fk(null);//N
					
					escala.setDia10Fk(null);//M
					escala.setDia11Fk(null);//T
					escala.setDia12Fk(null);//N
					
					escala.setDia16Fk(null);//M
					escala.setDia17Fk(null);//T
					escala.setDia18Fk(null);//N
					
					escala.setDia22Fk(null);//M
					escala.setDia23Fk(null);//T
					escala.setDia24Fk(null);//N
					
					escala.setDia28Fk(null);//M
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//T
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7E(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia01Fk(null);//N
					escala.setDia05Fk(null);//M
					escala.setDia06Fk(null);//T
					
					escala.setDia07Fk(null);//N
					escala.setDia11Fk(null);//M
					escala.setDia12Fk(null);//T
					
					escala.setDia13Fk(null);//N
					escala.setDia17Fk(null);//M
					escala.setDia18Fk(null);//T
					
					escala.setDia19Fk(null);//N
					escala.setDia23Fk(null);//M
					escala.setDia24Fk(null);//T
					
					escala.setDia25Fk(null);//N
					if(qtdDiasNoMes>=29) {escala.setDia29Fk(null);}//M
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//T
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//N
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
				
				public Escala atalhoCiclo7F(Escala escala) {
					int qtdDiasNoMes = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
					
					escala.setDia01Fk(null);//T
					escala.setDia02Fk(null);//N
					escala.setDia06Fk(null);//M
					
					escala.setDia07Fk(null);//T
					escala.setDia08Fk(null);//N
					escala.setDia12Fk(null);//M
					
					escala.setDia13Fk(null);//T
					escala.setDia14Fk(null);//N
					escala.setDia18Fk(null);//M
					
					escala.setDia19Fk(null);//T
					escala.setDia20Fk(null);//N
					escala.setDia24Fk(null);//M
					
					escala.setDia25Fk(null);//T
					escala.setDia26Fk(null);//N
					if(qtdDiasNoMes>=30) {escala.setDia30Fk(null);}//M
					
					if(qtdDiasNoMes==31) {escala.setDia31Fk(null);}//T
					
					escala = escalaCalculosService.calcularDadosEscala(escala);
					
				return escala;	
				}
}
