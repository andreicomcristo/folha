package com.folha.boot.web.controller;

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
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.LocalidadeEscala;
import com.folha.boot.service.AtividadeEscalaService;
import com.folha.boot.service.CoordenacaoEscalaService;
import com.folha.boot.service.LocalidadeEscalaService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/coordenacaoescalas")
public class CoordenacaoEscalaController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private CoordenacaoEscalaService service;
	@Autowired
	private AtividadeEscalaService atividadeEscalaservice;
	@Autowired
	private LocalidadeEscalaService localidadeEscalaService;
	@Autowired
	private UnidadesService unidadesService;
	
	
	
	
	String ultimaBuscaNome = "";
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(CoordenacaoEscala conselho) {
		return "coordenacaoescala/cadastro";
	}
	
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("coordenacaoEscala", service.buscarNaUnidade(unidadesService.buscarPorId(idUnidadeLogada)));
		return "coordenacaoescala/lista"; 
	}
	*/
	@PostMapping("/salvar")
	public String salvar(CoordenacaoEscala conselho, RedirectAttributes attr) {
		service.salvar(conselho);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/coordenacaoescalas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("coordenacaoEscala", service.buscarPorId(id));
		return "coordenacaoescala/cadastro";
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
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		CoordenacaoEscala coordenacaoEscala = service.buscarPorId(id);
		coordenacaoEscala.setDtCancelamento(new Date());
		service.salvar(coordenacaoEscala); 
		model.addAttribute("success", "Cancelado com sucesso.");
		return "redirect:/coordenacaoescalas/listar";
	}
	
	/*@GetMapping("/buscar/nome/coordenacao")
	public String getPorNome(@RequestParam("nomeCoordenacao") String nomeCoordenacao, ModelMap model) {		
		model.addAttribute("coordenacaoEscala", service.buscarPorNome(nomeCoordenacao.toUpperCase().trim()));
		return "coordenacaoescala/lista";
	}*/
	
	
	
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
			return "redirect:/coordenacaoescalas/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/coordenacaoescalas/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<CoordenacaoEscala> page = service.findPaginated( usuarioService.pegarUnidadeLogada(),pageNo, pageSeze);
		List<CoordenacaoEscala> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<CoordenacaoEscala> page = service.findPaginatedNome( usuarioService.pegarUnidadeLogada(), nome, pageNo, pageSeze);
		List<CoordenacaoEscala> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<CoordenacaoEscala> page, List<CoordenacaoEscala> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("coordenacaoEscala", lista);
		return "coordenacaoescala/lista";	
	}

	

	
	
	
	
	
	@ModelAttribute("idAtividadeFk")
	public List<AtividadeEscala> getAtividadeEscala() {
		return atividadeEscalaservice.buscarNaUnidade(usuarioService.pegarUnidadeLogada());
	}
	
	@ModelAttribute("idLocalidadeFk")
	public List<LocalidadeEscala> getLocalidadeEscala() {
		return localidadeEscalaService.buscarPorUnidade(usuarioService.pegarUnidadeLogada());
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
