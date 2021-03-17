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
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.service.CodigoDiferenciadoService;

@Controller
@RequestMapping("/codigodiferenciados")
public class CodigoDiferenciadoController {

	@Autowired
	private CodigoDiferenciadoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(CodigoDiferenciado codigoDiferenciado) {		
		return "/codigodiferenciado/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("codigoDiferenciado", service.buscarTodos());
		return "/codigodiferenciado/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(CodigoDiferenciado codigoDiferenciado, RedirectAttributes attr) {
		service.salvar(codigoDiferenciado);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/codigodiferenciados/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("codigoDiferenciado", service.buscarPorId(id));
		return "/codigodiferenciado/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(CodigoDiferenciado codigoDiferenciado, RedirectAttributes attr) {
		service.editar(codigoDiferenciado);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/codigodiferenciados/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/codigodiferenciado")
	public String getPorNome(@RequestParam("nomeCodigoDiferenciado") String nomeCodigoDiferenciado, ModelMap model) {		
		model.addAttribute("codigoDiferenciado", service.buscarPorNome(nomeCodigoDiferenciado.toUpperCase().trim()));
		return "/codigodiferenciado/lista";
	}
}
