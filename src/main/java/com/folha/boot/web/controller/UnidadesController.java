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
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.TiposLogradouro;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.UnidadesNaturezaJuridica;
import com.folha.boot.domain.UnidadesRegime;
import com.folha.boot.service.CidadesService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.TiposLogradouroService;
import com.folha.boot.service.UnidadesNaturezaJuridicaService;
import com.folha.boot.service.UnidadesRegimeService;
import com.folha.boot.service.UnidadesService;

@Controller
@RequestMapping("/unidades")
public class UnidadesController {

	@Autowired
	private UnidadesService service;
	@Autowired
	private CidadesService cidadesService; 
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService; 
	@Autowired
	private TiposLogradouroService tiposLogradouroService;
	@Autowired
	private UnidadesNaturezaJuridicaService unidadesNaturezaJuridicaService; 
	@Autowired
	private UnidadesRegimeService unidadesRegimeService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Unidades unidades) {		
		return "/unidade/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("unidades", service.buscarTodos());
		return "/unidade/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Unidades unidades, RedirectAttributes attr) {
		
		service.salvar(unidades);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/unidades/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("unidades", service.buscarPorId(id));
		return "/unidade/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Unidades unidades, RedirectAttributes attr) {
		service.editar(unidades);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/unidades/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/unidade")
	public String getPorNome(@RequestParam("nomeFantasia") String nomeFantasia, ModelMap model) {		
		model.addAttribute("unidades", service.buscarPorNome(nomeFantasia.toUpperCase().trim()));
		return "/unidade/lista";
	}
	
	@ModelAttribute("idEnderecoCidadeFk")
	public List<Cidades> getCidades() {
		return cidadesService.buscarTodos();
	}

	@ModelAttribute("idOperadorCadastroFk")
	public List<PessoaOperadores> getOperadoresCadastro() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idOperadorCancelamentoFk")
	public List<PessoaOperadores> getOperadoresCancelamento() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idTipoLogradouroFk")
	public List<TiposLogradouro> getTipoLogradouro() {
		return tiposLogradouroService.buscarTodos();
	}
	
	@ModelAttribute("idNaturezaJuridicaFk")
	public List<UnidadesNaturezaJuridica> getNaturezaJuridica() {
		return unidadesNaturezaJuridicaService.buscarTodos();
	}
	
	@ModelAttribute("idUnidadesRegimeFk")
	public List<UnidadesRegime> getUnidadesRegime() {
		return unidadesRegimeService.buscarTodos();
	}
		
}
