package com.folha.boot.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.EscalaReposytoty;
import com.folha.boot.Reposytory.PessoaDocumentosReposytory;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Cargos;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.IncrementoDeRiscoUnidadeCargo;
import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaCodDiferenciado;
import com.folha.boot.domain.PessoaComplementoDePlantao;
import com.folha.boot.domain.PessoaComplementoDePlantaoSede;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaIncrementoDeRisco;
import com.folha.boot.domain.PessoaIncrementoDeRiscoSede;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.TiposDeFolhaNivelCargo;
import com.folha.boot.domain.TiposDeFolhaVinculo;
import com.folha.boot.domain.UnidadeAdmiteComplementoPlantao;
import com.folha.boot.domain.UnidadeAdmiteIncrementoDeRisco;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.Vinculos;
import com.folha.boot.domain.models.calculos.FeriasNoMes;
import com.folha.boot.domain.models.calculos.LicencasNoMes;
import com.folha.boot.service.calculos.escala.CalculosColetaDeDadosService;
import com.folha.boot.service.seguranca.UsuarioService;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;
import com.folha.boot.service.util.UtilidadesMatematicas;

@Service
@Transactional(readOnly = false)
public class EscalaCompatibilidadeService {

	@Autowired
	UsuarioService usuarioService;
	@Autowired
	ObjectFactory<HttpSession> httpSessionFactory;
	@Autowired
	private CodigoDiferenciadoService codigoDiferenciadoService;
	@Autowired
	private TiposDeFolhaService tiposDeFolhaService;
	@Autowired
	private SimNaoService simNaoService;
	@Autowired
	private AcessoOperadoresCoordenacaoService acessoOperadoresCoordenacaoService;
	@Autowired
	private CargosEspecialidadeService cargosEspecialidadeService;
	@Autowired
	private EscalaExportacaoService escalaExportacaoService;
	@Autowired
	private EscalaPosTransparenciaService escalaPosTransparenciaService;
	@Autowired
	private EscalaAlteracoesService escalaAlteracoesService;
	@Autowired
	private PessoaCodDiferenciadoService pessoaCodDiferenciadoService;
	@Autowired
	private PessoaChDifService pessoaChDifService;
	@Autowired
	private PessoaIncrementoDeRiscoService pessoaIncrementoDeRiscoService;
	@Autowired
	private PessoaIncrementoDeRiscoSedeService pessoaIncrementoDeRiscoSedeService;
	@Autowired
	private EscalaCodDiferenciadoService escalaCodDiferenciadoService;
	@Autowired
	private FaixasValoresParametrosCalculoFolhasExtrasService faixasValoresParametrosCalculoFolhasExtrasService;
	@Autowired
	private TiposDeFolhaVinculoService tiposDeFolhaVinculoService;
	@Autowired
	private TiposDeFolhaNivelCargoService tiposDeFolhaNivelCargoService;
	@Autowired
	private UnidadeAdmiteIncrementoDeRiscoService unidadeAdmiteIncrementoDeRiscoService;
	@Autowired
	private IncrementoDeRiscoUnidadeCargoService incrementoDeRiscoUnidadeCargoService;
	@Autowired
	private UnidadeAdmiteComplementoPlantaoService unidadeAdmiteComplementoPlantaoService;
	@Autowired
	private PessoaComplementoDePlantaoService pessoaComplementoDePlantaoService;
	@Autowired
	private PessoaComplementoDePlantaoSedeService pessoaComplementoDePlantaoSedeService;
	@Autowired
	private FuncionariosFeriasPeriodosService funcionariosFeriasPeriodosService;
	@Autowired
	private FuncionariosLicencasService funcionariosLicencasService;
	@Autowired
	private CalculosColetaDeDadosService calculosColetaDeDadosService;
	@Autowired
	private EscalaCalculosService escalaCalculosService;
	
