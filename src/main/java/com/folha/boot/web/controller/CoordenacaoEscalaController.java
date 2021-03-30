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
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.LocalidadeEscala;
import com.folha.boot.service.AtividadeEscalaService;
import com.folha.boot.service.CoordenacaoEscalaService;
import com.folha.boot.service.LocalidadeEscalaService;

@Controller
@RequestMapping("/coordenacaoescalas")
public class CoordenacaoEscalaController {

	@Autowired
	private CoordenacaoEscalaService service;
	@Autowired
	private AtividadeEscalaService atividadeEscalaservice;
	@Autowired
	private LocalidadeEscalaService localidadeEscalaService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(CoordenacaoEscala conselho) {
		return "/coordenacaoescala/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("coordenacaoEscala", service.buscarTodos());
		return "/coordenacaoescala/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(CoordenacaoEscala conselho, RedirectAttributes attr) {
		service.salvar(conselho);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/coordenacaoescalas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("coordenacaoEscala", service.buscarPorId(id));
		return "/coordenacaoescala/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(CoordenacaoEscala conselho, RedirectAttributes attr) {
		service.editar(conselho);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/coordenacaoescalas/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	/*@GetMapping("/buscar/nome/coordenacao")
	public String getPorNome(@RequestParam("nomeCoordenacao") String nomeCoordenacao, ModelMap model) {		
		model.addAttribute("coordenacaoEscala", service.buscarPorNome(nomeCoordenacao.toUpperCase().trim()));
		return "/coordenacaoescala/lista";
	}*/
	
	@ModelAttribute("idAtividadeFk")
	public List<AtividadeEscala> getAtividadeEscala() {
		return atividadeEscalaservice.buscarTodos();
	}
	
	@ModelAttribute("idLocalidadeFk")
	public List<LocalidadeEscala> getLocalidadeEscala() {
		return localidadeEscalaService.buscarTodos();
	}
}
