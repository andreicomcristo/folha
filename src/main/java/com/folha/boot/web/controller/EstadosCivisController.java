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

import com.folha.boot.domain.EstadosCivis;
import com.folha.boot.service.EstadosCivisService;

@Controller
@RequestMapping("/estadoscivis")
public class EstadosCivisController {

	@Autowired
	private EstadosCivisService service;

	@GetMapping("/cadastrar")
	public String cadastrar(EstadosCivis estadoCivil) {
		
		return "estadocivil/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("estadosCivis", service.buscarTodos());
		return "estadocivil/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(EstadosCivis estadoCivil, RedirectAttributes attr) {
		service.salvar(estadoCivil);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/estadoscivis/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("estadosCivis", service.buscarPorId(id));
		return "estadocivil/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(EstadosCivis estadoCivil, RedirectAttributes attr) {	
		service.editar(estadoCivil);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/estadoscivis/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/estadocivil")
	public String getPorNome(@RequestParam("nomeEstadoCivil") String nomeEstadoCivil, ModelMap model) {		
		model.addAttribute("estadosCivis", service.buscarPorNome(nomeEstadoCivil.toUpperCase().trim()));
		return "estadocivil/lista";
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
