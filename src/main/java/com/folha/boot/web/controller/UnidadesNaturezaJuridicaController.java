package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.UnidadesNaturezaJuridica;
import com.folha.boot.service.UnidadesNaturezaJuridicaService;

@Controller
@RequestMapping("/naturezas")
public class UnidadesNaturezaJuridicaController {

	@Autowired
	private UnidadesNaturezaJuridicaService service;

	@GetMapping("/cadastrar")
	public String cadastrar(UnidadesNaturezaJuridica naturezaJuridica) {		
		return "/naturezajuridica/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("unidadesNaturezaJuridica", service.buscarTodos());
		return "/naturezajuridica/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(UnidadesNaturezaJuridica naturezaJuridica, RedirectAttributes attr) {
		
		service.salvar(naturezaJuridica);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/naturezas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("unidadesNaturezaJuridica", service.buscarPorId(id));
		return "/naturezajuridica/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(UnidadesNaturezaJuridica naturezaJuridica, RedirectAttributes attr) {
		service.editar(naturezaJuridica);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/naturezas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
}
