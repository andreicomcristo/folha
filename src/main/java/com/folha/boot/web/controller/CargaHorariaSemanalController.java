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

import com.folha.boot.domain.CargaHorariaSemanal;
import com.folha.boot.service.CargaHorariaSemanalService;

@Controller
@RequestMapping("/cargahorariasemanais")
public class CargaHorariaSemanalController {
	
	@Autowired
	private CargaHorariaSemanalService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(CargaHorariaSemanal cargaHorariaSemanal) {
		
		return "/cargahoraria/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargaHorariaSemanal", service.buscarTodos());		
		return "/cargahoraria/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(CargaHorariaSemanal cargaHorariaSemanal, RedirectAttributes attr) {				
		service.salvar(cargaHorariaSemanal);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/cargahorariasemanais/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargaHorariaSemanal", service.buscarPorId(id));
		return "/cargahoraria/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(CargaHorariaSemanal cargaHorariaSemanal, RedirectAttributes attr) {
		
		service.editar(cargaHorariaSemanal);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/cargahorariasemanais/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);

	}
	
	@GetMapping("/buscar/cargahoraria")
	public String getPorNome(@RequestParam("cargaHoraria") String cargaHoraria, ModelMap model) {
		String retorno = "/cargahoraria/lista";
		if(cargaHoraria.length()!=0) {
			model.addAttribute("cargaHorariaSemanal",service.buscarPorCargaHorariaSemanal(Integer.parseInt(cargaHoraria.toUpperCase().trim())));
		}else {retorno = "/cargahoraria/lista";}
		
		return retorno;
	}
}