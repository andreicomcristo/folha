package com.folha.boot.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CargosEspecialidadeService;
import com.folha.boot.service.NiveisCargoService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.relatorios.JasperService;
@RequestMapping("/jasper")
@Controller
public class JasperController {

	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private NiveisCargoService niveisCargoService;
	@Autowired
	private CargosEspecialidadeService cargosEspecialidadeService;
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
	
	
	
	//variacaoCustoPorUnidadeMediaLeito
	@GetMapping("/abrirRelatoriosFolha/variacaoCustoPorUnidadeMediaLeito")
	public String abrirRelatoriosFolhaVariacaoCustoPorUnidadeMediaLeito() {		
		return "/reports/variacaoCustoPorUnidadeMediaLeito";
	}

	@GetMapping("/relatoriosFolha/variacaoCustoPorUnidadeMediaLeito")
	public void exibirRelatoriosFolhaVariacaoCustoPorUnidadeMediaLeito(@RequestParam("ano") String ano, HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.setCaminho("/jasper/folha/variacaoCustoPorUnidadeMediaLeito.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
	
	
	//variacaoCustoPorUnidadeMediaLeitoCadastrado
	@GetMapping("/abrirRelatoriosFolha/variacaoCustoPorUnidadeMediaLeitoCadastrado")
	public String abrirRelatoriosFolhaVariacaoCustoPorUnidadeMediaLeitoCadastrado() {		
		return "/reports/variacaoCustoPorUnidadeMediaLeitoCadastrado";
	}

	@GetMapping("/relatoriosFolha/variacaoCustoPorUnidadeMediaLeitoCadastrado")
	public void exibirRelatoriosFolhaVariacaoCustoPorUnidadeMediaLeitoCadastrado(@RequestParam("ano") String ano, HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.setCaminho("/jasper/folha/variacaoCustoPorUnidadeMediaLeitoCadastrado.jasper");
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
	
	
	
	//variacaoCustoPorMes_global_grafico
	@GetMapping("/abrirRelatoriosFolha/variacaoCustoPorMes_global_grafico")
	public String abrirRelatoriosFolhavariacaoCustoPorMes_global_grafico() {		
		return "/reports/variacaoCustoPorMes_global_grafico";
	}

	@GetMapping("/relatoriosFolha/variacaoCustoPorMes_global_grafico")
	public void exibirRelatoriosFolhavariacaoCustoPorMes_global_grafico(@RequestParam("ano") String ano, HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.setCaminho("/jasper/folha/variacaoCustoPorMes_global_grafico.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
	
	
	//VariacaoCustoPorNivel_unidade_grafico
	@GetMapping("/abrirRelatoriosFolha/VariacaoCustoPorNivel_unidade_grafico")
	public String abrirRelatoriosFolhaVariacaoCustoPorNivel_unidade_grafico() {	
		return "/reports/VariacaoCustoPorNivel_unidade_grafico";
	}

	@GetMapping("/relatoriosFolha/VariacaoCustoPorNivel_unidade_grafico")
	public void exibirRelatoriosFolhaVariacaoCustoPorNivel_unidade_grafico(@RequestParam("ano") String ano, @RequestParam("unidade") Long unidade, HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.addParametros("UNIDADE_I", unidade);
		service.addParametros("UNIDADE_NOME_I", unidadesService.buscarPorId(unidade).getNomeFantasia());
		service.setCaminho("/jasper/folha/VariacaoCustoPorNivel_unidade_grafico.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
	
	
	//VariacaoCustoPorCargo_unidade_grafico
	@GetMapping("/abrirRelatoriosFolha/VariacaoCustoPorCargo_unidade_grafico")
	public String abrirRelatoriosFolhaVariacaoCustoPorCargo_unidade_grafico() {	
		return "/reports/VariacaoCustoPorCargo_unidade_grafico";
	}

	@GetMapping("/relatoriosFolha/VariacaoCustoPorCargo_unidade_grafico")
	public void exibirRelatoriosFolhaVariacaoCustoPorCargo_unidade_grafico(@RequestParam("ano") String ano, @RequestParam("unidade") Long unidade, @RequestParam("nivel") Long nivel ,  HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.addParametros("UNIDADE_I", unidade);
		service.addParametros("UNIDADE_NOME_I", unidadesService.buscarPorId(unidade).getNomeFantasia());
		service.addParametros("NIVEL_I", nivel);
		service.addParametros("NIVEL_NOME_I", niveisCargoService.buscarPorId(nivel).getNomeNivelCargo());
		service.setCaminho("/jasper/folha/VariacaoCustoPorCargo_unidade_grafico.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
	
	
	
	//VariacaoCustoPorEspecialidade_unidade_grafico
	@GetMapping("/abrirRelatoriosFolha/VariacaoCustoPorEspecialidade_unidade_grafico")
	public String abrirRelatoriosFolhaVariacaoCustoPorEspecialidade_unidade_grafico() {	
		return "/reports/VariacaoCustoPorEspecialidade_unidade_grafico";
	}

	@GetMapping("/relatoriosFolha/VariacaoCustoPorEspecialidade_unidade_grafico")
	public void exibirRelatoriosFolhaVariacaoCustoPorEspecialidade_unidade_grafico(@RequestParam("ano") String ano, @RequestParam("unidade") Long unidade, @RequestParam("nivel") Long nivel ,  HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.addParametros("UNIDADE_I", unidade);
		service.addParametros("UNIDADE_NOME_I", unidadesService.buscarPorId(unidade).getNomeFantasia());
		service.addParametros("NIVEL_I", nivel);
		service.addParametros("NIVEL_NOME_I", niveisCargoService.buscarPorId(nivel).getNomeNivelCargo());
		service.setCaminho("/jasper/folha/VariacaoCustoPorEspecialidade_unidade_grafico.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
	
	
	//VariacaoCustoPorEspecialidade_na_unidade_grafico
	@GetMapping("/abrirRelatoriosFolha/VariacaoCustoPorEspecialidade_na_unidade_grafico")
	public String abrirRelatoriosFolhaVariacaoCustoPorEspecialidade_na_unidade_grafico() {	
		return "/reports/VariacaoCustoPorEspecialidade_na_unidade_grafico";
	}

	@GetMapping("/relatoriosFolha/VariacaoCustoPorEspecialidade_na_unidade_grafico")
	public void exibirRelatoriosFolhaVariacaoCustoPorEspecialidade_na_unidade_grafico(@RequestParam("ano") String ano, @RequestParam("unidade") Long unidade, @RequestParam("especialidade") Long especialidade ,  HttpServletResponse response) throws IOException {
		if(ano.length()==4) {ano = ano+"%";}
		service.addParametros("ANO_I", ano);		
		service.addParametros("UNIDADE_I", unidade);
		service.addParametros("UNIDADE_NOME_I", unidadesService.buscarPorId(unidade).getNomeFantasia());
		service.addParametros("ESPECIALIDADE_I", especialidade);
		service.addParametros("ESPECIALIDADE_NOME_I", cargosEspecialidadeService.buscarPorId(especialidade).getIdCargoFk().getNomeCargo()+" - "+cargosEspecialidadeService.buscarPorId(especialidade).getNomeEspecialidadeCargo());
		service.setCaminho("/jasper/folha/VariacaoCustoPorEspecialidade_na_unidade_grafico.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
	
	
	//VariacaoCustoPorNivel_unidade_pizza_grafico
	@GetMapping("/abrirRelatoriosFolha/VariacaoCustoPorNivel_unidade_pizza_grafico")
	public String abrirRelatoriosFolhaVariacaoCustoPorNivel_unidade_pizza_grafico() {	
		return "/reports/VariacaoCustoPorNivel_unidade_pizza_grafico";
	}

	@GetMapping("/relatoriosFolha/VariacaoCustoPorNivel_unidade_pizza_grafico")
	public void exibirRelatoriosFolhaVariacaoCustoPorNivel_unidade_pizza_grafico(@RequestParam("mes") Long mes, @RequestParam("unidade") Long unidade, @RequestParam("nivel") Long nivel ,  HttpServletResponse response) throws IOException {
		service.addParametros("MES_I", anoMesService.buscarPorId(mes).getNomeAnoMes());		
		service.addParametros("UNIDADE_I", unidade);
		service.addParametros("UNIDADE_NOME_I", unidadesService.buscarPorId(unidade).getNomeFantasia());
		service.setCaminho("/jasper/folha/VariacaoCustoPorNivel_unidade_pizza_grafico.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
	
	
	//VariacaoCustoPorUnidade_pizza_grafico
	@GetMapping("/abrirRelatoriosFolha/VariacaoCustoPorUnidade_pizza_grafico")
	public String abrirRelatoriosFolhaVariacaoCustoPorUnidade_pizza_grafico() {	
		return "/reports/VariacaoCustoPorUnidade_pizza_grafico";
	}

	@GetMapping("/relatoriosFolha/VariacaoCustoPorUnidade_pizza_grafico")
	public void exibirRelatoriosFolhaVariacaoCustoPorUnidade_pizza_grafico(@RequestParam("mes") Long mes,  HttpServletResponse response) throws IOException {
		service.addParametros("MES_I", anoMesService.buscarPorId(mes).getNomeAnoMes());		
		service.setCaminho("/jasper/folha/VariacaoCustoPorUnidade_pizza_grafico.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
	
	
	
	
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getIdUnidadeRegimeFk() {
		return unidadesService.buscarTodos();	
	}
	
	@ModelAttribute("idNivelFk")
	public List<NiveisCargo> getIdNivelFk() {
		return niveisCargoService.buscarTodos();	
	}
	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getIdAnoMesFk() {
		return anoMesService.buscarTodos();	
	}
	
	@ModelAttribute("idEspecialidadeFk")
	public List<CargosEspecialidade> getIdEspecialidadeFk() {
		return cargosEspecialidadeService.buscarTodos();	
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
