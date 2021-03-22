package com.folha.boot.web.controller;

import java.util.List;

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
import com.folha.boot.domain.FaixasImpostoDeRenda;
import com.folha.boot.domain.FaixasImpostoDeRendaNome;
import com.folha.boot.service.FaixasImpostoDeRendaNomeService;
import com.folha.boot.service.FaixasImpostoDeRendaService;

@Controller
@RequestMapping("/faixasir")
public class FaixasImpostoDeRendaController {

	@Autowired
	private FaixasImpostoDeRendaService service;
	@Autowired
	private FaixasImpostoDeRendaNomeService faixasImpostoDeRendaNomeService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(FaixasImpostoDeRenda faixasImpostoDeRenda) {
		
		return "/faixaimpostoderenda/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("faixasImpostoDeRenda", service.buscarTodos());
		return "/faixaimpostoderenda/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(FaixasImpostoDeRenda faixasImpostoDeRenda, RedirectAttributes attr) {
		service.salvar(faixasImpostoDeRenda);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/faixasir/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("faixasImpostoDeRenda", service.buscarPorId(id));
		return "/faixaimpostoderenda/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(FaixasImpostoDeRenda faixasImpostoDeRenda, RedirectAttributes attr) {	
		service.editar(faixasImpostoDeRenda);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/faixasir/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/ano/mes")
	public String getPorNome(@RequestParam("anoMes") String anoMes, ModelMap model) {		
		model.addAttribute("anoMes", service.buscarPorAnoMes(anoMes.toUpperCase().trim()));
		return "/faixaimpostoderenda/lista";
	}
	
	@ModelAttribute("idFaixasImpostoDeRendaNomeFk")
	public List<FaixasImpostoDeRendaNome> getIdFaixasImpostoDeRendaNomeFk() {
		return faixasImpostoDeRendaNomeService.buscarTodos();
	}	
}
