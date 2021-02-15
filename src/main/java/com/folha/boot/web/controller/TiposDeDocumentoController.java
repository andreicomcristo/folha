package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.TiposDeDocumento;
import com.folha.boot.service.TiposDeDocumentoService;

@Controller
@RequestMapping("/tiposdedocumentos")
public class TiposDeDocumentoController {	

	@Autowired
	private TiposDeDocumentoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(TiposDeDocumento tiposDeDocumento) {		
		return "/doctipo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("TiposDeDocumento", service.buscarTodos());
		return "/doctipo/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(TiposDeDocumento tiposDeDocumento, RedirectAttributes attr) {
		
		service.salvar(tiposDeDocumento);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/tiposdedocumentos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("tiposDeDocumento", service.buscarPorId(id));
		return "/doctipo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(TiposDeDocumento tiposDeDocumento, RedirectAttributes attr) {
		service.editar(tiposDeDocumento);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/tiposdedocumentos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
}
