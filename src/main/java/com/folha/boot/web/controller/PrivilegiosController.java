package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.Privilegios;
import com.folha.boot.service.PrivilegiosService;

@Controller
@RequestMapping("/privilegios")
public class PrivilegiosController {

	@Autowired
	private PrivilegiosService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Privilegios privilegios) {		
		return "/privilegio/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("privilegios", service.buscarTodos());
		return "/privilegio/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Privilegios privilegios , RedirectAttributes attr) {
		
		service.salvar(privilegios);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/privilegios/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("Privilegios", service.buscarPorId(id));
		return "/privilegio/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Privilegios privilegios, RedirectAttributes attr) {
		service.editar(privilegios);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/privilegios/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
}
