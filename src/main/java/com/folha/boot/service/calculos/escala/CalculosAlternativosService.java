package com.folha.boot.service.calculos.escala;

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
import com.folha.boot.Reposytory.RubricaNaturezaReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.EscalaCodDiferenciado;
import com.folha.boot.domain.FaixasValoresFolhExt;
import com.folha.boot.domain.FaixasValoresGpf;
import com.folha.boot.domain.FaixasValoresGpfDiferenciada;
import com.folha.boot.domain.FaixasValoresGpfMedica;
import com.folha.boot.domain.FaixasValoresGpfMedicaDiferenciada;
import com.folha.boot.domain.FaixasValoresGpfMedicaDiferenciadaDiarista;
import com.folha.boot.domain.FaixasValoresIncentivoDeRisco;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.FaixasValoresPss;
import com.folha.boot.domain.FaixasValoresResidente;
import com.folha.boot.domain.FuncionariosFerias;
import com.folha.boot.domain.FuncionariosFeriasPeriodos;
import com.folha.boot.domain.FuncionariosLicencas;
import com.folha.boot.domain.HorasFaltasFolhasVariaveis;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.VencimentosFuncionario;
import com.folha.boot.domain.models.calculos.EscalasNoMes;
import com.folha.boot.domain.models.calculos.FeriasNoMes;
import com.folha.boot.domain.models.calculos.LicencasNoMes;
import com.folha.boot.domain.models.calculos.ReferenciasDeEscala;
import com.folha.boot.domain.models.calculos.RubricasVencimento;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.EscalaCalculosService;
import com.folha.boot.service.EscalaCodDiferenciadoService;
import com.folha.boot.service.FaixasValoresFolhExtService;
import com.folha.boot.service.FaixasValoresGpfDiferenciadaService;
import com.folha.boot.service.FaixasValoresGpfMedicaDiferenciadaDiaristaService;
import com.folha.boot.service.FaixasValoresGpfMedicaDiferenciadaService;
import com.folha.boot.service.FaixasValoresGpfMedicaService;
import com.folha.boot.service.FaixasValoresGpfService;
import com.folha.boot.service.FaixasValoresIncentivoDeRiscoService;
import com.folha.boot.service.FaixasValoresParametrosCalculoFolhasExtrasService;
import com.folha.boot.service.FaixasValoresPssService;
import com.folha.boot.service.FaixasValoresResidenteService;
import com.folha.boot.service.HorasFaltasFolhasVariaveisService;
import com.folha.boot.service.NaoDescontaInssService;
import com.folha.boot.service.RubricaNaturezaService;
import com.folha.boot.service.RubricaService;
import com.folha.boot.service.TurnosService;
import com.folha.boot.service.VencimentosFuncionarioService;
import com.folha.boot.service.VinculosService;
import com.folha.boot.service.calculos.folha.CalcularLiquidoService;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;
import com.folha.boot.service.util.UtilidadesMatematicas;

@Service
@Transactional(readOnly = false)
public class CalculosAlternativosService {
	
	@Autowired
	EscalaCalculosService escalaCalculosService;
	@Autowired
	TurnosService turnosService;
	@Autowired
	VinculosService vinculosService;
	@Autowired
	FaixasValoresParametrosCalculoFolhasExtrasService faixasValoresParametrosCalculoFolhasExtrasService;
	@Autowired
	EscalaCodDiferenciadoService escalaCodDiferenciadoService;
	@Autowired
	RubricaNaturezaService rubricaNaturezaService;
	@Autowired
	private  UtilidadesDeCalendarioEEscala utilidadesDeCalendarioEEscala;
	@Autowired
	private FaixasValoresIncentivoDeRiscoService faixasValoresIncentivoDeRiscoService;
	@Autowired
	private FaixasValoresGpfService faixasValoresGpfService;
	@Autowired
	private FaixasValoresGpfMedicaService faixasValoresGpfMedicaService;
	@Autowired
	private FaixasValoresGpfMedicaDiferenciadaService faixasValoresGpfMedicaDiferenciadaService;
	@Autowired
	private FaixasValoresPssService faixasValoresPssService;
	@Autowired
	private FaixasValoresFolhExtService faixasValoresFolhExtService;
	@Autowired
	private FaixasValoresGpfMedicaDiferenciadaDiaristaService faixasValoresGpfMedicaDiferenciadaDiaristaService;
	@Autowired
	private FaixasValoresGpfDiferenciadaService faixasValoresGpfDiferenciadaService;
	@Autowired
	private FaixasValoresResidenteService faixasValoresResidenteService;
	@Autowired
	private VencimentosFuncionarioService vencimentosFuncionarioService;
	@Autowired
	private RubricaService rubricaService;
	@Autowired
	private CalcularLiquidoService calcularLiquidoService;
	@Autowired
	private NaoDescontaInssService naoDescontaInssService;
	@Autowired
	private HorasFaltasFolhasVariaveisService horasFaltasFolhasVariaveisService;
	@Autowired
	private AnoMesService anoMesService;
	
	
	

