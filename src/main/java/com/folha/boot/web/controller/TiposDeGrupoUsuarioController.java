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

import com.folha.boot.domain.TiposDeGrupoUsuario;
import com.folha.boot.domain.TiposLogradouro;
import com.folha.boot.service.TiposDeGrupoUsuarioService;
import com.folha.boot.service.TiposLogradouroService;

@Controller
@RequestMapping("/tiposDeGrupoUsuario") 
public class TiposDeGrupoUsuarioController {

	@Autowired
	private TiposDeGrupoUsuarioService service;

	@GetMapping("/cadastrar")
	public String cadastrar(TiposDeGrupoUsuario tiposDeGrupoUsuario) {		
		return "/tiposDeGrupoUsuario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("tiposDeGrupoUsuario", service.buscarTodos());
		return "/tiposDeGrupoUsuario/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(TiposDeGrupoUsuario tiposDeGrupoUsuario, RedirectAttributes attr) {
		
		service.salvar(tiposDeGrupoUsuario);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/tiposDeGrupoUsuario/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("tiposDeGrupoUsuario", service.buscarPorId(id));
		return "/tiposDeGrupoUsuario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(TiposDeGrupoUsuario tiposDeGrupoUsuario, RedirectAttributes attr) {
		service.editar(tiposDeGrupoUsuario);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/tiposDeGrupoUsuario/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("tiposDeGrupoUsuario", service.buscarPorNome(nome.toUpperCase().trim()));
		return "/tiposDeGrupoUsuario/lista";
	}
	
	
}
