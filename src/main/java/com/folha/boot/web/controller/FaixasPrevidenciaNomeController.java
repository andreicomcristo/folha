package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.folha.boot.domain.FaixasPrevidenciaNome;
import com.folha.boot.service.FaixasPrevidenciaNomeService;

@Controller
@RequestMapping("/faixasnomesprev")
public class FaixasPrevidenciaNomeController {

	@Autowired
	private FaixasPrevidenciaNomeService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(FaixasPrevidenciaNome faixasPrevidenciaNome) {
		
		return "/faixanomeprev/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("faixasPrevidenciaNome", service.buscarTodos());
		return "/faixanomeprev/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(FaixasPrevidenciaNome faixasPrevidenciaNome, RedirectAttributes attr) {
		service.salvar(faixasPrevidenciaNome);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/faixasnomesprev/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("faixasPrevidenciaNome", service.buscarPorId(id));
		return "/faixanomeprev/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(FaixasPrevidenciaNome faixasPrevidenciaNome, RedirectAttributes attr) {	
		service.editar(faixasPrevidenciaNome);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/faixasnomesprev/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/faixa")
	public String getPorNome(@RequestParam("nomeFaixa") String nomeFaixa, ModelMap model) {		
		model.addAttribute("faixasPrevidenciaNome", service.buscarNome(nomeFaixa.toUpperCase().trim()));
		return "/faixanomeprev/lista";
	}
	
}