	public List<EscalasNoMes> aplicarFaltasVariaveisNaEscalaSemanaFimSemana(List<EscalasNoMes> listaEscalas){
		List<HorasFaltasFolhasVariaveis> listaFaltas = horasFaltasFolhasVariaveisService.buscarFaltasADescontar();
		List<EscalasNoMes> listaResposta = new ArrayList<>();
		
		for(int i=0;i<listaEscalas.size();i++) {
			
			if(listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdTipoRemuneracaoFk().getNomeTipoRemuneracao().equalsIgnoreCase("VARIAVEL")  ) {
				for(int j=0;j<listaFaltas.size();j++) {
					
					if(		(listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T")) &&
							(listaEscalas.get(i).getEscala().getIdFuncionarioFk()==listaFaltas.get(j).getIdFuncionarioFk()) && 
							(listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk()==listaFaltas.get(j).getIdUnidadeFk()) &&
							(listaFaltas.get(j).getHorasRestantes()>0) 
					) {
						
						int horasSemana = listaEscalas.get(i).getEscala().getHorasSemana();
						int horasFimSemana = listaEscalas.get(i).getEscala().getHorasFimSemana();
						int horasTotais = listaEscalas.get(i).getEscala().getHorasTotais();
						
						int horasDescontarSemana = listaFaltas.get(j).getHorasSemana();
						int horasDescontarFimSemana = listaFaltas.get(j).getHorasFimSemana();
						int horasRestantes = listaFaltas.get(j).getHorasRestantes();
						
						int horasSemanaDescontadas = listaFaltas.get(j).getHorasSemanaDescontadas();
						int horasFimSemanaDescontadas = listaFaltas.get(j).getHorasFimSemanaDescontadas();
						
						//Horas Fim Semana
						if(horasRestantes>0) {
							if(horasFimSemana>0) {
								if(horasDescontarFimSemana-horasFimSemanaDescontadas>0) {
									int horasCortadas = horasFimSemana- (horasDescontarFimSemana-horasFimSemanaDescontadas); 
									if(horasCortadas<0) {
										horasCortadas = horasFimSemana;
										horasFimSemana = 0;
										horasFimSemanaDescontadas = horasFimSemanaDescontadas+horasCortadas;
										horasRestantes = horasRestantes - horasCortadas;
										listaFaltas.get(j).setObservacaoSistema( listaFaltas.get(j).getObservacaoSistema()+"DESCONTO: "+horasCortadas+" HORAS FIM SEMANA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); listaEscalas.get(i).getReferencias().setObsReferencias(listaEscalas.get(i).getReferencias().getObsReferencias()+ "DESCONTO: "+horasCortadas+" HORAS FIM SEMANA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " );
										
									}else { horasCortadas = (horasDescontarFimSemana-horasFimSemanaDescontadas); horasFimSemana = horasFimSemana-horasCortadas; horasFimSemanaDescontadas = horasFimSemanaDescontadas+horasCortadas; horasRestantes = horasRestantes - horasCortadas; listaFaltas.get(j).setObservacaoSistema( listaFaltas.get(j).getObservacaoSistema()+"DESCONTO: "+horasCortadas+" HORAS FIM SEMANA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); listaEscalas.get(i).getReferencias().setObsReferencias(listaEscalas.get(i).getReferencias().getObsReferencias()+ "DESCONTO: "+horasCortadas+" HORAS FIM SEMANA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " );}
								}
							}
						}
						horasTotais = horasSemana+horasFimSemana;
						
						//Horas Semana
						if(horasRestantes>0) {
							if(horasSemana>0) {
								if(horasDescontarSemana-horasSemanaDescontadas>0) {
									int horasCortadas = horasSemana- (horasDescontarSemana-horasSemanaDescontadas); 
									if(horasCortadas<0) {
										horasCortadas = horasSemana;
										horasSemana = 0;
										horasSemanaDescontadas = horasSemanaDescontadas+horasCortadas;
										horasRestantes = horasRestantes - horasCortadas;
										listaFaltas.get(j).setObservacaoSistema( listaFaltas.get(j).getObservacaoSistema()+"DESCONTO: "+horasCortadas+" HORAS SEMANA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); listaEscalas.get(i).getReferencias().setObsReferencias(listaEscalas.get(i).getReferencias().getObsReferencias()+ "DESCONTO: "+horasCortadas+" HORAS SEMANA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " );
									}else { horasCortadas = (horasDescontarSemana-horasSemanaDescontadas); horasSemana = horasSemana-horasCortadas; horasSemanaDescontadas = horasSemanaDescontadas+horasCortadas; horasRestantes = horasRestantes - horasCortadas; listaFaltas.get(j).setObservacaoSistema( listaFaltas.get(j).getObservacaoSistema()+"DESCONTO: "+horasCortadas+" HORAS SEMANA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); listaEscalas.get(i).getReferencias().setObsReferencias(listaEscalas.get(i).getReferencias().getObsReferencias()+ "DESCONTO: "+horasCortadas+" HORAS SEMANA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); }
								}
							}
						}
						horasTotais = horasSemana+horasFimSemana;
						
						//Descontando os excedentes Semana
						if(horasRestantes>0 && horasTotais>0) {
							if(horasSemana>0) {
								
								int horasFicouNaEscala = horasSemana-horasRestantes;
								int horasA = 0;
								if(horasFicouNaEscala<0) { horasFicouNaEscala = 0;    }
								horasA = horasSemana-horasFicouNaEscala;
								horasSemanaDescontadas = horasSemanaDescontadas+horasA; 
								horasRestantes = horasRestantes-horasA; 
								horasSemana = horasSemana - horasA;
								listaFaltas.get(j).setObservacaoSistema( listaFaltas.get(j).getObservacaoSistema()+"DESCONTO: "+horasA+" HORAS SEMANA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); listaEscalas.get(i).getReferencias().setObsReferencias(listaEscalas.get(i).getReferencias().getObsReferencias()+ "DESCONTO: "+horasA+" HORAS SEMANA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " );
							}
						}
						horasTotais = horasSemana+horasFimSemana;
						
						//Descontando os excedentes FimSemana
						if(horasRestantes>0 && horasTotais>0) {
							if(horasFimSemana>0) {
								int horasFicouNaEscala = horasFimSemana-horasRestantes;
								int horasA = 0;
								if(horasFicouNaEscala<0) { horasFicouNaEscala = 0;    }
								horasA = horasFimSemana-horasFicouNaEscala;
								horasFimSemanaDescontadas = horasFimSemanaDescontadas+horasA; 
								horasRestantes = horasRestantes-horasA; 
								horasFimSemana = horasFimSemana - horasA;
								listaFaltas.get(j).setObservacaoSistema( listaFaltas.get(j).getObservacaoSistema()+"DESCONTO: "+horasA+" HORAS FIM SEMANA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); listaEscalas.get(i).getReferencias().setObsReferencias(listaEscalas.get(i).getReferencias().getObsReferencias()+ "DESCONTO: "+horasA+" HORAS FIM SEMANA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " );
							}
						}
						horasTotais = horasSemana+horasFimSemana;
						
						
						
						listaFaltas.get(j).setHorasFimSemanaDescontadas(horasFimSemanaDescontadas);	
						listaFaltas.get(j).setHorasSemanaDescontadas(horasSemanaDescontadas);
						listaFaltas.get(j).setHorasDescontadas(horasSemanaDescontadas+horasFimSemanaDescontadas);
						listaFaltas.get(j).setHorasRestantes(horasRestantes);
						
						listaEscalas.get(i).getEscala().setHorasSemana(horasSemana);
						listaEscalas.get(i).getEscala().setHorasFimSemana(horasFimSemana);
						listaEscalas.get(i).getEscala().setHorasTotais(horasTotais);
						
					}
				}
				
			}
		
			
			
			//Inserindo na resposta
			listaResposta.add(listaEscalas.get(i));
		}
		
		horasFaltasFolhasVariaveisService.salvarLista(listaFaltas);
		
			return listaResposta;
	}
	
	
	
	
	public List<EscalasNoMes> aplicarFaltasVariaveisNaEscalaDiaNoite(List<EscalasNoMes> listaEscalas){
		List<HorasFaltasFolhasVariaveis> listaFaltas = horasFaltasFolhasVariaveisService.buscarFaltasADescontar();
		
		List<EscalasNoMes> listaResposta = new ArrayList<>();
		
		for(int i=0;i<listaEscalas.size();i++) {
			if(listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdTipoRemuneracaoFk().getNomeTipoRemuneracao().equalsIgnoreCase("VARIAVEL")) {
				for(int j=0;j<listaFaltas.size();j++) {
					if(		(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T")) &&
							(listaEscalas.get(i).getEscala().getIdFuncionarioFk()==listaFaltas.get(j).getIdFuncionarioFk()) && 
							(listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk()==listaFaltas.get(j).getIdUnidadeFk()) &&
							(listaFaltas.get(j).getHorasRestantes()>0) 
					) {
					
						int horasDia = listaEscalas.get(i).getEscala().getHorasDia();
						int horasNoite = listaEscalas.get(i).getEscala().getHorasNoite();
						int horasTotais = listaEscalas.get(i).getEscala().getHorasTotais();
						
						int horasDescontarDia = listaFaltas.get(j).getHorasDia();
						int horasDescontarNoite = listaFaltas.get(j).getHorasDia();
						int horasRestantes = listaFaltas.get(j).getHorasRestantes();
						
						int horasDiaDescontadas = listaFaltas.get(j).getHorasDiaDescontadas();
						int horasNoiteDescontadas = listaFaltas.get(j).getHorasNoiteDescontadas();
						
						
						
						//Horas Noite
						if(horasRestantes>0) {
							if(horasNoite>0) {
								if(horasDescontarNoite-horasNoiteDescontadas>0) {
									int horasCortadas = horasNoite- (horasDescontarNoite-horasNoiteDescontadas); 
									if(horasCortadas<0) {
										horasCortadas = horasNoite;
										horasNoite = 0;
										horasNoiteDescontadas = horasNoiteDescontadas+horasCortadas;
										horasRestantes = horasRestantes - horasCortadas;
										listaFaltas.get(j).setObservacaoSistema( listaFaltas.get(j).getObservacaoSistema()+"DESCONTO: "+horasCortadas+" HORAS NOITE "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); listaEscalas.get(i).getReferencias().setObsReferencias(listaEscalas.get(i).getReferencias().getObsReferencias()+ "DESCONTO: "+horasCortadas+" HORAS NOITE "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); 
									}else {horasCortadas = (horasDescontarNoite-horasNoiteDescontadas); horasNoite = horasNoite-horasCortadas; horasNoiteDescontadas = horasNoiteDescontadas+horasCortadas; horasRestantes = horasRestantes - horasCortadas; listaFaltas.get(j).setObservacaoSistema( listaFaltas.get(j).getObservacaoSistema()+"DESCONTO: "+horasCortadas+" HORAS NOITE "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); listaEscalas.get(i).getReferencias().setObsReferencias(listaEscalas.get(i).getReferencias().getObsReferencias()+ "DESCONTO: "+horasCortadas+" HORAS NOITE "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); }
								}
							}
						}
						horasTotais = horasDia+horasNoite;
						
						
						//Horas Dia
						if(horasRestantes>0) {
							if(horasDia>0) {
								if(horasDescontarDia-horasDiaDescontadas>0) {
									int horasCortadas = horasDia- (horasDescontarDia-horasDiaDescontadas); 
									if(horasCortadas<0) {
										horasCortadas = horasDia;
										horasDia = 0;
										horasDiaDescontadas = horasDiaDescontadas+horasCortadas;
										horasRestantes = horasRestantes - horasCortadas;
										listaFaltas.get(j).setObservacaoSistema( listaFaltas.get(j).getObservacaoSistema()+"DESCONTO: "+horasCortadas+" HORAS DIA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); listaEscalas.get(i).getReferencias().setObsReferencias(listaEscalas.get(i).getReferencias().getObsReferencias()+ "DESCONTO: "+horasCortadas+" HORAS DIA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " );
									}else {horasCortadas = (horasDescontarDia-horasDiaDescontadas); horasDia = horasDia-horasCortadas; horasDiaDescontadas = horasDiaDescontadas+horasCortadas; horasRestantes = horasRestantes - horasCortadas; listaFaltas.get(j).setObservacaoSistema( listaFaltas.get(j).getObservacaoSistema()+"DESCONTO: "+horasCortadas+" HORAS DIA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); listaEscalas.get(i).getReferencias().setObsReferencias(listaEscalas.get(i).getReferencias().getObsReferencias()+ "DESCONTO: "+horasCortadas+" HORAS DIA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); }
								}
							}
						}
						horasTotais = horasDia+horasNoite;
						
						//Descontando os excedentes Dia
						if(horasRestantes>0 && horasTotais>0) {
							if(horasDia>0) {
								int horasFicouNaEscala = horasDia-horasRestantes;
								int horasA = 0;
								if(horasFicouNaEscala<0) { horasFicouNaEscala = 0;    }
								horasA = horasDia-horasFicouNaEscala;
								horasDiaDescontadas = horasDiaDescontadas+horasA; 
								horasRestantes = horasRestantes-horasA; 
								horasDia = horasDia - horasA;
								listaFaltas.get(j).setObservacaoSistema( listaFaltas.get(j).getObservacaoSistema()+"DESCONTO: "+horasA+" HORAS DIA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); listaEscalas.get(i).getReferencias().setObsReferencias(listaEscalas.get(i).getReferencias().getObsReferencias()+ "DESCONTO: "+horasA+" HORAS DIA "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " );
							}
						}
						horasTotais = horasDia+horasNoite;
						
						//Descontando os excedentes Noite
						if(horasRestantes>0 && horasTotais>0) {
							if(horasNoite>0) {
								int horasFicouNaEscala = horasNoite-horasRestantes;
								int horasA = 0;
								if(horasFicouNaEscala<0) { horasFicouNaEscala = 0;    }
								horasA = horasNoite-horasFicouNaEscala;
								horasNoiteDescontadas = horasNoiteDescontadas+horasA; 
								horasRestantes = horasRestantes-horasA; 
								horasNoite = horasNoite - horasA;
								listaFaltas.get(j).setObservacaoSistema( listaFaltas.get(j).getObservacaoSistema()+"DESCONTO: "+horasA+" HORAS NOITE "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " ); listaEscalas.get(i).getReferencias().setObsReferencias(listaEscalas.get(i).getReferencias().getObsReferencias()+ "DESCONTO: "+horasA+" HORAS NOITE "+listaFaltas.get(j).getIdAnoMesFk().getNomeAnoMes()+"; " );
							}
						}
						horasTotais = horasDia+horasNoite;
						
						
						
						
						listaFaltas.get(j).setHorasNoiteDescontadas(horasNoiteDescontadas);	
						listaFaltas.get(j).setHorasDiaDescontadas(horasDiaDescontadas);
						listaFaltas.get(j).setHorasDescontadas(horasDiaDescontadas+horasNoiteDescontadas);
						listaFaltas.get(j).setHorasRestantes(horasRestantes);
						
						listaEscalas.get(i).getEscala().setHorasDia(horasDia);
						listaEscalas.get(i).getEscala().setHorasNoite(horasNoite);
						listaEscalas.get(i).getEscala().setHorasTotais(horasTotais);
						
					}
				}
				
			}
		
			
			//Inserindo na resposta
			listaResposta.add(listaEscalas.get(i));
		}
		
		
		
		
			horasFaltasFolhasVariaveisService.salvarLista(listaFaltas);
		
			return listaResposta;
	}
		
	
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
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 01"+ listaEscalas.get(i).getEscala().getDia01Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia01Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=2 && listaFerias.get(j).getDiaFinal()>=2 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia02Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia02Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia02Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia02Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 02"+ listaEscalas.get(i).getEscala().getDia02Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia02Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=3 && listaFerias.get(j).getDiaFinal()>=3 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia03Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia03Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia03Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia03Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 03"+ listaEscalas.get(i).getEscala().getDia03Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia03Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=4 && listaFerias.get(j).getDiaFinal()>=4 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia04Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia04Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia04Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia04Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 04"+ listaEscalas.get(i).getEscala().getDia04Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia04Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=5 && listaFerias.get(j).getDiaFinal()>=5 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia05Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia05Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia05Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia05Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 05"+ listaEscalas.get(i).getEscala().getDia05Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia05Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=6 && listaFerias.get(j).getDiaFinal()>=6 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia06Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia06Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia06Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia06Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 06"+ listaEscalas.get(i).getEscala().getDia06Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia06Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=7 && listaFerias.get(j).getDiaFinal()>=7 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia07Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia07Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia07Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia07Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 07"+ listaEscalas.get(i).getEscala().getDia07Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia07Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=8 && listaFerias.get(j).getDiaFinal()>=8 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia08Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia08Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia08Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia08Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 08"+ listaEscalas.get(i).getEscala().getDia08Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia08Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=9 && listaFerias.get(j).getDiaFinal()>=9 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia09Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia09Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia09Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia09Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 09"+ listaEscalas.get(i).getEscala().getDia09Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia09Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=10 && listaFerias.get(j).getDiaFinal()>=10 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia10Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia10Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia10Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia10Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 10"+ listaEscalas.get(i).getEscala().getDia10Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia10Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=11 && listaFerias.get(j).getDiaFinal()>=11 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia11Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia11Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia11Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia11Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 11"+ listaEscalas.get(i).getEscala().getDia11Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia11Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=12 && listaFerias.get(j).getDiaFinal()>=12 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia12Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia12Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia12Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia12Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 12"+ listaEscalas.get(i).getEscala().getDia12Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia12Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=13 && listaFerias.get(j).getDiaFinal()>=13 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia13Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia13Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia13Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia13Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 13"+ listaEscalas.get(i).getEscala().getDia13Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia13Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=14 && listaFerias.get(j).getDiaFinal()>=14 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia14Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia14Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia14Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia14Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 14"+ listaEscalas.get(i).getEscala().getDia14Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia14Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=15 && listaFerias.get(j).getDiaFinal()>=15 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia15Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia15Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia15Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia15Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 15"+ listaEscalas.get(i).getEscala().getDia15Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia15Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=16 && listaFerias.get(j).getDiaFinal()>=16 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia16Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia16Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia16Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia16Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 16"+ listaEscalas.get(i).getEscala().getDia16Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia16Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=17 && listaFerias.get(j).getDiaFinal()>=17 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia17Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia17Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia17Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia17Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 17"+ listaEscalas.get(i).getEscala().getDia17Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia17Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=18 && listaFerias.get(j).getDiaFinal()>=18 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia18Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia18Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia18Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia18Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 18"+ listaEscalas.get(i).getEscala().getDia18Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia18Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=19 && listaFerias.get(j).getDiaFinal()>=19 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia19Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia19Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia19Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia19Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 19"+ listaEscalas.get(i).getEscala().getDia19Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia19Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=20 && listaFerias.get(j).getDiaFinal()>=20 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia20Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia20Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia20Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia20Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 20"+ listaEscalas.get(i).getEscala().getDia20Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia20Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=21 && listaFerias.get(j).getDiaFinal()>=21 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia21Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia21Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia21Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia21Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 21"+ listaEscalas.get(i).getEscala().getDia21Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia21Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=22 && listaFerias.get(j).getDiaFinal()>=22 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia22Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia22Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia22Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia22Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 22"+ listaEscalas.get(i).getEscala().getDia22Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia22Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=23 && listaFerias.get(j).getDiaFinal()>=23 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia23Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia23Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia23Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia23Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 23"+ listaEscalas.get(i).getEscala().getDia23Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia23Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=24 && listaFerias.get(j).getDiaFinal()>=24 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia24Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia24Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia24Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia24Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 24"+ listaEscalas.get(i).getEscala().getDia24Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia24Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=25 && listaFerias.get(j).getDiaFinal()>=25 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia25Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia25Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia25Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia25Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 25"+ listaEscalas.get(i).getEscala().getDia25Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia25Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=26 && listaFerias.get(j).getDiaFinal()>=26 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia26Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia26Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia26Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia26Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 26"+ listaEscalas.get(i).getEscala().getDia26Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia26Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=27 && listaFerias.get(j).getDiaFinal()>=27 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia27Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia27Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia27Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia27Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 27"+ listaEscalas.get(i).getEscala().getDia27Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia27Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=28 && listaFerias.get(j).getDiaFinal()>=28 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia28Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia28Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia28Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia28Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 28"+ listaEscalas.get(i).getEscala().getDia28Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia28Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=29 && listaFerias.get(j).getDiaFinal()>=29 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia29Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia29Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia29Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia29Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 29"+ listaEscalas.get(i).getEscala().getDia29Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia29Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=30 && listaFerias.get(j).getDiaFinal()>=30 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia30Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia30Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia30Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia30Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 30"+ listaEscalas.get(i).getEscala().getDia30Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia30Fk(turnosService.buscarPorNome(""));
							}
							
							//Limpando Turnos
							if(listaFerias.get(j).getDiaInicial()<=31 && listaFerias.get(j).getDiaFinal()>=31 ){
								listaEscalas.get(i).getReferencias().setDiasFerias( listaEscalas.get(i).getReferencias().getDiasFerias()+1 );
								listaEscalas.get(i).getReferencias().setHorasFeriasDescontadas( listaEscalas.get(i).getReferencias().getHorasFeriasDescontadas() + listaEscalas.get(i).getEscala().getDia31Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia31Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia31Fk().getHorasNoite() );
								if(listaEscalas.get(i).getEscala().getDia31Fk()!=turnosService.buscarPorNome("")) {
									listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 31"+ listaEscalas.get(i).getEscala().getDia31Fk().getNomeTurno());
								}
								listaEscalas.get(i).getEscala().setDia31Fk(turnosService.buscarPorNome(""));
							}
							
							
						listaEscalas.get(i).getReferencias().setObsReferencias(listaEscalas.get(i).getReferencias().getObsReferencias()+"; ");
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
	
	
	
	@SuppressWarnings("deprecation")
	public List<EscalasNoMes> aplicarLicencasNaEscala(List<EscalasNoMes> listaEscalas, List<LicencasNoMes> listaLicencas, AnoMes anoMes){
		List<EscalasNoMes> listaResposta = new ArrayList<>();
		
		for(int i=0;i<listaEscalas.size();i++) {
			
			for(int j=0;j<listaLicencas.size();j++) {
				
				//Colocando data da previdencia
				Date dataInicial = new Date( Integer.parseInt(anoMes.getNomeAnoMes().substring(0, 4))-1900 , Integer.parseInt(anoMes.getNomeAnoMes().substring(4, 6))-1   ,  1 );
				int diaFinala = utilidadesDeCalendarioEEscala.quantidadeDeDiasNoMes(anoMes.getNomeAnoMes());
				Date dataFinal = new Date( Integer.parseInt(anoMes.getNomeAnoMes().substring(0, 4))-1900 , Integer.parseInt(anoMes.getNomeAnoMes().substring(4, 6))-1   ,  diaFinala );
				if(listaLicencas.get(j).getFuncionariosLicencas().getDtPrevidencia()!=null) {
					if(listaLicencas.get(j).getFuncionariosLicencas().getDtPrevidencia().after(listaLicencas.get(j).getFuncionariosLicencas().getDtInicial())) {
						if(listaLicencas.get(j).getFuncionariosLicencas().getDtPrevidencia().getDate()>listaLicencas.get(j).getDiaInicial()) {
							if(listaLicencas.get(j).getFuncionariosLicencas().getDtPrevidencia().after(dataInicial) &&  (  (listaLicencas.get(j).getFuncionariosLicencas().getDtPrevidencia().before(dataFinal)) ||  (listaLicencas.get(j).getFuncionariosLicencas().getDtPrevidencia().equals(dataFinal))  ) ) {
									listaLicencas.get(j).setDiaInicial(listaLicencas.get(j).getFuncionariosLicencas().getDtPrevidencia().getDate());
							}
						}
					}
				}
				
					if(listaEscalas.get(i).getReferencias().getCpf()==listaLicencas.get(j).getFuncionariosLicencas().getIdFuncionarioFk().getIdPessoaFk().getCpf() ) {
						if( true ) {
							if( true ) {
								//Anotando Informação de Licença
								listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " CADASTRO "+listaLicencas.get(j).getFuncionariosLicencas().getIdTipoLicencaFk().getDescricaoTipoLicenca()+" DE "+listaLicencas.get(j).getFuncionariosLicencas().getDtInicial()+" ATE "+listaLicencas.get(j).getFuncionariosLicencas().getDtFinal() );
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=1 && listaLicencas.get(j).getDiaFinal()>=1 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia01Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 01"+ listaEscalas.get(i).getEscala().getDia01Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia01Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia01Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia01Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia01Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia01Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia01Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia01Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia01Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia01Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia01Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia01Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia01Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 01"+ listaEscalas.get(i).getEscala().getDia01Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia01Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia01Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia01Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia01Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia01Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 01"+ listaEscalas.get(i).getEscala().getDia01Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia01Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=2 && listaLicencas.get(j).getDiaFinal()>=2 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia02Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 02"+ listaEscalas.get(i).getEscala().getDia02Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia02Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia02Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia02Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia02Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia02Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia02Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia02Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia02Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia02Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia02Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia02Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia02Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 02"+ listaEscalas.get(i).getEscala().getDia02Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia02Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia02Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia02Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia02Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia02Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 02"+ listaEscalas.get(i).getEscala().getDia02Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia02Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=3 && listaLicencas.get(j).getDiaFinal()>=3 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia03Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 03"+ listaEscalas.get(i).getEscala().getDia03Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia03Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia03Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia03Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia03Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia03Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia03Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia03Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia03Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia03Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia03Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia03Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia03Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 03"+ listaEscalas.get(i).getEscala().getDia03Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia03Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia03Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia03Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia03Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia03Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 03"+ listaEscalas.get(i).getEscala().getDia03Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia03Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=4 && listaLicencas.get(j).getDiaFinal()>=4 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia04Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 04"+ listaEscalas.get(i).getEscala().getDia04Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia04Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia04Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia04Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia04Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia04Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia04Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia04Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia04Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia04Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia04Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia04Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia04Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 04"+ listaEscalas.get(i).getEscala().getDia04Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia04Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia04Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia04Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia04Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia04Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 04"+ listaEscalas.get(i).getEscala().getDia04Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia04Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=5 && listaLicencas.get(j).getDiaFinal()>=5 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia05Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 05"+ listaEscalas.get(i).getEscala().getDia05Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia05Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia05Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia05Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia05Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia05Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia05Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia05Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia05Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia05Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia05Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia05Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia05Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 05"+ listaEscalas.get(i).getEscala().getDia05Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia05Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia05Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia05Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia05Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia05Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 05"+ listaEscalas.get(i).getEscala().getDia05Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia05Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=6 && listaLicencas.get(j).getDiaFinal()>=6 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia06Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 06"+ listaEscalas.get(i).getEscala().getDia06Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia06Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia06Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia06Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia06Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia06Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia06Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia06Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia06Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia06Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia06Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia06Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia06Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 06"+ listaEscalas.get(i).getEscala().getDia06Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia06Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia06Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia06Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia06Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia06Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 06"+ listaEscalas.get(i).getEscala().getDia06Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia06Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=7 && listaLicencas.get(j).getDiaFinal()>=7 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia07Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 07"+ listaEscalas.get(i).getEscala().getDia07Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia07Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia07Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia07Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia07Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia07Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia07Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia07Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia07Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia07Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia07Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia07Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia07Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 07"+ listaEscalas.get(i).getEscala().getDia07Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia07Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia07Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia07Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia07Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia07Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 07"+ listaEscalas.get(i).getEscala().getDia07Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia07Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=8 && listaLicencas.get(j).getDiaFinal()>=8 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia08Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 08"+ listaEscalas.get(i).getEscala().getDia08Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia08Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia08Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia08Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia08Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia08Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia08Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia08Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia08Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia08Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia08Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia08Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia08Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 08"+ listaEscalas.get(i).getEscala().getDia08Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia08Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia08Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia08Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia08Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia08Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 08"+ listaEscalas.get(i).getEscala().getDia08Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia08Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=9 && listaLicencas.get(j).getDiaFinal()>=9 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia09Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 09"+ listaEscalas.get(i).getEscala().getDia09Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia09Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia09Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia09Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia09Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia09Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia09Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia09Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia09Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia09Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia09Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia09Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia09Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 09"+ listaEscalas.get(i).getEscala().getDia09Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia09Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia09Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia09Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia09Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia09Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 09"+ listaEscalas.get(i).getEscala().getDia09Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia09Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=10 && listaLicencas.get(j).getDiaFinal()>=10 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia10Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 10"+ listaEscalas.get(i).getEscala().getDia10Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia10Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia10Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia10Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia10Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia10Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia10Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia10Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia10Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia10Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia10Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia10Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia10Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 10"+ listaEscalas.get(i).getEscala().getDia10Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia10Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia10Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia10Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia10Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia10Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 10"+ listaEscalas.get(i).getEscala().getDia10Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia10Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=11 && listaLicencas.get(j).getDiaFinal()>=11 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia11Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 11"+ listaEscalas.get(i).getEscala().getDia11Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia11Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia11Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia11Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia11Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia11Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia11Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia11Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia11Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia11Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia11Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia11Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia11Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 11"+ listaEscalas.get(i).getEscala().getDia11Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia11Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia11Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia11Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia11Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia11Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 11"+ listaEscalas.get(i).getEscala().getDia11Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia11Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=12 && listaLicencas.get(j).getDiaFinal()>=12 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia12Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 12"+ listaEscalas.get(i).getEscala().getDia12Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia12Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia12Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia12Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia12Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia12Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia12Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia12Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia12Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia12Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia12Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia12Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia12Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 12"+ listaEscalas.get(i).getEscala().getDia12Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia12Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia12Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia12Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia12Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia12Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 12"+ listaEscalas.get(i).getEscala().getDia12Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia12Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=13 && listaLicencas.get(j).getDiaFinal()>=13 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia13Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 13"+ listaEscalas.get(i).getEscala().getDia13Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia13Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia13Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia13Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia13Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia13Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia13Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia13Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia13Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia13Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia13Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia13Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia13Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 13"+ listaEscalas.get(i).getEscala().getDia13Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia13Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia13Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia13Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia13Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia13Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 13"+ listaEscalas.get(i).getEscala().getDia13Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia13Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=14 && listaLicencas.get(j).getDiaFinal()>=14 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia14Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 14"+ listaEscalas.get(i).getEscala().getDia14Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia14Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia14Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia14Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia14Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia14Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia14Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia14Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia14Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia14Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia14Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia14Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia14Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 14"+ listaEscalas.get(i).getEscala().getDia14Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia14Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia14Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia14Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia14Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia14Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 14"+ listaEscalas.get(i).getEscala().getDia14Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia14Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=15 && listaLicencas.get(j).getDiaFinal()>=15 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia15Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 15"+ listaEscalas.get(i).getEscala().getDia15Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia15Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia15Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia15Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia15Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia15Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia15Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia15Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia15Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia15Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia15Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia15Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia15Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 15"+ listaEscalas.get(i).getEscala().getDia15Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia15Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia15Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia15Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia15Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia15Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 15"+ listaEscalas.get(i).getEscala().getDia15Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia15Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=16 && listaLicencas.get(j).getDiaFinal()>=16 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia16Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 16"+ listaEscalas.get(i).getEscala().getDia16Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia16Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia16Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia16Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia16Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia16Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia16Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia16Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia16Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia16Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia16Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia16Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia16Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 16"+ listaEscalas.get(i).getEscala().getDia16Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia16Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia16Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia16Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia16Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia16Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 16"+ listaEscalas.get(i).getEscala().getDia16Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia16Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=17 && listaLicencas.get(j).getDiaFinal()>=17 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia17Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 17"+ listaEscalas.get(i).getEscala().getDia17Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia17Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia17Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia17Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia17Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia17Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia17Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia17Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia17Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia17Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia17Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia17Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia17Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 17"+ listaEscalas.get(i).getEscala().getDia17Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia17Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia17Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia17Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia17Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia17Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 17"+ listaEscalas.get(i).getEscala().getDia17Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia17Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=18 && listaLicencas.get(j).getDiaFinal()>=18 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia18Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 18"+ listaEscalas.get(i).getEscala().getDia18Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia18Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia18Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia18Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia18Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia18Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia18Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia18Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia18Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia18Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia18Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia18Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia18Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 18"+ listaEscalas.get(i).getEscala().getDia18Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia18Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia18Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia18Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia18Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia18Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 18"+ listaEscalas.get(i).getEscala().getDia18Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia18Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=19 && listaLicencas.get(j).getDiaFinal()>=19 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia19Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 19"+ listaEscalas.get(i).getEscala().getDia19Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia19Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia19Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia19Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia19Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia19Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia19Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia19Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia19Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia19Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia19Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia19Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia19Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 19"+ listaEscalas.get(i).getEscala().getDia19Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia19Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia19Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia19Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia19Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia19Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 19"+ listaEscalas.get(i).getEscala().getDia19Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia19Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=20 && listaLicencas.get(j).getDiaFinal()>=20 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia20Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 20"+ listaEscalas.get(i).getEscala().getDia20Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia20Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia20Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia20Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia20Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia20Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia20Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia20Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia20Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia20Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia20Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia20Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia20Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 20"+ listaEscalas.get(i).getEscala().getDia20Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia20Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia20Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia20Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia20Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia20Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 20"+ listaEscalas.get(i).getEscala().getDia20Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia20Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=21 && listaLicencas.get(j).getDiaFinal()>=21 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia21Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 21"+ listaEscalas.get(i).getEscala().getDia21Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia21Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia21Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia21Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia21Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia21Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia21Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia21Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia21Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia21Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia21Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia21Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia21Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 21"+ listaEscalas.get(i).getEscala().getDia21Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia21Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia21Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia21Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia21Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia21Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 21"+ listaEscalas.get(i).getEscala().getDia21Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia21Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=22 && listaLicencas.get(j).getDiaFinal()>=22 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia22Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 22"+ listaEscalas.get(i).getEscala().getDia22Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia22Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia22Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia22Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia22Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia22Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia22Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia22Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia22Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia22Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia22Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia22Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia22Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 22"+ listaEscalas.get(i).getEscala().getDia22Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia22Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia22Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia22Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia22Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia22Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 22"+ listaEscalas.get(i).getEscala().getDia22Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia22Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=23 && listaLicencas.get(j).getDiaFinal()>=23 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia23Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 23"+ listaEscalas.get(i).getEscala().getDia23Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia23Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia23Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia23Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia23Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia23Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia23Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia23Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia23Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia23Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia23Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia23Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia23Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 23"+ listaEscalas.get(i).getEscala().getDia23Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia23Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia23Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia23Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia23Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia23Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 23"+ listaEscalas.get(i).getEscala().getDia23Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia23Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=24 && listaLicencas.get(j).getDiaFinal()>=24 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia24Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 24"+ listaEscalas.get(i).getEscala().getDia24Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia24Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia24Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia24Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia24Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia24Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia24Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia24Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia24Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia24Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia24Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia24Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia24Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 24"+ listaEscalas.get(i).getEscala().getDia24Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia24Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia24Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia24Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia24Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia24Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 24"+ listaEscalas.get(i).getEscala().getDia24Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia24Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=25 && listaLicencas.get(j).getDiaFinal()>=25 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia25Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 25"+ listaEscalas.get(i).getEscala().getDia25Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia25Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia25Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia25Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia25Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia25Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia25Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia25Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia25Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia25Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia25Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia25Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia25Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 25"+ listaEscalas.get(i).getEscala().getDia25Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia25Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia25Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia25Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia25Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia25Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 25"+ listaEscalas.get(i).getEscala().getDia25Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia25Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=26 && listaLicencas.get(j).getDiaFinal()>=26 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia26Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 26"+ listaEscalas.get(i).getEscala().getDia26Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia26Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia26Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia26Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia26Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia26Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia26Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia26Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia26Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia26Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia26Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia26Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia26Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 26"+ listaEscalas.get(i).getEscala().getDia26Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia26Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia26Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia26Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia26Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia26Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 26"+ listaEscalas.get(i).getEscala().getDia26Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia26Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=27 && listaLicencas.get(j).getDiaFinal()>=27 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia27Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 27"+ listaEscalas.get(i).getEscala().getDia27Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia27Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia27Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia27Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia27Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia27Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia27Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia27Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia27Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia27Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia27Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia27Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia27Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 27"+ listaEscalas.get(i).getEscala().getDia27Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia27Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia27Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia27Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia27Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia27Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 27"+ listaEscalas.get(i).getEscala().getDia27Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia27Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=28 && listaLicencas.get(j).getDiaFinal()>=28 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia28Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 28"+ listaEscalas.get(i).getEscala().getDia28Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia28Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia28Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia28Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia28Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia28Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia28Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia28Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia28Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia28Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia28Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia28Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia28Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 28"+ listaEscalas.get(i).getEscala().getDia28Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia28Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia28Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia28Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia28Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia28Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 28"+ listaEscalas.get(i).getEscala().getDia28Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia28Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=29 && listaLicencas.get(j).getDiaFinal()>=29 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia29Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 29"+ listaEscalas.get(i).getEscala().getDia29Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia29Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia29Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia29Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia29Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia29Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia29Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia29Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia29Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia29Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia29Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia29Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia29Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 29"+ listaEscalas.get(i).getEscala().getDia29Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia29Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia29Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia29Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia29Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia29Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 29"+ listaEscalas.get(i).getEscala().getDia29Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia29Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=30 && listaLicencas.get(j).getDiaFinal()>=30 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia30Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 30"+ listaEscalas.get(i).getEscala().getDia30Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia30Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia30Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia30Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia30Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia30Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia30Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia30Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia30Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia30Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia30Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia30Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia30Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 30"+ listaEscalas.get(i).getEscala().getDia30Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia30Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia30Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia30Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia30Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia30Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 30"+ listaEscalas.get(i).getEscala().getDia30Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia30Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								//Tratando Turnos
								if(listaLicencas.get(j).getDiaInicial()<=31 && listaLicencas.get(j).getDiaFinal()>=31 ){
									listaEscalas.get(i).getReferencias().setDiasLicenca( listaEscalas.get(i).getReferencias().getDiasLicenca()+1 );
									
									//Tirando os noturnos
									if(listaLicencas.get(j).getFuncionariosLicencas().getIdCorteAdicionalNoturnoSimNaoFk().getSigla().equalsIgnoreCase("S")) {
										if(listaEscalas.get(i).getEscala().getDia31Fk().getHorasNoite()>0) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 31"+ listaEscalas.get(i).getEscala().getDia31Fk().getHorasNoite());
										}
										listaEscalas.get(i).getEscala().getDia31Fk().setPlantoes( 0.0 );
										listaEscalas.get(i).getEscala().getDia31Fk().setHorasManha( listaEscalas.get(i).getEscala().getDia31Fk().getHorasManha()+ listaEscalas.get(i).getEscala().getDia31Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia31Fk().setHorasTarde( listaEscalas.get(i).getEscala().getDia31Fk().getHorasTarde()+ listaEscalas.get(i).getEscala().getDia31Fk().getHorasNoite()/2 );
										listaEscalas.get(i).getEscala().getDia31Fk().setHorasNoite( 0 );
									}
									
									//Tirando horas Efetivas
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia31Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia31Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia31Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia31Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 31"+ listaEscalas.get(i).getEscala().getDia31Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia31Fk(turnosService.buscarPorNome(""));
									}
									
									//Tirando horas Extras
									if(  (listaLicencas.get(j).getFuncionariosLicencas().getIdCorteFolhaExtraSimNaoFk().getSigla().equalsIgnoreCase("S"))   && (listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N"))   ) {
										listaEscalas.get(i).getReferencias().setHorasLicencaDescontadas( listaEscalas.get(i).getReferencias().getHorasLicencaDescontadas() + listaEscalas.get(i).getEscala().getDia31Fk().getHorasManha() + listaEscalas.get(i).getEscala().getDia31Fk().getHorasTarde() + listaEscalas.get(i).getEscala().getDia31Fk().getHorasNoite() );
										if(listaEscalas.get(i).getEscala().getDia31Fk()!=turnosService.buscarPorNome("")) {
											listaEscalas.get(i).getReferencias().setObsReferencias( listaEscalas.get(i).getReferencias().getObsReferencias()+ " 31"+ listaEscalas.get(i).getEscala().getDia31Fk().getNomeTurno());
										}
										listaEscalas.get(i).getEscala().setDia31Fk(turnosService.buscarPorNome(""));
									}
									
								}
								
								
								
								
								
								
								
								
							listaEscalas.get(i).getReferencias().setObsReferencias(listaEscalas.get(i).getReferencias().getObsReferencias()+"; ");
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
	
	
	
	public List<RubricasVencimento> obterVencimentosDiferenciadoPorEscala(List<EscalasNoMes> listaEscalas, List<FeriasNoMes> listaFerias , AnoMes anoMes) {
		List<FaixasValoresParametrosCalculoFolhasExtras> listaValoresExtra = faixasValoresParametrosCalculoFolhasExtrasService.buscarPorMesExato(anoMes); 
		List<RubricasVencimento> lista = new ArrayList<>();
		
		
		
		
		//Para pessoas que nao tem diferenciacao atribuída e sao de folhas variaveis 
		for(int i=0;i<listaEscalas.size();i++) {
			System.out.println("PPPP:"+"INICIOU A:"+i);
			if(escalaCodDiferenciadoService.buscarPorEscala(listaEscalas.get(i).getEscala()).isEmpty()) {
				for(int j=0;j<listaValoresExtra.size();j++) {
					RubricasVencimento r = new RubricasVencimento();
					
					if(
						listaEscalas.get(i).getEscala().getIdAnoMesFk() == listaValoresExtra.get(j).getIdAnoMesFk() &&  	
						(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("RESIDENTE")) &&
						listaEscalas.get(i).getEscala().getIdTipoFolhaFk() == listaValoresExtra.get(j).getIdTipoDeFolhaFk() &&
						listaEscalas.get(i).getEscala().getIdRegimeFk() == listaValoresExtra.get(j).getIdRegimeDeTrabalhoFk() &&
						listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk() == listaValoresExtra.get(j).getIdNivelFk() &&
						listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk() == listaValoresExtra.get(j).getIdCodDiferenciadoFk().getIdUnidadeFk() &&   
						listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdTipoRemuneracaoFk().getNomeTipoRemuneracao().equalsIgnoreCase("VARIAVEL") &&
						listaValoresExtra.get(j).getIdCodDiferenciadoFk().getNomeCodigoDiferenciado().equalsIgnoreCase("N") 
						
					) {
						Double valorBruto = 0.0;
						Double valorLiquido = 0.0;
						
						int horasDia = listaEscalas.get(i).getEscala().getHorasDia();
						int horasNoite = listaEscalas.get(i).getEscala().getHorasNoite();
						int horasSemana = listaEscalas.get(i).getEscala().getHorasSemana();
						int horasFimSemana = listaEscalas.get(i).getEscala().getHorasFimSemana();
						int horasTotais = listaEscalas.get(i).getEscala().getHorasTotais();
						
						Double valorHorasDia = listaValoresExtra.get(j).getValorHoraDia();
						Double valorHorasNoite = listaValoresExtra.get(j).getValorHoraNoite();
						Double valorHorasSemana = listaValoresExtra.get(j).getValorHoraSemana();
						Double valorHorasFimSemana = listaValoresExtra.get(j).getValorHoraFimDeSemana();
						Double valorHorasTotaisBruta = listaValoresExtra.get(j).getValorBrutoPorHora();
						Double valorHorasTotaisLiquida =  listaValoresExtra.get(j).getValorLiquidoPorHora();
						
						if(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) {
							valorBruto= (horasDia*valorHorasDia) + (horasNoite*valorHorasNoite) + (horasSemana*valorHorasSemana) + (horasFimSemana*valorHorasFimSemana) + (horasTotais*valorHorasTotaisBruta);
						}
						
						if(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) {
							valorLiquido= (horasDia*valorHorasDia) + (horasNoite*valorHorasNoite) + (horasSemana*valorHorasSemana) + (horasFimSemana*valorHorasFimSemana) + (horasTotais*valorHorasTotaisLiquida);
						}
						
						r.setAnoMes(anoMes);
						r.setSequencia(1);
						r.setCodigo(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getNomeCodigoDiferenciado());
						r.setDescricao(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getDescricaoCodigoDiferenciado());
						r.setFonte(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getIdFonteFk());
						r.setNatureza(rubricaNaturezaService.buscarPorSigla("V").get(0));
						r.setPercentagem(0.0);
						r.setPessoaFuncionarios(listaEscalas.get(i).getEscala().getIdFuncionarioFk());
						r.setTipoBrutoLiquido(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getIdTipoBrutoLiquidoFk());
						r.setUnidade(listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk());
						r.setVariacao(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getVariacao());
						r.setValorBruto(valorBruto);
						r.setValorLiquido(valorLiquido);
						r.setValorIr(0.0);
						r.setValorPatronal(0.0);
						r.setValorPrevidencia(0.0);
						r.setTiposDeFolha(listaEscalas.get(i).getEscala().getIdTipoFolhaFk());
						
						if(valorBruto+valorLiquido>0) {lista.add(r);}
					}
				}
			}
			System.out.println("PPPP:"+"TERMINOU A");
		}
		
		
		
		
		
		
		
			//Para pessoas que nao tem diferenciacao atribuída e sao de folhas fixas 
				for(int i=0;i<listaEscalas.size();i++) {
					if(escalaCodDiferenciadoService.buscarPorEscala(listaEscalas.get(i).getEscala()).isEmpty()) {
						for(int j=0;j<listaValoresExtra.size();j++) {
							RubricasVencimento r = new RubricasVencimento();
							
							if(
								listaEscalas.get(i).getEscala().getIdAnoMesFk() == listaValoresExtra.get(j).getIdAnoMesFk() &&  
								(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("RESIDENTE")) &&
								listaEscalas.get(i).getEscala().getIdTipoFolhaFk() == listaValoresExtra.get(j).getIdTipoDeFolhaFk() &&
								listaEscalas.get(i).getEscala().getIdRegimeFk() == listaValoresExtra.get(j).getIdRegimeDeTrabalhoFk() &&
								listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk() == listaValoresExtra.get(j).getIdNivelFk() &&
								listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk() == listaValoresExtra.get(j).getIdCodDiferenciadoFk().getIdUnidadeFk() &&   
								listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdTipoRemuneracaoFk().getNomeTipoRemuneracao().equalsIgnoreCase("FIXA") &&
								listaValoresExtra.get(j).getIdCodDiferenciadoFk().getNomeCodigoDiferenciado().equalsIgnoreCase("N") 
								
							) {
								Double valorBruto = 0.0;
								Double valorLiquido = 0.0;
								
								Double valorBrutoFixoTotal = listaValoresExtra.get(j).getValorBrutoFixoTotal();
								
								if(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) {
									valorBruto= (valorBrutoFixoTotal);
								}
								
								
								r.setAnoMes(anoMes);
								r.setSequencia(1);
								r.setCodigo(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getNomeCodigoDiferenciado());
								r.setDescricao(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getDescricaoCodigoDiferenciado());
								r.setFonte(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getIdFonteFk());
								r.setNatureza(rubricaNaturezaService.buscarPorSigla("V").get(0));
								r.setPercentagem(0.0);
								r.setPessoaFuncionarios(listaEscalas.get(i).getEscala().getIdFuncionarioFk());
								r.setTipoBrutoLiquido(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getIdTipoBrutoLiquidoFk());
								r.setUnidade(listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk());
								r.setVariacao(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getVariacao());
								r.setValorBruto(valorBruto);
								r.setValorLiquido(valorLiquido);
								r.setValorIr(0.0);
								r.setValorPatronal(0.0);
								r.setValorPrevidencia(0.0);
								r.setTiposDeFolha(listaEscalas.get(i).getEscala().getIdTipoFolhaFk());
								
								if(valorBruto+valorLiquido>0) {
									if(!lista.contains(r)) {lista.add(r);
									}
								}
							}
						}
					}
				}
		
				
				
				
		
		
				
				
			//Para Incentivo de Risco
				List<FaixasValoresIncentivoDeRisco> listaIncentivoDeRisco = faixasValoresIncentivoDeRiscoService.buscarPorMesExato(anoMes);
				for(int i=0;i<listaEscalas.size();i++) {
					if(escalaCodDiferenciadoService.buscarPorEscala(listaEscalas.get(i).getEscala()).isEmpty()) {
						for(int j=0;j<listaIncentivoDeRisco.size();j++) {
							RubricasVencimento r = new RubricasVencimento();
							if(
								listaEscalas.get(i).getEscala().getIdAnoMesFk() == listaIncentivoDeRisco.get(j).getIdAnoMesFk() &&  
								(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("RESIDENTE")) &&
								listaEscalas.get(i).getEscala().getIdIncrementoDeRiscoSimNaoFk().getSigla().equalsIgnoreCase("S") &&
								listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk() == listaIncentivoDeRisco.get(j).getIdUnidadeFk() 
								 
							) {
								
								//Calculando Valores
								Double valorBruto = 0.0;
								Double valorLiquido = 0.0;
								int horasTotais = listaEscalas.get(i).getEscala().getHorasTotais();
								Double valorBrutoFixoTotal = listaIncentivoDeRisco.get(j).getValor();
								Double valorPorHora = (valorBrutoFixoTotal/(listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria()*4) );
								
								Double valorDaLinha = (valorPorHora*horasTotais) ;
								
								//Avaliando se já tem alguma linha já cadastrada
								Double valorCadastrado = 0.0;
								for(int k=0;k<lista.size();k++) {
									if(lista.get(k).getAnoMes()==anoMes &&
										lista.get(k).getCodigo().equalsIgnoreCase("RISCO") &&
										lista.get(k).getPessoaFuncionarios()==listaEscalas.get(i).getEscala().getIdFuncionarioFk()
									) {
										valorCadastrado = valorCadastrado+lista.get(k).getValorBruto();
									}
								}
								
								// Ajustando casas decimais
								if(valorCadastrado+valorDaLinha>valorBrutoFixoTotal) {valorDaLinha=valorBrutoFixoTotal-valorCadastrado;}
								if(valorDaLinha<0) {valorDaLinha=0.0;}
								valorDaLinha = UtilidadesMatematicas.ajustaValorDecimal(valorDaLinha, 2);
								valorBruto=valorDaLinha;
								
								r.setAnoMes(anoMes);
								r.setSequencia(1);
								r.setCodigo("RISCO");
								r.setDescricao("INCENTIVO DE RISCO");
								r.setFonte(listaIncentivoDeRisco.get(j).getIdFonteFk());
								r.setNatureza(rubricaNaturezaService.buscarPorSigla("V").get(0));
								r.setPercentagem(0.0);
								r.setPessoaFuncionarios(listaEscalas.get(i).getEscala().getIdFuncionarioFk());
								r.setTipoBrutoLiquido(listaIncentivoDeRisco.get(j).getIdTipoBrutoLiquidoFk());
								r.setUnidade(listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk());
								r.setVariacao("00");
								r.setValorBruto(valorBruto);
								r.setValorLiquido(valorLiquido);
								r.setValorIr(0.0);
								r.setValorPatronal(0.0);
								r.setValorPrevidencia(0.0);
								r.setTiposDeFolha(listaEscalas.get(i).getEscala().getIdTipoFolhaFk());
								
								if(valorBruto+valorLiquido>0) {
									if(!lista.contains(r)) {lista.add(r);
									}
								}
							}
						}
					}
				}
			
			
			
				
		
				
				
				
				
				
				
				//Para pessoas que SIM têm diferenciacao atribuído e sao de folhas variaveis 
				for(int i=0;i<listaEscalas.size();i++) {
					if(!escalaCodDiferenciadoService.buscarPorEscala(listaEscalas.get(i).getEscala()).isEmpty()) {
						List<EscalaCodDiferenciado> listaDiferenciados = escalaCodDiferenciadoService.buscarPorEscala(listaEscalas.get(i).getEscala());
						for(int k=0;k<listaDiferenciados.size();k++) {
							for(int j=0;j<listaValoresExtra.size();j++) {
								RubricasVencimento r = new RubricasVencimento();
								
								
								if(
										listaDiferenciados.get(k).getIdEscalaFk().getIdAnoMesFk() == listaValoresExtra.get(j).getIdAnoMesFk() &&  
										(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("RESIDENTE")) &&
										listaDiferenciados.get(k).getIdEscalaFk().getIdTipoFolhaFk() == listaValoresExtra.get(j).getIdTipoDeFolhaFk() &&
										listaDiferenciados.get(k).getIdEscalaFk().getIdRegimeFk() == listaValoresExtra.get(j).getIdRegimeDeTrabalhoFk() &&
										listaDiferenciados.get(k).getIdCodigoDiferenciadoFk() == listaValoresExtra.get(j).getIdCodDiferenciadoFk() &&
										listaDiferenciados.get(k).getIdEscalaFk().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk() == listaValoresExtra.get(j).getIdNivelFk() &&
										listaDiferenciados.get(k).getIdEscalaFk().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk() == listaValoresExtra.get(j).getIdCodDiferenciadoFk().getIdUnidadeFk() &&   
										listaDiferenciados.get(k).getIdEscalaFk().getIdTipoFolhaFk().getIdTipoRemuneracaoFk().getNomeTipoRemuneracao().equalsIgnoreCase("VARIAVEL") 
										 
										
									) {
									
									
										Double valorBruto = 0.0;
										Double valorLiquido = 0.0;
										
										int horasDia = listaEscalas.get(i).getEscala().getHorasDia();
										int horasNoite = listaEscalas.get(i).getEscala().getHorasNoite();
										int horasSemana = listaEscalas.get(i).getEscala().getHorasSemana();
										int horasFimSemana = listaEscalas.get(i).getEscala().getHorasFimSemana();
										int horasTotais = listaEscalas.get(i).getEscala().getHorasTotais();
										
										Double valorHorasDia = listaValoresExtra.get(j).getValorHoraDia();
										Double valorHorasNoite = listaValoresExtra.get(j).getValorHoraNoite();
										Double valorHorasSemana = listaValoresExtra.get(j).getValorHoraSemana();
										Double valorHorasFimSemana = listaValoresExtra.get(j).getValorHoraFimDeSemana();
										Double valorHorasTotaisBruta = listaValoresExtra.get(j).getValorBrutoPorHora();
										Double valorHorasTotaisLiquida =  listaValoresExtra.get(j).getValorLiquidoPorHora();
										
										if(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) {
											valorBruto= (horasDia*valorHorasDia) + (horasNoite*valorHorasNoite) + (horasSemana*valorHorasSemana) + (horasFimSemana*valorHorasFimSemana) + (horasTotais*valorHorasTotaisBruta);
										}
										
										if(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) {
											valorLiquido= (horasDia*valorHorasDia) + (horasNoite*valorHorasNoite) + (horasSemana*valorHorasSemana) + (horasFimSemana*valorHorasFimSemana) + (horasTotais*valorHorasTotaisLiquida);
										}
										
										r.setAnoMes(anoMes);
										r.setSequencia(1);
										r.setCodigo(listaDiferenciados.get(k).getIdCodigoDiferenciadoFk().getNomeCodigoDiferenciado());
										r.setDescricao(listaDiferenciados.get(k).getIdCodigoDiferenciadoFk().getDescricaoCodigoDiferenciado());
										r.setFonte(listaDiferenciados.get(k).getIdCodigoDiferenciadoFk().getIdFonteFk());
										r.setNatureza(rubricaNaturezaService.buscarPorSigla("V").get(0));
										r.setPercentagem(0.0);
										r.setPessoaFuncionarios(listaDiferenciados.get(k).getIdEscalaFk().getIdFuncionarioFk());
										r.setTipoBrutoLiquido(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getIdTipoBrutoLiquidoFk());
										r.setUnidade(listaDiferenciados.get(k).getIdEscalaFk().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk());
										r.setVariacao(listaValoresExtra.get(j).getIdCodDiferenciadoFk().getVariacao());
										r.setValorBruto(valorBruto);
										r.setValorLiquido(valorLiquido);
										r.setValorIr(0.0);
										r.setValorPatronal(0.0);
										r.setValorPrevidencia(0.0);
										r.setTiposDeFolha(listaEscalas.get(i).getEscala().getIdTipoFolhaFk());
										
										if(valorBruto+valorLiquido>0) {lista.add(r);}
									}
								
							
							}
						}
					}
				}
				
				
	
				
				
				
				
				
				
				
				//Para Gpf Comum Técnica
				List<FaixasValoresGpf> listaGpf = faixasValoresGpfService.buscarPorMesExato(anoMes);
				for(int i=0;i<listaEscalas.size();i++) {
					if(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T")) {
						if(escalaCodDiferenciadoService.buscarPorEscala(listaEscalas.get(i).getEscala()).isEmpty()) {
							boolean temIrf = false;
							if(!vencimentosFuncionarioService.buscarPorMesExatoEFuncionarioETipo(anoMes, listaEscalas.get(i).getEscala().getIdFuncionarioFk(), "IRF"  ).isEmpty()) {temIrf = true;}
							
							for(int j=0;j<listaGpf.size();j++) {
								RubricasVencimento r = new RubricasVencimento();
								if(
									listaEscalas.get(i).getEscala().getIdAnoMesFk() == listaGpf.get(j).getIdAnoMesFk() &&  	
									(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("RESIDENTE")) &&
									listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk() == listaGpf.get(j).getIdUnidadeFk() && 
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdCargaHorariaAtualFk() == listaGpf.get(j).getIdCargaHorariaSemanalFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk() == listaGpf.get(j).getIdNivelCargoFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdClasseCarreiraAtualFk() == listaGpf.get(j).getIdClasseCarreiraFk() &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S") &&
									listaEscalas.get(i).getEscala().getIdComplementoPlantaoSimNaoFk().getSigla().equalsIgnoreCase("N") &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S") &&
									temIrf==false
									 
								) {
									
									//Calculando Valores
									Double valorBruto = 0.0;
									Double valorLiquido = 0.0;
									int horasTotais = listaEscalas.get(i).getEscala().getHorasTotais();
									Double valorBrutoFixoTotal = listaGpf.get(j).getValor();
									Double valorPorHora = (valorBrutoFixoTotal/(listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria()*4) );
									
									Double valorDaLinha = (valorPorHora*horasTotais) ;
									
									//Avaliando se já tem alguma linha já cadastrada
									Double valorCadastrado = 0.0;
									for(int k=0;k<lista.size();k++) {
										if( Long.parseLong(listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdPessoaFk().getCpf())  <  Long.parseLong(lista.get(k).getPessoaFuncionarios().getIdPessoaFk().getCpf()) ) {break;}
										if(lista.get(k).getAnoMes()==anoMes &&
											lista.get(k).getCodigo().equalsIgnoreCase("COMPL PLANT COMUM") &&
											lista.get(k).getPessoaFuncionarios()==listaEscalas.get(i).getEscala().getIdFuncionarioFk()
										) {
											valorCadastrado = valorCadastrado+lista.get(k).getValorBruto();
										}
									}
									
									// Ajustando casas decimais
									if(valorCadastrado+valorDaLinha>valorBrutoFixoTotal) {valorDaLinha=valorBrutoFixoTotal-valorCadastrado;}
									if(valorDaLinha<0) {valorDaLinha=0.0;}
									valorDaLinha = UtilidadesMatematicas.ajustaValorDecimal(valorDaLinha, 2);
									valorBruto=valorDaLinha;
									
									r.setAnoMes(anoMes);
									r.setSequencia(1);
									r.setCodigo("COMPL PLANT COMUM");
									r.setDescricao("COMPLEMENTO DE PLANTAO COMUM TECNICA");
									r.setFonte(listaGpf.get(j).getIdFonteFk());
									r.setNatureza(rubricaNaturezaService.buscarPorSigla("V").get(0));
									r.setPercentagem(0.0);
									r.setPessoaFuncionarios(listaEscalas.get(i).getEscala().getIdFuncionarioFk());
									r.setTipoBrutoLiquido(listaGpf.get(j).getIdTipoBrutoLiquidoFk());
									r.setUnidade(listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk());
									r.setVariacao("00");
									r.setValorBruto(valorBruto);
									r.setValorLiquido(valorLiquido);
									r.setValorIr(0.0);
									r.setValorPatronal(0.0);
									r.setValorPrevidencia(0.0);
									r.setTiposDeFolha(listaEscalas.get(i).getEscala().getIdTipoFolhaFk());
									
									if(valorBruto+valorLiquido>0) {
										if(!lista.contains(r)) {lista.add(r);
										}
									}
								}
							}
						}
					}
				}
			

				
				
				//Para Gpf Tecnica Diferenciada
				List<FaixasValoresGpfDiferenciada> listaGpfTecnicaDiferenciada = faixasValoresGpfDiferenciadaService.buscarPorMesExato(anoMes);
				for(int i=0;i<listaEscalas.size();i++) {
					if(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T")) {
						if(escalaCodDiferenciadoService.buscarPorEscala(listaEscalas.get(i).getEscala()).isEmpty()) {
							boolean temIrf = false;
							if(!vencimentosFuncionarioService.buscarPorMesExatoEFuncionarioETipo(anoMes, listaEscalas.get(i).getEscala().getIdFuncionarioFk(), "IRF"  ).isEmpty()) {temIrf = true;}
							
							for(int j=0;j<listaGpfTecnicaDiferenciada.size();j++) {
								RubricasVencimento r = new RubricasVencimento();
								if(
									listaEscalas.get(i).getEscala().getIdAnoMesFk() == listaGpfTecnicaDiferenciada.get(j).getIdAnoMesFk() && 
									(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("RESIDENTE")) &&
									listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk() == listaGpfTecnicaDiferenciada.get(j).getIdUnidadeFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk() == listaGpfTecnicaDiferenciada.get(j).getIdEspecialidadeFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdCargaHorariaAtualFk() == listaGpfTecnicaDiferenciada.get(j).getIdCargaHorariaSemanalFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk() == listaGpfTecnicaDiferenciada.get(j).getIdNivelCargoFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdClasseCarreiraAtualFk() == listaGpfTecnicaDiferenciada.get(j).getIdClasseCarreiraFk() &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S") &&
									listaEscalas.get(i).getEscala().getIdComplementoPlantaoSimNaoFk().getSigla().equalsIgnoreCase("S") &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S") &&
									temIrf==false
									 
								) {
									
									//Calculando Valores
									Double valorBruto = 0.0;
									Double valorLiquido = 0.0;
									int horasTotais = listaEscalas.get(i).getEscala().getHorasTotais();
									Double valorGlobal = listaGpfTecnicaDiferenciada.get(j).getValor();
									Double valorPorHora = (listaGpfTecnicaDiferenciada.get(j).getValor() / listaGpfTecnicaDiferenciada.get(j).getIdCargaHorariaSemanalFk().getCargaHoraria()) ;
									
									Double valorDaLinha = (horasTotais*valorPorHora) ;
									
									//Avaliando se já tem alguma linha já cadastrada
									Double valorCadastrado = 0.0;
									for(int k=0;k<lista.size();k++) {
										if( Long.parseLong(listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdPessoaFk().getCpf())  <  Long.parseLong(lista.get(k).getPessoaFuncionarios().getIdPessoaFk().getCpf()) ) {break;}
										if(lista.get(k).getAnoMes()==anoMes &&
											lista.get(k).getCodigo().equalsIgnoreCase("COMPL PLANT DIFERENCIADO") &&
											lista.get(k).getPessoaFuncionarios()==listaEscalas.get(i).getEscala().getIdFuncionarioFk()
										) {
											valorCadastrado = valorCadastrado+lista.get(k).getValorBruto();
										}
									}
									
									// Ajustando casas decimais
									if(valorDaLinha<0) {valorDaLinha=0.0;}
									if(valorCadastrado+valorDaLinha>valorGlobal) {valorDaLinha=valorGlobal-valorCadastrado;}
									valorDaLinha = UtilidadesMatematicas.ajustaValorDecimal(valorDaLinha, 2);
									if(listaGpfTecnicaDiferenciada.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) {valorBruto=valorDaLinha;}
									if(listaGpfTecnicaDiferenciada.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) {valorLiquido=valorDaLinha;}
									
									
									r.setAnoMes(anoMes);
									r.setSequencia(1);
									r.setCodigo("COMPL PLANT DIFERENCIADO");
									r.setDescricao("COMPLEMENTO DE PLANTAO DIFERENCIADO TECNICA");
									r.setFonte(listaGpfTecnicaDiferenciada.get(j).getIdFonteFk());
									r.setNatureza(rubricaNaturezaService.buscarPorSigla("V").get(0));
									r.setPercentagem(0.0);
									r.setPessoaFuncionarios(listaEscalas.get(i).getEscala().getIdFuncionarioFk());
									r.setTipoBrutoLiquido(listaGpfTecnicaDiferenciada.get(j).getIdTipoBrutoLiquidoFk());
									r.setUnidade(listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk());
									r.setVariacao("00");
									r.setValorBruto(valorBruto);
									r.setValorLiquido(valorLiquido);
									r.setValorIr(0.0);
									r.setValorPatronal(0.0);
									r.setValorPrevidencia(0.0);
									r.setTiposDeFolha(listaEscalas.get(i).getEscala().getIdTipoFolhaFk());
									
									if(valorBruto+valorLiquido>0) {
										if(!lista.contains(r)) {lista.add(r);
										}
									}
								}
							}
						}
					}
				}
				
	
				
				
				
				
				
				
				
				
				
				
				
				//Para Gpf Comum Medica
				List<FaixasValoresGpfMedica> listaGpfMedica = faixasValoresGpfMedicaService.buscarPorMesExato(anoMes);
				for(int i=0;i<listaEscalas.size();i++) {
					if(listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T")) {
						if(escalaCodDiferenciadoService.buscarPorEscala(listaEscalas.get(i).getEscala()).isEmpty()) {
							boolean temIrf = false;
							if(!vencimentosFuncionarioService.buscarPorMesExatoEFuncionarioETipo(anoMes, listaEscalas.get(i).getEscala().getIdFuncionarioFk(), "IRF"  ).isEmpty()) {temIrf = true;}
							
							for(int j=0;j<listaGpfMedica.size();j++) {
								RubricasVencimento r = new RubricasVencimento();
								if(
									listaEscalas.get(i).getEscala().getIdAnoMesFk() == listaGpfMedica.get(j).getIdAnoMesFk() &&  
									(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("RESIDENTE")) &&
									listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk() == listaGpfMedica.get(j).getIdUnidadeFk() && 
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdCargaHorariaAtualFk() == listaGpfMedica.get(j).getIdCargaHorariaSemanalFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk() == listaGpfMedica.get(j).getIdNivelCargoFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdClasseCarreiraAtualFk() == listaGpfMedica.get(j).getIdClasseCarreiraFk() &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S") &&
									listaEscalas.get(i).getEscala().getIdComplementoPlantaoSimNaoFk().getSigla().equalsIgnoreCase("N") &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S") &&
									temIrf==false
									 
								) {
									
									//Calculando Valores
									Double valorBruto = 0.0;
									Double valorLiquido = 0.0;
									int horasSemana = listaEscalas.get(i).getEscala().getHorasSemana();
									int horasFimSemana = listaEscalas.get(i).getEscala().getHorasFimSemana();
									Double valorPorHoraSemana = listaGpfMedica.get(j).getValorSemana();
									Double valorPorHoraFimSemana = listaGpfMedica.get(j).getValorFimSemana();
									
									Double valorDaLinha = ((horasSemana*valorPorHoraSemana)+horasFimSemana*(valorPorHoraFimSemana)) ;
									
									//Avaliando se já tem alguma linha já cadastrada
									Double valorCadastrado = 0.0;
									for(int k=0;k<lista.size();k++) {
										if( Long.parseLong(listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdPessoaFk().getCpf())  <  Long.parseLong(lista.get(k).getPessoaFuncionarios().getIdPessoaFk().getCpf()) ) {break;}
										if(lista.get(k).getAnoMes()==anoMes &&
											lista.get(k).getCodigo().equalsIgnoreCase("COMPL PLANT COMUM") &&
											lista.get(k).getPessoaFuncionarios()==listaEscalas.get(i).getEscala().getIdFuncionarioFk()
										) {
											valorCadastrado = valorCadastrado+lista.get(k).getValorBruto();
										}
									}
									
									// Ajustando casas decimais
									if(valorDaLinha<0) {valorDaLinha=0.0;}
									valorDaLinha = UtilidadesMatematicas.ajustaValorDecimal(valorDaLinha, 2);
									valorBruto=valorDaLinha;
									
									r.setAnoMes(anoMes);
									r.setSequencia(1);
									r.setCodigo("COMPL PLANT COMUM");
									r.setDescricao("COMPLEMENTO DE PLANTAO COMUM MEDICA");
									r.setFonte(listaGpfMedica.get(j).getIdFonteFk());
									r.setNatureza(rubricaNaturezaService.buscarPorSigla("V").get(0));
									r.setPercentagem(0.0);
									r.setPessoaFuncionarios(listaEscalas.get(i).getEscala().getIdFuncionarioFk());
									r.setTipoBrutoLiquido(listaGpfMedica.get(j).getIdTipoBrutoLiquidoFk());
									r.setUnidade(listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk());
									r.setVariacao("01");
									r.setValorBruto(valorBruto);
									r.setValorLiquido(valorLiquido);
									r.setValorIr(0.0);
									r.setValorPatronal(0.0);
									r.setValorPrevidencia(0.0);
									r.setTiposDeFolha(listaEscalas.get(i).getEscala().getIdTipoFolhaFk());
									
									if(valorBruto+valorLiquido>0) {
										if(!lista.contains(r)) {lista.add(r);
										}
									}
								}
							}
						}
					}
				}
				
				
				
				
				
				
				
				//Para Gpf Medica Diferenciada
				List<FaixasValoresGpfMedicaDiferenciada> listaGpfMedicaDiferenciada = faixasValoresGpfMedicaDiferenciadaService.buscarPorMesExato(anoMes);
				for(int i=0;i<listaEscalas.size();i++) {
					if(listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T")) {
						if(escalaCodDiferenciadoService.buscarPorEscala(listaEscalas.get(i).getEscala()).isEmpty()) {
							boolean temIrf = false;
							if(!vencimentosFuncionarioService.buscarPorMesExatoEFuncionarioETipo(anoMes, listaEscalas.get(i).getEscala().getIdFuncionarioFk(), "IRF"  ).isEmpty()) {temIrf = true;}
							
							for(int j=0;j<listaGpfMedicaDiferenciada.size();j++) {
								RubricasVencimento r = new RubricasVencimento();
								if(
									listaEscalas.get(i).getEscala().getIdAnoMesFk() == listaGpfMedicaDiferenciada.get(j).getIdAnoMesFk() &&  	
									(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("RESIDENTE")) &&
									(!listaEscalas.get(i).getEscala().getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("D")) &&  	
									listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk() == listaGpfMedicaDiferenciada.get(j).getIdUnidadeFk() && 
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdCargaHorariaAtualFk() == listaGpfMedicaDiferenciada.get(j).getIdCargaHorariaSemanalFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk() == listaGpfMedicaDiferenciada.get(j).getIdNivelCargoFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdClasseCarreiraAtualFk() == listaGpfMedicaDiferenciada.get(j).getIdClasseCarreiraFk() &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S") &&
									listaEscalas.get(i).getEscala().getIdComplementoPlantaoSimNaoFk().getSigla().equalsIgnoreCase("S") &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S") &&
									temIrf==false
									 
								) {
									
									//Calculando Valores
									Double valorBruto = 0.0;
									Double valorLiquido = 0.0;
									int horasTotais = listaEscalas.get(i).getEscala().getHorasTotais();
									Double valorGlobal = listaGpfMedicaDiferenciada.get(j).getValor();
									Double valorPorHora = (listaGpfMedicaDiferenciada.get(j).getValor() / listaGpfMedicaDiferenciada.get(j).getIdCargaHorariaSemanalFk().getCargaHoraria()) ;
									
									Double valorDaLinha = (horasTotais*valorPorHora) ;
									
									//Avaliando se já tem alguma linha já cadastrada
									Double valorCadastrado = 0.0;
									for(int k=0;k<lista.size();k++) {
										if( Long.parseLong(listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdPessoaFk().getCpf())  <  Long.parseLong(lista.get(k).getPessoaFuncionarios().getIdPessoaFk().getCpf()) ) {break;}
										if(lista.get(k).getAnoMes()==anoMes &&
											lista.get(k).getCodigo().equalsIgnoreCase("COMPL PLANT DIFERENCIADO") &&
											lista.get(k).getPessoaFuncionarios()==listaEscalas.get(i).getEscala().getIdFuncionarioFk()
										) {
											valorCadastrado = valorCadastrado+lista.get(k).getValorBruto();
										}
									}
									
									// Ajustando casas decimais
									if(valorDaLinha<0) {valorDaLinha=0.0;}
									if(valorCadastrado+valorDaLinha>valorGlobal) {valorDaLinha=valorGlobal-valorCadastrado;}
									valorDaLinha = UtilidadesMatematicas.ajustaValorDecimal(valorDaLinha, 2);
									if(listaGpfMedicaDiferenciada.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) {valorBruto=valorDaLinha;}
									if(listaGpfMedicaDiferenciada.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) {valorLiquido=valorDaLinha;}
									
									
									
									r.setAnoMes(anoMes);
									r.setSequencia(1);
									r.setCodigo("COMPL PLANT DIFERENCIADO");
									r.setDescricao("COMPLEMENTO DE PLANTAO DIFERENCIADO MEDICA");
									r.setFonte(listaGpfMedicaDiferenciada.get(j).getIdFonteFk());
									r.setNatureza(rubricaNaturezaService.buscarPorSigla("V").get(0));
									r.setPercentagem(0.0);
									r.setPessoaFuncionarios(listaEscalas.get(i).getEscala().getIdFuncionarioFk());
									r.setTipoBrutoLiquido(listaGpfMedicaDiferenciada.get(j).getIdTipoBrutoLiquidoFk());
									r.setUnidade(listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk());
									r.setVariacao("01");
									r.setValorBruto(valorBruto);
									r.setValorLiquido(valorLiquido);
									r.setValorIr(0.0);
									r.setValorPatronal(0.0);
									r.setValorPrevidencia(0.0);
									r.setTiposDeFolha(listaEscalas.get(i).getEscala().getIdTipoFolhaFk());
									
									if(valorBruto+valorLiquido>0) {
										if(!lista.contains(r)) {lista.add(r);
										}
									}
								}
							}
						}
					}
				}
				
				
				
				
				
				
				
				
				
				
				//Para Gpf Medica Diferenciada
				List<FaixasValoresGpfMedicaDiferenciadaDiarista> listaGpfMedicaDiferenciadaDiarista = faixasValoresGpfMedicaDiferenciadaDiaristaService.buscarPorMesExato(anoMes);
				for(int i=0;i<listaEscalas.size();i++) {
					if(listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T")) {
						if(escalaCodDiferenciadoService.buscarPorEscala(listaEscalas.get(i).getEscala()).isEmpty()) {
							boolean temIrf = false;
							if(!vencimentosFuncionarioService.buscarPorMesExatoEFuncionarioETipo(anoMes, listaEscalas.get(i).getEscala().getIdFuncionarioFk(), "IRF"  ).isEmpty()) {temIrf = true;}
							
							for(int j=0;j<listaGpfMedicaDiferenciadaDiarista.size();j++) {
								RubricasVencimento r = new RubricasVencimento();
								if(
									listaEscalas.get(i).getEscala().getIdAnoMesFk() == listaGpfMedicaDiferenciadaDiarista.get(j).getIdAnoMesFk() &&  
									(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("RESIDENTE")) &&
									(listaEscalas.get(i).getEscala().getIdRegimeFk().getNomeRegimeDeTrabalho().equalsIgnoreCase("D")) &&  	
									listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk() == listaGpfMedicaDiferenciadaDiarista.get(j).getIdUnidadeFk() && 
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdCargaHorariaAtualFk() == listaGpfMedicaDiferenciadaDiarista.get(j).getIdCargaHorariaSemanalFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk() == listaGpfMedicaDiferenciadaDiarista.get(j).getIdNivelCargoFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdClasseCarreiraAtualFk() == listaGpfMedicaDiferenciadaDiarista.get(j).getIdClasseCarreiraFk() &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S") &&
									listaEscalas.get(i).getEscala().getIdComplementoPlantaoSimNaoFk().getSigla().equalsIgnoreCase("S") &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("S") &&
									temIrf==false
									 
								) {
									
									//Calculando Valores
									Double valorBruto = 0.0;
									Double valorLiquido = 0.0;
									int horasTotais = listaEscalas.get(i).getEscala().getHorasTotais();
									Double valorGlobal = listaGpfMedicaDiferenciadaDiarista.get(j).getValor();
									Double valorPorHora = (listaGpfMedicaDiferenciadaDiarista.get(j).getValor() / listaGpfMedicaDiferenciadaDiarista.get(j).getIdCargaHorariaSemanalFk().getCargaHoraria()) ;
									
									Double valorDaLinha = (horasTotais*valorPorHora) ;
									
									//Avaliando se já tem alguma linha já cadastrada
									Double valorCadastrado = 0.0;
									for(int k=0;k<lista.size();k++) {
										if( Long.parseLong(listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdPessoaFk().getCpf())  <  Long.parseLong(lista.get(k).getPessoaFuncionarios().getIdPessoaFk().getCpf()) ) {break;}
										if(lista.get(k).getAnoMes()==anoMes &&
											lista.get(k).getCodigo().equalsIgnoreCase("COMPL PLANT DIFERENCIADO DIARISTA") &&
											lista.get(k).getPessoaFuncionarios()==listaEscalas.get(i).getEscala().getIdFuncionarioFk()
										) {
											if(listaGpfMedicaDiferenciadaDiarista.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) {valorCadastrado = valorCadastrado+lista.get(k).getValorBruto();}
											if(listaGpfMedicaDiferenciadaDiarista.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) {valorCadastrado = valorCadastrado+lista.get(k).getValorLiquido();}
										}
									}
									
									// Ajustando casas decimais
									if(valorDaLinha<0) {valorDaLinha=0.0;}
									if(valorCadastrado+valorDaLinha>valorGlobal) {valorDaLinha=valorGlobal-valorCadastrado;}
									valorDaLinha = UtilidadesMatematicas.ajustaValorDecimal(valorDaLinha, 2);
									if(listaGpfMedicaDiferenciadaDiarista.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) {valorBruto=valorDaLinha;}
									if(listaGpfMedicaDiferenciadaDiarista.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) {valorLiquido=valorDaLinha;}
									
									
									
									r.setAnoMes(anoMes);
									r.setSequencia(1);
									r.setCodigo("COMPL PLANT DIFERENCIADO DIARISTA");
									r.setDescricao("COMPLEMENTO DE PLANTAO DIFERENCIADO MEDICA PARA DIARISTAS");
									r.setFonte(listaGpfMedicaDiferenciadaDiarista.get(j).getIdFonteFk());
									r.setNatureza(rubricaNaturezaService.buscarPorSigla("V").get(0));
									r.setPercentagem(0.0);
									r.setPessoaFuncionarios(listaEscalas.get(i).getEscala().getIdFuncionarioFk());
									r.setTipoBrutoLiquido(listaGpfMedicaDiferenciadaDiarista.get(j).getIdTipoBrutoLiquidoFk());
									r.setUnidade(listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk());
									r.setVariacao("00");
									r.setValorBruto(valorBruto);
									r.setValorLiquido(valorLiquido);
									r.setValorIr(0.0);
									r.setValorPatronal(0.0);
									r.setValorPrevidencia(0.0);
									r.setTiposDeFolha(listaEscalas.get(i).getEscala().getIdTipoFolhaFk());
									
									if(valorBruto+valorLiquido>0) {
										if(!lista.contains(r)) {lista.add(r);
										}
									}
								}
							}
						}
					}
				}
			
				
				
				
				
				
				
				
				//Para Residentes
				List<FaixasValoresResidente> listaValoresResidente = faixasValoresResidenteService.buscarPorMesExato(anoMes);
				for(int i=0;i<listaEscalas.size();i++) {
					if(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T")) {
						if(escalaCodDiferenciadoService.buscarPorEscala(listaEscalas.get(i).getEscala()).isEmpty()) {
							boolean temIrf = false;
							if(!vencimentosFuncionarioService.buscarPorMesExatoEFuncionarioETipo(anoMes, listaEscalas.get(i).getEscala().getIdFuncionarioFk(), "IRF"  ).isEmpty()) {temIrf = true;}
							
							for(int j=0;j<listaValoresResidente.size();j++) {
								RubricasVencimento r = new RubricasVencimento();
								if(
									listaEscalas.get(i).getEscala().getIdAnoMesFk() == listaValoresResidente.get(j).getIdAnoMesFk() && 
									(listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("RESIDENTE")) &&
									listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk() == listaValoresResidente.get(j).getIdUnidadeFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk() == listaValoresResidente.get(j).getIdEspecialidadeFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdCargaHorariaAtualFk() == listaValoresResidente.get(j).getIdCargaHorariaSemanalFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk() == listaValoresResidente.get(j).getIdNivelCargoFk() &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N") &&
									temIrf==false
									 
								) {
									
									//Calculando Valores
									Double valorBruto = 0.0;
									Double valorLiquido = 0.0;
									int horasTotais = listaEscalas.get(i).getEscala().getHorasTotais();
									Double valorGlobal = listaValoresResidente.get(j).getValor();
									Double valorPorHora = (listaValoresResidente.get(j).getValor() / listaValoresResidente.get(j).getIdCargaHorariaSemanalFk().getCargaHoraria()) ;
									
									Double valorDaLinha = (horasTotais*valorPorHora) ;
									
									// Excessao férias
									for(int k=0;k<listaFerias.size();k++) {
										if(listaFerias.get(k).getFuncionariosFeriasPeriodos().getIdFeriasFk().getIdFuncionarioFk()==listaEscalas.get(i).getEscala().getIdFuncionarioFk()) {
											valorDaLinha = valorGlobal; break;
										}
									}
									
									
									//Avaliando se já tem alguma linha já cadastrada
									Double valorCadastrado = 0.0;
									for(int k=0;k<lista.size();k++) {
										if(lista.get(k).getAnoMes()==anoMes &&
											lista.get(k).getCodigo().equalsIgnoreCase("RESIDENTE") &&
											lista.get(k).getPessoaFuncionarios()==listaEscalas.get(i).getEscala().getIdFuncionarioFk()
										) {
											if(listaValoresResidente.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) { valorCadastrado = valorCadastrado+lista.get(k).getValorBruto(); }
											if(listaValoresResidente.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) { valorCadastrado = valorCadastrado+lista.get(k).getValorLiquido(); }
										}
									}
									
									// Ajustando casas decimais
									if(valorDaLinha<0) {valorDaLinha=0.0;}
									if(valorCadastrado+valorDaLinha>valorGlobal) {valorDaLinha=valorGlobal-valorCadastrado;}
									valorDaLinha = UtilidadesMatematicas.ajustaValorDecimal(valorDaLinha, 2);
									if(listaValoresResidente.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) {valorBruto=valorDaLinha;}
									if(listaValoresResidente.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) {valorLiquido=valorDaLinha;}
									
									
									r.setAnoMes(anoMes);
									r.setSequencia(1);
									r.setCodigo("RESIDENTE");
									r.setDescricao("PAGAMENTO RESIDENTE");
									r.setFonte(listaValoresResidente.get(j).getIdFonteFk());
									r.setNatureza(rubricaNaturezaService.buscarPorSigla("V").get(0));
									r.setPercentagem(0.0);
									r.setPessoaFuncionarios(listaEscalas.get(i).getEscala().getIdFuncionarioFk());
									r.setTipoBrutoLiquido(listaValoresResidente.get(j).getIdTipoBrutoLiquidoFk());
									r.setUnidade(listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk());
									r.setVariacao("00");
									r.setValorBruto(valorBruto);
									r.setValorLiquido(valorLiquido);
									r.setValorIr(0.0);
									r.setValorPatronal(0.0);
									r.setValorPrevidencia(0.0);
									r.setTiposDeFolha(listaEscalas.get(i).getEscala().getIdTipoFolhaFk());
									
									if(valorBruto+valorLiquido>0) {
										if(!lista.contains(r)) {lista.add(r);
										}
									}
								}
							}
						}
					}
				}

				
				
				
				
				
				
				
				
				//Para Pss
				List<FaixasValoresPss> listaPss = faixasValoresPssService.buscarPorMesExato(anoMes);
				for(int i=0;i<listaEscalas.size();i++) {
					if(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T")) {
						if(escalaCodDiferenciadoService.buscarPorEscala(listaEscalas.get(i).getEscala()).isEmpty()) {
							
							for(int j=0;j<listaPss.size();j++) {
								RubricasVencimento r = new RubricasVencimento();
								if(
									listaEscalas.get(i).getEscala().getIdAnoMesFk() == listaPss.get(j).getIdAnoMesFk() &&  	
									(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("RESIDENTE")) &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getNomeTipoFolha().equalsIgnoreCase("PSS") &&
									listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk() == listaPss.get(j).getIdUnidadeFk() && 
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdCargaHorariaAtualFk() == listaPss.get(j).getIdCargaHorariaSemanalFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk() == listaPss.get(j).getIdNivelCargoFk() &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N") 
									 
								) {
									
									//Calculando Valores
									Double valorBruto = 0.0;
									Double valorLiquido = 0.0;
									Double valorFixoTotal = listaPss.get(j).getValor();
									
									Double valorDaLinha = (valorFixoTotal) ;
									
									//Avaliando se já tem alguma linha já cadastrada
									Double valorCadastrado = 0.0;
									for(int k=0;k<lista.size();k++) {
										if( Long.parseLong(listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdPessoaFk().getCpf())  <  Long.parseLong(lista.get(k).getPessoaFuncionarios().getIdPessoaFk().getCpf()) ) {break;}
										if(lista.get(k).getAnoMes()==anoMes &&
											lista.get(k).getCodigo().equalsIgnoreCase("PSS") &&
											lista.get(k).getPessoaFuncionarios()==listaEscalas.get(i).getEscala().getIdFuncionarioFk()
										) {
											if(listaPss.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) {valorCadastrado = valorCadastrado+lista.get(k).getValorBruto();}
											if(listaPss.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) {valorCadastrado = valorCadastrado+lista.get(k).getValorLiquido();}
										}
									}
									
									// Ajustando casas decimais
									if(valorCadastrado+valorDaLinha>valorFixoTotal) {valorDaLinha=valorFixoTotal-valorCadastrado;}
									if(valorDaLinha<0) {valorDaLinha=0.0;}
									valorDaLinha = UtilidadesMatematicas.ajustaValorDecimal(valorDaLinha, 2);
									if(listaPss.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) {valorBruto=valorDaLinha;}
									if(listaPss.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) {valorLiquido=valorDaLinha;}
									
									r.setAnoMes(anoMes);
									r.setSequencia(1);
									r.setCodigo("PSS");
									r.setDescricao("CONTRATACAO PSS");
									r.setFonte(listaPss.get(j).getIdFonteFk());
									r.setNatureza(rubricaNaturezaService.buscarPorSigla("V").get(0));
									r.setPercentagem(0.0);
									r.setPessoaFuncionarios(listaEscalas.get(i).getEscala().getIdFuncionarioFk());
									r.setTipoBrutoLiquido(listaPss.get(j).getIdTipoBrutoLiquidoFk());
									r.setUnidade(listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk());
									r.setVariacao("00");
									r.setValorBruto(valorBruto);
									r.setValorLiquido(valorLiquido);
									r.setValorIr(0.0);
									r.setValorPatronal(0.0);
									r.setValorPrevidencia(0.0);
									r.setTiposDeFolha(listaEscalas.get(i).getEscala().getIdTipoFolhaFk());
									
									if(valorBruto+valorLiquido>0) {
										if(!lista.contains(r)) {lista.add(r);
										}
									}
								}
							}
						}
					}
				}
			
			
				
				
				
				
				
				
				
				//Para Folh Ext
				List<FaixasValoresFolhExt> listaFolhExt = faixasValoresFolhExtService.buscarPorMesExato(anoMes);
				for(int i=0;i<listaEscalas.size();i++) {
					if(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk().getSiglaNivelCargo().equalsIgnoreCase("T")) {
						if(escalaCodDiferenciadoService.buscarPorEscala(listaEscalas.get(i).getEscala()).isEmpty()) {
							
							for(int j=0;j<listaFolhExt.size();j++) {
								RubricasVencimento r = new RubricasVencimento();
								if(
									listaEscalas.get(i).getEscala().getIdAnoMesFk() == listaFolhExt.get(j).getIdAnoMesFk() &&  	
									(!listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("RESIDENTE")) &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getNomeTipoFolha().equalsIgnoreCase("FOLH EXT") &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk() == listaFolhExt.get(j).getIdFuncionarioFk() &&
									listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk() == listaFolhExt.get(j).getIdUnidadeFk() && 
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdCargaHorariaAtualFk() == listaFolhExt.get(j).getIdCargaHorariaSemanalFk() &&
									listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getIdNivelCargoFk() == listaFolhExt.get(j).getIdNivelCargoFk() &&
									listaEscalas.get(i).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N") 
									 
								) {
									
									//Calculando Valores
									Double valorBruto = 0.0;
									Double valorLiquido = 0.0;
									Double valorFixoTotal = listaFolhExt.get(j).getValor();
									
									Double valorDaLinha = (valorFixoTotal) ;
									
									//Avaliando se já tem alguma linha já cadastrada
									Double valorCadastrado = 0.0;
									for(int k=0;k<lista.size();k++) {
										if( Long.parseLong(listaEscalas.get(i).getEscala().getIdFuncionarioFk().getIdPessoaFk().getCpf())  <  Long.parseLong(lista.get(k).getPessoaFuncionarios().getIdPessoaFk().getCpf()) ) {break;}
										if(lista.get(k).getAnoMes()==anoMes &&
											lista.get(k).getCodigo().equalsIgnoreCase("FOLH EXT") &&
											lista.get(k).getPessoaFuncionarios()==listaEscalas.get(i).getEscala().getIdFuncionarioFk()
										) {
											valorCadastrado = valorCadastrado+lista.get(k).getValorBruto();
										}
									}
									
									// Ajustando casas decimais
									if(valorCadastrado+valorDaLinha>valorFixoTotal) {valorDaLinha=valorFixoTotal-valorCadastrado;}
									if(valorDaLinha<0) {valorDaLinha=0.0;}
									valorDaLinha = UtilidadesMatematicas.ajustaValorDecimal(valorDaLinha, 2);
									if(listaFolhExt.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) {valorBruto=valorDaLinha;}
									if(listaFolhExt.get(j).getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) {valorLiquido=valorDaLinha;}
									
									r.setAnoMes(anoMes);
									r.setSequencia(1);
									r.setCodigo("FOLH EXT");
									r.setDescricao("FOLH EXT VALOR FIXO");
									r.setFonte(listaFolhExt.get(j).getIdFonteFk());
									r.setNatureza(rubricaNaturezaService.buscarPorSigla("V").get(0));
									r.setPercentagem(0.0);
									r.setPessoaFuncionarios(listaEscalas.get(i).getEscala().getIdFuncionarioFk());
									r.setTipoBrutoLiquido(listaFolhExt.get(j).getIdTipoBrutoLiquidoFk());
									r.setUnidade(listaEscalas.get(i).getEscala().getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk());
									r.setVariacao("00");
									r.setValorBruto(valorBruto);
									r.setValorLiquido(valorLiquido);
									r.setValorIr(0.0);
									r.setValorPatronal(0.0);
									r.setValorPrevidencia(0.0);
									r.setTiposDeFolha(listaEscalas.get(i).getEscala().getIdTipoFolhaFk());
									
									if(valorBruto+valorLiquido>0) {
										if(!lista.contains(r)) {lista.add(r);
										}
									}
								}
							}
						}
					}
				}
			
				
				
				
				
				
				
				
				
				//Buscando rubricas atribuidas aos colaboradores pela folha IRF
				List<RubricasVencimento> listaA= obterVencimentosRubricasAtribuidasPelaFolhaIRF(listaEscalas, listaFerias, anoMes);
				for(int m=0;m<listaA.size();m++) {
					lista.add(listaA.get(m));
				}
				
				//Buscando rubricas atribuidas aos colaboradores pela folha GRATIFICACAO PREST
				List<RubricasVencimento> listaB= obterVencimentosRubricasAtribuidasPelaFolhaGratificacaoPrest(listaEscalas, listaFerias, anoMes);
				for(int m=0;m<listaB.size();m++) {
					lista.add(listaB.get(m));
				}
				
				//Buscando rubricas atribuidas aos colaboradores pela folha VANTAGENS E DESCONTOS
				List<RubricasVencimento> listaC= obterVencimentosRubricasAtribuidasPelaFolhaVantagensEDescontos(listaEscalas, listaFerias, anoMes);
				for(int m=0;m<listaC.size();m++) {
					lista.add(listaC.get(m));
				}
				
				
				
				
		
		return lista;
	}
	
	
	
	
	
	//Obter Vencimentos Rubricas Atribuidas Pela Folha (IRF)
	public List<RubricasVencimento> obterVencimentosRubricasAtribuidasPelaFolhaIRF(List<EscalasNoMes> listaEscalas, List<FeriasNoMes> listaFerias, AnoMes anoMes) {
		List<RubricasVencimento> lista = new ArrayList<>();
		List<VencimentosFuncionario> listaVencimentosFuncionarios = vencimentosFuncionarioService.buscarPorMesExato(anoMes); 
		
		for(int i=0;i<listaVencimentosFuncionarios.size();i++) {
			if(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdTipoFk().getNome().equalsIgnoreCase("IRF")) {
				RubricasVencimento r = new RubricasVencimento();
				VencimentosFuncionario vencimentosFuncionario = listaVencimentosFuncionarios.get(i);
				int horasEsperadas = vencimentosFuncionario.getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria()*4;
				Double valor = 0.0; 
				if(!rubricaService.buscarPorMesECodigo(anoMes, vencimentosFuncionario.getIdCodigoFk()).isEmpty()) { valor= rubricaService.buscarPorMesECodigo(anoMes, vencimentosFuncionario.getIdCodigoFk()).get(0).getValor(); }
				Double valorPorHora = valor/horasEsperadas;
				
				TiposDeFolha folhaAtual = null;
				
				int horasEscala = 0;
					for(int j=0;j<listaEscalas.size();j++) {
						if(
								listaEscalas.get(j).getEscala().getIdFuncionarioFk()==vencimentosFuncionario.getIdFuncionarioFk() &&
								listaEscalas.get(j).getEscala().getIdTipoFolhaFk().getIdTipoRemuneracaoFk().getNomeTipoRemuneracao().equalsIgnoreCase("FIXA") &&
								listaEscalas.get(j).getEscala().getIdAnoMesFk()==anoMes
								
								) 
						{
							horasEscala = horasEscala+ listaEscalas.get(j).getEscala().getHorasTotais();
							folhaAtual = listaEscalas.get(j).getEscala().getIdTipoFolhaFk();
						}					
					}
					
					
				Double valorDaPessoa = valorPorHora*horasEscala;
				if(valorDaPessoa>valor) {valorDaPessoa=valor;}
				
				// Excessao férias
				for(int k=0;k<listaFerias.size();k++) {
					if(listaFerias.get(k).getFuncionariosFeriasPeriodos().getIdFeriasFk().getIdFuncionarioFk()==vencimentosFuncionario.getIdFuncionarioFk()) {
						valorDaPessoa = valor; break;
					}
				}
				
				if(valorDaPessoa<0) {valorDaPessoa=0.0;}
				valorDaPessoa = UtilidadesMatematicas.ajustaValorDecimal(valorDaPessoa, 2);
				
				r.setAnoMes(anoMes);
				r.setSequencia(1);
				r.setCodigo(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getCodigo());
				r.setDescricao(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getDescricao());
				r.setFonte(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdFonteFk());
				r.setNatureza(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdNaturezaFk());
				r.setPercentagem(0.0);
				r.setPessoaFuncionarios(listaVencimentosFuncionarios.get(i).getIdFuncionarioFk());
				r.setTipoBrutoLiquido(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdTipoBrutoLiquidoFk());
				r.setUnidade(listaVencimentosFuncionarios.get(i).getIdFuncionarioFk().getIdUnidadeAtuacaoAtualFk());
				r.setVariacao(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getVariacao());
				
				if(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) {r.setValorBruto(valorDaPessoa);} else {r.setValorBruto(0.0);}
				if(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) {r.setValorLiquido(valorDaPessoa);} else {r.setValorLiquido(0.0);}
				
				r.setValorIr(0.0);
				r.setValorPatronal(0.0);
				r.setValorPrevidencia(0.0);
								
				r.setTiposDeFolha(folhaAtual);
				
				if(valorDaPessoa>0) {
					lista.add(r);
				}
				
					
					
			}
		}
		return lista;
	}
	
	
	
	
	
	
	
	
	
	
	
	//Obter Vencimentos Rubricas Atribuidas Pela Folha (GRATIFICACAO PREST) - fora a irf
	public List<RubricasVencimento> obterVencimentosRubricasAtribuidasPelaFolhaGratificacaoPrest(List<EscalasNoMes> listaEscalas, List<FeriasNoMes> listaFerias, AnoMes anoMes) {
		List<RubricasVencimento> lista = new ArrayList<>();
		List<VencimentosFuncionario> listaVencimentosFuncionarios = vencimentosFuncionarioService.buscarPorMesExato(anoMes); 
		
		for(int i=0;i<listaVencimentosFuncionarios.size();i++) {
			if(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdTipoFk().getNome().equalsIgnoreCase("GRATIFICACAO PREST")) {
				RubricasVencimento r = new RubricasVencimento();
				VencimentosFuncionario vencimentosFuncionario = listaVencimentosFuncionarios.get(i);
				int horasEsperadas = vencimentosFuncionario.getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria()*4;
				Double valor = 0.0; 
				if(!rubricaService.buscarPorMesECodigo(anoMes, vencimentosFuncionario.getIdCodigoFk()).isEmpty()) { valor= rubricaService.buscarPorMesECodigo(anoMes, vencimentosFuncionario.getIdCodigoFk()).get(0).getValor(); }
				Double valorPorHora = valor/horasEsperadas;
				
				TiposDeFolha folhaAtual = null;
				
				int horasEscala = 0;
					for(int j=0;j<listaEscalas.size();j++) {
						if(
								listaEscalas.get(j).getEscala().getIdFuncionarioFk()==vencimentosFuncionario.getIdFuncionarioFk() &&
								listaEscalas.get(j).getEscala().getIdTipoFolhaFk().getIdFolhaEfetivaSimNaoFk().getSigla().equalsIgnoreCase("N") &&
								listaEscalas.get(j).getEscala().getIdAnoMesFk()==anoMes
								
								) 
						{
							horasEscala = horasEscala+ listaEscalas.get(j).getEscala().getHorasTotais();
							folhaAtual = listaEscalas.get(j).getEscala().getIdTipoFolhaFk();
						}					
					}
					
					
				Double valorDaPessoa = valorPorHora*horasEscala;
				if(valorDaPessoa>valor) {valorDaPessoa=valor;}
				
				// Excessao férias
				for(int k=0;k<listaFerias.size();k++) {
					if(listaFerias.get(k).getFuncionariosFeriasPeriodos().getIdFeriasFk().getIdFuncionarioFk()==vencimentosFuncionario.getIdFuncionarioFk()) {
						valorDaPessoa = valor; break;
					}
				}
				
				if(valorDaPessoa<0) {valorDaPessoa=0.0;}
				valorDaPessoa = UtilidadesMatematicas.ajustaValorDecimal(valorDaPessoa, 2);
				
				r.setAnoMes(anoMes);
				r.setSequencia(1);
				r.setCodigo(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getCodigo());
				r.setDescricao(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getDescricao());
				r.setFonte(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdFonteFk());
				r.setNatureza(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdNaturezaFk());
				r.setPercentagem(0.0);
				r.setPessoaFuncionarios(listaVencimentosFuncionarios.get(i).getIdFuncionarioFk());
				r.setTipoBrutoLiquido(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdTipoBrutoLiquidoFk());
				r.setUnidade(listaVencimentosFuncionarios.get(i).getIdFuncionarioFk().getIdUnidadeAtuacaoAtualFk());
				r.setVariacao(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getVariacao());
				
				if(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) {r.setValorBruto(valorDaPessoa);} else {r.setValorBruto(0.0);}
				if(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) {r.setValorLiquido(valorDaPessoa);} else {r.setValorLiquido(0.0);}
				
				r.setValorIr(0.0);
				r.setValorPatronal(0.0);
				r.setValorPrevidencia(0.0);
								
				r.setTiposDeFolha(folhaAtual);
				
				if(valorDaPessoa>0) {
					lista.add(r);
				}
				
					
					
			}
		}
		return lista;
	}
	
	
	
	
	
	
	
	
	//Obter Vencimentos Rubricas Atribuidas Pela Folha (VANTAGENS E DESCONTOS)
		public List<RubricasVencimento> obterVencimentosRubricasAtribuidasPelaFolhaVantagensEDescontos(List<EscalasNoMes> listaEscalas, List<FeriasNoMes> listaFerias, AnoMes anoMes) {
			List<RubricasVencimento> lista = new ArrayList<>();
			List<VencimentosFuncionario> listaVencimentosFuncionarios = vencimentosFuncionarioService.buscarPorMesExato(anoMes); 
			
			for(int i=0;i<listaVencimentosFuncionarios.size();i++) {
				if( (!listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdTipoFk().getNome().equalsIgnoreCase("GRATIFICACAO PREST")) && (!listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdTipoFk().getNome().equalsIgnoreCase("IRF"))  ) {
					RubricasVencimento r = new RubricasVencimento();
					VencimentosFuncionario vencimentosFuncionario = listaVencimentosFuncionarios.get(i);
					int horasEsperadas = vencimentosFuncionario.getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria()*4;
					Double valor = 0.0; 
					if(!rubricaService.buscarPorMesECodigo(anoMes, vencimentosFuncionario.getIdCodigoFk()).isEmpty()) { valor= rubricaService.buscarPorMesECodigo(anoMes, vencimentosFuncionario.getIdCodigoFk()).get(0).getValor(); }
					Double valorPorHora = valor/horasEsperadas;
					
					TiposDeFolha folhaAtual = null;
					
					int horasEscala = 0;
						for(int j=0;j<listaEscalas.size();j++) {
							if(
									listaEscalas.get(j).getEscala().getIdFuncionarioFk()==vencimentosFuncionario.getIdFuncionarioFk() &&
									listaEscalas.get(j).getEscala().getIdAnoMesFk()==anoMes
									
									) 
							{
								horasEscala = horasEscala+ listaEscalas.get(j).getEscala().getHorasTotais();
								folhaAtual = listaEscalas.get(j).getEscala().getIdTipoFolhaFk();
							}					
						}
						
						
					Double valorDaPessoa = valor;
					if(valorDaPessoa>valor) {valorDaPessoa=valor;}
					
					// Excessao férias
					for(int k=0;k<listaFerias.size();k++) {
						if(listaFerias.get(k).getFuncionariosFeriasPeriodos().getIdFeriasFk().getIdFuncionarioFk()==vencimentosFuncionario.getIdFuncionarioFk()) {
							valorDaPessoa = valor; break;
						}
					}
					
					if(valorDaPessoa<0) {valorDaPessoa=0.0;}
					valorDaPessoa = UtilidadesMatematicas.ajustaValorDecimal(valorDaPessoa, 2);
					
					r.setAnoMes(anoMes);
					r.setSequencia(1);
					r.setCodigo(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getCodigo());
					r.setDescricao(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getDescricao());
					r.setFonte(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdFonteFk());
					r.setNatureza(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdNaturezaFk());
					r.setPercentagem(0.0);
					r.setPessoaFuncionarios(listaVencimentosFuncionarios.get(i).getIdFuncionarioFk());
					r.setTipoBrutoLiquido(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdTipoBrutoLiquidoFk());
					r.setUnidade(listaVencimentosFuncionarios.get(i).getIdFuncionarioFk().getIdUnidadeAtuacaoAtualFk());
					r.setVariacao(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getVariacao());
					
					if(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("B")) {r.setValorBruto(valorDaPessoa);} else {r.setValorBruto(0.0);}
					if(listaVencimentosFuncionarios.get(i).getIdCodigoFk().getIdTipoBrutoLiquidoFk().getNome().equalsIgnoreCase("L")) {r.setValorLiquido(valorDaPessoa);} else {r.setValorLiquido(0.0);}
					
					r.setValorIr(0.0);
					r.setValorPatronal(0.0);
					r.setValorPrevidencia(0.0);
									
					r.setTiposDeFolha(folhaAtual);
					
					if(valorDaPessoa>0) {
						lista.add(r);
					}
					
						
						
				}
			}
			return lista;
		}
	
	
	
	
	
	
	
	
	public List<RubricasVencimento> colocandoLiquidoNasRubricas(List<RubricasVencimento> listaVencimentos) {
		for(int i=0;i<listaVencimentos.size();i++) {
			if((listaVencimentos.get(i).getValorBruto()>0)  &&  (listaVencimentos.get(i).getValorLiquido()==0.0) ) {
				listaVencimentos.get(i).setValorLiquido(calcularLiquidoService.calcularLiquido(listaVencimentos.get(i).getValorBruto(), listaVencimentos.get(i).getPessoaFuncionarios(), listaVencimentos.get(i).getAnoMes()));
			}
		}
		return listaVencimentos;
	}
	
	
	
}
