package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.PessoaFotos;
import com.folha.boot.service.PessoaFotosService;

@Controller
@RequestMapping("/fotos")
public class PessoaFotosController {

	@Autowired
	private PessoaFotosService service;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaFotos fotos) {		
		return "/foto/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaFotos", service.buscarTodos());
		return "/foto/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaFotos fotos, RedirectAttributes attr) {
		
		service.salvar(fotos);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/fotos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaFotos", service.buscarPorId(id));
		return "/foto/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaFotos fotos, RedirectAttributes attr) {
		service.editar(fotos);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/fotos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
}
