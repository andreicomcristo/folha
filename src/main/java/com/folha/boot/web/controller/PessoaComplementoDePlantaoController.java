package com.folha.boot.web.controller;


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

import com.folha.boot.domain.AnoMes;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFuncionarios;
import com.folha.boot.domain.PessoaComplementoDePlantao;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.AnoMesService;
import com.folha.boot.service.PessoaFuncionariosService;
import com.folha.boot.service.PessoaComplementoDePlantaoService;
import com.folha.boot.service.PessoaOperadoresService;
import com.folha.boot.service.PessoaService;
import com.folha.boot.service.UnidadesService;
import com.folha.boot.service.seguranca.UsuarioService;


@Controller
@RequestMapping("/pessoaComplementoDePlantao")
public class PessoaComplementoDePlantaoController {

	
	Long idPessoaAtual = null;
	
	String ultimoAnoMes = "";
	String ultimaBuscaNome = "";
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PessoaComplementoDePlantaoService service;
	@Autowired
	private UnidadesService unidadesService;
	@Autowired
	private AnoMesService anoMesService;
	@Autowired
	private PessoaOperadoresService pessoaOperadoresService;
	@Autowired
	private	PessoaFuncionariosService pessoaFuncionariosService;
	@Autowired
	private PessoaService pessoaService;
	
	//Buscando Funcionario Inicial
		@GetMapping("/paginar/funcionarios/{pageNo}")
		public String getPorNomePaginadoInclusao(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
			
			if( (ultimaBuscaNome.equals("")) ){
				return "redirect:/pessoaComplementoDePlantao/listar/funcionarios/{pageNo}" ;}
			else {		
				if(!ultimaBuscaNome.equals("")) {
					return this.findPaginatedFuncionario(pageNo, ultimaBuscaNome, model);}
				else {
					return "redirect:/pessoaComplementoDePlantao/listar/funcionarios/{pageNo}" ;}
				}
		}
		
		@GetMapping("/listar/funcionarios")
		public String listarFuncionarios(ModelMap model) {
			ultimaBuscaNome = "";
			return this.findPaginatedFuncionario(1, model);
		}	
		
