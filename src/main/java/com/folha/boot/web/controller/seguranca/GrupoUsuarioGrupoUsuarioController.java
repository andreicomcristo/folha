package com.folha.boot.web.controller.seguranca;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.folha.boot.domain.seguranca.GrupoUsuario;
import com.folha.boot.domain.seguranca.GrupoUsuarioGrupoUsuario;
import com.folha.boot.service.seguranca.GrupoUsuarioGrupoUsuarioService;
import com.folha.boot.service.seguranca.GrupoUsuarioService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/grupoUsuarioGrupoUsuario")
public class GrupoUsuarioGrupoUsuarioController {

	
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private GrupoUsuarioService grupoUsuarioService;
	
	
	
	@Autowired
	private GrupoUsuarioGrupoUsuarioService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(GrupoUsuarioGrupoUsuario grupoUsuarioGrupoUsuario) {		
		return "/grupoUsuarioGrupoUsuario/cadastro";
	}
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("grupoUsuarioGrupoUsuario", service.buscarNaUnidade(unidadesService.buscarPorId(idUnidadeLogada)));
		return "/grupoUsuarioGrupoUsuario/lista"; 
	}
	*/
	@PostMapping("/salvar")
	public String salvar(GrupoUsuarioGrupoUsuario grupoUsuarioGrupoUsuario, RedirectAttributes attr) {
		service.salvar(grupoUsuarioGrupoUsuario);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/grupoUsuarioGrupoUsuario/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("grupoUsuarioGrupoUsuario", service.buscarPorId(id));
		return "/grupoUsuarioGrupoUsuario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(GrupoUsuarioGrupoUsuario grupoUsuarioGrupoUsuario, RedirectAttributes attr) {
		service.editar(grupoUsuarioGrupoUsuario);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/grupoUsuarioGrupoUsuario/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimaBuscaNome = "";
		return this.findPaginated(1, model);
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		return this.findPaginated(1, nome, model);
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorNomePaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if(pageNo<1) {pageNo=1;}
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaNome.equals("")) ){
			return "redirect:/grupoUsuarioGrupoUsuario/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/grupoUsuarioGrupoUsuario/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<GrupoUsuarioGrupoUsuario> page = service.findPaginated( pageNo, pageSeze);
		List<GrupoUsuarioGrupoUsuario> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 50;
		Page<GrupoUsuarioGrupoUsuario> page = service.findPaginatedNome(  nome, pageNo, pageSeze);
		List<GrupoUsuarioGrupoUsuario> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<GrupoUsuarioGrupoUsuario> page, List<GrupoUsuarioGrupoUsuario> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("grupoUsuarioGrupoUsuario", lista);
		return "/grupoUsuarioGrupoUsuario/lista";	
	}

	
	
	
	@ModelAttribute("idGrupoUsuarioFk")
	public List<GrupoUsuario> getidGrupoUsuarioFk() {
		List<GrupoUsuario> lista = grupoUsuarioService.buscarTodos();
		return lista;
	}	
	
	@ModelAttribute("idGrupoUsuarioCompativelFk")
	public List<GrupoUsuario> getidGrupoUsuarioCompativelFk() {
		List<GrupoUsuario> lista = grupoUsuarioService.buscarTodos();
		return lista;
	}	
	
	
	@Autowired
	HttpServletRequest request;
	@ModelAttribute("nomeOperadorLogado")
	public String operadorLogado() {
		return request.getSession().getAttribute("operador").toString();
	}
	@ModelAttribute("nomeUnidadeLogada")
	public String unidadeLogada() {
		return request.getSession().getAttribute("unidade").toString();
	}
	
}
