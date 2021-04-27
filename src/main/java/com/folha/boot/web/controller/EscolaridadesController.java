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

import com.folha.boot.domain.Escolaridades;
import com.folha.boot.service.EscolaridadesService;

@Controller
@RequestMapping("/escolaridades")
public class EscolaridadesController {

	@Autowired
	private EscolaridadesService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Escolaridades escolaridade) {
		
		return "/escolaridade/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("escolaridades", service.buscarTodos());
		return "/escolaridade/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Escolaridades escolaridade, RedirectAttributes attr) {	
		service.salvar(escolaridade);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/escolaridades/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("escolaridades", service.buscarPorId(id));
		return "/escolaridade/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Escolaridades escolaridade, RedirectAttributes attr) {
		service.editar(escolaridade);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/escolaridades/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/escolaridade")
	public String getPorNome(@RequestParam("nomeEscolaridade") String nomeEscolaridade, ModelMap model) {		
		model.addAttribute("escolaridades", service.buscarPorNome(nomeEscolaridade.toUpperCase().trim()));
		return "/escolaridade/lista";
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
