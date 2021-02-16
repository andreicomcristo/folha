package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.Paises;
import com.folha.boot.service.PaisesSevice;

@Controller
@RequestMapping("/paises")
public class PaisesController {

	@Autowired
	private PaisesSevice service;

	@GetMapping("/cadastrar")
	public String cadastrar(Paises pais) {
		
		return "/pais/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("paises", service.buscarTodos());
		return "/pais/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Paises pais, RedirectAttributes attr) {
		service.salvar(service.converteEmMaiusculo(pais));
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/paises/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("paises", service.buscarPorId(id));
		return "/pais/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Paises pais, RedirectAttributes attr) {
		service.editar(service.converteEmMaiusculo(pais));
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/paises/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nomePais")
	public String getPorNome(@RequestParam("nomePais") String nomePais, ModelMap model) {		
		model.addAttribute("paises", service.buscarPorNome(nomePais.toUpperCase().trim()));
		return "/pais/lista";
	}
	
}
