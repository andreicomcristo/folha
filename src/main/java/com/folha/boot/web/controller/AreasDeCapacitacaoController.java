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
import com.folha.boot.domain.AreasDeCapacitacao;
import com.folha.boot.service.AreasDeCapacitacaoService;

@Controller
@RequestMapping("/areasdecapacitacoes")
public class AreasDeCapacitacaoController {

	@Autowired
	private AreasDeCapacitacaoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(AreasDeCapacitacao areasDeCapacitacao) {		
		return "/areacapacitacao/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("areasDeCapacitacao", service.buscarTodos());
		return "/areacapacitacao/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(AreasDeCapacitacao areasDeCapacitacao, RedirectAttributes attr) {
		service.salvar(areasDeCapacitacao);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/areasdecapacitacoes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("areasDeCapacitacao", service.buscarPorId(id));
		return "/areacapacitacao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(AreasDeCapacitacao areasDeCapacitacao, RedirectAttributes attr) {
		service.editar(areasDeCapacitacao);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/areasdecapacitacoes/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/area/capacitacao")
	public String getPorNome(@RequestParam("areaDeCapacitacao") String areaDeCapacitacao, ModelMap model) {		
		model.addAttribute("areasDeCapacitacao", service.buscarPorNome(areaDeCapacitacao.toUpperCase().trim()));
		return "/areacapacitacao/lista";
	}
}
