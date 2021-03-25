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
import com.folha.boot.domain.Cids;
import com.folha.boot.service.CidsService;

@Controller
@RequestMapping("/cids")
public class CidsController {

	@Autowired
	private CidsService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Cids cids) {		
		return "/cid/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cids", service.buscarTodos());
		return "/cid/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Cids cids, RedirectAttributes attr) {
		service.salvar(cids);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/cids/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cids", service.buscarPorId(id));
		return "/cid/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Cids cids, RedirectAttributes attr) {
		service.editar(cids);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/cids/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/codcid")
	public String getPorNome(@RequestParam("codCid") String codCid, ModelMap model) {		
		model.addAttribute("cids", service.buscarPorNome(codCid.toUpperCase().trim()));
		return "/cid/lista";
	}
	
}
