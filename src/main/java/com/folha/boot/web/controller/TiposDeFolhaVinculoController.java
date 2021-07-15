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
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.TiposDeFolhaVinculo;
import com.folha.boot.domain.Vinculos;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.TiposDeFolhaVinculoService;
import com.folha.boot.service.TiposDeFolhaService;
import com.folha.boot.service.VinculosService;


@Controller
@RequestMapping("/tiposDeFolhaVinculo")
public class TiposDeFolhaVinculoController {

	String ultimoAnoMes = "";
	
	@Autowired
	private TiposDeFolhaVinculoService service;
	@Autowired
	private VinculosService vinculosService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private TiposDeFolhaService tiposDeFolhaService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(TiposDeFolhaVinculo tiposDeFolhaVinculo) {
		
		return "tiposDeFolhaVinculo/cadastro";
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
		Page<TiposDeFolhaVinculo> page = service.findPaginated(pageNo, pageSeze);
		List<TiposDeFolhaVinculo> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 10;
		Page<TiposDeFolhaVinculo> page = service.findPaginatedAnoMes(pageNo, pageSeze, cnes);
		List<TiposDeFolhaVinculo> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<TiposDeFolhaVinculo> page, List<TiposDeFolhaVinculo> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("tiposDeFolhaVinculo", lista);
		return "tiposDeFolhaVinculo/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if( (ultimoAnoMes.equals("")) ){
			return "redirect:/tiposDeFolhaVinculo/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
	
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		return this.findPaginated(1, anoMes, model);
	}
	
	@PostMapping("/salvar")
	public String salvar(TiposDeFolhaVinculo tiposDeFolhaVinculo, RedirectAttributes attr) {
		
		service.salvar(tiposDeFolhaVinculo);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/tiposDeFolhaVinculo/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("tiposDeFolhaVinculo", service.buscarPorId(id));
		return "tiposDeFolhaVinculo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(TiposDeFolhaVinculo tiposDeFolhaVinculo, RedirectAttributes attr) {	
		
		service.editar(tiposDeFolhaVinculo);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/tiposDeFolhaVinculo/listar";
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
		return "redirect:/tiposDeFolhaVinculo/listar" ;
	}
	
	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("tiposDeFolhaVinculo", service.buscarPorNome(nome.toUpperCase().trim()));
		return "tiposDeFolhaVinculo/lista";
	}
	
	
	
	
	@ModelAttribute("idTipoDeFolhaFk")
	public List<TiposDeFolha> getIdTipoDeFolhaFk() {
		return tiposDeFolhaService.buscarTodos();	
	}
	
	
	@ModelAttribute("idVinculoFk")
	public List<Vinculos> getIdNivelFk() {
		return vinculosService.buscarTodos();	
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

