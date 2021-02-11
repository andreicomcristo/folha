package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.Pessoa;
import com.folha.boot.service.PessoaService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Pessoa pessoa) {
		
		return "/pessoa/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoas", service.buscarTodos());
		return "/pessoa/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Pessoa pessoa, RedirectAttributes attr) {
		
		service.salvar(pessoa);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/pessoas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoas", service.buscarPorId(id));
		return "/pessoa/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Pessoa pessoa, RedirectAttributes attr) {
		service.editar(pessoa);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/pessoas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
}
