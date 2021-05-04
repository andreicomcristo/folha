package com.folha.boot.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.LocalidadeEscala;
import com.folha.boot.domain.RubricaComplementoConstitucionalCodigo;
import com.folha.boot.domain.RubricaGeralSomaCodigo;
import com.folha.boot.domain.RubricaGeralSomaPercentagemCodigo;
import com.folha.boot.domain.RubricaGeralSubtracaoPercentagemCodigo;
import com.folha.boot.domain.RubricaInsalubridadeCodigo;
import com.folha.boot.domain.RubricaNatureza;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AtividadeEscalaService;
import com.folha.boot.service.RubricaComplementoConstitucionalCodigoService;
import com.folha.boot.service.RubricaGeralSomaCodigoService;
import com.folha.boot.service.RubricaGeralSomaPercentagemCodigoService;
import com.folha.boot.service.RubricaGeralSubtracaoPercentagemCodigoService;
import com.folha.boot.service.RubricaInsalubridadeCodigoService;
import com.folha.boot.service.RubricaNaturezaService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/rubricaGeralSubtracaoPercentagemCodigo")
public class RubricaGeralSubtracaoPercentagemCodigoController {

	
	String ultimaBuscaNome = "";
	
	@Autowired
	private RubricaGeralSubtracaoPercentagemCodigoService service;
	@Autowired
	private RubricaNaturezaService rubricaNaturezaService;
	

	@GetMapping("/cadastrar")
	public String cadastrar(RubricaGeralSubtracaoPercentagemCodigo rubricaGeralSubtracaoPercentagemCodigo) {	
		
		return "/rubricaGeralSubtracaoPercentagemCodigo/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(RubricaGeralSubtracaoPercentagemCodigo rubricaGeralSubtracaoPercentagemCodigo, RedirectAttributes attr) {
		// Evitando salvar quem já está cadastrado
		if(rubricaGeralSubtracaoPercentagemCodigo!=null) {
			if(rubricaGeralSubtracaoPercentagemCodigo.getId()==null) {
				if(service.avaliarCadastrado(rubricaGeralSubtracaoPercentagemCodigo.getCodigo())==true) {
					return "redirect:/mensagens/mensagem/de/ja/cadastrado";	
				}
			}
		}
		
		service.salvar(rubricaGeralSubtracaoPercentagemCodigo);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/rubricaGeralSubtracaoPercentagemCodigo/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("rubricaGeralSubtracaoPercentagemCodigo", service.buscarPorId(id));
		return "/rubricaGeralSubtracaoPercentagemCodigo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(RubricaGeralSubtracaoPercentagemCodigo rubricaGeralSubtracaoPercentagemCodigo, RedirectAttributes attr) {
		service.editar(rubricaGeralSubtracaoPercentagemCodigo);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/rubricaGeralSubtracaoPercentagemCodigo/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimaBuscaNome = "";
		return this.findPaginated(1, model);
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		this.ultimaBuscaNome = nome;
		return this.findPaginated(1, nome, model);
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorNomePaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if(pageNo<1) {pageNo=1;}
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaNome.equals("")) ){
			return "redirect:/rubricaGeralSubtracaoPercentagemCodigo/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/rubricaGeralSubtracaoPercentagemCodigo/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<RubricaGeralSubtracaoPercentagemCodigo> page = service.findPaginated( pageNo, pageSeze);
		List<RubricaGeralSubtracaoPercentagemCodigo> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<RubricaGeralSubtracaoPercentagemCodigo> page = service.findPaginatedNome( nome, pageNo, pageSeze);
		List<RubricaGeralSubtracaoPercentagemCodigo> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	
	public String paginar(int pageNo, Page<RubricaGeralSubtracaoPercentagemCodigo> page, List<RubricaGeralSubtracaoPercentagemCodigo> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("rubricaGeralSubtracaoPercentagemCodigo", lista);
		return "/rubricaGeralSubtracaoPercentagemCodigo/lista";	
	}

	@ModelAttribute("idNaturezaFk")
	public List<RubricaNatureza> getIdNaturezaFk() {
		return rubricaNaturezaService.buscarTodos();
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
