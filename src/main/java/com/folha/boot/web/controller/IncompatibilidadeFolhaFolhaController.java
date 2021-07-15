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
import com.folha.boot.domain.IncompatibilidadeFolhaFolha;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.service.IncompatibilidadeFolhaFolhaService;
import com.folha.boot.service.TiposDeFolhaService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/incompatibilidadeFolhaFolha")
public class IncompatibilidadeFolhaFolhaController {

	
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TiposDeFolhaService tiposDeFolhaService;
	
	
	
	@Autowired
	private IncompatibilidadeFolhaFolhaService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(IncompatibilidadeFolhaFolha incompatibilidadeFolhaFolha) {		
		return "incompatibilidadeFolhaFolha/cadastro";
	}
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("incompatibilidadeFolhaFolha", service.buscarNaUnidade(unidadesService.buscarPorId(idUnidadeLogada)));
		return "incompatibilidadeFolhaFolha/lista"; 
	}
	*/
	@PostMapping("/salvar")
	public String salvar(IncompatibilidadeFolhaFolha incompatibilidadeFolhaFolha, RedirectAttributes attr) {
		
		//Vendo se já está cadastrado
		if(service.jaCadastradoConsiderandoId(incompatibilidadeFolhaFolha) ) {
			return "redirect:/incompatibilidadeFolhaFolha/mensagem/de/ja/cadastrado";
		} 
		
		service.salvar(incompatibilidadeFolhaFolha);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/incompatibilidadeFolhaFolha/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("incompatibilidadeFolhaFolha", service.buscarPorId(id));
		return "incompatibilidadeFolhaFolha/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(IncompatibilidadeFolhaFolha incompatibilidadeFolhaFolha, RedirectAttributes attr) {
		
		//Vendo se já está cadastrado
		if(service.jaCadastradoConsiderandoId(incompatibilidadeFolhaFolha) ) {
			return "redirect:/incompatibilidadeFolhaFolha/mensagem/de/ja/cadastrado";
		} 
				
		
		service.editar(incompatibilidadeFolhaFolha);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/incompatibilidadeFolhaFolha/listar";
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
			return "redirect:/incompatibilidadeFolhaFolha/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/incompatibilidadeFolhaFolha/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<IncompatibilidadeFolhaFolha> page = service.findPaginated( pageNo, pageSeze);
		List<IncompatibilidadeFolhaFolha> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 50;
		Page<IncompatibilidadeFolhaFolha> page = service.findPaginatedNome(  nome, pageNo, pageSeze);
		List<IncompatibilidadeFolhaFolha> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<IncompatibilidadeFolhaFolha> page, List<IncompatibilidadeFolhaFolha> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("incompatibilidadeFolhaFolha", lista);
		return "incompatibilidadeFolhaFolha/lista";	
	}

	
	
	
	
	@GetMapping("/mensagem/de/ja/cadastrado")
	public String mensagemDeNaoEscolha(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "JÁ CADASTRADA");
		model.addAttribute("mensagem", "Essa compatibilidade já está cadastrada.");
		
		return "alertas/jaTemPerfilNaUnidade";
	}
	
	
	
	
	@ModelAttribute("idFolhaFk")
	public List<TiposDeFolha> getidFolhaFk() {
		List<TiposDeFolha> lista = tiposDeFolhaService.buscarTodos();
		return lista; 
	}	
	
	@ModelAttribute("idFolhaIncompativelFk")
	public List<TiposDeFolha> getidFolhaIncompativelFk() {
		List<TiposDeFolha> lista = tiposDeFolhaService.buscarTodos();
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
