package com.folha.boot.web.controller;


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
import com.folha.boot.domain.RubricaPensaoIncidencia;
import com.folha.boot.service.RubricaPensaoIncidenciaService;

@Controller
@RequestMapping("/rubricaPensaoIncidencia")
public class RubricaPensaoIncidenciaController {

	
	String ultimaBuscaNome = "";
	
	@Autowired
	private RubricaPensaoIncidenciaService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(RubricaPensaoIncidencia rubricaPensaoIncidencia) {		
		return "/rubricaPensaoIncidencia/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(RubricaPensaoIncidencia rubricaPensaoIncidencia, RedirectAttributes attr) {
		service.salvar(rubricaPensaoIncidencia);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/rubricaPensaoIncidencia/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("rubricaPensaoIncidencia", service.buscarPorId(id));
		return "/rubricaPensaoIncidencia/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(RubricaPensaoIncidencia rubricaPensaoIncidencia, RedirectAttributes attr) {
		service.editar(rubricaPensaoIncidencia);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/rubricaPensaoIncidencia/listar";
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
			return "redirect:/rubricaPensaoIncidencia/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/rubricaPensaoIncidencia/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<RubricaPensaoIncidencia> page = service.findPaginated( pageNo, pageSeze);
		List<RubricaPensaoIncidencia> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<RubricaPensaoIncidencia> page = service.findPaginatedNome( nome, pageNo, pageSeze);
		List<RubricaPensaoIncidencia> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<RubricaPensaoIncidencia> page, List<RubricaPensaoIncidencia> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("rubricaPensaoIncidencia", lista);
		return "/rubricaPensaoIncidencia/lista";	
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
