package com.folha.boot.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
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
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.Escala;
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
import com.folha.boot.domain.models.EscolhaAcessoEscala;
import com.folha.boot.domain.models.InclusaoEscala;
import com.folha.boot.service.AcessoOperadoresCoordenacaoService;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.CoordenacaoEscalaService;
import com.folha.boot.service.EscalaAtalhosService;
import com.folha.boot.service.EscalaCalculosService;
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
	
	String ultimaBuscaNome = "";
	Turmas ultimaBuscaTurma = null;
	
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
	
	
	
	@GetMapping("/escolher/escala")
	public String escolherEscala(ModelMap model) {
		
		List<AcessoOperadoresCoordenacao> listaDeCoordenacoes = acessoOperadoresCoordenacaoService.buscarPorOperador(pessoaOperadoresService.buscarPorId( this.idOperadorLogado));
		model.addAttribute("escolhaAcessoEscala", new EscolhaAcessoEscala()); 
		model.addAttribute("coordenacaoEscala", coordenacaoEscalaService.buscarAcessoIndividual(unidadesService.buscarPorId(this.idUnidadeLogada) , pessoaOperadoresService.buscarPorId( this.idOperadorLogado) , listaDeCoordenacoes ) );
		model.addAttribute("anoMes", anoMesService.buscarTodos());
		return "/escala/escolher"; 
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

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		ultimaBuscaNome = "";
		ultimaBuscaTurma = null;
		return this.findPaginated(1, model);
	}	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 5;
		Page<Escala> page = service.findPaginated(pageNo, pageSeze, coordenacaoEscalaService.buscarPorId(idCoordenacaoAtual), anoMesService.buscarPorId(idAnoMesAtual));
		List<Escala> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<Escala> page, List<Escala> lista, ModelMap model) {	
		
		model.addAttribute("escala", coordenacaoEscalaService.buscarPorId(idCoordenacaoAtual));
		model.addAttribute("mes", anoMesService.buscarPorId(idAnoMesAtual));
		
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaEscala", lista);
		return "/escala/lista";	
	}
	
		
	@GetMapping("/alterar/escala/{id}")
	public String cadastrarEscala(@PathVariable("id") Long id, Escala escala, ModelMap model) {	
		ultimoIdEscala = id;
		escala = service.buscarPorId(id);
		
		this.escalaAtual = escala;
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		
		String recalcular = "N";
		
		String anoMesDaEscala = "202105";
		if(escala!=null){anoMesDaEscala = escala.getIdAnoMesFk().getNomeAnoMes();}
		int qtdDiasNoMes = escalaCalculosService.quantidadeDeDiasNoMes(anoMesDaEscala);
		String escalaCoordenacao = "ENFERMAGEM-VERDE A-ENFERMEIROS";
		if(escala!=null){escalaCoordenacao = escala.getIdCoordenacaoFk().getNomeCoordenacao()+"-"+escala.getIdCoordenacaoFk().getIdLocalidadeFk().getNomeLocalidade()+"-"+escala.getIdCoordenacaoFk().getIdAtividadeFk().getNomeAtividade();}
		String nomeDaPessoa = "NOME DA PESSOA";
		if(escala!=null){nomeDaPessoa = escala.getIdFuncionarioFk().getIdPessoaFk().getNome();}
		String cpfDaPessoa = "11111111111";
		if(escala!=null){cpfDaPessoa = escala.getIdFuncionarioFk().getIdPessoaFk().getCpf();}
		String matriculaDaPessoa = "00000000";
		if(escala!=null){matriculaDaPessoa = escala.getIdFuncionarioFk().getMatricula();}
		String chDaPessoa = "30";
		if(escala!=null){chDaPessoa = String.valueOf(escala.getIdFuncionarioFk().getIdCargaHorariaAtualFk().getCargaHoraria());}
		String tipoDeFolhaDaPessoa = "TIPO DE FOLHA";
		if(escala!=null){tipoDeFolhaDaPessoa = escala.getIdTipoFolhaFk().getNomeTipoFolha();}
		String cargoDaPessoa = "CARGO";
		if(escala!=null){cargoDaPessoa = escala.getIdFuncionarioFk().getIdEspecialidadeAtualFk().getIdCargoFk().getNomeCargo()+"-"+escala.getIdFuncionarioFk().getIdEspecialidadeAtualFk().getNomeEspecialidadeCargo();}
		
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
	

	@PostMapping("/salvar")
	public String salvar(Escala escala, String recalcular, String lancarTurma) {
		
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		boolean podeSalvar = true;
		
		boolean chocou = false;
		boolean naoPresencialComNoturno = false;
		
		//Avaliando Choques
		String choque = service.choquesEmEscalaOnipresenca(escala);
		this.choque = choque;
		if(choque.length()>0) {chocou = true; podeSalvar = false;}
		if(chocou==true) {
			return "redirect:/escalas/mensagem/de/choque";
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
		Escala escala = service.buscarPorId(id); 
		
		escala.setIdOperadorCancelamentoFk(pessoaOperadoresService.buscarPorId(idOperadorLogado));
		escala.setDtCancelamento(new Date());
		
		service.salvar(escala);  
		
		return "redirect:/escalas/listar";
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorNomePaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaTurma == null) ){
			return "redirect:/escalas/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return this.findPaginated(pageNo, ultimaBuscaTurma, model);}
			}
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		this.ultimaBuscaTurma = null;	
		return this.findPaginated(1, nome, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 5;
		Page<Escala> page = service.findPaginatedNome(pageNo, pageSeze, coordenacaoEscalaService.buscarPorId(idCoordenacaoAtual), anoMesService.buscarPorId(idAnoMesAtual), nome );
		List<Escala> lista = page.getContent();
		//ultimaBuscaNome = "";
		//ultimaBuscaTurma = null;
		return paginar(pageNo, page, lista, model);
	}
	
	@GetMapping("/buscar/id/turma")
	public String getPorIdUf(@RequestParam("idTurmaFk") Turmas turmas, ModelMap model) {
		this.ultimaBuscaTurma = turmas;
		this.ultimaBuscaNome = "";
		
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
		//ultimaBuscaNome = "";
		//ultimaBuscaTurma = null;
		return paginar(pageNo, page, lista, model);
	}
	

	
	@GetMapping("/atalho/limpar_escala")
	public String atalhoLimparEscala( RedirectAttributes attr) {	
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
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoDiaristasManha(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/diarista_tarde")
	public String atalhoDiaristaTarde( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoDiaristasTarde(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/diarista_dia")
	public String atalhoDiaristaDia( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoDiaristasDia(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/mt_dias_impares")
	public String atalhoMTDiasImpares( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoMTDiasImpares(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/mt_dias_pares")
	public String atalhoMTDiasPares( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoMTDiasPares(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	//Ciclo 1
	@GetMapping("/atalho/ciclo1_a")
	public String atalhoCiclo1A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_b")
	public String atalhoCiclo1B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_c")
	public String atalhoCiclo1C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_d")
	public String atalhoCiclo1D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_e")
	public String atalhoCiclo1E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo1_f")
	public String atalhoCiclo1F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo1F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	//Ciclo2
	@GetMapping("/atalho/ciclo2_a")
	public String atalhoCiclo2A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_b")
	public String atalhoCiclo2B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_c")
	public String atalhoCiclo2C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_d")
	public String atalhoCiclo2D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_e")
	public String atalhoCiclo2E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo2_f")
	public String atalhoCiclo2F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo2F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}

	//Ciclo4
	@GetMapping("/atalho/ciclo4_a")
	public String atalhoCiclo4A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_b")
	public String atalhoCiclo4B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_c")
	public String atalhoCiclo4C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_d")
	public String atalhoCiclo4D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_e")
	public String atalhoCiclo4E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo4_f")
	public String atalhoCiclo4F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo4F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}

	//Ciclo5
	@GetMapping("/atalho/ciclo5_a")
	public String atalhoCiclo5A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_b")
	public String atalhoCiclo5B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_c")
	public String atalhoCiclo5C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_d")
	public String atalhoCiclo5D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_e")
	public String atalhoCiclo5E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo5_f")
	public String atalhoCiclo5F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo5F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}

	//Ciclo6
	@GetMapping("/atalho/ciclo6_a")
	public String atalhoCiclo6A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_b")
	public String atalhoCiclo6B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_c")
	public String atalhoCiclo6C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_d")
	public String atalhoCiclo6D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_e")
	public String atalhoCiclo6E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo6_f")
	public String atalhoCiclo6F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo6F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}

	//Ciclo7
	@GetMapping("/atalho/ciclo7_a")
	public String atalhoCiclo7A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_b")
	public String atalhoCiclo7B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_c")
	public String atalhoCiclo7C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_d")
	public String atalhoCiclo7D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_e")
	public String atalhoCiclo7E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo7_f")
	public String atalhoCiclo7F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo7F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}


	//Ciclo8
	@GetMapping("/atalho/ciclo8_a")
	public String atalhoCiclo8A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo8A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo8_b")
	public String atalhoCiclo8B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo8B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo8_c")
	public String atalhoCiclo8C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo8C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo8_d")
	public String atalhoCiclo8D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo8D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo8_e")
	public String atalhoCiclo8E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo8E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo8_f")
	public String atalhoCiclo8F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo8F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo8_g")
	public String atalhoCiclo8G( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo8G(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	
	//Ciclo8
	@GetMapping("/atalho/ciclo9_a")
	public String atalhoCiclo9A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo9A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo9_b")
	public String atalhoCiclo9B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo9B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo9_c")
	public String atalhoCiclo9C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo9C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo9_d")
	public String atalhoCiclo9D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo9D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo9_e")
	public String atalhoCiclo9E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo9E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo9_f")
	public String atalhoCiclo9F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo9F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo9_g")
	public String atalhoCiclo9G( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo9G(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	
	//Ciclo10
	@GetMapping("/atalho/ciclo10_a")
	public String atalhoCiclo10A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo10A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo10_b")
	public String atalhoCiclo10B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo10B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo10_c")
	public String atalhoCiclo10C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo10C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo10_d")
	public String atalhoCiclo10D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo10D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo10_e")
	public String atalhoCiclo10E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo10E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo10_f")
	public String atalhoCiclo10F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo10F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo10_g")
	public String atalhoCiclo10G( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo10G(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	

	
	//Ciclo11
	@GetMapping("/atalho/ciclo11_a")
	public String atalhoCiclo11A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo11A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo11_b")
	public String atalhoCiclo11B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo11B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo11_c")
	public String atalhoCiclo11C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo11C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo11_d")
	public String atalhoCiclo11D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo11D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo11_e")
	public String atalhoCiclo11E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo11E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo11_f")
	public String atalhoCiclo11F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo11F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo11_g")
	public String atalhoCiclo11G( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo11G(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	

	
	//Ciclo12
	@GetMapping("/atalho/ciclo12_a")
	public String atalhoCiclo12A( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo12A(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo12_b")
	public String atalhoCiclo12B( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo12B(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo12_c")
	public String atalhoCiclo12C( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo12C(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo12_d")
	public String atalhoCiclo12D( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo12D(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo12_e")
	public String atalhoCiclo12E( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo12E(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo12_f")
	public String atalhoCiclo12F( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo12F(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	
	@GetMapping("/atalho/ciclo12_g")
	public String atalhoCiclo12G( RedirectAttributes attr) {	
		Escala escala = service.buscarPorId(ultimoIdEscala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaAtalhosService.atalhoCiclo12G(escala);
		escala = escalaCalculosService.converteTurnoNuloEmFolga(escala);
		escala = escalaCalculosService.calcularDadosEscala(escala);
		salvar(escala, null, null);
		ultimoIdEscala = escala.getId();
		attr.addFlashAttribute("fail", "Confirme CH Dif, Incremento de Risco, Diferenciado, Regime e Turma antes de Lançar.");
		return "redirect:/escalas/alterar/escala/"+escala.getId();
	}
	

	
	@GetMapping("/mensagem/de/choque")
	public String mensagemDeChoque(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "CHOQUE EM ESCALA");
		model.addAttribute("mensagem", choque);
		
		return "/choqueescala/choque";
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
	
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaDocumentos", service.buscarPorId(id));
		return "/documento/cadastro";
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
	
}

