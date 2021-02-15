package com.folha.boot.web.controller;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.Bancos;
import com.folha.boot.service.BancosService;
import com.folha.boot.util.UtilidadesDeTexto;

@Controller
@RequestMapping("/bancos")
public class BancosController {
	
	@Autowired
	private BancosService service;
	
	UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();

	@GetMapping("/cadastrar")
	public String cadastrar(Bancos banco) {
		return "/banco/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("bancos", service.buscarTodos());
		return "/banco/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Bancos banco, RedirectAttributes attr) {
		
		banco.setCodigoBanco( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(banco.getCodigoBanco()));
		banco.setNomeBanco( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(banco.getNomeBanco()));
		banco.setSiglaBanco( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(banco.getSiglaBanco()));
		
		service.salvar(banco);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/bancos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("bancos", service.buscarPorId(id));
		return "/banco/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Bancos banco, RedirectAttributes attr) {
		
		banco.setCodigoBanco( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(banco.getCodigoBanco()));
		banco.setNomeBanco( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(banco.getNomeBanco()));
		banco.setSiglaBanco( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(banco.getSiglaBanco()));
		
		service.editar(banco);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/bancos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nomebanco")
	public String getPorNome(@RequestParam("nomeBanco") String nomeBanco, ModelMap model) {		
		model.addAttribute("bancos", service.buscarPorNome(nomeBanco.toUpperCase().trim()));
		return "/banco/lista";
	}
	
}
