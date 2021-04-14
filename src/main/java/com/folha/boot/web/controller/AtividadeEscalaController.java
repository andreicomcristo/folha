package com.folha.boot.web.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.folha.boot.domain.LocalidadeEscala;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AtividadeEscalaService;
import com.folha.boot.service.UnidadesService;

@Controller
@RequestMapping("/atividadesescalas")
public class AtividadeEscalaController {

	Long idUnidadeLogada = 1l;
	Long idOperadorLogado = 1l;
	
	String ultimaBuscaNome = "";
	
	@Autowired
	private AtividadeEscalaService service;
	@Autowired
	private UnidadesService unidadesService;

	@GetMapping("/cadastrar")
	public String cadastrar(AtividadeEscala atividadeEscala) {		
		return "/atividadeescala/cadastro";
	}
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("atividadeEscala", service.buscarNaUnidade(unidadesService.buscarPorId(idUnidadeLogada)));
		return "/atividadeescala/lista"; 
	}
	*/
	@PostMapping("/salvar")
	public String salvar(AtividadeEscala atividadeEscala, RedirectAttributes attr) {
		service.salvar(atividadeEscala);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/atividadesescalas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("atividadeEscala", service.buscarPorId(id));
		return "/atividadeescala/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(AtividadeEscala atividadeEscala, RedirectAttributes attr) {
		service.editar(atividadeEscala);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/atividadesescalas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		AtividadeEscala atividadeEscala = service.buscarPorId(id);
		atividadeEscala.setDtCancelamento(new Date());
		service.salvar(atividadeEscala); 
		model.addAttribute("success", "Cancelado com sucesso.");
		return "redirect:/atividadesescalas/listar";
	}
	/*
	@GetMapping("/buscar/nome/atividade/escala")
	public String getPorNome(@RequestParam("nomeAtividade") String nomeAtividade, ModelMap model) {		
		model.addAttribute("atividadeEscala", service.buscarNaUnidadePorNome( unidadesService.buscarPorId(idUnidadeLogada) ,nomeAtividade.toUpperCase().trim()));
		return "/atividadeescala/lista";
	}
	*/
	
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
			return "redirect:/atividadesescalas/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/atividadesescalas/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<AtividadeEscala> page = service.findPaginated( unidadesService.buscarPorId(idUnidadeLogada),pageNo, pageSeze);
		List<AtividadeEscala> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<AtividadeEscala> page = service.findPaginatedNome( unidadesService.buscarPorId(idUnidadeLogada), nome, pageNo, pageSeze);
		List<AtividadeEscala> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<AtividadeEscala> page, List<AtividadeEscala> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("atividadeEscala", lista);
		return "/atividadeescala/lista";	
	}

	
	
	
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getUfs() {
		List<Unidades> lista = new ArrayList<Unidades>();
		lista.add(unidadesService.buscarPorId(idUnidadeLogada));
		return lista;
	}	
}
