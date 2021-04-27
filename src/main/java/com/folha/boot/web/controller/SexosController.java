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

import com.folha.boot.domain.Sexos;
import com.folha.boot.service.SexosService;

@Controller
@RequestMapping("/sexos")
public class SexosController {

	@Autowired
	private SexosService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Sexos sexos) {		
		return "/sexo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("sexos", service.buscarTodos());
		return "/sexo/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Sexos sexos, RedirectAttributes attr) {
		service.salvar(sexos);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/sexos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("sexos", service.buscarPorId(id));
		return "/sexo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Sexos sexos, RedirectAttributes attr) {
		service.editar(sexos);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/sexos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/Sexo")
	public String getPorNome(@RequestParam("nomeSexo") String nomeSexo, ModelMap model) {		
		model.addAttribute("sexos", service.buscarPorNome(nomeSexo.toUpperCase().trim()));
		return "/sexo/lista";
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
