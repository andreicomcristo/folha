package com.folha.boot.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.LocalidadeEscala;
import com.folha.boot.service.AtividadeEscalaService;

@Controller
@RequestMapping("/atividadesescalas")
public class AtividadeEscalaController {

	@Autowired
	private AtividadeEscalaService service;

	@GetMapping("/cadastrar")
	public String cadastrar(AtividadeEscala atividadeEscala) {		
		return "/atividadeescala/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("atividadeEscala", service.buscarTodos());
		return "/atividadeescala/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(AtividadeEscala atividadeEscala, RedirectAttributes attr) {
		service.salvar(atividadeEscala);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/atividadesescalas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("atividadeEscala", service.buscarPorId(id));
		return "/atividadeescala/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(AtividadeEscala atividadeEscala, RedirectAttributes attr) {
		service.editar(atividadeEscala);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/atividadesescalas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		AtividadeEscala atividadeEscala = service.buscarPorId(id);
		atividadeEscala.setDtCancelamento(new Date());
		service.salvar(atividadeEscala); 
		model.addAttribute("success", "Cancelado com sucesso.");
		return "redirect:/atividadesescalas/listar";
	}
	
	@GetMapping("/buscar/nome/atividade/escala")
	public String getPorNome(@RequestParam("nomeAtividade") String nomeAtividade, ModelMap model) {		
		model.addAttribute("atividadeEscala", service.buscarPorNome(nomeAtividade.toUpperCase().trim()));
		return "/atividadeescala/lista";
	}
}
