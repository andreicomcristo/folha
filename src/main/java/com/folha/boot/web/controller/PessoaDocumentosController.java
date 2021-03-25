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

import com.folha.boot.domain.Escala;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentos;
import com.folha.boot.domain.TiposDeDocumento;
import com.folha.boot.service.PessoaDocumentosService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.TiposDeDocumentoService;
import com.folha.boot.service.util.UtilidadesDeCalendarioEEscala;

@Controller
@RequestMapping("/documentos")
public class PessoaDocumentosController {

	Long idPessoaAtual;
	
	@Autowired
	private PessoaDocumentosService service;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private TiposDeDocumentoService tiposDeDocumentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaDocumentos pessoaDocumentos) {		
		return "/documento/cadastro";
	}
	
	@GetMapping("/cadastrar/{id}")
	public String cadastrarComPessoa(@PathVariable("id") Long id, ModelMap model, PessoaDocumentos pessoaDocumentos) {	
		idPessoaAtual = id;
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista", service.buscarPorPessoa(pessoaService.buscarPorId(id)));
		return "/documento/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaDocumentos", service.buscarTodos());
		System.out.println(service.buscarTodos().toString());
		return "/documento/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaDocumentos documento, Pessoa pessoa, RedirectAttributes attr) {
		documento.setIdPessoaFk(pessoaService.buscarPorId(idPessoaAtual));
		service.salvar(documento);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/documentos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/avancar")
	public String avancar() {
		return "redirect:/ctpsdocs/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/retroceder")
	public String retroceder() {
		return "redirect:/pessoas/retroceder/editar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaDocumentos", service.buscarPorId(id));
		return "/documento/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaDocumentos documento, RedirectAttributes attr) {
		service.editar(documento);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/documentos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaDocumentosLista", service.buscarPorPessoa(pessoaService.buscarPorId(id)));
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/documentos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/buscar/numero/documento")
	public String getPorNome(@RequestParam("numeroDocumento") String numeroDocumento, ModelMap model) {		
		model.addAttribute("pessoaDocumentos", service.buscarPorNome(numeroDocumento.toUpperCase().trim()));
		return "/documento/lista";
	}
	
	@ModelAttribute("idTiposDeDocumentoFk")
	public List<TiposDeDocumento> getTiposDeDocumentos() {
		return tiposDeDocumentoService.buscarTodos();
	}
}
