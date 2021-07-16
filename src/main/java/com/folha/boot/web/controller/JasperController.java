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
import com.folha.boot.domain.Fonte;
import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.domain.RubricaVencimento;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CargosEspecialidadeService;
import com.folha.boot.service.FonteService;
import com.folha.boot.service.NiveisCargoService;
import com.folha.boot.service.RubricaVencimentoService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.relatorios.JasperService;
import com.folha.boot.service.util.Extenso;
import com.folha.boot.service.util.UtilidadesMatematicas;
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
	private FonteService fonteService;
	@Autowired
	private RubricaVencimentoService rubricaVencimentoService;
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
		return "reports/variacaoCustoPorUnidade";
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
		return "reports/variacaoCustoPorUnidadeMediaLeito";
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
		return "reports/variacaoCustoPorUnidadeMediaLeitoCadastrado";
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
		return "reports/variacaoCustoPorFonte";
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
		return "reports/variacaoCustoPorMes";
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
		return "reports/variacaoCustoPorUnidadeArea";
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
		return "reports/variacaoCustoPorUnidadeFolha";
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
		return "reports/variacaoCustoPorUnidadeNivel";
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
		return "reports/variacaoCustoPorUnidadeNivelCargo";
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
		return "reports/variacaoCustoPorMes_grafico";
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
		return "reports/variacaoCustoPorMes_global_grafico";
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
		return "reports/VariacaoCustoPorNivel_unidade_grafico";
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
		return "reports/VariacaoCustoPorCargo_unidade_grafico";
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
		return "reports/VariacaoCustoPorEspecialidade_unidade_grafico";
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
		return "reports/VariacaoCustoPorEspecialidade_na_unidade_grafico";
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
		return "reports/VariacaoCustoPorNivel_unidade_pizza_grafico";
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
		return "reports/VariacaoCustoPorUnidade_pizza_grafico";
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
	
	
	
	//VencimentosTodosPorMes
	@GetMapping("/abrirRelatoriosFolha/VencimentosTodosPorMes")
	public String abrirRelatoriosVencimentosTodosPorMes() {		
		return "reports/VencimentosTodosPorMes";
	}

	@GetMapping("/relatoriosFolha/VencimentosTodosPorMes")
	public void exibirRelatoriosVencimentosTodosPorMes(@RequestParam("mes") Long mes, HttpServletResponse response) throws IOException {
		service.addParametros("MES_I", mes);		
		service.setCaminho("/jasper/folha/VencimentosTodosPorMes.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
	
	
	
	
	
	//VencimentosTodosPorFonteProcesso
		@GetMapping("/abrirRelatoriosFolha/processoPorFonte")
		public String abrirRelatoriosProcessoPorFonte() {		
			return "reports/ProcessoPorFonte";
		}

		@GetMapping("/relatoriosFolha/processoPorFonte")
		public void exibirRelatoriosProcessoPorFonte(@RequestParam("mes") Long mes, @RequestParam("fonte") Long fonte, HttpServletResponse response) throws IOException {
			
			
			Double totalBruto = 0.0;
			Double totalInss = 0.0;
			Double totalIr = 0.0;
			Double totalPensao = 0.0;
			Double totalOutrosDescontos = 0.0;
			Double totalPatronal = 0.0;
			Double totalLiquido = 0.0;
			Double totalBrutoComPatronal = 0.0;
			
			List<RubricaVencimento> lista = rubricaVencimentoService.buscarPorMesEFonteDescontoOuVantagem(anoMesService.buscarPorId(mes), fonteService.buscarPorId(fonte), "V");
			
			for(int i=0;i<lista.size();i++) {
				totalBruto = totalBruto + lista.get(i).getValorBruto() - lista.get(i).getDescontoProp();
				totalInss = totalInss + lista.get(i).getValorPrevidencia();
				totalIr = totalIr + lista.get(i).getValorIr();
				totalPensao = totalPensao + lista.get(i).getPensaoProp();
				totalOutrosDescontos = totalOutrosDescontos + lista.get(i).getPensaoProp();
				totalPatronal = totalPatronal + lista.get(i).getValorPatronal();
				totalLiquido = totalLiquido + lista.get(i).getValorLiquido();
			}
			
			totalBrutoComPatronal = totalBruto + totalPatronal;
			
			Extenso a = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalBruto, 2));
			String totalBrutoExtenso = a.toString() ;
			if(totalBrutoExtenso.equalsIgnoreCase("")) {totalBrutoExtenso = "Zero real e Zero centavo";}
			
			Extenso b = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalInss, 2));
			String totalInssExtenso = b.toString() ;
			if(totalInssExtenso.equalsIgnoreCase("")) {totalInssExtenso = "Zero real e Zero centavo";}
					
			Extenso c = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalIr, 2));		
			String totalIrExtenso = c.toString() ;
			if(totalIrExtenso.equalsIgnoreCase("")) {totalIrExtenso = "Zero real e Zero centavo";}
					
			Extenso d = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalOutrosDescontos, 2));		
			String totalOutrosDescontosExtenso = d.toString() ;
			if(totalOutrosDescontosExtenso.equalsIgnoreCase("")) {totalOutrosDescontosExtenso = "Zero real e Zero centavo";}
					
			Extenso e = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalPatronal, 2));
			String totalPatronalExtenso = e.toString() ;
			if(totalPatronalExtenso.equalsIgnoreCase("")) {totalPatronalExtenso = "Zero real e Zero centavo";}
					
			Extenso f = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalLiquido, 2));
			String totalLiquidoExtenso = f.toString() ;
			if(totalLiquidoExtenso.equalsIgnoreCase("")) {totalLiquidoExtenso = "Zero real e Zero centavo";}
			
			Extenso g = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalBrutoComPatronal, 2));
			String totalBrutoComPatronalExtenso = g.toString() ;
			if(totalBrutoComPatronalExtenso.equalsIgnoreCase("")) {totalBrutoComPatronalExtenso = "Zero real e Zero centavo";}
			
			Extenso h = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalPensao, 2));
			String totalPensaoExtenso = h.toString() ;
			if(totalPensaoExtenso.equalsIgnoreCase("")) {totalPensaoExtenso = "Zero real e Zero centavo";}
			 
			service.addParametros("mes", anoMesService.buscarPorId(mes).getNomeAnoMes());
			service.addParametros("fonte", fonteService.buscarPorId(fonte).getNome());
			
			service.addParametros("ANO_MES_I", mes);		
			service.addParametros("FONTE_I", fonte);
			
			service.addParametros("VALOR_TOTAL_BRUTO_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalBruto, 2));
			service.addParametros("VALOR_TOTAL_INSS_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalInss, 2));
			service.addParametros("VALOR_TOTAL_IR_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalIr, 2));
			service.addParametros("VALOR_TOTAL_PENSAO_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalPensao, 2));
			service.addParametros("VALOR_TOTAL_OUTROS_DESCONTOS_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalOutrosDescontos, 2));
			service.addParametros("VALOR_TOTAL_PATRONAL_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalPatronal, 2));
			service.addParametros("VALOR_TOTAL_LIQUIDO_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalLiquido, 2));
			service.addParametros("VALOR_TOTAL_BRUTO_COM_PATRONAL_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalBrutoComPatronal, 2));
			
			service.addParametros("TOTAL_BRUTO_I", totalBrutoExtenso);
			service.addParametros("TOTAL_INSS_I", totalInssExtenso);
			service.addParametros("TOTAL_IR_I", totalIrExtenso);
			service.addParametros("TOTAL_PENSAO_I", totalPensaoExtenso);
			service.addParametros("TOTAL_OUTROS_DESCONTOS_I", totalOutrosDescontosExtenso);
			service.addParametros("TOTAL_PATRONAL_I", totalPatronalExtenso);
			service.addParametros("TOTAL_LIQUIDO_I", totalLiquidoExtenso);
			service.addParametros("TOTAL_BRUTO_COM_PATRONAL_I", totalBrutoComPatronalExtenso);
			
			
			
			
			
			service.setCaminho("/jasper/folha/processo_por_fonte7.jasper");
			byte[] bytes = service.gerarRelatorio(); 
			response.setContentType(MediaType.APPLICATION_PDF_VALUE);
			//Faz o download
			response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
			response.getOutputStream().write(bytes);
		}	
		
	
		
		
		
		
		//VencimentosTodosPorFonteEUnidade
		@GetMapping("/abrirRelatoriosFolha/processoPorFonte/e/unidade")
		public String abrirRelatoriosProcessoPorFonteEUnidade() {		
			return "reports/ProcessoPorFonteEUnidade";
		}

		@GetMapping("/relatoriosFolha/processoPorFonte/e/unidade")
		public void exibirRelatoriosProcessoPorFonteEUnidade(@RequestParam("mes") Long mes, @RequestParam("fonte") Long fonte, @RequestParam("unidade") Long unidade, HttpServletResponse response) throws IOException {
			
			
			Double totalBruto = 0.0;
			Double totalInss = 0.0;
			Double totalIr = 0.0;
			Double totalPensao = 0.0;
			Double totalOutrosDescontos = 0.0;
			Double totalPatronal = 0.0;
			Double totalLiquido = 0.0;
			Double totalBrutoComPatronal = 0.0;
			
			List<RubricaVencimento> lista = rubricaVencimentoService.buscarPorMesEFonteEunidadeDescontoOuVantagem(anoMesService.buscarPorId(mes), fonteService.buscarPorId(fonte), unidadesService.buscarPorId(unidade), "V");
			
			for(int i=0;i<lista.size();i++) {
				totalBruto = totalBruto + lista.get(i).getValorBruto();
				totalInss = totalInss + lista.get(i).getValorPrevidencia();
				totalIr = totalIr + lista.get(i).getValorIr();
				totalPensao = totalPensao + lista.get(i).getPensaoProp();
				totalOutrosDescontos = totalOutrosDescontos + lista.get(i).getDescontoProp();
				totalPatronal = totalPatronal + lista.get(i).getValorPatronal();
				totalLiquido = totalLiquido + lista.get(i).getValorLiquido();
			}
			
			totalBrutoComPatronal = totalBruto + totalPatronal;
			
			Extenso a = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalBruto, 2));
			String totalBrutoExtenso = a.toString() ;
			
			Extenso b = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalInss, 2));
			String totalInssExtenso = b.toString() ;
					
			Extenso c = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalIr, 2));		
			String totalIrExtenso = c.toString() ;
					
			Extenso d = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalOutrosDescontos, 2));		
			String totalOutrosDescontosExtenso = d.toString() ;
					
			Extenso e = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalPatronal, 2));
			String totalPatronalExtenso = e.toString() ;
					
			Extenso f = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalLiquido, 2));
			String totalLiquidoExtenso = f.toString() ;
			
			Extenso g = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalBrutoComPatronal, 2));
			String totalBrutoComPatronalExtenso = g.toString() ;
			
			Extenso h = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalPensao, 2));
			String totalPensaoExtenso = h.toString() ;
			 
			
			service.addParametros("ANO_MES_I", mes);		
			service.addParametros("FONTE_I", fonte);
			service.addParametros("UNIDADE_I", unidade);
			
			service.addParametros("VALOR_TOTAL_BRUTO_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalBruto, 2));
			service.addParametros("VALOR_TOTAL_INSS_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalInss, 2));
			service.addParametros("VALOR_TOTAL_IR_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalIr, 2));
			service.addParametros("VALOR_TOTAL_PENSAO_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalPensao, 2));
			service.addParametros("VALOR_TOTAL_OUTROS_DESCONTOS_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalOutrosDescontos, 2));
			service.addParametros("VALOR_TOTAL_PATRONAL_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalPatronal, 2));
			service.addParametros("VALOR_TOTAL_LIQUIDO_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalLiquido, 2));
			service.addParametros("VALOR_TOTAL_BRUTO_COM_PATRONAL_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalBrutoComPatronal, 2));
			
			service.addParametros("TOTAL_BRUTO_I", totalBrutoExtenso);
			service.addParametros("TOTAL_INSS_I", totalInssExtenso);
			service.addParametros("TOTAL_IR_I", totalIrExtenso);
			service.addParametros("TOTAL_PENSAO_I", totalPensaoExtenso);
			service.addParametros("TOTAL_OUTROS_DESCONTOS_I", totalOutrosDescontosExtenso);
			service.addParametros("TOTAL_PATRONAL_I", totalPatronalExtenso);
			service.addParametros("TOTAL_LIQUIDO_I", totalLiquidoExtenso);
			service.addParametros("TOTAL_BRUTO_COM_PATRONAL_I", totalBrutoComPatronalExtenso);
			
			
			
			
			
			service.setCaminho("/jasper/folha/processo_por_fonte_e_unidade1.jasper");
			byte[] bytes = service.gerarRelatorio(); 
			response.setContentType(MediaType.APPLICATION_PDF_VALUE);
			//Faz o download
			response.setHeader("Content-disposition", "attachment; filename=dados.pdf");
			response.getOutputStream().write(bytes);
		}		
	
		
		
		
		
		//VencimentosTodosPorUnidade
		@GetMapping("/abrirRelatoriosFolha/processoPorUnidade")
		public String abrirRelatoriosProcessoPorUnidade() {		
			return "reports/ProcessoPorUnidade";
		}

		@GetMapping("/relatoriosFolha/processoPorUnidade")
		public void exibirRelatoriosProcessoPorUnidade(@RequestParam("mes") Long mes, @RequestParam("unidade") Long unidade, HttpServletResponse response) throws IOException {
			
			
			Double totalBruto = 0.0;
			Double totalInss = 0.0;
			Double totalIr = 0.0;
			Double totalPensao = 0.0;
			Double totalOutrosDescontos = 0.0;
			Double totalPatronal = 0.0;
			Double totalLiquido = 0.0;
			Double totalBrutoComPatronal = 0.0;
			
			List<RubricaVencimento> lista = rubricaVencimentoService.buscarPorMesEUnidadeDescontoOuVantagem(anoMesService.buscarPorId(mes), unidadesService.buscarPorId(unidade), "V");
			
			for(int i=0;i<lista.size();i++) {
				totalBruto = totalBruto + lista.get(i).getValorBruto();
				totalInss = totalInss + lista.get(i).getValorPrevidencia();
				totalIr = totalIr + lista.get(i).getValorIr();
				totalPensao = totalPensao + lista.get(i).getPensaoProp();
				totalOutrosDescontos = totalOutrosDescontos + lista.get(i).getDescontoProp();
				totalPatronal = totalPatronal + lista.get(i).getValorPatronal();
				totalLiquido = totalLiquido + lista.get(i).getValorLiquido();
			}
			
			totalBrutoComPatronal = totalBruto + totalPatronal;
			
			Extenso a = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalBruto, 2));
			String totalBrutoExtenso = a.toString() ;
			
			Extenso b = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalInss, 2));
			String totalInssExtenso = b.toString() ;
					
			Extenso c = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalIr, 2));		
			String totalIrExtenso = c.toString() ;
					
			Extenso d = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalOutrosDescontos, 2));		
			String totalOutrosDescontosExtenso = d.toString() ;
					
			Extenso e = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalPatronal, 2));
			String totalPatronalExtenso = e.toString() ;
					
			Extenso f = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalLiquido, 2));
			String totalLiquidoExtenso = f.toString() ;
			
			Extenso g = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalBrutoComPatronal, 2));
			String totalBrutoComPatronalExtenso = g.toString() ;
			
			Extenso h = new Extenso(UtilidadesMatematicas.ajustaValorDecimal(totalPensao, 2));
			String totalPensaoExtenso = h.toString() ;
			 
			
			service.addParametros("ANO_MES_I", mes);		
			service.addParametros("UNIDADE_I", unidade);
			
			service.addParametros("VALOR_TOTAL_BRUTO_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalBruto, 2));
			service.addParametros("VALOR_TOTAL_INSS_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalInss, 2));
			service.addParametros("VALOR_TOTAL_IR_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalIr, 2));
			service.addParametros("VALOR_TOTAL_PENSAO_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalPensao, 2));
			service.addParametros("VALOR_TOTAL_OUTROS_DESCONTOS_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalOutrosDescontos, 2));
			service.addParametros("VALOR_TOTAL_PATRONAL_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalPatronal, 2));
			service.addParametros("VALOR_TOTAL_LIQUIDO_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalLiquido, 2));
			service.addParametros("VALOR_TOTAL_BRUTO_COM_PATRONAL_I", "R$ "+UtilidadesMatematicas.ajustaValorDecimal(totalBrutoComPatronal, 2));
			
			service.addParametros("TOTAL_BRUTO_I", totalBrutoExtenso);
			service.addParametros("TOTAL_INSS_I", totalInssExtenso);
			service.addParametros("TOTAL_IR_I", totalIrExtenso);
			service.addParametros("TOTAL_PENSAO_I", totalPensaoExtenso);
			service.addParametros("TOTAL_OUTROS_DESCONTOS_I", totalOutrosDescontosExtenso);
			service.addParametros("TOTAL_PATRONAL_I", totalPatronalExtenso);
			service.addParametros("TOTAL_LIQUIDO_I", totalLiquidoExtenso);
			service.addParametros("TOTAL_BRUTO_COM_PATRONAL_I", totalBrutoComPatronalExtenso);
			
			
			
			
			
			service.setCaminho("/jasper/folha/processo_por_unidade2.jasper");
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
	
	@ModelAttribute("idFonteFk")
	public List<Fonte> getIdFonteFk() {
		return fonteService.buscarTodos();	
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
