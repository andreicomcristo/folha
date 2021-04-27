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

import com.folha.boot.domain.Uf;
import com.folha.boot.service.UfService;

@Controller
@RequestMapping("/ufs")
public class UfController {

	@Autowired
	private UfService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Uf uf) {		
		return "/uf/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("uf", service.buscarTodos());
		return "/uf/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Uf uf, RedirectAttributes attr) {
		service.salvar(uf);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/ufs/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("uf", service.buscarPorId(id));
		return "/uf/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Uf uf, RedirectAttributes attr) {
		service.editar(uf);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/ufs/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/uf")
	public String getPorNome(@RequestParam("nomeUf") String nomeUf, ModelMap model) {		
		model.addAttribute("uf", service.buscarPorNome(nomeUf.toUpperCase().trim()));
		return "/uf/lista";
	}
	
	@GetMapping("/buscar/id/uf")
	public String getPorIdUf(@RequestParam("idUf") String idUf, ModelMap model) {		
		model.addAttribute("uf", service.buscarPorId( Long.parseLong(idUf) ));
		return "/uf/lista";
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
