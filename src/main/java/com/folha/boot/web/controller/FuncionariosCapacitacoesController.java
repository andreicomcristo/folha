package com.folha.boot.web.controller;

import java.util.Date;
import java.util.List;
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
import com.folha.boot.domain.AreasDeCapacitacao;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.FuncionariosCapacitacoes;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.TiposDeCapacitacao;
import com.folha.boot.service.AreasDeCapacitacaoService;
import com.folha.boot.service.FuncionariosCapacitacoesService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.TiposDeCapacitacaoService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/funcionarioscapacitacoes")
public class FuncionariosCapacitacoesController {

	
	
	
	Long idFuncionarioAtual = 34l;
	
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private FuncionariosCapacitacoesService service;
	@Autowired
	private AreasDeCapacitacaoService areasDeCapacitacaoService;
	@Autowired
	private PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private TiposDeCapacitacaoService tiposDeCapacitacaoService;
	@Autowired
	private UnidadesService unidadesService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(FuncionariosCapacitacoes funcionariosCapacitacoes) {
		return "/funcionariocapacitacao/cadastro";
	}
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionariosCapacitacoes", service.buscarTodos());
		return "/funcionariocapacitacao/lista"; 
	}
	*/
	@PostMapping("/salvar")
	public String salvar(FuncionariosCapacitacoes funcionariosCapacitacoes, RedirectAttributes attr) {
		funcionariosCapacitacoes.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		funcionariosCapacitacoes.setDtCadastro(new Date());
		funcionariosCapacitacoes.setIdFuncionarioFk(pessoaFuncionariosService.buscarPorId(idFuncionarioAtual));
		service.salvar(funcionariosCapacitacoes);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/funcionarioscapacitacoes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionariosCapacitacoes", service.buscarPorId(id));
		return "/funcionariocapacitacao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(FuncionariosCapacitacoes funcionariosCapacitacoes, RedirectAttributes attr) {
		service.editar(funcionariosCapacitacoes);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/funcionarioscapacitacoes/listar";
	}
	/*
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	*/
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		FuncionariosCapacitacoes funcionariosCapacitacoes = service.buscarPorId(id);
		funcionariosCapacitacoes.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		funcionariosCapacitacoes.setDtCadastro(new Date());
		funcionariosCapacitacoes.setDtCancelamento(new Date());
		funcionariosCapacitacoes.setIdOperadorCancelamentoFk(usuarioService.pegarOperadorLogado());
		service.salvar(funcionariosCapacitacoes);  
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/funcionarioscapacitacoes/listar";
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
			return "redirect:/funcionarioscapacitacoes/listar/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginated(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/funcionarioscapacitacoes/listar/{pageNo}" ;}
			}
	}
	
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<FuncionariosCapacitacoes> page = service.findPaginated( usuarioService.pegarUnidadeLogada(),pageNo, pageSeze);
		List<FuncionariosCapacitacoes> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}

	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<FuncionariosCapacitacoes> page = service.findPaginatedNome( usuarioService.pegarUnidadeLogada(), nome, pageNo, pageSeze);
		List<FuncionariosCapacitacoes> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	
	public String paginar(int pageNo, Page<FuncionariosCapacitacoes> page, List<FuncionariosCapacitacoes> lista, ModelMap model) {	
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("funcionariosCapacitacoes", lista);
		return "/funcionariocapacitacao/lista";	
	}

	
	
	
	
	
	@ModelAttribute("idAreaDeCapacitacaoFk")
	public List<AreasDeCapacitacao> getAreasDeCapacitacao() {
		return areasDeCapacitacaoService.buscarTodos();
	}
	
	@ModelAttribute("idFuncionarioFk")
	public List<PessoaFuncionarios> getPessoaFuncionarios() {
		return pessoaFuncionariosService.buscarTodos();
	}
	
	@ModelAttribute("idOperadorCadastroFk")
	public List<PessoaOperadores> getOperadorCadastro() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idOperadorCancelamentoFk")
	public List<PessoaOperadores> getPessoaOperadoresCancelamento() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idTiposCapacitacaoFk")
	public List<TiposDeCapacitacao> getTiposDeCapacitacao() {
		return tiposDeCapacitacaoService.buscarTodos();
	}
}
