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
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.seguranca.Permissao;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.seguranca.PermissaoService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/permissao")
public class PermissaoController {

	
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PermissaoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Permissao permissao) {		
		return "/permissao/cadastro";
	}
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("permissao", service.buscarNaUnidade(unidadesService.buscarPorId(idUnidadeLogada)));
		return "/permissao/lista"; 
	}
	*/
	@PostMapping("/salvar")
	public String salvar(Permissao permissao, RedirectAttributes attr) {
		service.salvar(permissao);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/permissao/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("permissao", service.buscarPorId(id));
		return "/permissao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Permissao permissao, RedirectAttributes attr) {
		service.editar(permissao);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/permissao/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		Permissao permissao = service.buscarPorId(id);
		service.salvar(permissao); 
		model.addAttribute("success", "Cancelado com sucesso.");
		return "redirect:/permissao/listar";
	}
	/*
	@GetMapping("/buscar/nome/atividade/escala")
	public String getPorNome(@RequestParam("nomeAtividade") String nomeAtividade, ModelMap model) {	
		model.addAttribute("permissao", service.buscarNaUnidadePorNome( unidadesService.buscarPorId(idUnidadeLogada) ,nomeAtividade.toUpperCase().trim()));
		return "/permissao/lista";
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
			return "redirect:/permissao/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/permissao/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<Permissao> page = service.findPaginated( usuarioService.pegarUnidadeLogada(),pageNo, pageSeze);
		List<Permissao> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<Permissao> page = service.findPaginatedNome( usuarioService.pegarUnidadeLogada(), nome, pageNo, pageSeze);
		List<Permissao> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<Permissao> page, List<Permissao> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("permissao", lista);
		return "/permissao/lista";	
	}

	
	
	
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getUfs() {
		List<Unidades> lista = new ArrayList<Unidades>();
		lista.add(usuarioService.pegarUnidadeLogada());
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
