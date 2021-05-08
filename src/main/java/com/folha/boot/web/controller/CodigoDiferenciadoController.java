package com.folha.boot.web.controller;

import java.util.Date;
import java.util.List;

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
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.Fonte;
import com.folha.boot.domain.SimNao;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.CodigoDiferenciadoService;
import com.folha.boot.service.FonteService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.SimNaoService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/codigodiferenciados")
public class CodigoDiferenciadoController {

	
	
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private FonteService fonteService;
	@Autowired
	private UnidadesService unidadesservice;
	@Autowired
	private SimNaoService simNaoService;
	@Autowired
	private CodigoDiferenciadoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(CodigoDiferenciado codigoDiferenciado) {		
		return "/codigodiferenciado/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("codigoDiferenciado", service.buscarTodosGeral());
		return "/codigodiferenciado/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(CodigoDiferenciado codigoDiferenciado, RedirectAttributes attr) {
		codigoDiferenciado.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		codigoDiferenciado.setDtCadastro( new Date() );
		service.salvar(codigoDiferenciado);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/codigodiferenciados/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("codigoDiferenciado", service.buscarPorId(id));
		return "/codigodiferenciado/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(CodigoDiferenciado codigoDiferenciado, RedirectAttributes attr) {
		service.editar(codigoDiferenciado);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/codigodiferenciados/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		CodigoDiferenciado codigoDiferenciado = service.buscarPorId(id);
		codigoDiferenciado.setIdOperadorCancelamentoFk(usuarioService.pegarOperadorLogado());
		codigoDiferenciado.setDtCancelamento( new Date() );
		service.salvar(codigoDiferenciado);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome/codigodiferenciado")
	public String getPorNome(@RequestParam("nomeCodigoDiferenciado") String nomeCodigoDiferenciado, ModelMap model) {		
		model.addAttribute("codigoDiferenciado", service.buscarPorNomeGeral(nomeCodigoDiferenciado.toUpperCase().trim()));
		return "/codigodiferenciado/lista";
	}
	
	@ModelAttribute("idFonteFk")
	public List<Fonte> getIdFonteFk() {
		return fonteService.buscarTodos();
	}
	
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getUnidades() {
		return unidadesservice.buscarTodos();
	}
	
	@ModelAttribute("idNecessitaAtribuicaoRhFk")
	public List<SimNao> getIdNecessitaAtribuicaoRhFk() {
		return simNaoService.buscarTodos();
	}
	
	@ModelAttribute("idNecessitaAtribuicaoSedeFk")
	public List<SimNao> getIdNecessitaAtribuicaoSedeFk() {
		return simNaoService.buscarTodos();
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