	public boolean horasExtrasSemEfetivas(Escala escala) {
		boolean resposta = false;
		
		AnoMes anoMes = escala.getIdAnoMesFk();
		PessoaFuncionarios funcionario = escala.getIdFuncionarioFk();
		Pessoa pessoa = escala.getIdFuncionarioFk().getIdPessoaFk();
		TiposDeFolha folhaProposta = escala.getIdTipoFolhaFk();
		
		if(funcionario.getIdVinculoAtualFk().getNomeVinculo().equalsIgnoreCase("EFETIVO")) {
			if(folhaProposta.getIdTipoRemuneracaoFk().getNomeTipoRemuneracao().equalsIgnoreCase("VARIAVEL")) {
				if(escala.getHorasTotais()>0) {
					boolean temFerias = false;
					List<FeriasNoMes> listaFerias = calculosColetaDeDadosService.buscarFeriasPorMes(anoMes);
					for(int i=0;i<listaFerias.size();i++) {
						if( listaFerias.get(i).getFuncionariosFeriasPeriodos().getIdFeriasFk().getIdFuncionarioFk().equals(funcionario)) {temFerias = true; break; }
					}
					
					boolean temLicenca = false;
					if(temFerias==false) {
						List<LicencasNoMes> listaLicencas = calculosColetaDeDadosService.buscarLicencasPorMes(anoMes);
						for(int i=0;i<listaLicencas.size();i++) {
							if( listaLicencas.get(i).getFuncionariosLicencas().getIdFuncionarioFk().getIdPessoaFk().equals(pessoa)) {temLicenca = true; break; }
						}
					}
					
					boolean temEvento = false;
					if(temFerias==true || temLicenca==true) {temEvento = true;}
					
					if(temEvento == false) {
						int horasEfetivas = escalaCalculosService.horasEfetivasDoFuncionarioNoMes(escala);
						if((horasEfetivas) <  ((funcionario.getIdCargaHorariaAtualFk().getCargaHoraria()*4)-12)) {
							resposta = true;
						}
						
					}
				
				}
			}
			
		}
		
		return resposta;
	}
	
	
	
