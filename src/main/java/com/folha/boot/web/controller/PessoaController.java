package com.folha.boot.web.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
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

import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Doc;
import com.folha.boot.domain.Escolaridades;
import com.folha.boot.domain.EstadosCivis;
import com.folha.boot.domain.Paises;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFotos;
import com.folha.boot.domain.Sexos;
import com.folha.boot.domain.Uf;
import com.folha.boot.service.CidadesService;
import com.folha.boot.service.EscolaridadesService;
import com.folha.boot.service.EstadosCivisService;
import com.folha.boot.service.PessoaFotosService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.SexosService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@Autowired
	CidadesService cidadesService;
	
	@Autowired
	EscolaridadesService escolaridadesService;
	
	@Autowired
	EstadosCivisService estadosCivisService;
	
	@Autowired
	SexosService sexosService;
	
	@Autowired
	PessoaFotosService pessoaFotosService;

	@GetMapping("/cadastrar")
	public String cadastrar(Pessoa pessoa, PessoaFotos pessoaFotos, ModelMap model) {
		model.addAttribute("pessoa", pessoa);
		model.addAttribute("pessoaFotos", pessoaFotos);
		return "/pessoa/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoa", service.buscarTodos());
		return "/pessoa/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar( Pessoa pessoa, PessoaFotos pessoafotos,  RedirectAttributes attr) {
		service.salvar(pessoa);
		
		Long id = null;
		if(service.buscarPorCpf(pessoa.getCpf()).size()>0) {
			id = service.buscarPorCpf(pessoa.getCpf()).get(0).getId();
		}
		
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/documentos/cadastrar/"+id+"";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", service.buscarPorId(id));
		return "redirect:/documentos/cadastrar/"+id+"";
	}
	
	@GetMapping("retroceder/editar/{id}")
	public String preEditarRetroceder(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", service.buscarPorId(id));
		return "/pessoa/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Pessoa pessoa, RedirectAttributes attr) {
		service.editar(pessoa);
		Long id = pessoa.getId();
		//attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/documentos/cadastrar/"+id+"";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	@GetMapping("/buscar/nome/pessoa")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("pessoa", service.buscarPorNome(nome.toUpperCase().trim()));
		return "/pessoa/lista";
	}
	
	
	@ModelAttribute("idSexoFk")
	public List<Sexos> getSexos() {
		return sexosService.buscarTodos();
	}
	
	@ModelAttribute("idSexoDeclaradoFk")
	public List<Sexos> getSexosDeclarados() {
		return sexosService.buscarTodos();
	}
	
	@ModelAttribute("idCidadeNatalFk")
	public List<Cidades> getCidades() {
		return cidadesService.buscarTodos();
	}
	
	@ModelAttribute("idEscolaridadeFk")
	public List<Escolaridades> getEscolaridades() {
		return escolaridadesService.buscarTodos();
	}
	
	@ModelAttribute("idEstadoCivilFk")
	public List<EstadosCivis> getEstadosCivis() {
		return estadosCivisService.buscarTodos();
	}
	
}
