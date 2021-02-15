package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.PessoaFilhos;
import com.folha.boot.service.PessoaFilhosService;

@Controller
@RequestMapping("/folhos")
public class PessoaFilhosController {

	@Autowired
	private PessoaFilhosService service;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaFilhos filhos) {		
		return "/filho/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("PessoaFilhos", service.buscarTodos());
		return "/filho/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaFilhos filhos, RedirectAttributes attr) {
		
		service.salvar(filhos);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/filhos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("PessoaFilhos", service.buscarPorId(id));
		return "/filho/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaFilhos filhos, RedirectAttributes attr) {
		service.editar(filhos);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/filhos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
}
