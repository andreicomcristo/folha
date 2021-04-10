package com.folha.boot.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.AcessoOperadoresCoordenacao;
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.EscalaAlteracoes;
import com.folha.boot.domain.EscalaPosTransparencia;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.TiposDeDocumento;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Turmas;
import com.folha.boot.domain.Turnos;
import com.folha.boot.domain.Uf;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.models.EscolhaAcessoEscala;
import com.folha.boot.domain.models.InclusaoEscala;
import com.folha.boot.service.AcessoOperadoresCoordenacaoService;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CargosEspecialidadeService;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.CoordenacaoEscalaService;
import com.folha.boot.service.EscalaAlteracoesService;
import com.folha.boot.service.EscalaAtalhosService;
import com.folha.boot.service.EscalaCalculosService;
import com.folha.boot.service.EscalaExportacaoService;
import com.folha.boot.service.EscalaPosTransparenciaService;
import com.folha.boot.service.EscalaService;
import com.folha.boot.service.PessoaDocumentosService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.RegimesDeTrabalhoService;
import com.folha.boot.service.SimNaoService;
import com.folha.boot.service.TiposDeDocumentoService;
import com.folha.boot.service.TiposDeFolhaService;
import com.folha.boot.service.TurmasService;
import com.folha.boot.service.TurnosService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;

@Controller
@RequestMapping("/escalas")
public class EscalaController {

	Long ultimoIdEscala =0l ;
	Long idAnoMesAtual =1l ;
	Long idCoordenacaoAtual = 1l;
	Long idUnidadeLogada = 1l;
	Long idOperadorLogado = 1l;
	Escala escalaAtual;
	String choque = "";
	String choqueDescansoDepoisNoturno = "";
	
	String ultimaBuscaNome = "";
	Turmas ultimaBuscaTurma = null;
	CargosEspecialidade ultimaBuscaCargoEspecialidade = null;
	TiposDeFolha ultimaBuscaTiposDeFolha = null;
	
	@Autowired
	private EscalaService service;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private EscalaCalculosService escalaCalculosService;
	@Autowired
	private EscalaAtalhosService escalaAtalhosService;
	@Autowired
	private CodigoDiferenciadoService codigoDiferenciadoService;
	@Autowired
	private RegimesDeTrabalhoService regimesDeTrabalhoService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private CoordenacaoEscalaService coordenacaoEscalaService;
	@Autowired
	private TiposDeFolhaService tiposDeFolhaService;
	@Autowired
	private SimNaoService simNaoService;
	@Autowired
	private TurmasService turmasService;
	@Autowired
	private TurnosService turnosService;
	@Autowired
	AcessoOperadoresCoordenacaoService acessoOperadoresCoordenacaoService;
	@Autowired
	CargosEspecialidadeService cargosEspecialidadeService;
	@Autowired
	EscalaExportacaoService escalaExportacaoService;
	@Autowired
	EscalaPosTransparenciaService escalaPosTransparenciaService;
	@Autowired
	EscalaAlteracoesService escalaAlteracoesService;
	
	
	
	
	@GetMapping("/escolher/escala")
	public String escolherEscala(ModelMap model) {
		
		List<AcessoOperadoresCoordenacao> listaDeCoordenacoes = acessoOperadoresCoordenacaoService.buscarPorOperador(pessoaOperadoresService.buscarPorId( this.idOperadorLogado));
		model.addAttribute("escolhaAcessoEscala", new EscolhaAcessoEscala()); 
		model.addAttribute("coordenacaoEscala", coordenacaoEscalaService.buscarAcessoIndividual(unidadesService.buscarPorId(this.idUnidadeLogada) , pessoaOperadoresService.buscarPorId( this.idOperadorLogado) , listaDeCoordenacoes ) );
		model.addAttribute("anoMes", anoMesService.buscarTodos());
		return "/escala/escolher"; 
	}
	
	@GetMapping("/escolher/escala/todos")
	public String escolherEscalaTodos(ModelMap model) {
		
		Unidades unidade = unidadesService.buscarPorId(idUnidadeLogada);
		model.addAttribute("escolhaAcessoEscala", new EscolhaAcessoEscala());
		model.addAttribute("unidade", unidade); 
		model.addAttribute("anoMes", anoMesService.buscarTodos());
		return "/escala/escolherTodos"; 
	}
	
	@GetMapping("/escolher/escala/pos/transparencia")
	public String escolherEscalaPosTransparencia(ModelMap model) {
		
		Unidades unidade = unidadesService.buscarPorId(idUnidadeLogada);
		model.addAttribute("escolhaAcessoEscala", new EscolhaAcessoEscala());
		model.addAttribute("unidade", unidade); 
		model.addAttribute("anoMes", anoMesService.buscarTodos());
		return "/escala/escolherMudancasPosTransparencia"; 
	}
	
	@GetMapping("/escolher/escala/pos/transparencia/global")
	public String escolherEscalaPosTransparenciaGlobal(ModelMap model) {
		
		Unidades unidade = unidadesService.buscarPorId(idUnidadeLogada);
		model.addAttribute("escolhaAcessoEscala", new EscolhaAcessoEscala());
		model.addAttribute("unidade", unidade); 
		model.addAttribute("anoMes", anoMesService.buscarTodos());
		return "/escala/escolherMudancasPosTransparenciaGlobal"; 
	}
	
	//Escala Alteracao
	@GetMapping("/escolher/escala/alteracao")
	public String escolherEscalaAlteracao(ModelMap model) {
		
		Unidades unidade = unidadesService.buscarPorId(idUnidadeLogada);
		model.addAttribute("escolhaAcessoEscala", new EscolhaAcessoEscala());
		model.addAttribute("unidade", unidade); 
		model.addAttribute("anoMes", anoMesService.buscarTodos());
		return "/escala/escolherEscalaAlteracao"; 
	}
	
	@GetMapping("/escolher/escala/alteracao/global")
	public String escolherEscalaAlteracaoGlobal(ModelMap model) {
		
		Unidades unidade = unidadesService.buscarPorId(idUnidadeLogada);
		model.addAttribute("escolhaAcessoEscala", new EscolhaAcessoEscala());
		model.addAttribute("unidade", unidade); 
		model.addAttribute("anoMes", anoMesService.buscarTodos());
		return "/escala/escolherEscalaAlteracaoGlobal"; 
	}
	
	@PostMapping("/ir/para/escala")
	public String irParaEscala(ModelMap model, Long coordenacaoEscala, Long anoMes) {
		
		if(coordenacaoEscala!=null && anoMes!=null) {
			this.idCoordenacaoAtual = coordenacaoEscala;
			this.idAnoMesAtual = anoMes;
			
			return "redirect:/escalas/listar";
		}else {
			return "redirect:/escalas/mensagem/de/nao/escolha";
		}
		
	}
	
	@PostMapping("/ir/para/escala/todos")
	public String irParaEscalaTodos(ModelMap model, Long anoMes) {
		
		if( anoMes!=null) {
			this.idAnoMesAtual = anoMes;
			
			return "redirect:/escalas/listar/todos";
		}else {
			return "redirect:/escalas/mensagem/de/nao/escolha";
		}
		
	}
	
	//portal da transparência
	@PostMapping("/ir/para/escala/pos/transparencia")
	public String irParaEscalaPosTransparencia(ModelMap model, Long anoMes) {
		
		if( anoMes!=null) {
			this.idAnoMesAtual = anoMes;
			
			return "redirect:/escalas/listar/pos/transparencia";
		}else {
			return "redirect:/escalas/mensagem/de/nao/escolha";
		}
		
	}
	
