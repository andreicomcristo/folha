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
import com.folha.boot.domain.FaixasImpostoDeRendaNome;
import com.folha.boot.service.FaixasImpostoDeRendaNomeService;

@Controller
@RequestMapping("/faixasnomesir")
public class FaixasImpostoDeRendaNomeController {

	@Autowired
	private FaixasImpostoDeRendaNomeService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(FaixasImpostoDeRendaNome faixasImpostoDeRendaNome) {
		
		return "/faixanomeir/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("faixasImpostoDeRendaNome", service.buscarTodos());
		return "/faixanomeir/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(FaixasImpostoDeRendaNome faixasImpostoDeRendaNome, RedirectAttributes attr) {
		service.salvar(faixasImpostoDeRendaNome);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/faixasnomesir/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("faixasImpostoDeRendaNome", service.buscarPorId(id));
		return "/faixanomeir/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(FaixasImpostoDeRendaNome faixasImpostoDeRendaNome, RedirectAttributes attr) {	
		service.editar(faixasImpostoDeRendaNome);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/faixasnomesir/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/faixa")
	public String getPorNome(@RequestParam("nomeFaixa") String nomeFaixa, ModelMap model) {		
		model.addAttribute("nomeFaixa", service.buscarNome(nomeFaixa.toUpperCase().trim()));
		return "/faixanomeir/lista";
	}
	
}
