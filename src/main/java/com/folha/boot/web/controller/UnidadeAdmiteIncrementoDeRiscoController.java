package com.folha.boot.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.FaixasPrevidencia;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.UnidadeAdmiteIncrementoDeRisco;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.FaixasValoresParametrosCalculoFolhasExtrasService;
import com.folha.boot.service.NiveisCargoService;
import com.folha.boot.service.RegimesDeTrabalhoService;
import com.folha.boot.service.TiposDeFolhaService;
import com.folha.boot.service.UnidadeAdmiteIncrementoDeRiscoService;
import com.folha.boot.service.UnidadesService;


@Controller
@RequestMapping("/unidadeAdmiteIncrementoDeRisco")
public class UnidadeAdmiteIncrementoDeRiscoController {

	String ultimoAnoMes = "";
	
	@Autowired
	private UnidadeAdmiteIncrementoDeRiscoService service;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private AnoMesService anoMesService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(UnidadeAdmiteIncrementoDeRisco unidadeAdmiteIncrementoDeRisco) {
		
		return "/unidadeAdmiteIncrementoDeRisco/cadastro";
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
		Page<UnidadeAdmiteIncrementoDeRisco> page = service.findPaginated(pageNo, pageSeze);
		List<UnidadeAdmiteIncrementoDeRisco> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 10;
		Page<UnidadeAdmiteIncrementoDeRisco> page = service.findPaginatedAnoMes(pageNo, pageSeze, cnes);
		List<UnidadeAdmiteIncrementoDeRisco> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<UnidadeAdmiteIncrementoDeRisco> page, List<UnidadeAdmiteIncrementoDeRisco> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("unidadeAdmiteIncrementoDeRisco", lista);
		return "/unidadeAdmiteIncrementoDeRisco/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if( (ultimoAnoMes.equals("")) ){
			return "redirect:/unidadeAdmiteIncrementoDeRisco/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
	
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		return this.findPaginated(1, anoMes, model);
	}
	
	@PostMapping("/salvar")
	public String salvar(UnidadeAdmiteIncrementoDeRisco unidadeAdmiteIncrementoDeRisco, RedirectAttributes attr) {
		
		service.salvar(unidadeAdmiteIncrementoDeRisco);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/unidadeAdmiteIncrementoDeRisco/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("unidadeAdmiteIncrementoDeRisco", service.buscarPorId(id));
		return "/unidadeAdmiteIncrementoDeRisco/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(UnidadeAdmiteIncrementoDeRisco unidadeAdmiteIncrementoDeRisco, RedirectAttributes attr) {	
		
		service.editar(unidadeAdmiteIncrementoDeRisco);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/unidadeAdmiteIncrementoDeRisco/listar";
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
		return "redirect:/unidadeAdmiteIncrementoDeRisco/listar" ;
	}
	
	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("unidadeAdmiteIncrementoDeRisco", service.buscarPorNome(nome.toUpperCase().trim()));
		return "/unidadeAdmiteIncrementoDeRisco/lista";
	}
	
	
	
	

	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getIdUnidadeFk() {
		
		return unidadesService.buscarTodos();	
	}
	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getIdAnoMesFk() {
		return anoMesService.buscarTodos();	
	}
}

