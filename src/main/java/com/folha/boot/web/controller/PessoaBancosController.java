package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.PessoaBancos;
import com.folha.boot.service.PessoaBancosService;

@Controller
@RequestMapping("/pessoabancos")
public class PessoaBancosController {

	@Autowired
	private PessoaBancosService service;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaBancos pessoaBanco) {
		
		return "/pessoabanco/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaBancos", service.buscarTodos());
		return "/pessoananco/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaBancos pessoaBanco, RedirectAttributes attr) {
		
		service.salvar(pessoaBanco);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/pessoabancos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaBancos", service.buscarPorId(id));
		return "/pessoabanco/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaBancos pessoaBancos, RedirectAttributes attr) {
		service.editar(pessoaBancos);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/pessoabancos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
}
