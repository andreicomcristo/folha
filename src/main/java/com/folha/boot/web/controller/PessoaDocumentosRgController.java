package com.folha.boot.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.PessoaDocumentosRg;
import com.folha.boot.service.PessoaDocumentosRgService;

@Controller
@RequestMapping("/rgdocs")
public class PessoaDocumentosRgController {

	@Autowired
	private PessoaDocumentosRgService service;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaDocumentosRg Rg) {		
		return "/docrg/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaDocumentosRg", service.buscarTodos());
		return "/docrg/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaDocumentosRg rg, RedirectAttributes attr) {
		
		service.salvar(rg);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/rgdocs/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaDocumentosRg", service.buscarPorId(id));
		return "/docrg/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaDocumentosRg rg, RedirectAttributes attr) {
		service.editar(rg);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/rgdocs/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/numero/documento/rg")
	public String getPorNome(@RequestParam("rgNumero") String rgNumero, ModelMap model) {		
		model.addAttribute("pessoaDocumentosRg", service.buscarPorNumero(rgNumero.toUpperCase().trim()));
		return "/docrg/lista";
	}
	
	@Autowired
	HttpServletRequest request;
	@ModelAttribute("nomeOperadorLogado")
	public String operadorLogado() {
		return request.getSession().getAttribute("operador").toString();
	}
	@ModelAttribute("nomeUnidadeLogada")
	public String unidadeLogada() {
		return request.getSession().getAttribute("unidade").toString();
	}
	
}
