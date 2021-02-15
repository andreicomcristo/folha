package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.service.PessoaFuncionariosService;

@Controller
@RequestMapping("/funcionarios")
public class PessoaFuncionariosController {

	@Autowired
	private PessoaFuncionariosService service;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaFuncionarios funcionarios) {		
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaFuncionarios", service.buscarTodos());
		return "/funcionario/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaFuncionarios funcionarios, RedirectAttributes attr) {
		
		service.salvar(funcionarios);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("PessoaFuncionarios", service.buscarPorId(id));
		return "/funcionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaFuncionarios funcionarios, RedirectAttributes attr) {
		service.editar(funcionarios);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/funcionarios/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
}
