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

import com.folha.boot.domain.Classes;
import com.folha.boot.service.ClassesService;

@Controller
@RequestMapping("/classes")
public class ClassesController {

	@Autowired
	private ClassesService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Classes classe) {
		
		return "/classe/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("classes", service.buscarTodos());
		return "/classe/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Classes classe, RedirectAttributes attr) {
		service.salvar(classe);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/classes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("classes", service.buscarPorId(id));
		return "/classe/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Classes classe, RedirectAttributes attr) {
		service.editar(classe);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/classes/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/classe")
	public String getPorNome(@RequestParam("nomeClasse") String nomeClasse, ModelMap model) {		
		model.addAttribute("classes", service.buscarPorNome(nomeClasse.toUpperCase().trim()));
		return "/classe/lista";
	}
}
