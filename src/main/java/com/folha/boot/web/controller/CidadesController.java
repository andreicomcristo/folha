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

import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Paises;
import com.folha.boot.domain.Uf;
import com.folha.boot.service.CidadesService;
import com.folha.boot.service.PaisesSevice;
import com.folha.boot.service.UfService;
import com.folha.boot.service.testeIlo.RelatorioIloService;

@Controller
@RequestMapping("/cidades")
public class CidadesController {

	String ultimaBuscaCidade = "";
	Uf ultimaBuscaUf = null;
	
	@Autowired
	private PaisesSevice paisesSevice;
	@Autowired
	private UfService ufService;
	@Autowired
	private CidadesService service;
	
	@Autowired
	private RelatorioIloService relatorioIloService;

	@GetMapping("/cadastrar")
	public String cadastrar(Cidades cidade) {
		return "/cidade/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(Cidades cidade, RedirectAttributes attr) {
		service.salvar(cidade);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/cidades/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cidades", service.buscarPorId(id));
		return "/cidade/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Cidades cidades, RedirectAttributes attr) {
		service.editar(cidades);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/cidades/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id); 
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/cidades/listar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimaBuscaCidade = "";
		this.ultimaBuscaUf = null;
		return this.findPaginated(1, model);
	}
	
	@GetMapping("/buscar/nome/cidade")
	public String getPorNome(@RequestParam("nomeCidade") String nomeCidade, ModelMap model) {
		this.ultimaBuscaCidade = nomeCidade;
		this.ultimaBuscaUf = null;	
		return this.findPaginated(1, nomeCidade, model);
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorNomePaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaCidade.equals("")) && (ultimaBuscaUf == null) ){
			return "redirect:/cidades/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaCidade.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaCidade, model);}
			else {
				return this.findPaginated(pageNo, ultimaBuscaUf, model);}
			}
	}
	
	@GetMapping("/buscar/id/uf")
	public String getPorIdUf(@RequestParam("idUfFk") Uf uf, ModelMap model) {
		this.ultimaBuscaUf = uf;
		this.ultimaBuscaCidade = "";
		
		if(uf==null){
			return "redirect:/cidades/listar";
		}else {
			return this.findPaginated(1, uf, model);
		}
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<Cidades> page = service.findPaginated(pageNo, pageSeze);
		List<Cidades> listaCidades = page.getContent();
		return paginar(pageNo, page, listaCidades, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nomeCidade, ModelMap model) {
		int pageSeze = 10;
		Page<Cidades> page = service.findPaginatedNome(pageNo, pageSeze, nomeCidade);
		List<Cidades> listaCidades = page.getContent();
		return paginar(pageNo, page, listaCidades, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Uf uf, ModelMap model) {
		int pageSeze = 10;
		Page<Cidades> page = service.findPaginatedEstado(pageNo, pageSeze, uf);
		List<Cidades> listaCidades = page.getContent();
		return paginar(pageNo, page, listaCidades, model);
	}
	
	public String paginar(int pageNo, Page<Cidades> page, List<Cidades> listaCidades, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("cidades", listaCidades);
		return "/cidade/lista";	
	}
	
	@GetMapping("/exporta/excel")
    public void downloadExcel(HttpServletResponse response, ModelMap model) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=dados.xlsx");
        ByteArrayInputStream stream = service.exportarExcel(service.buscarTodos());
        IOUtils.copy(stream, response.getOutputStream());
    }
	/*
	@GetMapping(value = "/exporta/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {
		ByteArrayInputStream bis = service.exportarPdf(service.buscarTodos());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=dados.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	*/
	
	@GetMapping(value = "/exporta/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {
		ByteArrayInputStream bis = relatorioIloService.exportarPdfDadosIlo();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=dados.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	@ModelAttribute("idPaisFk")
	public List<Paises> getPaises() {
		return paisesSevice.buscarTodos();
	}
	
	@ModelAttribute("idUfFk")
	public List<Uf> getUfs() {
		return ufService.buscarTodos();
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