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
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Fonte;
import com.folha.boot.domain.Paises;
import com.folha.boot.domain.Uf;
import com.folha.boot.domain.models.calculos.FonteMes;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CidadesService;
import com.folha.boot.service.FonteService;
import com.folha.boot.service.PaisesSevice;
import com.folha.boot.service.RelatoriosExcepcionalidadesService;
import com.folha.boot.service.UfService;


@Controller
@RequestMapping("/relatoriosExcepcionalidades")
public class RelatoriosExcepcionalidadesController {

	
	@Autowired
	private FonteService fonteService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private RelatoriosExcepcionalidadesService service;
	
	

	@GetMapping("/selecionarElegibilidadeSituacoes")
	public String cadastrar(Cidades cidade) {
		return "relatoriosExcepcionalidades/selecionarElegibilidadeSituacoes";
	}

		
	@PostMapping(value = "/selecionarElegibilidadeSituacoes/exporta/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {
		ByteArrayInputStream bis = service.exportarElegibilidadeSituacoesPdf();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=dados.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	
	
	
	
	@GetMapping("/selecionarSituacoesValoresIndividuais")
	public String cadastrarSituacoesValoresIndividuais(FonteMes fonteMes) {
		return "relatoriosExcepcionalidades/selecionarSituacoesValoresIndividuais";
	}

		
	@PostMapping(value = "/selecionarSituacoesValoresIndividuais/exporta/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReportsSelecionarSituacoesValoresIndividuais(HttpServletResponse response, FonteMes fonteMes) throws IOException {
		
		AnoMes anoMes = anoMesService.buscarPorId(fonteMes.getAnoMes().getId());
		
		ByteArrayInputStream bis = service.exportarFaixasValoresParametrosCalculoFolhasExtrasIndividualPdf(anoMes);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=dados.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	
	
	
	
	@GetMapping("/selecionarFolhExt")
	public String cadastrar(FonteMes fonteMes) {
		return "relatoriosExcepcionalidades/selecionarFolhExt";
	}

		
	@PostMapping(value = "/selecionarFolhExt/exporta/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReportsSelecionarFolhExt(HttpServletResponse response, FonteMes fonteMes) throws IOException {
		
		AnoMes anoMes = anoMesService.buscarPorId(fonteMes.getAnoMes().getId());
		
		ByteArrayInputStream bis = service.exportarFolhExtPdf(anoMes);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=dados.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	
	
	
	
	
	
	@ModelAttribute("idFonteFkFk")
	public List<Fonte> getFontes() {
		return fonteService.buscarTodos();
	}
	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getMeses() {
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