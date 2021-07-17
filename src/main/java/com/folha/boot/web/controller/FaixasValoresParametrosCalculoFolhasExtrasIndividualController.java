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
import com.folha.boot.domain.ClassesCarreira;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtrasIndividual;
import com.folha.boot.domain.Fonte;
import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.TipoBrutoLiquido;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.CargaHorariaSemanalService;
import com.folha.boot.service.ClassesCarreiraService;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.FaixasValoresParametrosCalculoFolhasExtrasIndividualService;
import com.folha.boot.service.FonteService;
import com.folha.boot.service.NiveisCargoService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.RegimesDeTrabalhoService;
import com.folha.boot.service.TipoBrutoLiquidoService;
import com.folha.boot.service.TiposDeFolhaService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.seguranca.UsuarioService;


@Controller
@RequestMapping("/faixasValoresParametrosCalculoFolhasExtrasIndividual")
public class FaixasValoresParametrosCalculoFolhasExtrasIndividualController {

	String ultimoAnoMes = "";
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private CodigoDiferenciadoService codigoDiferenciadoService;
	@Autowired
	private TiposDeFolhaService tiposDeFolhaService;
	@Autowired
	private RegimesDeTrabalhoService regimesDeTrabalhoService;
	@Autowired
	private FaixasValoresParametrosCalculoFolhasExtrasIndividualService service;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private ClassesCarreiraService classesCarreiraService;
	@Autowired
	private CargaHorariaSemanalService cargaHorariaSemanalService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private FonteService fonteService;
	@Autowired
	private TipoBrutoLiquidoService tipoBrutoLiquidoService;
	@Autowired
	private NiveisCargoService niveisCargoService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*Lista de funcionarios
	  Funcionarios Todos os Possíveis
	  Inicio da paginação*/
	
	
	@GetMapping("/paginar/funcionarios/{pageNo}")
	public String getPorNomePaginadoInclusao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) ){
			return "redirect:/faixasValoresParametrosCalculoFolhasExtrasIndividual/funcionarios/listar/{pageNo}" ;}
			else {		
				if(!ultimaBuscaNome.equals("")) {
					return this.findPaginatedFuncionario(pageNo, ultimaBuscaNome, model);}
				else {
					return "redirect:/faixasValoresParametrosCalculoFolhasExtrasIndividual/funcionarios/listar/{pageNo}" ;}
			}
		}
		
	@GetMapping("/funcionarios/listar")
	public String listarFuncionarios(ModelMap model) {
		ultimaBuscaNome = "";
		return this.findPaginatedFuncionario(1, model);
	}	
		
	@GetMapping("/funcionarios/listar/{pageNo}")
	public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginatedDeTodasAsUnidades(pageNo, pageSeze, "ATIVO");
		List<PessoaFuncionarios> listaFuncionarios = page.getContent();
		return paginarFuncionario(pageNo, page, listaFuncionarios, model);
	}
		
	public String paginarFuncionario(int pageNo, Page<PessoaFuncionarios> page, List<PessoaFuncionarios> lista, ModelMap model) {			
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaFuncionarios", lista);
		return "faixasValoresParametrosCalculoFolhasExtrasIndividual/listafuncionario";	
	}	
		
	@GetMapping("/buscar/funcionarios/nome")
	public String getPorNomeFuncionario(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		//this.ultimaBuscaTurma = null;	
		return this.findPaginatedFuncionario(1, nome, model);
	}
		
	public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginatedNomeDeTodasAsUnidades(pageNo, pageSeze, "ATIVO", nome);
		List<PessoaFuncionarios> lista = page.getContent();
		//ultimaBuscaNome = "";
		//ultimaBuscaTurma = null;
		return paginarFuncionario(pageNo, page, lista, model);
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimoAnoMes = "";
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		Page<FaixasValoresParametrosCalculoFolhasExtrasIndividual> page = service.findPaginated(pageNo, pageSeze);
		List<FaixasValoresParametrosCalculoFolhasExtrasIndividual> listaCidades = page.getContent();
		return paginar(pageNo, page, listaCidades, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 50;
		Page<FaixasValoresParametrosCalculoFolhasExtrasIndividual> page = service.findPaginatedAnoMes(pageNo, pageSeze, cnes);
		List<FaixasValoresParametrosCalculoFolhasExtrasIndividual> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginatedNome(@PathVariable (value = "pageNo") int pageNo, String cnes, ModelMap model) {
		int pageSeze = 50;
		Page<FaixasValoresParametrosCalculoFolhasExtrasIndividual> page = service.findPaginatedNome(pageNo, pageSeze, cnes);
		List<FaixasValoresParametrosCalculoFolhasExtrasIndividual> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<FaixasValoresParametrosCalculoFolhasExtrasIndividual> page, List<FaixasValoresParametrosCalculoFolhasExtrasIndividual> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("faixasValoresParametrosCalculoFolhasExtrasIndividual", lista);
		return "faixasValoresParametrosCalculoFolhasExtrasIndividual/lista";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if(pageNo<1) {pageNo = 1;}
		if( (!ultimoAnoMes.equals("")) ){
			return this.findPaginated(pageNo, ultimoAnoMes, model);}
		
		else { if(!ultimaBuscaNome.equals("")) {
			return this.findPaginatedNome(pageNo, ultimaBuscaNome, model);}
		
			else {
				return "redirect:/faixasValoresParametrosCalculoFolhasExtrasIndividual/listar/{pageNo}" ;
			}
		}
	}
		
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		this.ultimaBuscaNome = "";
		return this.findPaginated(1, anoMes, model);
	}
	
	@GetMapping("/buscar/nome/nome")
	public String getPorNomePaginar(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimoAnoMes = "";
		this.ultimaBuscaNome = nome;
		return this.findPaginatedNome(1, nome, model);
	}
	//Fim da paginação
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(FaixasValoresParametrosCalculoFolhasExtrasIndividual faixasValoresParametrosCalculoFolhasExtrasIndividual) {
		return "faixasValoresParametrosCalculoFolhasExtrasIndividual/cadastro";
	}
	
	// Dados para Atribuição
	@GetMapping("/cadastrar/{id}")
	public String cadastrar(@PathVariable("id") Long id, FaixasValoresParametrosCalculoFolhasExtrasIndividual faixasValoresParametrosCalculoFolhasExtrasIndividual, ModelMap model) {
		faixasValoresParametrosCalculoFolhasExtrasIndividual.setIdFuncionarioFk(pessoaFuncionariosService.buscarPorId(id));
		PessoaFuncionarios funcionario = pessoaFuncionariosService.buscarPorId(id);
		model.addAttribute("idCodDiferenciadoFk", codigoDiferenciadoService.buscarTodosGeralNaUnidade(funcionario.getIdUnidadeAtuacaoAtualFk()));
		
		
		return "faixasValoresParametrosCalculoFolhasExtrasIndividual/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(FaixasValoresParametrosCalculoFolhasExtrasIndividual faixasValoresParametrosCalculoFolhasExtrasIndividual, RedirectAttributes attr) {
		
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorBrutoFixoTotal()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorBrutoFixoTotal(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorBrutoPorHora()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorBrutoPorHora(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorHoraDia()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorHoraDia(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorHoraFimDeSemana()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorHoraFimDeSemana(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorHoraNoite()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorHoraNoite(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorHoraA()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorHoraA(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorHoraB()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorHoraB(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorHoraC()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorHoraC(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorHoraSemana()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorHoraSemana(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorLiquidoPorHora()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorLiquidoPorHora(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getObservacao()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setObservacao("");
		}
		
		
		service.salvar(faixasValoresParametrosCalculoFolhasExtrasIndividual);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/faixasValoresParametrosCalculoFolhasExtrasIndividual/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("faixasValoresParametrosCalculoFolhasExtrasIndividual", service.buscarPorId(id));
		return "faixasValoresParametrosCalculoFolhasExtrasIndividual/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(FaixasValoresParametrosCalculoFolhasExtrasIndividual faixasValoresParametrosCalculoFolhasExtrasIndividual, RedirectAttributes attr) {	
		
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorBrutoFixoTotal()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorBrutoFixoTotal(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorBrutoPorHora()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorBrutoPorHora(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorHoraDia()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorHoraDia(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorHoraFimDeSemana()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorHoraFimDeSemana(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorHoraNoite()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorHoraNoite(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorHoraA()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorHoraA(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorHoraB()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorHoraB(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorHoraC()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorHoraC(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorHoraSemana()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorHoraSemana(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getValorLiquidoPorHora()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setValorLiquidoPorHora(0.0);
		}
		if(faixasValoresParametrosCalculoFolhasExtrasIndividual.getObservacao()==null) {
			faixasValoresParametrosCalculoFolhasExtrasIndividual.setObservacao("");
		}
		
		service.editar(faixasValoresParametrosCalculoFolhasExtrasIndividual);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/faixasValoresParametrosCalculoFolhasExtrasIndividual/listar";
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
		return "redirect:/faixasValoresParametrosCalculoFolhasExtrasIndividual/listar" ;
	}	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("cnesUnidade") String nome, ModelMap model) {		
		model.addAttribute("faixasValoresParametrosCalculoFolhasExtrasIndividual", service.buscarPorNome(nome.toUpperCase().trim()));
		return "faixasValoresParametrosCalculoFolhasExtrasIndividual/lista";
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
	
	@ModelAttribute("idFuncionarioFk")
	public List<PessoaFuncionarios> getIdFuncionarioFk() {
		return pessoaFuncionariosService.buscarPorAtivos( "ATIVO");
	}	
	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getIdAnoMesFk() {
		return anoMesService.buscarTodos();	
	}
	@ModelAttribute("idNivelCargoFk")
	public List<NiveisCargo> getIdNivelCarreiraFk() {
		return niveisCargoService.buscarTodos();	
	}
	@ModelAttribute("idRegimeDeTrabalhoFk")
	public List<RegimesDeTrabalho> getIdRegimeDeTrabalhoFk() {
		return regimesDeTrabalhoService.buscarTodos();	
	}
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getIdUnidadeRegimeFk() {
		return unidadesService.buscarTodos();	
	}
	@ModelAttribute("idClasseCarreiraFk")
	public List<ClassesCarreira> getIdClasseCarreiraFk() {
		return classesCarreiraService.buscarTodos();	
	}
	@ModelAttribute("idCargaHorariaSemanalFk")
	public List<CargaHorariaSemanal> getIdCargaHorariaSemanalFk() {
		return cargaHorariaSemanalService.buscarTodos();	
	}
	@ModelAttribute("idFonteFk")
	public List<Fonte> getIdFonteFk() {
		return fonteService.buscarTodos();
	}
	@ModelAttribute("idTipoBrutoLiquidoFk")
	public List<TipoBrutoLiquido> getIdTipoBrutoLiquidoFk() {
		return tipoBrutoLiquidoService.buscarTodos();
	}
	@ModelAttribute("idTipoDeFolhaFk")
	public List<TiposDeFolha> getIdTipoDeFolhaFk() {
		return tiposDeFolhaService.buscarNaoEfetivasEVariaveis();	
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