		@GetMapping("/listar/funcionarios/{pageNo}")
		public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
			int pageSeze = 50;
			Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginated(pageNo, pageSeze, usuarioService.pegarUnidadeLogada(), "ATIVO");
			List<PessoaFuncionarios> listaFuncionarios = page.getContent();
			return paginarFuncionario(pageNo, page, listaFuncionarios, model);
		}
		

		public String paginarFuncionario(int pageNo, Page<PessoaFuncionarios> page, List<PessoaFuncionarios> lista, ModelMap model) {	

			model.addAttribute("currentePage", pageNo);
			model.addAttribute("totalPages", page.getTotalPages());
			model.addAttribute("totalItems", page.getTotalElements()); 
			model.addAttribute("listaFuncionarios", lista);
			return "pessoaComplementoDePlantao/listafuncionario";	
		}
		
		@GetMapping("/buscar/funcionarios/nome")
		public String getPorNomeFuncionario(@RequestParam("nome") String nome, ModelMap model) {
			this.ultimaBuscaNome = nome;
			//this.ultimaBuscaTurma = null;	
			return this.findPaginatedFuncionario(1, nome, model);
		}
		
		public String findPaginatedFuncionario(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
			int pageSeze = 50;
			Page<PessoaFuncionarios> page = pessoaFuncionariosService.findPaginatedNome(pageNo, pageSeze, usuarioService.pegarUnidadeLogada(), "ATIVO", nome);
			List<PessoaFuncionarios> lista = page.getContent();
			//ultimaBuscaNome = "";
			//ultimaBuscaTurma = null;
			return paginarFuncionario(pageNo, page, lista, model);
		}
		
		@GetMapping("/atribuir/{id}")//Recebe o id do funcionário da tela de lista de funcionários
		public String cadastrar(@PathVariable("id") Long id, PessoaComplementoDePlantao pessoaComplementoDePlantao, ModelMap model) {
			idPessoaAtual = id;
			Pessoa pessoa = pessoaFuncionariosService.buscarPorId(id).getIdPessoaFk();
			pessoaComplementoDePlantao.setIdPessoaFk(pessoa);//relaciona as férias ao funcionário
			model.addAttribute("pessoaComplementoDePlantao", pessoaComplementoDePlantao);
			model.addAttribute("listaPessoaComplementoDePlantao", service.buscarPorUnidadeEPessoa(usuarioService.pegarUnidadeLogada(), pessoa));
			model.addAttribute("idAnoMes", service.buscarMesesCompativeis(usuarioService.pegarUnidadeLogada()));
			
			return "pessoaComplementoDePlantao/cadastro"; 
		}
		
		@GetMapping("/atribuir/pessoa/{id}")//Recebe o id do funcionário da tela de lista de funcionários
		public String cadastrarPessoa(@PathVariable("id") Long id, PessoaComplementoDePlantao pessoaComplementoDePlantao, ModelMap model) {
			idPessoaAtual = id;
			Pessoa pessoa = pessoaService.buscarPorId(id);
			pessoaComplementoDePlantao.setIdPessoaFk(pessoa);//relaciona as férias ao funcionário
			model.addAttribute("pessoaComplementoDePlantao", pessoaComplementoDePlantao);
			model.addAttribute("listaPessoaComplementoDePlantao", service.buscarPorUnidadeEPessoa(usuarioService.pegarUnidadeLogada(), pessoa));
			model.addAttribute("idAnoMes", service.buscarMesesCompativeis(usuarioService.pegarUnidadeLogada()));
			
			return "pessoaComplementoDePlantao/cadastro"; 
		}
		

	
	
	
	
	//Métodos normais
	
	@GetMapping("/cadastrar")
	public String cadastrar(PessoaComplementoDePlantao pessoaComplementoDePlantao, ModelMap model) {
		
		
		
		model.addAttribute("listaPessoaComplementoDePlantao", service.buscarPorUnidadeEPessoa(usuarioService.pegarUnidadeLogada(), pessoaService.buscarPorId(idPessoaAtual)));
		model.addAttribute("pessoaComplementoDePlantao", pessoaComplementoDePlantao);
		model.addAttribute("idAnoMes", service.buscarMesesCompativeis(usuarioService.pegarUnidadeLogada()));
		return "pessoaComplementoDePlantao/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		this.ultimoAnoMes = "";
		return this.findPaginated(1, model); 
	}
	
	@GetMapping("/listar/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		int pageSeze = 50;
		if(pageNo<1) {pageNo=1;}
		Page<PessoaComplementoDePlantao> page = service.findPaginated(pageNo, pageSeze, usuarioService.pegarUnidadeLogada());
		List<PessoaComplementoDePlantao> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, String nome, ModelMap model) {
		int pageSeze = 50;
		Page<PessoaComplementoDePlantao> page = service.findPaginatedAnoMes(pageNo, pageSeze, nome, usuarioService.pegarUnidadeLogada());
		List<PessoaComplementoDePlantao> lista = page.getContent();
		return paginar(pageNo, page, lista, model);
	}
	
	public String paginar(int pageNo, Page<PessoaComplementoDePlantao> page, List<PessoaComplementoDePlantao> lista, ModelMap model) {	
		model.addAttribute("idAnoMes", service.buscarMesesCompativeis(usuarioService.pegarUnidadeLogada()));
		model.addAttribute("currentePage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("listaPessoaComplementoDePlantao", lista);
		return "pessoaComplementoDePlantao/listaUnidade";	
	}
	
	@GetMapping("/paginar/{pageNo}")
	public String getPorCnesPaginado(@PathVariable (value = "pageNo") int pageNo, ModelMap model) {
		if(pageNo<1) {pageNo=1;}
		if( (ultimoAnoMes.equals("")) ){
			return "redirect:/pessoaComplementoDePlantao/listar/{pageNo}" ;}
		else {return this.findPaginated(pageNo, ultimoAnoMes, model);}
	}
	
	@GetMapping("/buscar/nome/anomes")
	public String getPorAnoMes(@RequestParam("anoMes") String anoMes, ModelMap model) {
		this.ultimoAnoMes = anoMes;
		return this.findPaginated(1, anoMes, model);
	}
	
	@PostMapping("/salvar")
	public String salvar(PessoaComplementoDePlantao pessoaComplementoDePlantao, RedirectAttributes attr) {
		pessoaComplementoDePlantao.setDtCadastro(new Date());
		pessoaComplementoDePlantao.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		pessoaComplementoDePlantao.setIdUnidadeFk(usuarioService.pegarUnidadeLogada());
		
		
		service.salvar(pessoaComplementoDePlantao);
		attr.addFlashAttribute("success", "Inserido com sucesso.");
		return "redirect:/pessoaComplementoDePlantao/atribuir/"+idPessoaAtual;
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoaComplementoDePlantao", service.buscarPorId(id));
		return "pessoaComplementoDePlantao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PessoaComplementoDePlantao pessoaComplementoDePlantao, RedirectAttributes attr) {	
		pessoaComplementoDePlantao.setDtCadastro(new Date());
		pessoaComplementoDePlantao.setIdOperadorCadastroFk(usuarioService.pegarOperadorLogado());
		pessoaComplementoDePlantao.setIdUnidadeFk(usuarioService.pegarUnidadeLogada());
		
		
		service.editar(pessoaComplementoDePlantao);
		attr.addFlashAttribute("success", "Editado com sucesso.");
		return "redirect:/pessoaComplementoDePlantao/atribuir/"+idPessoaAtual;
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") Long id, ModelMap model) {
		PessoaComplementoDePlantao pessoaComplementoDePlantao = service.buscarPorId(id);
		pessoaComplementoDePlantao.setIdOperadorCancelamentoFk(usuarioService.pegarOperadorLogado() );
		pessoaComplementoDePlantao.setDtCancelamento(new Date());
		service.salvar(pessoaComplementoDePlantao);  
		model.addAttribute("success", "Excluído com sucesso.");
		return listar(model);
	}
	
	
	@GetMapping("/herdar/de/mes") 
	public String herdarDeMes( Long anoMesInicial,  Long anoMesFinal,  ModelMap model) {		
		service.herdarDeUmMesParaOOutro(usuarioService.pegarUnidadeLogada(), usuarioService.pegarOperadorLogado() ,anoMesInicial, anoMesFinal);
		return "redirect:/pessoaComplementoDePlantao/listar" ;
	}
	
	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("idAnoMes", service.buscarMesesCompativeis(usuarioService.pegarUnidadeLogada()));
		model.addAttribute("pessoaComplementoDePlantao", service.buscarPorNome(nome.toUpperCase().trim(), usuarioService.pegarUnidadeLogada()));
		return "pessoaComplementoDePlantao/listaUnidade";
	}
	
	
	
	
	
	
	@ModelAttribute("idUnidadeFk")
	public List<Unidades> getIdUnidadeFk() {
		
		return unidadesService.buscarTodos();	
	}
	
	@ModelAttribute("idAnoMesFk")
	public List<AnoMes> getIdAnoMesFk() {
		return anoMesService.buscarTodos();	
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

