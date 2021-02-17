package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.PessoaDocumentosCtps;
import com.folha.boot.service.PessoaDocumentosCtpsService;

@Controller
@RequestMapping("/ctpsdocs")
public class PessoaDocumentosCtpsController {
	
	@Autowired
	private PessoaDocumentosCtpsService service;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaDocumentosCtps ctps) {		
		return "/docctps/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaDocumentosCtps", service.buscarTodos());
		System.out.println(service.buscarTodos().toString());
		return "/docctps/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaDocumentosCtps ctps, RedirectAttributes attr) {
		
		service.salvar(ctps);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/ctpsdocs/cadastrar";
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
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}

	@GetMapping("/buscar/numero/documento/ctps")
	public String getPorNome(@RequestParam("numero") String numero, ModelMap model) {		
		model.addAttribute("pessoaDocumentosCtps", service.buscarPorNumero(numero.toUpperCase().trim()));
		return "/docctps/lista";
	}
}
