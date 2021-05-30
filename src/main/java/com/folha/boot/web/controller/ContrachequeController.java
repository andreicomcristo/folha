package com.folha.boot.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.folha.boot.domain.PessoaCodDiferenciado;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.RubricaVencimento;
import com.folha.boot.domain.RubricaVencimentoObs;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.TiposDeDocumento;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Turmas;
import com.folha.boot.domain.Turnos;
import com.folha.boot.domain.Uf;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.models.calculos.MesDoCalculo;
import com.folha.boot.domain.models.escala.EscolhaAcessoEscala;
import com.folha.boot.domain.models.escala.InclusaoEscala;
import com.folha.boot.service.AcessoOperadoresCoordenacaoService;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CargosEspecialidadeService;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.ContrachequeService;
import com.folha.boot.service.CoordenacaoEscalaService;
import com.folha.boot.service.EscalaAlteracoesService;
import com.folha.boot.service.EscalaAtalhosService;
import com.folha.boot.service.EscalaCalculosService;
import com.folha.boot.service.EscalaExportacaoService;
import com.folha.boot.service.EscalaPosTransparenciaService;
import com.folha.boot.service.EscalaService;
import com.folha.boot.service.PessoaCodDiferenciadoService;
import com.folha.boot.service.PessoaDocumentosService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.RegimesDeTrabalhoService;
import com.folha.boot.service.RubricaVencimentoObsService;
import com.folha.boot.service.RubricaVencimentoService;
import com.folha.boot.service.SimNaoService;
import com.folha.boot.service.TiposDeDocumentoService;
import com.folha.boot.service.TiposDeFolhaService;
import com.folha.boot.service.TurmasService;
import com.folha.boot.service.TurnosService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.calculos.escala.CalculosCalcularService;
import com.folha.boot.service.seguranca.UsuarioService;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Controller
@RequestMapping("/contracheque")
public class ContrachequeController {

	
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	AcessoOperadoresCoordenacaoService acessoOperadoresCoordenacaoService;
	@Autowired
	CargosEspecialidadeService cargosEspecialidadeService;
	@Autowired
	ContrachequeService contrachequeService;
	@Autowired
	EscalaPosTransparenciaService escalaPosTransparenciaService;
	@Autowired
	EscalaAlteracoesService escalaAlteracoesService;
	@Autowired
	PessoaCodDiferenciadoService pessoaCodDiferenciadoService;
	@Autowired
	CalculosCalcularService calculosCalcularService;
	@Autowired
	RubricaVencimentoObsService rubricaVencimentoObsService;
	@Autowired
	RubricaVencimentoService rubricaVencimentoService;
	
	@Autowired
	PessoaService service;
	
	AnoMes anoMesEscolhido;
	Pessoa pessoaEscolhida = null;
	
	String ultimaBuscaNome = "";
	String ultimaBuscaCpf = "";
	
	
	// Global - Sede
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimaBuscaNome = "";
		this.ultimaBuscaCpf = "";
		return this.findPaginated(1, model);
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<Pessoa> page = service.findPaginated(pageNo, pageSeze);
		List<Pessoa> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginatedNome(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<Pessoa> page = service.findPaginatedNome(pageNo, pageSeze, nome);
		List<Pessoa> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginatedCpf(@PathVariable (value = "pageNo") int pageNo, String cpf, ModelMap model) {
		int pageSeze = 10;
		Page<Pessoa> page = service.findPaginatedCpf(pageNo, pageSeze, cpf);
		List<Pessoa> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	@GetMapping("/buscar/nome/paginado")
	public String getPorNomePaginado(@RequestParam("nome") String nome, ModelMap model) {
		nome=nome.toUpperCase().trim();
		this.ultimaBuscaNome = nome;
		this.ultimaBuscaCpf = "";	
		return this.findPaginatedNome(1, nome, model);
	}
	
	@GetMapping("/buscar/cpf/paginado")
	public String getPorCpfPaginado(@RequestParam("cpf") String cpf, ModelMap model) {
		cpf=cpf.toUpperCase().trim();
		cpf = UtilidadesDeTexto.limpaPontosETracosCpf(cpf);
		this.ultimaBuscaNome = "";
		this.ultimaBuscaCpf = cpf;	
		return this.findPaginatedCpf(1, cpf, model);
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorBusacaPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaCpf.equals("")) ){
			return "redirect:/contracheque/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedNome(pageNo, ultimaBuscaNome, model);}
			else {
				return this.findPaginatedCpf(pageNo, ultimaBuscaCpf, model);}
			}
	}
	
	
	
	public String paginar(int pageNo, Page<Pessoa> page, List<Pessoa> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("pessoa", lista);
		return "/contracheque/lista";	
	}
	
	
	
	
	
	
	
	//Métodos para contracheque
	@GetMapping("/escolher/mes")
	public String escolherMes(ModelMap model) {
		this.pessoaEscolhida = null;
		model.addAttribute("mesDoCalculo", new MesDoCalculo());
		model.addAttribute("anoMes", anoMesService.buscarTodos());
		return "/contracheque/escolherMes"; 
	}
	
	
	@GetMapping("/escolherMesFolha/{id}")
	public String escolherMes(@PathVariable("id") Long id, ModelMap model) {
		this.pessoaEscolhida = service.buscarPorId(id);
		model.addAttribute("mesDoCalculo", new MesDoCalculo());
		model.addAttribute("anoMes", anoMesService.buscarTodos());
		return "/contracheque/escolherMesFolha"; 
	}
	
	
	
	
	@PostMapping("/calcular")
	public String irParaEscala(ModelMap model, MesDoCalculo mesDoCalculo) {
		anoMesEscolhido = mesDoCalculo.getAnoMes();
		
		return "redirect:/contracheque/exporta/pdf/contracheque/colaborador"; 
	}
	
	
	@PostMapping("/calcular/folha")
	public String irParaEscalaFolha(ModelMap model, MesDoCalculo mesDoCalculo) {
		anoMesEscolhido = mesDoCalculo.getAnoMes();
		
		return "redirect:/contracheque/exporta/pdf/contracheque/colaborador/folha"; 
	}
	
	
	
	// Exportacao Contracheque Colaborador
	@GetMapping(value = "/exporta/pdf/contracheque/colaborador", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReportsEscalaColaborador( HttpServletResponse response) throws IOException {
		AnoMes anoMes = anoMesService.buscarPorId(this.anoMesEscolhido.getId()) ;
		Pessoa pessoa = usuarioService.pegarOperadorLogado().getIdPessoaFk();
		
		ByteArrayInputStream bis = contrachequeService.exportarPdfContracheque(anoMes, pessoa);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=dados.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	

	// Exportacao Contracheque Colaborador
	@GetMapping(value = "/exporta/pdf/contracheque/colaborador/folha", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReportsEscalaColaboradorFolha( HttpServletResponse response) throws IOException {
		AnoMes anoMes = anoMesService.buscarPorId(this.anoMesEscolhido.getId()) ;
		Pessoa pessoa = service.buscarPorId(this.pessoaEscolhida.getId()) ;
		
		ByteArrayInputStream bis = contrachequeService.exportarPdfContracheque(anoMes, pessoa);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=dados.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	
	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getIdAnoMesFk() {
		return anoMesService.buscarTodos();
	}
	
	
	
	@Autowired
	HttpServletRequest request;
	@ModelAttribute("nomeOperadorLogado")
	public String operadorLogado() {
		return request.getSession().getAttribute("operador").toString();
	}
	@ModelAttribute("nomeUnidadeLogada")
	public String unidadeLogada() {
		return request.getSession().getAttribute("unidade").toString();
	}
	
	
}

