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
import com.folha.boot.service.UfService;
import com.folha.boot.service.calculos.escala.TxtFinanceiroService;


@Controller
@RequestMapping("/txtFinanceiro")
public class TxtFinanceiroController {

	
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private FonteService fonteService;
	@Autowired
	private TxtFinanceiroService service;
	
	
	@GetMapping("/selecionar")
	public String selecionar(FonteMes fonteMes) {
		return "txtFinanceiro/selecao";
	}
	
	
	@PostMapping("/exporta/excel")
    public void downloadExcel(HttpServletResponse response, ModelMap model, FonteMes fonteMes) throws IOException {
        
		fonteMes.setAnoMes(anoMesService.buscarPorId(fonteMes.getAnoMes().getId()));
        fonteMes.setFonte(fonteService.buscarPorId(fonteMes.getFonte().getId()));
		
        String nomeDoArquivo = "Exportacao "+fonteMes.getAnoMes().getNomeAnoMes()+" pela fonte "+fonteMes.getFonte().getNome();
        
		response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename="+nomeDoArquivo+".xlsx");
        ByteArrayInputStream stream = service.exportarExcel(fonteMes.getAnoMes(), fonteMes.getFonte());
        IOUtils.copy(stream, response.getOutputStream());
    }
	
	
	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getAnoMes() {
		return anoMesService.buscarTodos();
	}
	
	@ModelAttribute("idFonteFk")
	public List<Fonte> getFonte() {
		return fonteService.buscarTodos();
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