	public List<SimNao> getIncrementoDeRiscoCompativel(Escala escala) {
		
		AnoMes anoMes = escala.getIdAnoMesFk();
		Unidades unidade = escala.getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk();
		Pessoa pessoa = escala.getIdFuncionarioFk().getIdPessoaFk();
		TiposDeFolha folha = escala.getIdTipoFolhaFk();
		Cargos cargo = escala.getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk();		
		List<SimNao> lista = simNaoService.buscarTodos();
		List<UnidadeAdmiteIncrementoDeRisco> lista1 = unidadeAdmiteIncrementoDeRiscoService.buscarPorMesExatoUnidade(anoMes, unidade);
		List<IncrementoDeRiscoUnidadeCargo> lista1a = incrementoDeRiscoUnidadeCargoService.buscarPorMesUnidadeCargoExato(anoMes, unidade, cargo);
		List<PessoaIncrementoDeRisco> lista2 = pessoaIncrementoDeRiscoService.buscarPorMesExatoUnidadePessoa(anoMes, unidade, pessoa);
		List<PessoaIncrementoDeRiscoSede> lista2a = pessoaIncrementoDeRiscoSedeService.buscarPorUnidadeEPessoa(unidade, pessoa);
		List<TiposDeFolha> lista3 = tiposDeFolhaService.buscarTodos();
		
		//Retirando quando nao tem Unidade ou pessoa atribuida
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getSigla().equalsIgnoreCase("S")) {
				if(lista1.isEmpty() || lista1a.isEmpty() ||  lista2.isEmpty() || lista2a.isEmpty()) {lista.remove(i); i=i-1;}
			}
		}
		
		//Retirando quando nao tem Folha Compativel
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getSigla().equalsIgnoreCase("S")) {
				boolean achou = false;
				for(int j=0;j<lista3.size();j++) {
					if(lista3.get(j) == folha) {
						if(lista3.get(j).getIdAdmiteIncrementoDeRiscoSimNaoFk().getSigla().equalsIgnoreCase("S")) {achou = true;}
					}
				}
				if(achou==false) {lista.remove(i); i=i-1;}
			}
		}
		
		
		return lista;
	}
	
	

	
	
	public List<SimNao> getComplementoDePlantaoCompativel(Escala escala) {
		
		AnoMes anoMes = escala.getIdAnoMesFk();
		Unidades unidade = escala.getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk();
		Pessoa pessoa = escala.getIdFuncionarioFk().getIdPessoaFk();
		TiposDeFolha folha = escala.getIdTipoFolhaFk();
		
		List<SimNao> lista = simNaoService.buscarTodos();
		List<UnidadeAdmiteComplementoPlantao> lista1 = unidadeAdmiteComplementoPlantaoService.buscarPorMesExatoUnidade(anoMes, unidade);
		List<PessoaComplementoDePlantao> lista2 = pessoaComplementoDePlantaoService.buscarPorMesExatoUnidadePessoa(anoMes, unidade, pessoa);
		List<PessoaComplementoDePlantaoSede> lista2a = pessoaComplementoDePlantaoSedeService.buscarPorUnidadeEPessoa(unidade, pessoa);
		List<TiposDeFolha> lista3 = tiposDeFolhaService.buscarTodos();
		
		//Retirando quando nao tem Unidade ou pessoa atribuida
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getSigla().equalsIgnoreCase("S")) {
				if(lista1.isEmpty()  ||  lista2.isEmpty() || lista2a.isEmpty()) {lista.remove(i); i=i-1;}
			}
		}
		
		//Retirando quando nao tem Folha Compativel
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getSigla().equalsIgnoreCase("S")) {
				boolean achou = false;
				for(int j=0;j<lista3.size();j++) {
					if(lista3.get(j) == folha) {
						if(lista3.get(j).getIdAdmiteComplementoDePlantaoSimNaoFk().getSigla().equalsIgnoreCase("S")) {achou = true;}
					}
				}
				if(achou==false) {lista.remove(i); i=i-1;}
			}
		}
		
		
		return lista;
	}
	
	
	
	
	public List<TiposDeFolha> getTiposDeFolhaCompativel(AnoMes anoMes, NiveisCargo nivel, Vinculos vinculo) {
		
		List<TiposDeFolha> lista = tiposDeFolhaService.buscarTodos();
		List<TiposDeFolhaVinculo> lista1 = tiposDeFolhaVinculoService.buscarPorMesVinculo(anoMes, vinculo);
		List<TiposDeFolhaNivelCargo> lista2 = tiposDeFolhaNivelCargoService.buscarPorMesNivel(anoMes, nivel);
		
		//Retirando quando nao tem Vinculo Compativel
		for(int i=0;i<lista.size();i++) {
			boolean achou = false;
			for(int j=0;j<lista1.size();j++) {
				if(lista.get(i) == lista1.get(j).getIdTipoDeFolhaFk() ) {achou = true; break;}
			}
			if(achou == false) {lista.remove(i); i=i-1;}
		}
		
		//Retirando quando nao tem Nivel Compativel
		for(int i=0;i<lista.size();i++) {
			boolean achou = false;
			for(int j=0;j<lista2.size();j++) {
				if(lista.get(i) == lista2.get(j).getIdTipoDeFolhaFk() ) {achou = true; break;}
			}
			if(achou == false) {lista.remove(i); i=i-1;}
		}
		
		
		return lista;
	}
	
	public List<CodigoDiferenciado> getCodigosDiferenciadoCompativel(Escala escala) {
		Pessoa pessoa = escala.getIdFuncionarioFk().getIdPessoaFk() ;
		
		List<CodigoDiferenciado> lista = codigoDiferenciadoService.buscarTodosQueNaoPrecisaDeAtribuicaoRh(usuarioService.pegarUnidadeLogada());
		List<PessoaCodDiferenciado> lista1 = pessoaCodDiferenciadoService.buscarPorUnidadeEPessoaQuePrecisaAtribuicaoRhENaoPrecisaAprovacaoDaSede(usuarioService.pegarUnidadeLogada(), pessoa);
		List<PessoaCodDiferenciado> lista2 = pessoaCodDiferenciadoService.buscarPorUnidadeEPessoaAprovadoSede(usuarioService.pegarUnidadeLogada(), pessoa);
		List<FaixasValoresParametrosCalculoFolhasExtras> lista3 = faixasValoresParametrosCalculoFolhasExtrasService.buscarPorMesExatoNivelRegimeFolhaUnidade( escala );
		
		for(int i=0;i<lista1.size();i++) {
			lista.add(lista1.get(i).getIdCodDiferenciadoFk());
		}
		
		for(int i=0;i<lista2.size();i++) {
			lista.add(lista2.get(i).getIdCodDiferenciadoFk());
		}
		
		//Retirando letra N.
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).getNomeCodigoDiferenciado().equalsIgnoreCase("N")) {lista.remove(i); i=i-1;}
		}
		
		//Retirando quando nao tem valores atribuidos
		for(int i=0;i<lista.size();i++) {
			boolean achou = false;
			for(int j=0;j<lista3.size();j++) {
				if(lista.get(i) == lista3.get(j).getIdCodDiferenciadoFk() ) {achou = true; break;}
			}
			if(achou == false) {lista.remove(i); i=i-1;}
		}
		
		
		return lista;
	}

				
				
}
