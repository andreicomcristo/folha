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

import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.domain.GrupoUsuario;
import com.folha.boot.domain.TiposDeGrupoUsuario;
import com.folha.boot.service.BancosService;
import com.folha.boot.service.GrupoUsuarioService;
import com.folha.boot.service.TiposDeGrupoUsuarioService;

@Controller
@RequestMapping("/grupousuario")
public class GrupoUsuarioController {
	
	@Autowired
	private GrupoUsuarioService service;
	@Autowired
	private TiposDeGrupoUsuarioService tiposDeGrupoUsuarioService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(GrupoUsuario grupoUsuario) {
		return "/grupousuario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("grupoUsuario", service.buscarTodos());
		return "/grupousuario/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(GrupoUsuario grupoUsuario, RedirectAttributes attr) {
		service.salvar(grupoUsuario);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/grupousuario/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("grupoUsuario", service.buscarPorId(id));
		
		return "/grupousuario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(GrupoUsuario grupoUsuario, RedirectAttributes attr) {
		service.salvar(grupoUsuario);		
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/grupousuario/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("grupoUsuario", service.buscarPorNome(nome));
		return "/grupousuario/lista";
	}
	
	@ModelAttribute("idTipoGrupoUsuarioFk")
	public List<TiposDeGrupoUsuario> getIdTipoGrupoUsuarioFk() {
		return tiposDeGrupoUsuarioService.buscarTodos();
	}
	
	
	
}
