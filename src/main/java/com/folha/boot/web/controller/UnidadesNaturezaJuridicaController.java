package com.folha.boot.web.controller;

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

import com.folha.boot.domain.UnidadesNaturezaJuridica;
import com.folha.boot.service.UnidadesNaturezaJuridicaService;

@Controller
@RequestMapping("/naturezas")
public class UnidadesNaturezaJuridicaController {

	
	String ultimaBuscaNome = "";
	
	@Autowired
	private UnidadesNaturezaJuridicaService service;

	@GetMapping("/cadastrar")
	public String cadastrar(UnidadesNaturezaJuridica unidadesNaturezaJuridica) {		
		return "naturezajuridica/cadastro";
	}
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("unidadesNaturezaJuridica", service.buscarTodos());
		return "naturezajuridica/lista"; 
	}
	*/
	@PostMapping("/salvar")
	public String salvar(UnidadesNaturezaJuridica unidadesNaturezaJuridica, RedirectAttributes attr) {
		
		service.salvar(unidadesNaturezaJuridica);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/naturezas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("unidadesNaturezaJuridica", service.buscarPorId(id));
		return "naturezajuridica/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(UnidadesNaturezaJuridica unidadesNaturezaJuridica, RedirectAttributes attr) {
		service.editar(unidadesNaturezaJuridica);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/naturezas/listar";
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
			return "redirect:/naturezas/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/naturezas/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<UnidadesNaturezaJuridica> page = service.findPaginated( pageNo, pageSeze);
		List<UnidadesNaturezaJuridica> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<UnidadesNaturezaJuridica> page = service.findPaginatedNome( nome, pageNo, pageSeze);
		List<UnidadesNaturezaJuridica> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<UnidadesNaturezaJuridica> page, List<UnidadesNaturezaJuridica> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("unidadesNaturezaJuridica", lista);
		return "naturezajuridica/lista";	
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
