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

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.DiasLicencaMaternidade;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.DiasLicencaMaternidadeService;


@Controller
@RequestMapping("/diasLicencaMaternidade")
public class DiasLicencaMaternidadeController {

	
	
	@Autowired
	private DiasLicencaMaternidadeService service;
	
	@Autowired
	private AnoMesService anoMesService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(DiasLicencaMaternidade diasLicencaMaternidade) {
		
		return "diasLicencaMaternidade/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		if(pageNo<1) {pageNo=1;}
		Page<DiasLicencaMaternidade> page = service.findPaginated(pageNo, pageSeze);
		List<DiasLicencaMaternidade> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<DiasLicencaMaternidade> page, List<DiasLicencaMaternidade> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("diasLicencaMaternidade", lista);
		return "diasLicencaMaternidade/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
			return "redirect:/diasLicencaMaternidade/listar/{pageNo}" ;
		
	}
	
	
	
	@PostMapping("/salvar")
	public String salvar(DiasLicencaMaternidade diasLicencaMaternidade, RedirectAttributes attr) {
		
		if(diasLicencaMaternidade.getDias()==null) {
			diasLicencaMaternidade.setDias(0);
		}
		
		
		service.salvar(diasLicencaMaternidade);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/diasLicencaMaternidade/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("diasLicencaMaternidade", service.buscarPorId(id));
		return "diasLicencaMaternidade/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(DiasLicencaMaternidade diasLicencaMaternidade, RedirectAttributes attr) {	
		
		if(diasLicencaMaternidade.getDias()==null) {
			diasLicencaMaternidade.setDias(0);
		}
		
		
		service.editar(diasLicencaMaternidade);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/diasLicencaMaternidade/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
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

