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
import com.folha.boot.domain.Situacoes;
import com.folha.boot.service.SituacoesService;

@Controller
@RequestMapping("/situacoes")
public class SituacoesController {

	@Autowired
	private SituacoesService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Situacoes situacoes) {		
		return "/situacao/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("situacoes", service.buscarTodos());
		return "/situacao/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Situacoes situacoes, RedirectAttributes attr) {		
		service.salvar(situacoes);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/situacoes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("situacoes", service.buscarPorId(id));
		return "/situacao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Situacoes situacoes, RedirectAttributes attr) {
		service.editar(situacoes);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/situacoes/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/situacao")
	public String getPorNome(@RequestParam("nomeSituacao") String nomeSituacao, ModelMap model) {		
		model.addAttribute("situacoes", service.buscarPorNome(nomeSituacao.toUpperCase().trim()));
		return "/situacao/lista";
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
