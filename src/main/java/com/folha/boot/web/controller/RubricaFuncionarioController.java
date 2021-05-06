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
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RubricaCodigo;
import com.folha.boot.domain.RubricaFuncionario;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.RubricaCodigoService;
import com.folha.boot.service.RubricaFuncionarioService;


@Controller
@RequestMapping("/rubricaFuncionario")
public class RubricaFuncionarioController {

	String ultimoAnoMes = "";
	String ultimaBuscaNome = "";
	
	@Autowired
	private RubricaFuncionarioService service;
	@Autowired
	private RubricaCodigoService rubricaCodigoService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	
	
	//Funcionarios Todos os Possíveis
	@GetMapping("/paginar/funcionarios/{pageNo}")
	public String getPorNomePaginadoInclusao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) ){
			return "redirect:/rubricaFuncionario/funcionarios/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedFuncionario(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/rubricaFuncionario/funcionarios/listar/{pageNo}" ;}
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
		return "/rubricaFuncionario/listafuncionario";	
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
	public String cadastrar(@PathVariable("id") Long id, RubricaFuncionario rubricaFuncionario) {
		rubricaFuncionario.setIdFuncionarioFk(pessoaFuncionariosService.buscarPorId(id));
		return "/rubricaFuncionario/cadastro";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(RubricaFuncionario rubricaFuncionario) {
		
		return "/rubricaFuncionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimoAnoMes = "";
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 30;
		Page<RubricaFuncionario> page = service.findPaginated(pageNo, pageSeze);
		List<RubricaFuncionario> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 30;
		Page<RubricaFuncionario> page = service.findPaginatedAnoMes(pageNo, pageSeze, cnes);
		List<RubricaFuncionario> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<RubricaFuncionario> page, List<RubricaFuncionario> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("rubricaFuncionario", lista);
		return "/rubricaFuncionario/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if(pageNo<1) {pageNo = 1;}
		if( (ultimoAnoMes.equals("")) ){
			return "redirect:/rubricaFuncionario/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
	
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		return this.findPaginated(1, anoMes, model);
	}
	
	@PostMapping("/salvar")
	public String salvar(RubricaFuncionario rubricaFuncionario, RedirectAttributes attr) {
		// Evitando salvar quem já está cadastrado
		if(rubricaFuncionario!=null) {
			if(rubricaFuncionario.getId()==null) {
				if(service.avaliarCadastrado(rubricaFuncionario.getIdCodigoFk(), rubricaFuncionario.getIdAnoMesFk(), rubricaFuncionario.getIdFuncionarioFk() )==true) {
					return "redirect:/mensagens/mensagem/de/ja/cadastrado";	
				}
			}
		}			
		
		service.salvar(rubricaFuncionario);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/rubricaFuncionario/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("rubricaFuncionario", service.buscarPorId(id));
		return "/rubricaFuncionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(RubricaFuncionario rubricaFuncionario, RedirectAttributes attr) {	
		
		
		service.editar(rubricaFuncionario);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/rubricaFuncionario/listar";
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
		return "redirect:/rubricaFuncionario/listar" ;
	}
	
	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("cnesUnidade") String nome, ModelMap model) {		
		model.addAttribute("rubricaFuncionario", service.buscarPorNome(nome.toUpperCase().trim()));
		return "/rubricaFuncionario/lista";
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
	public List<RubricaCodigo> getIdCodigoFk() {
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

