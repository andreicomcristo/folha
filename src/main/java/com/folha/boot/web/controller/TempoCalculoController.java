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

import com.folha.boot.domain.TempoCalculo;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.TempoCalculoService;


@Controller
@RequestMapping("/tempoCalculo")
public class TempoCalculoController {

	
	
	@Autowired
	private TempoCalculoService service;
	
	@Autowired
	private AnoMesService anoMesService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(TempoCalculo tempoCalculo) {
		
		return "tempoCalculo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		if(pageNo<1) {pageNo=1;}
		Page<TempoCalculo> page = service.findPaginated(pageNo, pageSeze);
		List<TempoCalculo> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<TempoCalculo> page, List<TempoCalculo> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("tempoCalculo", lista);
		return "tempoCalculo/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
			return "redirect:/tempoCalculo/listar/{pageNo}" ;
		
	}
	
	
	
	@PostMapping("/salvar")
	public String salvar(TempoCalculo tempoCalculo, RedirectAttributes attr) {
		
		if(tempoCalculo.getSegundos()==null) {
			tempoCalculo.setSegundos(0.0);
		}
		
		
		service.salvar(tempoCalculo);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/tempoCalculo/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("tempoCalculo", service.buscarPorId(id));
		return "tempoCalculo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(TempoCalculo tempoCalculo, RedirectAttributes attr) {	
		
		if(tempoCalculo.getSegundos()==null) {
			tempoCalculo.setSegundos(0.0);
		}
		
		
		service.editar(tempoCalculo);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/tempoCalculo/listar";
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

