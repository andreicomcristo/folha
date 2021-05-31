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
import com.folha.boot.domain.UnidadeAdmiteComplementoPlantao;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.UnidadeAdmiteComplementoPlantaoService;
import com.folha.boot.service.UnidadesService;


@Controller
@RequestMapping("/unidadeAdmiteComplementoPlantao")
public class UnidadeAdmiteComplementoPlantaoController {

	String ultimoAnoMes = "";
	
	@Autowired
	private UnidadeAdmiteComplementoPlantaoService service;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private AnoMesService anoMesService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(UnidadeAdmiteComplementoPlantao unidadeAdmiteComplementoPlantao) {
		
		return "/unidadeAdmiteComplementoPlantao/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimoAnoMes = "";
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		if(pageNo<1) {pageNo=1;}
		Page<UnidadeAdmiteComplementoPlantao> page = service.findPaginated(pageNo, pageSeze);
		List<UnidadeAdmiteComplementoPlantao> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 10;
		Page<UnidadeAdmiteComplementoPlantao> page = service.findPaginatedAnoMes(pageNo, pageSeze, cnes);
		List<UnidadeAdmiteComplementoPlantao> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<UnidadeAdmiteComplementoPlantao> page, List<UnidadeAdmiteComplementoPlantao> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("unidadeAdmiteComplementoPlantao", lista);
		return "/unidadeAdmiteComplementoPlantao/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if( (ultimoAnoMes.equals("")) ){
			return "redirect:/unidadeAdmiteComplementoPlantao/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
	
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		return this.findPaginated(1, anoMes, model);
	}
	
	@PostMapping("/salvar")
	public String salvar(UnidadeAdmiteComplementoPlantao unidadeAdmiteComplementoPlantao, RedirectAttributes attr) {
		
		service.salvar(unidadeAdmiteComplementoPlantao);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/unidadeAdmiteComplementoPlantao/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("unidadeAdmiteComplementoPlantao", service.buscarPorId(id));
		return "/unidadeAdmiteComplementoPlantao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(UnidadeAdmiteComplementoPlantao unidadeAdmiteComplementoPlantao, RedirectAttributes attr) {	
		
		service.editar(unidadeAdmiteComplementoPlantao);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/unidadeAdmiteComplementoPlantao/listar";
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
		return "redirect:/unidadeAdmiteComplementoPlantao/listar" ;
	}
	
	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("unidadeAdmiteComplementoPlantao", service.buscarPorNome(nome.toUpperCase().trim()));
		return "/unidadeAdmiteComplementoPlantao/lista";
	}
	
	
	
	

	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getIdUnidadeFk() {
		
		return unidadesService.buscarTodos();	
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

