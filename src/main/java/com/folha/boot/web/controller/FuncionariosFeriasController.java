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
import com.folha.boot.domain.FuncionariosFerias;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.FuncionariosFeriasService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.UnidadesService;

@Controller
@RequestMapping("/funcionariosferias")
public class FuncionariosFeriasController {

	@Autowired
	private FuncionariosFeriasService service;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private UnidadesService unidadesService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(FuncionariosFerias funcionariosFerias) {
		return "/funcionarioferias/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionariosFerias", service.buscarTodos());
		return "/funcionarioferias/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(FuncionariosFerias funcionariosFerias, RedirectAttributes attr) {
		service.salvar(funcionariosFerias);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/funcionariosferias/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionariosFerias", service.buscarPorId(id));
		return "/funcionarioferias/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(FuncionariosFerias funcionariosFerias, RedirectAttributes attr) {
		service.editar(funcionariosFerias);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/funcionariosferias/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/ano/referencia")
	public String getPorNome(@RequestParam("anoReferencia") String anoReferencia, ModelMap model) {		
		model.addAttribute("funcionariosFerias", service.buscarPorAnoReferencia(anoReferencia.toUpperCase().trim()));
		return "/funcionarioferias/lista";
	}
	
	@ModelAttribute("idFuncionarioFk")
	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return pessoaFuncionariosService.buscarTodos();
	}
	
	@ModelAttribute("idOperadorCadastroFk")
	public List<PessoaOperadores> getOperadorCadastro() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idOperadorCancelamentoFk")
	public List<PessoaOperadores> getPessoaOperadoresCancelamento() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idUnidadeLancamentoFk")
	public List<Unidades> getTiposDeCapacitacao() {
		return unidadesService.buscarTodos();
	}
}
