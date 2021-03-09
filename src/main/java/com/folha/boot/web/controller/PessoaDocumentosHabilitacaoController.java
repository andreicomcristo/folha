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

import com.folha.boot.domain.HabilitacaoCategorias;
import com.folha.boot.domain.PessoaDocumentosCtps;
import com.folha.boot.domain.PessoaDocumentosHabilitacao;
import com.folha.boot.domain.Uf;
import com.folha.boot.service.HabilitacaoCategoriasService;
import com.folha.boot.service.PessoaDocumentosHabilitacaoService;
import com.folha.boot.service.PessoaService;

@Controller
@RequestMapping("/habilitacaodocs")
public class PessoaDocumentosHabilitacaoController {

	Long idPessoaAtual;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	HabilitacaoCategoriasService habilitacaoCategoriasService;
	
	@Autowired
	private PessoaDocumentosHabilitacaoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaDocumentosHabilitacao habilitacao) {		
		return "/dochabilitacao/cadastro";
	}
	
	@GetMapping("/cadastrar/{id}")
	public String cadastrarComPessoa(@PathVariable("id") Long id, ModelMap model, PessoaDocumentosHabilitacao pessoaDocumentos) {	
		idPessoaAtual = id;
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista2", service.buscarPorPessoa(pessoaService.buscarPorId(id)));
		return "/dochabilitacao/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaDocumentosHabilitacao", service.buscarTodos());
		return "/dochabilitacao/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaDocumentosHabilitacao habilitacao, RedirectAttributes attr) {
		
		habilitacao.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		service.salvar(habilitacao);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/habilitacaodocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/avancar")
	public String avancar() {
		return "redirect:/reservistadocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/retroceder")
	public String retroceder() {
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaDocumentosHabilitacao", service.buscarPorId(id));
		return "/dochabilitacao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaDocumentosHabilitacao habilitacao, RedirectAttributes attr) {
		service.editar(habilitacao);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/habilitacaodocs/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista", service.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/habilitacaodocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/buscar/numero/documento/habilitacao")
	public String getPorNome(@RequestParam("numeroRegistro") String numeroRegistro, ModelMap model) {		
		model.addAttribute("pessoaDocumentosHabilitacao", service.buscarPorNome(numeroRegistro.toUpperCase().trim()));
		return "/dochabilitacao/lista";
	}
	
	@ModelAttribute("idHabilitacaoCategoriasFk")
	public List<HabilitacaoCategorias> getUfs() {
		return habilitacaoCategoriasService.buscarTodos();
	}
	
}
