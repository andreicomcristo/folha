package com.folha.boot.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.FaixasValoresParametrosCalculoFolhasExtras;
import com.folha.boot.domain.NiveisCargo;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.FaixasValoresParametrosCalculoFolhasExtrasService;
import com.folha.boot.service.NiveisCargoService;
import com.folha.boot.service.RegimesDeTrabalhoService;
import com.folha.boot.service.TiposDeFolhaService;
import com.folha.boot.service.UnidadesService;


@Controller
@RequestMapping("/faixasparametrosextras")
public class FaixasValoresParametrosCalculoFolhasExtrasController {

	@Autowired
	private FaixasValoresParametrosCalculoFolhasExtrasService service;
	@Autowired
	private NiveisCargoService niveisCargoService;
	@Autowired
	private CodigoDiferenciadoService CodigoDiferenciadoService;
	@Autowired
	private RegimesDeTrabalhoService regimesDeTrabalhoService;
	@Autowired
	private TiposDeFolhaService tiposDeFolhaService;
	@Autowired
	private UnidadesService unidadesService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(FaixasValoresParametrosCalculoFolhasExtras faixasValoresParametrosCalculoFolhasExtras) {
		
		return "/faixaparametroextra/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("faixasValoresParametrosCalculoFolhasExtras", service.buscarTodos());
		return "/faixaparametroextra/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(FaixasValoresParametrosCalculoFolhasExtras faixasValoresParametrosCalculoFolhasExtras, RedirectAttributes attr) {
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
	
	@GetMapping("/buscar/cnes")
	public String getPorNome(@RequestParam("cnesUnidade") String cnesUnidade, ModelMap model) {		
		model.addAttribute("anoMes", service.buscarPorCnes(cnesUnidade.toUpperCase().trim()));
		return "/faixaparametroextra/lista";
	}
	
	@ModelAttribute("idCodDiferenciadoFk")
	public List<CodigoDiferenciado> getIdCodDiferenciadoFk() {
		
		return CodigoDiferenciadoService.buscarTodos();	
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
		
		return tiposDeFolhaService.buscarTodos();	
	}
	
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getIdUnidadeFk() {
		
		return unidadesService.buscarTodos();	
	}
}

