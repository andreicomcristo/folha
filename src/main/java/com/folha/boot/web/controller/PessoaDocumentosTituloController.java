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

import com.folha.boot.domain.PessoaDocumentosTitulo;
import com.folha.boot.service.PessoaDocumentosTituloService;

@Controller
@RequestMapping("/titulodocs")
public class PessoaDocumentosTituloController {

	@Autowired
	private PessoaDocumentosTituloService service;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaDocumentosTitulo titulo) {		
		return "/doctitulo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaDocumentosTitulo", service.buscarTodos());
		return "/doctitulo/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaDocumentosTitulo titulo, RedirectAttributes attr) {
		
		service.salvar(titulo);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/titulodocs/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaDocumentosTitulo", service.buscarPorId(id));
		return "/doctitulo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaDocumentosTitulo titulo, RedirectAttributes attr) {
		service.editar(titulo);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/titulodocs/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/numero/documento/titulo")
	public String getPorNome(@RequestParam("numeroTitulo") String numeroTitulo, ModelMap model) {		
		model.addAttribute("pessoaDocumentosTitulo", service.buscarPorNumero(numeroTitulo.toUpperCase().trim()));
		return "/doctitulo/lista";
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
