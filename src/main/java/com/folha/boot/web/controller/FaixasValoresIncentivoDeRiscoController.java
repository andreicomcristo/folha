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
import com.folha.boot.domain.FaixasValoresIncentivoDeRisco;
import com.folha.boot.domain.Fonte;
import com.folha.boot.domain.TipoBrutoLiquido;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CargaHorariaSemanalService;
import com.folha.boot.service.CarreirasService;
import com.folha.boot.service.ClassesCarreiraService;
import com.folha.boot.service.FaixasValoresIncentivoDeRiscoService;
import com.folha.boot.service.FonteService;
import com.folha.boot.service.TipoBrutoLiquidoService;
import com.folha.boot.service.UnidadesRegimeService;
import com.folha.boot.service.UnidadesService;


@Controller
@RequestMapping("/faixasValoresIncentivoDeRisco")
public class FaixasValoresIncentivoDeRiscoController {

	String ultimoAnoMes = "";
	
	@Autowired
	private FaixasValoresIncentivoDeRiscoService service;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private FonteService fonteService;
	@Autowired
	private TipoBrutoLiquidoService tipoBrutoLiquidoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(FaixasValoresIncentivoDeRisco faixasValoresIncentivoDeRisco) {
		
		return "/faixasValoresIncentivoDeRisco/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimoAnoMes = "";
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<FaixasValoresIncentivoDeRisco> page = service.findPaginated(pageNo, pageSeze);
		List<FaixasValoresIncentivoDeRisco> listaCidades = page.getContent();
		return paginar(pageNo, page, listaCidades, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 50;
		Page<FaixasValoresIncentivoDeRisco> page = service.findPaginatedAnoMes(pageNo, pageSeze, cnes);
		List<FaixasValoresIncentivoDeRisco> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<FaixasValoresIncentivoDeRisco> page, List<FaixasValoresIncentivoDeRisco> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("faixasValoresIncentivoDeRisco", lista);
		return "/faixasValoresIncentivoDeRisco/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if(pageNo<1) {pageNo = 1;}
		if( (ultimoAnoMes.equals("")) ){
			return "redirect:/faixasValoresIncentivoDeRisco/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
	
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		return this.findPaginated(1, anoMes, model);
	}
	
	@PostMapping("/salvar")
	public String salvar(FaixasValoresIncentivoDeRisco faixasValoresIncentivoDeRisco, RedirectAttributes attr) {
		
		if(faixasValoresIncentivoDeRisco.getValor()==null) {
			faixasValoresIncentivoDeRisco.setValor(0.0);
		}
		
		service.salvar(faixasValoresIncentivoDeRisco);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/faixasValoresIncentivoDeRisco/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("faixasValoresIncentivoDeRisco", service.buscarPorId(id));
		return "/faixasValoresIncentivoDeRisco/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(FaixasValoresIncentivoDeRisco faixasValoresIncentivoDeRisco, RedirectAttributes attr) {	
		
		if(faixasValoresIncentivoDeRisco.getValor()==null) {
			faixasValoresIncentivoDeRisco.setValor(0.0);
		}
		
		service.editar(faixasValoresIncentivoDeRisco);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/faixasValoresIncentivoDeRisco/listar";
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
		return "redirect:/faixasValoresIncentivoDeRisco/listar" ;
	}
	
	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("cnesUnidade") String nome, ModelMap model) {		
		model.addAttribute("faixasValoresIncentivoDeRisco", service.buscarPorNome(nome.toUpperCase().trim()));
		return "/faixasValoresIncentivoDeRisco/lista";
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
	
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getIdUnidadeRegimeFk() {
		return unidadesService.buscarTodos();	
	}
	@ModelAttribute("idFonteFk")
	public List<Fonte> getIdFonteFk() {
		return fonteService.buscarTodos();
	}
	
	@ModelAttribute("idTipoBrutoLiquidoFk")
	public List<TipoBrutoLiquido> getIdTipoBrutoLiquidoFk() {
		return tipoBrutoLiquidoService.buscarTodos();
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

