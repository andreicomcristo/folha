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
import com.folha.boot.domain.AcessoOperadoresCoordenacao;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AcessoOperadoresCoordenacaoService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.UnidadesService;

@Controller
@RequestMapping("/acessoOperadoresCoordenacao")
public class AcessoOperadoresCoordenacaoController {

	@Autowired
	private AcessoOperadoresCoordenacaoService service;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private UnidadesService unidadesService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(AcessoOperadoresCoordenacao acessoOperadoresCoordenacao) {
		return "/operadorecoordenacao/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("acessoOperadoresCoordenacao", service.buscarTodos());
		return "/operadorecoordenacao/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(AcessoOperadoresCoordenacao acessoOperadoresCoordenacao, RedirectAttributes attr) {
		service.salvar(acessoOperadoresCoordenacao);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/acessoOperadoresCoordenacao/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("acessoOperadoresCoordenacao", service.buscarPorId(id));
		
		return "/operadorecoordenacao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(AcessoOperadoresCoordenacao acessoOperadoresCoordenacao, RedirectAttributes attr) {
		service.salvar(acessoOperadoresCoordenacao);		
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/acessoOperadoresCoordenacao/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}

	@ModelAttribute("idOperadorFk")
	public List<PessoaOperadores> getPessoaOperadores() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getUnidadesService() {
		return unidadesService.buscarTodos();
	}
}
