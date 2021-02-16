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

import com.folha.boot.domain.Vinculos;
import com.folha.boot.service.VinculosService;

@Controller
@RequestMapping("/vinculos")
public class VinculosController {

	@Autowired
	private VinculosService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Vinculos vinculos) {		
		return "/vinculo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("vinculos", service.buscarTodos());
		return "/vinculo/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Vinculos vinculos, RedirectAttributes attr) {	
		service.salvar(service.converteEmMaiusculo(vinculos));
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/vinculos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("vinculos", service.buscarPorId(id));
		return "/vinculo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Vinculos vinculos, RedirectAttributes attr) { 
		service.editar(service.converteEmMaiusculo(vinculos));
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/vinculos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/vinculo")
	public String getPorNome(@RequestParam("nomeVinculo") String nomeVinculo, ModelMap model) {		
		model.addAttribute("vinculos", service.buscarPorNome(nomeVinculo.toUpperCase().trim()));
		return "/vinculo/lista";
	}
}
