package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.PessoaDocumentosReservista;
import com.folha.boot.service.PessoaDocumentosReservistaService;

@Controller
@RequestMapping("/reservistadocs")
public class PessoaDocumentosReservistaController {
	
	@Autowired
	private PessoaDocumentosReservistaService service;

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaDocumentosReservista reservista) {		
		return "/docreservista/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaDocumentosReservista", service.buscarTodos());
		return "/docreservista/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaDocumentosReservista reservista, RedirectAttributes attr) {
		
		service.salvar(reservista);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/reservistadocs/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("niveisCargo", service.buscarPorId(id));
		return "/docreservista/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaDocumentosReservista reservista, RedirectAttributes attr) {
		service.editar(reservista);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/reservistadocs/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}

}
