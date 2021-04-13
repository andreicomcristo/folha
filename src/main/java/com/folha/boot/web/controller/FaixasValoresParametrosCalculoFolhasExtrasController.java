package com.folha.boot.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

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
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.FaixasValoresParametrosCalculoFolhasExtrasService;
import com.folha.boot.service.NiveisCargoService;
import com.folha.boot.service.RegimesDeTrabalhoService;
import com.folha.boot.service.TiposDeFolhaService;
import com.folha.boot.service.UnidadesService;


@Controller
@RequestMapping("/faixasparametrosextras")
public class FaixasValoresParametrosCalculoFolhasExtrasController {

	String ultimoAnoMes = "";
	
	@Autowired
	private FaixasValoresParametrosCalculoFolhasExtrasService service;
	@Autowired
	private NiveisCargoService niveisCargoService;
	@Autowired
	private CodigoDiferenciadoService codigoDiferenciadoService;
	@Autowired
	private RegimesDeTrabalhoService regimesDeTrabalhoService;
	@Autowired
	private TiposDeFolhaService tiposDeFolhaService;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private AnoMesService anoMesService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(FaixasValoresParametrosCalculoFolhasExtras faixasValoresParametrosCalculoFolhasExtras) {
		
		return "/faixaparametroextra/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimoAnoMes = "";
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<FaixasValoresParametrosCalculoFolhasExtras> page = service.findPaginated(pageNo, pageSeze);
		List<FaixasValoresParametrosCalculoFolhasExtras> listaCidades = page.getContent();
		return paginar(pageNo, page, listaCidades, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 10;
		Page<FaixasValoresParametrosCalculoFolhasExtras> page = service.findPaginatedAnoMes(pageNo, pageSeze, cnes);
		List<FaixasValoresParametrosCalculoFolhasExtras> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<FaixasValoresParametrosCalculoFolhasExtras> page, List<FaixasValoresParametrosCalculoFolhasExtras> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("faixasValoresParametrosCalculoFolhasExtras", lista);
		return "/faixaparametroextra/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if( (ultimoAnoMes.equals("")) ){
			return "redirect:/faixasparametrosextras/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
	
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		return this.findPaginated(1, anoMes, model);
	}
	
	@PostMapping("/salvar")
	public String salvar(FaixasValoresParametrosCalculoFolhasExtras faixasValoresParametrosCalculoFolhasExtras, RedirectAttributes attr) {
		
		if(faixasValoresParametrosCalculoFolhasExtras.getValorBrutoPorHora()==null) {
			faixasValoresParametrosCalculoFolhasExtras.setValorBrutoPorHora(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtras.getValorHoraDia()==null) {
			faixasValoresParametrosCalculoFolhasExtras.setValorHoraDia(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtras.getValorHoraFimDeSemana()==null) {
			faixasValoresParametrosCalculoFolhasExtras.setValorHoraFimDeSemana(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtras.getValorHoraNoite()==null) {
			faixasValoresParametrosCalculoFolhasExtras.setValorHoraNoite(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtras.getValorHoraSemana()==null) {
			faixasValoresParametrosCalculoFolhasExtras.setValorHoraSemana(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtras.getValorLiquidoPorHora()==null) {
			faixasValoresParametrosCalculoFolhasExtras.setValorLiquidoPorHora(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtras.getValorBrutoFixoTotal()==null) {
			faixasValoresParametrosCalculoFolhasExtras.setValorBrutoFixoTotal(0.0);
		}
		
		
		service.salvar(faixasValoresParametrosCalculoFolhasExtras);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/faixasparametrosextras/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("faixasValoresParametrosCalculoFolhasExtras", service.buscarPorId(id));
		return "/faixaparametroextra/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(FaixasValoresParametrosCalculoFolhasExtras faixasValoresParametrosCalculoFolhasExtras, RedirectAttributes attr) {	
		
		if(faixasValoresParametrosCalculoFolhasExtras.getValorBrutoPorHora()==null) {
			faixasValoresParametrosCalculoFolhasExtras.setValorBrutoPorHora(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtras.getValorHoraDia()==null) {
			faixasValoresParametrosCalculoFolhasExtras.setValorHoraDia(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtras.getValorHoraFimDeSemana()==null) {
			faixasValoresParametrosCalculoFolhasExtras.setValorHoraFimDeSemana(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtras.getValorHoraNoite()==null) {
			faixasValoresParametrosCalculoFolhasExtras.setValorHoraNoite(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtras.getValorHoraSemana()==null) {
			faixasValoresParametrosCalculoFolhasExtras.setValorHoraSemana(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtras.getValorLiquidoPorHora()==null) {
			faixasValoresParametrosCalculoFolhasExtras.setValorLiquidoPorHora(0.0);
		}
		
		
		service.editar(faixasValoresParametrosCalculoFolhasExtras);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/faixasparametrosextras/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("cnesUnidade") String nome, ModelMap model) {		
		model.addAttribute("faixasValoresParametrosCalculoFolhasExtras", service.buscarPorNome(nome.toUpperCase().trim()));
		return "/faixaparametroextra/lista";
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
	
	
	
	
	@ModelAttribute("idCodDiferenciadoFk")
	public List<CodigoDiferenciado> getIdCodDiferenciadoFk() {
		
		return codigoDiferenciadoService.buscarTodosGeral();	
	}
	
	@ModelAttribute("idNivelFk")
	public List<NiveisCargo> getIdNivelFk() {
		
		return niveisCargoService.buscarTodos();	
	}
	
	@ModelAttribute("idRegimeDeTrabalhoFk")
	public List<RegimesDeTrabalho> getIdRegimeDeTrabalhoFk() {
		
		return regimesDeTrabalhoService.buscarTodos();	
	}
	
	@ModelAttribute("idTipoDeFolhaFk")
	public List<TiposDeFolha> getIdTipoDeFolhaFk() {
		return tiposDeFolhaService.buscarNaoEfetivas();	
	}
	
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getIdUnidadeFk() {
		
		return unidadesService.buscarTodos();	
	}
	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getIdAnoMesFk() {
		return anoMesService.buscarTodos();	
	}
}

