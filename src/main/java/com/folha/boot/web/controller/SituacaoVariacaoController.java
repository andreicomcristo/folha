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

import com.folha.boot.domain.SituacaoVariacao;
import com.folha.boot.service.SituacaoVariacaoService;

@Controller
@RequestMapping("/situacaoVariacao")
public class SituacaoVariacaoController {

	@Autowired
	private SituacaoVariacaoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(SituacaoVariacao situacaoVariacao) {		
		return "situacaoVariacao/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("situacaoVariacao", service.buscarTodos());
		return "situacaoVariacao/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(SituacaoVariacao situacaoVariacao, RedirectAttributes attr) {		
		service.salvar(situacaoVariacao);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/situacaoVariacao/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("situacaoVariacao", service.buscarPorId(id));
		return "situacaoVariacao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(SituacaoVariacao situacaoVariacao, RedirectAttributes attr) {
		service.editar(situacaoVariacao);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/situacaoVariacao/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/situacao")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("situacaoVariacao", service.buscarPorNome(nome));
		return "situacaoVariacao/lista";
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
