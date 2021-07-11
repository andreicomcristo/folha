package com.folha.boot.web.controller;

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

import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Cids;
import com.folha.boot.domain.Uf;
import com.folha.boot.service.CidsService;

@Controller
@RequestMapping("/cids")
public class CidsController {

	String ultimaBuscaCodigo = "";
	String ultimaBuscaDescricao = "";
	
	@Autowired
	private CidsService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Cids cids) {		
		return "/cid/cadastro";
	}
		
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimaBuscaCodigo = "";
		this.ultimaBuscaDescricao = "";
		return this.findPaginated(1, model);
	}
	
	@PostMapping("/salvar")
	public String salvar(Cids cids, RedirectAttributes attr) {
		service.salvar(cids);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/cids/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cids", service.buscarPorId(id));
		return "/cid/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Cids cids, RedirectAttributes attr) {
		service.editar(cids);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/cids/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/codcid")
	public String getPorNome(@RequestParam("codCid") String codCid, ModelMap model) {		
		model.addAttribute("cids", service.buscarPorNome(codCid.toUpperCase().trim()));
		return "/cid/lista";
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorNomePaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaCodigo.equals("")) && (ultimaBuscaDescricao.equals("")) ){
			return "redirect:/cids/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaCodigo.equals("")) {
				return this.findPaginatedCodigo(pageNo, ultimaBuscaCodigo, model);}
			else {
				return this.findPaginatedDescricao(pageNo, ultimaBuscaDescricao, model);}
			}
	}
		
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<Cids> page = service.findPaginated(pageNo, pageSeze);
		List<Cids> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginatedCodigo(@PathVariable (value = "pageNo") int pageNo, String codigo, ModelMap model) {
		int pageSeze = 10;
		Page<Cids> page = service.findPaginatedCodigo(pageNo, pageSeze, codigo);
		List<Cids> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginatedDescricao(@PathVariable (value = "pageNo") int pageNo, String descricao, ModelMap model) {
		int pageSeze = 10;
		Page<Cids> page = service.findPaginatedDescricao(pageNo, pageSeze, descricao);
		List<Cids> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<Cids> page, List<Cids> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("cids", lista);
		return "/cid/lista";	
	}
	
	@GetMapping("/buscar/codigo")
	public String getPorCodigo(@RequestParam("codigo") String codigo, ModelMap model) {
		this.ultimaBuscaCodigo = codigo;
		this.ultimaBuscaDescricao = "";	
		return this.findPaginatedCodigo(1, codigo, model);
	}
	
	@GetMapping("/buscar/descricao")
	public String getPorDescricao(@RequestParam("descricao") String descricao, ModelMap model) {
		this.ultimaBuscaCodigo = "";
		this.ultimaBuscaDescricao = descricao;	
		return this.findPaginatedDescricao(1, descricao, model);
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
