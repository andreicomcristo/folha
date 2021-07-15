package com.folha.boot.web.controller;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.Enderecos;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFotos;
import com.folha.boot.service.PessoaFotosService;
import com.folha.boot.service.PessoaFotosUploadService;
import com.folha.boot.service.PessoaService;

@Controller
@RequestMapping("/fotos")
public class PessoaFotosController {

	Long idPessoaAtual;
	PessoaFotos pessoaFotos = new PessoaFotos();
	
	@Autowired
	private PessoaFotosService service;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaFotosUploadService pessoaFotosUploadService;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaFotos fotos) {		
		return "foto/cadastro";
	}
	
	@GetMapping("/cadastrar/{id}")
	public String cadastrarComPessoa(@PathVariable("id") Long id, ModelMap model, Enderecos enderecos) {	
		idPessoaAtual = id;
		this.pessoaFotos.setIdPessoaFk(pessoaService.buscarPorId(id));
		
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		model.addAttribute("pessoaFotos", this.pessoaFotos);
		model.addAttribute("pessoaDocumentosLista9", pessoaFotosUploadService.buscarPorPessoa(pessoaService.buscarPorId(id)));
		
		return "foto/cadastro";
	}
	
	@PostMapping("/salvar/fotografia")
    public String saveProduct(@RequestParam("file") MultipartFile file, PessoaFotos pessoaFotos )
    {
		
		Pessoa pessoa = pessoaService.buscarPorId(idPessoaAtual);
		pessoaFotosUploadService.saveFile(file,pessoa);
    	return "redirect:/fotos/cadastrar/"+idPessoaAtual+"";
    }
	
	@GetMapping("/avancar")
	public String avancar() {
		return "redirect:/funcionarios/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/retroceder")
	public String retroceder() {
		return "redirect:/enderecos/cadastrar/"+idPessoaAtual+"";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaFotos", service.buscarTodos());
		return "foto/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaFotos fotos, RedirectAttributes attr) {	
		service.salvar(fotos);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/fotos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaFotos", service.buscarPorId(id));
		return "foto/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaFotos fotos, RedirectAttributes attr) {
		service.editar(fotos);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/fotos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
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
