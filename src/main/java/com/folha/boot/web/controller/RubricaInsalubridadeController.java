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
import com.folha.boot.domain.CargaHorariaSemanal;
import com.folha.boot.domain.Carreiras;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.ClassesCarreira;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.FaixasPrevidencia;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.FaixasValoresSubsidio;
import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.domain.NiveisCarreira;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.RubricaInsalubridade;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.UnidadesRegime;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CargaHorariaSemanalService;
import com.folha.boot.service.CarreirasService;
import com.folha.boot.service.ClassesCarreiraService;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.FaixasValoresParametrosCalculoFolhasExtrasService;
import com.folha.boot.service.FaixasValoresSubsidioService;
import com.folha.boot.service.NiveisCargoService;
import com.folha.boot.service.NiveisCarreiraService;
import com.folha.boot.service.RegimesDeTrabalhoService;
import com.folha.boot.service.RubricaInsalubridadeCodigoService;
import com.folha.boot.service.RubricaInsalubridadeService;
import com.folha.boot.service.TiposDeFolhaService;
import com.folha.boot.service.UnidadesRegimeService;
import com.folha.boot.service.UnidadesService;


@Controller
@RequestMapping("/rubricaInsalubridade")
public class RubricaInsalubridadeController {

	String ultimoAnoMes = "";
	
	@Autowired
	private RubricaInsalubridadeService service;
	@Autowired
	private RubricaInsalubridadeCodigoService rubricaInsalubridadeCodigoService;
	@Autowired
	private AnoMesService anoMesService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(RubricaInsalubridade rubricaInsalubridade) {
		
		return "/rubricaInsalubridade/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimoAnoMes = "";
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<RubricaInsalubridade> page = service.findPaginated(pageNo, pageSeze);
		List<RubricaInsalubridade> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 10;
		Page<RubricaInsalubridade> page = service.findPaginatedAnoMes(pageNo, pageSeze, cnes);
		List<RubricaInsalubridade> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<RubricaInsalubridade> page, List<RubricaInsalubridade> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("rubricaInsalubridade", lista);
		return "/rubricaInsalubridade/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if(pageNo<1) {pageNo = 1;}
		if( (ultimoAnoMes.equals("")) ){
			return "redirect:/rubricaInsalubridade/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
	
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		return this.findPaginated(1, anoMes, model);
	}
	
	@PostMapping("/salvar")
	public String salvar(RubricaInsalubridade rubricaInsalubridade, RedirectAttributes attr) {
		
		// Evitando salvar quem já está cadastrado
			if(rubricaInsalubridade!=null) {
				if(rubricaInsalubridade.getId()==null) {
					if(service.avaliarCadastrado(rubricaInsalubridade.getIdCodigoFk(), rubricaInsalubridade.getIdAnoMesFk() )==true) {
						return "redirect:/mensagens/mensagem/de/ja/cadastrado";	
					}
				}
			}
				
		
		if(rubricaInsalubridade.getValor()==null) {
			rubricaInsalubridade.setValor(0.0);
		}
		
		service.salvar(rubricaInsalubridade);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/rubricaInsalubridade/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("rubricaInsalubridade", service.buscarPorId(id));
		return "/rubricaInsalubridade/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(RubricaInsalubridade rubricaInsalubridade, RedirectAttributes attr) {	
		
		if(rubricaInsalubridade.getValor()==null) {
			rubricaInsalubridade.setValor(0.0);
		}
		
		service.editar(rubricaInsalubridade);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/rubricaInsalubridade/listar";
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
		return "redirect:/rubricaInsalubridade/listar" ;
	}
	
	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("cnesUnidade") String nome, ModelMap model) {		
		model.addAttribute("rubricaInsalubridade", service.buscarPorNome(nome.toUpperCase().trim()));
		return "/rubricaInsalubridade/lista";
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
	@ModelAttribute("idCodigoFk")
	public List<RubricaInsalubridadeCodigo> getIdCodigoFk() {
		return rubricaInsalubridadeCodigoService.buscarTodos();	
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

