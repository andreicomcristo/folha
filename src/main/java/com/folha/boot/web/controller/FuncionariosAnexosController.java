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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.FuncionariosAnexos;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.service.FuncionariosAnexosService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaOperadoresService;

@Controller
@RequestMapping("/funcionariosanexos")
public class FuncionariosAnexosController {

	@Autowired
	private FuncionariosAnexosService service;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	/*@Autowired
	private PessoaOperadoresService pessoaOperadoresService;*/
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(FuncionariosAnexos funcionariosAnexos) {
		return "funcionariosanexo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionariosAnexos", service.buscarTodos());
		return "funcionariosanexo/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(FuncionariosAnexos funcionariosAnexos, RedirectAttributes attr) {
		service.salvar(funcionariosAnexos);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/funcionariosanexos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionariosAnexos", service.buscarPorId(id));
		return "funcionariosanexo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(FuncionariosAnexos funcionariosAnexos, RedirectAttributes attr) {
		service.editar(funcionariosAnexos);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/funcionariosanexos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	/*@GetMapping("/buscar/nome/coordenacao")
	public String getPorNome(@RequestParam("nomeCoordenacao") String nomeCoordenacao, ModelMap model) {		
		model.addAttribute("funcionariosAnexos", service.buscarPorNome(nomeCoordenacao.toUpperCase().trim()));
		return "coordenacaoescala/lista";
	}*/
	
	@ModelAttribute("idPessoaFuncionarioFk")
	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return pessoaFuncionariosService.buscarTodos();
	}
	
	@ModelAttribute("idOperadorCadastroFk")
	public List<PessoaOperadores> getPessoaOperadoresCadastro() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idOperadorCancelamentoFk")
	public List<PessoaOperadores> getPessoaOperadoresCancelamento() {
		return pessoaOperadoresService.buscarTodos();
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
