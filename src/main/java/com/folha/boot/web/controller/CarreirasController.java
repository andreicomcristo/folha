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

import com.folha.boot.domain.Carreiras;
import com.folha.boot.service.CarreirasService;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Controller
@RequestMapping("/carreiras")
public class CarreirasController {

	@Autowired
	private CarreirasService service;
	
	UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();

	@GetMapping("/cadastrar")
	public String cadastrar(Carreiras carreira) {
		return "/carreira/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("carreiras", service.buscarTodos());
		return "/carreira/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Carreiras carreira, RedirectAttributes attr) {		
		
		carreira = service.converteEmMaiusculo(carreira);
		
		service.salvar(carreira);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/carreiras/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("carreiras", service.buscarPorId(id));
		return "/carreira/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Carreiras carreiras, RedirectAttributes attr) {
		
		carreiras = service.converteEmMaiusculo(carreiras);
		
		service.editar(carreiras);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/carreiras/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id); 
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nomecarreira")
	public String getPorNome(@RequestParam("nomeCarreira") String nomeCarreira, ModelMap model) {		
		model.addAttribute("carreiras", service.buscarPorNome(nomeCarreira.toUpperCase().trim()));
		return "/carreira/lista";
	}
	
}
