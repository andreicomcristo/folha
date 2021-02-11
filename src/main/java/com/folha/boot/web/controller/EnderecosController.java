package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.Enderecos;
import com.folha.boot.service.EnderecosServices;

@Controller
@RequestMapping("/enderecos")
public class EnderecosController {

	@Autowired
	private EnderecosServices service;

	@GetMapping("/cadastrar")
	public String cadastrar(Enderecos endereco) {
		
		return "/endereco/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("enderecos", service.buscarTodos());
		return "/endereco/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Enderecos endereco, RedirectAttributes attr) {
		
		service.salvar(endereco);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/enderecos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("enderecos", service.buscarPorId(id));
		return "/endereco/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Enderecos endereco, RedirectAttributes attr) {
		service.editar(endereco);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/enderecos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}

}
