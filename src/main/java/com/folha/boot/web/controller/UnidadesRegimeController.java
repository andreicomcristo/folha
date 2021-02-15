package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.UnidadesRegime;
import com.folha.boot.service.UnidadesRegimeService;

@Controller
@RequestMapping("/regimes")
public class UnidadesRegimeController {

	@Autowired
	private UnidadesRegimeService service;

	@GetMapping("/cadastrar")
	public String cadastrar(UnidadesRegime unidadesRegime) {		
		return "/unidaderegime/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("unidadesRegime", service.buscarTodos());
		return "/unidaderegime/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(UnidadesRegime unidadesRegime, RedirectAttributes attr) {
		
		service.salvar(unidadesRegime);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/regimes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("unidadesRegime", service.buscarPorId(id));
		return "/unidaderegime/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(UnidadesRegime unidadesRegime, RedirectAttributes attr) {
		service.editar(unidadesRegime);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/regimes/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
}
