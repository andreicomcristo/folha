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

import com.folha.boot.domain.TiposDeDocumento;
import com.folha.boot.service.TiposDeDocumentoService;

@Controller
@RequestMapping("/tiposdedocumentos")
public class TiposDeDocumentoController {	

	@Autowired
	private TiposDeDocumentoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(TiposDeDocumento tiposDeDocumento) {		
		return "tipodocumento/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("tiposDeDocumento", service.buscarTodos());
		return "tipodocumento/lista"; 
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
		return "tipodocumento/cadastro";
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
	
	@GetMapping("/buscar/sigla/documento")
	public String getPorNome(@RequestParam("siglaDocumento") String siglaDocumento, ModelMap model) {		
		model.addAttribute("tiposDeDocumento", service.buscarPorNome(siglaDocumento.toUpperCase().trim()));
		return "tipodocumento/lista";
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
