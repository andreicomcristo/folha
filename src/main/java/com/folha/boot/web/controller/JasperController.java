package com.folha.boot.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.folha.boot.service.relatorios.JasperService;
@RequestMapping("/jasper")
@Controller
public class JasperController {

	@Autowired
	private JasperService service;
	
	@GetMapping("/reports")
	public String abrir() {		
		return "reports";
	}
	
	@GetMapping("/relatorio/pdf/jr1")
/*	public void exibirRelatorio(@RequestParam("code") String code,   
								@RequestParam("acao") String acao,
								HttpServletResponse response) throws IOException {*/
	public void exibirRelatorio(@RequestParam("code") String code, HttpServletResponse response) throws IOException {
		//System.out.println(code);
		
		service.addParametros("NOME_I", code);		
		service.setCaminho("/jasper/funcionarios-01.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=funcionarios-01.pdf");
		// Abre na mesma pagina
		//response.setHeader("Content-disposition", "inline; filename=funcionarios-01.pdf");
		response.getOutputStream().write(bytes);
	}	
	


	
	
	//variacaoCustoPorUnidade
	@GetMapping("/abrirRelatoriosFolha/variacaoCustoPorUnidade")
	public String abrirRelatoriosFolhaVariacaoCustoPorUnidade() {		
		return "/reports/variacaoCustoPorUnidade";
	}

	@GetMapping("/relatoriosFolha/variacaoCustoPorUnidade")
	public void exibirRelatoriosFolhaVariacaoCustoPorUnidade(@RequestParam("ano") String ano, HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.setCaminho("/jasper/folha/variacaoCustoPorUnidade.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
	

	
	//variacaoCustoPorFonte
	@GetMapping("/abrirRelatoriosFolha/variacaoCustoPorFonte")
	public String abrirRelatoriosFolhavariacaoCustoPorFonte() {		
		return "/reports/variacaoCustoPorFonte";
	}

	@GetMapping("/relatoriosFolha/variacaoCustoPorFonte")
	public void exibirRelatoriosFolhavariacaoCustoPorFonte(@RequestParam("ano") String ano, HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.setCaminho("/jasper/folha/variacaoCustoPorFonte.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
	
	
	
	//variacaoCustoPorMes
	@GetMapping("/abrirRelatoriosFolha/variacaoCustoPorMes")
	public String abrirRelatoriosFolhavariacaoCustoPorMes() {		
		return "/reports/variacaoCustoPorMes";
	}

	@GetMapping("/relatoriosFolha/variacaoCustoPorMes")
	public void exibirRelatoriosFolhavariacaoCustoPorMes(@RequestParam("ano") String ano, HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.setCaminho("/jasper/folha/variacaoCustoPorMes.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
		
	
	
	
	//variacaoCustoPorUnidadeArea
	@GetMapping("/abrirRelatoriosFolha/variacaoCustoPorUnidadeArea")
	public String abrirRelatoriosFolhavariacaoCustoPorUnidadeArea() {		
		return "/reports/variacaoCustoPorUnidadeArea";
	}

	@GetMapping("/relatoriosFolha/variacaoCustoPorUnidadeArea")
	public void exibirRelatoriosFolhavariacaoCustoPorUnidadeArea(@RequestParam("ano") String ano, HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.setCaminho("/jasper/folha/variacaoCustoPorUnidadeArea.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
		
	
	
	
	//variacaoCustoPorUnidadeFolha
	@GetMapping("/abrirRelatoriosFolha/variacaoCustoPorUnidadeFolha")
	public String abrirRelatoriosFolhavariacaoCustoPorUnidadeFolha() {		
		return "/reports/variacaoCustoPorUnidadeFolha";
	}

	@GetMapping("/relatoriosFolha/variacaoCustoPorUnidadeFolha")
	public void exibirRelatoriosFolhavariacaoCustoPorUnidadeFolha(@RequestParam("ano") String ano, HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.setCaminho("/jasper/folha/variacaoCustoPorUnidadeFolha.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}		
	
	
	//variacaoCustoPorUnidadeNivel
	@GetMapping("/abrirRelatoriosFolha/variacaoCustoPorUnidadeNivel")
	public String abrirRelatoriosFolhavariacaoCustoPorUnidadeNivel() {		
		return "/reports/variacaoCustoPorUnidadeNivel";
	}

	@GetMapping("/relatoriosFolha/variacaoCustoPorUnidadeNivel")
	public void exibirRelatoriosFolhavariacaoCustoPorUnidadeNivel(@RequestParam("ano") String ano, HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.setCaminho("/jasper/folha/variacaoCustoPorUnidadeNivel.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
	
	
	
	
	//variacaoCustoPorUnidadeNivelCargo
	@GetMapping("/abrirRelatoriosFolha/variacaoCustoPorUnidadeNivelCargo")
	public String abrirRelatoriosFolhavariacaoCustoPorUnidadeNivelCargo() {		
		return "/reports/variacaoCustoPorUnidadeNivelCargo";
	}

	@GetMapping("/relatoriosFolha/variacaoCustoPorUnidadeNivelCargo")
	public void exibirRelatoriosFolhavariacaoCustoPorUnidadeNivelCargo(@RequestParam("ano") String ano, HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.setCaminho("/jasper/folha/variacaoCustoPorUnidadeNivelCargo.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	//GRAFICOS
	//variacaoCustoPorMes_grafico
	@GetMapping("/abrirRelatoriosFolha/variacaoCustoPorMes_grafico")
	public String abrirRelatoriosFolhavariacaoCustoPorMes_grafico() {		
		return "/reports/variacaoCustoPorMes_grafico";
	}

	@GetMapping("/relatoriosFolha/variacaoCustoPorMes_grafico")
	public void exibirRelatoriosFolhavariacaoCustoPorMes_grafico(@RequestParam("ano") String ano, HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.setCaminho("/jasper/folha/variacaoCustoPorMes_grafico.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
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