	@PostMapping("/ir/para/escala/pos/transparencia/global")
	public String irParaEscalaPosTransparenciaGlobal(ModelMap model, Long anoMes) {
		
		if( anoMes!=null) {
			this.idAnoMesAtual = anoMes;
			
			return "redirect:/escalas/listar/pos/transparencia/global";
		}else {
			return "redirect:/escalas/mensagem/de/nao/escolha";
		}
		
	}
	
	
	//Escala Alteracao X9
	@PostMapping("/ir/para/escala/alteracao")
	public String irParaEscalaAlteracao(ModelMap model, Long anoMes) {
		
		if( anoMes!=null) {
			this.idAnoMesAtual = anoMes;
			
			return "redirect:/escalas/listar/escala/alteracao";
		}else {
			return "redirect:/escalas/mensagem/de/nao/escolha";
		}
		
	}
	
	@PostMapping("/ir/para/escala/alteracao/global")
	public String irParaEscalaAlteracaoGlobal(ModelMap model, Long anoMes) {
		
		if( anoMes!=null) {
			this.idAnoMesAtual = anoMes;
			
			return "redirect:/escalas/listar/escala/alteracao/global";
		}else {
			return "redirect:/escalas/mensagem/de/nao/escolha";
		}
		
	}


	@GetMapping("/listar")
	public String listar(ModelMap model) {
		ultimaBuscaNome = "";
		ultimaBuscaTurma = null;
		ultimaBuscaCargoEspecialidade = null;
		ultimaBuscaTiposDeFolha = null;
		return this.findPaginated(1, model);
	}	
	
	@GetMapping("/listar/todos")
	public String listarTodos(ModelMap model) {
		ultimaBuscaNome = "";
		ultimaBuscaTurma = null;
		ultimaBuscaCargoEspecialidade = null;
		ultimaBuscaTiposDeFolha = null;
		return this.findPaginatedTodos(1, model);
	}
	
	@GetMapping("/listar/pos/transparencia")
	public String listarEscalasPosTransparencia(ModelMap model) {
		ultimaBuscaNome = "";
		ultimaBuscaTurma = null;
		ultimaBuscaCargoEspecialidade = null;
		ultimaBuscaTiposDeFolha = null;
		return this.findPaginatedPosTransparencia(1, model);
	}	
	
	@GetMapping("/listar/pos/transparencia/global")
	public String listarEscalasPosTransparenciaGlobal(ModelMap model) {
		ultimaBuscaNome = "";
		ultimaBuscaTurma = null;
		ultimaBuscaCargoEspecialidade = null;
		ultimaBuscaTiposDeFolha = null;
		return this.findPaginatedPosTransparenciaGlobal(1, model);
	}	
	
	// Escala alteracao
	@GetMapping("/listar/escala/alteracao")
	public String listarEscalasEscalaAlteracao(ModelMap model) {
		ultimaBuscaNome = "";
		ultimaBuscaTurma = null;
		ultimaBuscaCargoEspecialidade = null;
		ultimaBuscaTiposDeFolha = null;
		return this.findPaginatedEscalaAlteracao(1, model);
	}	
	
