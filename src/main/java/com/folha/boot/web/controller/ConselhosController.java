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

import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.Conselhos;
import com.folha.boot.service.BancosService;
import com.folha.boot.service.ConselhosServices;

@Controller
@RequestMapping("/conselhos")
public class ConselhosController {

	@Autowired
	private ConselhosServices service;

	@GetMapping("/cadastrar")
	public String cadastrar(Conselhos conselho) {
		return "/conselho/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("conselhos", service.buscarTodos());
		return "/conselho/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Conselhos conselho, RedirectAttributes attr) {
		
		conselho = service.converteEmMaiusculo(conselho);
		
		service.salvar(conselho);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/conselhos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("conselhos", service.buscarPorId(id));
		return "/conselho/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Conselhos conselho, RedirectAttributes attr) {
		
		conselho = service.converteEmMaiusculo(conselho);
		
		service.editar(conselho);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/conselhos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/descricaoconselho")
	public String getPorNome(@RequestParam("descricaoConselho") String descricaoConselho, ModelMap model) {		
		model.addAttribute("conselhos", service.buscarPorDescricao(descricaoConselho.toUpperCase().trim()));
		return "/conselho/lista";
	}
	
}
