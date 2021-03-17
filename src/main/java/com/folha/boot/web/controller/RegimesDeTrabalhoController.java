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
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.service.RegimesDeTrabalhoService;

@Controller
@RequestMapping("/regimesdetrabalhos")
public class RegimesDeTrabalhoController {	
	@Autowired
	private RegimesDeTrabalhoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(RegimesDeTrabalho regimesDeTrabalho) {		
		return "/regimedetrabalho/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("regimesDeTrabalho", service.buscarTodos());
		return "/regimedetrabalho/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(RegimesDeTrabalho regimesDeTrabalho, RedirectAttributes attr) {
		service.salvar(regimesDeTrabalho);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/regimesdetrabalhos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("regimesDeTrabalho", service.buscarPorId(id));
		return "/regimedetrabalho/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(RegimesDeTrabalho regimesDeTrabalho, RedirectAttributes attr) {
		service.editar(regimesDeTrabalho);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/regimesdetrabalhos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/regimedetrabalho")
	public String getPorNome(@RequestParam("nomeRegimeDeTrabalho") String nomeRegimeDeTrabalho, ModelMap model) {		
		model.addAttribute("regimesDeTrabalho", service.buscarPorNome(nomeRegimeDeTrabalho.toUpperCase().trim()));
		return "/regimedetrabalho/lista";
	}
}
