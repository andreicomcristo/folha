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
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.TiposLogradouro;
import com.folha.boot.domain.UnidadeGestora;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.UnidadesNaturezaJuridica;
import com.folha.boot.domain.UnidadesRegime;
import com.folha.boot.service.CidadesService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.TiposLogradouroService;
import com.folha.boot.service.UnidadeGestoraService;
import com.folha.boot.service.UnidadesNaturezaJuridicaService;
import com.folha.boot.service.UnidadesRegimeService;
import com.folha.boot.service.UnidadesService;

@Controller
@RequestMapping("/unidadeGestora")
public class UnidadeGestoraController {

	
	@Autowired
	private UnidadeGestoraService service;
	
	
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(UnidadeGestora unidadeGestora) {		
		return "/unidadeGestora/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("unidadeGestora", service.buscarTodos());
		return "/unidadeGestora/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(UnidadeGestora unidadeGestora, RedirectAttributes attr) {
		
		service.salvar(unidadeGestora);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/unidadeGestora/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("unidadeGestora", service.buscarPorId(id));
		return "/unidadeGestora/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(UnidadeGestora unidadeGestora, RedirectAttributes attr) {
		service.editar(unidadeGestora);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/unidadeGestora/listar";
	}
	
	@GetMapping("/buscar/nome/unidade")
	public String getPorNome(@RequestParam("nomeFantasia") String nomeFantasia, ModelMap model) {		
		model.addAttribute("unidadeGestora", service.buscarPorNome(nomeFantasia.toUpperCase().trim()));
		return "/unidadeGestora/lista";
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
