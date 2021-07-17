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

import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.IncompatibilidadeCodigoDiferenciadoCodigoDiferenciadoService;
import com.folha.boot.service.seguranca.GrupoUsuarioService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/incompatibilidadeCodigoDiferenciadoCodigoDiferenciado")
public class IncompatibilidadeCodigoDiferenciadoCodigoDiferenciadoController {

	
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private GrupoUsuarioService grupoUsuarioService;
	@Autowired
	private CodigoDiferenciadoService codigoDiferenciadoService;
	
	
	
	@Autowired
	private IncompatibilidadeCodigoDiferenciadoCodigoDiferenciadoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado incompatibilidadeCodigoDiferenciadoCodigoDiferenciado) {		
		return "incompatibilidadeCodigoDiferenciadoCodigoDiferenciado/cadastro";
	}
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("incompatibilidadeCodigoDiferenciadoCodigoDiferenciado", service.buscarNaUnidade(unidadesService.buscarPorId(idUnidadeLogada)));
		return "incompatibilidadeCodigoDiferenciadoCodigoDiferenciado/lista"; 
	}
	*/
	@PostMapping("/salvar")
	public String salvar(IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado incompatibilidadeCodigoDiferenciadoCodigoDiferenciado, RedirectAttributes attr) {
		
		//Vendo se já está cadastrado
		if(service.jaCadastradoConsiderandoId(incompatibilidadeCodigoDiferenciadoCodigoDiferenciado) ) {
			return "redirect:/incompatibilidadeCodigoDiferenciadoCodigoDiferenciado/mensagem/de/ja/cadastrado";
		} 
		
		service.salvar(incompatibilidadeCodigoDiferenciadoCodigoDiferenciado);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/incompatibilidadeCodigoDiferenciadoCodigoDiferenciado/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("incompatibilidadeCodigoDiferenciadoCodigoDiferenciado", service.buscarPorId(id));
		return "incompatibilidadeCodigoDiferenciadoCodigoDiferenciado/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado incompatibilidadeCodigoDiferenciadoCodigoDiferenciado, RedirectAttributes attr) {
		
		//Vendo se já está cadastrado
		if(service.jaCadastradoConsiderandoId(incompatibilidadeCodigoDiferenciadoCodigoDiferenciado) ) {
			return "redirect:/incompatibilidadeCodigoDiferenciadoCodigoDiferenciado/mensagem/de/ja/cadastrado";
		} 
				
		
		service.editar(incompatibilidadeCodigoDiferenciadoCodigoDiferenciado);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/incompatibilidadeCodigoDiferenciadoCodigoDiferenciado/listar";
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
			return "redirect:/incompatibilidadeCodigoDiferenciadoCodigoDiferenciado/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/incompatibilidadeCodigoDiferenciadoCodigoDiferenciado/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado> page = service.findPaginated( pageNo, pageSeze);
		List<IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 50;
		Page<IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado> page = service.findPaginatedNome(  nome, pageNo, pageSeze);
		List<IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado> page, List<IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("incompatibilidadeCodigoDiferenciadoCodigoDiferenciado", lista);
		return "incompatibilidadeCodigoDiferenciadoCodigoDiferenciado/lista";	
	}

	
	
	
	
	@GetMapping("/mensagem/de/ja/cadastrado")
	public String mensagemDeNaoEscolha(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "JÁ CADASTRADA");
		model.addAttribute("mensagem", "Essca compatibilidade já está cadastrada.");
		
		return "alertas/jaTemPerfilNaUnidade";
	}
	
	
	
	
	@ModelAttribute("idCodigoDiferenciadoFk")
	public List<CodigoDiferenciado> getidGrupoUsuarioFk() {
		List<CodigoDiferenciado> lista = codigoDiferenciadoService.buscarTodosGeral();
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
