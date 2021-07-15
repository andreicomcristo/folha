package com.folha.boot.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.folha.boot.domain.Cargos;
import com.folha.boot.domain.IncrementoDeRiscoUnidadeCargo;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CargosService;
import com.folha.boot.service.IncrementoDeRiscoUnidadeCargoService;
import com.folha.boot.service.UnidadesService;


@Controller
@RequestMapping("/incrementoDeRiscoUnidadeCargo")
public class IncrementoDeRiscoUnidadeCargoController {

	String ultimoAnoMes = "";
	
	@Autowired
	private IncrementoDeRiscoUnidadeCargoService service;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private CargosService cargosService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(IncrementoDeRiscoUnidadeCargo IncrementoDeRiscoUnidadeCargo) {
		
		return "incrementoDeRiscoUnidadeCargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimoAnoMes = "";
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<IncrementoDeRiscoUnidadeCargo> page = service.findPaginated(pageNo, pageSeze);
		List<IncrementoDeRiscoUnidadeCargo> listaCidades = page.getContent();
		return paginar(pageNo, page, listaCidades, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 50;
		Page<IncrementoDeRiscoUnidadeCargo> page = service.findPaginatedAnoMes(pageNo, pageSeze, cnes);
		List<IncrementoDeRiscoUnidadeCargo> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<IncrementoDeRiscoUnidadeCargo> page, List<IncrementoDeRiscoUnidadeCargo> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("incrementoDeRiscoUnidadeCargo", lista);
		return "incrementoDeRiscoUnidadeCargo/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if(pageNo<1) {pageNo = 1;}
		if( (ultimoAnoMes.equals("")) ){
			return "redirect:/incrementoDeRiscoUnidadeCargo/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
	
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		return this.findPaginated(1, anoMes, model);
	}
	
	@PostMapping("/salvar")
	public String salvar(IncrementoDeRiscoUnidadeCargo IncrementoDeRiscoUnidadeCargo, RedirectAttributes attr) {
		
		service.salvar(IncrementoDeRiscoUnidadeCargo);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/incrementoDeRiscoUnidadeCargo/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("incrementoDeRiscoUnidadeCargo", service.buscarPorId(id));
		return "incrementoDeRiscoUnidadeCargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(IncrementoDeRiscoUnidadeCargo IncrementoDeRiscoUnidadeCargo, RedirectAttributes attr) {	
		
		service.editar(IncrementoDeRiscoUnidadeCargo);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/incrementoDeRiscoUnidadeCargo/listar";
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
		return "redirect:/incrementoDeRiscoUnidadeCargo/listar" ;
	}
	
	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("cnesUnidade") String nome, ModelMap model) {		
		model.addAttribute("incrementoDeRiscoUnidadeCargo", service.buscarPorNome(nome.toUpperCase().trim()));
		return "incrementoDeRiscoUnidadeCargo/lista";
	}
	
	@GetMapping("/exporta/excel")
    public void downloadExcel(HttpServletResponse response, ModelMap model) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=dados.xlsx");
        ByteArrayInputStream stream = service.exportarExcel(service.buscarTodos());
        IOUtils.copy(stream, response.getOutputStream());
    }
	
	@GetMapping(value = "/exporta/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {
		ByteArrayInputStream bis = service.exportarPdf(service.buscarTodos());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=dados.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	
	
	
	
	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getIdAnoMesFk() {
		return anoMesService.buscarTodos();	
	}
	@ModelAttribute("idCargoFk")
	public List<Cargos> getIdCargoFk() {
		return cargosService.buscarTodos();	
	}
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getIdUnidadeRegimeFk() {
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

