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
import com.folha.boot.domain.UnidadeAdmiteChDif;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.FaixasValoresParametrosCalculoFolhasExtrasService;
import com.folha.boot.service.NiveisCargoService;
import com.folha.boot.service.RegimesDeTrabalhoService;
import com.folha.boot.service.TiposDeFolhaService;
import com.folha.boot.service.UnidadeAdmiteChDifService;
import com.folha.boot.service.UnidadesService;


@Controller
@RequestMapping("/unidadeAdmiteChDif")
public class UnidadeAdmiteChDifController {

	String ultimoAnoMes = "";
	
	@Autowired
	private UnidadeAdmiteChDifService service;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private AnoMesService anoMesService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(UnidadeAdmiteChDif unidadeAdmiteChDif) {
		
		return "/unidadeAdmiteChDif/cadastro";
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
		Page<UnidadeAdmiteChDif> page = service.findPaginated(pageNo, pageSeze);
		List<UnidadeAdmiteChDif> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 10;
		Page<UnidadeAdmiteChDif> page = service.findPaginatedAnoMes(pageNo, pageSeze, cnes);
		List<UnidadeAdmiteChDif> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<UnidadeAdmiteChDif> page, List<UnidadeAdmiteChDif> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("unidadeAdmiteChDif", lista);
		return "/unidadeAdmiteChDif/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if( (ultimoAnoMes.equals("")) ){
			return "redirect:/unidadeAdmiteChDif/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
	
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		return this.findPaginated(1, anoMes, model);
	}
	
	@PostMapping("/salvar")
	public String salvar(UnidadeAdmiteChDif unidadeAdmiteChDif, RedirectAttributes attr) {
		
		service.salvar(unidadeAdmiteChDif);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/unidadeAdmiteChDif/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("unidadeAdmiteChDif", service.buscarPorId(id));
		return "/unidadeAdmiteChDif/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(UnidadeAdmiteChDif unidadeAdmiteChDif, RedirectAttributes attr) {	
		
		service.editar(unidadeAdmiteChDif);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/unidadeAdmiteChDif/listar";
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
		return "redirect:/unidadeAdmiteChDif/listar" ;
	}
	
	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("unidadeAdmiteChDif", service.buscarPorNome(nome.toUpperCase().trim()));
		return "/unidadeAdmiteChDif/lista";
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

