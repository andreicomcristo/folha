package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.PessoaDocumentosHabilitacao;
import com.folha.boot.service.PessoaDocumentosHabilitacaoService;

@Controller
@RequestMapping("/habilitacaodocs")
public class PessoaDocumentosHabilitacaoController {

	@Autowired
	private PessoaDocumentosHabilitacaoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaDocumentosHabilitacao habilitacao) {		
		return "/dochabilitacao/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaDocumentosHabilitacao", service.buscarTodos());
		System.out.println(service.buscarTodos().toString());
		return "/dochabilitacao/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaDocumentosHabilitacao habilitacao, RedirectAttributes attr) {
		
		service.salvar(habilitacao);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/habilitacaodocs/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaDocumentosHabilitacao", service.buscarPorId(id));
		return "/dochabilitacao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaDocumentosHabilitacao habilitacao, RedirectAttributes attr) {
		service.editar(habilitacao);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/habilitacaodocs/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
}
