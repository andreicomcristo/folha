package com.folha.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.folha.boot.domain.CargosEspecialidade;
import com.folha.boot.service.CargosEspecialidadeService;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Controller
@RequestMapping("/especialidades")
public class CargosEspecialidadeController {
	
	@Autowired
	private CargosEspecialidadeService service;
	
	UtilidadesDeTexto utilidadesDeTexto = new UtilidadesDeTexto();

	@GetMapping("/cadastrar")
	public String cadastrar(CargosEspecialidade especialidade) {		
		return "/especialidade/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargosEspecialidade", service.buscarTodos());
		return "/especialidade/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(CargosEspecialidade especialidade, RedirectAttributes attr) {
		
		especialidade.setNomeEspecialidadeCargo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(especialidade.getNomeEspecialidadeCargo()));
		especialidade.setDescricaoEspecialidadeCargo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(especialidade.getDescricaoEspecialidadeCargo()));
		
		service.salvar(especialidade);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/especialidades/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargosEspecialidade", service.buscarPorId(id));
		return "/especialidade/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(CargosEspecialidade especialidade, RedirectAttributes attr) {
		
		especialidade.setNomeEspecialidadeCargo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(especialidade.getNomeEspecialidadeCargo()));
		especialidade.setDescricaoEspecialidadeCargo( utilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(especialidade.getDescricaoEspecialidadeCargo()));
		
		service.editar(especialidade);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/especialidades/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
}