	@GetMapping("/listar/escala/alteracao/global")
	public String listarEscalasEscalaAlteracaoGlobal(ModelMap model) {
		ultimaBuscaNome = "";
		ultimaBuscaTurma = null;
		ultimaBuscaCargoEspecialidade = null;
		ultimaBuscaTiposDeFolha = null;
		return this.findPaginatedEscalaAlteracaoGlobal(1, model);
	}	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 5;
		Page<Escala> page = service.findPaginated(pageNo, pageSeze, coordenacaoEscalaService.buscarPorId(idCoordenacaoAtual), anoMesService.buscarPorId(idAnoMesAtual));
		List<Escala> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	@GetMapping("/listar/todos/{pageNo}")
	public String findPaginatedTodos(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 5;
		Page<Escala> page = service.findPaginatedTodos(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual));
		List<Escala> lista = page.getContent();
		return paginarTodos(pageNo, page, lista, model);
	}
	
	@GetMapping("/listar/pos/transparencia/{pageNo}")
	public String findPaginatedPosTransparencia(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 5;
		Page<EscalaPosTransparencia> page = escalaPosTransparenciaService.findPaginatedPosTransparencia(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual));
		List<EscalaPosTransparencia> lista = page.getContent();
		return paginarPosTransparencia(pageNo, page, lista, model);
	}
	
	@GetMapping("/listar/pos/transparencia/global/{pageNo}")
	public String findPaginatedPosTransparenciaGlobal(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 5;
		Page<EscalaPosTransparencia> page = escalaPosTransparenciaService.findPaginatedPosTransparenciaGlobal(pageNo, pageSeze,  anoMesService.buscarPorId(idAnoMesAtual));
		List<EscalaPosTransparencia> lista = page.getContent();
		return paginarPosTransparenciaGlobal(pageNo, page, lista, model);
	}
	
	//Escala Alteracao
	@GetMapping("/listar/escala/alteracao/{pageNo}")
	public String findPaginatedEscalaAlteracao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 5;
		Page<EscalaAlteracoes> page = escalaAlteracoesService.findPaginatedEscalaAlteracao(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual));
		List<EscalaAlteracoes> lista = page.getContent();
		return paginarEscalaAlteracao(pageNo, page, lista, model);
	}
	
	@GetMapping("/listar/escala/alteracao/global/{pageNo}")
	public String findPaginatedEscalaAlteracaoGlobal(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 5;
		Page<EscalaAlteracoes> page = escalaAlteracoesService.findPaginatedEscalaAlteracaoGlobal(pageNo, pageSeze,  anoMesService.buscarPorId(idAnoMesAtual));
		List<EscalaAlteracoes> lista = page.getContent();
		return paginarEscalaAlteracaoGlobal(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<Escala> page, List<Escala> lista, ModelMap model) {	
		
		model.addAttribute("escala", coordenacaoEscalaService.buscarPorId(idCoordenacaoAtual));
		model.addAttribute("mes", anoMesService.buscarPorId(idAnoMesAtual));
		//Tratando Envio transparencia
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdTransparenciaEnviadaFk().getSigla().equalsIgnoreCase("S")) {model.addAttribute("transparencia", "Dados já enviados para o portal da transparência (Lei Federal de Acesso à Informação 12 527/2011). Ficará registrada sua mudança para possíveis comprovações.");}else {model.addAttribute("transparencia", "");}
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaEscala", lista);
		return "/escala/lista";	
	}
	
	public String paginarTodos(int pageNo, Page<Escala> page, List<Escala> lista, ModelMap model) {	
		
		model.addAttribute("escala", "Todos");
		model.addAttribute("mes", anoMesService.buscarPorId(idAnoMesAtual));
		//Tratando Envio transparencia
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdTransparenciaEnviadaFk().getSigla().equalsIgnoreCase("S")) {model.addAttribute("transparencia", "Dados já enviados para o portal da transparência (Lei Federal de Acesso à Informação 12 527/2011). Ficará registrada sua mudança para possíveis comprovações.");}else {model.addAttribute("transparencia", "");}
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaEscala", lista);
		return "/escala/listaTodos";	
	}
	
	public String paginarPosTransparencia(int pageNo, Page<EscalaPosTransparencia> page, List<EscalaPosTransparencia> lista, ModelMap model) {	
		
		model.addAttribute("escala", "Mudanças depois do envio ao Portal da Transparência");
		model.addAttribute("mes", anoMesService.buscarPorId(idAnoMesAtual));
		//Tratando Envio transparencia
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdTransparenciaEnviadaFk().getSigla().equalsIgnoreCase("S")) {model.addAttribute("transparencia", "Dados já enviados para o portal da transparência (Lei Federal de Acesso à Informação 12 527/2011). Ficará registrada sua mudança para possíveis comprovações.");}else {model.addAttribute("transparencia", "");}
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaEscala", lista);
		return "/escala/listaPosTransparencia";	
	}
	
	public String paginarPosTransparenciaGlobal(int pageNo, Page<EscalaPosTransparencia> page, List<EscalaPosTransparencia> lista, ModelMap model) {	
		
		model.addAttribute("escala", "Mudanças depois do envio ao Portal da Transparência");
		model.addAttribute("mes", anoMesService.buscarPorId(idAnoMesAtual));
		//Tratando Envio transparencia
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdTransparenciaEnviadaFk().getSigla().equalsIgnoreCase("S")) {model.addAttribute("transparencia", "Dados já enviados para o portal da transparência (Lei Federal de Acesso à Informação 12 527/2011). Ficará registrada sua mudança para possíveis comprovações.");}else {model.addAttribute("transparencia", "");}
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaEscala", lista);
		return "/escala/listaPosTransparenciaGlobal";	
	}
	
	//Escala Alteracao
	public String paginarEscalaAlteracao(int pageNo, Page<EscalaAlteracoes> page, List<EscalaAlteracoes> lista, ModelMap model) {	
		
		model.addAttribute("escala", "Todas as Alterações nas escalas.");
		model.addAttribute("mes", anoMesService.buscarPorId(idAnoMesAtual));
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaEscala", lista);
		return "/escala/listaEscalaAlteracao";	
	}
	
	public String paginarEscalaAlteracaoGlobal(int pageNo, Page<EscalaAlteracoes> page, List<EscalaAlteracoes> lista, ModelMap model) {	
		
		model.addAttribute("escala", "Todas as Alterações nas escalas.");
		model.addAttribute("mes", anoMesService.buscarPorId(idAnoMesAtual));
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaEscala", lista);
		return "/escala/listaEscalaAlteracaoGlobal";	
	}
	
		
	@GetMapping("/alterar/escala/{id}")
	public String cadastrarEscala(@PathVariable("id") Long id, Escala escala, ModelMap model) {	
		ultimoIdEscala = id;
		escala = service.buscarPorId(id);
		
		this.escalaAtual = escala;
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		
		String anoMesDaEscala = "202105";
		if(escala!=null){anoMesDaEscala = escala.getIdAnoMesFk().getNomeAnoMes();}
		int qtdDiasNoMes = escalaCalculosService.quantidadeDeDiasNoMes(anoMesDaEscala);
		
		// CALCULANDO OS DIAS DO MES
		String nomeColuna1 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 1);
		String nomeColuna2 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 2);
		String nomeColuna3 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 3);
		String nomeColuna4 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 4);
		String nomeColuna5 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 5);
		String nomeColuna6 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 6);
		String nomeColuna7 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 7);
		
		model.addAttribute("escala", escala );
		model.addAttribute("idLinha", id );
		model.addAttribute("qtdDiasNoMes", qtdDiasNoMes );
		model.addAttribute("nomeColuna1", nomeColuna1 );
		model.addAttribute("nomeColuna2", nomeColuna2 );
		model.addAttribute("nomeColuna3", nomeColuna3 );
		model.addAttribute("nomeColuna4", nomeColuna4 );
		model.addAttribute("nomeColuna5", nomeColuna5 );
		model.addAttribute("nomeColuna6", nomeColuna6 );
		model.addAttribute("nomeColuna7", nomeColuna7 );
		
		this.escalaAtual = escala;
		
		return "/escala/editar";
	}
	
	
	//Ver Escala Alteracao X9
	@GetMapping("/ver/escala/alteracao/{id}")
	public String verEscalaAlteracao(@PathVariable("id") Long id, EscalaAlteracoes escala, ModelMap model) {	
		ultimoIdEscala = id;
		escala = escalaAlteracoesService.buscarPorId(id);
		
		String anoMesDaEscala = "202105";
		if(escala!=null){anoMesDaEscala = escala.getIdAnoMesFk().getNomeAnoMes();}
		int qtdDiasNoMes = escalaCalculosService.quantidadeDeDiasNoMes(anoMesDaEscala);
		
		// CALCULANDO OS DIAS DO MES
		String nomeColuna1 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 1);
		String nomeColuna2 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 2);
		String nomeColuna3 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 3);
		String nomeColuna4 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 4);
		String nomeColuna5 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 5);
		String nomeColuna6 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 6);
		String nomeColuna7 = escalaCalculosService.obtemNomeDiaColuna(anoMesDaEscala, 7);
		
		model.addAttribute("escala", escala );
		model.addAttribute("idLinha", id );
		model.addAttribute("qtdDiasNoMes", qtdDiasNoMes );
		model.addAttribute("nomeColuna1", nomeColuna1 );
		model.addAttribute("nomeColuna2", nomeColuna2 );
		model.addAttribute("nomeColuna3", nomeColuna3 );
		model.addAttribute("nomeColuna4", nomeColuna4 );
		model.addAttribute("nomeColuna5", nomeColuna5 );
		model.addAttribute("nomeColuna6", nomeColuna6 );
		model.addAttribute("nomeColuna7", nomeColuna7 );
		
		return "/escala/verEscalaAlteracao";
	}

	
	

	@PostMapping("/salvar")
	public String salvar(Escala escala, String recalcular, String lancarTurma) {
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}
		
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		boolean podeSalvar = true;
		
		boolean chocou = false;
		boolean naoPresencialComNoturno = false;
		
		escala.setIdOperadorMudancaFk(pessoaOperadoresService.buscarPorId(idOperadorLogado));
		escala.setDtMudanca(new Date());
		
		//Avaliando Choques
		String choque = service.choquesEmEscalaOnipresenca(escala);
		this.choque = choque;
		if(choque.length()>0) {chocou = true; podeSalvar = false;}
		if(chocou==true) {
			return "redirect:/escalas/mensagem/de/choque";
		}
		
		//Avaliando Choques Depois Noturno
		String choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		this.choqueDescansoDepoisNoturno = "";
			if(escala.getIdLiberacaoDobraInvertidaSimNaoFk().getSigla().equalsIgnoreCase("N")) {
				this.choqueDescansoDepoisNoturno = choqueDescansoDepoisNoturno;
				if(choqueDescansoDepoisNoturno.length()>0) {chocou = true; podeSalvar = false;}
				if(chocou==true) {
				return "redirect:/escalas/mensagem/de/choque/depois/noturno";
			}
		}
				
		
		//Avaliando Noturno Não Presencial
		if(escala.getHorasNoite()!=null) {
			if(escala.getHorasNoite()>0) {
				if(escala.getIdPresencialSimNaoFk().getSigla().equalsIgnoreCase("N")) {
					naoPresencialComNoturno = true;
					podeSalvar = false;
				}
			}
		}
		if(naoPresencialComNoturno==true) {
			return "redirect:/escalas/mensagem/de/presencial/noturno";
		}
		
		
		//salvando
		if(podeSalvar==true ){
			service.salvar(escala);
			//Tratando Salvar Alteracoes X9
			escalaAlteracoesService.salvar(escalaAlteracoesService.converteDeEscalaParaEscalaAlteracoes(escala));
			//Tratando Envio transparencia
			if(anoMesService.buscarPorId(idAnoMesAtual).getIdTransparenciaEnviadaFk().getSigla().equalsIgnoreCase("S")) {			
				escalaPosTransparenciaService.salvar(escalaPosTransparenciaService.converteDeEscalaParaEscalaPosTransparencia(escala));
			}

		}
		//lançanco turma
		if(lancarTurma!= null) {service.lancarTurma(escala);}
		
		
		
		if(recalcular!=null) {
			return "redirect:/escalas/alterar/escala/"+escala.getId();
		}
		
		
		return "redirect:/escalas/listar";
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		
		
		Escala escala = service.buscarPorId(id); 
		
		escala.setIdOperadorCancelamentoFk(pessoaOperadoresService.buscarPorId(idOperadorLogado));
		escala.setDtCancelamento(new Date());
		escala.setIdOperadorMudancaFk(pessoaOperadoresService.buscarPorId(idOperadorLogado));
		escala.setDtMudanca(new Date());
		
		service.salvar(escala);
		//Tratando Salvar Alteracoes X9
		escalaAlteracoesService.salvar(escalaAlteracoesService.converteDeEscalaParaEscalaAlteracoes(escala));
		//Tratando Envio transparencia
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdTransparenciaEnviadaFk().getSigla().equalsIgnoreCase("S")) {			
			escalaPosTransparenciaService.salvar(escalaPosTransparenciaService.converteDeEscalaParaEscalaPosTransparencia(escala));
		}
		
		return "redirect:/escalas/listar";
	}
	
	// Buscas para um setor específico
	@GetMapping("/paginar/{pageNo}")
	public String getPorNomePaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaTurma == null) && (ultimaBuscaCargoEspecialidade == null)  && (ultimaBuscaTiposDeFolha == null) ){
			return "redirect:/escalas/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			if(ultimaBuscaTurma!=null) {
				return this.findPaginated(pageNo, ultimaBuscaTurma, model);}
			if(ultimaBuscaCargoEspecialidade!=null) {
				return this.findPaginated(pageNo, ultimaBuscaCargoEspecialidade, model);}
			if(ultimaBuscaTiposDeFolha!=null) {
				return this.findPaginated(pageNo, ultimaBuscaTiposDeFolha, model);}
			
			else {
				return "redirect:/escalas/listar/{pageNo}" ;}
			}
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		this.ultimaBuscaTurma = null;
		this.ultimaBuscaCargoEspecialidade = null;
		this.ultimaBuscaTiposDeFolha = null;
		return this.findPaginated(1, nome, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 5;
		Page<Escala> page = service.findPaginatedNome(pageNo, pageSeze, coordenacaoEscalaService.buscarPorId(idCoordenacaoAtual), anoMesService.buscarPorId(idAnoMesAtual), nome );
		List<Escala> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	@GetMapping("/buscar/id/turma")
	public String getPorIdTurma(@RequestParam("idTurmaFk") Turmas turmas, ModelMap model) {
		this.ultimaBuscaTurma = turmas;
		this.ultimaBuscaNome = "";
		this.ultimaBuscaCargoEspecialidade = null;
		this.ultimaBuscaTiposDeFolha = null;
		
		if(turmas==null){
			return "redirect:/escalas/listar";
		}else {
			return this.findPaginated(1, turmas, model);
		}
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Turmas turmas, ModelMap model) {
		int pageSeze = 5;
		Page<Escala> page = service.findPaginatedTurma(pageNo, pageSeze, coordenacaoEscalaService.buscarPorId(idCoordenacaoAtual), anoMesService.buscarPorId(idAnoMesAtual), turmas );
		List<Escala> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	@GetMapping("/buscar/id/cargo")
	public String getPorIdCargo(@RequestParam("idEspecialidadeCargoFk") CargosEspecialidade cargosEspecialidade, ModelMap model) {
		this.ultimaBuscaCargoEspecialidade = cargosEspecialidade;
		this.ultimaBuscaTurma = null;
		this.ultimaBuscaNome = "";
		this.ultimaBuscaTiposDeFolha = null;
		
		if(cargosEspecialidade==null){
			return "redirect:/escalas/listar";
		}else {
			return this.findPaginated(1, cargosEspecialidade, model);
		}
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, CargosEspecialidade cargosEspecialidade, ModelMap model) {
		int pageSeze = 5;
		Page<Escala> page = service.findPaginatedCargo(pageNo, pageSeze, coordenacaoEscalaService.buscarPorId(idCoordenacaoAtual), anoMesService.buscarPorId(idAnoMesAtual), cargosEspecialidade );
		List<Escala> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	@GetMapping("/buscar/id/folha")
	public String getPorIdFolha(@RequestParam("idTipoFolhaFk") TiposDeFolha tiposDeFolha, ModelMap model) {
		this.ultimaBuscaCargoEspecialidade = null;
		this.ultimaBuscaTurma = null;
		this.ultimaBuscaNome = "";
		this.ultimaBuscaTiposDeFolha = tiposDeFolha;
		
		if(tiposDeFolha==null){
			return "redirect:/escalas/listar";
		}else {
			return this.findPaginated(1, tiposDeFolha, model);
		}
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, TiposDeFolha tiposDeFolha, ModelMap model) {
		int pageSeze = 5;
		Page<Escala> page = service.findPaginatedFolha(pageNo, pageSeze, coordenacaoEscalaService.buscarPorId(idCoordenacaoAtual), anoMesService.buscarPorId(idAnoMesAtual), tiposDeFolha );
		List<Escala> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	// Buscas para todos
	@GetMapping("/paginar/todos/{pageNo}")
	public String getPorNomePaginadoTodos(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaTurma == null) && (ultimaBuscaCargoEspecialidade == null)  && (ultimaBuscaTiposDeFolha == null)  ){
			return "redirect:/escalas/listar/todos/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedTodos(pageNo, ultimaBuscaNome, model);}
			if(ultimaBuscaTurma!=null) {
				return this.findPaginatedTodos(pageNo, ultimaBuscaTurma, model);}
			if(ultimaBuscaCargoEspecialidade!=null) {
				return this.findPaginatedTodos(pageNo, ultimaBuscaCargoEspecialidade, model);}
			if(ultimaBuscaTiposDeFolha!=null) {
				return this.findPaginatedTodos(pageNo, ultimaBuscaTiposDeFolha, model);}
			
			
			else {
				return "redirect:/escalas/listar/{pageNo}" ;}
			}
	}
	
	@GetMapping("/buscar/nome/todos")
	public String getPorNomeTodos(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		this.ultimaBuscaTurma = null;
		this.ultimaBuscaCargoEspecialidade = null;
		this.ultimaBuscaTiposDeFolha = null;
		return this.findPaginatedTodos(1, nome, model);
	}
	
	public String findPaginatedTodos(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 5;
		Page<Escala> page = service.findPaginatedNomeTodos(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual), nome );
		List<Escala> lista = page.getContent();
		return paginarTodos(pageNo, page, lista, model);
	}
	
	@GetMapping("/buscar/id/turma/todos")
	public String getPorIdTurmaTodos(@RequestParam("idTurmaFk") Turmas turmas, ModelMap model) {
		this.ultimaBuscaTurma = turmas;
		this.ultimaBuscaNome = "";
		this.ultimaBuscaCargoEspecialidade = null;
		this.ultimaBuscaTiposDeFolha = null;
		
		if(turmas==null){
			return "redirect:/escalas/listar/todos";
		}else {
			return this.findPaginatedTodos(1, turmas, model);
		}
	}
	
	public String findPaginatedTodos(@PathVariable (value = "pageNo") int pageNo, Turmas turmas, ModelMap model) {
		int pageSeze = 5;
		Page<Escala> page = service.findPaginatedTurmaTodos(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual), turmas );
		List<Escala> lista = page.getContent();
		return paginarTodos(pageNo, page, lista, model);
	}
	
	@GetMapping("/buscar/id/cargo/todos")
	public String getPorIdCargoTodos(@RequestParam("idEspecialidadeCargoFk") CargosEspecialidade cargosEspecialidade, ModelMap model) {
		this.ultimaBuscaCargoEspecialidade = cargosEspecialidade;
		this.ultimaBuscaTurma = null;
		this.ultimaBuscaNome = "";
		this.ultimaBuscaTiposDeFolha = null;
		
		if(cargosEspecialidade==null){
			return "redirect:/escalas/listar/todos";
		}else {
			return this.findPaginatedTodos(1, cargosEspecialidade, model);
		}
	}
	
	public String findPaginatedTodos(@PathVariable (value = "pageNo") int pageNo, CargosEspecialidade cargosEspecialidade, ModelMap model) {
		int pageSeze = 5;
		Page<Escala> page = service.findPaginatedCargoTodos(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual), cargosEspecialidade );
		List<Escala> lista = page.getContent();
		return paginarTodos(pageNo, page, lista, model);
	}
	
	@GetMapping("/buscar/id/folha/todos")
	public String getPorIdCargoTodos(@RequestParam("idTipoFolhaFk") TiposDeFolha tiposDeFolha, ModelMap model) {
		this.ultimaBuscaCargoEspecialidade = null;
		this.ultimaBuscaTurma = null;
		this.ultimaBuscaNome = "";
		this.ultimaBuscaTiposDeFolha = tiposDeFolha;
		
		if(tiposDeFolha==null){
			return "redirect:/escalas/listar/todos";
		}else {
			return this.findPaginatedTodos(1, tiposDeFolha, model);
		}
	}
	
	public String findPaginatedTodos(@PathVariable (value = "pageNo") int pageNo, TiposDeFolha tiposDeFolha, ModelMap model) {
		int pageSeze = 5;
		Page<Escala> page = service.findPaginatedFolhaTodos(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual), tiposDeFolha );
		List<Escala> lista = page.getContent();
		return paginarTodos(pageNo, page, lista, model);
	}
	
	//Buscar escala pos transparencia
	@GetMapping("/paginar/pos/transparencia/{pageNo}")
	public String getPorNomePaginadoPosTransparencia(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) ){
			return "redirect:/escalas/listar/pos/transparencia/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedPosTransparencia(pageNo, ultimaBuscaNome, model);}
			
			else {
				return "redirect:/escalas/listar/pos/transparencia/{pageNo}" ;}
			}
	}
	
	@GetMapping("/buscar/nome/pos/transparencia")
	public String getPorNomePosTransparencia(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		this.ultimaBuscaTurma = null;
		this.ultimaBuscaCargoEspecialidade = null;
		this.ultimaBuscaTiposDeFolha = null;
		return this.findPaginatedPosTransparencia(1, nome, model);
	}
	
	public String findPaginatedPosTransparencia(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 5;
		Page<EscalaPosTransparencia> page = escalaPosTransparenciaService.findPaginatedNomePosTransparencia(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual), nome );
		List<EscalaPosTransparencia> lista = page.getContent();
		return paginarPosTransparencia(pageNo, page, lista, model);
	}

	
	
	// para global (todas as unidades)
	@GetMapping("/paginar/pos/transparencia/global/{pageNo}")
	public String getPorNomePaginadoPosTransparenciaGlobal(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
			
	    return this.findPaginatedPosTransparenciaGlobal(pageNo,  model);
	}
	
	
	
	//Buscar Escala Alteracao
	@GetMapping("/paginar/escala/alteracao/{pageNo}")
	public String getPorNomePaginadoEscalaAlteracao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) ){
			return "redirect:/escalas/listar/escala/alteracao/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedEscalaAlteracao(pageNo, ultimaBuscaNome, model);}
			
			else {
				return "redirect:/escalas/listar/escala/alteracao/{pageNo}" ;}
			}
	}
	
	@GetMapping("/buscar/nome/escala/alteracao")
	public String getPorNomeEscalaAlteracao(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		this.ultimaBuscaTurma = null;
		this.ultimaBuscaCargoEspecialidade = null;
		this.ultimaBuscaTiposDeFolha = null;
		return this.findPaginatedEscalaAlteracao(1, nome, model);
	}
	
	public String findPaginatedEscalaAlteracao(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 5;
		Page<EscalaAlteracoes> page = escalaAlteracoesService.findPaginatedNomeEscalaAlteracao(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual), nome );
		List<EscalaAlteracoes> lista = page.getContent();
		return paginarEscalaAlteracao(pageNo, page, lista, model);
	}


	
	

	// Avaliacao (notas)
	@GetMapping("/alterar/avaliacao/{id}")
	public String cadastrarAvaliacao(@PathVariable("id") Long id, Escala escala, ModelMap model) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		
		
		ultimoIdEscala = id;
		escala = service.buscarPorId(id);
		
		this.escalaAtual = escala;
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		
		model.addAttribute("escala", escala );
		model.addAttribute("idLinha", id );
		
		this.escalaAtual = escala;
		
		return "/escala/editarAvaliacao";
	}
	
	
	// Atalhos Escala
	
	@GetMapping("/atalho/limpar_escala/choque")
	public String atalhoLimparEscalaChoque( RedirectAttributes attr, String critica) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		
		
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaAtalhosService.atalhoLimaprEscala(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", critica+" ESCALA VAI FICAR ZERADA ATÉ QUE O(S) CONFLITOS SEJA(M) RESOLVIDO(S).");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/limpar_escala")
	public String atalhoLimparEscala( RedirectAttributes attr) {
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoLimaprEscala(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/diarista_manha")
	public String atalhoDiaristaManha( RedirectAttributes attr) {
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoDiaristasManha(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/diarista_tarde")
	public String atalhoDiaristaTarde( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		
		
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoDiaristasTarde(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/diarista_dia")
	public String atalhoDiaristaDia( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoDiaristasDia(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/mt_dias_impares")
	public String atalhoMTDiasImpares( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoMTDiasImpares(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/mt_dias_pares")
	public String atalhoMTDiasPares( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoMTDiasPares(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	//Ciclo 1
	@GetMapping("/atalho/ciclo1_a")
	public String atalhoCiclo1A( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_b")
	public String atalhoCiclo1B( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_c")
	public String atalhoCiclo1C( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_d")
	public String atalhoCiclo1D( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_e")
	public String atalhoCiclo1E( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_f")
	public String atalhoCiclo1F( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	//Ciclo2
	@GetMapping("/atalho/ciclo2_a")
	public String atalhoCiclo2A( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_b")
	public String atalhoCiclo2B( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_c")
	public String atalhoCiclo2C( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_d")
	public String atalhoCiclo2D( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_e")
	public String atalhoCiclo2E( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_f")
	public String atalhoCiclo2F( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}

	//Ciclo4
	@GetMapping("/atalho/ciclo4_a")
	public String atalhoCiclo4A( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_b")
	public String atalhoCiclo4B( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_c")
	public String atalhoCiclo4C( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_d")
	public String atalhoCiclo4D( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_e")
	public String atalhoCiclo4E( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_f")
	public String atalhoCiclo4F( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}

	//Ciclo5
	@GetMapping("/atalho/ciclo5_a")
	public String atalhoCiclo5A( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_b")
	public String atalhoCiclo5B( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_c")
	public String atalhoCiclo5C( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_d")
	public String atalhoCiclo5D( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_e")
	public String atalhoCiclo5E( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_f")
	public String atalhoCiclo5F( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}

	//Ciclo6
	@GetMapping("/atalho/ciclo6_a")
	public String atalhoCiclo6A( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_b")
	public String atalhoCiclo6B( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_c")
	public String atalhoCiclo6C( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_d")
	public String atalhoCiclo6D( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_e")
	public String atalhoCiclo6E( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_f")
	public String atalhoCiclo6F( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}

	//Ciclo7
	@GetMapping("/atalho/ciclo7_a")
	public String atalhoCiclo7A( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_b")
	public String atalhoCiclo7B( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_c")
	public String atalhoCiclo7C( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_d")
	public String atalhoCiclo7D( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_e")
	public String atalhoCiclo7E( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_f")
	public String atalhoCiclo7F( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}


	//Ciclo8
	@GetMapping("/atalho/ciclo8_a")
	public String atalhoCiclo8A( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo8A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo8_b")
	public String atalhoCiclo8B( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo8B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo8_c")
	public String atalhoCiclo8C( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo8C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo8_d")
	public String atalhoCiclo8D( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo8D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo8_e")
	public String atalhoCiclo8E( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo8E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo8_f")
	public String atalhoCiclo8F( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo8F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo8_g")
	public String atalhoCiclo8G( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo8G(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	
	//Ciclo8
	@GetMapping("/atalho/ciclo9_a")
	public String atalhoCiclo9A( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo9A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo9_b")
	public String atalhoCiclo9B( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo9B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo9_c")
	public String atalhoCiclo9C( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo9C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo9_d")
	public String atalhoCiclo9D( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo9D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo9_e")
	public String atalhoCiclo9E( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo9E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo9_f")
	public String atalhoCiclo9F( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo9F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo9_g")
	public String atalhoCiclo9G( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo9G(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	
	//Ciclo10
	@GetMapping("/atalho/ciclo10_a")
	public String atalhoCiclo10A( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo10A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo10_b")
	public String atalhoCiclo10B( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo10B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo10_c")
	public String atalhoCiclo10C( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo10C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo10_d")
	public String atalhoCiclo10D( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo10D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo10_e")
	public String atalhoCiclo10E( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo10E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo10_f")
	public String atalhoCiclo10F( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo10F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo10_g")
	public String atalhoCiclo10G( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo10G(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	

	
	//Ciclo11
	@GetMapping("/atalho/ciclo11_a")
	public String atalhoCiclo11A( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo11A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo11_b")
	public String atalhoCiclo11B( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo11B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo11_c")
	public String atalhoCiclo11C( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo11C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo11_d")
	public String atalhoCiclo11D( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo11D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo11_e")
	public String atalhoCiclo11E( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo11E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo11_f")
	public String atalhoCiclo11F( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo11F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo11_g")
	public String atalhoCiclo11G( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo11G(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	

	
	//Ciclo12
	@GetMapping("/atalho/ciclo12_a")
	public String atalhoCiclo12A( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo12A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo12_b")
	public String atalhoCiclo12B( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo12B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo12_c")
	public String atalhoCiclo12C( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo12C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo12_d")
	public String atalhoCiclo12D( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo12D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo12_e")
	public String atalhoCiclo12E( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo12E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo12_f")
	public String atalhoCiclo12F( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo12F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo12_g")
	public String atalhoCiclo12G( RedirectAttributes attr) {	
		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo12G(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		//AVALIAÇÃO PARA SABER SE TEM CHOQUES
		this.choque = service.choquesEmEscalaOnipresenca(escala);
		this.choqueDescansoDepoisNoturno = service.choquesEmEscalaDepoisDoNoturno(escala);
		if(choqueDescansoDepoisNoturno.length()>0) {attr.addFlashAttribute("fail", choqueDescansoDepoisNoturno); return atalhoLimparEscalaChoque(attr, choqueDescansoDepoisNoturno); }
		if(choque.length()>0) {attr.addFlashAttribute("fail", choque); return atalhoLimparEscalaChoque(attr, choque);  }
		if((choqueDescansoDepoisNoturno.length()==0) && (choque.length()==0)) {
			salvar(escala, null, null);
			ultimoIdEscala = escala.getId();
			attr.addFlashAttribute("success", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		}
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	

	@GetMapping("/mensagem/de/escala/bloqueada")
	public String mensagemDeEscalaBloqueada(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "ESCALA BLOQUEADA");
		model.addAttribute("mensagem", "Precisamos cumprir os prazos para evitar problemas.");
		
		return "/choqueescala/escalaBloqueada";
	}
	
	@GetMapping("/mensagem/de/choque")
	public String mensagemDeChoque(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "CHOQUE EM ESCALA");
		model.addAttribute("mensagem", choque);
		
		return "/choqueescala/choque";
	}
	
	@GetMapping("/mensagem/de/choque/depois/noturno")
	public String mensagemDeChoqueDepoisNoturno(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "NÃO DESCANSO DEPOIS DO NOTURNO");
		model.addAttribute("mensagem", choqueDescansoDepoisNoturno);
		
		return "/choqueescala/choqueDepoisNoturno";
	}
	
	@GetMapping("/mensagem/de/presencial/noturno")
	public String mensagemDePresencialNoturno(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "ESCALA NÃO PRESENCIAL");
		model.addAttribute("mensagem", "Você não pode impetrar uma escala não presencial com adicional noturno.");
		
		return "/choqueescala/naoPresencial";
	}
	
	@GetMapping("/mensagem/de/nao/escolha")
	public String mensagemDeNaoEscolha(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "ESCOLHA");
		model.addAttribute("mensagem", "Campos obrigatórios");
		
		return "/choqueescala/obrigatorio";
	}

	// Metodos da Inclusão	
	@GetMapping("/paginar/inclusao/{pageNo}")
	public String getPorNomePaginadoInclusao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) ){
			return "redirect:/escalas/listar/inclusao/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedInclusao(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/escalas/listar/inclusao/{pageNo}" ;}
			}
	}
	
	@GetMapping("/listar/inclusao")
	public String listarInclusao(ModelMap model) {
		ultimaBuscaNome = "";
		return this.findPaginatedInclusao(1, model);
	}	
	
	@GetMapping("/listar/inclusao/{pageNo}")
	public String findPaginatedInclusao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 5;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginated(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), "ATIVO");
		List<PessoaFuncionarios> listaCidades = page.getContent();
		return paginarInclusao(pageNo, page, listaCidades, model);
	}
	
	public String paginarInclusao(int pageNo, Page<PessoaFuncionarios> page, List<PessoaFuncionarios> lista, ModelMap model) {	
		
		model.addAttribute("escala", coordenacaoEscalaService.buscarPorId(idCoordenacaoAtual));
		model.addAttribute("mes", anoMesService.buscarPorId(idAnoMesAtual));
		
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaFuncionarios", lista);
		return "/escala/listaInclusao";	
	}
	
	@GetMapping("/buscar/inclusao/nome")
	public String getPorNomeInclusao(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		this.ultimaBuscaTurma = null;	
		return this.findPaginatedInclusao(1, nome, model);
	}
	
	public String findPaginatedInclusao(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 5;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginatedNome(pageNo, pageSeze, unidadesService.buscarPorId(idUnidadeLogada), "ATIVO", nome);
		List<PessoaFuncionarios> lista = page.getContent();
		//ultimaBuscaNome = "";
		//ultimaBuscaTurma = null;
		return paginarInclusao(pageNo, page, lista, model);
	}
	
	@GetMapping("/incluir/{id}")
	public String incluirEscala(@PathVariable("id") Long id, ModelMap model) {
		
		String nome = pessoaFuncionariosService.buscarPorId(id).getIdPessoaFk().getNome();
		
		InclusaoEscala inclusaoEscala = new InclusaoEscala();
		inclusaoEscala.setId(id);		
		List<AcessoOperadoresCoordenacao> listaDeCoordenacoes = acessoOperadoresCoordenacaoService.buscarPorOperador(pessoaOperadoresService.buscarPorId( this.idOperadorLogado));
		model.addAttribute("escolhaAcessoEscala", new EscolhaAcessoEscala()); 
		model.addAttribute("coordenacaoEscala", coordenacaoEscalaService.buscarAcessoIndividual(unidadesService.buscarPorId(this.idUnidadeLogada) , pessoaOperadoresService.buscarPorId( this.idOperadorLogado) , listaDeCoordenacoes ) );
		model.addAttribute("anoMes", anoMesService.buscarTodos());
		model.addAttribute("nome", nome);
		model.addAttribute("inclusaoEscala", inclusaoEscala);
		
		return "/escala/incluir"; 
	}
	
	@PostMapping("/incluindo")
	public String incluindo(ModelMap model, InclusaoEscala inclusaoEscala ) {

		//Tratando escala Bloqueada
		if(anoMesService.buscarPorId(idAnoMesAtual).getIdEscalaBloqueadaFk().getSigla().equalsIgnoreCase("S")) {
		return "redirect:/escalas/mensagem/de/escala/bloqueada";
		}		

		
		if(inclusaoEscala.getId()!=null && inclusaoEscala.getRegiDeTrabalho()!= null && inclusaoEscala.getTiposDeFolha()!=null && inclusaoEscala.getTurma()!=null) {
			
			Turmas turma = inclusaoEscala.getTurma();
			RegimesDeTrabalho regimesDeTrabalho = inclusaoEscala.getRegiDeTrabalho();
			TiposDeFolha tiposDeFolha = inclusaoEscala.getTiposDeFolha();
			PessoaFuncionarios pessoaFuncionarios = pessoaFuncionariosService.buscarPorId(inclusaoEscala.getId());
			AnoMes anoMes = anoMesService.buscarPorId(idAnoMesAtual);
			CoordenacaoEscala coordenacaoEscala = coordenacaoEscalaService.buscarPorId(idCoordenacaoAtual);
			CodigoDiferenciado codigoDiferenciado = codigoDiferenciadoService.buscarPorNome(unidadesService.buscarPorId(idUnidadeLogada) ,"N" ).get(0);
			Date dtMudanca = new Date();
			PessoaOperadores idOperadorMudanca = pessoaOperadoresService.buscarPorId(idOperadorLogado);
			Date dtCancelamento = null;
			PessoaOperadores idOperadorCancelamento = null;
			Double plantoes = 0.0;
			Turnos turnos = turnosService.buscarPorNome("");
			SimNao simNaoNAO = simNaoService.buscarPorSigla("N").get(0);
			SimNao simNaoSIM = simNaoService.buscarPorSigla("S").get(0);
			
			Escala escala = new Escala();
			escala.setId(null);
			escala.setIdAnoMesFk(anoMes);
			escala.setIdCoordenacaoFk(coordenacaoEscala);
			escala.setIdFuncionarioFk(pessoaFuncionarios);
			escala.setIdTipoFolhaFk(tiposDeFolha);
			escala.setIdRegimeFk(regimesDeTrabalho);
			escala.setIdCodigoDiferenciadoFk(codigoDiferenciado);
			escala.setHorasDia(0);
			escala.setHorasFimSemana(0);
			escala.setHorasNoite(0);
			escala.setHorasSemana(0);
			escala.setHorasTotais(0);
			escala.setDtMudanca(dtMudanca);
			escala.setIdOperadorMudancaFk(idOperadorMudanca);
			escala.setDtCancelamento(dtCancelamento);
			escala.setIdOperadorCancelamentoFk(idOperadorCancelamento);
			escala.setPlantoes(plantoes);
			escala.setIdTurmaFk(turma);
			escala.setIdChDifSimNaoFk(simNaoNAO);
			escala.setIdIncrementoDeRiscoSimNaoFk(simNaoNAO);
			escala.setIdAvaliacaoAssiduidadeFk(simNaoSIM);
			escala.setIdAvaliacaoAtividadesBurocraticasFk(simNaoSIM);
			escala.setIdAvaliacaoFormalizacaoPontoFk(simNaoSIM);
			escala.setIdAvaliacaoPermanenciaFk(simNaoSIM);
			escala.setIdPresencialSimNaoFk(simNaoSIM);
			escala.setIdLiberacaoDobraInvertidaSimNaoFk(simNaoNAO);
			escala.setDia01Fk(turnos);
			escala.setDia02Fk(turnos);
			escala.setDia03Fk(turnos);
			escala.setDia04Fk(turnos);
			escala.setDia05Fk(turnos);
			escala.setDia06Fk(turnos);
			escala.setDia07Fk(turnos);
			escala.setDia08Fk(turnos);
			escala.setDia09Fk(turnos);
			escala.setDia10Fk(turnos);
			escala.setDia11Fk(turnos);
			escala.setDia12Fk(turnos);
			escala.setDia13Fk(turnos);
			escala.setDia14Fk(turnos);
			escala.setDia15Fk(turnos);
			escala.setDia16Fk(turnos);
			escala.setDia17Fk(turnos);
			escala.setDia18Fk(turnos);
			escala.setDia19Fk(turnos);
			escala.setDia20Fk(turnos);
			escala.setDia21Fk(turnos);
			escala.setDia22Fk(turnos);
			escala.setDia23Fk(turnos);
			escala.setDia24Fk(turnos);
			escala.setDia25Fk(turnos);
			escala.setDia26Fk(turnos);
			escala.setDia27Fk(turnos);
			escala.setDia28Fk(turnos);
			escala.setDia29Fk(turnos);
			escala.setDia30Fk(turnos);
			escala.setDia31Fk(turnos);
			
			salvar(escala, null, null);
			
			return "redirect:/escalas/listar";
		}else {
			return "redirect:/escalas/mensagem/de/nao/escolha";
		}
		
	}
	
	
	//Exportacao
	@GetMapping("/exporta/excel")
    public void downloadExcel(HttpServletResponse response, ModelMap model) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=dados.xlsx");
        ByteArrayInputStream stream = escalaExportacaoService.exportarExcel(service.buscarExportacao(coordenacaoEscalaService.buscarPorId(idCoordenacaoAtual), anoMesService.buscarPorId(idAnoMesAtual)));
        IOUtils.copy(stream, response.getOutputStream());
    }
	
	@GetMapping(value = "/exporta/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {
		ByteArrayInputStream bis = escalaExportacaoService.exportarPdf(service.buscarExportacao(coordenacaoEscalaService.buscarPorId(idCoordenacaoAtual), anoMesService.buscarPorId(idAnoMesAtual)));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=dados.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	@GetMapping(value = "/exporta/pdf/setorial/servico", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReportsSetorialServico(HttpServletResponse response) throws IOException {
		ByteArrayInputStream bis = escalaExportacaoService.exportarPdfSetorial(service.buscarExportacaoSetorialServico(coordenacaoEscalaService.buscarPorId(idCoordenacaoAtual), anoMesService.buscarPorId(idAnoMesAtual)));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=dados.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	//Exportacao Todos os setores
		@GetMapping("/exporta/excel/todos")
	    public void downloadExcelTodos(HttpServletResponse response, ModelMap model) throws IOException {
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Disposition", "attachment; filename=dados.xlsx");
	        ByteArrayInputStream stream = escalaExportacaoService.exportarExcel(service.buscarExportacaoTodos(unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual)));
	        IOUtils.copy(stream, response.getOutputStream());
	    }
		
		@GetMapping(value = "/exporta/pdf/todos", produces = MediaType.APPLICATION_PDF_VALUE)
		public ResponseEntity<InputStreamResource> employeeReportsTodos(HttpServletResponse response) throws IOException {
			ByteArrayInputStream bis = escalaExportacaoService.exportarPdf(service.buscarExportacaoTodos(unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual)));
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment;filename=dados.pdf");
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
		
		//Exportacao Pos Transparência
		@GetMapping("/exporta/excel/pos/transparencia")
	    public void downloadExcelPosTransparencia(HttpServletResponse response, ModelMap model) throws IOException {
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Disposition", "attachment; filename=dados.xlsx");
	        ByteArrayInputStream stream = escalaExportacaoService.exportarExcelPosTransparencia(escalaPosTransparenciaService.buscarNaUnidade(unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual)));
	        IOUtils.copy(stream, response.getOutputStream());
	    }
		
		@GetMapping(value = "/exporta/pdf/pos/transparencia", produces = MediaType.APPLICATION_PDF_VALUE)
		public ResponseEntity<InputStreamResource> employeeReportsPosTransparencia(HttpServletResponse response) throws IOException {
			ByteArrayInputStream bis = escalaExportacaoService.exportarPdfPosTransparencia(escalaPosTransparenciaService.buscarNaUnidade(unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual)));
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment;filename=dados.pdf");
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
		
		//Exportacao Pos Transparência Global
		@GetMapping("/exporta/excel/pos/transparencia/global")
	    public void downloadExcelPosTransparenciaGlobal(HttpServletResponse response, ModelMap model) throws IOException {
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Disposition", "attachment; filename=dados.xlsx");
	        ByteArrayInputStream stream = escalaExportacaoService.exportarExcelPosTransparencia(escalaPosTransparenciaService.buscarEmTodasAsUnidades( anoMesService.buscarPorId(idAnoMesAtual)));
	        IOUtils.copy(stream, response.getOutputStream());
	    }
		
		@GetMapping(value = "/exporta/pdf/pos/transparencia/global", produces = MediaType.APPLICATION_PDF_VALUE)
		public ResponseEntity<InputStreamResource> employeeReportsPosTransparenciaGlobal(HttpServletResponse response) throws IOException {
			ByteArrayInputStream bis = escalaExportacaoService.exportarPdfPosTransparencia(escalaPosTransparenciaService.buscarEmTodasAsUnidades( anoMesService.buscarPorId(idAnoMesAtual)));
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment;filename=dados.pdf");
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
			
		
		//Exportacao Escala Alteracoes X9
		@GetMapping("/exporta/excel/escala/alteracao")
	    public void downloadExcelEscalaAlteracao(HttpServletResponse response, ModelMap model) throws IOException {
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Disposition", "attachment; filename=dados.xlsx");
	        ByteArrayInputStream stream = escalaExportacaoService.exportarExcelEscalaAlteracao(escalaAlteracoesService.buscarNaUnidade(unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual)));
	        IOUtils.copy(stream, response.getOutputStream());
	    }
		
		@GetMapping(value = "/exporta/pdf/escala/alteracao", produces = MediaType.APPLICATION_PDF_VALUE)
		public ResponseEntity<InputStreamResource> employeeReportsEscalaAlteracao(HttpServletResponse response) throws IOException {
			ByteArrayInputStream bis = escalaExportacaoService.exportarPdfEscalaAlteracao(escalaAlteracoesService.buscarNaUnidade(unidadesService.buscarPorId(idUnidadeLogada), anoMesService.buscarPorId(idAnoMesAtual)));
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment;filename=dados.pdf");
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
		
		//Exportacao Escala Alteracoes X9 Global
		@GetMapping("/exporta/excel/escala/alteracao/global")
	    public void downloadExcelEscalaAlteracaoGlobal(HttpServletResponse response, ModelMap model) throws IOException {
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Disposition", "attachment; filename=dados.xlsx");
	        ByteArrayInputStream stream = escalaExportacaoService.exportarExcelEscalaAlteracao(escalaAlteracoesService.buscarEmTodasAsUnidades( anoMesService.buscarPorId(idAnoMesAtual)));
	        IOUtils.copy(stream, response.getOutputStream());
	    }
		
		@GetMapping(value = "/exporta/pdf/escala/alteracao/global", produces = MediaType.APPLICATION_PDF_VALUE)
		public ResponseEntity<InputStreamResource> employeeReportsEscalaAlteracaoGlobal(HttpServletResponse response) throws IOException {
			ByteArrayInputStream bis = escalaExportacaoService.exportarPdfEscalaAlteracao(escalaAlteracoesService.buscarEmTodasAsUnidades( anoMesService.buscarPorId(idAnoMesAtual)));
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment;filename=dados.pdf");
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}

		
		
		
	
	// Metodos para preencher os combobox
	
	@ModelAttribute("idTipoFolhaFk")
	public List<TiposDeFolha> getTipoFolha() {
		return tiposDeFolhaService.buscarTodos();
	}
	@ModelAttribute("idChDifSimNaoFk")
	public List<SimNao> getChDif() {
		return simNaoService.buscarTodos();
	}
	@ModelAttribute("idPresencialSimNaoFk")
	public List<SimNao> getPresencial() {
		return simNaoService.buscarTodos();
	}
	@ModelAttribute("idIncrementoDeRiscoSimNaoFk")
	public List<SimNao> getIncrementoDeRisco() {
		return simNaoService.buscarTodos();
	}
	@ModelAttribute("idLiberacaoDobraInvertidaSimNaoFk")
	public List<SimNao> getLiberacaoDobraInvertida() {
		return simNaoService.buscarTodos();
	}
	@ModelAttribute("idCodigoDiferenciadoFk")
	public List<CodigoDiferenciado> getCodigosDiferenciado() {
		return codigoDiferenciadoService.buscarTodos(unidadesService.buscarPorId(idUnidadeLogada));
	}
	@ModelAttribute("idRegimeFk")
	public List<RegimesDeTrabalho> getRegimesDeTrabalho() {
		return regimesDeTrabalhoService.buscarTodos();
	}
	@ModelAttribute("idTurmaFk")
	public List<Turmas> getTurma() {
		return turmasService.buscarTodos();
	}
	
	@ModelAttribute("dia01Fk")
	public List<Turnos> getTurnos01() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia02Fk")
	public List<Turnos> getTurnos02() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia03Fk")
	public List<Turnos> getTurnos03() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia04Fk")
	public List<Turnos> getTurnos04() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia05Fk")
	public List<Turnos> getTurnos05() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia06Fk")
	public List<Turnos> getTurnos06() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia07Fk")
	public List<Turnos> getTurnos07() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia08Fk")
	public List<Turnos> getTurnos08() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia09Fk")
	public List<Turnos> getTurnos09() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia10Fk")
	public List<Turnos> getTurnos10() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia11Fk")
	public List<Turnos> getTurnos11() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia12Fk")
	public List<Turnos> getTurnos12() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia13Fk")
	public List<Turnos> getTurnos13() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia14Fk")
	public List<Turnos> getTurnos14() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia15Fk")
	public List<Turnos> getTurnos15() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia16Fk")
	public List<Turnos> getTurnos16() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia17Fk")
	public List<Turnos> getTurnos17() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia18Fk")
	public List<Turnos> getTurnos18() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia19Fk")
	public List<Turnos> getTurnos19() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia20Fk")
	public List<Turnos> getTurnos20() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia21Fk")
	public List<Turnos> getTurnos21() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia22Fk")
	public List<Turnos> getTurnos22() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia23Fk")
	public List<Turnos> getTurnos23() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia24Fk")
	public List<Turnos> getTurnos24() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia25Fk")
	public List<Turnos> getTurnos25() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia26Fk")
	public List<Turnos> getTurnos26() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia27Fk")
	public List<Turnos> getTurnos27() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia28Fk")
	public List<Turnos> getTurnos28() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia29Fk")
	public List<Turnos> getTurnos29() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia30Fk")
	public List<Turnos> getTurnos30() {
		return turnosService.buscarTodos();
	}
	@ModelAttribute("dia31Fk")
	public List<Turnos> getTurnos31() {
		return turnosService.buscarTodos();
	}
		
	@ModelAttribute("idAvaliacaoAssiduidadeFk")
	public List<SimNao> getIdAvaliacaoAssiduidadeFk() {
		return simNaoService.buscarTodos();
	}
	@ModelAttribute("idAvaliacaoPermanenciaFk")
	public List<SimNao> getIdAvaliacaoPermanenciaFk() {
		return simNaoService.buscarTodos();
	}
	@ModelAttribute("idAvaliacaoFormalizacaoPontoFk")
	public List<SimNao> getIdAvaliacaoFormalizacaoPontoFk() {
		return simNaoService.buscarTodos();
	}
	@ModelAttribute("idAvaliacaoAtividadesBurocraticasFk")
	public List<SimNao> getIdAvaliacaoAtividadesBurocraticasFk() {
		return simNaoService.buscarTodos();
	}
	@ModelAttribute("idEspecialidadeCargoFk")
	public List<CargosEspecialidade> getIdEspecialidadeCargoFk() {
		return cargosEspecialidadeService.buscarTodos();
	}
	
}

