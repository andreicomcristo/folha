package com.folha.boot.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	public void exibirRelatorio(@RequestParam("code") String code, HttpServletResponse response) throws IOException {
		//System.out.println(code);
		
		service.addParametros("NOME_I", code);		
		service.setCaminho("/jasper/funcionarios-01.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		response.getOutputStream().write(bytes);
	}		
}
