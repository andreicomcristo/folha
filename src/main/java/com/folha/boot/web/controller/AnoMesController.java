package com.folha.boot.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.SimNao;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.SimNaoService;

@Controller
@RequestMapping("/anomes")
public class AnoMesController {

	@Autowired
	private AnoMesService service;

	@Autowired
	private SimNaoService simNaoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(AnoMes anoMes) {		
		return "anomes/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("anoMes", service.buscarTodos());
		return "anomes/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(AnoMes anoMes, RedirectAttributes attr) {
		
		if(anoMes.getIdEscalaBloqueadaFk()==null) {
			anoMes.setIdEscalaBloqueadaFk(simNaoService.buscarPorSigla("N").get(0));
		}
		service.salvar(anoMes);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/anomes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("anoMes", service.buscarPorId(id));
		return "anomes/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(AnoMes anoMes, RedirectAttributes attr) {
		service.editar(anoMes);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/anomes/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/AnoMes")
	public String getPorNome(@RequestParam("nomeAnoMes") String nomeAnoMes, ModelMap model) {	
		model.addAttribute("anoMes", service.buscarPorNome(nomeAnoMes.toUpperCase().trim()));
		return "anomes/lista";
	}
	
	@ModelAttribute("idEscalaBloqueadaFk")
	public List<SimNao> getEscalaBloqueadaFk() {
		return simNaoService.buscarTodos();
	}
	
	@ModelAttribute("idTransparenciaEnviadaFk")
	public List<SimNao> getTransparenciaEnviadaFk() {
		return simNaoService.buscarTodos();
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
