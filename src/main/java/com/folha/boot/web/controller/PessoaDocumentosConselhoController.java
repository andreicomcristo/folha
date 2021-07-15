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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.PessoaDocumentosConselho;
import com.folha.boot.service.PessoaDocumentosConselhoService;

@Controller
@RequestMapping("/conselhodocs")
public class PessoaDocumentosConselhoController {

	@Autowired
	private PessoaDocumentosConselhoService service; 

	@GetMapping("/cadastrar")
	public String cadastrar(PessoaDocumentosConselho DocConselho) {
		
		return "docconselho/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoaDocumentosConselho", service.buscarTodos());
		return "docconselho/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaDocumentosConselho docConselho, RedirectAttributes attr) {
		
		service.salvar(docConselho);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/conselhodocs/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaDocumentosConselho", service.buscarPorId(id));
		return "docconselho/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaDocumentosConselho Conselho, RedirectAttributes attr) {
		service.editar(Conselho);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/conselhodocs/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/numero/documento/conselho")
	public String getPorNome(@RequestParam("numeroConselho") String numeroConselho, ModelMap model) {		
		model.addAttribute("pessoaDocumentosConselho", service.buscarPorNome(numeroConselho.toUpperCase().trim()));
		return "docconselho/lista";
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
