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

import com.folha.boot.domain.Conselhos;
import com.folha.boot.domain.HabilitacaoCategorias;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.PessoaDocumentosConselho;
import com.folha.boot.domain.PessoaDocumentosCtps;
import com.folha.boot.domain.PessoaDocumentosHabilitacao;
import com.folha.boot.domain.PessoaDocumentosReservista;
import com.folha.boot.domain.Uf;
import com.folha.boot.service.ConselhosServices;
import com.folha.boot.service.HabilitacaoCategoriasService;
import com.folha.boot.service.PessoaDocumentosConselhoService;
import com.folha.boot.service.PessoaDocumentosCtpsService;
import com.folha.boot.service.PessoaDocumentosHabilitacaoService;
import com.folha.boot.service.PessoaDocumentosReservistaService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.UfService;

@Controller
@RequestMapping("/ctpsdocs")
public class PessoaDocumentosCtpsController {
	
	Long idPessoaAtual;
	
	@Autowired
	private PessoaDocumentosCtpsService service;
	
	@Autowired
	private PessoaDocumentosHabilitacaoService pessoaDocumentosHabilitacaoService;
	
	@Autowired
	private PessoaDocumentosReservistaService pessoaDocumentosReservistaService;
	
	@Autowired
	private PessoaDocumentosConselhoService pessoaDocumentosConselhoService;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	HabilitacaoCategoriasService habilitacaoCategoriasService;
	
	@Autowired
	UfService ufService;
	
	@Autowired
	ConselhosServices conselhosServices;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaDocumentosCtps ctps) {		
		return "/docctps/cadastro";
	}
	
	@GetMapping("/cadastrar/{id}")
	public String cadastrarComPessoa(@PathVariable("id") Long id, ModelMap model, PessoaDocumentosCtps pessoaDocumentos, PessoaDocumentosHabilitacao pessoaDocumentosHabilitacao, PessoaDocumentosReservista pessoaDocumentosReservista, PessoaDocumentosConselho pessoaDocumentosConselho) {	
		idPessoaAtual = id;
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista1", service.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("pessoaDocumentosLista2", pessoaDocumentosHabilitacaoService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("pessoaDocumentosLista3", pessoaDocumentosReservistaService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("pessoaDocumentosLista4", pessoaDocumentosConselhoService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		return "/docctps/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaDocumentosCtps", service.buscarTodos());
		System.out.println(service.buscarTodos().toString());
		return "/docctps/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaDocumentosCtps documento, RedirectAttributes attr) {
		
		documento.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		service.salvar(documento);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@PostMapping("/salvar/habilitacao")
	public String salvarHabilitacao(PessoaDocumentosHabilitacao habilitacao, RedirectAttributes attr) {
		
		habilitacao.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		pessoaDocumentosHabilitacaoService.salvar(habilitacao);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@PostMapping("/salvar/reservista")
	public String salvarReservista(PessoaDocumentosReservista reservista, RedirectAttributes attr) {
		
		reservista.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		pessoaDocumentosReservistaService.salvar(reservista);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@PostMapping("/salvar/conselho")
	public String salvarConselho(PessoaDocumentosConselho conselho, RedirectAttributes attr) {
		
		conselho.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		pessoaDocumentosConselhoService.salvar(conselho);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/avancar")
	public String avancar() {
		return "redirect:/habilitacaodocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/retroceder")
	public String retroceder() {
		return "redirect:/documentos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaDocumentosCtps", service.buscarPorId(id));
		return "/docctps/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaDocumentosCtps ctps, RedirectAttributes attr) {
		service.editar(ctps);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/ctpsdocs/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista", service.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}

	@GetMapping("/buscar/numero/documento/ctps")
	public String getPorNome(@RequestParam("numero") String numero, ModelMap model) {		
		model.addAttribute("pessoaDocumentosCtps", service.buscarPorNumero(numero.toUpperCase().trim()));
		return "/docctps/lista";
	}
	
	@ModelAttribute("idHabilitacaoCategoriasFk")
	public List<HabilitacaoCategorias> getHabilitacaoCategorias() {
		return habilitacaoCategoriasService.buscarTodos();
	}
	
	@ModelAttribute("idUfFk")
	public List<Uf> getUfs() {
		return ufService.buscarTodos();
	}
	
	@ModelAttribute("idConselhosFk")
	public List<Conselhos> getConselhos() {
		return conselhosServices.buscarTodos();
	}
	
}
