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

import com.folha.boot.domain.Autorizacoes;
import com.folha.boot.service.AutorizacoesService;

@Controller
@RequestMapping("/autorizacoes")
public class AutorizacoesController {
	
	@Autowired
	private AutorizacoesService service;
		
	@GetMapping("/cadastrar")
	public String cadastrar(Autorizacoes autorizacoes) {

		return "autorizacao/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("autorizacoes", service.buscarTodos());
		return "autorizacao/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Autorizacoes autorizacoes, RedirectAttributes attr) {

		service.salvar(autorizacoes);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/autorizacoes/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("autorizacoes", service.buscarPorId(id));
		return "autorizacao/cadastro";
	}
 
	@PostMapping("/editar")
	public String editar(Autorizacoes autorizacoes, RedirectAttributes attr) {
		service.editar(autorizacoes);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/autorizacoes/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {

		/*
		 * if (service.depertamentoTemCargos(id)) { model.addAttribute("fail",
		 * "Departamento não removido. Possui cargo(s) vinculado(s)."); } else {
		 * service.excluir(id); model.addAttribute("success",
		 * "Departamento excluído com sucesso."); }
		 */
		service.excluir(id); // Caso implemente a regra acima, apagar essa linha.
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