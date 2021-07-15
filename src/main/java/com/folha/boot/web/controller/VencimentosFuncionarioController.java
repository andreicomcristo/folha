package com.folha.boot.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import com.folha.boot.domain.VencimentosFuncionario;
import com.folha.boot.domain.models.outros.VencimentosFuncionarioComValores;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.RubricaCodigoService;
import com.folha.boot.service.RubricaService;
import com.folha.boot.service.VencimentosFuncionarioService;


@Controller
@RequestMapping("/vencimentosFuncionario")
public class VencimentosFuncionarioController {

	String ultimoAnoMes = "";
	String ultimaBuscaNome = "";
	
	@Autowired
	private VencimentosFuncionarioService service;
	@Autowired
	private RubricaCodigoService rubricaCodigoService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private RubricaService rubricaService;
	
	
	//Funcionarios Todos os Possíveis
	@GetMapping("/paginar/funcionarios/{pageNo}")
	public String getPorNomePaginadoInclusao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) ){
			return "redirect:/vencimentosFuncionario/funcionarios/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedFuncionario(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/vencimentosFuncionario/funcionarios/listar/{pageNo}" ;}
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
		return "vencimentosFuncionario/listafuncionario";	
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

	
	
	
	// Dados para Atribuição
	@GetMapping("/cadastrar/{id}")
	public String cadastrar(@PathVariable("id") Long id, VencimentosFuncionario vencimentosFuncionario) {
		vencimentosFuncionario.setIdFuncionarioFk(pessoaFuncionariosService.buscarPorId(id));
		return "vencimentosFuncionario/cadastro";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(VencimentosFuncionario vencimentosFuncionario) {
		
		return "vencimentosFuncionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimoAnoMes = "";
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<VencimentosFuncionario> page = service.findPaginated(pageNo, pageSeze);
		List<VencimentosFuncionario> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 50;
		Page<VencimentosFuncionario> page = service.findPaginatedAnoMes(pageNo, pageSeze, cnes);
		List<VencimentosFuncionario> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<VencimentosFuncionario> page, List<VencimentosFuncionario> lista, ModelMap model) {	
		
		List<VencimentosFuncionarioComValores> lista1 = new ArrayList<>();
		
		for(int i=0;i<lista.size();i++) {
			VencimentosFuncionarioComValores v = new VencimentosFuncionarioComValores();
			v.setId(lista.get(i).getId());
			v.setIdAnoMesFk(lista.get(i).getIdAnoMesFk());
			v.setIdCodigoFk(lista.get(i).getIdCodigoFk());
			v.setIdFuncionarioFk(lista.get(i).getIdFuncionarioFk());
			
			Double valor = 0.0;
        	Double percentagem = 0.0;
        	int quantidade = 0;
        	if(! rubricaService.buscarPorMesECodigo(lista.get(i).getIdAnoMesFk(), lista.get(i).getIdCodigoFk()).isEmpty() ) {
        	valor= rubricaService.buscarPorMesECodigo(lista.get(i).getIdAnoMesFk(), lista.get(i).getIdCodigoFk()).get(0).getValor();
        	percentagem= rubricaService.buscarPorMesECodigo(lista.get(i).getIdAnoMesFk(), lista.get(i).getIdCodigoFk()).get(0).getPercentagem();
        	quantidade= rubricaService.buscarPorMesECodigo(lista.get(i).getIdAnoMesFk(), lista.get(i).getIdCodigoFk()).get(0).getQuantidade();
        	}
        	v.setValor(valor);
        	v.setPercentagem(percentagem);
        	v.setQuantidade(quantidade);
		lista1.add(v);
		}
		
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("vencimentosFuncionario", lista1);
		return "vencimentosFuncionario/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if(pageNo<1) {pageNo = 1;}
		if( (ultimoAnoMes.equals("")) ){
			return "redirect:/vencimentosFuncionario/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
	
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		return this.findPaginated(1, anoMes, model);
	}
	
	@PostMapping("/salvar")
	public String salvar(VencimentosFuncionario vencimentosFuncionario, RedirectAttributes attr) {
		// Evitando salvar quem já está cadastrado
		if(vencimentosFuncionario!=null) {
			if(vencimentosFuncionario.getId()==null) {
				if(service.avaliarCadastrado(vencimentosFuncionario.getIdCodigoFk(), vencimentosFuncionario.getIdAnoMesFk(), vencimentosFuncionario.getIdFuncionarioFk() )==true) {
					return "redirect:/mensagens/mensagem/de/ja/cadastrado";	
				}
			}
		}			
		
		service.salvar(vencimentosFuncionario);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/vencimentosFuncionario/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("vencimentosFuncionario", service.buscarPorId(id));
		return "vencimentosFuncionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(VencimentosFuncionario vencimentosFuncionario, RedirectAttributes attr) {	
		
		
		service.editar(vencimentosFuncionario);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/vencimentosFuncionario/listar";
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
		return "redirect:/vencimentosFuncionario/listar" ;
	}
	
	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("cnesUnidade") String nome, ModelMap model) {		
		model.addAttribute("vencimentosFuncionario", service.buscarPorNome(nome.toUpperCase().trim()));
		return "vencimentosFuncionario/lista";
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

