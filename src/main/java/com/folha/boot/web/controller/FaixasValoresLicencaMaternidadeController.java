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
import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CargaHorariaSemanal;
import com.folha.boot.domain.ClassesCarreira;
import com.folha.boot.domain.DiasLicencaMaternidade;
import com.folha.boot.domain.FaixasValoresLicencaMaternidade;
import com.folha.boot.domain.Fonte;
import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.TipoBrutoLiquido;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CargaHorariaSemanalService;
import com.folha.boot.service.ClassesCarreiraService;
import com.folha.boot.service.DiasLicencaMaternidadeService;
import com.folha.boot.service.FaixasValoresLicencaMaternidadeService;
import com.folha.boot.service.FonteService;
import com.folha.boot.service.NiveisCargoService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.TipoBrutoLiquidoService;
import com.folha.boot.service.TiposDeFolhaService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.seguranca.UsuarioService;


@Controller
@RequestMapping("/faixasValoresLicencaMaternidade")
public class FaixasValoresLicencaMaternidadeController {

	String ultimoAnoMes = "";
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private FaixasValoresLicencaMaternidadeService service;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private ClassesCarreiraService classesCarreiraService;
	@Autowired
	private CargaHorariaSemanalService cargaHorariaSemanalService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private FonteService fonteService;
	@Autowired
	private TipoBrutoLiquidoService tipoBrutoLiquidoService;
	@Autowired
	private TiposDeFolhaService tiposDeFolhaService;
	@Autowired
	private NiveisCargoService niveisCargoService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private DiasLicencaMaternidadeService diasLicencaMaternidadeService;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*Lista de funcionarios
	  Funcionarios Todos os Possíveis
	  Inicio da paginação*/
	
	
	@GetMapping("/paginar/funcionarios/{pageNo}")
	public String getPorNomePaginadoInclusao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) ){
			return "redirect:/faixasValoresLicencaMaternidade/funcionarios/listar/{pageNo}" ;}
			else {		
				if(!ultimaBuscaNome.equals("")) {
					return this.findPaginatedFuncionario(pageNo, ultimaBuscaNome, model);}
				else {
					return "redirect:/faixasValoresLicencaMaternidade/funcionarios/listar/{pageNo}" ;}
			}
		}
		
	@GetMapping("/funcionarios/listar")
	public String listarFuncionarios(ModelMap model) {
		ultimaBuscaNome = "";
		return this.findPaginatedFuncionario(1, model);
	}	
		
	@GetMapping("/funcionarios/listar/{pageNo}")
	public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginatedDeTodasAsUnidades(pageNo, pageSeze, "ATIVO");
		List<PessoaFuncionarios> listaFuncionarios = page.getContent();
		return paginarFuncionario(pageNo, page, listaFuncionarios, model);
	}
		
	public String paginarFuncionario(int pageNo, Page<PessoaFuncionarios> page, List<PessoaFuncionarios> lista, ModelMap model) {			
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaFuncionarios", lista);
		return "/faixasValoresLicencaMaternidade/listafuncionario";	
	}	
		
	@GetMapping("/buscar/funcionarios/nome")
	public String getPorNomeFuncionario(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		//this.ultimaBuscaTurma = null;	
		return this.findPaginatedFuncionario(1, nome, model);
	}
		
	public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginatedNomeDeTodasAsUnidades(pageNo, pageSeze, "ATIVO", nome);
		List<PessoaFuncionarios> lista = page.getContent();
		//ultimaBuscaNome = "";
		//ultimaBuscaTurma = null;
		return paginarFuncionario(pageNo, page, lista, model);
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimoAnoMes = "";
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<FaixasValoresLicencaMaternidade> page = service.findPaginated(pageNo, pageSeze);
		List<FaixasValoresLicencaMaternidade> listaCidades = page.getContent();
		return paginar(pageNo, page, listaCidades, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 50;
		Page<FaixasValoresLicencaMaternidade> page = service.findPaginatedNome(pageNo, pageSeze, cnes);
		List<FaixasValoresLicencaMaternidade> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<FaixasValoresLicencaMaternidade> page, List<FaixasValoresLicencaMaternidade> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("faixasValoresLicencaMaternidade", lista);
		return "/faixasValoresLicencaMaternidade/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if(pageNo<1) {pageNo = 1;}
		if( (ultimoAnoMes.equals("")) ){
			return "redirect:/faixasValoresLicencaMaternidade/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
		
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		return this.findPaginated(1, anoMes, model);
	}
	//Fim da paginação
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(FaixasValoresLicencaMaternidade faixasValoresLicencaMaternidade) {
		return "/faixasValoresLicencaMaternidade/cadastro";
	}
	
	// Dados para Atribuição
	@GetMapping("/cadastrar/{id}")
	public String cadastrar(@PathVariable("id") Long id, FaixasValoresLicencaMaternidade faixasValoresLicencaMaternidade) {
		faixasValoresLicencaMaternidade.setIdFuncionarioFk(pessoaFuncionariosService.buscarPorId(id));
		return "/faixasValoresLicencaMaternidade/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(FaixasValoresLicencaMaternidade faixasValoresLicencaMaternidade, Long dias, RedirectAttributes attr) {
		
		if(faixasValoresLicencaMaternidade.getValorBrutoPorDia()==null) {
			faixasValoresLicencaMaternidade.setValorBrutoPorDia(0.0);
		}
		
		Long dataA = faixasValoresLicencaMaternidade.getDtInicial().getTime() /1000/60/60/24;
		Long dataB = dataA + diasLicencaMaternidadeService.buscarPorId(dias).getDias() ;
		Date dataFinal = new Date(dataB*1000*60*60*24);
		
		faixasValoresLicencaMaternidade.setDtFinal(dataFinal);
		faixasValoresLicencaMaternidade.setDtCadastro(new Date());
		faixasValoresLicencaMaternidade.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		faixasValoresLicencaMaternidade.setDtUltimaMudanca(new Date());
		faixasValoresLicencaMaternidade.setIdOperadorUltimaMudancaFk(usuarioService.pegarOperadorLogado());
		
		service.salvar(faixasValoresLicencaMaternidade);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/faixasValoresLicencaMaternidade/funcionarios/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("faixasValoresLicencaMaternidade", service.buscarPorId(id));
		return "/faixasValoresLicencaMaternidade/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(FaixasValoresLicencaMaternidade faixasValoresLicencaMaternidade, Long dias, RedirectAttributes attr) {	
		
		if(faixasValoresLicencaMaternidade.getValorBrutoPorDia()==null) {
			faixasValoresLicencaMaternidade.setValorBrutoPorDia(0.0);
		}
		
		Long dataA = faixasValoresLicencaMaternidade.getDtInicial().getTime() /1000/60/60/24;
		Long dataB = dataA + diasLicencaMaternidadeService.buscarPorId(dias).getDias() ;
		Date dataFinal = new Date(dataB*1000*60*60*24);
		
		faixasValoresLicencaMaternidade.setDtFinal(dataFinal);
		faixasValoresLicencaMaternidade.setDtUltimaMudanca(new Date());
		faixasValoresLicencaMaternidade.setIdOperadorUltimaMudancaFk(usuarioService.pegarOperadorLogado());
		
		service.editar(faixasValoresLicencaMaternidade);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/faixasValoresLicencaMaternidade/listar";
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		
		FaixasValoresLicencaMaternidade faixasValoresLicencaMaternidade = service.buscarPorId(id);
		
		faixasValoresLicencaMaternidade.setDtCancelamento(new Date());
		faixasValoresLicencaMaternidade.setIdOperadorCancelamentoFk(usuarioService.buscarPorId(id));
		
		service.salvar(faixasValoresLicencaMaternidade);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}	
	
	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("cnesUnidade") String nome, ModelMap model) {		
		model.addAttribute("faixasValoresLicencaMaternidade", service.buscarPorNome(nome.toUpperCase().trim()));
		return "/faixasValoresLicencaMaternidade/lista";
	}
	
	@GetMapping("/exporta/excel")
    public void downloadExcel(HttpServletResponse response, ModelMap model) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=dados.xlsx");
        ByteArrayInputStream stream = service.exportarExcel(service.buscarTodos());
        IOUtils.copy(stream, response.getOutputStream());
    }
	
	@GetMapping(value = "/exporta/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {
		ByteArrayInputStream bis = service.exportarPdf(service.buscarTodos());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=dados.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	@ModelAttribute("idFuncionarioFk")
	public List<PessoaFuncionarios> getIdFuncionarioFk() {
		return pessoaFuncionariosService.buscarPorUnidade(usuarioService.pegarUnidadeLogada(), "ATIVO");
	}	
	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getIdAnoMesFk() {
		return anoMesService.buscarTodos();	
	}
	@ModelAttribute("idNivelCargoFk")
	public List<NiveisCargo> getIdNivelCarreiraFk() {
		return niveisCargoService.buscarTodos();	
	}
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getIdUnidadeRegimeFk() {
		return unidadesService.buscarTodos();	
	}
	@ModelAttribute("idTipoDeFolhaFk")
	public List<TiposDeFolha> getIdTipoDeFolhaFk() {
		return tiposDeFolhaService.buscarTodos();	
	}
	
	
	
	@ModelAttribute("idClasseCarreiraFk")
	public List<ClassesCarreira> getIdClasseCarreiraFk() {
		return classesCarreiraService.buscarTodos();	
	}
	@ModelAttribute("idCargaHorariaSemanalFk")
	public List<CargaHorariaSemanal> getIdCargaHorariaSemanalFk() {
		return cargaHorariaSemanalService.buscarTodos();	
	}
	@ModelAttribute("idFonteFk")
	public List<Fonte> getIdFonteFk() {
		return fonteService.buscarTodos();
	}
	@ModelAttribute("diasFk")
	public List<DiasLicencaMaternidade> getDias() {
		return diasLicencaMaternidadeService.buscarTodos();
	}
	@ModelAttribute("idTipoBrutoLiquidoFk")
	public List<TipoBrutoLiquido> getIdTipoBrutoLiquidoFk() {
		return tipoBrutoLiquidoService.buscarTodos();
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

