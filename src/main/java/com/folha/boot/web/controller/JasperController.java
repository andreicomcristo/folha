package com.folha.boot.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.folha.boot.service.relatorios.JasperService;

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
	public void exibirRelatorio(HttpServletResponse response) throws IOException {
		
		byte[] bytes = service.exportarPDF();
		

		response.setContentType(org.springframework.http.MediaType.APPLICATION_PDF_VALUE);
		
		/*if(acao.equals("v")){
			response.setHeader("Content-disposition", "inline; filename=relatorio-"+code+".pdf");		
		}else {
			response.setHeader("Content-disposition", "attachment; filename=relatorio-"+code+".pdf");
		}*/
		response.getOutputStream().write(bytes);
	}
		
}
