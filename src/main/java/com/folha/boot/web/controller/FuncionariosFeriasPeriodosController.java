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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.folha.boot.domain.FuncionariosFerias;
import com.folha.boot.domain.FuncionariosFeriasPeriodos;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.service.FuncionariosFeriasPeriodosService;
import com.folha.boot.service.FuncionariosFeriasService;
import com.folha.boot.service.PessoaOperadoresService;



@Controller
@RequestMapping("/funcionariosferiasperiodos")
public class FuncionariosFeriasPeriodosController {

	@Autowired
	private FuncionariosFeriasPeriodosService service;
	@Autowired
	private FuncionariosFeriasService funcionariosFeriasService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(FuncionariosFeriasPeriodos funcionariosFeriasPeriodos) {
		return "/funcionariosferiasperiodo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionariosFeriasPeriodos", service.buscarTodos());
		return "/funcionariosferiasperiodo/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(FuncionariosFeriasPeriodos funcionariosFeriasPeriodos, RedirectAttributes attr) {
		service.salvar(funcionariosFeriasPeriodos);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/funcionariosferiasperiodos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionariosFeriasPeriodos", service.buscarPorId(id));
		return "/funcionariosferiasperiodo/cadastro";
	}
	
	
	@PostMapping("/editar")
	public String editar(FuncionariosFeriasPeriodos funcionariosFeriasPeriodos, RedirectAttributes attr) {
		service.editar(funcionariosFeriasPeriodos);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/funcionariosferiasperiodos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	//Deficnir Critérios de Busca
	
	/*@GetMapping("/buscar/ano/referencia")
	public String getPorNome(@RequestParam("anoReferencia") String anoReferencia, ModelMap model) {		
		model.addAttribute("funcionariosFeriasPeriodos", service.buscarPorAnoReferencia(anoReferencia.toUpperCase().trim()));
		return "/funcionariosferiasperiodo/lista";
	}*/
		
	@ModelAttribute("idFeriasFk")
	public List<FuncionariosFerias> getTiposDeCapacitacao() {
		return funcionariosFeriasService.buscarTodos();
	}
	
	@ModelAttribute("idOperadorCadastroFk")
	public List<PessoaOperadores> getOperadorCadastro() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idOperadorCancelamentoFk")
	public List<PessoaOperadores> getPessoaOperadoresCancelamento() {
		return pessoaOperadoresService.buscarTodos();
	}
	
}
