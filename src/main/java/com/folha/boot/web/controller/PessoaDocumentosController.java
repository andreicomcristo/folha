package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.service.PessoaDocumentosService;

@Controller
@RequestMapping("/documentos")
public class PessoaDocumentosController {

	@Autowired
	private PessoaDocumentosService service;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaDocumentos pessoaDocumentos) {		
		return "/documento/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaDocumentos", service.buscarTodos());
		System.out.println(service.buscarTodos().toString());
		return "/documento/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaDocumentos documento, RedirectAttributes attr) {
		
		service.salvar(documento);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/documentos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaDocumentos", service.buscarPorId(id));
		return "/documento/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaDocumentos documento, RedirectAttributes attr) {
		service.editar(documento);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/documentos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
}
