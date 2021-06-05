package com.folha.boot.web.controller.seguranca;

import java.util.ArrayList;
import java.util.Date;
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
import com.folha.boot.domain.seguranca.GrupoUsuarioPermissao;
import com.folha.boot.domain.seguranca.Permissao;
import com.folha.boot.service.seguranca.GrupoUsuarioPermissaoService;
import com.folha.boot.service.seguranca.GrupoUsuarioService;
import com.folha.boot.service.seguranca.PermissaoService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/grupoUsuarioPermissao")
public class GrupoUsuarioPermissaoController {

	
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private GrupoUsuarioService grupoUsuarioService;
	@Autowired
	private PermissaoService permissaoService;
	
	
	@Autowired
	private GrupoUsuarioPermissaoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(GrupoUsuarioPermissao grupoUsuarioPermissao) {		
		return "/grupoUsuarioPermissao/cadastro";
	}
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("grupoUsuarioPermissao", service.buscarNaUnidade(unidadesService.buscarPorId(idUnidadeLogada)));
		return "/grupoUsuarioPermissao/lista"; 
	}
	*/
	@PostMapping("/salvar")
	public String salvar(GrupoUsuarioPermissao grupoUsuarioPermissao, RedirectAttributes attr) {
		service.salvar(grupoUsuarioPermissao);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/grupoUsuarioPermissao/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("grupoUsuarioPermissao", service.buscarPorId(id));
		return "/grupoUsuarioPermissao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(GrupoUsuarioPermissao grupoUsuarioPermissao, RedirectAttributes attr) {
		service.editar(grupoUsuarioPermissao);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/grupoUsuarioPermissao/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		GrupoUsuarioPermissao grupoUsuarioPermissao = service.buscarPorId(id);
		service.salvar(grupoUsuarioPermissao); 
		model.addAttribute("success", "Cancelado com sucesso.");
		return "redirect:/grupoUsuarioPermissao/listar";
	}
	/*
	@GetMapping("/buscar/nome/atividade/escala")
	public String getPorNome(@RequestParam("nomeAtividade") String nomeAtividade, ModelMap model) {	
		model.addAttribute("grupoUsuarioPermissao", service.buscarNaUnidadePorNome( unidadesService.buscarPorId(idUnidadeLogada) ,nomeAtividade.toUpperCase().trim()));
		return "/grupoUsuarioPermissao/lista";
	}
	*/
	
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
			return "redirect:/grupoUsuarioPermissao/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/grupoUsuarioPermissao/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<GrupoUsuarioPermissao> page = service.findPaginated( pageNo, pageSeze);
		List<GrupoUsuarioPermissao> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<GrupoUsuarioPermissao> page = service.findPaginatedNome(  nome, pageNo, pageSeze);
		List<GrupoUsuarioPermissao> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<GrupoUsuarioPermissao> page, List<GrupoUsuarioPermissao> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("grupoUsuarioPermissao", lista);
		return "/grupoUsuarioPermissao/lista";	
	}

	
	
	
	@ModelAttribute("idGrupoUsuarioFk")
	public List<GrupoUsuario> getidGrupoUsuarioFk() {
		List<GrupoUsuario> lista = grupoUsuarioService.buscarTodos();
		return lista;
	}	
	
	@ModelAttribute("idPermissaoFk")
	public List<Permissao> getidPermissaoFk() {
		List<Permissao> lista = permissaoService.buscarTodos();
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
