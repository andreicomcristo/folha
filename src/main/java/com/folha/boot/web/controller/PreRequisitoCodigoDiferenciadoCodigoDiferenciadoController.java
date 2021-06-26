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
import com.folha.boot.domain.seguranca.GrupoUsuario;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.PreRequisitoCodigoDiferenciadoCodigoDiferenciado;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.PreRequisitoCodigoDiferenciadoCodigoDiferenciadoService;
import com.folha.boot.service.seguranca.GrupoUsuarioService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/preRequisitoCodigoDiferenciadoCodigoDiferenciado")
public class PreRequisitoCodigoDiferenciadoCodigoDiferenciadoController {

	
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private GrupoUsuarioService grupoUsuarioService;
	@Autowired
	private CodigoDiferenciadoService codigoDiferenciadoService;
	
	
	
	@Autowired
	private PreRequisitoCodigoDiferenciadoCodigoDiferenciadoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(PreRequisitoCodigoDiferenciadoCodigoDiferenciado preRequisitoCodigoDiferenciadoCodigoDiferenciado) {		
		return "/preRequisitoCodigoDiferenciadoCodigoDiferenciado/cadastro";
	}
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("preRequisitoCodigoDiferenciadoCodigoDiferenciado", service.buscarNaUnidade(unidadesService.buscarPorId(idUnidadeLogada)));
		return "/preRequisitoCodigoDiferenciadoCodigoDiferenciado/lista"; 
	}
	*/
	@PostMapping("/salvar")
	public String salvar(PreRequisitoCodigoDiferenciadoCodigoDiferenciado preRequisitoCodigoDiferenciadoCodigoDiferenciado, RedirectAttributes attr) {
		
		//Vendo se já está cadastrado
		if(service.jaCadastradoConsiderandoId(preRequisitoCodigoDiferenciadoCodigoDiferenciado) ) {
			return "redirect:/preRequisitoCodigoDiferenciadoCodigoDiferenciado/mensagem/de/ja/cadastrado";
		} 
		
		service.salvar(preRequisitoCodigoDiferenciadoCodigoDiferenciado);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/preRequisitoCodigoDiferenciadoCodigoDiferenciado/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("preRequisitoCodigoDiferenciadoCodigoDiferenciado", service.buscarPorId(id));
		return "/preRequisitoCodigoDiferenciadoCodigoDiferenciado/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PreRequisitoCodigoDiferenciadoCodigoDiferenciado preRequisitoCodigoDiferenciadoCodigoDiferenciado, RedirectAttributes attr) {
		
		//Vendo se já está cadastrado
		if(service.jaCadastradoConsiderandoId(preRequisitoCodigoDiferenciadoCodigoDiferenciado) ) {
			return "redirect:/preRequisitoCodigoDiferenciadoCodigoDiferenciado/mensagem/de/ja/cadastrado";
		} 
				
		
		service.editar(preRequisitoCodigoDiferenciadoCodigoDiferenciado);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/preRequisitoCodigoDiferenciadoCodigoDiferenciado/listar";
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
			return "redirect:/preRequisitoCodigoDiferenciadoCodigoDiferenciado/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/preRequisitoCodigoDiferenciadoCodigoDiferenciado/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<PreRequisitoCodigoDiferenciadoCodigoDiferenciado> page = service.findPaginated( pageNo, pageSeze);
		List<PreRequisitoCodigoDiferenciadoCodigoDiferenciado> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 50;
		Page<PreRequisitoCodigoDiferenciadoCodigoDiferenciado> page = service.findPaginatedNome(  nome, pageNo, pageSeze);
		List<PreRequisitoCodigoDiferenciadoCodigoDiferenciado> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<PreRequisitoCodigoDiferenciadoCodigoDiferenciado> page, List<PreRequisitoCodigoDiferenciadoCodigoDiferenciado> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("preRequisitoCodigoDiferenciadoCodigoDiferenciado", lista);
		return "/preRequisitoCodigoDiferenciadoCodigoDiferenciado/lista";	
	}

	
	
	
	
	@GetMapping("/mensagem/de/ja/cadastrado")
	public String mensagemDeNaoEscolha(ModelMap model) {	
		
		model.addAttribute("atencao", "ATENÇÃO");
		model.addAttribute("choque", "JÁ CADASTRADA");
		model.addAttribute("mensagem", "Essca compatibilidade já está cadastrada.");
		
		return "/alertas/jaTemPerfilNaUnidade";
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
