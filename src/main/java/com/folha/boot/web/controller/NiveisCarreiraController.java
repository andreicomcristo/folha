package com.folha.boot.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.NiveisCarreira;
import com.folha.boot.service.NiveisCarreiraService;

@Controller
@RequestMapping("/niveis/carreira")
public class NiveisCarreiraController {

	@Autowired
	private NiveisCarreiraService service;

	@GetMapping("/cadastrar")
	public String cadastrar(NiveisCarreira niveisCarreira) {
		return "nivelcarreira/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("niveisCarreira", service.buscarTodos());
		return "nivelcarreira/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(NiveisCarreira niveisCarreira, RedirectAttributes attr) {
		service.salvar(niveisCarreira);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/niveis/carreira/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("niveisCarreira", service.buscarPorId(id));
		return "nivelcarreira/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(NiveisCarreira niveisCarreira, RedirectAttributes attr) {
		service.editar(niveisCarreira);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/niveis/carreira/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/nivel")
	public String getPorNome(@RequestParam("nomeNivelCarreira") String nomeNivelCarreira, ModelMap model) {		
		model.addAttribute("niveisCarreira", service.buscarPorNome(nomeNivelCarreira.toUpperCase().trim()));
		return "nivelcarreira/lista";
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
