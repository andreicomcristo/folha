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
import com.folha.boot.domain.AreasDeCapacitacao;
import com.folha.boot.domain.FuncionariosCapacitacoes;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.TiposDeCapacitacao;
import com.folha.boot.service.AreasDeCapacitacaoService;
import com.folha.boot.service.FuncionariosCapacitacoesService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.TiposDeCapacitacaoService;

@Controller
@RequestMapping("/funcionarioscapacitacoes")
public class FuncionariosCapacitacoesController {

	@Autowired
	private FuncionariosCapacitacoesService service;
	@Autowired
	private AreasDeCapacitacaoService areasDeCapacitacaoService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private TiposDeCapacitacaoService tiposDeCapacitacaoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(FuncionariosCapacitacoes funcionariosCapacitacoes) {
		return "/funcionariocapacitacao/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionariosCapacitacoes", service.buscarTodos());
		return "/funcionariocapacitacao/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(FuncionariosCapacitacoes funcionariosCapacitacoes, RedirectAttributes attr) {
		service.salvar(funcionariosCapacitacoes);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/funcionarioscapacitacoes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionariosCapacitacoes", service.buscarPorId(id));
		return "/funcionariocapacitacao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(FuncionariosCapacitacoes funcionariosCapacitacoes, RedirectAttributes attr) {
		service.editar(funcionariosCapacitacoes);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/funcionarioscapacitacoes/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/descricao")
	public String getPorNome(@RequestParam("descricao") String descricao, ModelMap model) {		
		model.addAttribute("funcionariosCapacitacoes", service.buscarPorDescricao(descricao.toUpperCase().trim()));
		return "/funcionariocapacitacao/lista";
	}
	
	@ModelAttribute("idAreaDeCapacitacaoFk")
	public List<AreasDeCapacitacao> getAreasDeCapacitacao() {
		return areasDeCapacitacaoService.buscarTodos();
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
	
	@ModelAttribute("idTiposCapacitacaoFk")
	public List<TiposDeCapacitacao> getTiposDeCapacitacao() {
		return tiposDeCapacitacaoService.buscarTodos();
	}
}
