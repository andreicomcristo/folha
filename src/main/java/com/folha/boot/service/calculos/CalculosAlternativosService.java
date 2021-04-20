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
import com.folha.boot.service.EscalaCalculosService;
import com.folha.boot.service.TurnosService;
import com.folha.boot.service.VinculosService;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;

@Service
@Transactional(readOnly = false)
public class CalculosAlternativosService {
	
	@Autowired
	EscalaCalculosService escalaCalculosService;
	@Autowired
	TurnosService turnosService;
	@Autowired
	VinculosService vinculosService;

	public List<EscalasNoMes> aplicarFeriasNaEscala(List<EscalasNoMes> listaEscalas, List<FeriasNoMes> listaFerias){
		List<EscalasNoMes> listaResposta = new ArrayList<>();
		
		for(int i=0;i<listaEscalas.size();i++) {
			
			for(int j=0;j<listaFerias.size();j++) {
				if(listaEscalas.get(i).getReferencias().getCpf()==listaFerias.get(j).getFuncionariosFeriasPeriodos().getIdFeriasFk().getIdFuncionarioFk().getIdPessoaFk().getCpf() ) {
					if( listaEscalas.get(i).getReferencias().getMatricula()==listaFerias.get(j).getFuncionariosFeriasPeriodos().getIdFeriasFk().getIdFuncionarioFk().getMatricula()  ) {
						
						if( (listaEscalas.get(i).getReferencias().getVinculos()!=vinculosService.buscarPorNomeExato("PRESTADOR").get(0))  ) {
							//Anotando Informação de Férias
							listaEscalas.get(i).getReferencias().setObsReferencias( "FERIAS CADASTRADAS PELA UNIDADE "+listaFerias.get(j).getFuncionariosFeriasPeriodos().getIdFeriasFk().getIdUnidadeLancamentoFk().getNomeFantasia()+" DE "+listaFerias.get(j).getFuncionariosFeriasPeriodos().getDtInicial()+" ATE "+listaFerias.get(j).getFuncionariosFeriasPeriodos().getDtFinal() );
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=1 && listaFerias.get(j).getDiaFinal()>=1 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia01Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia01Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia01Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia01Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 01: "+ listaEscalas.get(i).getEscala().getDia01Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia01Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=2 && listaFerias.get(j).getDiaFinal()>=2 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia02Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia02Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia02Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia02Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 02: "+ listaEscalas.get(i).getEscala().getDia02Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia02Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=3 && listaFerias.get(j).getDiaFinal()>=3 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia03Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia03Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia03Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia03Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 03: "+ listaEscalas.get(i).getEscala().getDia03Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia03Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=4 && listaFerias.get(j).getDiaFinal()>=4 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia04Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia04Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia04Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia04Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 04: "+ listaEscalas.get(i).getEscala().getDia04Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia04Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=5 && listaFerias.get(j).getDiaFinal()>=5 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia05Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia05Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia05Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia05Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 05: "+ listaEscalas.get(i).getEscala().getDia05Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia05Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=6 && listaFerias.get(j).getDiaFinal()>=6 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia06Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia06Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia06Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia06Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 06: "+ listaEscalas.get(i).getEscala().getDia06Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia06Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=7 && listaFerias.get(j).getDiaFinal()>=7 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia07Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia07Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia07Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia07Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 07: "+ listaEscalas.get(i).getEscala().getDia07Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia07Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=8 && listaFerias.get(j).getDiaFinal()>=8 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia08Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia08Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia08Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia08Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 08: "+ listaEscalas.get(i).getEscala().getDia08Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia08Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=9 && listaFerias.get(j).getDiaFinal()>=9 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia09Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia09Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia09Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia09Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 09: "+ listaEscalas.get(i).getEscala().getDia09Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia09Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=10 && listaFerias.get(j).getDiaFinal()>=10 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia10Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia10Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia10Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia10Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 10: "+ listaEscalas.get(i).getEscala().getDia10Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia10Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=11 && listaFerias.get(j).getDiaFinal()>=11 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia11Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia11Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia11Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia11Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 11: "+ listaEscalas.get(i).getEscala().getDia11Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia11Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=12 && listaFerias.get(j).getDiaFinal()>=12 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia12Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia12Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia12Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia12Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 12: "+ listaEscalas.get(i).getEscala().getDia12Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia12Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=13 && listaFerias.get(j).getDiaFinal()>=13 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia13Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia13Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia13Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia13Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 13: "+ listaEscalas.get(i).getEscala().getDia13Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia13Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=14 && listaFerias.get(j).getDiaFinal()>=14 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia14Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia14Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia14Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia14Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 14: "+ listaEscalas.get(i).getEscala().getDia14Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia14Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=15 && listaFerias.get(j).getDiaFinal()>=15 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia15Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia15Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia15Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia15Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 15: "+ listaEscalas.get(i).getEscala().getDia15Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia15Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=16 && listaFerias.get(j).getDiaFinal()>=16 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia16Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia16Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia16Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia16Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 16: "+ listaEscalas.get(i).getEscala().getDia16Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia16Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=17 && listaFerias.get(j).getDiaFinal()>=17 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia17Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia17Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia17Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia17Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 17: "+ listaEscalas.get(i).getEscala().getDia17Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia17Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=18 && listaFerias.get(j).getDiaFinal()>=18 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia18Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia18Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia18Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia18Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 18: "+ listaEscalas.get(i).getEscala().getDia18Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia18Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=19 && listaFerias.get(j).getDiaFinal()>=19 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia19Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia19Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia19Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia19Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 19: "+ listaEscalas.get(i).getEscala().getDia19Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia19Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=20 && listaFerias.get(j).getDiaFinal()>=20 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia20Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia20Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia20Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia20Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 20: "+ listaEscalas.get(i).getEscala().getDia20Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia20Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=21 && listaFerias.get(j).getDiaFinal()>=21 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia21Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia21Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia21Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia21Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 21: "+ listaEscalas.get(i).getEscala().getDia21Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia21Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=22 && listaFerias.get(j).getDiaFinal()>=22 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia22Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia22Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia22Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia22Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 22: "+ listaEscalas.get(i).getEscala().getDia22Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia22Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=23 && listaFerias.get(j).getDiaFinal()>=23 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia23Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia23Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia23Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia23Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 23: "+ listaEscalas.get(i).getEscala().getDia23Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia23Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=24 && listaFerias.get(j).getDiaFinal()>=24 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia24Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia24Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia24Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia24Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 24: "+ listaEscalas.get(i).getEscala().getDia24Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia24Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=25 && listaFerias.get(j).getDiaFinal()>=25 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia25Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia25Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia25Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia25Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 25: "+ listaEscalas.get(i).getEscala().getDia25Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia25Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=26 && listaFerias.get(j).getDiaFinal()>=26 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia26Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia26Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia26Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia26Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 26: "+ listaEscalas.get(i).getEscala().getDia26Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia26Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=27 && listaFerias.get(j).getDiaFinal()>=27 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia27Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia27Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia27Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia27Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 27: "+ listaEscalas.get(i).getEscala().getDia27Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia27Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=28 && listaFerias.get(j).getDiaFinal()>=28 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia28Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia28Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia28Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia28Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 28: "+ listaEscalas.get(i).getEscala().getDia28Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia28Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=29 && listaFerias.get(j).getDiaFinal()>=29 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia29Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia29Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia29Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia29Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 29: "+ listaEscalas.get(i).getEscala().getDia29Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia29Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=30 && listaFerias.get(j).getDiaFinal()>=30 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia30Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia30Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia30Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia30Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 30: "+ listaEscalas.get(i).getEscala().getDia30Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia30Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=31 && listaFerias.get(j).getDiaFinal()>=31 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia31Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia31Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia31Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia31Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 31: "+ listaEscalas.get(i).getEscala().getDia31Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia31Fk(turnosService.buscarPorNome(""));
							}
							
							
						
						}
						
					}
				}
			}
			//Recalculando Datas e plantoes
			listaEscalas.get(i).setEscala(escalaCalculosService.calcularDadosEscala( listaEscalas.get(i).getEscala() ));
			
			//Inserindo na resposta
			listaResposta.add(listaEscalas.get(i));
		}
		
		
		
		
		
		
			return listaResposta;
	}
	
	
	
	
	
	
}
