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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.LiberacaoIndividualEscala;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.LiberacaoIndividualEscalaService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/liberacaoIndividualEscala")
public class LiberacaoIndividualEscalaController {

	
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private LiberacaoIndividualEscalaService service;
	@Autowired
	private UnidadesService unidadesService;
	
	@Autowired
	private AnoMesService anoMesService;

	@GetMapping("/cadastrar")
	public String cadastrar(LiberacaoIndividualEscala liberacaoIndividualEscala) {		
		return "liberacaoIndividualEscala/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(LiberacaoIndividualEscala liberacaoIndividualEscala, RedirectAttributes attr) {
	
		liberacaoIndividualEscala.setDtCadastro(new Date());
		liberacaoIndividualEscala.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		
		service.salvar(liberacaoIndividualEscala);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/liberacaoIndividualEscala/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("liberacaoIndividualEscala", service.buscarPorId(id));
		return "liberacaoIndividualEscala/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(LiberacaoIndividualEscala liberacaoIndividualEscala, RedirectAttributes attr) {
		service.editar(liberacaoIndividualEscala);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/liberacaoIndividualEscala/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		LiberacaoIndividualEscala liberacaoIndividualEscala = service.buscarPorId(id);
		liberacaoIndividualEscala.setDtCancelamento(new Date());
		liberacaoIndividualEscala.setIdOperadorCancelamentoFk(usuarioService.pegarOperadorLogado());
		service.salvar(liberacaoIndividualEscala); 
		model.addAttribute("success", "Cancelado com sucesso.");
		return "redirect:/liberacaoIndividualEscala/listar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimaBuscaNome = "";
		return this.findPaginated(1, model);
	}
	
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorNomePaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if(pageNo<1) {pageNo=1;}
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaNome.equals("")) ){
			return "redirect:/liberacaoIndividualEscala/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return "redirect:/liberacaoIndividualEscala/listar/{pageNo}" ;}
			else {
				return "redirect:/liberacaoIndividualEscala/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<LiberacaoIndividualEscala> page = service.findPaginated( pageNo, pageSeze);
		List<LiberacaoIndividualEscala> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	
	
	
	public String paginar(int pageNo, Page<LiberacaoIndividualEscala> page, List<LiberacaoIndividualEscala> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("liberacaoIndividualEscala", lista);
		return "liberacaoIndividualEscala/lista";	
	}

	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getMes() {
		return anoMesService.buscarTodos();
	}	
	
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getUfs() {
		return unidadesService.buscarTodos();
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
