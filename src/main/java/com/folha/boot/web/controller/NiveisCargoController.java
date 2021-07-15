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

import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.service.NiveisCargoService;

@Controller
@RequestMapping("/niveis")
public class NiveisCargoController {

	@Autowired
	private NiveisCargoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(NiveisCargo nivel) {		
		return "nivel/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("niveisCargo", service.buscarTodos());
		return "nivel/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(NiveisCargo nivel, RedirectAttributes attr) {
		service.salvar(nivel);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/niveis/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("niveisCargo", service.buscarPorId(id));
		return "nivel/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(NiveisCargo nivel, RedirectAttributes attr) {		
		service.editar(nivel);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/niveis/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/nivel/cargo")
	public String getPorNome(@RequestParam("nomeNivelCargo") String nomeNivelCargo, ModelMap model) {		
		model.addAttribute("niveisCargo", service.buscarPorNome(nomeNivelCargo.toUpperCase().trim()));
		return "nivel/lista";
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
