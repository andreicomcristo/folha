package com.folha.boot.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.folha.boot.domain.RubricaCodigo;
import com.folha.boot.domain.RubricaNatureza;
import com.folha.boot.domain.RubricaTipo;
import com.folha.boot.service.RubricaCodigoService;
import com.folha.boot.service.RubricaNaturezaService;
import com.folha.boot.service.RubricaTipoService;

@Controller
@RequestMapping("/rubricaCodigo")
public class RubricaCodigoController {

	
	String ultimaBuscaNome = "";
	
	@Autowired
	private RubricaCodigoService service;
	@Autowired
	private RubricaNaturezaService rubricaNaturezaService;
	@Autowired
	private RubricaTipoService rubricaTipoService;
	

	@GetMapping("/cadastrar")
	public String cadastrar(RubricaCodigo rubricaCodigo) {		
		return "/rubricaCodigo/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(RubricaCodigo rubricaCodigo, RedirectAttributes attr) {
		// Evitando salvar quem já está cadastrado
		if(rubricaCodigo!=null) {
			if(rubricaCodigo.getId()==null) {
				if(service.avaliarCadastrado(rubricaCodigo.getCodigo())==true) {
					return "redirect:/mensagens/mensagem/de/ja/cadastrado";	
				}
			}
		}
		
		service.salvar(rubricaCodigo);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/rubricaCodigo/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("rubricaCodigo", service.buscarPorId(id));
		return "/rubricaCodigo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(RubricaCodigo rubricaCodigo, RedirectAttributes attr) {
		service.editar(rubricaCodigo);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/rubricaCodigo/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimaBuscaNome = "";
		return this.findPaginated(1, model);
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		return this.findPaginated(1, nome, model);
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorNomePaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if(pageNo<1) {pageNo=1;}
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaNome.equals("")) ){
			return "redirect:/rubricaCodigo/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/rubricaCodigo/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<RubricaCodigo> page = service.findPaginated( pageNo, pageSeze);
		List<RubricaCodigo> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<RubricaCodigo> page = service.findPaginatedNome( nome, pageNo, pageSeze);
		List<RubricaCodigo> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<RubricaCodigo> page, List<RubricaCodigo> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("rubricaCodigo", lista);
		return "/rubricaCodigo/lista";	
	}

	@ModelAttribute("idNaturezaFk")
	public List<RubricaNatureza> getIdNaturezaFk() {
		return rubricaNaturezaService.buscarTodos();
	}
	
	
	@ModelAttribute("idTipoFk")
	public List<RubricaTipo> getIdTipoFk() {
		return rubricaTipoService.buscarTodos();
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
