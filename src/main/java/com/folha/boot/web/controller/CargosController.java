package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.Cargos;
import com.folha.boot.service.CargosService;
import com.folha.boot.util.UtilidadesDeTexto;

@Controller
@RequestMapping("/cargos")
public class CargosController {

	@Autowired
	private CargosService service;
	
	UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();

	@GetMapping("/cadastrar")
	public String cadastrar(Cargos Cargos) {
		
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", service.buscarTodos());
		return "/cargo/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Cargos cargos, RedirectAttributes attr) {
		
		cargos.setNomeCargo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cargos.getNomeCargo()));
		cargos.setDescricaoCargo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cargos.getDescricaoCargo()));
		
		service.salvar(cargos);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargos", service.buscarPorId(id));
		return "/cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Cargos cargos, RedirectAttributes attr) {
		
		cargos.setNomeCargo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cargos.getNomeCargo()));
		cargos.setDescricaoCargo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cargos.getDescricaoCargo()));
		
		service.editar(cargos);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/cargos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id); 
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}

}
