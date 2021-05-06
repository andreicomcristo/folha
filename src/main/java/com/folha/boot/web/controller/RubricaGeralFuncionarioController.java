package com.folha.boot.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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
import com.folha.boot.domain.Carreiras;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.ClassesCarreira;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.FaixasPrevidencia;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.FaixasValoresSubsidio;
import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.domain.NiveisCarreira;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.RubricaComplementoConstitucionalCodigo;
import com.folha.boot.domain.RubricaComplementoConstitucionalFuncionario;
import com.folha.boot.domain.RubricaGeralSomaCodigo;
import com.folha.boot.domain.RubricaGeralSomaFuncionario;
import com.folha.boot.domain.RubricaInsalubridade;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.RubricaInsalubridadeFuncionario;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.UnidadesRegime;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CargaHorariaSemanalService;
import com.folha.boot.service.CarreirasService;
import com.folha.boot.service.ClassesCarreiraService;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.FaixasValoresParametrosCalculoFolhasExtrasService;
import com.folha.boot.service.FaixasValoresSubsidioService;
import com.folha.boot.service.NiveisCargoService;
import com.folha.boot.service.NiveisCarreiraService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.RegimesDeTrabalhoService;
import com.folha.boot.service.RubricaComplementoConstitucionalCodigoService;
import com.folha.boot.service.RubricaComplementoConstitucionalFuncionarioService;
import com.folha.boot.service.RubricaGeralSomaCodigoService;
import com.folha.boot.service.RubricaGeralSomaFuncionarioService;
import com.folha.boot.service.RubricaInsalubridadeCodigoService;
import com.folha.boot.service.RubricaInsalubridadeFuncionarioService;
import com.folha.boot.service.RubricaInsalubridadeService;
import com.folha.boot.service.TiposDeFolhaService;
import com.folha.boot.service.UnidadesRegimeService;
import com.folha.boot.service.UnidadesService;


@Controller
@RequestMapping("/rubricaGeralSomaFuncionario")
public class RubricaGeralSomaFuncionarioController {

	String ultimoAnoMes = "";
	String ultimaBuscaNome = "";
	
	@Autowired
	private RubricaGeralSomaFuncionarioService service;
	@Autowired
	private RubricaGeralSomaCodigoService rubricaCodigoService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	
	
	//Funcionarios Todos os Possíveis
	@GetMapping("/paginar/funcionarios/{pageNo}")
	public String getPorNomePaginadoInclusao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) ){
			return "redirect:/rubricaGeralSomaFuncionario/funcionarios/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedFuncionario(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/rubricaGeralSomaFuncionario/funcionarios/listar/{pageNo}" ;}
			}
	}
	
	@GetMapping("/funcionarios/listar")
	public String listarFuncionarios(ModelMap model) {
		ultimaBuscaNome = "";
		return this.findPaginatedFuncionario(1, model);
	}	
	
	@GetMapping("/funcionarios/listar/{pageNo}")
	public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 30;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginatedDeTodasAsUnidades(pageNo, pageSeze, "ATIVO");
		List<PessoaFuncionarios> listaFuncionarios = page.getContent();
		return paginarFuncionario(pageNo, page, listaFuncionarios, model);
	}
	
	public String paginarFuncionario(int pageNo, Page<PessoaFuncionarios> page, List<PessoaFuncionarios> lista, ModelMap model) {	

		
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaFuncionarios", lista);
		return "/rubricaGeralSomaFuncionario/listafuncionario";	
	}	
	
	@GetMapping("/buscar/funcionarios/nome")
	public String getPorNomeFuncionario(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		//this.ultimaBuscaTurma = null;	
		return this.findPaginatedFuncionario(1, nome, model);
	}
	
	public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 30;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginatedNomeDeTodasAsUnidades(pageNo, pageSeze, "ATIVO", nome);
		List<PessoaFuncionarios> lista = page.getContent();
		//ultimaBuscaNome = "";
		//ultimaBuscaTurma = null;
		return paginarFuncionario(pageNo, page, lista, model);
	}

	
	
	
	// Dados para Atribuição
	@GetMapping("/cadastrar/{id}")
	public String cadastrar(@PathVariable("id") Long id, RubricaGeralSomaFuncionario rubricaGeralSomaFuncionario) {
		rubricaGeralSomaFuncionario.setIdFuncionarioFk(pessoaFuncionariosService.buscarPorId(id));
		return "/rubricaGeralSomaFuncionario/cadastro";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(RubricaGeralSomaFuncionario rubricaGeralSomaFuncionario) {
		
		return "/rubricaGeralSomaFuncionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimoAnoMes = "";
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 30;
		Page<RubricaGeralSomaFuncionario> page = service.findPaginated(pageNo, pageSeze);
		List<RubricaGeralSomaFuncionario> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 30;
		Page<RubricaGeralSomaFuncionario> page = service.findPaginatedAnoMes(pageNo, pageSeze, cnes);
		List<RubricaGeralSomaFuncionario> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<RubricaGeralSomaFuncionario> page, List<RubricaGeralSomaFuncionario> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("rubricaGeralSomaFuncionario", lista);
		return "/rubricaGeralSomaFuncionario/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if(pageNo<1) {pageNo = 1;}
		if( (ultimoAnoMes.equals("")) ){
			return "redirect:/rubricaGeralSomaFuncionario/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
	
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		return this.findPaginated(1, anoMes, model);
	}
	
	@PostMapping("/salvar")
	public String salvar(RubricaGeralSomaFuncionario rubricaGeralSomaFuncionario, RedirectAttributes attr) {
		// Evitando salvar quem já está cadastrado
		if(rubricaGeralSomaFuncionario!=null) {
			if(rubricaGeralSomaFuncionario.getId()==null) {
				if(service.avaliarCadastrado(rubricaGeralSomaFuncionario.getIdCodigoFk(), rubricaGeralSomaFuncionario.getIdAnoMesFk(), rubricaGeralSomaFuncionario.getIdFuncionarioFk() )==true) {
					return "redirect:/mensagens/mensagem/de/ja/cadastrado";	
				}
			}
		}			
		
		service.salvar(rubricaGeralSomaFuncionario);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/rubricaGeralSomaFuncionario/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("rubricaGeralSomaFuncionario", service.buscarPorId(id));
		return "/rubricaGeralSomaFuncionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(RubricaGeralSomaFuncionario rubricaGeralSomaFuncionario, RedirectAttributes attr) {	
		
		
		service.editar(rubricaGeralSomaFuncionario);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/rubricaGeralSomaFuncionario/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	
	@GetMapping("/herdar/de/mes") 
	public String herdarDeMes( Long anoMesInicial,  Long anoMesFinal,  ModelMap model) {		
		service.herdarDeUmMesParaOOutro(anoMesInicial, anoMesFinal);
		return "redirect:/rubricaGeralSomaFuncionario/listar" ;
	}
	
	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("cnesUnidade") String nome, ModelMap model) {		
		model.addAttribute("rubricaGeralSomaFuncionario", service.buscarPorNome(nome.toUpperCase().trim()));
		return "/rubricaGeralSomaFuncionario/lista";
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
	
	
		
	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getIdAnoMesFk() {
		return anoMesService.buscarTodos();	
	}
	@ModelAttribute("idCodigoFk")
	public List<RubricaGeralSomaCodigo> getIdCodigoFk() {
		return rubricaCodigoService.buscarTodos();	
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

