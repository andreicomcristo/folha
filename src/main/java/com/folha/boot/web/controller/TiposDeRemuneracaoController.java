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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.TiposDeRemuneracao;
import com.folha.boot.service.TiposDeRemuneracaoService;

@Controller
@RequestMapping("/tipoRemuneracao")
public class TiposDeRemuneracaoController {
	
	@Autowired
	private TiposDeRemuneracaoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(TiposDeRemuneracao tiposDeRemuneracao) {
		return "tipoRemuneracao/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("tiposDeRemuneracao", service.buscarTodos());
		return "tipoRemuneracao/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(TiposDeRemuneracao tiposDeRemuneracao, RedirectAttributes attr) {
		service.salvar(tiposDeRemuneracao);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/tipoRemuneracao/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("tiposDeRemuneracao", service.buscarPorId(id));
		
		return "tipoRemuneracao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(TiposDeRemuneracao tiposDeRemuneracao, RedirectAttributes attr) {
		service.salvar(tiposDeRemuneracao);		
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/tipoRemuneracao/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
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
