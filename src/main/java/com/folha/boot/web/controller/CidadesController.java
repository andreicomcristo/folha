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

import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Paises;
import com.folha.boot.domain.Uf;
import com.folha.boot.service.CidadesService;
import com.folha.boot.service.PaisesSevice;
import com.folha.boot.service.UfService;

@Controller
@RequestMapping("/cidades")
public class CidadesController {

	@Autowired
	PaisesSevice paisesSevice;
	
	@Autowired
	UfService ufService;
	
	@Autowired
	private CidadesService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Cidades cidade) {
		return "/cidade/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		// gambiarra para renderizar apenas 200 linhas
		List<Cidades> lista = service.buscarTodos();
		if (lista.size() > 300) {
			for (int i = lista.size() - 1; i > 200; i--) {
				lista.remove(i);
			}
			model.addAttribute("success",
					"Apenas os 200 primeiros registros exibidos. Use o filtro para refinar a sua busca.");
		}
		model.addAttribute("cidades", lista);
		return "/cidade/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cidades cidade, RedirectAttributes attr) {
		service.salvar(cidade);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/cidades/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cidades", service.buscarPorId(id));
		return "/cidade/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Cidades cidades, RedirectAttributes attr) {
		service.editar(cidades);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/cidades/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id); 
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/cidade")
	public String getPorNome(@RequestParam("nomeCidade") String nomeCidade, ModelMap model) {

		// gambiarra para renderizar apenas 200 linhas
		List<Cidades> lista = service.buscarPorNome(nomeCidade.toUpperCase().trim());
		if (lista.size() > 300) {
			for (int i = lista.size() - 1; i > 200; i--) {
				lista.remove(i);
			}
			model.addAttribute("success",
					"Apenas os 200 primeiros registros exibidos. Use o filtro para refinar a sua busca.");
		}
		model.addAttribute("cidades", lista);
		return "/cidade/lista";
	}
	
	@GetMapping("/buscar/id/uf")
	public String getPorIdUf(@RequestParam("idUfFk") Uf uf, ModelMap model) {

		List<Cidades> lista = service.buscarPorIdUf(uf);
		if (lista.size() > 300) {
			for (int i = lista.size() - 1; i > 200; i--) {
				lista.remove(i);
			}
			model.addAttribute("success",
					"Apenas os 200 primeiros registros exibidos. Use o filtro para refinar a sua busca.");
		}
		model.addAttribute("cidades", lista);
		return "/cidade/lista";
	}
	
	/*@GetMapping("/buscar/id/uf")
	public String getPorIdUf(@RequestParam("idUf") String idUf, ModelMap model) {		
		
		// gambiarra para renderizar apenas 200 linhas
		List<Cidades> lista = service.buscarPorIdUf(ufService.buscarPorId(Long.parseLong(idUf)));
		if(lista.size()>300){
			for(int i=lista.size()-1;i>200;i--) {
				lista.remove(i);
			}
			model.addAttribute("success", "Apenas os 200 primeiros registros exibidos. Use o filtro para refinar a sua busca.");
		}
		
		model.addAttribute("cidades", lista);
		model.addAttribute("uf", ufService.buscarTodos());
		
		return "/cidade/lista";
	}*/
		
	@ModelAttribute("idPaisFk")
	public List<Paises> listaPaises() {
		return paisesSevice.buscarTodos();
	}
	
	@ModelAttribute("idUfFk")
	public List<Uf> listaUfs() {
		return ufService.buscarTodos();
	}
}