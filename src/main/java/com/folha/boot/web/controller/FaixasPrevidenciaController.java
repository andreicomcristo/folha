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
import com.folha.boot.domain.FaixasImpostoDeRenda;
import com.folha.boot.domain.FaixasPrevidencia;
import com.folha.boot.domain.FaixasPrevidenciaNome;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.FaixasPrevidenciaNomeService;
import com.folha.boot.service.FaixasPrevidenciaSevice;

@Controller
@RequestMapping("/faixasprevidencia")
public class FaixasPrevidenciaController {

	String ultimaBuscaNome = "";
	
	@Autowired
	private FaixasPrevidenciaSevice service;
	@Autowired
	private FaixasPrevidenciaNomeService FaixasPrevidenciaNomeService;
	@Autowired
	private AnoMesService anoMesService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(FaixasPrevidencia faixasPrevidencia) {
		
		return "/faixaprevidencia/cadastro";
	}
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("faixasPrevidencia", service.buscarTodos());
		return "/faixaprevidencia/lista"; 
	}
	*/
	@PostMapping("/salvar")
	public String salvar(FaixasPrevidencia faixasPrevidencia, RedirectAttributes attr) {
		service.salvar(faixasPrevidencia);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/faixasprevidencia/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("faixasPrevidencia", service.buscarPorId(id));
		return "/faixaprevidencia/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(FaixasPrevidencia faixasPrevidencia, RedirectAttributes attr) {	
		service.editar(faixasPrevidencia);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/faixasprevidencia/listar";
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
		return "redirect:/faixasprevidencia/listar" ;
	}
	
	/*
	@GetMapping("/buscar/ano/mes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {		
		model.addAttribute("faixasPrevidencia", service.buscarPorAnoMes(anoMes));
		return "/faixaprevidencia/lista";
	}
	*/
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimaBuscaNome = "";
		return this.findPaginated(1, model);
	}
	
	@GetMapping("/buscar/ano/mes") 
	public String getPorNome(@RequestParam("anoMes") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		return this.findPaginated(1, nome, model);
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorNomePaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if(pageNo<1) {pageNo=1;}
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaNome.equals("")) ){
			return "redirect:/faixasprevidencia/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/faixasprevidencia/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<FaixasPrevidencia> page = service.findPaginated( pageNo, pageSeze);
		List<FaixasPrevidencia> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<FaixasPrevidencia> page = service.findPaginatedNome(  nome, pageNo, pageSeze);
		List<FaixasPrevidencia> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<FaixasPrevidencia> page, List<FaixasPrevidencia> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("faixasPrevidencia", lista);
		return "/faixaprevidencia/lista";	
	}

	
	
	
	
	
	@ModelAttribute("idFaixasPrevidenciaNomeFk")
	public List<FaixasPrevidenciaNome> getIdFaixasPrevidenciaNomeFk() {
		
		return FaixasPrevidenciaNomeService.buscarTodos();
		
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
