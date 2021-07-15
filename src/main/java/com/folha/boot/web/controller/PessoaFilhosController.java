package com.folha.boot.web.controller;

import java.util.Date;
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
import com.folha.boot.domain.PessoaFilhos;
import com.folha.boot.domain.TiposDeFiliacao;
import com.folha.boot.service.PessoaFilhosService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.TiposDeFiliacaoService;

@Controller
@RequestMapping("/filhos")
public class PessoaFilhosController {

	Long idPessoaAtual;
	PessoaFilhos pessoaFilhos = new PessoaFilhos();
	
	@Autowired
	private PessoaFilhosService pessoaFilhosService;
	
	@Autowired
	private TiposDeFiliacaoService tiposDeFiliacaoService;
	
	
	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaFilhos filhos) {		
		return "filho/cadastro";
	}
	
	@GetMapping("/cadastrar/{id}")
	public String cadastrarComPessoa(@PathVariable("id") Long id, ModelMap model, PessoaFilhos pessoaFilhos) {	
		idPessoaAtual = id;
		
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaFilhos", this.pessoaFilhos);
		model.addAttribute("pessoaDocumentosLista8", pessoaFilhosService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		
		return "filho/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("PessoaFilhos", pessoaFilhosService.buscarTodos());
		return "filho/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaFilhos filhos, RedirectAttributes attr) {
		
		pessoaFilhosService.salvar(filhos);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/filhos/cadastrar";
	}
	
	@PostMapping("/salvar/filho")
	public String salvarConselho(PessoaFilhos pessoaFilhos, RedirectAttributes attr) {
		pessoaFilhos.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		pessoaFilhos.setDtCadastro(new Date());
		pessoaFilhosService.salvar(pessoaFilhos);
		
	
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/filhos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/avancar")
	public String avancar() {
		return "redirect:/pessoabancos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/retroceder")
	public String retroceder() {
		return "redirect:/enderecos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("PessoaFilhos", pessoaFilhosService.buscarPorId(id));
		return "filho/cadastro";
	}
	
	@GetMapping("/editar/filho/{id}")
	public String preEditarFilho(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarPorId(idPessoaAtual));
		model.addAttribute("pessoaFilhos", pessoaFilhosService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista8", pessoaFilhosService.buscarPorPessoa(pessoaService.buscarPorId(this.idPessoaAtual)));
		return "filho/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaFilhos filhos, RedirectAttributes attr) {
		pessoaFilhosService.editar(filhos);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/filhos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		pessoaFilhosService.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	} 
	
	@GetMapping("/excluir/filho/{id}")
	public String excluirEndereco(@PathVariable("id") Long id, ModelMap model) {
		pessoaFilhosService.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista8", pessoaFilhosService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/filhos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/buscar/nome/filho")
	public String getPorNome(@RequestParam("nomeFilho") String nomeFilho, ModelMap model) {		
		model.addAttribute("PessoaFilhos", pessoaFilhosService.buscarPorNome(nomeFilho.toUpperCase().trim()));
		return "filho/lista";
	}
	
	@ModelAttribute("idTipoFiliacaoFk")
	public List<TiposDeFiliacao> getTiposFiliacao() {
		return tiposDeFiliacaoService.buscarTodos();
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
