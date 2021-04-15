package com.folha.boot.web.controller;

import java.util.Date;
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

import com.folha.boot.domain.Bancos;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaBancos;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.TiposDeDocumento;
import com.folha.boot.service.BancosService;
import com.folha.boot.service.PessoaBancosService;
import com.folha.boot.service.PessoaDocumentosService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.SimNaoService;
import com.folha.boot.service.TiposDeDocumentoService;
import com.folha.boot.service.UnidadesService;

@Controller
@RequestMapping("/pessoabancos")
public class PessoaBancosController {

	Long idUnidadeLogada = 1l;
	Long idOperadorLogado = 1l;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	
	
	Long idPessoaAtual;
	
	@Autowired
	private PessoaBancosService service;
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private BancosService bancosService;
	@Autowired
	private SimNaoService simNaoService;
	
	
	

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaDocumentos pessoaDocumentos) {		
		return "/pessoabanco/cadastro";
	}
	
	@GetMapping("/cadastrar/{id}")
	public String cadastrarComPessoa(@PathVariable("id") Long id, ModelMap model, PessoaBancos pessoaBancos) {	
		idPessoaAtual = id;
		model.addAttribute("pessoa", pessoaService.buscarPorId(idPessoaAtual));
		model.addAttribute("pessoaBancosLista", service.buscarPorPessoa(pessoaService.buscarPorId(this.idPessoaAtual)));
		return "/pessoabanco/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaBancos", service.buscarTodos());
		return "/pessoabanco/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaBancos pessoaBancos, Pessoa pessoa, RedirectAttributes attr) {
		pessoaBancos.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		
		pessoaBancos.setIdOperadorCadastroFk(pessoaOperadoresService.buscarPorId(idOperadorLogado));
		pessoaBancos.setDtCadastro(new Date());
		
		service.salvar(pessoaBancos);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/pessoabancos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/avancar")
	public String avancar() {
		return "redirect:/funcionarios/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/retroceder")
	public String retroceder() {
		return "redirect:/filhos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaBancos", service.buscarPorId( id));
		model.addAttribute("pessoaBancosLista", service.buscarPorPessoa(pessoaService.buscarPorId(this.idPessoaAtual)));
		return "/pessoabanco/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaBancos pessoaBancos, RedirectAttributes attr) {
		service.editar(pessoaBancos);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/funcionarios/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaBancosLista", service.buscarPorPessoa(pessoaService.buscarPorId(idPessoaAtual)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/pessoabancos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/buscar/nome/banco")
	public String getPorNome(@RequestParam("nomeBanco") String nomeBanco, ModelMap model) {		
		model.addAttribute("pessoaDocumentos", service.buscarPorNome(nomeBanco.toUpperCase().trim()));
		return "/pessoabanco/cadastro";
	}
	
	@ModelAttribute("idBancoFk")
	public List<Bancos> getIdBancosFk() {
		return bancosService.buscarTodos();
	}
	
	@ModelAttribute("idPrioritarioFk")
	public List<SimNao> getIdPrioritarioFk() {
		return simNaoService.buscarTodos();
	}

} 
