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
import com.folha.boot.domain.FaixasPrevidencia;
import com.folha.boot.domain.FaixasPrevidenciaNome;
import com.folha.boot.service.FaixasPrevidenciaNomeService;
import com.folha.boot.service.FaixasPrevidenciaSevice;

@Controller
@RequestMapping("/faixasprevidencia")
public class FaixasPrevidenciaController {

	@Autowired
	private FaixasPrevidenciaSevice service;
	@Autowired
	private FaixasPrevidenciaNomeService FaixasPrevidenciaNomeService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(FaixasPrevidencia faixasPrevidencia) {
		
		return "/faixaprevidencia/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("faixasPrevidencia", service.buscarTodos());
		return "/faixaprevidencia/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(FaixasPrevidencia faixasPrevidencia, RedirectAttributes attr) {
		service.salvar(faixasPrevidencia);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/faixasprevidencia/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("faixasPrevidencia", service.buscarPorId(id));
		return "/faixaprevidencia/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(FaixasPrevidencia faixasPrevidencia, RedirectAttributes attr) {	
		service.editar(faixasPrevidencia);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/faixasprevidencia/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/ano/mes")
	public String getAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {		
		model.addAttribute("anoMes", service.buscarPorAnoMes(anoMes.toUpperCase().trim()));
		return "/faixaprevidencia/lista";
	}
	
	@ModelAttribute("idFaixasPrevidenciaNomeFk")
	public List<FaixasPrevidenciaNome> getIdFaixasPrevidenciaNomeFk() {
		
		return FaixasPrevidenciaNomeService.buscarTodos();
		
	}	
}
