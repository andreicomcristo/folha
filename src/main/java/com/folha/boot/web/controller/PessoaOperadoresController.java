package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.service.PessoaOperadoresService;

@Controller
@RequestMapping("/operadores")
public class PessoaOperadoresController {
	
	@Autowired
	private PessoaOperadoresService service;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaOperadores operadores) {		
		return "/operador/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaOperadores", service.buscarTodos());
		return "/operador/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaOperadores operadores, RedirectAttributes attr) {		
		service.salvar(operadores);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/operadores/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("PessoaOperadores", service.buscarPorId(id));
		return "/operador/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaOperadores operadores, RedirectAttributes attr) {
		service.editar(operadores);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/operadores/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}

}
