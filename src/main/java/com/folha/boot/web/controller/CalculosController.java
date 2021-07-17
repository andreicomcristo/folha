package com.folha.boot.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.models.calculos.MesDoCalculo;
import com.folha.boot.service.AcessoOperadoresCoordenacaoService;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CargosEspecialidadeService;
import com.folha.boot.service.EscalaAlteracoesService;
import com.folha.boot.service.EscalaExportacaoService;
import com.folha.boot.service.EscalaPosTransparenciaService;
import com.folha.boot.service.EscalaService;
import com.folha.boot.service.PessoaCodDiferenciadoService;
import com.folha.boot.service.TempoCalculoService;
import com.folha.boot.service.calculos.escala.CalculosCalcularService;
import com.folha.boot.service.relatorios.JasperService;
import com.folha.boot.service.seguranca.UsuarioService;
import com.folha.boot.service.util.UtilidadesMatematicas;

@Controller
@RequestMapping("/calculos")
public class CalculosController {

	
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	AcessoOperadoresCoordenacaoService acessoOperadoresCoordenacaoService;
	@Autowired
	CargosEspecialidadeService cargosEspecialidadeService;
	@Autowired
	EscalaExportacaoService escalaExportacaoService;
	@Autowired
	EscalaPosTransparenciaService escalaPosTransparenciaService;
	@Autowired
	EscalaAlteracoesService escalaAlteracoesService;
	@Autowired
	PessoaCodDiferenciadoService pessoaCodDiferenciadoService;
	@Autowired
	CalculosCalcularService calculosCalcularService;
	@Autowired
	private JasperService service;
	@Autowired
	private EscalaService escalaService;
	@Autowired
	private TempoCalculoService tempoCalculoService;
	
	
	
	
	
	
	@GetMapping("/escolher/mes")
	public String escolherMes(ModelMap model) {
		model.addAttribute("mesDoCalculo", new MesDoCalculo());
		model.addAttribute("anoMes", anoMesService.buscarTodos());
		return "calculos/escolherMes"; 
	}
	
	@GetMapping("/previsao/tempo/calculo")
	public String previsaoTempoCalculo(@RequestParam("anoMes") AnoMes anoMes, ModelMap model) throws IOException {
		
		anoMes = anoMesService.buscarPorId(anoMes.getId());
		MesDoCalculo mesDoCalculo = new MesDoCalculo();
		mesDoCalculo.setAnoMes(anoMesService.buscarPorId(anoMes.getId()));
		
		String mensagem = "";
		
		//Colocar o tempo esperado por linha
		Double tempoPorLinha = tempoCalculoService.buscarPrimeiro().getSegundos();
		int linhas = escalaService.buscarQuantidadeDeEscalasPorMes(anoMes);
		Double tempoInicial = linhas * tempoPorLinha;
		Double tempo = tempoInicial;
		tempo = tempo/60;
		tempo = tempo +1;
		Double horas = 0.0;
		Double minutos = 0.0;
		minutos=tempo%60;
		horas = (tempo-minutos)/60;
		horas = UtilidadesMatematicas.ajustaValorDecimal(horas, 0);
		minutos = UtilidadesMatematicas.ajustaValorDecimal(minutos, 0);
		
		String horasString = String.valueOf(horas);
		horasString = horasString.substring(0, horasString.length()-2);
		
		String minutosString = String.valueOf(minutos);
		minutosString = minutosString.substring(0, minutosString.length()-2);
		
		Long agora = new Date().getTime();
		Long depois = agora + (  (Long.parseLong(String.valueOf(horasString))*60*60*1000) + (Long.parseLong(String.valueOf(minutosString))*60*1000) );
		Date termino = new Date(depois);
		
		mensagem = "Tempo previsto para conclusão de "+linhas+" escalas é de "+horasString+" hora(s) e "+minutosString+" minuto(s) ["+termino.getHours()+":"+termino.getMinutes()+":"+termino.getSeconds()+"].";
		
		model.addAttribute("mensagem", mensagem);
		
		model.addAttribute("anoMes", anoMes);
		model.addAttribute("mesDoCalculo", mesDoCalculo);
		model.addAttribute("idAnoMesFk",mesDoCalculo.getAnoMes() );
		return "calculos/calcular";
	}	
	
	
	
	
	@PostMapping("/calcular")
	public void irParaEscala(MesDoCalculo mesDoCalculo, ModelMap model,  HttpServletResponse response) throws IOException {
		AnoMes anoMes = anoMesService.buscarPorId(mesDoCalculo.getAnoMes().getId());
		calculosCalcularService.calcular(anoMes);
		exibirRelatoriosVencimentosTodosPorMes(anoMes, response);
		
		//return "redirect:/calculos/escolher/mes"; 
	}
	
	
	
	
	
	public void exibirRelatoriosVencimentosTodosPorMes( AnoMes anoMes,  HttpServletResponse response ) throws IOException {
		service.addParametros("MES_I", anoMes.getId());		
		service.addParametros("NOME_MES_I", anoMes.getNomeAnoMes());
		service.setCaminho("/jasper/folha/VencimentosTodosPorMes.jasper");
		byte[] bytes = service.gerarRelatorio(); 
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		//Faz o download
		response.setHeader("Content-disposition", "inline; filename=dados.pdf");
		response.getOutputStream().write(bytes);
	}	
	
	
	
	
	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getIdAnoMesFk() {
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

