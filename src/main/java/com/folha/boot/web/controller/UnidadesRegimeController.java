package com.folha.boot.web.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.UnidadesRegime;
import com.folha.boot.service.UnidadesRegimeService;

@Controller
@RequestMapping("/regimes")
public class UnidadesRegimeController {

	
	String ultimaBuscaNome = "";
	
	@Autowired
	private UnidadesRegimeService service;

	@GetMapping("/cadastrar")
	public String cadastrar(UnidadesRegime unidadesRegime) {		
		return "/unidaderegime/cadastro";
	}
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("unidadesRegime", service.buscarTodos());
		return "/unidaderegime/lista"; 
	}
	*/
	@PostMapping("/salvar")
	public String salvar(UnidadesRegime unidadesRegime, RedirectAttributes attr) {
		
		service.salvar(unidadesRegime);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/regimes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("unidadesRegime", service.buscarPorId(id));
		return "/unidaderegime/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(UnidadesRegime unidadesRegime, RedirectAttributes attr) {
		service.editar(unidadesRegime);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/regimes/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	//Paginacao
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
			return "redirect:/regimes/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/regimes/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<UnidadesRegime> page = service.findPaginated( pageNo, pageSeze);
		List<UnidadesRegime> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<UnidadesRegime> page = service.findPaginatedNome(  nome, pageNo, pageSeze);
		List<UnidadesRegime> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<UnidadesRegime> page, List<UnidadesRegime> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("regime", lista);
		return "/unidaderegime/lista";	
	}

	
	
	
	
	
}
