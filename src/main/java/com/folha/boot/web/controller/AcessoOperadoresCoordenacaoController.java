package com.folha.boot.web.controller;

import java.util.ArrayList;
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
import com.folha.boot.domain.AcessoOperadoresCoordenacao;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AcessoOperadoresCoordenacaoService;
import com.folha.boot.service.CoordenacaoEscalaService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.seguranca.UsuarioService;

@Controller
@RequestMapping("/acessooperadorescoordenacao")
public class AcessoOperadoresCoordenacaoController {

	
	Long idOperadorAlterado =1l ;
	
	String ultimaBuscaNome = "";
	
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	HttpServletRequest request;
	@Autowired
	private AcessoOperadoresCoordenacaoService service;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private CoordenacaoEscalaService coordenacaoEscalaService;

	@GetMapping("/inicio/{id}")
	public String inicio(@PathVariable("id") Long id, ModelMap model) {
		idOperadorAlterado = id;
		return "redirect:/acessooperadorescoordenacao/cadastrar";
	}

	
	@GetMapping("/cadastrar")
	public String cadastrar(AcessoOperadoresCoordenacao acessoOperadoresCoordenacao, ModelMap model) {
		
		model.addAttribute("unidade", usuarioService.pegarUnidadeLogada());
		model.addAttribute("operador", pessoaOperadoresService.buscarPorId(idOperadorAlterado));
		model.addAttribute("acessoOperadoresCoordenacaoLista", service.buscarPorOperadorEUnidade(pessoaOperadoresService.buscarPorId(idOperadorAlterado), usuarioService.pegarUnidadeLogada()));
		return "/acessoOperadoresCoordenacaoEscala/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("acessoOperadoresCoordenacao", service.buscarTodos());
		return "/operadorecoordenacao/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(AcessoOperadoresCoordenacao acessoOperadoresCoordenacao, RedirectAttributes attr) {
		acessoOperadoresCoordenacao.setIdOperadorFk(pessoaOperadoresService.buscarPorId(idOperadorAlterado));
		
		service.salvar(acessoOperadoresCoordenacao);
		//attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/acessooperadorescoordenacao/cadastrar";
	}
	
	@GetMapping("/inserir/todos")
	public String inserirTodos() {
		
		List <AcessoOperadoresCoordenacao> lista = new ArrayList<>();
		List<CoordenacaoEscala> listaCoordenacoes = getidCoordenacaoFk();
		
		//Gerando objetos e salvando
		for(int i=0;i<listaCoordenacoes.size();i++) {
			AcessoOperadoresCoordenacao acessoOperadoresCoordenacao = new AcessoOperadoresCoordenacao();
			//Inserindo dados no objeto
			acessoOperadoresCoordenacao.setIdCoordenacaoFk(listaCoordenacoes.get(i));
			acessoOperadoresCoordenacao.setIdOperadorFk(pessoaOperadoresService.buscarPorId(idOperadorAlterado));
			acessoOperadoresCoordenacao.setId(null);
			//Salvando
			service.salvar(acessoOperadoresCoordenacao);
		}
		
		return "redirect:/acessooperadorescoordenacao/cadastrar"; 
	}
	
	@GetMapping("/tirar/todos")
	public String irarTodos() {
		List <AcessoOperadoresCoordenacao> lista = service.buscarPorOperadorEUnidade(pessoaOperadoresService.buscarPorId(idOperadorAlterado), usuarioService.pegarUnidadeLogada());
		//Apagando
		for(int i=0;i<lista.size();i++) {
			service.excluir(lista.get(i).getId());
		}
		return "redirect:/acessooperadorescoordenacao/cadastrar"; 
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		
		model.addAttribute("acessoOperadoresCoordenacao", service.buscarPorId(id));
		
		return "/operadorecoordenacao/cadastro";
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);  
		model.addAttribute("success", "Excluído com sucesso.");
		return "redirect:/acessooperadorescoordenacao/cadastrar";
	}

	
	
	// Listando - Todos (Sistema inteiro)
	@GetMapping("/listar/unidade")
	public String listarUnidade(ModelMap model) {
		this.ultimaBuscaNome = "";
		return this.findPaginatedUnidade(1, model);
	}
	
	@GetMapping("/listar/unidade/{pageNo}")
	public String findPaginatedUnidade(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 10;
		Page<PessoaOperadores> page = pessoaOperadoresService.findPaginated( pageNo, pageSeze);
		List<PessoaOperadores> lista = page.getContent();
		return paginarUnidade(pageNo, page, lista, model);
	}
	
	public String findPaginatedNomeUnidade(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 10;
		Page<PessoaOperadores> page = pessoaOperadoresService.findPaginatedNome(nome, pageNo, pageSeze);
		List<PessoaOperadores> lista = page.getContent();
		return paginarUnidade(pageNo, page, lista, model);
	}

	@GetMapping("/buscar/nome/unidade/paginado")
	public String getPorNomePaginadoUnidade(@RequestParam("nome") String nome, ModelMap model) {
		nome=nome.toUpperCase().trim();
		this.ultimaBuscaNome = nome;
		return this.findPaginatedNomeUnidade(1, nome, model);
	}
	
	@GetMapping("/paginar/unidade/{pageNo}")
	public String getPorBusacaPaginadoUnidade(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		
		if( (ultimaBuscaNome.equals("")) && (ultimaBuscaNome.equals("")) ){
			return "redirect:/acessooperadorescoordenacao/listar/unidade/{pageNo}" ;}
		else {		
			if(!ultimaBuscaNome.equals("")) {
				return this.findPaginatedNomeUnidade(pageNo, ultimaBuscaNome, model);}
			else {
				return "redirect:/acessooperadorescoordenacao/listar/unidade/{pageNo}" ;}
			}
	}
	
	public String paginarUnidade(int pageNo, Page<PessoaOperadores> page, List<PessoaOperadores> lista, ModelMap model) {	
		
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("pessoa", lista);
		return "/acessoOperadoresCoordenacaoEscala/listaTodosAcessosEscala";	
	}
	
	
	
	
	
	
	@ModelAttribute("idOperadorFk")
	public List<PessoaOperadores> getPessoaOperadores() {
		return pessoaOperadoresService.buscarTodos();
	}
	
	@ModelAttribute("idCoordenacaoFk")
	public List<CoordenacaoEscala> getidCoordenacaoFk() {
		List<CoordenacaoEscala> lista = coordenacaoEscalaService.buscarAcessoIndividualQueNaoTem(usuarioService.pegarUnidadeLogada(), pessoaOperadoresService.buscarPorId(idOperadorAlterado)); 
		return lista;
	}
	
	
	@ModelAttribute("nomeOperadorLogado")
	public String operadorLogado() {
		return request.getSession().getAttribute("operador").toString();
	}
	@ModelAttribute("nomeUnidadeLogada")
	public String unidadeLogada() {
		return request.getSession().getAttribute("unidade").toString();
	}
	
	
}
