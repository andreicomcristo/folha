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

import com.folha.boot.domain.TiposLogradouro;
import com.folha.boot.service.TiposLogradouroService;

@Controller
@RequestMapping("/tiposlogradouros") 
public class TiposLogradouroController {

	@Autowired
	private TiposLogradouroService service;

	@GetMapping("/cadastrar")
	public String cadastrar(TiposLogradouro tiposLogradouro) {		
		return "/tipologradouro/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("tiposLogradouro", service.buscarTodos());
		return "/tipologradouro/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(TiposLogradouro tiposLogradouro, RedirectAttributes attr) {
		
		service.salvar(tiposLogradouro);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/tiposlogradouros/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("tiposLogradouro", service.buscarPorId(id));
		return "/tipologradouro/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(TiposLogradouro tiposLogradouro, RedirectAttributes attr) {
		service.editar(tiposLogradouro);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/tiposlogradouros/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}	
	
	@GetMapping("/buscar/nome/tipologradouro")
	public String getPorNome(@RequestParam("nomeTipoLogradouro") String nomeTipoLogradouro, ModelMap model) {		
		model.addAttribute("tiposLogradouro", service.buscarPorNome(nomeTipoLogradouro.toUpperCase().trim()));
		return "/tipologradouro/lista";
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
