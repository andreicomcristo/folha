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

import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.CategoriaDeLicenca;
import com.folha.boot.service.BancosService;
import com.folha.boot.service.CategoriaDeLicencaService;

@Controller
@RequestMapping("/categoriaDeLicenca")
public class CategoriaDeLicencaController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	private CategoriaDeLicencaService service;
	@GetMapping("/cadastrar")
	public String cadastrar(CategoriaDeLicenca categoriaDeLicenca) {
		return "/categoriaDeLicenca/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("nomeOperadorLogado", request.getSession().getAttribute("operador"));
		model.addAttribute("nomeUnidadeLogada", request.getSession().getAttribute("unidade").toString());
		model.addAttribute("categoriaDeLicenca", service.buscarTodos());
		return "/categoriaDeLicenca/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(CategoriaDeLicenca categoriaDeLicenca, RedirectAttributes attr) {
		service.salvar(categoriaDeLicenca);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/categoriaDeLicenca/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("nomeOperadorLogado", request.getSession().getAttribute("operador"));
		model.addAttribute("nomeUnidadeLogada", request.getSession().getAttribute("unidade").toString());
		model.addAttribute("categoriaDeLicenca", service.buscarPorId(id));
		
		return "/categoriaDeLicenca/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(CategoriaDeLicenca categoriaDeLicenca, RedirectAttributes attr) {
		service.salvar(categoriaDeLicenca);		
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/categoriaDeLicenca/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id); 
		model.addAttribute("nomeOperadorLogado", request.getSession().getAttribute("operador"));
		model.addAttribute("nomeUnidadeLogada", request.getSession().getAttribute("unidade").toString());
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("nomeOperadorLogado", request.getSession().getAttribute("operador"));
		model.addAttribute("nomeUnidadeLogada", request.getSession().getAttribute("unidade").toString());
		model.addAttribute("categoriaDeLicenca", service.buscarPorNome(nome));
		return "/categoriaDeLicenca/lista";
	}
	
	
	
	
	@ModelAttribute("nomeOperadorLogado")
	public String operadorLogado() {
		return request.getSession().getAttribute("operador").toString();
	}
	@ModelAttribute("nomeUnidadeLogada")
	public String unidadeLogada() {
		return request.getSession().getAttribute("unidade").toString();
	}
	
	
}
