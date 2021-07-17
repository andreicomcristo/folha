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

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.domain.LimiteHorasAcrescimoPorUnidadeEEspecialidade;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CargosEspecialidadeService;
import com.folha.boot.service.LimiteHorasAcrescimoPorUnidadeEEspecialidadeService;
import com.folha.boot.service.UnidadesService;

@Controller
@RequestMapping("/limiteHorasAcrescimoPorUnidadeEEspecialidade")
public class LimiteHorasAcrescimoPorUnidadeEEspecialidadeController {

	
	String ultimaBuscaNome = "";
	
	@Autowired
	private CargosEspecialidadeService cargosEspecialidadeService;
	@Autowired
	private AnoMesService anoMesService;
	
	@Autowired
	private LimiteHorasAcrescimoPorUnidadeEEspecialidadeService service;
	@Autowired
	private UnidadesService unidadesService;

	@GetMapping("/cadastrar")
	public String cadastrar(LimiteHorasAcrescimoPorUnidadeEEspecialidade limiteHorasAcrescimoPorUnidadeEEspecialidade) {		
		return "limiteHorasAcrescimoPorUnidadeEEspecialidade/cadastro";
	}
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("limiteHorasAcrescimoPorUnidadeEEspecialidade", service.buscarNaUnidade(unidadesService.buscarPorId(idUnidadeLogada)));
		return "limiteHorasAcrescimoPorUnidadeEEspecialidade/lista"; 
	}
	*/
	@PostMapping("/salvar")
	public String salvar(LimiteHorasAcrescimoPorUnidadeEEspecialidade limiteHorasAcrescimoPorUnidadeEEspecialidade, RedirectAttributes attr) {
		if(limiteHorasAcrescimoPorUnidadeEEspecialidade.getHoras()==null) {limiteHorasAcrescimoPorUnidadeEEspecialidade.setHoras(0);}
		service.salvar(limiteHorasAcrescimoPorUnidadeEEspecialidade);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/limiteHorasAcrescimoPorUnidadeEEspecialidade/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("limiteHorasAcrescimoPorUnidadeEEspecialidade", service.buscarPorId(id));
		return "limiteHorasAcrescimoPorUnidadeEEspecialidade/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(LimiteHorasAcrescimoPorUnidadeEEspecialidade limiteHorasAcrescimoPorUnidadeEEspecialidade, RedirectAttributes attr) {
		service.editar(limiteHorasAcrescimoPorUnidadeEEspecialidade);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/limiteHorasAcrescimoPorUnidadeEEspecialidade/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	
	@GetMapping("/herdar/de/mes") 
	public String herdarDeMes( Long anoMesInicial,  Long anoMesFinal,  ModelMap model) {		
		service.herdarDeUmMesParaOOutro(anoMesInicial, anoMesFinal);
		return "redirect:/limiteHorasAcrescimoPorUnidadeEEspecialidade/listar" ;
	}
	
	/*
	@GetMapping("/buscar/nome/atividade/escala")
	public String getPorNome(@RequestParam("nomeAtividade") String nomeAtividade, ModelMap model) {	
		model.addAttribute("limiteHorasAcrescimoPorUnidadeEEspecialidade", service.buscarNaUnidadePorNome( unidadesService.buscarPorId(idUnidadeLogada) ,nomeAtividade.toUpperCase().trim()));
		return "limiteHorasAcrescimoPorUnidadeEEspecialidade/lista";
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
			return "redirect:/limiteHorasAcrescimoPorUnidadeEEspecialidade/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/limiteHorasAcrescimoPorUnidadeEEspecialidade/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<LimiteHorasAcrescimoPorUnidadeEEspecialidade> page = service.findPaginated( pageNo, pageSeze);
		List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<LimiteHorasAcrescimoPorUnidadeEEspecialidade> page = service.findPaginatedUnidade(  nome, pageNo, pageSeze);
		List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<LimiteHorasAcrescimoPorUnidadeEEspecialidade> page, List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("limiteHorasAcrescimoPorUnidadeEEspecialidade", lista);
		return "limiteHorasAcrescimoPorUnidadeEEspecialidade/lista";	
	}

	
	
	
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getUnidades() {
		return unidadesService.buscarTodos();
	}	
	@ModelAttribute("idEspecialidadeFk")
	public List<CargosEspecialidade> getIdEspecialidadeFk() {
		return cargosEspecialidadeService.buscarTodos();
	}	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getIdAnoMesFk() {
		return anoMesService.buscarTodos();
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
